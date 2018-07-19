package com.daniel.acommerce;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.daniel.dao.UserDaoImpl;
import com.daniel.model.User;
 
@RunWith(SpringJUnit4ClassRunner.class)
//JUnit 테스트 클래스를 실행시킬 환경(클래스)
@WebAppConfiguration
//웹 애플리케이션의 환경 설정 정보(예: web.xml)를 사용함
@ContextConfiguration(
   locations = {"classpath:/applicationContext.xml"}
)
public class UserDaoImplTest {
     
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);
 
    @Autowired
    private UserDaoImpl userDao;
     
    @Test
    public void findById() throws Exception {
        User user = userDao.findById("pcso");
        logger.info("user: {}", user.toString());
    }
     
    @Test
    public void create() throws Exception{
        User user = new User("pcso1", "daniel", "pw1", "test@gmail.com");
        userDao.create(user);
        User actual = userDao.findById(user.getId());
        logger.info("user: {}", actual.toString());
        //assertThat(actual, equalTo(user));
    }
}

