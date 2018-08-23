package group2.game;

public class Erosion extends RiverBankObjects{

	
	boolean eroding = true;
	long time = 10 * 60;
	int cur_image;
	int updates;
	boolean removePoints = false;
	boolean pointsRemoved = false;
	int erosion_feedback_updates=0;



	Erosion(RiverBank inputBank, Position inputPosition) {
		this.is_permanent = false;
		this.is_alive = true;
		this.ID = "Erosion";
		this.bank = inputBank;
		this.position = inputPosition;
		System.out.println("erode at " + position.getXPos() + "," + position.getYPos());
			position.width = .06;
			position.height = .1;

	}
	
	public void update(){
		if(eroding){
			time--;
		}
		if(time < 0 && !pointsRemoved){
			is_permanent = true;
			removePoints=true;
		}
		updates++;
		if (updates%10==0)
			cur_image=(cur_image+1)%7;
	}
	

}