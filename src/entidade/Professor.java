package entidade;

import entidade.ProfessorConvidado.Atividade;
import entidade.ProfessorSubstituto.DiaSemana;
import entidade.ProfessorSubstituto.Periodo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BD;

public class Professor {

    public enum AreaConcurso {
        Direito, Administração, Contabilidade,
        Economia, Engenharia, Computação, Medicina;
    }

    private int sequencial;
    private String cpf;
    private String nome;
    private String email;
    private AreaConcurso area_concurso;

    public Professor(int sequencial, String cpf, String nome, String email, AreaConcurso area_concurso) {
        this.sequencial = sequencial;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.area_concurso = area_concurso;

    }

    public Professor(int sequencial, String cpf) {
        this.sequencial = sequencial;
        this.cpf = cpf;
    }
    
    public String toStringFull() {
        return "[" + sequencial + "] " + " - " +nome; 
    }
    
    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM Professor";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return sequencial;
    }

    public static Professor[] getVisões() {
        String sql = "SELECT Sequencial, Cpf FROM Professor";
        ResultSet lista_resultados = null;
        ArrayList<Professor> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Professor(lista_resultados.getInt("Sequencial"), lista_resultados.getString("Cpf")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visões.toArray(new Professor[visões.size()]);
    }

    public static boolean existeProfessorMesmosAtributos(Professor professor) {
        String sql = "SELECT COUNT(Sequencial) FROM Professor WHERE Cpf = ? AND Nome = ? AND Email = ? AND AreaConcurso = ?";
        ResultSet lista_resultados = null;
        int n_professores_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, professor.getCpf());
            comando.setString(2, professor.getNome());
            comando.setString(3, professor.getEmail());
            comando.setInt(4, professor.getAreaConcurso().ordinal());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_professores_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_professores_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String inserirProfessor(Professor professor) {
        String sql = "INSERT INTO Professor(Cpf, Nome, Email, AreaConcurso)" + " Values(?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, professor.getCpf());
            comando.setString(2, professor.getNome());
            comando.setString(3, professor.getEmail());
            comando.setInt(4, professor.getAreaConcurso().ordinal());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Professor no BD";
        }

        int sequencial = últimoSequencial();

        if (professor instanceof ProfessorEfetivo) {
            ProfessorEfetivo professor_efetivo
                    = (ProfessorEfetivo) professor;

            sql = "INSERT INTO ProfessorEfetivo(Afastado, AnoAdmissao, ProfessorId) VALUES (?,?,?)";
                    
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setBoolean(1, professor_efetivo.isAfastado());
                comando.setString(2, professor_efetivo.getAnoAdmissao());
                comando.setInt(3, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Efetivo  no BD";
            }
        } else if (professor instanceof ProfessorSubstituto) {
            ProfessorSubstituto professor_substituto = (ProfessorSubstituto) professor;
            sql = "INSERT INTO ProfessorSubstituto(DiaSemana, Periodo, HorasAula, ProfessorId)VALUES(?,?,?,?)";
                    
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, professor_substituto.getDiaSemana().ordinal());
                comando.setInt(2, professor_substituto.getPeriodo().ordinal());
                comando.setInt(3, professor_substituto.getHorasAula());
                comando.setInt(4, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Substituto no BD";
            }
        } else if (professor instanceof ProfessorConvidado) {
            ProfessorConvidado professor_convidado = (ProfessorConvidado) professor;
            sql = "INSERT INTO ProfessorConvidado(Atividade, NomeProjeto, Bolsista, ProfessorId) VALUES(?,?,?,?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, professor_convidado.getAtividade().ordinal());
                comando.setString(2, professor_convidado.getNomeProjeto());
                comando.setBoolean(3, professor_convidado.isBolsista());
                comando.setInt(4, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Convidado no BD";
            }
        }

        return null;
    }

    public static String alterarProfessor(Professor professor) {
           String sql = "UPDATE Professor SET Cpf = ?, Nome = ?, Email = ? , AreaConcurso = ? WHERE Sequencial = ?";  
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, professor.getCpf());
            comando.setString(2, professor.getNome());
            comando.setString(3, professor.getEmail());
            comando.setInt(4, professor.getAreaConcurso().ordinal());
            comando.setInt(5, professor.getSequencial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração do Professor no BD";
        }

        if (professor instanceof ProfessorEfetivo) {
            ProfessorEfetivo professor_efetivo = (ProfessorEfetivo) professor;
            sql = "UPDATE ProfessorEfetivo SET Afastado = ?,AnoAdmissao = ? WHERE ProfessorId = ?";
                  
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setBoolean(1, professor_efetivo.isAfastado());
                comando.setString(2, professor_efetivo.getAnoAdmissao());
                comando.setInt(3, professor_efetivo.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Efetivo  no BD";
            }
        } else if (professor instanceof ProfessorSubstituto) {
            ProfessorSubstituto professor_substituto = (ProfessorSubstituto) professor;
            sql = "UPDATE ProfessorSubstituto SET DiaSemana = ?, Periodo = ?, HorasAula = ? WHERE ProfessorId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, professor_substituto.getDiaSemana().ordinal());
                comando.setInt(2, professor_substituto.getPeriodo().ordinal());
                comando.setInt(3, professor_substituto.getHorasAula());
                comando.setInt(4, professor_substituto.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Substituto no BD";
            }
        } else if (professor instanceof ProfessorConvidado) {
            ProfessorConvidado professor_convidado = (ProfessorConvidado) professor;
            sql = "UPDATE ProfessorConvidado SET Atividade = ?, NomeProjeto = ?, Bolsista = ? WHERE ProfessorId = ?";
                    
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, professor_convidado.getAtividade().ordinal());
                comando.setString(2, professor_convidado.getNomeProjeto());
                comando.setBoolean(3, professor_convidado.isBolsista());
                comando.setInt(4, professor_convidado.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Professor Convidado no BD";
            }
        }
        return null;
    }

    public static String removerProfessor(Professor professor) {
        int sequencial = professor.getSequencial();
        if (professor instanceof ProfessorEfetivo) {
            String sql = "DELETE FROM ProfessorEfetivo WHERE ProfessorId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Professor Efetivo no BD";
            }

        } else if (professor instanceof ProfessorSubstituto) {
            String sql = "DELETE FROM ProfessorSubstituto WHERE ProfessorId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Professor Substituto no BD";
            }
        } else if (professor instanceof ProfessorConvidado) {
            String sql = "DELETE FROM ProfessorConvidado WHERE ProfessorId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Professor Convidado no BD";
            }
        }
        String sql = "DELETE FROM Professor WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do Professor no BD";
        }
    }

    public static Professor buscarProfessor(int sequencial) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT Cpf, Nome, Email ,AreaConcurso FROM Professor WHERE Sequencial = ?";
        String cpf = null;
        String nome = null;
        String email = null;
        AreaConcurso area_concurso = null;

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                cpf = lista_resultados.getString("Cpf");
                nome = lista_resultados.getString("Nome");
                email = lista_resultados.getString("Email");
                area_concurso = AreaConcurso.values()[lista_resultados.getInt("AreaConcurso")];
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        if (cpf == null) {
            return null;
        }

        sql = "SELECT Afastado,AnoAdmissao"
                + " FROM ProfessorEfetivo WHERE Professorid =  ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new ProfessorEfetivo(sequencial, cpf, nome, email, area_concurso,
                        lista_resultados.getBoolean("Afastado"),
                        lista_resultados.getString("AnoAdmissao"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        sql = "SELECT DiaSemana, Periodo, HorasAula FROM ProfessorSubstituto WHERE ProfessorId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new ProfessorSubstituto(sequencial, cpf, nome, email, area_concurso,
                        DiaSemana.values()[lista_resultados.getInt("DiaSemana")],
                        Periodo.values()[lista_resultados.getInt("Periodo")],
                        lista_resultados.getInt("HorasAula"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        sql = "SELECT Atividade, NomeProjeto, Bolsista FROM ProfessorConvidado WHERE ProfessorId = ?";
           
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new ProfessorConvidado(sequencial, cpf, nome, email, area_concurso,
                        Atividade.values()[lista_resultados.getInt("Atividade")],
                        lista_resultados.getString("NomeProjeto"),
                        lista_resultados.getBoolean("Bolsista"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        return null;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AreaConcurso getAreaConcurso() {
        return area_concurso;
    }

    public void setAreaConcurso(AreaConcurso area_concurso) {
        this.area_concurso = area_concurso;
    }

       public Professor getVisao() {
        return new Professor(sequencial, cpf);
    }
    
    public String toString() {
        return "[" + getSequencial() + "]" + getCpf();

    }
}
