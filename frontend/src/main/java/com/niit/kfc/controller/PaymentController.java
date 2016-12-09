package com.niit.kfc.controller;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CreditCardDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.ShippingAddressDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Cart;
import com.niit.project.model.CreditCard;
import com.niit.project.model.ShippingAddress;
import com.niit.project.model.User;


@Controller
@SessionAttributes("email")

public class PaymentController {
	
	@Autowired(required = true)
	private ProductDao productDao;
	
	@Autowired(required = true)
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CreditCardDao creditCardDao;
	
	@Autowired 
	private CreditCard creditCard;
	
	@Autowired
	private ShippingAddressDao shippingAddressDao;
	
	
	@RequestMapping("/Proceed/{username}")
	public ModelAndView Proceed (@PathVariable("username") String username){
		
		ShippingAddress shippingAddress = shippingAddressDao.get(username);
		
		List<ShippingAddress> shippingAddresses = shippingAddressDao.list(shippingAddress.getId());
				
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("shippingAddresses", shippingAddresses);
		mv.addObject("isPlaceOrderClicked", true);
		
		
		
		return mv;		
	}
	
	@RequestMapping("/paymentMethod/{email}")
	public String paymentMethod(@PathVariable("email") String email){
		
		return "redirect:/cashOnDelivery/{email}";
		
	}
	
	@RequestMapping("/OnLinePayment/{email}")
	public ModelAndView OnLinePayment(@PathVariable("email") String email)
	{
		User user = userDao.get(email);		
		
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("onLinePaymentClicked", true);
		mv.addObject("User", user);
		return mv;
	}
	
	
	@RequestMapping("/cardPayment/{email}")
	private  String cardPayment(@ModelAttribute CreditCard creditCard, @PathVariable ("email") String email){
		
		creditCardDao.saveOrUpdate(creditCard);
		
		return "redirect:/cashOnDelivery/{email}";
	}
	
	
	@RequestMapping("/cashOnDelivery/{email}")
	public ModelAndView cashOnDelivery(@PathVariable("email") String email)
	{
		User user = userDao.get(email);
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("User", user);
		mv.addObject("cashOnDeliveryClicked", true);
		
		return mv;
	}
	@RequestMapping("/shiipingAddess/{email}")
	public ModelAndView shippingAdresss(@ModelAttribute ShippingAddress shippingAddress, @PathVariable ("email") String email){
		
		User user = userDao.get(email);
		//shippingAddress.setId(user.getEmail());
		shippingAddressDao.saveOrUpdate(shippingAddress);
		
		Random t = new Random(); 
		int day = t.nextInt(7);
		
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("ProductDelivered", true);
		mv.addObject("User", user);
		mv.addObject("day", day);
		return mv;
		
	}
	
	
	
	@ModelAttribute
	public void commonObject(Model model){	
		
		model.addAttribute("isLoggedInUser", true);
		String message = "You Have Successfully Logged In";
		model.addAttribute("msg", message);
	}
}



