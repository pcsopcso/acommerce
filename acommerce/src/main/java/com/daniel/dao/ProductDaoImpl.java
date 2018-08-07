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
}
