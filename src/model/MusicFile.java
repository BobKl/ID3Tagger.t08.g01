package model;

import java.io.File;

@SuppressWarnings("serial")
public class MusicFile extends File {

	private ID3Tag tag;
	private boolean hasBeenChanged;

	public MusicFile(String arg0) {
		super(arg0);
		this.tag = new ID3Tag();
		this.setHasBeenChanged(false);
	}

	public ID3Tag getTag() {
		return tag;
	}

	public void setTag(ID3Tag tag) {
		this.tag = tag;
		this.setHasBeenChanged(true);
	}

	public boolean isHasBeenChanged() {
		return hasBeenChanged;
	}

	public void setHasBeenChanged(boolean hasBeenChanged) {
		this.hasBeenChanged = hasBeenChanged;
	}

}
