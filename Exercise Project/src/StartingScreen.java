import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * @author Aneesh Patri
 * This class creates the starting screen. When someone clicks the play button,
 * this is the first screen that pops up. There will be three buttons on the screen
 * which will take the user to different locations if clicked. The exercise button
 * will take the user to the muscle selection screen, and the user button will take
 * the user to the user input screen. There will also be a timechart which the user 
 * can see their workout activity.
 */

public class StartingScreen extends JFrame implements ActionListener {

	// Initializes the various screen features
	JButton Exercises = new JButton("Exercises");
	JButton User = new JButton("User");
	JLabel Title = new JLabel("Exercise Application");
	JLabel Picture = new JLabel(new ImageIcon("pics/workout.jpg"));
	JButton timeChart = new JButton("Time Chart");

	// Method that creates and sets the visual features of the Starting Screen
	public StartingScreen() {

		// Sets the size, visibility, and colour of the screen
		setLayout(null);
		setSize(1000, 700);
		getContentPane().setBackground(new Color(51, 153, 255));
		setVisible(true);
		setResizable(false);

		// Sets bounds, font, and colour for the title
		Title.setBounds(200, 30, 750, 75);
		Title.setFont(new Font("Arial", Font.BOLD, 64));
		Title.setForeground(new Color(0, 0, 0));
		add(Title);

		// Sets bounds, font, and different colours variations for the Exercises button
		Exercises.setBounds(50, 150, 300, 200);
		Exercises.setForeground(new Color(0, 0, 0));
		Exercises.setBackground(new Color(255, 204, 51));
		Exercises.setFont(new Font("Arial", Font.BOLD, 36));
		Exercises.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Exercises.addActionListener(this);
		add(Exercises);

		// Sets bounds, font, and different colours variations for the User button
		User.setBounds(50, 400, 300, 200);
		User.setForeground(new Color(0, 0, 0));
		User.setBackground(new Color(255, 204, 51));
		User.setFont(new Font("Arial", Font.BOLD, 36));
		User.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		User.addActionListener(this);
		add(User);

		// Sets bounds, font, and different colours variations for the time chart button
		timeChart.setBounds(530, 500, 300, 100);
		timeChart.setForeground(new Color(0, 0, 0));
		timeChart.setBackground(new Color(255, 204, 51));
		timeChart.setFont(new Font("Arial", Font.BOLD, 36));
		timeChart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		timeChart.addActionListener(this);
		add(timeChart);

		// Sets bounds for the Picture
		Picture.setBounds(-10, 50, 1000, 700);
		add(Picture);

	}

	// This method allows the button to be functional when clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		// If the exercise is pressed, it takes you to the exercise screen
		if (e.getSource() == Exercises) {
			this.setVisible(false);
			new MuscleSelection();

		}

		// if the user button is pressed, it you to the user screen
		if (e.getSource() == User) {
			this.setVisible(false);
			new UserScreen();

		}

		// if the timechart button is pressed, the timechart pops up
		if (e.getSource() == timeChart) {
			new TimeDistributionChart();

		}

	}

}