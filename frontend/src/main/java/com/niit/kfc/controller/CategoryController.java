package com.niit.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;


@Controller
@RequestMapping("/")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Product product;
	
	
	@RequestMapping("/addcategory")
	public ModelAndView addCategory() {
		ModelAndView mv = new ModelAndView("/newCategory");
		
	  return mv;
	 }
	
	@RequestMapping("/newCategory")
	public ModelAndView newCategory(@ModelAttribute Category category) {
		categoryDao.saveOrUpdate(category);
		ModelAndView mv = new ModelAndView("adminHome");
	
		return mv;
	 }
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {

		Util util = new Util();
		String id=  util.replace(category.getId(), ",", "");
		category.setName(id);
		
		categoryDao.saveOrUpdate(category);

		//return "redirect:/category";
		return "category";
	}
	
	/*@RequestMapping("/orderedBy")
	public ModelAndView orderedBy(@RequestParam(value="search") String search ) {
		
		categoryDAO.search(search);
		
		List<Category> categoryList = categoryDAO.list();
		
		ModelAndView mv = new ModelAndView("viewCategory");
		
		mv.addObject("categoryList", categoryList);
		
		return mv;
		
	}*/
	
	
	
	
	@RequestMapping("/viewCategories")
	public ModelAndView viewCategories() {

		List<Category> categoryList = categoryDao.list();
		
		ModelAndView mv = new ModelAndView("viewCategory");
	
		mv.addObject("categoryList", categoryList);
		mv.addObject("isViewCategoriesClicked", true);

		return mv;
	}
	
	@RequestMapping("/editcategory/{id}")
	public ModelAndView editCategory(@PathVariable ("id") String id){
		Category category = categoryDao.get(id);
		//categoryDAO.saveOrUpdate(category);
		
		ModelAndView mv = new ModelAndView("/editCategory");
		mv.addObject("category", category);
		/*mv.addObject("ID", category.getId());
		mv.addObject("Name", category.getName());
		mv.addObject("Description", category.getDescription());*/
		return mv;
	}
	
	@RequestMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable ("id") String id,ModelMap model){
		
		 categoryDao.delete(id);
		return "redirect:/viewCategories";

	}

	
	@RequestMapping("/editCategory")
	public ModelAndView editAndSave(@ModelAttribute Category category)
	//public ModelAndView editAndSave(@PathVariable("id") String id,@RequestParam(value="name") String name,@RequestParam(value="description") String description)
	//public ModelAndView editAndSave(@RequestParam("id")String id,@RequestParam("name")String name)
	{
		
		//category.setId(id);
		//category.setName(name);
		//category.setDescription(description);
		categoryDao.saveOrUpdate(category);
	
		List<Category> categoryList = categoryDao.list();
		ModelAndView mv = new ModelAndView("/viewCategory");
		
		mv.addObject("categoryList", categoryList);
		
		return mv;
	}
	
	@ModelAttribute
	public void commonToCategory(Model model){
		 model.addAttribute("isLoggedInAdmin", true);
	}
	}
