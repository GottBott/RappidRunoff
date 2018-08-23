package group2.game;

import java.awt.Color;

/**
 * Joe 4/2/13
 */
public class Oil extends WaterObjects {

	public Oil(Position p, RapidRunoffGame g, int s) {
		super(p, g, s);
		this.color = Color.BLACK;
		this.bin = game.map.oil_menu.bin;
		image = DrawGame.OilImage;
		this.id = "o";

	}

	@Override
	public void update() {
		super.update();

		if (position.getXPos() > 1.0) {
			is_alive = false;
			remove(false);
			if(!addedtocount){
				game.player.player_score.incrementOilLost();
				System.out.println(game.player.player_score.oil_lost
						+ " Oil lost so far.");
				addedtocount = true;
			}
		}
	}

	public void increment() {
		game.player.player_score.incrementOil();
	}

}