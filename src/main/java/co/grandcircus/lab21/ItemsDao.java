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

		public List<User> findAll() {
			// BeanPropertyRowMapper uses the rows from the SQL result create
			// new Room objects and fill in the values by calling the setters.
			// Use .query for SQL SELECT statements.
			return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
		}
		
		public User findById(Long id) {
			// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
			// While .query returns a list, .queryForObject assumes only one result. 
			User match = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
			// If nothing matched, match will be null.
			return match;
		}
		
		public void update(User newUser) {
			String sql = "UPDATE Room SET name = ?, capacity = ?, available = ? WHERE id = ?";
			// Use .update for SQL INSERT, UPDATE, and DELETE
			// All the parameters after the first specify values to fill in the ?s in the SQL.
			jdbcTemplate.update(sql, newUser.getFirstname(), newUser.getLastname(), newUser.getEmail(), newUser.getId());
		}
		
		public void create(User newUser) {
			String sql = "INSERT INTO Room (name, capacity, available) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, newUser.getFirstname(), newUser.getLastname(), newUser.getEmail(), newUser.getId());
		}
		
		public void delete(Long id) {
			String sql = "DELETE FROM users WHERE id = ?";
			jdbcTemplate.update(sql, id);
		}
	}
	