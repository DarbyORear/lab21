package co.grandcircus.lab21;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Repository;

//	import co.grandcircus.jdbcintro.entity.Room;

	// DAO stands for Data Access Object.
	// DAOs are used as a layer of code that is responsible for communicating
	// with the database. On the Java side, we use the Room POJO with properties.
	// On the SQL side, there are corresponding rows and columns.
	// The @Repository annotation tells Spring both that this is a component
	// (a.k.a Spring Bean) that can be autowired and that it should be treated like
	// a DAO (which mostly applies to error handling behind the scenes).
	@Repository
	public class ItemsDao {		
		// Spring will automatically inject this dependency thanks to @Autowired
		@Autowired
		private JdbcTemplate jdbcTemplate;

		public List<Items> findAll() {
			// BeanPropertyRowMapper uses the rows from the SQL result create
			// new Room objects and fill in the values by calling the setters.
			// Use .query for SQL SELECT statements.
			return jdbcTemplate.query("SELECT * FROM items", new BeanPropertyRowMapper<>(Items.class));
		}
		
		public Items findById(int id) {
			// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
			// While .query returns a list, .queryForObject assumes only one result. 
			Items match = jdbcTemplate.queryForObject("SELECT * FROM items WHERE id = ?", new BeanPropertyRowMapper<>(Items.class), id);
			// If nothing matched, match will be null.
			return match;
		}
		
		public void update(Items items) {
			String sql = "UPDATE items SET name = ?, description = ?, quantity = ?, price = ? WHERE id = ?";
			// Use .update for SQL INSERT, UPDATE, and DELETE
			// All the parameters after the first specify values to fill in the ?s in the SQL.
			jdbcTemplate.update(sql, items.getName(), items.getDescription(), items.getQuantity(), items.getPrice(), items.getId());
		}
		
		public void create(Items items) {
			String sql = "INSERT INTO items (name, description, quantity, price) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, items.getName(), items.getDescription(), items.getQuantity(), items.getPrice(), items.getId());
		}
		
		public void delete(int id) {
			String sql = "DELETE FROM items WHERE id = ?";
			jdbcTemplate.update(sql, id);
		}
	}
	