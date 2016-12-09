package com.niit.kfc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Cart;
import com.niit.project.model.Product;
import com.niit.project.model.User;




@Controller
@SessionAttributes("email")
public class CartController {
	@Autowired(required = true)
	private ProductDao productDao;
	
	@Autowired(required = true)
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="cart/{id}",method=RequestMethod.GET)
	public String viewProductDetails(@PathVariable("id") String Id,Model mod) {
		String email=(String)session.getAttribute("email");
		mod.addAttribute("numberOfProduct", cartDao.getCount(Id));
		
		if(email != null){
			mod.addAttribute("isLoggedInUser", true);
			mod.addAttribute("isProductClicked", true);
			Product product = productDao.get(Id);
			mod.addAttribute("product", product);
			return "success";
		}
	  return "redirect:/Loginpage";
	 }
	  

	@RequestMapping("/addToCart/{email}/{product_Id}")
	public String addCart(@PathVariable("email") String email, @PathVariable("product_Id") String product_Id ,Model model){
		model.addAttribute("numberOfProduct", cartDao.getCount(email));
		Product product = productDao.get(product_Id);
		User user = userDao.get(email);
	
		
			 
			if(product.getProduct_Stock() > 1){
				
				Cart cart = new Cart();
					cart.setProductName(product.getProduct_Name());
		
				
				
			cart.setPrice(product.getProduct_Price());
			cart.setQuantity(1);
			cart.setStatus("N");
			cart.setUserName(user.getName());
			cart.setUserId(user.getEmail());

			int stock = product.getProduct_Stock() - 1;
			product.setProduct_Stock(stock);
			
			cartDao.saveOrUpdate(cart);
			productDao.saveOrUpdate(product);
			}
			return "redirect:/myCart";
	
	}
	@RequestMapping(value="/myCart",method = RequestMethod.GET)
	public String viewCart(Model model,HttpSession session)
	{
		
		model.addAttribute("cart", new Cart());
		String email=(String)session.getAttribute("email");
		model.addAttribute("numberOfProduct", cartDao.getCount(email));
			model.addAttribute("cartList",cartDao.list(email));
			model.addAttribute("total",cartDao.getTotalAmount(email));
			model.addAttribute("isAddToCartClicked", "true");
			model.addAttribute("isMyCartClicked", "true");
		return "success";
	}
	@RequestMapping("/deletecart/{id}")
	public String deleteCart(@PathVariable ("id") String id, Model model,HttpSession session){
		//String emailid=(String)session.getAttribute("email");

		cartDao.delete(id);
		model.addAttribute("isMyCartClicked", true);
		model.addAttribute("cartList",cartDao.list(id));
		model.addAttribute("total",cartDao.getTotalAmount(id));
		model.addAttribute("isLoggedInUser", true);
		//String message = "You Have Successfully Logged In";
		//model.addAttribute("msg", message);
		
		return "redirect:/myCart";

	} 
	
	/*@ModelAttribute
	public void commonObject(Model model){	
		
		model.addAttribute("isLoggedInUser", true);
		String message = "You Have Successfully Logged In";
		model.addAttribute("msg", message);
	}*/
	
	
}

	

