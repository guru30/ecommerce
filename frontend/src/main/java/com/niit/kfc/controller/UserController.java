/*package com.niit.kfc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.SupplierDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;
import com.niit.project.model.Supplier;
import com.niit.project.model.User; 

@Controller
public class UserController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private User user;
	
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute(value="email")String email,
			@ModelAttribute(value="password")String password)
	{
		user = userDao.isvalidUser(email, password);
		ModelAndView mv = null;
		if( user == null){
			mv = new ModelAndView("login");
			mv.addObject("error message","invalid credentials");
		}else{
			if (user.getRole().equals("ROLE_ADMIN")){
				mv = new ModelAndView("adminHome");
				session.setAttribute("categoryList", categoryDao.list());
				session.setAttribute("supplierList", supplierDao.list());
				session.setAttribute("productList", productDao.list());
				
				session.setAttribute("category", category);
				session.setAttribute("product", product);
				session.setAttribute("supplier", supplier);
			}else if (user.getRole().equals("ROLE_USER")){
				mv = new ModelAndView("index");
				session.setAttribute("Name",user.getName());
				session.setAttribute("email", user.getEmail());
			}
		}
		return mv;
	
	}
	
	@RequestMapping(value="/loginError", method = RequestMethod.GET)
	public String loginError(Model model){
		model.addAttribute("errorMessage", "Login Error");
		return "index";	
	}
	
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model){
		model.addAttribute("errorMessage","you are not authorized to access this page");
		return "home";
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDao.list());
		
		mv.addObject("logoutmessage", "you successfully logged out");
		mv.addObject("loggedout","true");
		
		return mv;
	}
		
	
}*/



