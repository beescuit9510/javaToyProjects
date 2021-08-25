package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	static private String DRIVER = null;
	static private String URL = null;
	static private String USER = null;
	static private String PW = null;

	static {
		
		try (FileReader fr = new FileReader("resources/driver.properties");) {
			Properties prop = new Properties();
			prop.load(fr);

			DRIVER = prop.getProperty("driver");
			URL = prop.getProperty("url");
			USER = prop.getProperty("user");
			PW = prop.getProperty("pw");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PW);
			conn.setAutoCommit(false);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {

		try {
			if ( conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet result) {

		try {
			if ( result != null && !result.isClosed()) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement state) {

		try {
			if ( state != null && !state.isClosed()) {
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
