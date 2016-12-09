package com.niit.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.SupplierDao;
import com.niit.project.model.Supplier;



@Controller
@Repository()
public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;
	

	@RequestMapping("/addsupplier")
	public ModelAndView newSupplier() {
		return new ModelAndView("newSupplier");
	 }
	
	@RequestMapping("/newSupplier")
	public ModelAndView newSupplier(@ModelAttribute Supplier supplier) {
		supplierDao.saveOrUpdate(supplier);
	  return new ModelAndView("adminHome");
	 }
	
	
	@RequestMapping("/viewSuppliers")
	public ModelAndView viewSuppliers() {

	//	System.out.println("getAllSuppliers");
		
		List<Supplier> supplierList = supplierDao.list();
		
		ModelAndView mv = new ModelAndView("viewSupplier");
		mv.addObject("supplierList", supplierList);
		mv.addObject("isViewSuppliersClicked", true);
		return mv;
		
	}
		@RequestMapping("/editSupplier/{id}")
		public ModelAndView viewSupplier(@PathVariable ("id") String id) {
				Supplier supplier = supplierDao.get(id);
				ModelAndView mv = new ModelAndView("editSupplier");
				mv.addObject("supplier", supplier);
		  return mv;
		  
		 }
		
		@RequestMapping("/editSupplier")
		public ModelAndView editAndSave(@ModelAttribute ("Supplier") Supplier supplier){
			supplierDao.saveOrUpdate(supplier);
			List<Supplier> supplierList = supplierDao.list();
			
			ModelAndView mv = new ModelAndView("/viewSupplier");
			mv.addObject("supplierList", supplierList);
			return mv;

		}
		
		@RequestMapping("/deleteSupplier/{id}")
		public String deleteSupplier(@PathVariable ("id") String id, ModelMap model){
			
			supplierDao.delete(id);
			
			return "redirect:/viewSuppliers";
		}
		
		@ModelAttribute
		public void commonToSupplier(Model model){
			 model.addAttribute("isLoggedInAdmin", true);
		}
}
