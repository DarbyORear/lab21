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
	
//	@RequestMapping("/item/{id}/delete")
//	public ModelAndView delete(@RequestParam("id") Integer id) {
//		itemsDao.delete(id);
//		return new ModelAndView("redirect:/");
//	}
	
	
	@RequestMapping("/add-item")
	public ModelAndView showAddItemForm() {
		return new ModelAndView("addItem"); //jsp file (in the jsp file, tell it the next place you want it to go is the submit-form method in the controller???
	}
	
	@RequestMapping("/submit-item") //WHAT GOES HERE?
	public ModelAndView submitCreateForm(
		
		@RequestParam("name")String name, //"firstname" = part of requestparam annotation, name = regular java parameter
		@RequestParam("description")String description,
		@RequestParam("quantity") int quantity,
		@RequestParam("price") float price)
{
	
	//construct an item object from the url params
	Items newItem = new Items();
	newItem.setName(name);  //matches String in Requestparam
	newItem.setDescription(description); //matches String in Requestparam
	newItem.setQuantity(quantity); //matches String in Requestparam
	newItem.setPrice(price);
	
	itemsDao.create(newItem);
	ModelAndView mav = new ModelAndView("redirect:/");
	mav.addObject("newItem", newItem);
	return mav;

	}
	

//}
}























