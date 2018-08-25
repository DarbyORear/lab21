package co.grandcircus.lab21;

	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;


	@Repository
	@Transactional
	public class ItemsDaoHibernate {

		// Use this annotation to have Spring inject the Hibernate entity manager
		@PersistenceContext
		private EntityManager em;

		public List<Items> findAll(){
			return em.createQuery("FROM Items", Items.class).getResultList();
		}
		
		public Items findById(Integer id) {
			return em.find(Items.class, id);
		}
		
		
		public void create(Items item) {
			em.persist(item);

		}
		
		public void update(Items item) {
			em.merge(item);
		}
		
		public void delete(Integer id) {
			Items item = em.getReference(Items.class, id);
			em.remove(item);
			System.out.println("Are you sure you want to delete this item?");
		}

	}
