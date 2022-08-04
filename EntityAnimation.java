import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class EntityAnimation
{
  int x;
  int y;
  
  AnimatedSprite sprite;

  int xSpeed = 0;
  int ySpeed = 0;
  int topBound;
  int bottomBound;
  int leftBound;
  int rightBound;

  public EntityAnimation(int nx, int ny, BufferedImage[] spriteSheet)
  {
    x = nx;
    y = ny;
    
    sprite = new AnimatedSprite(spriteSheet);
  }
  
  public void drawTo(Graphics g)
  {
    sprite.drawTo(g,x,y);
  }
   public void drawTo(Graphics g, int xc, int yc)
  {
    sprite.drawTo(g,xc,yc);
  }

  
  // Advance the action by one game tick
  public void step()
  {
    move();
    sprite.animate();
  }
  public void setIdleFrame(int frame)
  {
    sprite.idleFrame = frame;
  }
  public boolean middleAnimation()
  {
    return sprite.currentlyPlayingAnimation != null;
  }
  public void clearAnimation()
  {
    sprite.currentlyPlayingAnimation = null;
  }
  
  // Trigger an animation sequence specified by the entered array
  // (see AnimatedSprite.java for the format of this array)
  public void startAnimationSequence(int[][] animationSequence)
  {
    sprite.startAnimationSequence(animationSequence); // pass the work along to AnimatedSprite
  }
  
  // Applies the speed to the position
  public void move()
  {
    moveX(xSpeed);
    moveY(ySpeed);
  }
  
  // Manually changes the position by the entered amount
  public void moveX(int amount)
  {
    x += amount;
  }
  
  public void moveY(int amount)
  {
    y += amount;
  }
}