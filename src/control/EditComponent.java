package control;

import java.awt.event.FocusEvent;

import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This Class describes Components that an be edited and edit the Files. It
 * implements {@link FocusListener}, {@link KeyListener}
 * 
 * @author Patrick Flakus, Maria Kleppisch
 */

public class EditComponent implements FocusListener, KeyListener {

	private String name;
	private JLabel label;
	private JTextField textField;

	/**
	 * Constructor of EditCompnent
	 * 
	 * @param name
	 *            description of what can be edited in this EditComponet and
	 *            content of label
	 */
	public EditComponent(String name) {

		super();
		this.name = name;
		this.label = new JLabel(name);
		this.textField = new JTextField("Hier den " + name + " einfügen...");
		this.textField.addKeyListener(this);
		this.textField.addFocusListener(this);
	}

	/**
	 * @return label
	 */
	public JLabel getLabel() {

		return label;
	}

	/**
	 * @return textField
	 */

	public JTextField getTextField() {

		return textField;
	}

	/**
	 * @return name
	 */
	public String getName() {

		return name;
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	/**
	 * if enter-key is released setFieldValue(this) in MainModel is invoked
	 */
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			model.MainModel.getMainModel().setFieldValue(this);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	/**
	 * if EditCompenent loses Focus setFieldValue(this) in MainModel is invoked
	 */
	public void focusLost(FocusEvent e) {

	}

}
