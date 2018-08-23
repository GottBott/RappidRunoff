package group2.game;

import java.awt.Image;
import java.util.ArrayList;

// Ben Gotthold
//4/3
//this defines the class for the side menus they have a 
// position and a height and width and a function to add a
// bin

public class Menu {

	ArrayList<MenuObject> menu_objects;

	Position position;
	Image bin_image;
	Bin bin;

	public Menu(Position p, Image image) {
		this.menu_objects = new ArrayList<MenuObject>();
		this.position = p;
		position.width = (1.0 / 11);
		position.height = (1.0 / 2);
		this.bin_image = image;
		addBin();

	}

	public void addBin() {
		menu_objects = new ArrayList<MenuObject>();
		bin = new Bin(new Position(position.x + 1.0 / 5000, position.y * 2.9));
		menu_objects.add(bin);

	}

}
