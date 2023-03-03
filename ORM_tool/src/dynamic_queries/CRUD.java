package dynamic_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class CRUD {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private String database;
	private String table;
	
	Connector connector=Connector.getConnector(1);
	
	public CRUD () {
		this.con=connector.getConnection();
		this.pst=connector.getPreparedStatement();
		this.rs=connector.getResultSet();
		connector.setDatabase("demo");
		this.database=connector.getDatabase();
		connector.setTable("test");
		this.table=connector.getTable();
	}
	
	
	
	public String getColumnNameByIndex(String table,int index) throws SQLException, ClassNotFoundException {
		connector.connect();
		String col_nameQuery="select column_name " + 
				"from information_schema.columns " + 
				"where table_name = '"+table+"' and ordinal_position = "+index+";";
		pst=con.prepareStatement(col_nameQuery);
		rs=pst.executeQuery(col_nameQuery);
		rs.next();
		return rs.getString(1);
	}
	public int getColumnCount(String table) throws SQLException, ClassNotFoundException {
		connector.connect();
		String query="SELECT COUNT(*)"
				+ "FROM INFORMATION_SCHEMA.COLUMNS "
				+ "WHERE table_schema = 'demo' "
				+ "AND table_name = '"+table+"';";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	public int getRowCount(String table) throws SQLException {
		String query="SELECT COUNT(*) FROM "+table+";";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	public int getLastId(String table) throws SQLException, ClassNotFoundException {
		String col_1=getColumnNameByIndex(table,1);//first column
		int lastID;//last primary key
		String query="SELECT "+col_1+" from "+table+" ORDER BY "+col_1+" desc ;";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery(query);
		rs.next();
		return lastID = rs.getInt(1);
	}
	
	public  void create(HashMap<String,Object> values,String table) throws SQLException, ClassNotFoundException  {
		connector.connect();
		String col_1=getColumnNameByIndex(table,1);//first column
		String insertquery="insert into "+table+"("+col_1+") value('0');";
		pst=con.prepareStatement(insertquery);
		pst.executeUpdate(insertquery);
		int no_of_columns=getColumnCount(table);
		int last_Id=getLastId(table);
		for(int i=2;i<=no_of_columns;i++) {
			String col=getColumnNameByIndex(table,i);//new colmn_name
			insertquery="update "+table+" set "+col+"='"+values.get(col)+"' where "+col_1+"="+last_Id+";";
			pst=con.prepareStatement(insertquery);
			pst.executeUpdate(insertquery);
		}
		connector.close();
	}
	public void update(String new_value,String Table,String col,int id) throws ClassNotFoundException, SQLException {
		connector.connect();
		String col_1=getColumnNameByIndex(Table,1);
		String query="update "+Table+" set "+col+"='"+new_value+"' where "+col_1+"="+id+";";
		st.executeUpdate(query);close();
	}
	public ArrayList readRow(String Table,int id) throws ClassNotFoundException, SQLException {
		connector.connect();
		ArrayList values=new ArrayList();
		int col_count=getColumnCount(Table);
		String col_1=getColumnNameByIndex(Table,1);
		String query="select * from "+Table+" where "+col_1+"="+id+";";
		rs=st.executeQuery(query);
		rs.next();
		for(int i=2;i<=col_count;i++) {
			String value=rs.getString(i);
			//System.out.println(getColumnNameByIndex(Table,i)+": "+value);
			values.add(value);
		}
		return values;
	}
	public void deleteRow(int id,String Table) throws SQLException, ClassNotFoundException {
		connector.connect();
		String col_1=getColumnNameByIndex(Table,1);
		String query="DELETE FROM "+Table+" WHERE "+col_1+"="+id+";";
		st.executeUpdate(query);close();
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		CRUD crud =new CRUD();
		//System.out.println(getColumnNameByIndex("test",3));
		System.out.println(crud.getColumnCount("test"));
		System.out.println(crud.getRowCount("test"));
//		HashMap<String,Object> values=new HashMap<String,Object>();
//		values.put("name", "mr a");
//		values.put("age", 22);
//		//values.put("work", "sde");
//		crud.insert(values,"test");
		crud.connector.close();
	}
}



	