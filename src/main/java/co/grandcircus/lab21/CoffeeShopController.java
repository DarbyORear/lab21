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
//		return new ModelAndView("index", "items", items);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("items", items);
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
		List<Items>items = itemsDao.findAll();
//		return new ModelAndView("index", "items", items);
		ModelAndView mav = new ModelAndView("practiceform");
		mav.addObject("items", items);
		return mav;
	}
	
	@RequestMapping("/admin-login")
	public ModelAndView adminLogin() {
	ModelAndView mav = new ModelAndView("adminLogin");
	return mav;
	}
	
	@RequestMapping("/user-login")
	public ModelAndView userLogin() {
	ModelAndView mav = new ModelAndView("userLogin");
	return mav;
	}
	
	@RequestMapping("/items-admin") //CHANGE?? /items-admin or itemsAdmin?
	public ModelAndView showItemAdmin() {
	List<Items> items = itemsDao.findAll();
	return new ModelAndView("itemsAdmin", "items", items); //WHAT GOES HERE?
	}
	
//	@RequestMapping("/user-login")
	
	
	@RequestMapping("/item/{id}/delete")
	public ModelAndView delete(@PathVariable("id") int id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/add-item")
	public ModelAndView showAddItemForm() {			//CHANGE MADE: ADDED 2 EXTRA THINGS IN (), what goes there??
		return new ModelAndView("addItem", "name", "add Item"); //jsp file (in the jsp file, tell it the next place you want it to go is the submit-form method in the controller???
	}
	
	@RequestMapping("/submit-item")
	public ModelAndView submitCreateForm(
		
		@RequestParam("name")String name, //"firstname" = part of requestparam annotation, name = regular java parameter
		@RequestParam("description")String description,
		@RequestParam("quantity") int quantity,
		@RequestParam("price") float price)
{
	
	//construct an item object from the url params

	Items newItem = new Items();
	newItem.setName(name); //matches String in Requestparam
	newItem.setDescription(description); //matches String in Requestparam
	newItem.setQuantity(quantity); //matches String in Requestparam
	newItem.setPrice(price);
	
	itemsDao.create(newItem);
	ModelAndView mav = new ModelAndView("redirect:/");
	mav.addObject("newItem", newItem);
	return mav;

	}
	
	//OR
//	@RequestMapping 
	//EDIT AN ITEM
	
	@RequestMapping(value="/item/{id}/update", method=RequestMethod.POST)
	public ModelAndView submitEditForm(Items item, @PathVariable("id") int id) {
//		item.setId(id);
//		itemsDao.update(item);
		itemsDao.update(id);
		return new ModelAndView("redirect:/edit-item");
}
	
	@RequestMapping(value="/edit-item", method=RequestMethod.POST)
	public ModelAndView viewEditForm() {
		return new ModelAndView("redirect:/editItem");
}

}