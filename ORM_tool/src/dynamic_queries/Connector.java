package dynamic_queries;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
	abstract Connection getConnection();
	
	abstract Connection connect() throws ClassNotFoundException, SQLException;
	abstract void closeConnection() throws SQLException;
	
	public static Connector getConnector(int connector_no) {
		Connector connector = null; 
		switch(connector_no) {
		case 1:
			try {
				connector= new Connector_1();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		return connector;
	}
}
