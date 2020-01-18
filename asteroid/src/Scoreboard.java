
/**
 * A display of the current score and lives remaining.
 * 
 * @author C. Fox
 * @version 2/19
 */
public class Scoreboard implements Drawable
{
  private int score;   // total of points for destroyed projectiles
  private int lives;   // how many lives remain
  
  /**
   * Initialize the scoreboard.
   */
  public Scoreboard()
  {
    score = 0;
    lives = GameConstants.NUMBER_OF_LIVES;
  }

  /**
   * Increase the score with points for a destroyed projectile.
   * @param inc how much to increase by
   */
  public void incrementScore(int inc)
  {
    score += inc;
  }
  
  /**
   * Decrease lives because the ship was destroyed.
   */
  public void decrementLives()
  {
    lives--;
  }
  
  public void incrementLives()
  {
    lives+=2;
  }

  /**
   * Indicate whether all lives have been used up.
   * @return true iff the lives counter is 0 (or less)
   */
  public boolean isGameOver()
  {
    return lives <= 0;
  }

  @Override
  public void draw()
  {
    StdDraw.text(GameConstants.SCORE_X, GameConstants.SCORE_Y, "Score :"+ score);
    StdDraw.text(GameConstants.LIVES_X, GameConstants.LIVES_Y, "Lives :"+ lives);
  }

}
