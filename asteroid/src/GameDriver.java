/**
 * Driver for the Asteroids application.
 * 
 * @author CS 159 Instructors
 * @version V1.0, 3/18
 *
 */
public class GameDriver
{

  /**
   * Create a game object and a display screen and execute the main update loop.
   * 
   * @param args
   *          - args[0] optional integer indicating the number of asteroids that appear on each
   *          level. If no argument is provided a default value will be used.
   */
  public static void main(String[] args)
  {
    int numAsteroids;
    AsteroidsGame sim;

    if (args.length > 0)
    {
      numAsteroids = Integer.parseInt(args[0]);
    }
    else
    {
      numAsteroids = GameConstants.DEFAULT_ASTEROIDS_PER_LEVEL;
    }

    sim = new AsteroidsGame(numAsteroids);

    StdDraw.setCanvasSize(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    StdDraw.setXscale(0, GameConstants.SCREEN_WIDTH);
    StdDraw.setYscale(0, GameConstants.SCREEN_HEIGHT);
    StdDraw.enableDoubleBuffering();

    while (true)
    {
      StdDraw.clear(GameConstants.SCREEN_COLOR);
      sim.update();
      sim.draw();
      StdDraw.show();
      StdDraw.pause(GameConstants.DRAW_DELAY);
    }

  }

}
