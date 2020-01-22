
/* 
 * @author Rylan Sykes 
 * Object class to hold individual exercises and the muscle group they work out, their name, description, and video link
 */

public class Exercise {

	// Private variables
	private String muscleGroup;
	private String name;
	private String description;
	private String video;

	/*
	 * Constructor method
	 * 
	 * @param muscleGroup Holds which muscle group an exercise works out
	 * 
	 * @param name Specific exercise name
	 * 
	 * @param description Description on how to perform each exercise correctly
	 * 
	 * @param video Video file directory
	 */
	public Exercise(String muscleGroup, String name, String description, String video) {

		this.muscleGroup = muscleGroup;
		this.name = name;
		this.description = description;
		setVideo(video);
	}

	/*
	 * Getters and setters
	 */
	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = "videos/" + video + ".mp4";
	}

	/*
	 * toString method(non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return String that displays all parameters of the object
	 */
	@Override
	public String toString() {
		return "Exercise [muscleGroup=" + muscleGroup + ", name=" + name + ", description=" + description + ", video="
				+ video + "]";
	}

}
