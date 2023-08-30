
package rto_management_system;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CosLook {
    
    public ArrayList<ArrayList<String>> search(String table)
	{
                Connection connection = new Conn().c;
                ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		String sel = String.format("select * from %s ",table);
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(sel);
			if(res.next())
			{
				users = createTable(res);
				System.out.println(users);
				
			}
			else{
				System.out.println("USER NOT FOUND");
			}
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
    
    public ArrayList<ArrayList<String>> search(String table, String colname, String data)
	{
                Connection connection = new Conn().c;
                ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		String sel = String.format("select * from %s where %s = '%s'",table, colname,data);
		try {
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(sel);
			if(res.next())
			{
				users = createTable(res);
				System.out.println(users);
				
			}
			else{
				System.out.println("USER NOT FOUND");
			}
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	//inserts data into the  user table
	public void insert( String name, String addr, String number,String vehicleno, String type, String model, String chasis)
	{
                Connection connection = new Conn().c;
		String ins = "insert into Customer (name,addr, number,vehicleno, type,model,chasis) values(?,?,?,?,?,?,?);";
				
		try {
			PreparedStatement ps = connection.prepareStatement(ins);
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, number);
			ps.setString(4, vehicleno);
			ps.setString(5, type);
                        ps.setString(6, model);
                        ps.setString(7, chasis);
                        
			
			int rows  = ps.executeUpdate();
			if(rows>0)
			{
				System.out.print("Insert Successful");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(String table,String updcol, String upData, String colname, String data)
	{
                Connection connection = new Conn().c;
		String upd = String.format("update %s set %s  = '%s' where %s = '%s'",table,updcol, upData ,colname,data);
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(upd);
			int rows  = ps.executeUpdate();
			if(rows>0)
			{
				System.out.print("Update Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete( String table, String colname, String data)
	{
                Connection connection = new Conn().c;
		String del = String.format("delete from %s where %s = '%s'",table,colname,data);
		Statement s;
		try {
			s = connection.createStatement();
			int rows  = s.executeUpdate(del);
			if(rows>0)
			{
				System.out.print("Delete Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
	public void vehicleReg()
	{
		
	}
	
	//create a 2D array of data
	public ArrayList<ArrayList<String>> createTable(ResultSet res) throws SQLException
	{
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		do{
			String name = res.getString("name");
			String addr = res.getString("addr");
			String number = res.getString("number");
			String vehno = res.getString("vehicleno");
			String type = res.getString("type");
                        String model = res.getString("model");
                        String chassis = res.getString("chasis");
			ArrayList<String> s = new ArrayList<String>();
			s.add(name);
			s.add(addr);
			s.add(number);
			s.add(vehno);
			s.add(type);
                        s.add(model);
                        s.add(chassis);
			users.add(s);
		}
		while(res.next());
		
		return users;
	}
	
        public String[][] toarray(ArrayList<ArrayList<String>> s)
        {
            int size = s.size();
            String a[][] = new String[size][7];
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<7;j++)
                {
                    a[i][j] = s.get(i).get(j);
                }
            }
            return a;
        }
}
