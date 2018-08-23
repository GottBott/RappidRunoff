package group2.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import org.junit.Test;

public class TestGame {

	// WHAT DO WE WANT TO TEST!!!?????

	// moving objects along river
	// objects increasing / decreasing players score
	// count number of objects collected
	// quiz answers
	// generate erosion
	// adding & removing buffers
	// tracking player movement and clicks

	// Tests the creation of a new set of score data;
	@Test
	public void testNewScoreData() {
		ScoreData d = new ScoreData("Ben Gotthold", 54321, "date", false);

		assertEquals(d.name, "Ben Gotthold");
		assertEquals(d.score, 54321, 0);
		assertEquals(d.date, "date");
		assertEquals(d.rank, 0);

	}
	
	@Test
	public void testGUIInput(){
		RapidRunoffGame g = new RapidRunoffGame();
		GUIInput gui = new GUIInput(g,true,true);
		
		assertEquals(gui.game,g);
		assertTrue(gui.createAndShowGUI());
	}

	@Test
	public void testQuiz() {
		String q = "Question";
		String[] choices = { "A", "B", "C", "D" };
		Quiz q1 = new Quiz(q, choices, 2);

		// Make sure constructor works properly
		assertEquals(q, q1.question);
		assertEquals(choices, q1.choices);
		assertEquals(2, q1.answer);

		// Make sure checkChoice() works as expected
		assertFalse(q1.checkChoice(0));
		assertFalse(q1.checkChoice(1));
		assertTrue(q1.checkChoice(2));
		assertFalse(q1.checkChoice(3));
	}

	// tests to make sure scores are saved in the correct order
	// tests getRank()
	@Test
	public void testRankOrder() {
		ScoreData d1 = new ScoreData("Ben", 50, "", false);
		ScoreData d2 = new ScoreData("Dan", 20, "", false);
		ScoreData d3 = new ScoreData("Forr", 80, "", false);

		d1.addDataToList();
		d2.addDataToList();
		d3.addDataToList();

		// ArrayList<ScoreData> scores = HighScoreList.getScores();

		// lower rank means higher score
		assertTrue(d1.getRank() < d2.getRank());
		assertTrue(d2.getRank() > d3.getRank());
		

	}

