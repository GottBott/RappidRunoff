package group2.game;

/**
 * Stefan 4/2/13
 */
public class Player {

	ScoreData player_data;
	int players_rank;
	Score player_score = new Score(0, 0, 0, 0, 0);
	RapidRunoffGame game;
	
	public Player(RapidRunoffGame game){
		this.game = game;
	}

	public void addScoreDataToList(String name, String date) {
		player_data = new ScoreData(name, player_score.game_score, date, game.arcademode);
		player_data.addDataToList();
	}

	public int get_players_rank() {
		players_rank = player_data.getRank();
		return players_rank;
	}

}
