import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Collisable
{
  BufferedImage image;
  int x;
  int y;
  int width;
  int height;
  
  public Collisable(int nx, int ny, BufferedImage otherImage)
  {
    x = nx;
    y = ny;
    image = otherImage;
    width = otherImage.getWidth();
    height = otherImage.getHeight(); //-60
  }
  
  public void drawTo(Graphics g)
  {
    g.drawImage(image, x, y, null);
  }
    
  public void drawTo(Graphics g, int hx, int hy)
  {
    g.drawImage(image, x + hx, y + hy, null);
  }
  
  /* Return true if the point is contained inside the rectangle for this
     Collisable, false otherwise.
     FILL THIS IN!
   */
  public boolean containsPoint(int pointX, int pointY)
  {
    return pointX > x &&
           pointX < x + width &&
           pointY > y &&
           pointY < y + height;
  }
  
  /* Return true if the rectangles for this Collisable and the parameter other
     are intersecting, false otherwise.
     FILL THIS IN!
   */
  public boolean intersects(Collisable other)
  {
    return x + width > other.x &&
           y + height > other.y &&
           x < other.x + other.width &&
           y < other.y + other.height;
  }
  
  /* Movement methods for our square.
     We will modify this in a future file to stop our player square from being
     able to run into other squares.
   */
  public void moveRight(int amount)
  {
    x += amount;
  }
  
  public void moveLeft(int amount)
  {
    x -= amount;
  }
  
  public void moveUp(int amount)
  {
    y -= amount;
  }
  
  public void moveDown(int amount)
  {
    y += amount;
  }
}
