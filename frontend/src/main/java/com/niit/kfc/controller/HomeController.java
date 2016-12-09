package com.niit.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;
import com.niit.project.model.User;






@Controller
public class HomeController {
	
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@SuppressWarnings("unused")
	@Autowired
	private Category category;
	@SuppressWarnings("unused")
	@Autowired
	private Product product;
	

@RequestMapping(value="/")
public ModelAndView showindex(Model mod)
{
	mod.addAttribute("ch","true");
	ModelAndView mv=new ModelAndView("/index");
	List<Category> CategoryList = categoryDao.list();
	List<Product> List = productDao.list(); 
	mv.addObject("productList",List);
	mv.addObject("categoryList",CategoryList);
	return mv;

		
}

 
@RequestMapping(value="/managepage")
public ModelAndView showadminmanage(Model mod){
ModelAndView mv=new ModelAndView("admin");
return mv;

}
@RequestMapping(value="/index")
public String showHome(Model mod)
{
	mod.addAttribute("ch","true");
	return "index";
}
@RequestMapping(value="/aboutus")
public String showAboutus(Model mod)
{
	mod.addAttribute("ch","true");
	return "aboutus";
}
@RequestMapping(value="/contactus")
public String showContactus(Model mod)
{
	mod.addAttribute("ch","true");
	return "contactus";
}
	
		@RequestMapping("/registeruser")
    public String registerUser(Model model) {

    	User user = new User();
       
        model.addAttribute("user", user);

        return "registeruser";

    }
		@RequestMapping("/register")
		public ModelAndView registerUser(@ModelAttribute User user, @RequestParam(value = "email") String email, ModelMap mod) {
			ModelAndView mv ;
		
		
			
			if(userDao.isAllReadyRegister(email, true))		{
				
				mod.addAttribute("isAllReadyRegister", "true");	
			
				mod.addAttribute("userexists","Your Email Id All Ready Registered");
				
					}
			else {
				user.setRole("ROLE_USER");
				user.setEnabled(true);
				userDao.saveorupdate(user);
				mod.addAttribute("isSignupClicked", "true");

				mod.addAttribute("success","You r Registered");
				
			}
			mv = new ModelAndView("registeruser");
			
			return mv;
			}
			
	/*		
    /*
     * registerUserPost method is used to register user into  the system and to show registration related errors
     *//*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@ModelAttribute("user") User user, BindingResult result,
                                       Model model) {
    	System.out.println("jithu");
        if (result.hasErrors()) {
            return "registeruser";
        }

            user.setRole("ROLE_USER");
        //usersDetail.setEnabled(true);
        //usersDetailService.addUser(usersDetail);
userDao.saveorupdate(user);
        return "success";

    }*/
    
   
    @RequestMapping("/Loginpage")

    public String Login(Model mod)
    {
    	mod.addAttribute("ch","true");
    return "login";

    }
    
    @RequestMapping("/cart/Loginpage")

    public String Login1()
    {
    	
    return "login";

    }
    
    @RequestMapping("/logincheck")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
        	
        	model.addAttribute("login", "true");
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
        	model.addAttribute("logout","true");
            model.addAttribute("errormessage1", "You have been logged out successfully.");
        }

        return "login";
    }
    
    @RequestMapping("/viewproduct/{name}")
	public ModelAndView viewCategoryItems(@PathVariable ("name") String name){
		List<Category> CategoryList = categoryDao.list();
		List<Product> productList = productDao.list();
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("productList", productList);
		mv.addObject("categoryList",CategoryList);
		return mv;
    }
    
    
    
}