package dynamic_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Connector {
	
	public Connection getConnection();
	public PreparedStatement getPreparedStatement();
	public  ResultSet getResultSet();
	
	String getDatabase() ;
	void setDatabase(String database);
	String getTable();
	void setTable(String table);
	
	abstract void connect() throws ClassNotFoundException, SQLException;
	abstract void close() throws SQLException;
	
	public static Connector getConnector(int connector_no) {
		Connector connector = null; 
		switch(connector_no) {
		case 1:
			connector= new Connector_1();
			break;
		}
		return connector;
	}
}
