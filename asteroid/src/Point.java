/**
 * Encapsulation of a two-dimensional point.
 * 
 * @author Nathan Sprague
 * @author C. Fox
 * @version V2.1 3/19
 */
public class Point
{
  protected double xPosition;
  protected double yPosition;

  /**
   * Construct a point object.
   * 
   * @param xPosition
   *          - position on the X-axis
   * @param yPosition
   *          - position on the Y-axis
   */
  public Point(double xPosition, double yPosition)
  {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  /**
   * Copy constructor.
   * 
   * @param other
   *          The point to copy
   */
  public Point(Point other)
  {
    this(other.getX(), other.getY());
  }

  /**
   * @return the X coordinate
   */
  public double getX()
  {
    return xPosition;
  }

  /**
   * @return the Y coordinate
   */
  public double getY()
  {
    return yPosition;
  }

  /**
   * Set the x position of the point.
   * 
   * @param x The new X position
   */
  public void setX(double x)
  {
    this.xPosition = x;
  }

  /**
   * Set the y position of the point.
   * 
   * @param y The new y position.
   */
  public void setY(double y)
  {
    this.yPosition = y;
  }

  /**
   * Move the point according the the provided vector.
   * 
   * @param vector
   *          The motion vector (probably encoding a velocity)
   */
  public void move(Vector2D vector)
  {
    setX(getX() + vector.getX());
    setY(getY() + vector.getY());
  }

  /**
   * Move the point according the the provided vector and wrap around
   * if the point is moved outside the range (0..maxX, 0..maxY).
   * 
   * @param vector the motion vector (probably encoding a velocity)
   * @param maxX highest allowed x value
   * @param maxY highest allowed y value
   */
  public void moveAndWrap(Vector2D vector, double maxX, double maxY)
  {
    xPosition += vector.getX();
    yPosition += vector.getY();
    if (xPosition < 0) xPosition = maxX;
    else if (maxX < xPosition) xPosition = 0;
    if (yPosition < 0) yPosition = maxY;
    else if (maxY < yPosition) yPosition = 0;
  }

  /**
   * Compute the distance between two points.
   * @param other the other point
   * @return the Euclidean distance between this and the other points
   */
  public double distance(Point other)
  {
    double x1 = getX();
    double y1 = getY();
    double x2 = other.getX();
    double y2 = other.getY();
    double xDiff = x1-x2;
    double yDiff = y1-y2;
    return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
  }

  /**
   * @return String representation of this point as "Point[xPosition=x, yPosition=y]"
   */
  public String toString()
  {
    return "Point[xPosition=" + xPosition + ", yPosition=" + yPosition + "]";
  }

}
