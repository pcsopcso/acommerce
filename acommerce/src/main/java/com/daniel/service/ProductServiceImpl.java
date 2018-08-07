package com.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daniel.dao.ProductDaoImpl;
import com.daniel.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoImpl productDao;

	// 01. 상품목록
    @Override
    public List<Product> listProduct() throws Exception {
        return productDao.findAll();
    }
    // 02. 상품상세
    @Override
    public Product detailProduct(Long id) throws Exception {
        return productDao.findById(id);
    }
    // 03. 상품수정
    @Override
    public void updateProduct(Product vo) {
        // TODO Auto-generated method stub

    }
    // 04. 상품삭제
    @Override
    public void deleteProduct(Long id) {
        // TODO Auto-generated method stub

    }

}
