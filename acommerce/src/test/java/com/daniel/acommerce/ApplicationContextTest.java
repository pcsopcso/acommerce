package com.daniel.acommerce;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
 
@RunWith(SpringJUnit4ClassRunner.class)
//JUnit 테스트 클래스를 실행시킬 환경(클래스)
@WebAppConfiguration
//웹 애플리케이션의 환경 설정 정보(예: web.xml)를 사용함
@ContextConfiguration(
     locations = {"classpath:/applicationContext.xml"}
)
public class ApplicationContextTest {
    @Autowired
    private DataSource dataSource;
 
    @Test
    public void dataSource() {
        assertNotNull(dataSource);
    }
	
}