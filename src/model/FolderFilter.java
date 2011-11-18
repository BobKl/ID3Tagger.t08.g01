package model;

import java.io.File;
import java.io.FileFilter;

public class FolderFilter implements FileFilter {

	@Override
	public boolean accept(File dir) {

		return dir.isDirectory();
	}

}
