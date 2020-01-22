
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphs extends JPanel {
	
	String exercise = "hit";
	
	public Graphs() {
		setBounds(100, 50, 400, 310);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		setLayout(null);
	}
	
	public void drawGraph(int x1, int y1, int x2, int y2, Graphics g) {
		
		g.drawLine(x1, y1, x2, y2);

	}
	
	public void paintComponent(Graphics g) { 
		
		super.paintComponent(g);
		
		g.setColor(Color.black);
		//switch ()
		drawGraph(0, 0, 0, 300, g);
		drawGraph(0, 300, 350, 300,g);
		
		for (int day = 0; day < 7; day++)
		drawGraph(0, 300, day * 70, 4, g);

	}
}
