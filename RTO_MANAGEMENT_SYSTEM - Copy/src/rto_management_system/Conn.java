
package rto_management_system;
 
import java.sql.DriverManager;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //1.register jar file
        //2.create connection
        //3.statement
        try{
            
        
        c=DriverManager.getConnection("jdbc:mysql:///rto","root","Sohail@25");
        s = c.createStatement();
    }
        catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
