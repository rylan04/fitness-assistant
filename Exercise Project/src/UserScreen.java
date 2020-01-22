import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/* @author Aneesh Patri, Rylan Sykes
 * GUI screen where users input their information to create users, or select an already existing user
 */
public class UserScreen extends JFrame implements ActionListener {

	private JButton submit = new JButton("Submit");
	private JTextField name;
	private JTextField weight;
	private JTextField bodyweight;
	private JLabel namelabel = new JLabel("Enter your Name");
	private JLabel bodyweightlabel = new JLabel("Enter your Bodyweight");
	private JComboBox userSelection = new JComboBox();
	JLabel namebox = new JLabel("Name Select");
	JLabel Picture = new JLabel(new ImageIcon("pics/muscle.jpg"));

	/*
	 * currentUser is a String that holds which user is currently logged into the
	 * program
	 */
	public static String currentUser;

	public UserScreen() {

		// Sets the features of the entire user screen and also background colour
		setLayout(null);
		setSize(1000, 700);
		getContentPane().setBackground(new Color(51, 153, 255));
		setVisible(true);
		setResizable(false);

		// Creates a name textfield in which the user can input their name
		name = new JTextField(10);
		name.setBounds(650, 100, 225, 60);
		name.setFont(new Font("Arial", Font.BOLD, 24));
		add(name, BorderLayout.SOUTH);

		// Sets bounds, font, and colour for the name
		namelabel.setBounds(625, 20, 750, 75);
		namelabel.setFont(new Font("Arial", Font.BOLD, 36));
		namelabel.setForeground(new Color(0, 0, 0));
		add(namelabel);

		// Creates a bodyweight textfield in which the user can input their bodyweight
		bodyweight = new JTextField(10);
		bodyweight.setBounds(650, 300, 225, 60);
		bodyweight.setFont(new Font("Arial", Font.BOLD, 24));
		add(bodyweight, BorderLayout.SOUTH);

		// Sets bounds, font, and colour for the bodyweight label
		bodyweightlabel.setBounds(575, 220, 750, 75);
		bodyweightlabel.setFont(new Font("Arial", Font.BOLD, 36));
		bodyweightlabel.setForeground(new Color(0, 0, 0));
		add(bodyweightlabel);

		// Sets bounds, font, and colour for the name select label
		namebox.setBounds(215, 20, 750, 75);
		namebox.setFont(new Font("Arial", Font.BOLD, 36));
		namebox.setForeground(new Color(0, 0, 0));
		add(namebox);

		// Sets bounds, font, colour, border, and visual appearances of the submit
		// button
		submit.setBounds(635, 450, 250, 150);
		submit.setForeground(new Color(0, 0, 0));
		submit.setBackground(new Color(255, 204, 51));
		submit.setFont(new Font("Arial", Font.BOLD, 36));
		submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		submit.addActionListener(this);
		add(submit);

		// Initializes the characteristics of the user selection combo box
		add(userSelection);
		userSelection.addActionListener(this);
		userSelection.setBounds(220, 85, 200, 50);
		for (int i = 0; i < ExerciseTest.userList.size(); i++)
			userSelection.addItem(ExerciseTest.userList.get(i).getName());
		userSelection.setEditable(false);

		// Sets bounds for the Picture
		Picture.setBounds(-200, 10, 1000, 700);
		add(Picture);

	}

