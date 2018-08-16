package co.grandcircus.lab21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@RequestMapping("/")
	public ModelAndView showIndexPage() {
		ModelAndView mav = new ModelAndView("index");
		return mav;	
	}
	
	@RequestMapping("/register") //.url
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView("registration");  //.jsp
		return mav;	
	}
	
	@RequestMapping("/summary")
	public ModelAndView showSummaryPage(@RequestParam("firstname")String name) {
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("firstname", name);
		return mav;	
	}
}
























