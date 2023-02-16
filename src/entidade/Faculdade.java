package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BD;

public class Faculdade {

    public enum Tipo {
        Exatas, Humanas, Engenharias, Medicinas;
    }

    
    private String titulo;
    private String sigla;
    private char modalidade;
    private Tipo tipo;

    public Faculdade(String sigla,String titulo, char modalidade, Tipo tipo) {
        this.sigla = sigla;
        this.titulo = titulo;
        this.modalidade = modalidade;
        this.tipo = tipo;
    }

    public Faculdade(String sigla, String titulo) {
         this.sigla = sigla;
        this.titulo = titulo;
    }
    
     public String toStringFull() {
        return "  [" + sigla + "] " + " - " +titulo; 
    }
    
    public Faculdade getVisao() {
        return new Faculdade(getSigla(), getTitulo());
    }

    public static Faculdade buscarFaculdade(String sigla) {
        String sql = "SELECT * FROM faculdades WHERE Sigla = ?";
        ResultSet lista_resultados = null;
        Faculdade faculdade = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, sigla);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                faculdade = new Faculdade(sigla, lista_resultados.getString("Titulo"),
                        lista_resultados.getString("Modalidade").toCharArray()[0],
                        Tipo.values()[lista_resultados.getInt("Tipo")]);
                       

            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            faculdade = null;
        }
        return faculdade;
    }

    public static String inserirFaculdade(Faculdade faculdade) {
        String sql = "INSERT INTO faculdades(Sigla, Titulo, Modalidade, Tipo)"
                + " Values(?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, faculdade.getSigla());
            comando.setString(2, faculdade.getTitulo());
            comando.setString(3, (faculdade.getModalidade() + ""));
            comando.setInt(4, faculdade.getTipo().ordinal());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção da Faculdade no BD";
        }
    }

    public static String alterarFaculdade(Faculdade faculdade) {
        String sql = "UPDATE faculdades SET Titulo = ?, Modalidade = ?, Tipo = ? WHERE Sigla = ?";
                
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, faculdade.getTitulo());
            comando.setString(2, (faculdade.getModalidade() + ""));
            comando.setInt(3, faculdade.getTipo().ordinal());
            comando.setString(4, faculdade.getSigla());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração da Faculdade no BD";
        }
    }

    public static String removerFaculdade(String faculdade) {
        String sql = "DELETE FROM faculdades WHERE Sigla = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, faculdade);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoçaõ do Faculdade no BD";
        }
    }

    public static Faculdade[] getVisões() {
        String sql = "SELECT Sigla,Titulo FROM faculdades";
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public char getModalidade() {
        return modalidade;
    }

    public void setModalidade(char modalidade) {
        this.modalidade = modalidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
    return "[" + sigla + "] " + titulo;
    
    }

}
