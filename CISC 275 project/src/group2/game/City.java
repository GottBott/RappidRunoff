package group2.game;

import java.awt.Image;
import java.util.Random;

//Ben Gotthold
// 5/1

public class City {
	RapidRunoffGame game;

	Random generator = new Random();
	int update_count = 0;
	public Image[] buildings = { null, null, null, null, null, null, null };
	public Image[][] clouds = {
			{ null, null, null, null, null, null, null, null, null, null },
			{ null, null, null, null, null, null, null, null, null, null } };

	public Image cloudL;
	public Image cloudCL;
	public Image cloudCR;
	public Image cloudCLS;
	public Image cloudCRS;
	public Image cloudR;
	public Image city1;
	public Image city2;

	public City(RapidRunoffGame game) {
		this.game = game;

		this.cloudL = DrawGame.cloudL;
		this.cloudCL = DrawGame.cloudCL;
		this.cloudCR = DrawGame.cloudCR;
		this.cloudCLS = DrawGame.cloudCLS;
		this.cloudCRS = DrawGame.cloudCRS;
		this.cloudR = DrawGame.cloudR;
		this.city1 = DrawGame.city1;
		this.city2 = DrawGame.city2;

	}

	public void update() {
		update_count++;

		if (update_count > 10) {
			update_count = 0;
			// increase in strike results in less lightning strikes
			int strike = generator.nextInt(15) + 1;
			int random_index = generator.nextInt(9) + 1;

			if (game.game_time % (strike) == 0) {
				if (clouds[0][random_index] != null) {
					clouds[0][random_index] = clouds[1][random_index];
					updateClouds();
					clouds[0][random_index] = clouds[1][random_index];

				}
			}

			else {
				updateClouds();

			}
		}

	}

	public void updateClouds() {
		if (game.game_time < 120000) {

			clouds[0][3] = cloudL;
			clouds[0][4] = cloudCL;
			clouds[0][5] = cloudCR;
			clouds[0][6] = cloudR;

			clouds[1][3] = cloudL;
			clouds[1][4] = cloudCLS;
			clouds[1][5] = cloudCRS;
			clouds[1][6] = cloudR;

			buildings[3] = city1;

		}

		if (game.game_time < 90000) {

			clouds[0][2] = cloudL;
			clouds[0][3] = cloudCL;
			clouds[0][6] = cloudCR;
			clouds[0][7] = cloudR;

			clouds[1][2] = cloudL;
			clouds[1][3] = cloudCLS;
			clouds[1][6] = cloudCRS;
			clouds[1][7] = cloudR;

			buildings[2] = city2;
			buildings[4] = city2;
		}

		if (game.game_time < 60000) {

			clouds[0][1] = cloudL;
			clouds[0][2] = cloudCL;
			clouds[0][7] = cloudCR;
			clouds[0][8] = cloudR;

			clouds[1][1] = cloudL;
			clouds[1][2] = cloudCLS;
			clouds[1][7] = cloudCRS;
			clouds[1][8] = cloudR;

			buildings[1] = city1;
			buildings[5] = city1;

		}

		if (game.game_time < 30000) {

			clouds[0][0] = cloudL;
			clouds[0][1] = cloudCL;
			clouds[0][8] = cloudCR;
			clouds[0][9] = cloudR;

			clouds[1][0] = cloudL;
			clouds[1][1] = cloudCLS;
			clouds[1][8] = cloudCRS;
			clouds[1][9] = cloudR;

			buildings[0] = city2;
			buildings[6] = city2;
		}
	}
}
