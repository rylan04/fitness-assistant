
import java.awt.*;
import javax.swing.*;
import com.sun.jna.*;
import uk.co.caprica.vlcj.binding.*;
import uk.co.caprica.vlcj.player.*;
import uk.co.caprica.vlcj.player.embedded.*;
import uk.co.caprica.vlcj.player.embedded.windows.*;
import uk.co.caprica.vlcj.runtime.*;

/* @author Rylan Sykes 
 * Creates a frame to play a video of a selected exercise
 */

public class videoPlayer {

	/*
	 * Constructor method
	 * @param name The directory of the video that is going to be played
	 */
	public videoPlayer(String name) {

		// Makes frame
		JFrame videoFrame = new JFrame();
		videoFrame.setLocation(100, 100);
		videoFrame.setSize(900, 900);
		videoFrame.setVisible(true);
		videoFrame.setResizable(false);

		// Makes background canvas
		Canvas videoCanvas = new Canvas();
		videoCanvas.setBackground(Color.BLACK);
		JPanel videoPanel = new JPanel();
		videoPanel.setLayout(new BorderLayout());
		videoPanel.add(videoCanvas);
		videoFrame.add(videoPanel);

		// Uses VLC media player
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "vlc");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

		// Media player object
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		EmbeddedMediaPlayer videoPlayer = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(videoFrame));
		videoPlayer.setVideoSurface(mpf.newVideoSurface(videoCanvas));
		videoPlayer.setEnableKeyInputHandling(false);

		// Name of exercise
		String file = name;
		videoPlayer.prepareMedia(file);

		// Plays video
		videoPlayer.play();

		// Listens to users clicks
		videoFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			/*
			 * If user clicks the close button (non-Javadoc)
			 * 
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Stop playing video
				videoPlayer.stop();
			}

		});

	}
}
