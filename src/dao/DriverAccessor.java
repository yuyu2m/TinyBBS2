
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriverAccessor {

	private final static String DRIVER_URL="jdbc:mysql://localhost:3306/tinybbs?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
	private final static String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	private final static String USER_NAME="root";
	private final static String PASSWORD="mysqlroot";

	public Connection createConnection(){
		try{
			Class.forName(DRIVER_NAME);
			Connection con=DriverManager.getConnection(DRIVER_URL,USER_NAME,PASSWORD);
			return con;
			}catch(ClassNotFoundException e){
				System.out.println("Can't Find JDBC Driver.\n");
				}catch(SQLException e){
					e.printStackTrace();
					 System.out.println("Connection Error.\n");
				}
		return null;
	}

	public void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception ex){}
	}
}
