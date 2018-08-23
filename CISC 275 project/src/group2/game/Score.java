package group2.game;

/**
 * Joe 4/2/13
 */
public class Score {
	int game_score;

	// these may be better in a different class
	int oil_count;
	int fertilizer_count;
	int oil_lost;
	int fertilizer_lost;

	public Score(int game_score, int oil_count, int fertilizer_count,
			int oil_lost, int fertilizer_lost) {
		this.game_score = game_score;
		this.oil_count = oil_count;
		this.fertilizer_count = fertilizer_count;
		this.oil_lost = oil_lost;
		this.fertilizer_lost = fertilizer_lost;
	}

	public void addScore(int s) {
		game_score += s;
		game_score = game_score < 0 ? 0 : game_score;
	}

	public void incrementFertilizer() {
		fertilizer_count++;
	}

	public void incrementFertilizerLost() {
		fertilizer_lost++;
	}

	public void incrementOil() {
		oil_count++;
	}

	public void incrementOilLost() {
		oil_lost++;
	}
}