	  @Test public void testRiverBank() throws InterruptedException{ 
	  Position p0= new Position(.33,.67); 
	  RiverBank testBank = new RiverBank(2, 2, p0, .12, .15, 1);

	  Buffer b1 = new Buffer(); 
	  b1.bank = testBank;
	  
	  //testing addBuffer()
	  
	  //test that a buffer can be added on a bank of all true values
	  assertTrue(testBank.addBuffer(b1, 0,0));
	  
	  //test that when a bank is placed, corresponding element of
	  //can_place_buffer is made false
	  assertFalse(testBank.can_place_object[0][0]);
	  
	  //test that the buffer is added to river_bank_objs
	  assertEquals(testBank.objects[0][0], b1);
	  
	  //test that a buffer cannot be added where can_place_buffer is false
	  assertFalse(testBank.addBuffer(b1, 0,0));
	  
	  ((Buffer)(testBank.objects[0][0])).time = -1;
	  ((Buffer)(testBank.objects[0][0])).update();
	  testBank.update();
	  
	  //test buffer disappearing after 20 seconds
	  assertTrue(testBank.can_place_object[0][0]);
	  
	  testBank.erode(0,0);

	  //test buffer being put on non-permanent erosion
	  assertTrue(testBank.addBuffer(b1, 0,0));
	  
	  //test erosion being removed from objects when buffer placed
	  assertEquals(testBank.objects[0][0], b1);

	  
	  
	  //testing erode()
	  
	  testBank.erode(0,0);
	  
	  //test erosion being put in objects on erode()
	  assertEquals(testBank.objects[0][0].ID,"Erosion");
	  assertEquals(testBank.objects[0][0].position, p0);
	  assertFalse(testBank.can_place_object[0][0]);

	  //test that erosion is not permanent
	  assertFalse(testBank.permanent_erosion[0][0]);
	  
	  ((Erosion)(testBank.objects[0][0])).time = -1;
	  ((Erosion)(testBank.objects[0][0])).update();
	  testBank.update();
	  
	  //test that erosion becomes permanent when time <0
	  assertFalse(testBank.can_place_object[0][0]);
	  assertTrue(testBank.permanent_erosion[0][0]);
	  
	  //test that buffer cannot be placed on permanent erosion
	  assertFalse(testBank.addBuffer(b1, 0,0));
	  
	  
	  //testing checkCoordinates()
	  assertEquals(testBank.checkCoordinates(.33, .67), new Position(0,0));
	  assertEquals(testBank.checkCoordinates(.4, .67), new Position(1,0));
	  assertEquals(testBank.checkCoordinates(.33, .75), new Position(0,1));
	  assertEquals(testBank.checkCoordinates(.4, .75), new Position(1,1));
	  assertEquals(testBank.checkCoordinates(.45, .82), new Position(1,1));


	  //testing checkIfInBank
	  assertEquals(testBank.checkIfInBank(.33, .67), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.34, .67), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.33, .68), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.35, .7), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.45, .67), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.33, .82), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.45, .82), testBank.ID);
	  assertEquals(testBank.checkIfInBank(.46, .67), -1);
	  assertEquals(testBank.checkIfInBank(.33, .84), -1);

	  
	  
	  //testing findErode()
	  testBank.permanent_erosion[0][1]=true;
	  testBank.can_place_object[0][1]=false;
	  assertTrue(testBank.findErode());
	  assertEquals(testBank.objects[1][1].ID, "Erosion");
	  
	  
	  //testing erosionFactor()
	  assertEquals(testBank.erosionFactor(0), 0);
	  assertEquals(testBank.erosionFactor(1), 1);


	  
	  }

	
	// tests to make sure scores read and write correctly
	// tests adddataToList()
	@Test
	public void testSaveScore() {
		ScoreData d1 = new ScoreData("Ben", 50, "", false);
		ScoreData d2 = new ScoreData("Dan", 20, "", false);
		ScoreData d3 = new ScoreData("Forr", 80, "", false);

		d1.addDataToList();
		d2.addDataToList();
		d3.addDataToList();

		ArrayList<ScoreData> scores = HighScoreList.getScores(false);

		assertTrue(scores.contains(d1));
		assertTrue(scores.contains(d2));
		assertTrue(scores.contains(d3));

	}

	@Test
	public void testScore() {
		Score testScore = new Score(0, 0, 0, 0, 0);

		// test addScore()
		testScore.addScore(10);
		assertEquals(testScore.game_score, 10);

		testScore.addScore(-20);
		assertEquals(testScore.game_score, 0);
		
		testScore.incrementFertilizer();
		testScore.incrementFertilizer();
		assertEquals(testScore.fertilizer_count, 2);
		
		testScore.incrementOil();
		testScore.incrementOil();
		assertEquals(testScore.oil_count, 2);
		
		testScore.incrementFertilizerLost();
		assertEquals(testScore.fertilizer_lost, 1);
		
		testScore.incrementOilLost();
		assertEquals(testScore.oil_lost, 1);
	}

	// Stefan
	@Test
	public void testMap() {
		RapidRunoffGame g = new RapidRunoffGame();
		Map m = new Map(g);

		// Test updateSpeed
		m.updateSpeed(100);
		assertEquals(m.updates_per_water_object, 66);
	}

	// Stefan
	@Test
	public void testWaterObjects() {
		RapidRunoffGame g = new RapidRunoffGame();
		WaterObjects w = new Oil(new Position(0.1, 0.1), g, 0);
		double tolerance = 0.00001;

		// Test moveWaterObject
		w.moveWaterObject();
		assertTrue(w.position.y <= 0.105 + tolerance && w.position.y >= 0.105 - tolerance );
		assertTrue(w.position.x == 0.1);

		// Test remove
		g.map.water_objects.add(w);
		w.remove(true);
		assertTrue(g.player.player_score.game_score == w.point_value);
		assertTrue(!g.map.water_objects.contains(w));
		
		//Test checkClickRange(x,y)
		assertTrue(w.checkClickRange(0.1, 0.1));
		assertTrue(w.checkClickRange(0.101,0.099));
		assertTrue(w.checkClickRange(0.102,0.098));
		assertFalse(w.checkClickRange(0.2,0.098));
		assertFalse(w.checkClickRange(0.102,0.95));
		
		//Test checkIfInBin()
		assertTrue(w.checkIfInBin(0.015, 0.5));
		assertFalse(w.checkIfInBin(0.15, 0.1));
		
		//Test increment()
		WaterObjects fert = new Fertilizer(new Position(0.2,0.2), g, 0);
		
		w.increment();
		fert.increment();
		
		assertEquals(g.player.player_score.oil_count, 1);
		assertEquals(g.player.player_score.fertilizer_count, 1);
		
		//Test checkIfInStream()
		assertTrue(w.checkIfInStream());
		
		//Test checkIfInRiver()
		assertFalse(w.checkIfInRiver());
	}
	
	
	
	@Test
	public void testPosition() {
		Position p1 = new Position(0.1,0.2);
		Position p2 = new Position(0.1,0.2);
		Position p3 = new Position(0.2,0.1);
		
		//Test equals()
		assertTrue(p1.equals(p2));
		assertTrue(p2.equals(p1));
		assertFalse(p1.equals(p3));
		assertFalse(p3.equals(p1));
		
		//Test getXPos()
		assertTrue(p1.getXPos() == 0.1);
		assertTrue(p2.getXPos() == 0.1);
		assertTrue(p3.getXPos() == 0.2);
		
		//Test getYPos()
		assertTrue(p1.getYPos() == 0.2);
		assertTrue(p2.getYPos() == 0.2);
		assertTrue(p3.getYPos() == 0.1);
		
		//Test hashCode()
		assertEquals(p1.hashCode(), 0);
		assertEquals(p2.hashCode(), 0);
		assertEquals(p3.hashCode(), 0);
		
		//Test setPosition(x_new,y_new)
		p1.setPosition(0.3, 0.4);
		assertTrue(p1.getXPos() == 0.3);
		assertTrue(p1.getYPos() == 0.4);
	}
	
	@Test
	public void testPlayer(){
		Player p = new Player(new RapidRunoffGame());
		
		p.addScoreDataToList("Ben", "May 5");
		assertEquals(p.player_data.name,"Ben");
		assertEquals(p.player_data.date,"May 5");
		assertEquals(p.get_players_rank(),p.players_rank);
	}
	
	
}
