package group2.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/**
 * Joe 4/2/13
 */

public class InputHandler implements KeyListener, MouseMotionListener,
		MouseListener {

	RapidRunoffGame game;
	JFrame frame;
	WaterObjects currently_clicked = null;
	int powerupclicked = 0;
	Buffer buffer_clicked = null;

	public InputHandler(RapidRunoffGame g) {
		this.game = g;

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	/**
	 * Joe
	 * Checks to see if we clicked on a WaterObject, and if we did, it will change the value
	 * of its is_clicked attribute to true.  When a WaterObject is placed in the correct bin, it is removed from 
	 * the screen, and the Player attribute player_score is updated accordingly.  If a WaterObject is clicked on 
	 * and the next click is not in the correct bin, then its is_clicked will become false and 
	 * currently_clicked will become null, allowing for the next WaterObject to be selected.
	 * 
	 * Mason
	 * Took out code relating to an object already being clicked and added it to the mouseRelease event below.
	 * 
	 * Mary
	 * added a portion to check if a powerUp was clicked/if riverBank was clicked
	 * 
	 * Steve
	 * checks if powerup is pressed, if so initiate quizMode. if in quizMode accept input for the quiz only.
	 * Mason
	 * reorganize and bug cleanup
	 */
	public void mousePressed(MouseEvent e) {

		double x = e.getX() / game.screen_width;
		double y = e.getY() / game.screen_height;
		System.out.println("(" + x + "," + y + ")");
		if (game.game_screen) {
			if (game.game_time <= 0) {
				if (x >= 0.25 && x <= 0.45 && y >= 0.55 && y <= 0.75) {
					game.reset();
				}
			}
			
			if (game.paused && !game.quizMode && !game.quizFeedbackMode && !game.score_up){
				if(x >= 0.4 && x <= 0.6 && y >= 0.4 && y <= 0.6){
					game.reset();
				}
			}
			if (game.quizMode) {
				// CHOICE A
				if (x > .29 && x < (.29 + 0.033) && y > .28
						&& y < (.28 + 0.033)) {
					if (game.map.power_ups.get(powerupclicked).quiz
							.checkChoice(0)) {
						game.map.power_ups.get(powerupclicked).deployPowerUp();
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
						game.player.player_score.game_score += 100;
					} else {
						game.map.power_ups.get(powerupclicked).ready = false;
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
					}
				}
				// CHOICE B
				if (x > .29 && x < (.29 + 0.033) && y > .4 && y < (.4 + 0.033)) {
					if (game.map.power_ups.get(powerupclicked).quiz
							.checkChoice(1)) {
						game.map.power_ups.get(powerupclicked).deployPowerUp();
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
						game.player.player_score.game_score += 100;
					} else {
						game.map.power_ups.get(powerupclicked).ready = false;
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
					}
				}
				// CHOICE C
				if (x > .29 && x < (.29 + .033) && y > .52 && y < (.52 + .033)) {
					if (game.map.power_ups.get(powerupclicked).quiz
							.checkChoice(2)) {
						game.map.power_ups.get(powerupclicked).deployPowerUp();
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
						game.player.player_score.game_score += 100;
					} else {
						game.map.power_ups.get(powerupclicked).ready = false;
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
					}
				}
				// CHOICE D
				if (x > .29 && x < (.29 + .033) && y > .64 && y < (.64 + .033)) {
					if (game.map.power_ups.get(powerupclicked).quiz
							.checkChoice(3)) {
						game.map.power_ups.get(powerupclicked).deployPowerUp();
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;	
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
						game.player.player_score.game_score += 100;
					} else {
						game.map.power_ups.get(powerupclicked).ready = false;
						game.map.power_ups.get(powerupclicked).quiz.asked = true;
						game.quizMode = false;
						game.quizFeedbackMode = true;
						DrawGame.first_quiz=true;
						DrawGame.first_powerup=true;
					}
				}
			} else if (x >= 0.02 && x <= 0.04 && y >= 0.02 && y <= 0.053
					&& !game.quizMode) {
				game.pause_or_unpause();
			} else {
				if(!game.paused && !game.score_up){
					if (currently_clicked == null) {
						for (int i = 0; i < game.map.power_ups.size(); i++) {
							PowerUp clicked = game.map.power_ups.get(i);
							if (clicked.checkIfInPowerUp(x, y) && clicked.ready) {
								powerupclicked = i;
								game.quizMode = true;
								game.feedbackStartTime = -1;
								if (!game.pause) {
									game.pause_or_unpause();
								}
								game.draw_game.repaint();
								break;
							}
						}
						for (WaterObjects o : game.map.water_objects) {
							if (o.checkClickRange(x, y)) {
								if (currently_clicked != null)
									currently_clicked.is_clicked = false;
								currently_clicked = o;
								o.is_clicked = true;
								break;
							}
						}
						for (Buffer b : game.map.buffers) {
							if (b.checkIfInBuffer(x, y)) {
								System.out.println("buffer");
								if (buffer_clicked != null)
									buffer_clicked.is_clicked = false;
								buffer_clicked = b;
								b.is_clicked = true;
								break;
							}
						}
					}
				}
			}
		} else if (game.home_screen) {
			if (x >= 0.38 && x <= 0.54 && y >= 0.86 && y <= 0.91) {
				game.home_screen = false;
				game.intro_screen = true;
			} else if (x >= 0.72 && x <= 0.95 && y >= 0.90 && y <= 0.96) {
				game.home_screen = false;
				game.high_score_screen = true;
				game.draw_game.repaint();
			}
			else if (x >= 0.067 && x <= 0.279 && y >= 0.91 && y <= 0.96) {
				GUIInput gui = new GUIInput(game,false,true);
				gui.createAndShowGUI();
				game.draw_game.repaint();
			}
		} else if (game.high_score_screen) {
			if (x >= 0.06 && x <= 0.19 && y >= 0.73 && y <= 0.82) {
				game.home_screen = true;
				game.high_score_screen = false;
				game.draw_game.repaint();
			}
		}
		else if (game.intro_screen){
			if (x >= 0.42 && x <= 0.57 && y >= 0.5 && y <= 0.65){
				game.code_screen =false;
				game.intro_screen=false;
				game.game_screen=true;
				game.pause_or_unpause();
			}
		}
	}

	@Override
	/**
	 * Mason
	 * This method is to allow the user to drag the water object to it's respective bin. If the
	 * mouse is released over the correct bin, the user gains points and the object disappears.
	 * If the mouse is released any place other than the right bin, the object will return to it's
	 * previous position. Uses above method as framework.
	 */
	public void mouseReleased(MouseEvent e) {
		double x = e.getX() / game.screen_width;
		double y = e.getY() / game.screen_height;
		if (currently_clicked != null) {
			if (currently_clicked.checkIfInBin(x, y)
					&& currently_clicked.is_alive) {
				currently_clicked.increment();
				game.map.items_removed++;
				currently_clicked.is_alive = false;
				currently_clicked.remove(true);
				currently_clicked.is_clicked = false;
				currently_clicked.setPos(x - 0.02, y - 0.02);
				currently_clicked = null;
			} else {
				currently_clicked.is_clicked = false;
				currently_clicked = null;
			}
			return;
		} else if (buffer_clicked != null) {
			for (RiverBank r : game.map.river_banks) {
				if (r.checkIfInBank(x, y) > -1) {
					System.out.println("in bank");
					Position p = r.checkCoordinates(x, y);
					r.addBuffer(buffer_clicked, (int)p.getXPos(), (int)p.getYPos());
					buffer_clicked.bank = r;
					game.map.buffers.remove(0);
					buffer_clicked.is_clicked = false;
					buffer_clicked.deployBuffer();
					buffer_clicked = null;
					return;
				}

			}
			buffer_clicked.is_clicked = false;
			buffer_clicked = null;
			return;
		}

	}
}
