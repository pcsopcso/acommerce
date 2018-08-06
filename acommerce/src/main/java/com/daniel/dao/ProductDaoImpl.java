package com.daniel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.daniel.model.Product;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport  implements ProductDao  {

	@Override
	public int create(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into Product values(?, ?, ?, ?)";
		getJdbcTemplate().update(sql, product.getId(), product.getProductname(), product.getPrice(), product.getDescription());
		return 0;
	}

	@Override
	public int update(Product product) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product findById(Long id) throws Exception {
		String sql = "select * from Product where id = ?";
        RowMapper<Product> rowMapper = new RowMapper<Product>(){
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getLong("id"),
                        rs.getString("productname"),
                        rs.getLong("price"),
                        rs.getString("description"));
            }
        };
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Product> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from Product";
		return getJdbcTemplate().query(sql,
		        (rs, rowNum) -> new Product(rs.getLong("id"),
                        rs.getString("productname"),
                        rs.getLong("price"),
                        rs.getString("description")));
	}

	

/*
	@Override
	public User findById(String username) throws Exception {
		String sql = "select * from USERS where username = ?";
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
        return getJdbcTemplate().queryForObject(sql, rowMapper, username);
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
