import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * @author: Aneesh Patri
 * This is the muscle selection screen which displays the 6 buttons for each muscle group 
 * Once the button is pressed, it takes the user to the corresponding muscle group to get more informationSets the visual features
 */

public class MuscleSelection extends JFrame implements ActionListener {

	// Declares the buttons and label
	JButton Arms = new JButton("Arms");
	JButton Chest = new JButton("Chest");
	JButton Shoulders = new JButton("Shoulders");
	JButton Legs = new JButton("Legs");
	JButton Back = new JButton("Back");
	JButton GoBack = new JButton("Go Back");
	JLabel Title = new JLabel("Muscles");

	// Method for setting the physical features of the screen
	public MuscleSelection() {

		// Sets the size, visibility, and colour of the screen
		setLayout(null);
		setSize(1000, 700);
		getContentPane().setBackground(new Color(51, 153, 255));
		setVisible(true);
		setResizable(false);

		// Sets bounds, font, and colour for the title
		Title.setBounds(375, 30, 750, 75);
		Title.setFont(new Font("Arial", Font.BOLD, 64));
		Title.setForeground(new Color(0, 0, 0));
		add(Title);

		// Sets bounds, font, and different colours variations for the arms button
		Arms.setBounds(15, 150, 300, 200);
		Arms.setForeground(new Color(0, 0, 0));
		Arms.setBackground(new Color(255, 204, 51));
		Arms.setFont(new Font("Arial", Font.BOLD, 36));
		Arms.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Arms.addActionListener(this);
		add(Arms);

		// Sets bounds, font, and different colours variations for the chest button
		Chest.setBounds(350, 150, 300, 200);
		Chest.setForeground(new Color(0, 0, 0));
		Chest.setBackground(new Color(255, 204, 51));
		Chest.setFont(new Font("Arial", Font.BOLD, 36));
		Chest.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Chest.addActionListener(this);
		add(Chest);

		// Sets bounds, font, and different colours variations for the shoulders button
		Shoulders.setBounds(180, 400, 300, 200);
		Shoulders.setForeground(new Color(0, 0, 0));
		Shoulders.setBackground(new Color(255, 204, 51));
		Shoulders.setFont(new Font("Arial", Font.BOLD, 36));
		Shoulders.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Shoulders.addActionListener(this);
		add(Shoulders);

		// Sets bounds, font, and different colours variations for the legs button
		Legs.setBounds(520, 400, 300, 200);
		Legs.setForeground(new Color(0, 0, 0));
		Legs.setBackground(new Color(255, 204, 51));
		Legs.setFont(new Font("Arial", Font.BOLD, 36));
		Legs.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Legs.addActionListener(this);
		add(Legs);

		// Sets bounds, font, and different colours variations for the back button
		Back.setBounds(685, 150, 300, 200);
		Back.setForeground(new Color(0, 0, 0));
		Back.setBackground(new Color(255, 204, 51));
		Back.setFont(new Font("Arial", Font.BOLD, 36));
		Back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Back.addActionListener(this);
		add(Back);

		// Sets bounds, font, and different colours variations for the go back button
		GoBack.setBounds(10, 10, 120, 80);
		GoBack.setForeground(new Color(0, 0, 0));
		GoBack.setBackground(new Color(255, 204, 51));
		GoBack.setFont(new Font("Arial", Font.BOLD, 24));
		GoBack.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		GoBack.addActionListener(this);
		add(GoBack);

	}

	// If a specific button is pressed, it takes you to the corresponding screen.
	@Override
	public void actionPerformed(ActionEvent e) {

		// When arms is pressed
		if (e.getSource() == Arms) {
			this.setVisible(false);
			new ExerciseScreen(1);
		}

		// When chest is pressed
		if (e.getSource() == Chest) {
			this.setVisible(false);
			new ExerciseScreen(2);
		}

		// When shoulders is pressed
		if (e.getSource() == Shoulders) {
			this.setVisible(false);
			new ExerciseScreen(3);
		}

		// When legs is pressed
		if (e.getSource() == Legs) {
			this.setVisible(false);
			new ExerciseScreen(4);
		}

		// When back is pressed
		if (e.getSource() == Back) {
			this.setVisible(false);
			new ExerciseScreen(5);
		}

		// When goback is pressed
		if (e.getSource() == GoBack) {
			dispose();
			new StartingScreen();

		}

	}

}