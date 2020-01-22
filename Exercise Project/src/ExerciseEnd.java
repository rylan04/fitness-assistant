
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Author : Andy
public class ExerciseEnd extends JFrame implements ActionListener {

	// initializes comboBoxes, button, JLabels, and constant variables
	String[] exercises = new String[19];
	String[] weights = { "10", "15", "20", "30", "35", "40", "45", "50", "55", "60", "65", "75", "80" };
	String[] days = { "1", "2", "3", "4", "5", "6", "7" };

	JComboBox weightList = new JComboBox(weights);
	JComboBox exerciseList = new JComboBox();
	JComboBox uList = new JComboBox();
	JComboBox dayList = new JComboBox(days);

	JLabel eTitle = new JLabel("Enter your exercise");
	JLabel wTitle = new JLabel("Enter your weight");
	JLabel dTitle = new JLabel("Choose the day you worked out");
	JLabel uTitle = new JLabel("Select which user you are");
	JLabel finish = new JLabel("When you are done adding  your exercises close this window");

	JButton repeat = new JButton("Add this exercise");

	String inputE = (String) exerciseList.getSelectedItem();
	String inputW = (String) weightList.getSelectedItem();
	String inputD = (String) dayList.getSelectedItem();
	String inputU = (String) dayList.getSelectedItem();

	public ArrayList<Workout> workout = new ArrayList<Workout>();

	public ExerciseEnd() {
		// adds exercises and users to respective combobox
		for (int i = 0; i < ExerciseTest.exerciseArray.length; i++) {
			exerciseList.addItem(ExerciseTest.exerciseArray[i].getName());
		}

		for (int u = 0; u < ExerciseTest.userList.size(); u++) {
			uList.addItem(ExerciseTest.userList.get(u).getName());
		}

		// Makes the Jframe
		setSize(700, 500);
		setTitle("Exercise Record");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initializes and adds JLabels and comboBoxes to JFrame
		add(eTitle);
		eTitle.setBounds(100, 100, 200, 20);

		add(exerciseList);
		// exerciseList.setLayout(null);
		exerciseList.setBounds(100, 130, 120, 100);
		exerciseList.addActionListener(this);
		exerciseList.setVisible(true);

		add(wTitle);
		wTitle.setBounds(300, 100, 100, 20);

		add(weightList);

		weightList.setBounds(300, 130, 100, 100);
		weightList.addActionListener(this);
		weightList.setVisible(true);

		add(dTitle);
		dTitle.setBounds(450, 100, 180, 20);

		add(dayList);
		// dayList.setLayout(null);
		dayList.setBounds(450, 130, 100, 100);
		dayList.addActionListener(this);
		dayList.setVisible(true);

		add(uTitle);
		uTitle.setBounds(100, 220, 200, 100);

		add(uList);
		// dayList.setLayout(null);
		uList.setBounds(100, 300, 200, 100);
		uList.addActionListener(this);
		uList.setVisible(true);

		// Separate event for buttons to not listen for button clicks only
		// Clicklistener click = new Clicklistener();
		//
		// add(repeat);
		// repeat.setLayout(null);
		// repeat.setBounds(400, 300, 200, 100);
		// repeat.addActionListener(click);
		// repeat.setVisible(true);

		add(finish);
		finish.setLayout(null);
		finish.setBounds(100, 40, 400, 20);
		// finish.addActionListener(click);
		finish.setVisible(true);

	}

	// private class Clicklistener implements ActionListener {
	// // if the button is clicked the it will see if a txt file to store the
	// workouts
	// // has been created, if not then it will make one
	// // otherwise add the workout to the existing txt
	// public void actionPerformed(ActionEvent e) {
	// if (e.getSource() == repeat) {
	// String tx = (String) uList.getSelectedItem() + (String)
	// exerciseList.getSelectedItem() + "," + ","
	// + (String) weightList.getSelectedItem() + "," + (String)
	// dayList.getSelectedItem() + "\n";
	// if (!Workout.workoutFile.exists()) {
	// try {
	// Workout.workoutFile.createNewFile();
	// try {
	//
	// // Reads using scanner
	// PrintWriter nFile = new PrintWriter(new File("workoutFile.txt"));
	//
	// nFile.print(tx);
	//
	// } catch (FileNotFoundException error) {
	//
	// System.out.println("File not found");
	// }
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// }
	//
	// else {
	// try {
	// Files.write(Paths.get("workoutFile.txt"), tx.getBytes(),
	// StandardOpenOption.APPEND);
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// System.out.print("w");
	// }
	// // Writes name
	// }
	//
	// }
	// }
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// detect if the combo box opitions has changed
		inputE = (String) exerciseList.getSelectedItem();

		inputW = (String) weightList.getSelectedItem();

		inputD = (String) dayList.getSelectedItem();

		inputU = (String) dayList.getSelectedItem();

	}

	public ArrayList<Workout> getWorkout() {
		return workout;
	}

	public void setWorkout(ArrayList<Workout> workout) {
		this.workout = workout;
	}

}