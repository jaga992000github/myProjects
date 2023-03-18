package dynamic_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class CRUD {
	
	private Connector connector;
	private Connection con;
	private PreparedStatement pst;
	private String database;
	private String table;
	
	public CRUD(int connector_no) {
		this.connector=Connector.getConnector(connector_no);
		this.con=connector.getConnection();
	}
	
	public void changeConnection(int connector_no) {
		try {
			connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this. connector=Connector.getConnector(connector_no);
		this.con=connector.getConnection();
	}
	
	
	private void useDatabase() {
		String query="use "+this.database+";";
		try {
			pst=con.prepareStatement(query);
			pst.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
		useDatabase();
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	
	public String getColumnNameByIndex(int index) throws SQLException, ClassNotFoundException {
		ResultSet rs;
		String col_nameQuery="select column_name " + 
				"from information_schema.columns " + 
				"where table_name = '"+table+"' and ordinal_position ="+index+";";
		pst=con.prepareStatement(col_nameQuery);
		rs=pst.executeQuery(col_nameQuery);
		rs.next();
		String col=rs.getString(1);
		return col;
	}
	public int getColumnCount() throws SQLException, ClassNotFoundException {
		ResultSet rs;
		String query="SELECT COUNT(*)"
				+ "FROM INFORMATION_SCHEMA.COLUMNS "
				+ "WHERE table_schema = '"+database+"' "
				+ "AND table_name = '"+table+"';";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	public int getRowCount() throws SQLException {
		
		ResultSet rs;
		String query="SELECT COUNT(*) FROM "+table+";";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	public int getLastId() throws SQLException, ClassNotFoundException {
		ResultSet rs;
		String col_1=getColumnNameByIndex(1);//first column
		int lastID;//last primary key
		String query="SELECT "+col_1+" from "+table+" ORDER BY "+col_1+" desc ;";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		lastID = rs.getInt(1);
		return lastID;
	}
	
	public  void create(HashMap<String,Object> values) throws SQLException, ClassNotFoundException  {
		String col_1=getColumnNameByIndex(1);//first column
		String insertquery="insert into "+table+"("+col_1+") value('0');";
		pst=con.prepareStatement(insertquery);
		pst.executeUpdate(insertquery);
		int no_of_columns=getColumnCount();
		int last_Id=getLastId();
		for(int i=2;i<=no_of_columns;i++) {
			String col=getColumnNameByIndex(i);//new colmn_name
			insertquery="update "+table+" set "+col+"='"+values.get(col)+"' where "+col_1+"="+last_Id+";";
			pst=con.prepareStatement(insertquery);
			pst.executeUpdate(insertquery);
		}
	}
	public void update(String new_value,String col,int id) throws ClassNotFoundException, SQLException {
		String col_1=getColumnNameByIndex(1);
		String query="update "+table+" set "+col+"='"+new_value+"' where "+col_1+"="+id+";";
		pst=con.prepareStatement(query);
		pst.executeUpdate(query);
	}
	public HashMap<String,Object> readRow(String id) throws ClassNotFoundException, SQLException {
		ResultSet rs;
		HashMap<String,Object> values=new HashMap<String,Object>();
		int col_count=getColumnCount();
		String col_1=getColumnNameByIndex(1);
		String query="select * from "+table+" where "+col_1+"="+id+";";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		for(int i=1;i<=col_count;i++) {
			String col=getColumnNameByIndex(i);
			String value=rs.getString(i);
			values.put(col, value);
		}
		return values;
	}
	public HashMap<String,HashMap<String,Object>> readTable() throws SQLException, ClassNotFoundException{
		ResultSet rs;
		HashMap<String,HashMap<String,Object>> table=new  HashMap<String,HashMap<String,Object>>();
		int total_col=getColumnCount();
		String query="select * from "+this.table+";";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		while(rs.next()){
			HashMap<String,Object> row=new HashMap<String,Object>();
			String row_id=rs.getString(1);
			for(int j=1;j<=total_col;j++) {
				String value= rs.getString(j);
				String col=getColumnNameByIndex(j);
				row.put(col, value);
			}
			table.put(row_id,row);
		}
			
		return table;
	}
	
	public void deleteRow(int id) throws SQLException, ClassNotFoundException {
		String col_1=getColumnNameByIndex(1);
		String query="DELETE FROM "+table+" WHERE "+col_1+"="+id+";";
		pst=con.prepareStatement(query);
		pst.executeUpdate(query);
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		CRUD crud =new CRUD(1);
		crud.setDatabase("demo");
		crud.setTable("test");
		HashMap<String,HashMap<String,Object>> table
		= new HashMap<String,HashMap<String,Object>>();
		table=crud.readTable();
		String prime_key ="8";
		System.out.println(table.get(prime_key));
	}
}



	