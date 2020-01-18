
/**
 * A star providing part of the backdrop for the game.
 * 
 * @author C. Fox
 * @version 2/19
 */
public class Star implements Drawable
{
  private double x;  // x coordinate of the star
  private double y;  // y coordinate of the star

  /**
   * Make a new star at a random location.
   */
  public Star()
  {
    x = GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_WIDTH;
    y = GameConstants.GENERATOR.nextDouble() * GameConstants.SCREEN_HEIGHT;
  }
  
  @Override
  public void draw()
  {
    StdDraw.filledCircle(x, y, GameConstants.STAR_RADIUS);
  }
}
