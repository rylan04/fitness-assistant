
/* Group: Rylan Sykes, Aneesh Patri, Andy Lau
 * Responsibilities: Rylan Sykes - 
 * Collect information about various exercises and put them into a Google sheet, then export as a .csv file to read into Eclipse. 
 * Create exercise class that can make can be made to make exercise objects that holds muscle groups, name, description, and video names. 
 * Read in .csv file and creates all exercise objects with appropriate muscle group, name, description, video. 
 * Make exercise info GUI that shows various exercises linked to the muscle group shown and can randomise variations of each exercise. 
 * Make the exercise screen play videos of each exercise. 
 * Have a timer that allows the user to input a given time and countdown to track how long the user wants to do an exercise. 
 * Track the time a person works out in each muscle group and graph the ratio of how long they worked out each muscle group
 * Aneesh Patri - 
 * Create the user screen which allows users to input their name and bodyweight for it to be stored in the resource folder. 
 * Create muscle selection screen in which users select the muscle group they want to focus on for the day. 
 * Takes them onto another screen when any of the 6 buttons are pressed
 * Create a screen in which the users can click the exercise button which takes them to the muscle selection screen, or the user button which takes them to the user screen (Main screen)
 * Andy Lau -
 * User weight input screen
 * Graph weight over time
 * Workout object class
 * Store the weights and inputed value from the graph into a readable file in the program
 * Date of submission: 2018 - 12- 10
 * Course code: ICS4U1 - 01
 * Title of project: Software development project, title of product: Fitness App
 * Description: An exercise application that can display information on different exercises and graph various fitness progressions.
 * Features: 1. Timer that can count down from a given amount and track which muscle group that was being timed which can later be graphed to see how long a user spent on each muscle group
 * 2. Videos of each exercise can be played to show how to properly do a rep of the exercise
 * 3. Users can save their progress and data and can log in to continue tracking their progress
 * 4. Users can input data about how much weight they lifted over time and will be graphed to show the change in weight lifted over time
 * Major skills:
 * 1. OOP - Objects were used to store data of exercises, workouts, and users
 * 2. Control Structures - If statements, for loops, enhanced for loops, try - catch
 * 3. Inheritance - JLabel, JFrame, ActionListener, MouseListener
 * 4. External API's - JFreeChart, VLCJ
 * 5. Arrays - Arrays of objects, ArrayLists of objects, arrays of integers
 * Areas of Concern -
 * Files needed: JFreeChart folder (jar file), "pics" folder, "soundFiles" folder, "videos" folder, "vlc" folder, "vlcj-3.0.1" folder
 * Errors: 1. User is able to type letters into the body weight category
 */

import java.io.*;
import java.util.*;

/* @author Rylan Sykes, Aneesh Patri
 * Test class, runs the user screen when program is opened
 */
public class ExerciseTest {

	// Holds all exercise objects
	public static Exercise[] exerciseArray = new Exercise[19];

	// Holds user objects
	public static ArrayList<User> userList = new ArrayList<User>();

	public static File file1 = new File("res/userinputs.txt");

	/*
	 * Main method, runs the load exercises method, runs the load users method,
	 * and creates a new users screen
	 */
	public static void main(String[] args) {

		// Reads in exercises from text file
		loadExercises();

		// Reads in users from text file
		UserScreen.loadUsers();

		// Creates screen to display user inputs

		new UserScreen();

	}

	/*
	 * @author Rylan Sykes Reads in text file
	 */
	public static void loadExercises() {

		try {

			// Reads using scanner
			Scanner read = new Scanner(new File("textFiles/EXERCISELIST.csv"));

			// Each value separated by a dash
			read.useDelimiter("-");

			// Reads in strings
			for (int i = 0; i < exerciseArray.length; i++) {
				int index = 0;
				while (read.hasNextLine()) {

					String muscleGroup = read.next();
					String name = read.next();
					String description = read.next();
					String video = read.next();

					// Makes objects
					exerciseArray[index] = new Exercise(muscleGroup, name, description, video);
					index++;
				}
			}

			// Stops reading text file
			read.close();

			// If there's no file
		} catch (FileNotFoundException error) {

			// Display error
			System.out.println("EXERCISELIST.csv not found");
		}
	}

}
