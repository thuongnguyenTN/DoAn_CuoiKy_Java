package util;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.*;

public class SQLConnect {
	public static Connection getSQL() {
	String server = "THUONGNGUYEN";
        String instance = "MSSQLSV";// Thay bằng tên máy chủ và instance của bạn
        String user = "sa"; // Tên người dùng SQL Server
        String password = "12345"; // Mật khẩu SQL Server
        String dbName = "Dictionary"; // Thay bằng tên cơ sở dữ liệu
        int port = 1433; // Cổng mặc định của SQL Server
        
        //Tao doi tuong SQLserverDataSource
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(dbName);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setTrustServerCertificate(true);
        
        
        try {
      
            java.sql.Connection conn = ds.getConnection();
            System.out.println("\n** Connect Successfully !!!");
            return conn;
        } catch (SQLException ex) {
            System.err.println("\\n**Connect Fail !!!");
            ex.printStackTrace();
            return null;
        }
	}
    
        
      
}
