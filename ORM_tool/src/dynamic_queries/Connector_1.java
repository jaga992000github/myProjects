package dynamic_queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector_1 implements  Connector{
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private String database;
	private String table;
	
	
    public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Connection getCon() {
		return con;
	}

	public PreparedStatement getPst() {
		return pst;
	}

	public ResultSet getRs() {
		return rs;
	}
	
	
	public void connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://127.0.0.1:3306/"+this.database;
		String user="root";
		String password="";
		//jdbc:mysql://127.0.0.1:3306/?user=root
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,password);
		
	}
	
	public void close() throws SQLException  {
		pst.close();
		con.close();
		rs.close();
		//pst=null;
		//con=null;
		//rs=null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getPreparedStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getResultSet() {
		// TODO Auto-generated method stub
		return null;
	}

}


