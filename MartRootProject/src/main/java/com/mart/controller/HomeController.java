package com.mart.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mart.action.GetBigCategory;
import com.mart.action.GetFloorProductList;
import com.mart.action.GetSecondCategory;
import com.mart.action.GetSecondFloorData;
import com.mart.action.GetThirdCategory;
import com.mart.action.GetThirdFloorData;
import com.mart.action.PrimAlgorithm;
import com.mart.dao.AllDao;
import com.mart.model.BigCategory;
import com.mart.model.FloorData;
import com.mart.model.SecondCategory;
import com.mart.model.ThirdCategory;

import net.sf.json.JSONArray;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private AllDao dao;
	
	@Autowired
	public void setDao(AllDao dao) {this.dao = dao;}
	public AllDao getDao() {return dao;}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session = request.getSession();
		session.invalidate();
		GetBigCategory bigCategory = new GetBigCategory(dao);
		GetSecondCategory secondCategory = new GetSecondCategory(dao);
		GetThirdCategory thirdCategory = new GetThirdCategory(dao);
		
		ArrayList<BigCategory> bigList = bigCategory.getBigCategory();
		ArrayList<SecondCategory> secondList = secondCategory.getAllSecondCategory();
		ArrayList<ThirdCategory> thirdList = thirdCategory.getAllThirdCategory();
		
		model.addAttribute("bigList", bigList);
		model.addAttribute("secondList", secondList);
		model.addAttribute("thirdList", thirdList);
		
		return "category";
	}
	
	@RequestMapping("/getBigCategory")
	public @ResponseBody JSONArray getBigCategory(Model model){
		
		GetBigCategory action = new GetBigCategory(dao);
		ArrayList<BigCategory> list = action.getBigCategory();
		JSONArray jArray = JSONArray.fromObject(list);
		
		return jArray;
	}
	
	@RequestMapping("/getSecondCategory")
	public @ResponseBody JSONArray getSecondCategory(
			@RequestParam("bId") int bId){
		
		GetSecondCategory action = new GetSecondCategory(dao);
		ArrayList<SecondCategory> list = action.getSecondCategory(bId);
		JSONArray jArray = JSONArray.fromObject(list);
		System.out.println(jArray);
		return jArray;
	}
	
	@RequestMapping("/getThirdCategory")
	public @ResponseBody JSONArray getThirdCategory(
			@RequestParam("bId") int bId){
		
		GetThirdCategory action = new GetThirdCategory(dao);
		ArrayList<SecondCategory> list = action.getThirdCategory(bId);
		JSONArray jArray = JSONArray.fromObject(list);
		System.out.println(jArray);
		return jArray;
	}
	
	@RequestMapping("/martRoot")
	public String martRoot(Model model, HttpServletRequest request,
			@RequestParam(value="selected", required=false) String selected[],
			@RequestParam(value="floor") int floor,
			@RequestParam(value="totalCount", required=false)String totalCount){
		
		HttpSession session = request.getSession();
		
		GetFloorProductList action = new GetFloorProductList(dao);
		if(selected != null){
			ArrayList<FloorData> thirdList = action.getThirdFloorProductList(selected);
			ArrayList<FloorData> secondList = action.getSecondFloorProductList(selected);

			ArrayList<Integer> secondPath = new ArrayList<Integer>();
			ArrayList<Integer> thirdPath = new ArrayList<Integer>();
			
			if(secondList.size() != 0){
				PrimAlgorithm prim = new PrimAlgorithm();
				prim.setNode(secondList);
				secondPath = prim.findRootUsingPrimAlgorithm();
//				System.out.println("second - >"+secondPath.toString());
			}
			if(thirdList.size() != 0){
				System.out.println("third in");
				PrimAlgorithm prim = new PrimAlgorithm();
				prim.setNode(thirdList);
				System.out.println("third out -> " +prim.getList());
				thirdPath = prim.findRootUsingPrimAlgorithm();
				System.out.println("third final");
			}
			session.setAttribute("secondPath", secondPath);
			session.setAttribute("thirdPath", thirdPath);
		}
		if(floor == 2){
			model.addAttribute("maxWidth",98);
			model.addAttribute("maxHeight",120);
			model.addAttribute("floor",2);
		}else if(floor == 3){
			model.addAttribute("floor",3);
			model.addAttribute("maxWidth",118);
			model.addAttribute("maxHeight",134);
		}
		
		if(totalCount != null){
			int count = Integer.parseInt(totalCount);
			model.addAttribute("totalCount", count);
		}
	
		return "martMap";
	}
	
	@RequestMapping("/getThirdFloor")
	public @ResponseBody JSONArray getThirdFloor(Model model){
		GetThirdFloorData action = new GetThirdFloorData(dao);
		ArrayList<FloorData> list = action.getThirdFloorData();
		JSONArray jArray = JSONArray.fromObject(list);
		return jArray;
	}
	
	@RequestMapping("/getSecondFloor")
	public @ResponseBody JSONArray getSecondFloor(Model model){
		GetSecondFloorData action = new GetSecondFloorData(dao);
		ArrayList<FloorData> list = action.getSecondFloorData();
		JSONArray jArray = JSONArray.fromObject(list);
		return jArray;
	}
	
	@RequestMapping("/getFloorPath")
	public @ResponseBody JSONArray getFloorPath(Model model, HttpServletRequest request,
			@RequestParam("floor") int floor){
		
		HttpSession session = request.getSession();
		
		if(floor == 2){
			ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("secondPath");
			return JSONArray.fromObject(list);
		}else if(floor == 3){
			ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("thirdPath");
			System.out.println(list);
			return JSONArray.fromObject(list);
		}else{
			session.invalidate();
			return null;
		}
	}
	
	@RequestMapping("/getTotalCount")
	public @ResponseBody JSONArray getTotalCount(HttpServletRequest request){
		HttpSession session = request.getSession();
		int total = 0;
		ArrayList<FloorData> second = (ArrayList<FloorData>)session.getAttribute("secondPath");
		ArrayList<FloorData> third = (ArrayList<FloorData>)session.getAttribute("thirdPath");
		total += second.size()-1;
		total += third.size()-1;
		
		JSONArray jArray = JSONArray.fromObject(total);
		return jArray;
	}
}
