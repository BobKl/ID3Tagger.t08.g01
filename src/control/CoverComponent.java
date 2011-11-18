package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CoverComponent extends JLabel implements MouseListener {

	private byte[] cover;

	public CoverComponent(byte[] cover) {
		super(new ImageIcon(cover));
		this.cover = cover;
		this.addMouseListener(this);
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
		this.setIcon(new ImageIcon(cover));
	}

	public byte[] getCover() {
		return cover;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO FileChooser Dialog

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
