package group2.game;

/**
 * Mary 4/4/13
 */
public class Broom extends PowerUp {

	Broom(Position position) {
		super(position);

		text = "BROOM";
		image = DrawGame.Broom;
		effect_string1 = "requiring citizens to properly fertilize their lawns!";
		effect_string2 = "Runoff will be free of fertilizer for 10 seconds.";
	}

}
