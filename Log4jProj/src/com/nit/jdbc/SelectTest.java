package com.nit.jdbc;

/* Procedure to develop First App having log4j message */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SelectTest {

	private static Logger logger = Logger.getLogger(SelectTest.class);
	static{
		try {
			//create layout obj
			SimpleLayout layout = new SimpleLayout();

			//create Appender object having layout object
			ConsoleAppender appender = new ConsoleAppender(layout);

			//add appender to logger object
			logger.addAppender(appender);

			//logger level to retrieve log message
			//logger.setLevel(Level.DEBUG);  //default is DEBUG
			logger.setLevel(Level.DEBUG);
			//logger.setLevel(Level.OFF);
			//logger.setLevel(Level.ALL);
			logger.info("com.nit.jdbc.SelectTest:: Log4j setup is ready");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("SelectTest::Problem while setting up log4j");
		}
	}

	public static void main(String[] args) {
		logger.debug("SelectTest:: start of main(-) method");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//Load JDBC Driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.debug("SelectTest:: JDBC driver class loaded");

			//Establish the connection(road)
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			logger.debug("SelectTest:: Connection is established with DB s/w");

			//Create JDBC Statement obj
			if(con!=null) {
				st = con.createStatement();
				logger.debug("SelectTest:: JDBC statement object is created");
			}
			//Send and execute SQL Select Query in DB s/w and get JDBC ResultSet object
			if(st!=null) {
				rs = st.executeQuery("SELECT * FROM STUDENT");
				logger.debug("SelectTest:: SQL Query is send to DB s/w for execution and ResultSet object is generated");
			}
			//Process the ResultSet object
			if(rs!=null) {
				while(rs.next()!=false) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
					logger.warn("com.nit.jdbc.SelectTest:: The Records are ResultSet object are retrieved using getString(-) for all cols..change them accordingly");
				}//while
				logger.debug("com.nit.jdbc.SelectTest:: ResultSet Object is processed");
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			logger.error("com.nit.jdbc.SelectTest:: known DB Problem :: "+se.getMessage()+"SQL Error code "+se.getErrorCode());
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.fatal("com.nit.jdbc.SelectTest:: unknown Problem :: "+e.getMessage());
		}
		finally {
			logger.debug("com.nit.jdbc.SelectTest:: Closing JDBC objects");
			//close JDBC objects
			try {
				if(rs!=null) 
					rs.close();
				logger.debug("com.nit.jdbc.SelectTest:: ResultSet object is closed");
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				logger.debug("com.nit.jdbc.SelectTest:: Problem in closing ResultSet object"+se.getMessage());
			}
			try {
				if(st!=null) 
					st.close();
				logger.debug("com.nit.jdbc.SelectTest:: Statement object is closed");
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				logger.debug("com.nit.jdbc.SelectTest:: Problem in closing Statement object"+se.getMessage());
			}
			try {
				if(con!=null) 
					con.close();
				logger.debug("com.nit.jdbc.SelectTest:: Connection object is closed");
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				logger.debug("com.nit.jdbc.SelectTest:: Problem in closing Connection object"+se.getMessage());
			}
		}//finally
		logger.debug("com.nit.jdbc.SelectTest:: end of main(-) method");
	}//main
}//class