package group2.game;

/**
 * Mary 4/4/13
 */
public class Funnel extends PowerUp {

	Funnel(Position position) {
		super(position);

		text = "FUNNEL";
		image = DrawGame.Funnel;
		effect_string1 = "requiring citizens to correctly dispose of oil!";
		effect_string2 = "Runoff will be free of oil for 10 seconds.";
	}

}
