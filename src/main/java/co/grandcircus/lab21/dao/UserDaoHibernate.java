package co.grandcircus.lab21.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.grandcircus.lab21.entities.User;


@Repository
@Transactional
public class UserDaoHibernate {

	// Use this annotation to have Spring inject the Hibernate entity manager
	@PersistenceContext
	private EntityManager em;

	public List<User> findAll(){
		return em.createQuery("FROM User", User.class).getResultList(); //FROM User OR FROM users???

	}
	
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	
	public void create(User user) {
		em.persist(user);
	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}


	public User findbyUsername(String username) {
//		return em.find(User.class, username);
		return em.createQuery("FROM User WHERE username = :username", User.class).setParameter("username", username).getSingleResult();
	}

}
