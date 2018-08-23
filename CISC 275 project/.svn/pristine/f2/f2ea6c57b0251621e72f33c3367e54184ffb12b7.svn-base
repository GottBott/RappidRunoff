package group2.game;

import java.awt.Image;

public class Bin extends MenuObject {

	Image bin_image;
	Position position;

	public Bin(Position p) {
		super(p);
		this.position = p;
		p.height = .125;
		p.width = .125;
	}

	public boolean checkIfInBin(double x, double y) {
		return x >= position.x && x <= position.x + position.width
				&& y >= position.y && y <= position.y + position.height;
	}
}
