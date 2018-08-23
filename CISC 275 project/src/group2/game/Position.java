package group2.game;

/**
 * Stefan 4/2/13
 */
public class Position {
	double x;
	double y;
	double width;
	double height;

	Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		if (((Position) other).x == this.x && ((Position) other).y == this.y)
			return true;
		else
			return false;
	}

	public double getXPos() {
		return x;
	}

	public double getYPos() {
		return y;
	}

	@Override
	public int hashCode() {
		return 0;

	}

	public void setPosition(double x_new, double y_new) {
		x = x_new;
		y = y_new;

	}
}