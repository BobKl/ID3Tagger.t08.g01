import java.io.File;
import java.io.IOException;

/**
 * entry point for the ID3-Tagging-Application
 * 
 * @author Patrick Flakus, Maria Kleppisch
 * @version 1.0
 */
public class ProjectMain {

	/**
	 * main method starts the Application
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

//		 view.MainView.getMainView().initialize();

		System.out.println(model.MusicFileIO.getMusicFileIO().parseFileToID3(new File(view.ViewConstants.FILE_PATH2+ File.separator + "Animals are people too" + File.separator + "01_Turtle.mp3")));
		
		// view.TestView.getTestView().setEditingEnabled(false);
		// view.TestView.getTestView().initialize();
	}

}
