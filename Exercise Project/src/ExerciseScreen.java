
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import sun.audio.*;
import javax.swing.*;
import javax.swing.Timer;

/* @author Rylan Sykes
 * Screen to show the multiple exercises for each muscle group and videos
 */

public class ExerciseScreen extends JFrame implements ActionListener, MouseListener {

	// Count down timer
	Timer timer = new Timer(1000, this);

	// Array of labels to hold exercise titles
	JLabel[] exerciseTitle = new JLabel[3];

	// Array to hold exercise descriptions
	JTextArea[] exerciseDescription = new JTextArea[3];

	// Displays which is the selected muscle category
	JLabel muscleCategory = new JLabel();

	// Randomizes exercise variations
	JButton randomize = new JButton("RANDOMIZE");

	// Plays video of an exercise
	JButton[] video = new JButton[3];

	// Button that will take you to the muscle selection screen
	JButton back = new JButton("BACK");

	// Displays which user is currently using the screen
	JLabel userNameLabel = new JLabel();

	// Custom fonts
	Font titleFont = new Font("TimesRoman", Font.BOLD, 50);
	Font subheadingFont = new Font("TimesRoman", Font.BOLD, 30);
	Font textFont = new Font("TimesRoman", Font.BOLD, 21);

	// Start and stop count down timer buttons
	JButton startTime = new JButton();
	JButton stopTime = new JButton();

	// Displays time
	JLabel showTime = new JLabel();

	// Input for seconds for timer
	private String timeInput;
	// Holds the current time
	private int time;

	// Holds which category the user chose
	private int muscleGroup;

	/*
	 * Constructor method
	 * 
	 * @param category - Holds which category the user chose
	 */
	public ExerciseScreen(int category) {

		setSize(1000, 700);
		setLabels(category);
		setLayout(null);
		setVisible(true);
		setResizable(false);

		// Changes background colour
		getContentPane().setBackground(new Color(30, 144, 225));

		// Sets the category to a variable that can be used in another method
		muscleGroup = category;

		for (int i = 0; i < ExerciseTest.userList.size(); i++) {
			System.out.println(ExerciseTest.userList.get(i).toString());
		}

	}

