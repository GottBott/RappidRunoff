package group2.game;

/**
 * Joe
 * 4/3/13
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawGame extends JPanel {

	private static final long serialVersionUID = 1L;

	RapidRunoffGame game;
	Quiz currQuiz;

	static public boolean first_fert = false;
	static public boolean first_oil = false;
	static public boolean first_erosion_temp = false;
	static public boolean first_erosion_per = false;
	static public boolean first_powerup = false;
	static public boolean first_quiz = false;
	
	public int erosion_updates=0;


	int bg_count = 0;
	ArrayList<ScoreData> Score_data = new ArrayList<ScoreData>();
	ArrayList<ScoreData> ArcadeScore_data = new ArrayList<ScoreData>();

	static Image[] background = new Image[3];
	static Image[] OilImage = new Image[3];
	static Image[] FertImage = new Image[3];
	static Image[] permanentErosion = new Image[7];


	static public Image background_start;
	static public Image high_score_screen;
	static public Image grass;
	static public Image skyline;
	static public Image Oil_Box;
	static public Image Fert_Box;
	static public Image Broom;
	static public Image Funnel;
	static public Image erosion;
	static public Image back_to_menu;
	static public Image cloudL;
	static public Image cloudCL;
	static public Image cloudCR;
	static public Image cloudCLS;
	static public Image cloudCRS;
	static public Image cloudR;
	static public Image city1;
	static public Image city2;
	static public Image raindrop;
	static public Image play;

	Font f1;
	Font f2;
	Font f3;
	Font f4;

	BasicStroke bs8 = new BasicStroke(8);
	BasicStroke bs6 = new BasicStroke(6);
	BasicStroke bs4 = new BasicStroke(4);
	BasicStroke bs3 = new BasicStroke(3);

	Color trans_grey = new Color(128, 128, 128, 200);
	Color clear = new Color(128, 128, 128, 0);

	DrawGame(RapidRunoffGame g) {
		this.game = g;

		try {
			OilImage[0] = ImageIO.read(Oil.class
					.getResourceAsStream("Oil_Blob.png"));
			OilImage[1] = ImageIO.read(Oil.class
					.getResourceAsStream("Oil_Blob_02.png"));
			OilImage[2] = ImageIO.read(Oil.class
					.getResourceAsStream("Oil_Blob_03.png"));
			FertImage[0] = ImageIO.read(Fertilizer.class
					.getResourceAsStream("Fertilizer_01.png"));
			FertImage[2] = ImageIO.read(Fertilizer.class
					.getResourceAsStream("Fertilizer_02.png"));
			FertImage[1] = ImageIO.read(Fertilizer.class
					.getResourceAsStream("Fertilizer_03.png"));
			background[2] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Background_01.png"));
			background[1] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Background_03.png"));
			background[0] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Background_05.png"));
			background_start = ImageIO.read(DrawGame.class
					.getResourceAsStream("home_screen.png"));
			permanentErosion[0] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0001.png"));
			permanentErosion[1] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0002.png"));
			permanentErosion[2] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0003.png"));
			permanentErosion[3] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0004.png"));
			permanentErosion[4] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0005.png"));
			permanentErosion[5] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0006.png"));
			permanentErosion[6] = ImageIO.read(DrawGame.class
					.getResourceAsStream("Wave0007.png"));
			high_score_screen = ImageIO.read(DrawGame.class
					.getResourceAsStream("high_score_screen.png"));
			grass = ImageIO.read(DrawGame.class
					.getResourceAsStream("Switchgrass.png"));
			skyline = ImageIO.read(DrawGame.class
					.getResourceAsStream("skyline.png"));
			Fert_Box = ImageIO.read(Oil.class
					.getResourceAsStream("Fertilizer Box.png"));
			Oil_Box = ImageIO
					.read(Oil.class.getResourceAsStream("Oil_Box.png"));
			Broom = ImageIO.read(Oil.class.getResourceAsStream("Broom.png"));
			Funnel = ImageIO.read(Oil.class.getResourceAsStream("Funnel.png"));
			//permanentErosion = ImageIO.read(DrawGame.class
			//		.getResourceAsStream("water.png"));
			erosion = ImageIO.read(DrawGame.class
					.getResourceAsStream("compost.png"));
			back_to_menu = ImageIO.read(DrawGame.class
					.getResourceAsStream("BacktoMenu.png"));
			city1 = ImageIO.read(City.class
					.getResourceAsStream("CityScape_02.png"));
			city2 = ImageIO.read(City.class
					.getResourceAsStream("CityScape.png"));
			cloudL = ImageIO.read(Oil.class
					.getResourceAsStream("Storm_Cloud_02.png"));
			;
			cloudR = ImageIO.read(Oil.class
					.getResourceAsStream("Storm_Cloud_01.png"));
			;
			cloudCL = ImageIO.read(City.class
					.getResourceAsStream("Storm_Cloud_Lightning_02_S.png"));
			cloudCR = ImageIO.read(City.class
					.getResourceAsStream("Storm_Cloud_Lightning_S.png"));
			cloudCLS = ImageIO.read(City.class
					.getResourceAsStream("Storm_Cloud_Lightning_02.png"));
			cloudCRS = ImageIO.read(City.class
					.getResourceAsStream("Storm_Cloud_Lightning.png"));
			raindrop = ImageIO.read(City.class
					.getResourceAsStream("Raindrop_cartoon1.png"));
			play = ImageIO.read(DrawGame.class
					.getResourceAsStream("play.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// load some score data
		for (int i = 0; i < 10; i++) {
			try {
				this.Score_data.add(HighScoreList.getScores(false).get(i));
			} catch (Exception e) {
				System.out.println("not 10 scores");
			}
		}
		for (int i = 0; i < 10; i++) {
			try {
				this.ArcadeScore_data.add(HighScoreList.getScores(true).get(i));
			} catch (Exception e) {
				System.out.println("not 10 scores");
			}
		}

		f1 = new Font("serif", Font.BOLD, (int) game.screen_height / 60
				+ (int) game.screen_width / 75);
		f2 = new Font("serif", Font.BOLD, (int) game.screen_height / 125
				+ (int) game.screen_width / 125);
		f3 = new Font("serif", Font.BOLD, (int) game.screen_height / 80
				+ (int) game.screen_width / 125);
		f4 = new Font("serif", Font.BOLD, (int) game.screen_height / 65
				+ (int) game.screen_width / 125);

	}

	// the paint component where objects are drawn
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		// if arcade mode is unlocked!


		if (game.home_screen) { // True if we haven't started playing the game
			g.drawImage(background_start, 0, 0, (int) game.screen_width,
					(int) (.98 * game.screen_height), null);
			if (game.code_screen) {
				g.setColor(Color.BLACK);
				g.setFont(f1);
				if(game.valid_code){
					g.drawString("Arcade Mode Unlocked!", (int)(.37*game.screen_width), (int)(.95*game.screen_height));
				}
				else{
					g.drawString("Invalid Code!", (int) (.42*game.screen_width), (int) (.95*game.screen_height));
				}

			}
		}

		else if (game.high_score_screen) {
			g.drawImage(high_score_screen, 0, 0, (int) game.screen_width,
					(int) (.98 * game.screen_height), null);
			g.setColor(trans_grey);
			g.fillRect((int) (0.35 * game.screen_width),
					(int) (0.15 * game.screen_height),
					(int) (0.3 * game.screen_width),
					(int) (0.7 * game.screen_height));

			g.setColor(Color.BLACK);
			g2d.setStroke(bs6);
			g.setFont(f1);
			
			ArrayList<ScoreData> data;
			if(game.arcademode){
				g.drawString("ArcadeHighScores", (int) (0.4 * game.screen_width),
						(int) (0.20 * game.screen_height));
				data = ArcadeScore_data;
			}else{
				g.drawString("HighScores", (int) (0.45 * game.screen_width),
						(int) (0.20 * game.screen_height));
				data = Score_data;
			}

			g.setFont(f4);
			String m;
			// rank
			double h = 0.25;
			for (int i = 0; i < data.size(); i++) {
				g.drawString(data.get(i).display()[0],
						(int) (0.36 * game.screen_width),
						(int) (h * game.screen_height));
				h = h + 0.05;
			}

			// name
			h = 0.25;
			for (int i = 0; i < data.size(); i++) {
				m = data.get(i).display()[1];
				if(m.length() > 4){
					m = m.substring(0, 6);
				}
				g.drawString(m,
						(int) (0.39 * game.screen_width),
						(int) (h * game.screen_height));
				h = h + 0.05;
			}

			// score
			h = 0.25;
			for (int i = 0; i < data.size(); i++) {
				g.drawString(data.get(i).display()[2],
						(int) (0.47 * game.screen_width),
						(int) (h * game.screen_height));
				h = h + 0.05;
			}

			// date
			h = 0.25;
			for (int i = 0; i < data.size(); i++) {
				g.drawString(data.get(i).display()[3],
						(int) (0.55 * game.screen_width),
						(int) (h * game.screen_height));
				h = h + 0.05;
			}

		}
		else if (game.intro_screen){
			// set some color thickness and fonts
			g.setColor(Color.BLUE);
			g2d.setStroke(bs6);
			g.setFont(f1);

			// draw skyline
			g.drawImage(skyline, 0, 0, (int) game.screen_width,
					(int) (0.25 * game.screen_height), null);


			// DRAW CITY -B
			g.drawImage(city1,
								(int) (.4 * game.screen_width),
								(int) (.05 * game.screen_height),
								(int) (0.17 * game.screen_width),
								(int) (0.2 * game.screen_height), null);
	

			// draw background -B
			g.drawImage(background[bg_count], 0, 0, (int) game.screen_width,
					(int) game.screen_height, null);
			
			//draw screen
			g.setColor(Color.CYAN);
			g.drawRect((int) (game.screen_width * .17),
					(int) (game.screen_height * .2),
					(int) (game.screen_width * .65),
					(int) (game.screen_height * .5));
			Color myColor = new Color(0, 0, 0, 200);
			g.setColor(myColor);
			g.fillRect((int) (game.screen_width * .17),
					(int) (game.screen_height * .2),
					(int) (game.screen_width * .65),
					(int) (game.screen_height * .5));
			g.setColor(Color.GREEN);
			g.setFont(f3);
			g.drawString(("A storm is about to hit the city!"),
					(int) (.4 * game.screen_width),
					(int) (.24 * game.screen_height));
			g.drawString(("Remove pollutants from the streams of runoff coming down the hill towards the river"),
					(int) (.25 * game.screen_width),
					(int) (.3 * game.screen_height));
			if(game.arcademode){
				g.drawString("***ARCADE MODE***",
						(int) (.42 * game.screen_width),
						(int) (.35 * game.screen_height));
				g.drawString("Keep removing pollutants until you miss 10, see how many you can discard!",
						(int) (.265 * game.screen_width),
						(int) (.4 * game.screen_height));
			}
			g.drawImage(play, (int)(game.screen_width*.42), 
					(int) (game.screen_height * .5),
					(int) (game.screen_width * .15),
					(int) (game.screen_height * .15), null);
		}
		else if (game.game_screen) { // True if we are currently playing the

			// set some color thickness and fonts
			g.setColor(Color.BLUE);
			g2d.setStroke(bs6);
			g.setFont(f1);

			// draw skyline
			g.drawImage(skyline, 0, 0, (int) game.screen_width,
					(int) (0.25 * game.screen_height), null);

			// draw Clouds -B
			for (int i = 0; i < game.map.city.clouds[0].length; i++) {
				if (game.game_time > 0) {
					if (game.map.city.clouds[0][i] != null) {
						g.drawImage(game.map.city.clouds[0][i],
								(int) ((i * 0.05 + 0.22) * game.screen_width),
								0, (int) (0.12 * game.screen_width),
								(int) (0.12 * game.screen_height), null);
					}
				}
			}

			// DRAW CITY -B
			for (int i = 0; i < game.map.city.buildings.length; i++) {
				if (game.game_time > 0) {
					if (game.map.city.buildings[i] != null) {
						g.drawImage(game.map.city.buildings[i],
								(int) ((i * 0.07 + 0.21) * game.screen_width),
								(int) (.05 * game.screen_height),
								(int) (0.17 * game.screen_width),
								(int) (0.2 * game.screen_height), null);
					}
				}
			}

			// draw background -B
			g.drawImage(background[bg_count], 0, 0, (int) game.screen_width,
					(int) game.screen_height, null);

			// draw menu which menu iterator
			for (Menu m : game.map.menus) {

				g.setColor(trans_grey);

				g.fillRect((int) (m.position.x * game.screen_width),
						(int) (m.position.y * game.screen_height),
						(int) (m.position.width * game.screen_width),
						(int) (m.position.height * game.screen_height));

				// draw bins
				for (MenuObject o : m.menu_objects) {
					g.setColor(Color.BLACK);
					g.drawImage(m.bin_image,
							(int) (o.position.x * game.screen_width),
							(int) (o.position.y * game.screen_height),
							(int) (o.width * game.screen_width),
							(int) (o.height * game.screen_height), null);

				}
			}

			// draw score
			if(!game.arcademode){
				g.setFont(f1);
				g.setColor(Color.GREEN);
				g.drawString("Score: " + Integer.toString(game.player.player_score.game_score),
						(int) (.85 * game.screen_width),
						(int) (.045 * game.screen_height));
			} else{
				g.setFont(f1);
				g.setColor(Color.GREEN);
				g.drawString("Pollutants Missed: " + Integer.toString(game.player.player_score.fertilizer_lost+
																	  game.player.player_score.oil_lost),
						(int) (.75 * game.screen_width),
						(int) (.045 * game.screen_height));
				g.drawString("Pollutants Removed: " + Integer.toString(game.player.player_score.fertilizer_count+
																	   game.player.player_score.oil_count), 
						(int) (.75 * game.screen_width),
						(int) (.09 * game.screen_height));
			}

			// draw time in bar format
			if(!game.arcademode){
				g.drawString("Time:", (int) (game.screen_width * 0.05),
						(int) (game.screen_height * 0.045));
				g.setColor(Color.BLACK);
				g.fillRect((int) (game.screen_width * 0.11),
						(int) (game.screen_height * 0.02),
						(int) (game.screen_width * 0.126),
						(int) (game.screen_height * 0.033));
				g.setColor(Color.YELLOW);
				g.fillRect((int) (game.screen_width * 0.113),
						(int) (game.screen_height * 0.024),
						(int) (game.screen_width * (game.game_time * 0.000001)),
						(int) (game.screen_height * 0.025));
				g.setColor(Color.BLACK);
			} else{
				g.drawString("Remaining:", (int) (game.screen_width * 0.05),
						(int) (game.screen_height * 0.045));
				g.setColor(Color.BLACK);
				g.fillRect((int) (game.screen_width * 0.16),
						(int) (game.screen_height * 0.02),
						(int) (game.screen_width * 0.143),
						(int) (game.screen_height * 0.033));
				g.setColor(Color.YELLOW);
				for(int i = 0; i < (game.abletomiss - (game.player.player_score.fertilizer_lost + game.player.player_score.oil_lost)); i++){
					g.fillRect((int)(game.screen_width * (0.163 + (i * 0.014))),
							   (int)(game.screen_height * 0.024),
							   (int)(game.screen_width * 0.011),
							   (int)(game.screen_height * 0.025));
				}
				
				g.setColor(Color.BLACK);
			}
			
			g2d.setStroke(bs3);
			// draw pause button
			g.drawRect((int) (game.screen_width * 0.02),
					(int) (game.screen_height * 0.02),
					(int) (game.screen_width * 0.02),
					(int) (game.screen_height * 0.033));
			g.drawLine((int) (game.screen_width * 0.026),
					(int) (game.screen_height * 0.029),
					(int) (game.screen_width * 0.026),
					(int) (game.screen_height * 0.043));
			g.drawLine((int) (game.screen_width * 0.033),
					(int) (game.screen_height * 0.029),
					(int) (game.screen_width * 0.033),
					(int) (game.screen_height * 0.043));

			

			// draw powerup objects
			for (PowerUp p : game.map.power_ups) {
				g.setColor(Color.BLACK);
				if (p.ready){
					if(!first_powerup){
						g.setColor(Color.BLACK);
						g.drawString("Use a Power-Up!",
								(int) (game.screen_width * .33),
								(int) ((game.map.river.position.y + .1) * game.screen_height));
						
						g.drawLine((int) (game.screen_width * .4),
								(int) ((game.map.river.position.y + .05) * game.screen_height),
								(int) ((p.position.x + .5*p.position.width) * game.screen_width),
								(int) ((p.position.y + p.position.height) * game.screen_height));
						
						g.setColor(Color.RED);
						g.drawRect(
								(int) (p.position.x * game.screen_width),
								(int) (p.position.y * game.screen_height),
								(int) (p.position.width * game.screen_width),
								(int) (p.position.height * game.screen_height));
						
					}
				g.drawImage(p.image,
						(int) (p.position.x * game.screen_width),
						(int) (p.position.y * game.screen_height),
						(int) (p.position.width * game.screen_width),
						(int) (p.position.height * game.screen_height),
						null);
				}
			}

			// draw buffer zones and buffers
			for (int i = 0; i < game.map.river_banks.size(); i++) {
				RiverBank curBank = game.map.river_banks.get(i);
				for (int col = 0; col < curBank.objects.length; col++) {
					for (int row = 0; row < curBank.objects[col].length; row++) {
						if (curBank.objects[col][row] != null) {
							if ((curBank.objects[col][row]).ID == "Buffer") {
								Buffer b = (Buffer) curBank.objects[col][row];
								g.drawImage(
										grass,
										(int) ((b.position.x) * game.screen_width),
										(int) ((b.position.y - .02) * game.screen_height),
										(int) (.8 * b.menu_width * game.screen_width),
										(int) (.8 * b.menu_height * game.screen_height),
										null);
										first_erosion_temp = true;
							} else if ((curBank.objects[col][row]).ID == "Erosion") {
								Erosion e = (Erosion) curBank.objects[col][row];
								if (e.is_permanent) {

									if (curBank.ID==0){
										if (row==1){
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (1.2*e.position.width * game.screen_width),
													(int) (e.position.height * game.screen_height),
													null);
										}
										else{
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (1.2*e.position.width * game.screen_width),
													(int) (1.2*e.position.height * game.screen_height),
													null);
										}
									}
									if (curBank.ID==1){
										if (row==1){
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x-.006) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) ((1.2*e.position.width * game.screen_width)),
													(int) (e.position.height * game.screen_height),
													null);
										}
										else{
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x-.02) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) ((1.2*e.position.width * game.screen_width+ (.014*game.screen_width))),
													(int) (1.2*e.position.height * game.screen_height),
													null);
										}
									}
									if (curBank.ID==2){
										if (row==1){
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x-.002) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (e.position.width * game.screen_width+(.002*game.screen_width)),
													(int) (e.position.height * game.screen_height),
													null);
										}
										else{
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x-.002) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (e.position.width * game.screen_width+(.002*game.screen_width)),
													(int) (1.2*e.position.height * game.screen_height),
													null);
										}
									}
									if (curBank.ID==3){
										if (row==1){
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (1.2*e.position.width * game.screen_width),
													(int) (e.position.height * game.screen_height),
													null);
										}
										else{
											g.drawImage(
													permanentErosion[e.cur_image],
													(int) ((e.position.x+.002) * game.screen_width),
													(int) ((e.position.y ) * game.screen_height),
													(int) (1.2*e.position.width * game.screen_width-(.002*game.screen_width)),
													(int) (1.2*e.position.height * game.screen_height),
													null);
										}
									}
										
									if(!first_erosion_per || erosion_updates< 100){
										g.setColor(Color.BLACK);
										g.drawString("The erosion is permanent!",(int) ((e.position.x) * game.screen_width),
											(int) ((e.position.y + .02) * game.screen_height));
										first_erosion_per=true;
										erosion_updates++;
									}
									if (e.erosion_feedback_updates < 100){
										if(!game.arcademode){
											g.setColor(Color.RED);
		
											g.drawOval((int) (e.position.x * game.screen_width),
													(int) ((e.position.y +.03)* game.screen_height ),
													(int) game.screen_width / 30,
													(int) game.screen_width / 30);
											g.setFont(f3);
											g.drawString("-50", (int) ((e.position.x + .005) * game.screen_width),
													(int) (((e.position.y +.03)+ .035) * game.screen_height));
											e.erosion_feedback_updates++;
										}
									}
								} else {
									if(!first_erosion_temp){
										g.drawString("Fix the Erosion!",(int) ((e.position.x) * game.screen_width),
											(int) ((e.position.y + .02) * game.screen_height));
										g.setColor(Color.BLACK);
										g2d.setStroke(bs4);
									g.drawRect((int)(Buffer.menu_position.x * game.screen_width),
											(int)(Buffer.menu_position.y * game.screen_height),
											(int)(Buffer.menu_position.width * game.screen_width),
											(int)(Buffer.menu_position.height * game.screen_height));
									g.drawLine((int)((Buffer.menu_position.x + .08)* game.screen_width),
											(int)((Buffer.menu_position.y + .12) * game.screen_height),
											(int) ((e.position.x) * game.screen_width),
											(int) ((e.position.y + .02) * game.screen_height));
									}
									g.drawImage(
											erosion,
											(int) ((e.position.x) * game.screen_width),
											(int) ((e.position.y) * game.screen_height),
											(int) (e.position.width * game.screen_width),
											(int) (e.position.height * game.screen_height),
											null);
											
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < game.map.buffers.size(); i++) {
				g.setColor(Color.RED);
				g.setFont(f2);
				Buffer b = game.map.buffers.get(i);
				
				g.setColor(Color.BLACK);
				if (b.ready) {
					g.drawImage(grass,
							(int) ((b.position.x) * game.screen_width),
							(int) ((b.position.y) * game.screen_height),
							(int) (b.menu_width * game.screen_width),
							(int) (b.menu_height * game.screen_height), null);

					if(b.is_clicked){
						g.drawImage(grass,
								(int) game.frame.getContentPane()
								.getMousePosition().getX()
								- (int) game.screen_width / 30,
								(int) game.frame.getContentPane()
								.getMousePosition().getY()
								- (int) game.screen_width / 30,
								(int) (b.position.width * game.screen_width),
								(int) (b.position.height * game.screen_height), null);
						g.drawString("Sediment Efficiency: 56%", (int) game.frame.getContentPane()
								.getMousePosition().getX()
								- (int) game.screen_width / 30,
								(int) game.frame.getContentPane()
								.getMousePosition().getY()
								- (int) game.screen_width / 30);
						
					}
				}
			}
			
			// draws pollutants
						for (int i = 0; i < game.map.water_objects.size(); i++) {
							WaterObjects w = game.map.water_objects.get(i);
							g.setFont(f1);
							if (w.is_clicked) {
								g.setColor(Color.BLACK);

								// when the first fertilizer is clicked
								if (!first_fert && w.id == "f") {

									g.drawLine(
											(int) game.frame.getContentPane()
													.getMousePosition().getX(),
											
											(int) game.frame.getContentPane()
													.getMousePosition().getY(),
							
											(int) ((w.bin.position.x + .5 * w.bin.position.width) * game.screen_width),
											(int) ((w.bin.position.y + .5 * w.bin.position.height) * game.screen_height));

									g.drawOval(
											(int) ((w.bin.position.x + .4 * w.bin.position.width) * game.screen_width),
											(int) ((w.bin.position.y + .4 * w.bin.position.height) * game.screen_height),
											(int) (.2 * w.bin.position.width * game.screen_width),
											(int) (.2 * w.bin.position.height * game.screen_height));

									g.drawString(
											"Fertilizer doesn't belong in the stream!",
											(int) (game.screen_width * .30),
											(int) ((game.map.river.position.y + .1) * game.screen_height));
								}
								// when the first oil is clicked
								if (!first_oil && w.id != "f") {
									g.drawLine(
											(int) game.frame.getContentPane().getMousePosition().getX(),		
											(int) game.frame.getContentPane().getMousePosition().getY(),
											(int) ((w.bin.position.x + .5 * w.bin.position.width) * game.screen_width),
											(int) ((w.bin.position.y + .5 * w.bin.position.height) * game.screen_height));

									g.drawOval(
											(int) ((w.bin.position.x + .4 * w.bin.position.width) * game.screen_width),
											(int) ((w.bin.position.y + .4 * w.bin.position.height) * game.screen_height),
											(int) (.2 * w.bin.position.width * game.screen_width),
											(int) (.2 * w.bin.position.height * game.screen_height));

									g.drawString(
											"Oil doesn't belong in the stream!",
											(int) (game.screen_width * .33),
											(int) ((game.map.river.position.y + .1) * game.screen_height));

								}

								g.setColor(w.color);
								g2d.setStroke(bs8);

								g.drawImage(w.image[w.cur_image], (int) game.frame
										.getContentPane().getMousePosition().getX()
										- (int) game.screen_width / 50, (int) game.frame
										.getContentPane().getMousePosition().getY()
										- (int) game.screen_width / 50,
										(int) game.screen_width / 25,
										(int) game.screen_width / 25, null);

								g2d.setStroke(bs4);
								// Draws where dragged WaterObject SHOULD be on screen
								g.setColor(Color.GRAY);
								g.drawOval((int) (w.position.x * game.screen_width),
										(int) (w.position.y * game.screen_height),
										(int) game.screen_width / 50,
										(int) game.screen_width / 50);

							} else if (w.position.x > .99) {
								if(!game.arcademode){
									g.setColor(Color.RED);
	
									g.drawOval((int) ((.965) * game.screen_width),
											(int) (w.position.y * game.screen_height),
											(int) game.screen_width / 30,
											(int) game.screen_width / 30);
									g.setFont(f3);
									g.drawString("-10", (int) ((.97) * game.screen_width),
											(int) ((w.position.y + .035) * game.screen_height));
								}
							} else if (w.removed) {
								if(!game.arcademode){
									if(w.id == "f")
										g.setColor(Color.GREEN);
									else
										g.setColor(Color.BLACK);
	
									g.drawOval((int) (w.position.x * game.screen_width),
											(int) (w.position.y * game.screen_height),
											(int) game.screen_width / 30,
											(int) game.screen_width / 30);
									g.setFont(f3);
									g.drawString("+10", (int) ((w.position.x + .005) * game.screen_width),
											(int) ((w.position.y + .035) * game.screen_height));
								}
							} else {
								g.setColor(w.color);
								g.drawImage(w.image[w.cur_image],
										(int) (w.position.x * game.screen_width),
										(int) (w.position.y * game.screen_height),
										(int) game.screen_width / 40,
										(int) game.screen_width / 40, null);

								if (!first_oil && w.id != "f") {
									g.drawString("Click Me!",
											(int) (w.position.x * game.screen_width),
											(int) (w.position.y * game.screen_height));
								}
								if (!first_fert && w.id == "f") {
									g.drawString("Click Me!",
											(int) (w.position.x * game.screen_width),
											(int) (w.position.y * game.screen_height));
								}
							}

						}

						
			/**
			 * Mason
			 * 
			 * Greys out the game if either the quiz/feedback or the end game screen is up
			 */
			if(game.quizMode || game.quizFeedbackMode || game.score_up){
				Color myColor = new Color(192,192,192,200);
				g.setColor(myColor);
				g.fillRect(1,1,(int)game.screen_width,(int)game.screen_height);
			}else if(game.paused){
				g.drawImage(back_to_menu, (int) (0.4 * game.screen_width),
										  (int) (0.4 * game.screen_height),
										  (int) (0.2  * game.screen_width),
										  (int) (0.2  * game.screen_height), null);
			}
			
						
			/**
			 * Steve Pauses game & draws the quiz window
			 */
			// Draws the quiz window

			if (game.quizMode) {
				int clicked = game.input_handler.powerupclicked;
				if(game.updates){
					currQuiz = game.quiz_bank[game.rand.nextInt(15)];
					while (true) {
						if(currQuiz == null)
							System.out.println("null");
						if (currQuiz.asked == false) {
							game.map.power_ups.get(clicked).quiz = currQuiz;
							break;
						} else {
							currQuiz = game.quiz_bank[game.rand.nextInt(15)];
						}
					}
					game.updates = false;
				}
				g.setColor(Color.CYAN);
				g.drawRect((int) (game.screen_width * .2),
						(int) (game.screen_height * .2),
						(int) (game.screen_width * .6),
						(int) (game.screen_height * .6));
				Color myColor = new Color(0, 0, 0, 200);
				g.setColor(myColor);
				g.fillRect((int) (game.screen_width * .2),
						(int) (game.screen_height * .2),
						(int) (game.screen_width * .6),
						(int) (game.screen_height * .6));
				g.setColor(Color.GREEN);
				g.setFont(f3);
				g.drawString(currQuiz.question,
						(int) (.31 * game.screen_width),
						(int) (.24 * game.screen_height));
				g.setColor(Color.GREEN);
				g.drawImage(raindrop, (int) (.29 * game.screen_width),
						(int) (.28 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30), null);
				g.drawImage(raindrop, (int) (.29 * game.screen_width),
						(int) (.40 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30), null);
				g.drawImage(raindrop, (int) (.29 * game.screen_width),
						(int) (.52 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30), null);
				g.drawImage(raindrop, (int) (.29 * game.screen_width),
						(int) (.64 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30), null);
				g.drawRect((int) (.29 * game.screen_width),
						(int) (.28 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30));
				g.drawRect((int) (.29 * game.screen_width),
						(int) (.40 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30));
				g.drawRect((int) (.29 * game.screen_width),
						(int) (.52 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30));
				g.drawRect((int) (.29 * game.screen_width),
						(int) (.64 * game.screen_height),
						(int) (game.screen_width / 30),
						(int) (game.screen_width / 30));
				g.setFont(f2);
				g.drawString(currQuiz.choices[0],
						(int) (game.screen_width * .36),
						(int) (game.screen_height * .32));
				g.drawString(currQuiz.choices[1],
						(int) (game.screen_width * .36),
						(int) (game.screen_height * .44));
				g.drawString(currQuiz.choices[2],
						(int) (game.screen_width * .36),
						(int) (game.screen_height * .56));
				g.drawString(currQuiz.choices[3],
						(int) (game.screen_width * .36),
						(int) (game.screen_height * .68));
	
				// Mason
				// when the first quiz is displayed
				if (!first_quiz) {
					g.setColor(Color.YELLOW);
					g.drawLine(
							(int) (game.screen_width * .11),		
							(int) (game.screen_height * .16),
							(int) (.29 * game.screen_width),
							(int) (.28 * (game.screen_height+game.screen_width/15)));
					g.drawLine(
							(int) (game.screen_width * .11),		
							(int) (game.screen_height * .16),
							(int) (.29 * game.screen_width),
							(int) (.38 * (game.screen_height+game.screen_width/15)));
					g.drawLine(
							(int) (game.screen_width * .11),		
							(int) (game.screen_height * .16),
							(int) (.29 * game.screen_width),
							(int) (.49 * (game.screen_height+game.screen_width/15)));
					g.drawLine(
							(int) (game.screen_width * .11),		
							(int) (game.screen_height * .16),
							(int) (.29 * game.screen_width),
							(int) (.60 * (game.screen_height+game.screen_width/15)));
					g.drawOval(
							(int) (.29 * game.screen_width),
							(int) (.28 * game.screen_height),
							(int) (game.screen_width / 30),
							(int) (game.screen_width / 30));
					g.drawOval(
							(int) (.29 * game.screen_width),
							(int) (.40 * game.screen_height),
							(int) (game.screen_width / 30),
							(int) (game.screen_width / 30));
					g.drawOval(
							(int) (.29 * game.screen_width),
							(int) (.52 * game.screen_height),
							(int) (game.screen_width / 30),
							(int) (game.screen_width / 30));
					g.drawOval(
							(int) (.29 * game.screen_width),
							(int) (.64 * game.screen_height),
							(int) (game.screen_width / 30),
							(int) (game.screen_width / 30));
					g.setColor(Color.RED);
					g.setFont(f1);
					g.drawString(
							"Read the question and",
							(int) (game.screen_width * .025),
							(int) (game.screen_height*.1));
					g.drawString(
							"choose the best answer!",
							(int) (game.screen_width * .025),
							(int) (game.screen_height*.14));
				}
			}
			
			if (game.quizFeedbackMode) {
				int clicked = game.input_handler.powerupclicked;
				game.updates = true;
				g.setColor(trans_grey);
				g.fillRect((int) (game.screen_width * .2),
						(int) (game.screen_height * .2),
						(int) (game.screen_width * .6),
						(int) (game.screen_height * .6));
				g.setColor(Color.BLACK);
				g.setFont(f1);
				g.drawString(currQuiz.feedback_string,
						(int) (.29 * game.screen_width),
						(int) (.24 * game.screen_height));
				if(currQuiz.answered_correctly){
					g.drawString(game.map.power_ups.get(clicked).effect_string1,
							(int) (.29 * game.screen_width),
							(int) (.30 * game.screen_height));
					g.drawString(game.map.power_ups.get(clicked).effect_string2,
							(int) (.29 * game.screen_width),
							(int) (.38 * game.screen_height));
				} else{
					g.drawString("The correct answer was: ",
								(int)(.40 * game.screen_width), 
								(int)(.33 * game.screen_height));
					g.drawString(currQuiz.choices[currQuiz.answer],
								(int)(.29 * game.screen_width), 
								(int)(.38 * game.screen_height));
				}
				g.drawImage(city1,
						(int) (.25 * game.screen_width),
						(int) (.45 * game.screen_height),
						(int) (.5 * game.screen_width),
						(int) (.3 * game.screen_height), null);
				if(game.feedbackStartTime < 0){
					game.feedbackStartTime = System.currentTimeMillis();
				}
				else if((System.currentTimeMillis() - game.feedbackStartTime)>4500){
					game.quizFeedbackMode = false;
					game.pause_or_unpause();
				}
				
				g.setFont(f2);
				g.setColor(Color.BLACK);
				g.drawString("Returning to game in... " + (int)((game.feedbackStartTime+4500)-System.currentTimeMillis())/1000 + " seconds.", 
						(int)(.43 * game.screen_width), 
						(int)(.77 * game.screen_height));
			}


			// draws all necessary game over information
			if (game.game_time <= 0) {

				g.setColor(Color.GRAY);
				g.fillRect((int) (game.screen_width * .25),
						(int) (game.screen_height * .25),
						(int) (game.screen_width * .5),
						(int) (game.screen_height * .5));
				g.setColor(Color.BLACK);
				g.setFont(f1);
				g.drawString("The Storm Has Passed!",
						(int) (game.screen_width * .39),
						(int) (game.screen_height * .33));

				g.drawImage(back_to_menu, (int) (0.25 * game.screen_width),
						(int) (0.55 * game.screen_height),
						(int) (0.2 * game.screen_width),
						(int) (0.2 * game.screen_height), null);

				g.setFont(f3);
				g.setColor(Color.BLUE);

				g.drawString("Oil:", (int) (game.screen_width * .33),
						(int) (game.screen_height * .43));
				g.drawString(
						Integer.toString(game.player.player_score.oil_count)
								+ " x 10  = "
								+ Integer
										.toString(game.player.player_score.oil_count * 10),
						(int) (game.screen_width * .46),
						(int) (game.screen_height * .43));

				g.drawString("Fertilizer:", (int) (game.screen_width * .33),
						(int) (game.screen_height * .46));
				g.drawString(
						Integer.toString(game.player.player_score.fertilizer_count)
								+ " x 10  = "
								+ Integer
										.toString(game.player.player_score.fertilizer_count * 10),
						(int) (game.screen_width * .46),
						(int) (game.screen_height * .46));

				g.setColor(Color.RED);
				g.drawString("Oil:", (int) (game.screen_width * .33),
						(int) (game.screen_height * .49));
				g.drawString(
						Integer.toString(game.player.player_score.oil_lost)
								+ " x 10  = "
								+ Integer
										.toString(-1
												* (game.player.player_score.oil_lost * 10)),
						(int) (game.screen_width * .46),
						(int) (game.screen_height * .49));
				g.drawString("Fertilizer:", (int) (game.screen_width * .33),
						(int) (game.screen_height * .52));
				g.drawString(
						Integer.toString(game.player.player_score.fertilizer_lost)
								+ " x 10  = "
								+ Integer
										.toString(-1
												* (game.player.player_score.fertilizer_lost * 10)),
						(int) (game.screen_width * .46),
						(int) (game.screen_height * .52));

				g.setFont(f1);

				g.setColor(Color.BLACK);
				g.drawString(
						"Total "
								+ Integer
										.toString(game.player.player_score.game_score),
						(int) (game.screen_width * .57),
						(int) (game.screen_height * .52));

				g.setColor(Color.BLACK);
				g.setFont(f4);

				if(game.arcademode){
					g.drawString("Arcade High Score List",
							(int) (game.screen_width * .45),
							(int) (game.screen_height * .58));
				}else{
					g.drawString("High Score List",
							(int) (game.screen_width * .45),
							(int) (game.screen_height * .58));
				}
				for (int i = 0; i < 10; i++) {
					try {
						this.Score_data.add(i,HighScoreList.getScores(game.arcademode).get(i));
					} catch (Exception e) {
						System.out.println("not 10 scores");
					}
				}

				double h = 0.63;
				// rank
				String m;
				for (int i = 0; i < 3; i++) {
					m = Score_data.get(i).display()[0];
					if(m.length() > 3){
						m = m.substring(0, 3);
					}
					g.drawString(m,
							(int) (0.43 * game.screen_width),
							(int) (h * game.screen_height));
					h = h + 0.03;
				}

				// name
				h = 0.63;
				for (int i = 0; i < 3; i++) {
					m = Score_data.get(i).display()[1];
					if(m.length() > 6){
						m = m.substring(0, 6);
					}
					g.drawString(m,
							(int) (0.46 * game.screen_width),
							(int) (h * game.screen_height));
					h = h + 0.03;
				}

				// score
				h = 0.63;
				for (int i = 0; i < 3; i++) {
					g.drawString(Score_data.get(i).display()[2],
							(int) (0.52 * game.screen_width),
							(int) (h * game.screen_height));
					h = h + 0.03;
				}

				// date
				h = 0.63;
				for (int i = 0; i < 3; i++) {
					g.drawString(Score_data.get(i).display()[3],
							(int) (0.58 * game.screen_width),
							(int) (h * game.screen_height));
					h = h + 0.03;
				}
				
				

				// to show where current players score lies
				try {
					ScoreData d4 = HighScoreList.getScores(game.arcademode).get(
							game.player.get_players_rank());
					g.drawString(
							Integer.toString(game.player.get_players_rank() + 1)
									+ ". ", (int) (game.screen_width * .43),
							(int) (game.screen_height * .72));
					String n = d4.name;
					if(n.length() > 6){
						n = n.substring(0, 6);
					}
					g.drawString(n, (int) (game.screen_width * .46),
							(int) (game.screen_height * .72));
					g.drawString(Double.toString(d4.score),
							(int) (game.screen_width * .52),
							(int) (game.screen_height * .72));
					g.drawString(d4.date, (int) (game.screen_width * .58),
							(int) (game.screen_height * .72));
					g.setColor(Color.CYAN);

					g.drawRect((int) (game.screen_width * .42),
							(int) (game.screen_height * .695),
							(int) (.23 * game.screen_width),
							(int) (.035 * game.screen_height));
				} catch (NullPointerException e) {
				}
			}
		}
	}
}