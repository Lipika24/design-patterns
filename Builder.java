package Creational_Design_Patterns;
class User
{
	//All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	private User(Builder builder) 
	{
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	//All getter, and NO setter to provide immutability
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
	}

	public static class Builder
	{
		private final String firstName;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public Builder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		public User build() {
			User user =  new User(this);
			return user;
		}	
	}
}
public class Builder{

	public static void main(String args[])
	{
		User user1 = new User.Builder("Lokesh", "Gupta")
				.age(30)
				.phone("1234567")
				.address("Fake address 1234")
				.build();

				System.out.println(user1);

				User user2 = new User.Builder("Jack", "Reacher")
				.age(40)
				.phone("5655")
				//no address
				.build();
				System.out.println(user2);

				User user3 = new User.Builder("Super", "Man")
				//No age
				//No phone
				//no address
				.build();

				System.out.println(user3);
	}

}



