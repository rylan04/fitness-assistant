
import java.util.Arrays;

//Aneesh Patri
public class User {

	private String name;
	private int bodyWeight;
	private int[] timeArray = new int[6];

	public User(String name, int bodyWeight) {
		super();
		this.name = name;
		this.bodyWeight = bodyWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public void setTimeArray(int exercise, int time) {
		timeArray[exercise] = timeArray[exercise] + time;
	}

	public int getTimeArray(int index) {
		return timeArray[index];
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", bodyWeight=" + bodyWeight + ", timeArray=" + Arrays.toString(timeArray) + "]";
	}

}
