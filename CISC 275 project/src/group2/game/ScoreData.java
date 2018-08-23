package group2.game;

import java.util.ArrayList;

public class ScoreData {

	String name;
	int score;
	String date;
	int rank;
	boolean arcade;
	String[] printdata = new String[4];

	// constructor that takes in a name a score and a datetime
	// the datetime probably will not be of type double in future versions
	ScoreData(String name, int score, String date, boolean arcade) {
		this.name = name;
		this.score = score;
		this.date = date;
		this.arcade = arcade;
	}

	// adds its self to the scorelist
	public void addDataToList() {
		HighScoreList.addScore(this, arcade);
	}

	// Joe - used when printing high scores in the game.
	public String[] display() {

		printdata[0] = Integer.toString(rank + 1) + ".";
		printdata[1] = name;
		printdata[2] = Integer.toString(score);
		printdata[3] = date;
		return printdata;
	}

	// override equals as to be able to use built in assrylist functions.
	@Override
	public boolean equals(Object other) {

		if (this.toString().equals(other.toString())) {
			return true;
		}

		return false;

	}

	public int getRank() {
		ArrayList<ScoreData> d = HighScoreList.getScores(arcade);
		if (d.contains(this)) {
			return d.indexOf(this);
		} else {
			addDataToList();
			getRank();
		}
		return -1;
	}

	// override toString so it is usefulll for equals
	@Override
	public String toString() {
		return name + "," + String.valueOf(score) + "," + String.valueOf(date);

	}

}
