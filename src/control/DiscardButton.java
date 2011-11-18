package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DiscardButton extends JButton implements ActionListener {

	private String name;

	public DiscardButton(String string) {
		super(string);
		this.name = string;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this) {
			System.out.println(this.getName() + "-Button geklickt");
		}
	}

	@Override
	public String getName() {
		return this.name;
	}
}
