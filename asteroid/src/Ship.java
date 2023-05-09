
/**
 * The space ship class.
 * 
 * @author C. Fox, Ryan Gross
 * @version 2/19
 */
public class Ship implements Drawable, Collidable, Updateable
{
  private Pose pose;          // location and heading of the ship
  private Vector2D velocity;  // speed and direction of motion of the ship
  
  /**
   * Make a new ship in the middle of the screen pointing up and not moving.
   */
  public Ship()
  {
    reset();
  }

  /**
   * Place the ship in the middle of the screen, pointing up,
   * and not moving.
   */
  public void reset()
  {
    pose = new Pose(GameConstants.SCREEN_WIDTH/2,
                    GameConstants.SCREEN_HEIGHT/2,
                    GameConstants.SHIP_START_HEADING);
    velocity = new Vector2D(GameConstants.SHIP_START_HEADING,
                            GameConstants.SHIP_START_SPEED);
  }

  /**
   * Reveal the direction in which the ship is pointed.
   * @return the current heading
   */
  public double getHeading()
  {
    return pose.getHeading();
  }

  @Override
  public void update()
  {
    // rotate
    if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
      pose.setHeading(pose.getHeading()+GameConstants.SHIP_TURN_SPEED);
    else if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
      pose.setHeading(pose.getHeading()-GameConstants.SHIP_TURN_SPEED);

    // accelerate or decelerate
    if (   StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN)
        || StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP))
    {
      GameUtils.applyThrust(velocity, pose.getHeading(), GameConstants.SHIP_ACCELERATION);
    }
    else
      velocity.setMagnitude(velocity.getMagnitude()*GameConstants.SHIP_FRICTION);

    pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH-1, GameConstants.SCREEN_HEIGHT-1);
  }

  @Override
  public void draw()
  {
    GameUtils.drawPoseAsTriangle(pose, GameConstants.SHIP_WIDTH, GameConstants.SHIP_HEIGHT);
  }
  
  @Override
  public Point getLocation()
  {
    return new Point(pose.getX(), pose.getY());
  }

  @Override
  public double getSize()
  {
    return GameConstants.SHIP_HEIGHT/2;
  }
  
}
