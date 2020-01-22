import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphGUI extends JFrame {

	private Graphs drawSpace;
	private JPanel mainJPanel = new JPanel();
	
	JLabel eTitle = new JLabel("Enter your exercise");
	JLabel wTitle = new JLabel("Weight");
	JLabel dTitle = new JLabel("Day");
	
	public GraphGUI() {
		
		super("Graphs");
		
		setSize(700, 600);
		setVisible(true);
		setLayout(null);
		
		drawSpace = new Graphs();
		
		
		mainJPanel.add(drawSpace);
		mainJPanel.setBounds(0,0,700,600);
		mainJPanel.setBackground(Color.WHITE);
		mainJPanel.setVisible(true);
		mainJPanel.setLayout(null);
		add(mainJPanel);
		
		mainJPanel.add(eTitle);
		eTitle.setBounds(250, 10, 200, 20);
		
		mainJPanel.add(wTitle);
		wTitle.setBounds(20, 220, 200, 20);
		
		mainJPanel.add(dTitle);
		dTitle.setBounds(250, 365, 200, 20);
	
	
		
		
		
	}
	
	
	
}
