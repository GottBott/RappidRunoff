package group2.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class HighScoreList {

	// where the game can find the score data
	static ArrayList<ScoreData> scores;
	static ArrayList<ScoreData> arcadeScores;

	// puts core into score list in order and then calls the write function to
	// save the scores.
	public static void addScore(ScoreData new_data, boolean arcade) {
		int rank = 0;
		getScores(arcade);

		if(arcade){
			// no scores in list add to front
			if (arcadeScores.size() == 0) {
				new_data.rank = 0;
				arcadeScores.add(new_data);
				writeScore(arcade);
				return;
	
			}
			// else add to correct spot;
			else {
				for (ScoreData score : arcadeScores) {
					if (new_data.score >= score.score) {
						score.rank = rank;
						arcadeScores.add(rank, new_data);
						writeScore(arcade);
						return;
					} else {
						rank++;
					}
				}
	
				// add to end if lowest score;
				new_data.rank = rank;
				arcadeScores.add(new_data);
				writeScore(arcade);
			}
		}else{
			// no scores in list add to front
			if (scores.size() == 0) {
				new_data.rank = 0;
				scores.add(new_data);
				writeScore(arcade);
				return;
	
			}
			// else add to correct spot;
			else {
				for (ScoreData score : scores) {
					if (new_data.score >= score.score) {
						score.rank = rank;
						scores.add(rank, new_data);
						writeScore(arcade);
						return;
					} else {
						rank++;
					}
				}
	
				// add to end if lowest score;
				new_data.rank = rank;
				scores.add(new_data);
				writeScore(arcade);
			}
		}
	}

	public static ArrayList<ScoreData> getScores(boolean arcade) {
		String f;
		if(arcade){
			f = "src/group2/game/ArcadeScoreList.txt";
			arcadeScores = new ArrayList<ScoreData>();
		}else{
			f = "src/group2/game/ScoreList.txt";
			scores = new ArrayList<ScoreData>();
		}
		File file = new File(f); // file name
		StringBuilder contents = new StringBuilder();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			// make a new score data from each line and insert it into
			// the arrylist, repeat until all lines all lines are read
			while ((text = reader.readLine()) != null) {
				String str[] = text.split(",");
				ScoreData d = new ScoreData(str[0], Integer.parseInt(str[1]),
						str[2], arcade);
				d.rank = Integer.parseInt(str[3]);
				if(arcade){
					arcadeScores.add(d);
				}else{
					scores.add(d);
				}
				contents.append(text).append(
						System.getProperty("line.separator"));

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return arcade ? arcadeScores : scores;
	}

	private static void writeScore(boolean arcade) {

		Writer writer = null;

		try {
			if(arcade){
				// clears list for rewrite
				File file_old = new File("src/group2/game/ArcadeScoreList.txt");
				file_old.delete();

				File file = new File("src/group2/game/ArcadeScoreList.txt");
				writer = new BufferedWriter(new FileWriter(file));

				// for all the scores in the high score list
				int rank = 0;
				for (ScoreData score : arcadeScores) {
					String text = score.toString() + "," + rank;
					; // append the rank
					writer.write(text); // write the scoredata separated by commas
					writer.write("\r\n"); // new line
					rank++;
				}
			}else{
				// clears list for rewrite
				File file_old = new File("src/group2/game/ScoreList.txt");
				file_old.delete();

				File file = new File("src/group2/game/ScoreList.txt");
				writer = new BufferedWriter(new FileWriter(file));

				// for all the scores in the high score list
				int rank = 0;
				for (ScoreData score : scores) {
					String text = score.toString() + "," + rank;
					; // append the rank
					writer.write(text); // write the scoredata separated by commas
					writer.write("\r\n"); // new line
					rank++;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
