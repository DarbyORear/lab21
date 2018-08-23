package co.grandcircus.lab21;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CoffeeShopController {
	
	@Autowired
	private ItemsDaoHibernate itemsDao;
	
	@Autowired
	private UserDaoHibernate userDao;
	
	
	@RequestMapping("/")  //url path
	public ModelAndView showIndexPage() {
		List<Items>items = itemsDao.findAll();
		return new ModelAndView("index", "items", items);
			//"index" = view, points to index.jsp; "items"= model, points to list of items (map of key: value pairs), items=variable
			//
	}
	
	//the above line (24) can also be written like this:
//	ModelAndView mav = new MOdelAndView("index");
//	mav.addObject("items", items);
//	return mav;
	
	@RequestMapping("/register")  //url path
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView("registration");  //.jsp file
		return mav;	
	}
	
	@RequestMapping("/summary") //url path
	public ModelAndView showSummaryPage(
			@RequestParam("firstname")String name, //"firstname" = part of requestparam annotation, name = regular java parameter
			@RequestParam("lastname")String lastname,
			@RequestParam("email") String email,
			@RequestParam("phonenum") String phonenum,
			@RequestParam("password") String password)
	{
		
		
		//construct a user from the url params
		User newUser = new User();
		newUser.setFirstname(name);  //matches String in Requestparam
		newUser.setLastname(lastname); //matches String in Requestparam
		newUser.setEmail(email); //matches String in Requestparam
		newUser.setPhonenum(phonenum);
		newUser.setPassword(password);
		
		ModelAndView mav = new ModelAndView("summary");
		mav.addObject("newUser", newUser);
		return mav;	
	}
	
	@RequestMapping("/practiceform") //url path
	public ModelAndView showPracticePage() {
		ModelAndView mav = new ModelAndView("practiceform");  //.jsp file
		return mav;
	}
	
	@RequestMapping("/item/{id}/delete")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/item/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut. Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("index", "items", "items");
	}
	
	@RequestMapping(value="/food/create", method=RequestMethod.POST)
	public ModelAndView submitCreateForm(Items item) {
		itemsDao.create(item);
		return new ModelAndView("redirect:/");
	}
	
//	@RequestMapping("/items") //url path
//	public ModelAndView showItems() {
//		ModelAndView mav = new ModelAndView("practiceform");  //.jsp file
//		return mav;
//	}
//	
	
//	@RequestMapping("submit-user-registration")
//	public ModelAndView submitForm(
//			@RequestParam("firstname") String firstname,
//			@RequestParam("lastname") String firstname,
//			@RequestParam("firstname") String firstname,

}
























