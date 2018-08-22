package co.grandcircus.lab21;

public class User {

		private String id;
		private String firstname;
		private String lastname;
		private String email;
		private String phonenum;
		private String password;
		
		public User() {}
		
		public User(int id, String firstname, String lastname, String email, String phonenum, String password) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.phonenum = phonenum;
			this.password = password;
			
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phonenum="
					+ phonenum + ", password=" + password + "]";
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhonenum() {
			return phonenum;
		}

		public void setPhonenum(String phonenum) {
			this.phonenum = phonenum;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		

}
