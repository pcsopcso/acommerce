package com.daniel.acommerce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.daniel.dao.ProductDaoImpl;
import com.daniel.model.Product;
 
@RunWith(SpringJUnit4ClassRunner.class)
//JUnit 테스트 클래스를 실행시킬 환경(클래스)
@WebAppConfiguration
//웹 애플리케이션의 환경 설정 정보(예: web.xml)를 사용함
@ContextConfiguration(
   locations = {"classpath:/applicationContext.xml"}
)
public class ProductDaoImplTest {
     
    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImplTest.class);
 
    @Autowired
    private ProductDaoImpl productDao;
     
    @Test
    public void findById() throws Exception {
        Product product = productDao.findById(Long.valueOf(1));
        logger.info("product findby: {}", product.toString());
    }
     
    @Test
    public void create() throws Exception{
    	Product product = new Product(Long.valueOf(11), "벤츠", Long.valueOf(100000000), "독일 자동차");
    	productDao.create(product);
    	Product actual = productDao.findById(product.getId());
        logger.info("product create: {}", actual.toString());
        //assertThat(actual, equalTo(user));
    }
}

