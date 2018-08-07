package com.daniel.acommerce;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daniel.model.Product;
import com.daniel.service.ProductServiceImpl;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private ProductServiceImpl productService;
	
	
	@RequestMapping(value = "/board/list.do")
	public String list(Locale locale, Model model) {
		try {
			List<Product> list = productService.listProduct();
			model.addAttribute("list", list );
			logger.info("Welcome board list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/list";
	}
}
