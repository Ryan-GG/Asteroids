/**
 * A bullet fired from the ship.
 * 
 * @author C. Fox
 * @version 2/19
 */
public class Bullet extends Projectile
{
  private int stepsRemaining;  // how much longer the bullet is alive

  /**
   * Create a new bullet with the standard speed and given location and heading.
   * @param startLocation where the bullet starts from
   * @param heading which direction the bullet moves
   */
  public Bullet(Point startLocation, double heading)
  {
    super(startLocation, new Vector2D(heading, GameConstants.BULLET_SPEED));
    stepsRemaining = GameConstants.BULLET_LIFETIME;
  }

  @Override
  public void update()
  {
    location.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    stepsRemaining--;
    if (stepsRemaining == 0) isDefunct = true;
  }

  @Override
  public void draw()
  {
    StdDraw.filledCircle(location.getX(), location.getY(), GameConstants.BULLET_RADIUS);
  }
  
  @Override
  public int getPoints()
  {
    return 0;
  }

  @Override
  public double getSize()
  {
    return GameConstants.BULLET_RADIUS;
  }

}
