package group2.game;

public class Buffer extends RiverBankObjects {

	Boolean currently_clicked;
	Boolean is_clicked = false;
	Boolean ready = true;
	String text = "Buffer";
	Position position;
	static public Position menu_position = new Position((1.0 / 60), (11.0 / 30));
	double menu_width = .08;
	double menu_height=.12;
	long time = 20 * 60;

	Buffer() {
		this.position = menu_position;
		this.position.width = menu_width;
		this.position.height = menu_height;
		this.ID = "Buffer";
		this.is_alive = false;
		this.is_permanent = false;
	}

	public boolean checkIfInBuffer(double x, double y) {
		return x >= position.x && x <= position.x + this.position.width && y >= position.y
				&& y <= position.y + this.position.height;

	}

	public void deployBuffer() {
		is_alive = true;
		ready = false;
	}
	
	public void update(){
		if(is_alive){
			time--;
		}
		if(time < 0){
			is_alive = false;
		}
	}
}
