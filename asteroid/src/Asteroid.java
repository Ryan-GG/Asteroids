
/**
 * An asteroid in the game.
 * 
 * @author: C. Fox
 * @version 2/19
 */
public class Asteroid extends Projectile
{
  /**
   * Make a new asteroid with a random location and direction (handled
   * by the super-class), and a fixed size and speed.
   */
  public Asteroid()
  {
    super(GameConstants.ASTEROID_SPEED);
  }

  @Override
  public void update()
  {
    location.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH-1, GameConstants.SCREEN_HEIGHT-1);
  }

  @Override
  public void draw()
  {
    StdDraw.circle(location.getX(), location.getY(), GameConstants.ASTEROID_RADIUS);
  }
  
  @Override
  public int getPoints()
  {
    return GameConstants.ASTEROID_POINTS;
  }

  @Override
  public double getSize()
  {
    return GameConstants.ASTEROID_RADIUS;
  }
  
}
