package javaweb.app1.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



/**
 * 
 * Encapsulate basic CRUD's methods, for subclass inheriting Gaining database
 * connection from current DAO Whole DAO uses DBUtils solving pattern
 * 
 * @param <T>:
 *            the type/class of current DAO dealing with
 */
public class DAO {

	private QueryRunner queryRunner = new QueryRunner();


	/**
	 * 
	 * return corresponding T List
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> getForList(String sql, Class<T> clazz, Object... args) {
		List<T> list = null;
		
		Connection connection = null;
		try {
			connection = DBManager.getInstance().getConnection();
			list = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {

			throw new RuntimeException(e);
		
		} finally {
			DbUtils.closeQuietly(connection);
		}
		

		return list;
	}

	/**
	 * return a corresponding T class instance
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T get(String sql,Class<T> clazz, Object... args) {
		T result = null;
		
		Connection connection = null;

		try {
			connection = DBManager.getInstance().getConnection();
			result =  queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(connection);
		}
		return result;
	}

	
}
