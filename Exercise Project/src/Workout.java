
public class Workout {

	String name;
	String day;
	String weight;

	public Workout(String name, String day, String weight) {
		super();
		this.name = name;
		this.day = day;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
