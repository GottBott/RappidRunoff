package group2.game;

import java.util.Random;

public class RiverBank {
	Boolean[][] can_place_object;
	public RiverBankObjects[][] objects;
	Boolean[][] permanent_erosion;
	Position position;
	Random rand = new Random();
	int colSize;
	int rowSize;
	double height;
	double width;
	int ID; // 0 = left bank, 1= middle left bank, 2=middle right bank, 3=right
			// bank
	boolean removePoints = false;
	
	public RiverBank(int colSize, int rowSize, Position position, double width,
			double height, int ID) {
		this.colSize = colSize;
		this.rowSize = rowSize;
		this.position = position;
		this.height = height;
		this.width = width;
		this.ID = ID;
		can_place_object = new Boolean[colSize][rowSize];
		permanent_erosion = new Boolean[colSize][rowSize];
		initializeBufferArray();
		objects = new RiverBankObjects[colSize][rowSize];
	}

	public boolean addBuffer(Buffer b, int x, int y) {
		if (objects[x][y] != null) {
			if (objects[x][y].ID == "Erosion") {
				if(objects[x][y].is_permanent){
					return false;
				}
			} else {
				return false;
			}
		}
		objects[x][y] = b;
		double px = position.getXPos();
		double py = position.getYPos();
		px = x == 0 ? px : px + width / 2;
		py = y == 0 ? py : py + height / 2;
		b.position = new Position(px, py);
		b.deployBuffer();
		can_place_object[x][y] = false;
		return true;

	}

	/*
	 * Mason re-did the coordinate mapping to positions (4/14)
	 * 
	 * Mary added a check so the left and right most banks only have one column
	 */
	public Position checkCoordinates(double x, double y) {
		double bankX = position.getXPos();
		double bankY = position.getYPos();
		int px = 0;
		int py = 0;
		if (ID == 1 || ID == 2) {
			if((x >= bankX) && (x <= (bankX + (width / 2)))){
				px = 0;
			}
			if(x >= (bankX + (width / 2)) && (x <= (bankX + width))){
				px = 1;
			}
			if((y >= bankY-.04) && (y <= (bankY + (height / 2)-.04))){
				py = 0;
			}
			if((y >= (bankY + (height / 2)-.04)) && (y <= (bankY + height))){
				py = 1;
			}
			return new Position(px, py);
		} else if (ID == 0 || ID == 3) {
			if((x >= bankX) && (x <= (bankX + width))){
				px = 0;
			}
			if((y >= bankY-.04) && (y <= (bankY + (height / 2)-.04))){
				py = 0;
			}
			if((y >= (bankY + (height / 2)-.04)) && (y <= (bankY + height))){
				py = 1;
			}
			return new Position(px, py);
		}
		return null;

	}

	/*
	 * Mary Checks if click was in range of Bank and which RiverBankObject was
	 * clicked
	 */
	public int checkIfInBank(double x, double y) {
		double bankX = position.getXPos();
		double bankY = position.getYPos();
		return (x >= bankX && x <= (bankX + width) && y >= bankY-.04 && y <= (bankY + height)) ? ID : -1;
	}
	
	public void erode(int x, int y){
		double px = position.getXPos();
		double py = position.getYPos();
		px = x == 0 ? px : px + (width / 2);
		py = y == 0 ? py : py + (height / 2);
		objects[x][y] = new Erosion(this, new Position(px, py));
		can_place_object[x][y] = false;
	}

	public boolean findErode() {
		if (ID == 1 || ID == 2) {
			int x = rand.nextInt(2);
			if (can_place_object[x][0] || can_place_object[x][1]) {
				if(can_place_object[x][1]){
					erode(x, 1);
					return true;
				}else if(permanent_erosion[x][1]){
					erode(x, 0);
					return true;
				}
			}else if(can_place_object[(x + 1)%2][0] || can_place_object[(x + 1)%2][1]){
				x = (x + 1)%2;
				if(can_place_object[x][1]){
					erode(x, 1);
					return true;
				}else if(permanent_erosion[x][1]){
					erode(x, 0);
					return true;
				}
			}
		} else if (ID == 0 || ID == 3) {
			int x = 0;
			if (can_place_object[x][0] || can_place_object[x][1]) {
				if(can_place_object[x][1]){
					erode(x, 1);
					return true;
				}else if(permanent_erosion[x][1]){
					erode(x, 0);
					return true;
				}
			}
		}
		return false;
	}

	public int erosionFactor(int col) {
		int count = can_place_object[col][0] ? 1 : 0;
		count += can_place_object[col][1] ? 1 : 0;
		return count;
	}

	private void initializeBufferArray() {
		for (int i = 0; i < colSize; i++) {
			for (int j = 0; j < rowSize; j++) {
				can_place_object[i][j] = true;
				permanent_erosion[i][j] = false;
			}
		}
	}

	/*
	 * Mary Each call there is a small chance a bank will erode, checks to see
	 * if erosion has become permanent or if a buffer has died
	 */
	public void update() {
		for(int i = 0; i < objects.length ; i++){
			for(int j = 0; j < objects[i].length; j++){
				if(objects[i][j] != null){
					objects[i][j].update();
					if(!objects[i][j].is_alive){
						objects[i][j] = null;
						can_place_object[i][j] = true;
					}
					if(objects[i][j] != null){
						if(objects[i][j].is_permanent){
							permanent_erosion[i][j] = true;
							if (((Erosion)objects[i][j]).removePoints){
								removePoints=true;
								((Erosion)objects[i][j]).removePoints=false;
								((Erosion)objects[i][j]).pointsRemoved=true;
							}
						}
					}
				}
			}
		}
	}
}