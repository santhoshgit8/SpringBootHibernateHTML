package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csi.model.Employee;
import com.csi.service.ServiceDao;

@Controller
public class EmpController {

	@Autowired
	ServiceDao serviceDaoImpl;
	Employee employee = new Employee();

	// WELCOME PAGE
	@RequestMapping("/")
	public String homePage() {
		return "homepage";
	}

	// GET DATA
	@RequestMapping("/viewdata")
	public String viewPage(Model model) {
		List<Employee> employees = serviceDaoImpl.getAllData();
		model.addAttribute("employees", employees);
		return "viewdata1";
	}

	// SAVE DATA
	@RequestMapping("/adddata1")
	public String addData1(Model model) {
		model.addAttribute("employee", employee);
		return "addform";
	}

	@RequestMapping(value = "/adddata2", method = RequestMethod.POST)
	public String saveData(@ModelAttribute("employee") Employee employee) {
		serviceDaoImpl.saveData(employee);
		return "redirect:/viewdata";
	}

	// GETDATABY ID
	@RequestMapping("/editdata1/{empId}")
	public String editData(@PathVariable("empId") int empId, Model model) {
		Employee employee = serviceDaoImpl.getDataById(empId);
		model.addAttribute("employee", employee);
		return "editform";
	}

	// EDIT DATA
	@RequestMapping(value = "/editdata2", method = RequestMethod.POST)
	public String editSaveData(@ModelAttribute("employee") Employee employee) {
		serviceDaoImpl.updateData(employee);
		return "redirect:/viewdata";
	}

	// DELETE DATA
	@RequestMapping("/deletedata/{empId}")
	public String deleteData(@PathVariable("empId") int empId) {
		serviceDaoImpl.deleteDataById(empId);
		return "redirect:/viewdata";
	}
}
