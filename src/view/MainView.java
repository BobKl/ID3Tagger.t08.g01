package view;

import info.clearthought.layout.TableLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import control.CoverComponent;
import control.DiscardButton;
import control.EditComponent;
import control.OpenButton;
import control.SaveButton;
import control.TreeListener;

import model.EditTreeNode;
import resources.TestImages;

/**
 * this class constructs the MainView of the ID3-Tagger
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */
public class MainView {

	private static MainView mainView = new MainView();

	private JFrame window;
	private JScrollPane scroll;
	private JTree tree;

	private JPanel editPane;
	private EditComponent titleComponent;
	private EditComponent artistComponent;
	private EditComponent albumComponent;
	private EditComponent yearComponent;
	private CoverComponent coverViewer;

	private JPanel menuPane;
	private JButton openButton;
	private JButton saveButton;
	private JButton discardButton;

	/**
	 * initializes the MainView
	 */
	public void initialize() {
		setup();
		draw();

	}

	private void setup() {
		int width = view.ViewConstants.FRAME_WIDTH;
		int height = view.ViewConstants.FRAME_HEIGHT;

		window = new JFrame();
		window.setSize(width, height);

		EditTreeNode root = model.FileHandler.getFileHandler().createFromRoot(
				view.ViewConstants.FILE_PATH);
		setTree(new JTree(root));
		getTree().setEditable(true);
		getTree().addTreeSelectionListener(new TreeListener());

		// add tree to scroll panel to framePane
		scroll = new JScrollPane(getTree());
		scroll.setPreferredSize(new Dimension(240, height));

		// add southern panel with buttons to framePane
		menuPane = new JPanel();
		menuPane.setSize(width, 40);
		menuPane.setLayout(new GridLayout(1, 3));
		this.openButton = new OpenButton("Open");
		this.saveButton = new SaveButton("Save");
		this.discardButton = new DiscardButton("Discard");

		editPane = new JPanel();

		int space = 10;
		int textHeight = 20;
		double size[][] = {
				// Columns
				{ space, 0.5, space, 0.5, space },
				// Rows
				{ space, textHeight, textHeight, space, textHeight, textHeight,
						space, textHeight, textHeight, TableLayout.PREFERRED,
						space } };

		getTree().setBackground(Color.orange);
		editPane.setBackground(Color.pink);
		editPane.setLayout(new TableLayout(size));

		this.titleComponent = new EditComponent(view.ViewConstants.TAGS[0]);
		this.artistComponent = new EditComponent(view.ViewConstants.TAGS[1]);
		this.albumComponent = new EditComponent(view.ViewConstants.TAGS[2]);
		this.yearComponent = new EditComponent(view.ViewConstants.TAGS[3]);
		this.coverViewer = new CoverComponent(TestImages.png);

	}

	private void draw() {

		menuPane.add(this.openButton);
		menuPane.add(this.saveButton);
		menuPane.add(this.discardButton);
		window.getContentPane().add(menuPane, BorderLayout.SOUTH);

		window.getContentPane().add(scroll, BorderLayout.WEST);

		editPane.add(this.titleComponent.getLabel(), "1,1,3,1");
		editPane.add(this.titleComponent.getTextField(), "1,2,3,2");
		editPane.add(this.artistComponent.getLabel(), "1,4");
		editPane.add(this.artistComponent.getTextField(), "1,5");
		editPane.add(this.albumComponent.getLabel(), "3,4");
		editPane.add(this.albumComponent.getTextField(), "3,5");
		editPane.add(this.yearComponent.getLabel(), "3,7");
		editPane.add(this.yearComponent.getTextField(), "3,8");
		editPane.add(this.coverViewer, "1,7,1,9");
		window.getContentPane().add(editPane, BorderLayout.CENTER);

		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * private static return mainView
	 * 
	 * @return mainView
	 */
	public static MainView getMainView() {

		return mainView;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * returns EditCompnent containing title information
	 * 
	 * @return titelComponent
	 */
	public JTree getTree() {
		return tree;
	}

	/**
	 * sets private this.tree to tree
	 * 
	 * @param tree
	 */
	public void setTree(JTree tree) {
		this.tree = tree;
	}

	/**
	 * returns EditCompnent containing title information
	 * 
	 * @return titelComponent
	 */
	public EditComponent getTitleComponent() {

		return titleComponent;
	}

	/**
	 * returns EditCompnent containing artist information
	 * 
	 * @return artistComponent
	 */
	public EditComponent getArtistComponent() {

		return artistComponent;
	}

	/**
	 * returns EditCompnent containing album information
	 * 
	 * @return albumComponent
	 */
	public EditComponent getAlbumComponent() {

		return albumComponent;
	}

	/**
	 * returns EditCompnent containing year information
	 * 
	 * @return yearlComponent
	 */
	public EditComponent getYearComponent() {

		return yearComponent;
	}

	/**
	 * returns JLabel containing cover
	 * 
	 * @return coverViewer
	 */
	public CoverComponent getCoverViewer() {

		return coverViewer;
	}

}
