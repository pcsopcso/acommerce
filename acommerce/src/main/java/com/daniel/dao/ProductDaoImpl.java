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
		int result = 0;
		try {
			String sql = "insert into Product values(?, ?, ?, ?)";
			result = getJdbcTemplate().update(sql, product.getId(), product.getProductname(), product.getPrice(), product.getDescription());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Product product) throws Exception {
		int result = 0;
		try {
			String sql = "update Product set productname=?, price=?, description=? WHERE id=?";
			result = getJdbcTemplate().update(sql, product.getProductname(), product.getPrice(), product.getDescription(), product.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Long id) throws Exception {
		int result = 0;
		try {
			String sql = "delete from Product where id = ?";
			result = getJdbcTemplate().update(sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product findById(Long id) throws Exception {
		String sql = "select * from Product where id = ?";
        try {
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
			return getJdbcTemplate().queryForObject(sql, new Object[]{id}, rowMapper);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public List<Product> findAll() throws Exception {
		String sql = "select * from Product";
		try {
			return getJdbcTemplate().query(sql,
			        (rs, rowNum) -> new Product(rs.getLong("id"),
			                rs.getString("productname"),
			                rs.getLong("price"),
			                rs.getString("description")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
