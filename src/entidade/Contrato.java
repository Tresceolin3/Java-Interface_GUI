package entidade;

import entidade.ProfessorSubstituto.Periodo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import persistencia.BD;

public class Contrato {

    public enum ModeloContrato {
        tempo_determinado, tempo_indeterminado, temporario, estagio;
    }

    public enum Modalidade {
        PJ, CLT;
    }

    private int sequencial;
    private Faculdade faculdade;
    private Professor professor;
    private ModeloContrato modelo_contrato;
    private Modalidade modalidade;
    private Timestamp data_hora;

    public Contrato(int sequencial, Faculdade faculdade, Professor professor, ModeloContrato modelo_contrato,
            Modalidade modalidade, Timestamp data_hora) {
        this.sequencial = sequencial;
        this.faculdade = faculdade;
        this.professor = professor;
        this.modelo_contrato = modelo_contrato;
        this.modalidade = modalidade;
        this.data_hora = data_hora;
    }

    public Contrato(int sequencial, Faculdade faculdade, Professor professor) {
        this.sequencial = sequencial;
        this.faculdade = faculdade;
        this.professor = professor;
    }

    public Contrato(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ModeloContrato getModeloContrato() {
        return modelo_contrato;
    }

    public void setModeloContrato(ModeloContrato modelo_contrato) {
        this.modelo_contrato = modelo_contrato;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Timestamp getDataHora() {
        return data_hora;
    }

    public void setDataHora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public static Contrato[] getVisoes() {
        String sql = "SELECT Sequencial, FaculdadeId, ProfessorId From Contrato";
        ResultSet lista_resultados = null;
        ArrayList<Contrato> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Contrato(lista_resultados.getInt("Sequencial"),
                        Faculdade.buscarFaculdade(lista_resultados.getString("FaculdadeId")).getVisao(),
                        Professor.buscarProfessor(lista_resultados.getInt("ProfessorId")).getVisao()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return visoes.toArray(new Contrato[visoes.size()]);
    }

    public Contrato getVisao() {
        return new Contrato(sequencial,faculdade,professor);
    }

    public static boolean existeContratoInserir(String chave_faculdade, int chave_professor) {
        String sql = "SELECT Sequencial FROM Contrato WHERE FaculdadeId = ? AND ProfessorId = ?";
        ResultSet lista_resultados = null;
        boolean existe_contrato = false;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, chave_faculdade);
            comando.setInt(2, chave_professor);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe_contrato = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return existe_contrato;
    }

    public static boolean existeContrato(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM Contrato WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe_contrato = false;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe_contrato = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return existe_contrato;
    }

    public static int ultimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM Contrato";
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

    public static Faculdade[] getVisaoFaculadeSelecionada() {
        String sql = "SELECT Sigla,Titulo FROM Faculdade";
        ResultSet lista_resultados = null;
        ArrayList<Faculdade> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String sigla = lista_resultados.getString("Sigla");
                String titulo = lista_resultados.getString("Titulo");
                visões.add(new Faculdade(sigla, titulo));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visões.toArray(new Faculdade[visões.size()]);
    }

    public static Professor[] getVisaoProfessorSelecionada() {
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

    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mes_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mes_dia[2] + "/" + ano_mes_dia[1] + "/"
                + ano_mes_dia[0] + " " + hora_minuto_resto[0]
                + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }

    public static ArrayList<Contrato> pesquisarContratos(String chave_faculdade, int chave_professor, char modalidade_faculdade, Faculdade.Tipo tipo_faculdade,
            Professor.AreaConcurso area_concurso, char afastado_professor_efetivo, char bolsista_professor_convidado, Periodo periodo_professor_substituto,
            ModeloContrato modalidade_contrato, Modalidade modalidade, Timestamp data_minima) {
        String sql = "SELECT F.Sigla, F.modalidade, F.Tipo, P.Sequencial, P.AreaConcurso,"
                + " C.Sequencial, C.ModeloContrato, C.Modalidade, C.DataHora"
                + " FROM Faculdades F, Professor P, Contrato C"
                + " WHERE C.FaculdadeId = F.Sigla AND C.ProfessorId = P.Sequencial";
        if (chave_faculdade != null) {
            sql += " AND F.Sigla = ?";
        }
        if (chave_professor > -1) {
            sql += " AND P.Sequencial = ?";
        }
        if (modalidade_faculdade != 'X') {
            sql += " AND F.modalidade = ?";
        }
        if (tipo_faculdade != null) {
            sql += " AND F.Tipo = ?";
        }
        if (area_concurso != null) {
            sql += " AND P.AreaConcurso = ?";
        }
        if (modalidade_contrato != null) {
            sql += " AND C.ModeloContrato = ?";
        }
        if (modalidade != null) {
            sql += " AND C.Modalidade = ?";
        }
        if (data_minima != null) {
            sql += " AND C.DataHora >= ? ";
        }
        sql += " ORDER BY C.Sequencial";
        ResultSet lista_resultados = null;
        ArrayList<Contrato> contrato_selecionados = new ArrayList();
        int index = 0;
        int sequencial_professor = -1;

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            if (chave_faculdade != null) {
                comando.setString(++index, chave_faculdade);
            }
            if (chave_professor > -1) {
                comando.setInt(++index, chave_professor);
            }
            if (modalidade_faculdade != 'X') {
                comando.setString(++index, modalidade_faculdade + "");
            }
            if (tipo_faculdade != null) {
                comando.setInt(++index, tipo_faculdade.ordinal());
            }
            if (area_concurso != null) {
                comando.setInt(++index, area_concurso.ordinal());
            }
            if (modalidade_contrato != null) {
                comando.setInt(++index, modalidade_contrato.ordinal());
            }
            if (modalidade != null) {
                comando.setInt(++index, modalidade.ordinal());
            }
            if (data_minima != null) {
                comando.setTimestamp(++index, data_minima);
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                Contrato contrato_pesquisado = Contrato.buscarContrato(lista_resultados.getInt(6));
                sequencial_professor = lista_resultados.getInt(4);
                if (afastado_professor_efetivo != 'X') {
                    if (isOkPesquisaProfessorEfetivo(sequencial_professor, afastado_professor_efetivo)) {
                        contrato_selecionados.add(contrato_pesquisado);
                    }
                } else if (bolsista_professor_convidado != 'X') {
                    if (isOkPesquisaProfessorConvidado(sequencial_professor, bolsista_professor_convidado)) {
                        contrato_selecionados.add(contrato_pesquisado);
                    }
                } else if (periodo_professor_substituto != null) {
                    if (isOkPesquisaProfessorSubstituto(sequencial_professor, periodo_professor_substituto)) {
                        contrato_selecionados.add(contrato_pesquisado);
                    }
                } else {
                    contrato_selecionados.add(contrato_pesquisado);
                }
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return contrato_selecionados;
    }

    private static boolean isOkPesquisaProfessorEfetivo(int sequencial_professor, char afastado) {
        boolean pesquisa_ok = false;
        String sql = " SELECT * FROM ProfessorEfetivo WHERE ProfessorId = ? ";
        if (afastado != 'X') {
            sql += " AND Afastado = ? ";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_professor);
            switch (afastado) {
                case 'T':
                    comando.setBoolean(++index, true);
                    break;
                case 'F':
                    comando.setBoolean(++index, false);
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    private static boolean isOkPesquisaProfessorConvidado(int sequencial_professor, char bolsista) {
        boolean pesquisa_ok = false;
        String sql = " SELECT * FROM ProfessorConvidado WHERE ProfessorId = ? ";
        if (bolsista != 'X') {
            sql += " AND Bolsista = ? ";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_professor);
            switch (bolsista) {
                case 'T':
                    comando.setBoolean(++index, true);
                    break;
                case 'F':
                    comando.setBoolean(++index, false);
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    private static boolean isOkPesquisaProfessorSubstituto(int sequencial_professor, Periodo periodo_professor_substituto) {
        boolean pesquisa_ok = false;
        String sql = " SELECT * FROM ProfessorSubstituto WHERE ProfessorId = ? ";
        if (periodo_professor_substituto != null) {
            sql += " AND Periodo = ? ";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_professor);
            if (periodo_professor_substituto != null) {
                comando.setInt(++index, periodo_professor_substituto.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return pesquisa_ok;
    }

    public static Contrato buscarContrato(int sequencial) {
        String sql = " SELECT * FROM Contrato WHERE Sequencial = ? ";
        ResultSet lista_resultados = null;
        Contrato contrato = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                Modalidade modalidade = null;
                if (lista_resultados.getInt("Modalidade") > -1) {
                    modalidade = Modalidade.values()[lista_resultados.getInt("Modalidade")];
                }
                contrato = new Contrato(sequencial,
                        Faculdade.buscarFaculdade(lista_resultados.getString("FaculdadeId")),
                        Professor.buscarProfessor(lista_resultados.getInt("ProfessorId")),
                        ModeloContrato.values()[lista_resultados.getInt("ModeloContrato")], modalidade,
                        lista_resultados.getTimestamp("DataHora"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            contrato = null;
        }
        return contrato;
    }

    public static String inserirContrato(Contrato contrato) {
        String sql = "INSERT INTO Contrato(FaculdadeId, ProfessorId,  ModeloContrato, Modalidade, DataHora) "
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, contrato.getFaculdade().getSigla());
            comando.setInt(2, contrato.getProfessor().getSequencial());
            comando.setInt(3, contrato.getModeloContrato().ordinal());
            int indice_modalidade = -1;
            if (contrato.getModalidade() != null) {
                indice_modalidade = contrato.getModalidade().ordinal();
            }
            comando.setInt(4, indice_modalidade);
            comando.setTimestamp(5, contrato.getDataHora());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na inserção do contrato no BD";
        }
    }
    
    public static String alterarContrato(Contrato contrato) {
        String sql = "UPDATE Contrato SET FaculdadeId = ?, ProfessorId = ?, ModeloContrato = ?, Modalidade = ?, DataHora = ?"
                + "WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, contrato.getFaculdade().getSigla());
            comando.setInt(2, contrato.getProfessor().getSequencial());
            comando.setInt(3, contrato.getModeloContrato().ordinal());
            int indice_modalidade = -1;
            if (contrato.getModalidade() != null) {
                indice_modalidade = contrato.getModalidade().ordinal();
            }
            comando.setInt(4, indice_modalidade);
            comando.setTimestamp(5, contrato.getDataHora());
            comando.setInt(6, contrato.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração da avaliacao no BD";
        }
    }
    
     public static String removerContrato(int sequencial) {

        String sql = "DELETE FROM Contrato WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do Contrato no BD";
        }
        return null;
    }
    
     
     public String toString() {
        return "[" + sequencial + "] Faculdade: " + faculdade + " Professor: " + professor;
    }
     
     public String toStringFull() {
        String str = professor.toStringFull() + " --- " + faculdade.toStringFull() + "\n   ";
        if (modalidade != null) {
            switch (modalidade) {
                case PJ:
                    str += " Pessoa Juridica ";
                    break;
                case CLT:
                    str += " Carteira de Trabalho ";
            }
        }
        str += " --- Modelo Contrato[" + modelo_contrato + "] --- " + formatarDataHora(data_hora.toString());
        return str;
    }
     
}
