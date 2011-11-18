package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import model.EditTreeNode;
import model.FileHandler;

@SuppressWarnings("serial")
public class OpenButton extends JButton implements ActionListener {

	private String name;
	private JFileChooser fc;

	public OpenButton(String string) {

		super(string);
		this.name = string;
		this.addActionListener(this);
		this.fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int returnVal = fc.showOpenDialog(OpenButton.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			EditTreeNode newRoot = new EditTreeNode(file.getAbsolutePath());
			newRoot = FileHandler.getFileHandler().createFromRoot(
					newRoot.getFile().getAbsolutePath());
			TreeModel newTreeModel = new DefaultTreeModel(newRoot);
			view.MainView.getMainView().getTree().setModel(newTreeModel);
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
