/* Basic example of how to do animation.

   Make sure to call panel.mainLoop() in your main method!
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class AnimatedSpriteExample extends JPanel implements KeyListener
{
  int maxSpeed = 5;
  boolean foot1 = true;
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  public static final int FPS = 24;
  public static final int MSPF = 1000/FPS;
  int nx;
  int ny;

  BufferedImage background;

  EntityAnimation entity;

  public AnimatedSpriteExample()
  {
    BufferedImage[] images = new BufferedImage[13];
    images[0] = readImage("Sprite Images/Left1.gif");
    images[1] = readImage("Sprite Images/Left2.gif");
    images[2] = readImage("Sprite Images/Left4.gif");
    
    images[3] = readImage("Sprite Images/Right1.gif");
    images[4] = readImage("Sprite Images/Right2.gif");
    images[5] = readImage("Sprite Images/Right4.gif");
    
    images[6] = readImage("Sprite Images/Forward1.gif");
    images[7] = readImage("Sprite Images/Forward2.gif");
    images[8] = readImage("Sprite Images/Forward4.gif");
    
    images[9] = readImage("Sprite Images/Backward1.gif");
    images[10] = readImage("Sprite Images/Backward2.gif");
    images[11] = readImage("Sprite Images/Backward4.gif");
    
    background = readImage("Sprite Images/BasementBackground(1).gif");
    
    nx = 300;
    ny = 300;
    entity = new EntityAnimation(-300, 90, images);
    entity.topBound = -270;
    entity.bottomBound = 110;
    entity.leftBound = -315;
    entity.rightBound = 130;
      addKeyListener(this);
      setFocusable(true);
    
  }
  
  /* Update the image and redraw the screen */
  public void mainLoop()
  {
    long nextTick = System.currentTimeMillis();
    long curTime;
    
 
    while(true)
    {
    if(!(entity.middleAnimation())) 
    {
       if(rightPressed)
      {
        triggerRightWalk();
      }
     else if(leftPressed)
      {
       triggerLeftWalk();
       
      }
     else if(upPressed)
      {
       triggerForwardWalk();

      }
     else if(downPressed)
      {
       triggerBackwardWalk();
      }
    }
    if(rightPressed)
      {
        entity.moveX(maxSpeed);
        if(entity.x > entity.rightBound) {
        entity.moveX(-maxSpeed);
        }
      }
      else if(leftPressed)
      {
        entity.moveX(-maxSpeed);
        if(entity.x < entity.leftBound) {
        entity.moveX(maxSpeed);
        }
      }
      else if(upPressed)
      {
        entity.moveY(-maxSpeed);
        if(entity.y < entity.topBound) {
        entity.moveY(maxSpeed);
        }
      }
      else if(downPressed)
      {
        entity.moveY(maxSpeed);
        if(entity.y > entity.bottomBound) {
        entity.moveY(-maxSpeed);
        }
      }

/*    else
    {
      if(!(rightPressed || leftPressed || upPressed || downPressed))
      {
        entity.clearAnimation();
      } 
    } */
      

      // change game state
      entity.step();
      
      // wait some time
      curTime = System.currentTimeMillis();
      if(nextTick > curTime)
      {
        try
        {
          Thread.sleep(nextTick - curTime);
        }
        catch(Exception e){e.printStackTrace();}
      }
      
      nextTick += MSPF;
      
      // redraw screen
      repaint();
    }
  }
 
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0,0,1800,1800);
    g.drawImage(background, -entity.x,-entity.y, null);
    entity.drawTo(g,nx,ny);
    g.setColor(Color.WHITE);
    g.drawString(entity.x +", "+ entity.y,1030, 20);
    
  }
  
  public void triggerLeftWalk()
  {
    if(foot1 == true) {
    entity.startAnimationSequence(new int[][]{
        {1,7},
        {0,7},
     }
   );
   }
     else{
     entity.startAnimationSequence(new int[][]{
        {2,7},
        {0,7},
       }
    );
    }
    foot1 = !foot1;
    entity.setIdleFrame(0);
  }
  public void triggerRightWalk()
  {
    if(foot1 == true) 
    {
    entity.startAnimationSequence(new int[][]{
        {4,7},
        {3,7},
      }
    );
  }
    else
    {
    entity.startAnimationSequence(new int[][]{
        {5,7},
        {3,7},
    }
   ); 
    }
    foot1 = !foot1;
    entity.setIdleFrame(3);
  }
  public void triggerForwardWalk()
  {
  if(foot1 == true) 
  {
    entity.startAnimationSequence(new int[][]{
        {7,7},
        {6,7},
      }
    );
  }
  else
  {
  entity.startAnimationSequence(new int[][] {
   {8,7},
   {6,7},
  }
  );
  }
    foot1 = !foot1;
    entity.setIdleFrame(6);
  }
  public void triggerBackwardWalk()
  {
  if(foot1 == true)
  {
    entity.startAnimationSequence(new int[][]{
        {10,7},
        {9,7},
        
      }
    );
  }
  else
  {
   entity.startAnimationSequence(new int[][]{
        {11,7},
        {9,7},
     }
   );
  }
    foot1 = !foot1;
    entity.setIdleFrame(9);
  }
    public static BufferedImage readImage(String infile)
  {
    try
    {
      BufferedImage ret = ImageIO.read(new File(infile));
      return ret;
    }
    catch(Exception e){System.out.println(e.getMessage()+ infile); return null;}
  }
    public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D)
    {
      rightPressed = true;
    }
    else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A)
    {
      leftPressed = true;
    }
    else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W)
    {
      upPressed = true;
    }
    else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S)
    {
      downPressed = true;
    }
  }
  
  public void keyReleased(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D)
    {
      rightPressed = false;
    }
    else if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A)
    {
      leftPressed = false;
    }
    else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W)
    {
      upPressed = false;
    }
    else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S)
    {
      downPressed = false;
    }
  }
  public void keyTyped(KeyEvent e)
  {
  }

}