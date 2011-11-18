package control;

import javax.swing.ImageIcon;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainView;

import model.EditTreeNode;
import model.MusicFile;

/**
 * TreeSelectionListener recognizes changes in selection of a JTree, implements
 * {@link TreeSelectionListener}
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */
public class TreeListener implements TreeSelectionListener {

	private EditTreeNode prevFile;
	private EditTreeNode currFile;

	@Override
	/**
	 * sets ID3 information of currently selected file in 
	 * tree of view.MainView.mainView in the TextFields of
	 * the corresponding EditComponents
	 */
	public void valueChanged(TreeSelectionEvent e) {

		MainView mView = view.MainView.getMainView();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) mView.getTree()
				.getLastSelectedPathComponent();
		if (node.isLeaf()) {

			EditTreeNode eNode = (EditTreeNode) node;
			MusicFile nFile = eNode.getFile();

			this.setPrevFile(this.getCurrFile());
			// TODO if former currFile existed, save all fields(needs to be
			// changed)
			if (this.getPrevFile() != null)
				model.MainModel.getMainModel().saveAllFields();
			this.setCurrFile(eNode);

			// get all tags and set to textFields
			mView.getTitleComponent().getTextField()
					.setText(nFile.getTag().getTitle());
			mView.getArtistComponent().getTextField()
					.setText(nFile.getTag().getArtist());
			mView.getAlbumComponent().getTextField()
					.setText(nFile.getTag().getAlbum());
			mView.getYearComponent().getTextField()
					.setText(nFile.getTag().getYear());
			if (nFile.getTag().getCover() != null) {
				System.out.println("cover exists");
				mView.getCoverViewer().setIcon(
						new ImageIcon(nFile.getTag().getCover()));
			}

		}
	}

	public EditTreeNode getPrevFile() {
		return prevFile;
	}

	public void setPrevFile(EditTreeNode prevFile) {
		this.prevFile = prevFile;
	}

	public EditTreeNode getCurrFile() {
		return currFile;
	}

	public void setCurrFile(EditTreeNode currFile) {
		this.currFile = currFile;
	}

}
