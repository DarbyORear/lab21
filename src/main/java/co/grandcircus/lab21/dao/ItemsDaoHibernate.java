package co.grandcircus.lab21.dao;

	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import co.grandcircus.lab21.entities.Items;


	@Repository
	@Transactional
	public class ItemsDaoHibernate {

		// Use this annotation to have Spring inject the Hibernate entity manager
		@PersistenceContext
		private EntityManager em;

		public List<Items> findAll(){
			return em.createQuery("FROM Items", Items.class).getResultList();
		}
		
		public Items findById(int id) {
			return em.find(Items.class, id);
		}
		
//		public List<Items> findById(int id) {
//			// HQL queries can have named parameters, such as :regex here.
//			return em.createQuery("FROM Items", Items.class)
//					.getResultList();
//		}
		
		public void create(Items item) {
			em.persist(item);

		}
		
		
		//note (1/29/29): THIS should be the right way to update an item
		public void update(Items item){
			em.merge(item);
		}
		
		public void delete(int id) {
			Items item = em.getReference(Items.class, id);
			em.remove(item);
			System.out.println("Are you sure you want to delete this item?");
		}
		
		//DO I NEED TO ADD A METHOD HERE TO ADD A SPECIFIC ITEM TO THE CART? (1/28/19)
		//maybe this method needs to be in cartDao not itemsDao
//		public void addToCart(int id) {
//			Items item = em.find(Items.class, id);
//			//add that Item to cart
//			
//
//		}
		

	}

