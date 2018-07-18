package com.daniel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
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
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("acommerce.sql"));
        DatabasePopulatorUtils.execute(populator, getDataSource());
    }

	
	@Override
	public int create(User user) throws Exception {
		String sql = "insert into USERS values(?, ?, ?, ?)";
        getJdbcTemplate().update(sql, user.getId(), user.getPassword(), user.getName(), user.getEmail());
 		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findById(String id) throws Exception {
		String sql = "select * from USERS where Id = ?";
        RowMapper<User> rowMapper = new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        };
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
