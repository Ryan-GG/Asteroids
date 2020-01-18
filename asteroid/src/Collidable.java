
/**
 * Methods needed to determine whether two entities have collided.
 * 
 * @author C. Fox
 * @version 2/19
 */
public interface Collidable
{
  /**
   * Find the location of the entity.
   * @return the current location
   */
  public Point getLocation();
  
  /**
   * Find the size of the entity, which is the radius for circular entities,
   * or half the longest dimension of other entities.
   * @return the size of the entity
   */
  public double getSize();

}
