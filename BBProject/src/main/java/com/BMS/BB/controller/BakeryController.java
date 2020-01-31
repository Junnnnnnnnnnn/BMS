package com.BMS.BB.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.BMS.BB.service.BakeryService;
import com.BMS.BB.service.IBakeryService;
import com.BMS.BB.service.IBookService;

@Controller
public class BakeryController {
	@Autowired
	IBakeryService bakeryService;
	
	@Autowired
	IBookService bookService;
	
	
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainBMS() {
		return "/hr/main";
	}
	
	@RequestMapping(value="/introduce", method=RequestMethod.GET)
	public String introduceBMS() {
		
		return "/hr/introduce";
	}
	
	@RequestMapping(value="/map", method=RequestMethod.GET)
	public String mapBMS() {
		return "/hr/map";
	}
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menuBMS() {
		return "/hr/menu";
	}
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public String bookBMS(Model model) {
		model.addAttribute("breadVO", bakeryService.getBMSamount());
		
		System.out.println(bakeryService.getBMSamount().get(0).getBREAD_AMOUNT());
		System.out.println(bakeryService.getBMSamount().get(2).getBREAD_PRICE());
		
		return "/hr/book";
	}
	
	@RequestMapping(value="/lookbook", method=RequestMethod.GET)
	public String lookBMS() {
		return "/hr/lookbook";
	}
	
	@RequestMapping(value="/lookbook_2", method=RequestMethod.GET)
	public String look2BMS() {
		return "/hr/lookbook";
	}

	
	
	@RequestMapping(value="/hr/bakeryBook", method=RequestMethod.POST)
	public String bookBMS(@RequestParam(value="breadName", required=false) String breadName,
															@RequestParam(value="count", required=false) int amount,
																	@RequestParam(value="num",required=false)String phoneNumber,
																			Model model) {
		if(bakeryService.updateBakery(amount, breadName)==true) {
			bookService.insertBook(phoneNumber,breadName,amount);
		}
		else {
			return "redirect:/book";
		}
		
		return "redirect:/book";
	}
	
	@RequestMapping(value="/hr/lookbook1", method=RequestMethod.POST)
	public String lookbookBMS(@RequestParam(value="bookNum", required=false) String phoneNum,
																			Model model) {
		model.addAttribute("bookVO" ,bookService.readBook(phoneNum));
		return "hr/lookbook_2";
	}
	
	@RequestMapping(value="hr/lookbook2", method=RequestMethod.POST)
	public String look2BMS(@RequestParam(value="cancelBook",required=false)int bookNum) {
		
		System.out.println(bookNum);
		bookService.deleteBook(bookNum);
		
		return "redirect:/lookbook_2";
	}
	
	
	

}