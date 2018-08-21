package co.grandcircus.lab21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@RequestMapping("/")  //url path
	public ModelAndView showIndexPage() {
		ModelAndView mav = new ModelAndView("index"); //jsp file
		return mav;	
	}
	
	@RequestMapping("/register")  //url path
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView("registration");  //.jsp file
		return mav;	
	}
	
	@RequestMapping("/summary") //url path
	public ModelAndView showSummaryPage(
			@RequestParam("firstname")String name, //"firstname" = part of requestparam annotation, name = regular java parameter
			@RequestParam("lastname")String lastname,
			@RequestParam("email") String email){
		
		
		//construct a user from the url params
		User user = new User();
		user.setFirstname(name);  //matches String in Requestparam
		user.setLastname(lastname); //matches String in Requestparam
		user.setPassword(email); //matches String in Requestparam
		
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("person", user);
		return mav;	
	}
	
	@RequestMapping("/practiceform") //url path
	public ModelAndView showPracticePage() {
		ModelAndView mav = new ModelAndView("practiceform");  //.jsp file
		return mav;
	}
	
//	@RequestMapping("submit-user-registration")
//	public ModelAndView submitForm(
//			@RequestParam("firstname") String firstname,
//			@RequestParam("lastname") String firstname,
//			@RequestParam("firstname") String firstname,
}
