	/*
	 * Listens to users' clicks(non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			// If user leaves name blank
			if (name.getText().equals("")) {

				// Set current user to selected user
				currentUser = (String) userSelection.getSelectedItem();

			} else {
				// Else add the user to the array list of users
				ExerciseTest.userList.add(new User(name.getText(), Integer.parseInt(bodyweight.getText())));

				// Set the current user
				currentUser = name.getText();

				// Sample input
				ExerciseTest.userList.get(0).setTimeArray(1, 105);
				ExerciseTest.userList.get(0).setTimeArray(2, 238);
				ExerciseTest.userList.get(0).setTimeArray(3, 205);
				ExerciseTest.userList.get(0).setTimeArray(4, 305);
				ExerciseTest.userList.get(0).setTimeArray(4, 450);
				ExerciseTest.userList.get(0).setTimeArray(5, 450);

				writeUsers();
			}

			dispose();
			new StartingScreen();

		}

	}

	/*
	 * @author Rylan Sykes Writes the user object parameters into a text file
	 */
	public void writeUsers() {

		try {
			PrintWriter writer = new PrintWriter("textFiles/userFile.txt");

			for (int i = 0; i < ExerciseTest.userList.size(); i++) {

				// Writes the time spent on each exercise
				for (int j = 0; j < 6; j++) {
					writer.print(ExerciseTest.userList.get(i).getTimeArray(j) + ",");
				}

				// Writes name
				writer.print(ExerciseTest.userList.get(i).getName() + ",");
				// Writes body weight
				writer.print(ExerciseTest.userList.get(i).getBodyWeight());

				// If writer is on the last line
				if (i == ExerciseTest.userList.size() - 1) {
					// Stop writing
					writer.close();
				} else {
					// Else separate last value with a comma
					writer.print(",");
				}
			}

		} catch (FileNotFoundException error) {

			error.printStackTrace();
		}
	}

	/*
	 * @author Rylan Sykes Reads text file and creates users with their past data
	 */
	public static void loadUsers() {

		System.out.println("load users method");
		try {

			// Reads data using scanner
			Scanner read = new Scanner(new File("textFiles/userFile.txt"));

			// Seperates data with commas
			read.useDelimiter(",");

			int index = 0;

			while (read.hasNext()) {

				// Reads in time array
				int exerciseTime1 = read.nextInt();
				int exerciseTime2 = read.nextInt();
				int exerciseTime3 = read.nextInt();
				int exerciseTime4 = read.nextInt();
				int exerciseTime5 = read.nextInt();
				int exerciseTime6 = read.nextInt();

				// Reads in name
				String name = read.next();

				// Reads in body weight
				int bodyWeight = read.nextInt();

				// Sets parameters for user objects in the user object arraylist
				ExerciseTest.userList.add((new User(name, bodyWeight)));

				// Sample input
				ExerciseTest.userList.get(index).setTimeArray(0, exerciseTime1);
				ExerciseTest.userList.get(index).setTimeArray(1, exerciseTime2);
				ExerciseTest.userList.get(index).setTimeArray(2, exerciseTime3);
				ExerciseTest.userList.get(index).setTimeArray(3, exerciseTime4);
				ExerciseTest.userList.get(index).setTimeArray(4, exerciseTime5);
				ExerciseTest.userList.get(index).setTimeArray(5, exerciseTime6);

				// Increments index
				index++;
			}

			// Stops reading file
			read.close();

		} catch (FileNotFoundException error) {

			// Error message
			System.out.println("userFile.txt not found");
		}
	}

	/*
	 * Code for saving the user name and bodyweight and also storing it in another
	 * // file // public void actionPerformed(ActionEvent e) { // // TODO
	 * Auto-generated method stub // if (e.getSource() == submit) { // //
	 * TestClass.userList.add(new User(name.getText(), //
	 * Integer.parseInt(bodyweight.getText()))); // //
	 * TestClass.userList.get(0).setWeightArray(6); // //
	 * TestClass.userList.get(0).setWeightArray(10); // //
	 * TestClass.userList.get(0).setWeightArray(5); // //
	 * System.out.println(TestClass.userList.get(0).getWeightArray()); // save(); //
	 * // System.out.println(TestClass.userList.get(0).toString()); // // } // // }
	 * // // private void save() { // // try { // // if (!TestClass.file1.exists())
	 * { // TestClass.file1.createNewFile(); // } // // // Here true is to append
	 * the content to file // FileWriter fWriter = new FileWriter(TestClass.file1,
	 * true); // PrintWriter pWriter = new PrintWriter(fWriter); // //
	 * pWriter.write(name.getText() + "," + bodyweight.getText()); // // for
	 * (Integer currentWeight: TestClass.userList.get(0).getWeightArray()) //
	 * pWriter.write(currentWeight + ","); // // pWriter.println(); // // // Closing
	 * PrintWriter Stream // pWriter.close(); // // } catch (IOException ioe) { //
	 * System.out.println("Exception occurred:"); // ioe.printStackTrace(); // }
	 */

}