	/*
	 * Sets labels
	 * 
	 * @param c - Holds which muscle category the user chose
	 */
	public void setLabels(int c) {

		// Adds the label that displays the current time for the count down
		add(showTime);
		showTime.setBounds(690, 570, 100, 100);
		showTime.setFont(new Font("TimesRoman", Font.BOLD, 40));

		// Adds button that allows user to input time for count down
		add(startTime);
		startTime.addActionListener(this);
		startTime.setIcon(new ImageIcon(new ImageIcon("pics/timer.png").getImage().getScaledInstance(100, 100, 0)));
		startTime.setBackground(new Color(30, 144, 225));
		startTime.setBounds(690, 570, 100, 100);

		// Adds button that allows user to stop count down
		add(stopTime);
		stopTime.addActionListener(this);
		stopTime.setIcon(new ImageIcon(new ImageIcon("pics/stop.jpg").getImage().getScaledInstance(100, 100, 0)));
		stopTime.setBackground(new Color(30, 144, 225));
		stopTime.setBounds(550, 570, 100, 100);

		// If chest is selected
		if (c == 2)
			// Move the stop time button to a different location
			stopTime.setBounds(840, 570, 100, 100);

		// Adds back button for user to go back to the muscle selection screen
		add(back);
		back.setBounds(5, 5, 75, 75);
		back.addActionListener(this);

		// Muscle category
		add(muscleCategory);
		muscleCategory.setBounds(200, 0, 700, 100);
		muscleCategory.setFont(titleFont);

		// Displays the current user
		add(userNameLabel);
		userNameLabel.setBounds(10, 540, 190, 150);
		userNameLabel.setText("CURRENT USER: " + UserScreen.currentUser);
		userNameLabel.setFont(new Font("TimesRoman", Font.BOLD, 15));

		// If chest
		if (c == 2) {

			// Make randomize exercise button
			add(randomize);
			randomize.addActionListener(this);
			randomize.setBounds(300, 600, 150, 50);
		}

		// Adds all labels to frame
		for (int i = 0; i < 3; i++) {

			exerciseTitle[i] = new JLabel();
			add(exerciseTitle[i]);
			exerciseTitle[i].setFont(subheadingFont);

			exerciseDescription[i] = new JTextArea();
			add(exerciseDescription[i]);
			exerciseDescription[i].setFont(textFont);
			exerciseDescription[i].setLineWrap(true);
			exerciseDescription[i].setEditable(false);
			exerciseDescription[i].setBackground(new Color(30, 144, 225));

			video[i] = new JButton("VIDEO");
			add(video[i]);
			video[i].addActionListener(this);
			video[i].addMouseListener(this);
			video[i].setBounds(800, 80 + (200 * i), 100, 100);
		}

		// Sets specific texts depending on which muscle category was selected
		// If arms
		if (c == 1) {
			muscleCategory.setText("Muscle category: Arms");
			for (int i = 0; i < exerciseTitle.length; i++) {

				exerciseTitle[i].setText(ExerciseTest.exerciseArray[i].getName());
				exerciseTitle[i].setBounds(100, 10 + (i * 150), 450, 200);

				exerciseDescription[i].setFont(textFont);
				exerciseDescription[i].setBackground(new Color(30, 144, 225));
				exerciseDescription[i].setText(ExerciseTest.exerciseArray[i].getDescription());
				exerciseDescription[i].setBounds(100, 140 + (150 * i), 600, 110);
			}

			// If chest
		} else if (c == 2) {

			muscleCategory.setText("Muscle category: Chest");
			for (int i = 0; i < exerciseTitle.length; i++) {

				exerciseTitle[i].setText(ExerciseTest.exerciseArray[i + 3].getName());
				exerciseTitle[i].setBounds(100, 10 + (i * 150), 450, 200);

				exerciseDescription[i].setFont(textFont);
				exerciseDescription[i].setBackground(new Color(30, 144, 225));
				exerciseDescription[i].setText(ExerciseTest.exerciseArray[i + 3].getDescription());
				exerciseDescription[i].setBounds(100, 140 + (150 * i), 600, 110);
			}

			// If shoulders
		} else if (c == 3) {

			muscleCategory.setText("Muscle category: Shoulders");

			for (int i = 0; i < exerciseTitle.length; i++) {

				exerciseTitle[i].setText(ExerciseTest.exerciseArray[i + 10].getName());
				exerciseTitle[i].setBounds(100, 10 + (i * 150), 450, 200);

				exerciseDescription[i].setFont(textFont);
				exerciseDescription[i].setBackground(new Color(30, 144, 225));
				exerciseDescription[i].setText(ExerciseTest.exerciseArray[i + 10].getDescription());
				exerciseDescription[i].setBounds(100, 140 + (150 * i), 600, 110);
			}

			// If legs
		} else if (c == 4) {

			muscleCategory.setText("Muscle category: Legs");

			for (int i = 0; i < exerciseTitle.length; i++) {

				exerciseTitle[i].setText(ExerciseTest.exerciseArray[i + 13].getName());
				exerciseTitle[i].setBounds(100, 10 + (i * 150), 450, 200);

				exerciseDescription[i].setFont(textFont);
				exerciseDescription[i].setBackground(new Color(30, 144, 225));
				exerciseDescription[i].setText(ExerciseTest.exerciseArray[i + 13].getDescription());
				exerciseDescription[i].setBounds(100, 140 + (150 * i), 600, 110);
			}

			// If back
		} else if (c == 5) {

			muscleCategory.setText("Muscle category: Back");

			for (int i = 0; i < exerciseTitle.length; i++) {

				exerciseTitle[i].setText(ExerciseTest.exerciseArray[i + 16].getName());
				exerciseTitle[i].setBounds(100, 10 + (i * 150), 450, 200);

				exerciseDescription[i].setFont(textFont);
				exerciseDescription[i].setBackground(new Color(30, 144, 225));
				exerciseDescription[i].setText(ExerciseTest.exerciseArray[i + 16].getDescription());
				exerciseDescription[i].setBounds(100, 140 + (150 * i), 600, 110);
			}
		}
	}

	/*
	 * Changes exercises (Only if chest was selected)
	 */
	public void randomize() {

		// Array of integers
		ArrayList<Integer> ra = new ArrayList<Integer>();

		// Fills array with numbers
		for (int i = 4; i < 10; i++)
			ra.add(i);

		// Randomizes numbers
		Collections.shuffle(ra);

		int index = 0;

		// Updates labels
		for (int newExercise : ra) {
			if (index < 3) {
				exerciseTitle[index].setText(ExerciseTest.exerciseArray[newExercise].getName());
				exerciseDescription[index].setText(ExerciseTest.exerciseArray[newExercise].getDescription());
				index++;
			} else
				break;
		}
	}

