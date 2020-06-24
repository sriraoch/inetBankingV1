package recordingtests;


import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recorder extends ScreenRecorder {

	private static ScreenRecorder screenRecorder;
	private static String name;
	public Recorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
		this.name=name;
		Log.info("Test Case name in Constructor: "+this.name);
	}

	@Override
    protected File createMovieFile(Format fileFormat) throws IOException {
          if (!movieFolder.exists()) {
                movieFolder.mkdirs();
          } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
          }                           
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");                       
          return new File(movieFolder, this.name + "-" + dateFormat.format(new Date()) + "."+ Registry.getInstance().getExtension(fileFormat));
    }
	
	public static void startRecording(String testCaseName) {
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice()
				.getDefaultConfiguration();

		try {
			screenRecorder = new Recorder(gc, gc.getBounds(),new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),QualityKey, 1.0f,	KeyFrameIntervalKey, (int) (15 * 60)),
					new Format(MediaTypeKey, MediaType.VIDEO,EncodingKey,"black",FrameRateKey, Rational.valueOf(30)),null, 
					new File(ConstantsFile.videoRecordingFolder),testCaseName);	
			screenRecorder.start();
		}catch (IOException e) {
			Log.info("IOException has occured while recording.");
		} catch (AWTException e) {
			Log.info("AWTException has occured while recording.");
		}
		
	}

	public static void stopRecording() {
		try {
			Log.info("Test Case name in stop recorder: "+name);
			screenRecorder.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}