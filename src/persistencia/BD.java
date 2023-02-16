package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    static final String URL = "jdbc:mysql://localhost/contratacao_professores";
    static final String USER = "root";
    static final String PASSWORD = "admin";
   public static Connection conexao = null;

    public static void criaConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
    public static void fechaConexao() {
        try {

            conexao.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
}
