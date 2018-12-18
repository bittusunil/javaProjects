package xml2json;



public class Customers {

	private String name;

	private int age;
	
	private int id;

		
	public Customers(){
		
	}
	
	public Customers(String name, int id, int age) {
		this.name = name;
		this.age = age;
		this.id  = id;
		
		
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Details - ");
		sb.append("Name:" + getName());
		sb.append(", ");
		sb.append("Id:" + getId());
		sb.append(", ");
		sb.append("Age:" + getAge());
		sb.append(".");
		
		return sb.toString();
	}
}
