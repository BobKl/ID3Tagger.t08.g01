package model;

import java.io.File;

/**
 * Creates example Files, Folder so they can test ID3-Tagger
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */
public class FileHandler {

	private static FileHandler fileHandler = new FileHandler();

	/**
	 * @return fileHandler
	 */
	public static FileHandler getFileHandler() {

		return fileHandler;
	}

	/**
	 * creates example directories for root
	 * 
	 * @param root
	 */
	public EditTreeNode createFromRoot(String path) {

		EditTreeNode root = new EditTreeNode(path);
		addAllChildren(root);
		return root;
	}

	private void addAllChildren(EditTreeNode node) {

		if (node.getFile().isDirectory()) {
			File[] folderList = node.getFile().listFiles(new FolderFilter());
			File[] mp3List = node.getFile().listFiles(new MP3Filter());

			File[] list = new File[folderList.length + mp3List.length];
			for (int i = 0; i < list.length; i++) {
				if (i < folderList.length)
					list[i] = folderList[i];
				else
					list[i] = mp3List[i - folderList.length];
			}
			EditTreeNode nNode;
			for (int i = 0; i < list.length; i++) {
				nNode = new EditTreeNode(list[i].getAbsolutePath());
				node.add(nNode);
				addAllChildren(nNode);
			}
		}
	}

}
