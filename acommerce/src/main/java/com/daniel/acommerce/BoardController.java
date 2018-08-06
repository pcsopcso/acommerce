package com.daniel.acommerce;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daniel.dao.ProductDaoImpl;
import com.daniel.model.Product;
import com.daniel.service.ProductServiceImpl;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = "/board/list.do", method = RequestMethod.GET)
	public String loginFor(Locale locale, Model model) throws Exception {
		List<Product> list = productService.listProduct();
		
		//model.addAttribute("productList", list );
		
		//logger.info("Welcome board list");
		
		return "board/list";
	}
}
