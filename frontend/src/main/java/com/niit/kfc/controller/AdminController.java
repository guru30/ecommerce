package com.niit.kfc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.SupplierDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;
import com.niit.project.model.Supplier;

@Controller
public class AdminController {
	
		
		@Autowired
		private Product product;
		
		@Autowired
		private Supplier supplier;
		
		@Autowired
		private Category category;
		
		@Autowired
		private SupplierDao supplierDao;
		
		@Autowired
		private CategoryDao categoryDao;
		
		@Autowired
		private ProductDao productDao;
		
		
		@RequestMapping("/manageCategories")
		public ModelAndView categories(){
			ModelAndView mv = new ModelAndView("/category");
			mv.addObject("category", category);
			mv.addObject("isAdminClickedCategories", "true");
			mv.addObject("categoryList", categoryDao.list());
			return mv;
			
		}
		
		@RequestMapping("/manageProducts")
		public ModelAndView suppliers(){
			ModelAndView mv = new ModelAndView("/Product");
			mv.addObject("product", product);
			mv.addObject("isAsminclickedProducts", "true");
			mv.addObject("productList", productDao.list());
			return mv;
		}
		
		@RequestMapping("/manageSuppliers")
		public ModelAndView products(){
			ModelAndView mv = new ModelAndView("/Supplier");
			mv.addObject("supplier", supplier);
			mv.addObject("isAdminClickedSuppliers", "true");
			mv.addObject("supplierList", supplierDao.list());
			return mv;
		}
		
		

	}


