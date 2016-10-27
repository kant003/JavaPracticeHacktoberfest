package sqlite;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQlite {

    /*
    TODO:
        Add to project SQLite driver ( https://github.com/LauraLaureus/Kata4/blob/master/lib/sqlite-jdbc-3.7.2.jar )
        Add your SQLite data base in the folder src of your project
        Configure your project to add the SQLite you download before
    */
    
    public static void main(String[] args) {
       Connection conection = createConnection("people.db");
       
       try {
            conection.createStatement().executeQuery("SELECT * FROM people");
        
        } catch (SQLException ex) {
            System.out.println("PRINT AN ERROR HERE");
        }
}

    
    private static Connection createConnection(String adbpath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + adbpath);
    }
}
