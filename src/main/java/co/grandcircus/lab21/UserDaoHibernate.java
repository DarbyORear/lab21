package co.grandcircus.lab21;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoHibernate {

	// Use this annotation to have Spring inject the Hibernate entity manager
	@PersistenceContext
	private EntityManager em;

	public List<User> findAll(){
		return em.createQuery("FROM users", User.class).getResultList();

	}
	
	public User findById(Integer id) {
		return em.find(User.class, id);
	}
	
	
	public void create(User user) {
		em.persist(user);

	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(Integer id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}

}
