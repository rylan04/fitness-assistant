
import java.text.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;

/* @author Rylan Sykes
 * TimeChart class - Creates a visual pie chart that a user can use to find the distribution of how much time they spend exercising each muscle group
 */

public class TimeDistributionChart {

	/*
	 * Constructor method
	 */

	public TimeDistributionChart() {

		// Creates pie chart
		createPieChart();
	}

	/*
	 * Displays pie chart
	 */
	public void createPieChart() {

		// Holds values that will be graphed
		DefaultPieDataset pieDataset = new DefaultPieDataset();

		// Gets data through user objects
		pieDataset.setValue("ARMS",
				Math.ceil((ExerciseTest.userList.get(ExerciseScreen.findUser()).getTimeArray(1)) / 60));
		pieDataset.setValue("CHEST",
				Math.ceil((ExerciseTest.userList.get(ExerciseScreen.findUser()).getTimeArray(2)) / 60));
		pieDataset.setValue("SHOULDERS",
				Math.ceil((ExerciseTest.userList.get(ExerciseScreen.findUser()).getTimeArray(3)) / 60));
		pieDataset.setValue("LEGS",
				Math.ceil((ExerciseTest.userList.get(ExerciseScreen.findUser()).getTimeArray(4)) / 60));
		pieDataset.setValue("BACK",
				Math.ceil((ExerciseTest.userList.get(ExerciseScreen.findUser()).getTimeArray(5)) / 60));

		// API creating chart
		JFreeChart timeChart = ChartFactory
				.createPieChart("Time distribution of exercises for " + UserScreen.currentUser, pieDataset);

		PiePlot plotGraph = (PiePlot) timeChart.getPlot();

		// Creates a frame to display chart on
		ChartFrame graphFrame = new ChartFrame("Time distribution pie chart", timeChart);

		/*
		 * Shows labels on the sections and displays how much time and the percentage of
		 * each muscle group
		 */
		PieSectionLabelGenerator sectionValue = new StandardPieSectionLabelGenerator("{0}: {1} MINUTES ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		plotGraph.setLabelGenerator(sectionValue);

		graphFrame.setSize(700, 700);
		graphFrame.setResizable(false);
		graphFrame.setVisible(true);

	}

}
