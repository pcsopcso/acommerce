package com.daniel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import com.daniel.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport  implements UserDao  {

	@PostConstruct
    public void initialize(){
        try {
			ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
			populator.addScript(new ClassPathResource("acommerce.sql"));
			DatabasePopulatorUtils.execute(populator, getDataSource());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
	@Override
	public int create(User user) throws Exception {
		int result = 0;
		try {
			String sql = "insert into USERS values(?, ?, ?, ?, ?)";
			result = getJdbcTemplate().update(sql, user.getUsername(), user.getName(), user.getPassword(), user.getEmail(), user.getEnabled());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return result;
	}

	@Override
	public int update(User user) throws Exception {
		int result = 0;
		try {
			String sql = "update USERS set name=?, password=?, email=?, enabled=? WHERE username=?";
			result = getJdbcTemplate().update(sql, user.getName(), user.getPassword(), user.getEmail(), user.getEnabled(), user.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String username) throws Exception {
		int result = 0;
		try {
			String sql = "delete from USERS where id = ?";
			result = getJdbcTemplate().update(sql, username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User findById(String username) throws Exception {
		String sql = "select * from USERS where username = ?";
        try {
			RowMapper<User> rowMapper = new RowMapper<User>(){
			    @Override
			    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			        return new User(
			                rs.getString("username"),
			                rs.getString("password"),
			                rs.getString("name"),
			                rs.getString("email"),
			                rs.getInt("enabled"));
			    }
			};
			return getJdbcTemplate().queryForObject(sql, new Object[]{username}, rowMapper);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		String sql = "select * from USERS";
		try {
			return getJdbcTemplate().query(sql,
			        (rs, rowNum) -> new User(
			        		rs.getString("username"),
			                rs.getString("password"),
			                rs.getString("name"),
			                rs.getString("email"),
			                rs.getInt("enabled")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
