package model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * example File for testing ID3-Tagger, extends {@link DefaultMutableTreeNode}
 * implements {@link MutableTreeNode}
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */
@SuppressWarnings("serial")
public class EditTreeNode extends DefaultMutableTreeNode implements
		MutableTreeNode {

	private String filePath;
	private MusicFile file;

	/**
	 * Constructor
	 * 
	 * @param filepath
	 */
	public EditTreeNode(String filepath) {

		this.filePath = filepath;
		this.file = new MusicFile(filePath);

	}

	public MusicFile getFile() {

		return file;
	}

	public String getFilePath() {

		return filePath;
	}

	@Override
	public String toString() {

		return file.getName();
	}
}
