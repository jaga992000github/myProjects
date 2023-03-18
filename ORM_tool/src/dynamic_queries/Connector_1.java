package dynamic_queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector_1 implements  Connector{
	private Connection con=connect();
	Connector_1() throws ClassNotFoundException, SQLException {
		
	}
	@Override
	public Connection getConnection() {
		return this.con;
	}
	

	@Override
	public Connection connect() throws ClassNotFoundException, SQLException  {
		String url="jdbc:mysql://127.0.0.1:3306";//+this.database;
		String user="root";
		String password="";
		//jdbc:mysql://127.0.0.1:3306/?user=root
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	@Override
	public void closeConnection() throws SQLException  {
		this.con.close();
		this.con=null;
	}
}


