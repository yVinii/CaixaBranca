package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class user {
    public Connection conectarBD(){ // 0
        
        Connection conn = null; // 1
        
        try{ // 2
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql//127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url); 
        
        }catch(Exception e){ } // 3 e 4
        
        return conn;} // 5
    
    // 6 {
    public String nome="";
    public boolean result = false;
    // } 6
    
    public boolean verificarUsuario(String login, String senha){ // 7 
        
        String sql=""; // 9 {
        Connection conn = conectarBD();
        //Instrução SQL
        sql += "select nome from usuários";
        sql += "where login  = " + "'" +login+"'";
        sql += "and senha  = " + "'" +senha+"';";
        // } 9
        
        try{ // 10
            Statement st= conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){ // 15
                result=true; // 16
                nome = rs.getString("nome"); // 17
            }}catch(Exception e){} // 11 e 12
        return result; // 13 14
        }
    
    }//fim da class