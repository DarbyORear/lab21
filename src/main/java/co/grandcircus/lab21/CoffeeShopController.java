package co.grandcircus.lab21;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



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
	
	@RequestMapping("/create-new-user") //url path
	//1. request params from registration
	public ModelAndView createNewUser(
			@RequestParam("firstname")String name,
			@RequestParam("lastname")String lastname,
			@RequestParam("email") String email,
			@RequestParam("phonenum") String phonenum,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session)
	{
		
		//construct a user from the url params
		User newUser = new User();
		newUser.setFirstname(name);  //matches String in Requestparam
		newUser.setLastname(lastname); //matches String in Requestparam
		newUser.setEmail(email); //matches String in Requestparam
		newUser.setPhonenum(phonenum);
		newUser.setUsername(username); 
		newUser.setPassword(password);
		session.setAttribute("newUser", newUser);
		
		//3. add new user to database
		//User gets created
		User user = (User) session.getAttribute("newUser");
		user.setId(null);
		user.setFirstname(name);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPhonenum(phonenum);
		user.setUsername(username);
		user.setPassword(password);
		//user is added to database
		userDao.create(newUser);
		
		//4. add new user to session
		session.setAttribute("newUser", newUser);
		
		
		//4. add new user to mav
		ModelAndView mav = new ModelAndView("redirect:/new-user-view");
		mav.addObject("newUser", newUser);
		return mav;	
	}

@RequestMapping("new-user-view")
public ModelAndView newUserView(HttpSession session) {
	//needs to show userView page but for new user
	List<Items>items = itemsDao.findAll();
	User user = (User) session.getAttribute("newUser");
	ModelAndView mav = new ModelAndView("userView");
	mav.addObject("items", items);
	mav.addObject("user1", user);
	return mav;
}
	
	@RequestMapping("/user-login")
	public ModelAndView userLogin() {
	ModelAndView mav = new ModelAndView("userLogin");
	return mav;
	}
	
	//FIXME: "specificmessage" doesn't show. figure out where/how I need to define specificmessage.
	@RequestMapping("/user-verify")
	private ModelAndView checkLoginInfo(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session, RedirectAttributes redir) {
		// find the matching user.
		User user = userDao.findbyUsername(username);
		//this is where it checks if user exists by checking username and password
		if(user == null  || !password.equals(user.getPassword())) {
			 ModelAndView mav = new ModelAndView("userLogin");
				mav.addObject("specificmessage", "Incorrect username or password. Please try again.");
				return mav; 
		}
		//Here we add the user to the session!!!!
		session.setAttribute("user1", user);
		return new ModelAndView("redirect:/user-view");
				
	}
	
	@RequestMapping("/user-view") //url path
	public ModelAndView showPracticePage(HttpSession session) {
		List<Items>items = itemsDao.findAll();
		User user = (User) session.getAttribute("user1");
		ModelAndView mav = new ModelAndView("userView");
		mav.addObject("items", items);
		mav.addObject("user1", user);
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();

		// A flash message will only show on the very next page. Then it will go away.
		redir.addFlashAttribute("specificmessage", "Logged out.");
		return new ModelAndView("redirect:/");
	}
	
	
	
	@RequestMapping("/admin-login")
	public ModelAndView adminLogin() {
	ModelAndView mav = new ModelAndView("adminLogin");
	return mav;
	}
	
	
	@RequestMapping("/items-admin")
	public ModelAndView showItemAdmin() {
	List<Items> items = itemsDao.findAll();
	return new ModelAndView("itemsAdmin", "items", items);
	}
	
	
	@RequestMapping("/item/{id}/delete")
	public ModelAndView delete(@PathVariable("id") int id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/add-item")
	public ModelAndView showAddItemForm() {			
		return new ModelAndView("addItem", "name", "add Item");
	}
	
	@RequestMapping("/submit-item")
	public ModelAndView submitCreateForm(
		
		@RequestParam("name")String name,
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
	
	
	// cart/summary page
	@RequestMapping("/cart") //url path
	public ModelAndView showCart(Items cartItem, @PathVariable("id") int id) {
		itemsDao.findById(id);
//		return new ModelAndView("index", "items", items);
		ModelAndView mav = new ModelAndView("userCart");
		mav.addObject("cartItem", cartItem);
		return mav;
	}
	}

