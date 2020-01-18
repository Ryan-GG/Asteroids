import java.awt.Color;
import java.util.Random;

/**
 * This class stores constants related to the Asteroids application.
 * 
 * @author Nathan Sprague
 * @author Fox
 * @version V1.1, 3/19
 */
public class GameConstants
{
  public static final int DRAW_DELAY = 10;       // In milliseconds.
  public static final double PEN_RADIUS = 0.002;

  public static final double STAR_RADIUS = 1;
  public static final int NUMBER_OF_STARS = 100;
  
  public static final double ASTRONAUT_RADIUS = 3;
  public static final double ASTONAUT_PROBABILITY = 0.00099;

  public static final Color SCREEN_COLOR = new Color(0, 0, 0);
  public static final int SCREEN_WIDTH = 480;
  public static final int SCREEN_HEIGHT = 480;

  public static final int DEFAULT_ASTEROIDS_PER_LEVEL = 10;
  public static final double ASTEROID_RADIUS = 30;
  public static final int ASTEROID_POINTS = 20;
  public static final int ASTEROID_SPEED = 1;

  public static final int SAUCER_WIDTH = 20;
  public static final int SAUCER_HEIGHT = 10;
  public static final int SAUCER_SPEED = 2;
  public static final int SAUCER_POINTS = 200;
  public static final double SAUCER_DIRECTION_PROB = 0.05;
  public static final double SAUCER_APPEARANCE_PROB = 0.002;
  

  public static final int SHIP_WIDTH = 10;
  public static final int SHIP_HEIGHT = 20;
  public static final int SHIP_START_SPEED = 0;
  public static final double SHIP_START_HEADING = Math.PI/2;
  public static final double SHIP_FRICTION = 0.99;
  public static final double SHIP_ACCELERATION = 0.1;
  public static final double SHIP_TURN_SPEED = 0.1;
  
  public static final int BULLET_LIFETIME = 20;
  public static final int BULLET_SPEED = 20;
  public static final double BULLET_RADIUS = 1.5;
  
  public static final int SCORE_X = 60;
  public static final int SCORE_Y = SCREEN_WIDTH-20;
  public static final int LIVES_X = 60;
  public static final int LIVES_Y = SCREEN_WIDTH-60;

  public static final int NUMBER_OF_LIVES = 3;
  
  public static final Random GENERATOR = new Random();

}
