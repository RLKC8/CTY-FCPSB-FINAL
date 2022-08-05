import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JFrame;
public class FinalProject{
   public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      Random rng = new Random();
      AnimatedSpriteExample panel = new AnimatedSpriteExample();
      Player player=new Player(panel.player);
      int temp;
      int nextInt;
      boolean hasBasementKey=false;
      String nextLine;
      System.out.println("Please type out your character's name.");
      player.name=input.nextLine().toLowerCase();
      System.out.println("Ok, "+player.name+", let's start by assigning your skill points.");
      try{Thread.sleep(1000);}catch(InterruptedException e){}
      System.out.println("You have 10 points to distribute among strength, dexterity, constitution, wisdom, and magic.");
      try{Thread.sleep(1000);}catch(InterruptedException e){}
      System.out.println("You start with a value of 3 in each category.");
      try{Thread.sleep(1000);}catch(InterruptedException e){}
      System.out.println("Let's start with strength. How many points would you like to alot to strength?");
      temp=0;
      while (temp==0){
         nextInt = input.nextInt();
         input.nextLine().toLowerCase();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine().toLowerCase();
            if (nextLine.startsWith("y")){
               player.strength+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a strength value of "+player.strength+". You have "+player.skillPoints+" skill points left.");
               temp++;
               try{Thread.sleep(1000);}catch(InterruptedException e){}
               System.out.println("Next, dexterity, or speed. How many points would you like to alot to dexterity?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to allot to strength?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again!");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("You have "+player.skillPoints+" skill points left.");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("How many points would you like to alot to strength?");
         }
      }
      while (temp==1){
         nextInt = input.nextInt();
         input.nextLine().toLowerCase();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine().toLowerCase();
            if (nextLine.startsWith("y")){
               player.dexterity+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a dexterity value of "+player.dexterity+". You have "+player.skillPoints+" skill points left.");
               temp++;
               try{Thread.sleep(1000);}catch(InterruptedException e){}
               System.out.println("Next, constitution, or defense. How many points would you like to alot to constitution?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to dexterity?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again!");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("You have "+player.skillPoints+" skill points left.");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("How many points would you like to alot to dexterity?");         
         }
      }
      while (temp==2){
         nextInt = input.nextInt();
         input.nextLine().toLowerCase();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine().toLowerCase();
            if (nextLine.startsWith("y")){
               player.constitution+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a constitution value of "+player.constitution+". You have "+player.skillPoints+" skill points left.");
               temp++;
               try{Thread.sleep(1000);}catch(InterruptedException e){}
               System.out.println("Next, wisdom. How many points would you like to alot to wisdom?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to dexterity?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again!");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("You have "+player.skillPoints+" skill points left.");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("How many points would you like to alot to constitution?");         
         }
      }
      while (temp==3){
         nextInt = input.nextInt();
         input.nextLine().toLowerCase();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine().toLowerCase();
            if (nextLine.startsWith("y")){
               player.wisdom+=nextInt;               player.skillPoints-=nextInt;
               System.out.println("You now have a wisdom value of "+player.wisdom+". You have "+player.skillPoints+" skill points left.");
               temp++;
               try{Thread.sleep(1000);}catch(InterruptedException e){}
               player.magic+=player.skillPoints;
               System.out.println("Lastly, magic. The rest of your skill point will be aloted to magic, so "+player.skillPoints+" skill points will go to magic. You have a magic value of "+player.magic+".");
               
               player.skillPoints=0;
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to wisdom?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again!");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("You have "+player.skillPoints+" skill points left.");
            try{Thread.sleep(1000);}catch(InterruptedException e){}
            System.out.println("How many points would you like to alot to wisdom?");         
         }
      }
      // Initialize the window
       JFrame frame = new JFrame();
   
       // Set the width and height of the window in pixels
       frame.setSize(1024,1024);
       
       // Make the program end when the window is closed
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Initialize the drawing canvas (replace BGPExample with the name of any
       // class that extends JPanel)
   
       
      
       // Add the drawing canvas to the window
       frame.add(panel);
       
       // Show the window when we are done with all of our initialization
       frame.setVisible(true);
       
       System.out.println("You wake up in a dimly lit basement. There's a shiny object on a nearby table. Try using WASD or your arrow keys to move around.");

       panel.mainLoop();
            
      
       
   }
}