	/*
	 * Starts counting down from a given amount in seconds
	 */
	public void startTimer() {

		// Updates time label
		showTime.setText(String.valueOf(time));

		// If timer reaches to 0
		if (time == 0) {

			// Stops timer
			timer.stop();

			// Hides the time label
			showTime.setVisible(false);

			// Sets the button to start the time to be visible again
			startTime.setVisible(true);

			playSound();

			// Adds the given time to the array of times that holds how long
			// each user
			// worked out a specific exercise
			ExerciseTest.userList.get(findUser()).setTimeArray(muscleGroup, Integer.parseInt(timeInput));
			// System.out.println(Arrays.toString(ExerciseTest.userList.get(findUser()).getTimeArray()));
		} else

			// Decrements one second
			time--;
	}

	/*
	 * Finds the index in the arraylist of user objects that the current user has
	 * 
	 * @return Return an integer of which index the current user is in the array
	 * list
	 */

	public static int findUser() {

		System.out.println("finduser method");

		// Returns index of arraylist
		int user = 0;

		// Cycles through array to find name that matches the current user
		for (int i = 0; i < ExerciseTest.userList.size(); i++) {
			System.out.println(ExerciseTest.userList.get(i).getName());
			System.out.println(UserScreen.currentUser);

			if (ExerciseTest.userList.get(i).getName().equals(UserScreen.currentUser)) {
				System.out.println("found");
				user = i;
			}
		}
		System.out.println(user);
		return user;
	}

	/*
	 * Plays an alarm sound when the timer has completed
	 */
	public void playSound() {
		try {
			
			// Inputs file
			InputStream fileName = new FileInputStream("soundFiles/timerSound.wav");
			AudioStream audioStream = new AudioStream(fileName);
			
			// Plays sound
			AudioPlayer.player.start(audioStream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			// If file is not found
			System.out.println("timerSound.mp3 not found");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/*
	 * Listens to the users' clicks (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	@Override
	public void actionPerformed(ActionEvent event) {

		// Starts timer
		if (event.getSource() == timer) {
			startTimer();
			showTime.setVisible(true);
		}

		// Plays videos of exercises
		else if (event.getSource() == video[0]) {
			new videoPlayer("videos/" + exerciseTitle[0].getText() + ".mp4");
		} else if (event.getSource() == video[1]) {
			new videoPlayer("videos/" + exerciseTitle[1].getText() + ".mp4");
		} else if (event.getSource() == video[2]) {
			new videoPlayer("videos/" + exerciseTitle[2].getText() + ".mp4");
		}

		// Randomizes exercises
		else if (event.getSource() == randomize) {
			randomize();
		}

		// Stops timer
		else if (event.getSource() == stopTime) {
			timer.stop();
			startTime.setVisible(true);
			showTime.setVisible(false);
		}

		// Timer button
		else if (event.getSource() == startTime && timer.isRunning() == false) {

			// Asks user for time
			timeInput = JOptionPane.showInputDialog("Please input a time in seconds");

			// Checks for valid input
			try {
				// Holds input as integer
				time = Integer.parseInt(timeInput);

				// Starts timer
				timer.start();

				// Hides button
				startTime.setVisible(false);

				// Error message if invalid input
			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Invalid input");
			}

		}

		// Goes back to muscle selection
		else if (event.getSource() == back) {
			dispose();
			new MuscleSelection();
		}

	}

	/*
	 * Expanding effect when mouse hovers over button (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == video[0])
			video[0].setBounds(790, 40, 120, 120);

		if (e.getSource() == video[1])
			video[1].setBounds(790, 240, 120, 120);

		if (e.getSource() == video[2])
			video[2].setBounds(790, 440, 120, 120);
	}

	/*
	 * When the user takes their mouse off of the button, the button goes back to
	 * it's original state (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == video[0])
			video[0].setBounds(800, 80, 100, 100);

		if (e.getSource() == video[1])
			video[1].setBounds(800, 280, 100, 100);

		if (e.getSource() == video[2])
			video[2].setBounds(800, 480, 100, 100);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
