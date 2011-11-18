package model;

import control.CoverComponent;
import control.EditComponent;
import control.TreeListener;

/**
 * model of ID3-Tagger
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */
public class MainModel {

	private static MainModel mainModel = new MainModel();

	/**
	 * @return mainModel
	 */
	public static MainModel getMainModel() {

		return mainModel;
	}

	private TreeListener treeListener = ((TreeListener) view.MainView
			.getMainView().getTree().getTreeSelectionListeners()[0]);

	/**
	 * sets the field value of given EditComponent eC overwrites chosen field in
	 * currently selected file with content of textField in eC
	 * 
	 * @param eC
	 */
	public void setFieldValue(EditComponent eC) {

		MusicFile cFile = treeListener.getCurrFile().getFile();
		String textFieldContent = eC.getTextField().getText();
		if (eC.getName() == view.ViewConstants.TAGS[0])
			cFile.getTag().setTitle(textFieldContent);
		if (eC.getName() == view.ViewConstants.TAGS[1])
			cFile.getTag().setArtist(textFieldContent);
		if (eC.getName() == view.ViewConstants.TAGS[2])
			cFile.getTag().setAlbum(textFieldContent);
		if (eC.getName() == view.ViewConstants.TAGS[3])
			cFile.getTag().setYear(textFieldContent);
	}

	public void setCoverValue(CoverComponent cC) {

		MusicFile cFile = treeListener.getCurrFile().getFile();
		cFile.getTag().setCover(cC.getCover());
	}

	/**
	 * sets every current field value of selected file to the text in the
	 * TextField of the corresponding EditComponent
	 */
	public void saveAllFields() {

		setFieldValue(view.MainView.getMainView().getTitleComponent());
		setFieldValue(view.MainView.getMainView().getArtistComponent());
		setFieldValue(view.MainView.getMainView().getAlbumComponent());
		setFieldValue(view.MainView.getMainView().getYearComponent());
		// setCoverValue(view.MainView.getMainView().getCoverViewer());
	}

}
