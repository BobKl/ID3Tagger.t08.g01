package view;

import info.clearthought.layout.TableLayout;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

import control.EditComponent;

public class TestView {

	private static TestView testView = new TestView();

	private JFrame slimWindow;
	private EditComponent titleComp;
	private EditComponent artistComp;
	private EditComponent albumComp;
	private EditComponent yearComp;
	// private CoverComponent coverViewer;
	private JLabel filePathPanel;
	private JButton openButton;
	private boolean editingEnabled;

	public void initialize() {
		setup();
		draw();
	}

	private void setup() {

		slimWindow = new JFrame();
		slimWindow.setSize(view.ViewConstants.FRAME_WIDTH * 3 / 4,
				view.ViewConstants.FRAME_HEIGHT / 2);

		Container slimWindowPane = slimWindow.getContentPane();
		int labelHeight = 20;
		int buttonHeight = 30;
		double[][] frameTableSize = {
				// Rows
				{ 0.5, 0.5 },
				// Columns
				{ labelHeight, labelHeight, labelHeight, labelHeight,
						labelHeight, buttonHeight, TableLayout.PREFERRED } };
		slimWindowPane.setLayout(new TableLayout(frameTableSize));

		filePathPanel = new JLabel("Hier wird der Dateipfad stehen...");
		setTitleComp(new EditComponent(view.ViewConstants.TAGS[0]));
		setArtistComp(new EditComponent(view.ViewConstants.TAGS[1]));
		setAlbumComp(new EditComponent(view.ViewConstants.TAGS[2]));
		setYearComp(new EditComponent(view.ViewConstants.TAGS[3]));
		titleComp.getTextField().setEditable(isEditingEnabled());
		artistComp.getTextField().setEditable(isEditingEnabled());
		albumComp.getTextField().setEditable(isEditingEnabled());
		yearComp.getTextField().setEditable(isEditingEnabled());

		openButton = new SlimOpenButton("Open");
	}

	private void draw() {

		Container slimWindowPane = slimWindow.getContentPane();

		slimWindowPane.add(filePathPanel, "0,0,1,0");
		slimWindowPane.add(titleComp.getLabel(), "0,1");
		slimWindowPane.add(titleComp.getTextField(), "1,1");
		slimWindowPane.add(artistComp.getLabel(), "0,2");
		slimWindowPane.add(artistComp.getTextField(), "1,2");
		slimWindowPane.add(albumComp.getLabel(), "0,3");
		slimWindowPane.add(albumComp.getTextField(), "1,3");
		slimWindowPane.add(yearComp.getLabel(), "0,4");
		slimWindowPane.add(yearComp.getTextField(), "1,4");

		slimWindowPane.add(openButton, "0,5");

		slimWindow.setVisible(true);
		slimWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public EditComponent getTitleComp() {
		return titleComp;
	}

	public void setTitleComp(EditComponent titleComp) {
		this.titleComp = titleComp;
	}

	public EditComponent getArtistComp() {
		return artistComp;
	}

	public void setArtistComp(EditComponent artistComp) {
		this.artistComp = artistComp;
	}

	public EditComponent getAlbumComp() {
		return albumComp;
	}

	public void setAlbumComp(EditComponent albumComp) {
		this.albumComp = albumComp;
	}

	public EditComponent getYearComp() {
		return yearComp;
	}

	public void setYearComp(EditComponent yearComp) {
		this.yearComp = yearComp;
	}

	public JLabel getFilePathPanel() {
		return filePathPanel;
	}

	public void setFilePathPanel(JLabel filePathPanel) {
		this.filePathPanel = filePathPanel;
	}

	public static TestView getTestView() {
		return testView;
	}

	public boolean isEditingEnabled() {
		return editingEnabled;
	}

	public void setEditingEnabled(boolean editingEnabled) {
		this.editingEnabled = editingEnabled;
	}

}

@SuppressWarnings("serial")
class SlimOpenButton extends JButton implements MouseListener {

	private JFileChooser fileChooser;

	public SlimOpenButton(String string) {

		super(string);
		this.addMouseListener(this);
		this.fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Filter allows directories and mp3s only.";
			}

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".mp3") || f.isDirectory();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int returnVal = fileChooser.showOpenDialog(SlimOpenButton.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			TestView.getTestView().getFilePathPanel().setText(file.getPath());
			// ID3Tag tag = MusicFileIO.getMusicFileIO().parseFileToID3(file);
			// TestView.getTestView().getTitleComp().getTextField().setText(tag.getTitle());
			// TestView.getTestView().getArtistComp().getTextField().setText(tag.getArtist());
			// TestView.getTestView().getAlbumComp().getTextField().setText(tag.getAlbum());
			// TestView.getTestView().getYearComp().getTextField().setText(tag.getYear());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}