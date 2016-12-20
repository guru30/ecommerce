package com.niit.kfc.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.SupplierDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;
import com.niit.project.model.Supplier;
import com.niit.project.model.User;




@Controller
public class LoginAndHomeController {
	

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
	
	@Autowired
	private CartDao cartDao;
	

	
	/*@RequestMapping("/login")
	public ModelAndView login(Model mod,@ModelAttribute(value="email")String email,
			@ModelAttribute(value="password")String password)
	

	
	{	
		
		ModelAndView mv = new ModelAndView("login");
	
		
		
		user=null;
	
		user = userDao.isvalidUser(email, password);
		if( user == null){
			mod.addAttribute("login", "true");
			mv.addObject("errormessage","Pls Enter Valid Email & Password ");
		
			
			
		}else{
			if (user.getRole().equals("ROLE_ADMIN")){
			 mv = new ModelAndView("adminHome");
			 mod.addAttribute("Ifadminlogged","true");
			    session.setAttribute("username", user.getName());
				session.setAttribute("categoryList", categoryDao.list());
				session.setAttribute("supplierList", supplierDao.list());
				session.setAttribute("productList", productDao.list());
			
				session.setAttribute("category", category);
				session.setAttribute("product", product);
				session.setAttribute("supplier", supplier);
				
			}else if(user.getRole().equals("ROLE_USER")){
		 mv = new ModelAndView("listedItem");
		 mod.addAttribute("isLoggedInUser","true");
				session.setAttribute("email", user.getEmail());
				session.setAttribute("username", user.getName());
				session.setAttribute("productList", productDao.list());

			}
		}
		
	
		return mv;
	
}*/
	
	
	@RequestMapping("/logout1")
	
	public String logout(Model mod){
			
	mod.addAttribute("msg","successfully logged out");
			
	 mod.addAttribute("ch1","true");
	      
	 return "index";
	}
	
	
	
	@RequestMapping("/afterlogin")
	String loginProcess(Principal p,Model model)
		
	
	
	
	{
		
		
String email=p.getName();
		
		
		User user = userDao.get(email);
		model.addAttribute("email", email);
	
		long count = cartDao.getCount(email);
		model.addAttribute("numberOfProduct", count);
		
		
		user=userDao.get(email);
	
		if (user.getRole().equals("ROLE_ADMIN")){
			 model.addAttribute("Ifadminlogged",true);
			// mod.addAttribute("loginclicked","true");
			    session.setAttribute("Adminname", user.getName());
				session.setAttribute("categoryList", categoryDao.list());
				session.setAttribute("supplierList", supplierDao.list());
				session.setAttribute("productList", productDao.list());
				
				session.setAttribute("category", category);
				session.setAttribute("product", product);
				session.setAttribute("supplier", supplier);
				return"adminHome";
			}else if(user.getRole().equals("ROLE_USER")){
		     
		        model.addAttribute("isLoggedInUser", "true");	
		      //  session.setAttribute("cartList", cartDao.list(password));
		        session.setAttribute("productList", productDao.list());
				session.setAttribute("username",user.getName());
				session.setAttribute("email", user.getEmail());
                return "listedItem";
			}
		return "login";
		}
	@RequestMapping("/viewUsers")
	public String Listuser(Model model)
	{
		List<User> list = userDao.list();
		model.addAttribute("users", list);
		return "UserList";
	}
	@RequestMapping("/delete/{name}")
	public String Users(@ModelAttribute ("name") User name){
	
	userDao.delete(name);
	return "redirect:/viewUsers";
	}
		    
	@RequestMapping("cart/logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/login");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDao.list());
		
		mv.addObject("errormessage1", "successfully LoggedOut");
		mv.addObject("logout","true");
		
		return mv;
	}
	
}