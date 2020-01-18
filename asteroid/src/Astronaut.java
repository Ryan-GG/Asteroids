
public class Astronaut extends Projectile
{

  public Astronaut()
  {
    super(1);
  }

  @Override
  public void update()
  {
    location.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH-1, GameConstants.SCREEN_HEIGHT-1);
  }

  @Override
  public void draw()
  {
    StdDraw.filledSquare(location.getX(), location.getY(), GameConstants.ASTRONAUT_RADIUS);
  }
  

  @Override
  public double getSize()
  {
    return GameConstants.ASTRONAUT_RADIUS;
  }

  @Override
  public int getPoints()
  {
    // TODO Auto-generated method stub
    return 0;
  }
  
}
