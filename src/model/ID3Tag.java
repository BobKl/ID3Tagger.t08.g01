package model;

public class ID3Tag {

	private String title;
	private String artist;
	private String album;
	private String year;
	private byte[] cover;

	/**
	 * sets tags of ID3Tag
	 * 
	 * @param setTitle
	 *            boolean if title is to be set
	 * @param title
	 *            String name of title of ID3Tag
	 * @param setArtist
	 *            boolean if album is to be set
	 * @param artist
	 *            String name of artist of ID3Tag
	 * @param setAlbum
	 *            boolean if album is to be set
	 * @param album
	 *            String name of album of ID3Tag
	 * @param setYear
	 *            boolean if year is to be set
	 * @param year
	 *            String number of year of ID3Tag
	 * @param setcover
	 *            boolean if cover is to be set
	 * @param cover
	 *            byte[] of cover of ID3Tag
	 */
	public void setTag(boolean setTitle, String title, boolean setArtist,
			String artist, boolean setAlbum, String album, boolean setYear,
			String year, boolean setcover, byte[] cover) {
		if (setTitle) {
			this.setTitle(title);
		}
		if (setArtist) {
			this.setArtist(artist);
		}
		if (setAlbum) {
			this.setAlbum(album);
		}
		if (setYear) {
			this.setYear(year);
		}
		if (setcover) {
			this.setCover(cover);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

}
