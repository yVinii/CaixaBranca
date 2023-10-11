package login.documentacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Esta classe representa um usuário e fornece métodos para interagir com o banco de dados.
 */
public class DocumentUser {

    /**
     * Método para ese conectar com o banco de dados.
     * @return a conexão com o banco de dados ou null caso falhe.
     */
    public Connection conectarBD() {
        Connection conn = null;

        try {
            // Carrega o MySQL e conecta com o banco de dados.
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
        }

        return conn;
    }

    // Variáveis de nome do usuário e o resultado da verificação.
    public String nome = "";
    public boolean result = false;

    /**
     * Com base no login e senha fornecidos verifica o usuário no banco de dados.
     * @param login O nome de usuário.
     * @param senha A senha do usuário.
     * @return true se o usuário foi encontrado no banco de dados, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";

        // Conecta com o banco de dados.
        Connection conn = conectarBD();

        // Instrução SQL para consulta.
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "' ";
        sql += "and senha = '" + senha + "';";

        try {
            // Objeto Statement e executa a consulta SQL.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                // Caso o usuário foi encontrado no banco de dados.
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
        }

        return result;
    }
}