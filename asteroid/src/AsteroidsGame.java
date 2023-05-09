import java.util.ArrayList;

/**
 * The main asteroids game simulation class. This class controls the simulation by
 * setting up the game, telling the other classes to update themselves, adding more
 * asteroids when necessary, freezing the game when it is over, detecting collisions
 * updating the game state, and telling the other classes when to draw themselves.
 * 
 * @author: C. Fox, Ryan Gross
 * @version 3/19
 */
public class AsteroidsGame
{
  private ArrayList<Drawable> drawnObjects;    // all the stuff drawn to the screen
  private ArrayList<Updateable> movingObjects; // all the things that move
  private final Ship ship;                     // for detecting ship collisions
  private final Scoreboard scoreboard;         // for checking if the game is over
  private final int asteroidStock;             // how many asteroids to start with
  private int asteroidsLeft;                   // current asteroid count during the game
  
  /**
   * Allocate the stars, ship, and asteroids.
   * 
   * @param numAsteroids how many asteroids to start with
   */
  public AsteroidsGame(int numAsteroids)
  {
    asteroidStock = numAsteroids;
    drawnObjects  = new ArrayList<>();
    movingObjects = new ArrayList<>();
    
    // put the stars and scoreboard in to drawn object
    for (int i = 0; i < GameConstants.NUMBER_OF_STARS; i++)
      drawnObjects.add(new Star());
    scoreboard = new Scoreboard();
    drawnObjects.add(scoreboard);
    
    // put the ship in
    ship = new Ship();
    drawnObjects.add(ship);
    movingObjects.add(ship);
    

    // add the asteroids
    replenishAsteroids();
  }

  /**
   * Check if the game is over, tell all the moving objects in the game to update
   * themselves, perhaps add a saucer and fire bullets, check for collisions, remove
   * all the defunct objects from the lists of drawn and moving objects, and
   * replenish the asteroids if necessary.
   */
  public void update()
  {
    // freeze play if the game is over
    if (scoreboard.isGameOver()) return;
    
    // update all moving objects
    for (Updateable o : movingObjects) o.update();
    
    // perhaps add a saucer
    if (GameConstants.GENERATOR.nextDouble() <= GameConstants.SAUCER_APPEARANCE_PROB)
    {
      Saucer saucer = new Saucer();
      drawnObjects.add(saucer);
      movingObjects.add(saucer);
    }
    
    if(GameConstants.GENERATOR.nextDouble() <= GameConstants.ASTONAUT_PROBABILITY)
    {
      Astronaut astro = new Astronaut();
      drawnObjects.add(astro);
      movingObjects.add(astro);
    }
    
    // perhaps fire bullets
    if (StdDraw.hasNextKeyTyped() && StdDraw.nextKeyTyped() == ' ')
    {
      Bullet bullet = new Bullet(ship.getLocation(), ship.getHeading());
      drawnObjects.add(bullet);
      movingObjects.add(bullet);
    }

    // check for collisions
    detectCollisions();
    
    // get rid of defunct objects (remember that index 0 is the ship)
    for (int i = movingObjects.size()-1; 0 < i; i--)
    {
      Projectile projectile = (Projectile)movingObjects.get(i);
      if (projectile.isDefunct())
      {
        drawnObjects.remove((Drawable)(movingObjects.get(i)));
        movingObjects.remove(i);
      }
    }
    
    // add more asteroids if necessary
    if (asteroidsLeft <= 0)
      replenishAsteroids();
  }

  /**
   * Tell all the drawn objects to draw themselves.
   */
  public void draw()
  {
    StdDraw.setPenRadius(GameConstants.PEN_RADIUS);
    StdDraw.setPenColor(StdDraw.WHITE);

    for (Drawable o : drawnObjects) o.draw();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  ///   Private Methods   ///////////////////////////////////////////////////////////

  /**
   * Make all the asteroids at the start of the game or when they are all destroyed.
   */
  private void replenishAsteroids()
  {
    for (int i = 0; i < asteroidStock; i++)
    {
      Asteroid asteroid = new Asteroid();
      drawnObjects.add(asteroid);
      movingObjects.add(asteroid);
    }
    asteroidsLeft = asteroidStock;
  }

  /**
   * Figure out whether saucers or asteroids have hit the ship, and it so then
   * destroy both. Then figure out whether bullets have hit an asteroid or saucer,
   * and if so then destroy both.
   * 
   * Because the first element in the movingObjects list is the ship, we need only
   * check from index 1 forward in the list to examine the asteroids, bullets, and
   * saucers (the Projectiles).
   */
  private void detectCollisions()
  {
    // check for collisions with the ship
    Point shipLocation = ship.getLocation();
    for (int i = 1; i < movingObjects.size(); i++)
    {
      Projectile projectile = (Projectile)movingObjects.get(i);
      
      if (projectile instanceof Bullet) continue;
      Point oLocation = projectile.getLocation();
      double criticalDistance = ship.getSize()+projectile.getSize();
     
      if (criticalDistance < shipLocation.distance(oLocation)) continue;
      projectile.setDefunct();
      
      if (projectile instanceof Asteroid) asteroidsLeft--;
      scoreboard.decrementLives();
      
      if(projectile instanceof Astronaut)
        scoreboard.incrementLives();
      
      ship.reset();
    }
      
    // now check for collisions between bullets and other projectiles
    for (int i = 1; i < movingObjects.size(); i++)
    {
      Projectile projectile1 = (Projectile)movingObjects.get(i);
      for (int j = i+1; j < movingObjects.size(); j++)
      {
        Projectile projectile2 = (Projectile)movingObjects.get(j); 
        if (  projectile1 instanceof Bullet  &&   projectile2 instanceof Bullet) continue;
        if (!(projectile1 instanceof Bullet) && !(projectile2 instanceof Bullet)) continue;
        if (projectile1.isDefunct() || projectile2.isDefunct) continue; 
        Point location1 = projectile1.getLocation();
        Point location2 = projectile2.getLocation();
        double criticalDistance = projectile1.getSize()+projectile2.getSize();
        if (criticalDistance < location1.distance(location2)) continue;
        scoreboard.incrementScore(projectile1.getPoints() + projectile2.getPoints());
        projectile1.setDefunct();
        projectile2.setDefunct();
        if (projectile1 instanceof Asteroid || projectile2 instanceof Asteroid) asteroidsLeft--;
      }
    }
  }
}
