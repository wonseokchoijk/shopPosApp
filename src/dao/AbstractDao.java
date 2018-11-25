package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcDataSource;

import service.Properties;

public class AbstractDao {

	protected Connection con = null;

	public AbstractDao() throws SQLException {
		JdbcDataSource ds = new JdbcDataSource(); 
		ds.setURL(Properties.DbConnect);
		ds.setUser("sa"); 
		ds.setPassword("greentea"); 
		this.con = ds.getConnection();
	}
}
