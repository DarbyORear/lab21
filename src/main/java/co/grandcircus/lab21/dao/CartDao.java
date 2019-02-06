package co.grandcircus.lab21.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.lab21.entities.Cart;


@Repository
@Transactional
public class CartDao {

	// Use this annotation to have Spring inject the Hibernate entity manager
	@PersistenceContext
	private EntityManager em;

	public List<Cart> findAll(){
		return em.createQuery("FROM Cart", Cart.class).getResultList();

	}
	
	public Cart findById(int id) {
		return em.find(Cart.class, id);
	}
	
	
	public void create(Cart cartItem) {
		em.persist(cartItem);
	}
	
	public void update(Cart cartItem) {
		em.merge(cartItem);
	}
	
	public void delete(int id) {
		Cart cartItem = em.getReference(Cart.class, id);
		em.remove(cartItem);
	}


	public Cart findbyItem(String itemName) {
//		return em.find(User.class, username);
		return em.createQuery("FROM Cart WHERE itemName = :itemName", Cart.class).setParameter("itemName", itemName).getSingleResult();
	}

//FIXME: THIS SHOULD BE A LIST OF ALL ITEMS UNDER ONE USERNAME
//	public Cart findByUsername(String userName) {
//		// TODO Auto-generated method stub
//		return em.createQuery("FROM Cart WHERE userName = :userName", Cart.class).setParameter("userName", userName).getSingleResult();
//
//	}
	
	//list of cart items based on username
	public List<Cart> findByUsername(String userName){
		try {
		return em.createQuery("FROM Cart WHERE userName = :userName", Cart.class).setParameter("userName", userName).getResultList();
	} catch (NoResultException e)  {
		return null;
	}
	}
	
	
	
	
	
	
	public List<Cart> findAllItems(){
		return em.createQuery("FROM Cart", Cart.class).getResultList(); //FROM User OR FROM users???

	}

//	public void addToCart(int id) {
//		Items item = em.find(Items.class, id);
//		//add that Item to cart
//		

	
	
}
