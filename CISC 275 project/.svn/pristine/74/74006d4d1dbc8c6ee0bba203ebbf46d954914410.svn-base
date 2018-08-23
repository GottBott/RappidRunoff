package group2.game;

import java.awt.Color;

/**
 * Joe 4/2/13
 */
public class Fertilizer extends WaterObjects {

	public Fertilizer(Position p, RapidRunoffGame g, int s) {
		super(p, g, s);
		this.color = Color.GREEN;
		this.bin = game.map.fert_menu.bin;
		image = DrawGame.FertImage;
		this.id = "f";

	}

	@Override
	public void update() {
		super.update();

		if (position.getXPos() > 1.0) {
			is_alive = false;
			remove(false);
			if(!addedtocount){
				game.player.player_score.incrementFertilizerLost();
				System.out.println(game.player.player_score.fertilizer_lost
						+ " Fertilizer lost so far.");
				addedtocount = true;
			}
		}
	}

	public void increment() {
		game.player.player_score.incrementFertilizer();
	}
}