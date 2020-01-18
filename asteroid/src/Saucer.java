
/**
 * A flying saucer that can run into the ship and destroy it.
 * 
 * @author C. Fox
 * @version 2/19
 */
public class Saucer extends Projectile
{

  /**
   * Make a saucer with a random location and direction but a fixed speed.
   */
  public Saucer()
  {
    super(GameConstants.SAUCER_SPEED);
  }

  @Override
  public void update()
  {
    if (GameConstants.GENERATOR.nextDouble() < GameConstants.SAUCER_DIRECTION_PROB)
    {
      double heading = GameConstants.GENERATOR.nextDouble() * 2 * Math.PI;
      velocity = new Vector2D(heading, GameConstants.SAUCER_SPEED);
    }
    location.move(velocity);
    double x = location.getX();
    double y = location.getY();
    if (   x < 0 || GameConstants.SCREEN_WIDTH <= x
        || GameConstants.SCREEN_HEIGHT <= y || y < 0) isDefunct = true;
  }

  @Override
  public void draw()
  {
    StdDraw.rectangle(location.getX(), location.getY(),
          GameConstants.SAUCER_WIDTH/2, GameConstants.SAUCER_HEIGHT/2);
  }

  @Override
  public double getSize()
  {
    return GameConstants.SAUCER_WIDTH/2;
  }
  
  @Override
  public int getPoints()
  {
    return GameConstants.SAUCER_POINTS;
  }

}
