
/**
 * Common features of bullets, saucers, and asteroids.
 * 
 * @author C. Fox
 * @version 2/19
 */
public abstract class Projectile implements Drawable, Collidable, Updateable
{
  protected Point location;     // where the entity is in space
  protected Vector2D velocity;  // the direction and speed of the entity
  protected boolean isDefunct;  // is this entity destroyed?

  /**
   * Create a projectile with the specified location and velocity,
   * and mark is as not defunct.
   * @param startLocation where the entity starts out
   * @param startVelocity the velocity of the entity
   */
  public Projectile(Point startLocation, Vector2D startVelocity)
  {
    location = startLocation;
    velocity = startVelocity;
    isDefunct = false;
  }

  /**
   * Create a projectile with a randomly determined initial location and
   * direction of motion, but a given speed, that is not defunct.
   * @param speed how fast the new projectile is moving
   */
  public Projectile(double speed)
  {
    double x = GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_WIDTH;
    double y = GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_HEIGHT;
    location = new Point(x,y);

    double heading = GameConstants.GENERATOR.nextDouble() * 2 * Math.PI;
    velocity = new Vector2D(heading, speed);
    
    isDefunct = false;
  }

  /**
   * Say whether this projectile is defunct (destroyed).
   * @return true iff this entity is destroyed
   */
  public boolean isDefunct()
  {
    return isDefunct;
  }

  /**
   * Mark this entity as defunct (destroyed).
   */
  public void setDefunct()
  {
    isDefunct = true;
  }

  @Override
  public Point getLocation()
  {
    return location;
  }

  /**
   * Every projectile must have a point value accruing to the player when
   * it is destroyed.
   * @return how many points for destroying this projectile
   */
  public abstract int getPoints();

}
