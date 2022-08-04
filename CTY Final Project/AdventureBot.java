import java.util.Scanner;
import java.util.Random;
public class AdventureBot
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      Random rng = new Random();
      int rollResult=rng.nextInt(20);
      
      System.out.println ("Hi, I'm the AdventureBot, what's your name?");
      String subject = input.nextLine();
      System.out.println("Cool, "+subject+ ", are you ready for an adventure?");
      String ready = input.nextLine().toLowerCase();
      
      if(ready.startsWith("y"))
      {
         String items;
         int strength = 0;
         int dexterity = 0;
         int constitution = 0;
         int magic = 0;
         int wisdom = 0;
         int points = 30;
         int storage = 8;
         int lengthRope = 0;
         int gold = 20;
         int wpnStrength=3;
         int damage = wpnStrength+strength;
         int health = 25;
         int next;
         int x =0;
         String then;
         System.out.println("Alright, let's start. \nWe should begin by distributing your skill points. \nThere are strength, constitution, dexterity, wisdom, and magic. \nYou get 30 total points. Let's start with strength.");
         while (x==0)
         {
            next = input.nextInt();
            input.nextLine();
            if (next<=points & next>=0)
            {
               System.out.println("Are you sure?");
               then = input.nextLine();
               if (then.startsWith("y"))
               {
                  strength+=next;
                  points-=next;
                  System.out.println("You have "+points+" skill points left.");
                  x++;
                  System.out.println("Next, constitution, or defense.");
               }
               else
               {
                  System.out.println("You have "+points+" skill points left. How many would you like to allot to strength?");
               }
            }
            else
            {
               System.out.println("You don't have enough points, try again! \nYou have "+points+" skill points left. \nHow many points would you like to allot to strength?");
            }
         }
         
         while (x==1)
         {
            
            next = input.nextInt();
            input.nextLine();
            if (next<=(points) & next>=0)
            {
               System.out.println("Are you sure?");
               then = input.nextLine();
               if (then.startsWith("y"))
               {
                  constitution+=next;
                  points-=next;
                  System.out.println("You have "+points+" skill points left.");
                  x++;
                  System.out.println("Next, dexterity, or speed.");
               }
               else
               {
                  System.out.println("You have "+points+" skill points left. How many would you like to allot to constitution?");
               }
            }
            else
            {
               System.out.println("You don't have enough points, try again! \nYou have "+points+" skill points left. \nHow many points would you like to allot to constitution?");
            }
         }
      
         
         while (x==2)
         {
            next = input.nextInt();
            input.nextLine();
            if (next<=points & next>=0)
            {
               System.out.println("Are you sure?");
               then = input.nextLine();
               if (then.startsWith("y"))
               {
                  dexterity+=next;
                  points-=next;
                  System.out.println("You have "+points+" skill points left.");
                  x++;
                  System.out.println("Next, wisdom.");
               }
               else
               {
                  System.out.println("You have "+points+" skill points left. How many would you like to allot to dexterity?");
               }
            }
            else
            {
               System.out.println("You don't have enough points, try again! \nYou have "+points+" skill points left. \nHow many points would you like to allot to dexterity?");
            }
         }
                  while(x==3)
         {
            next = input.nextInt();
            input.nextLine();
            if (next<=points & next>=0)
            {
               System.out.println("Are you sure?");
               then = input.nextLine();
               if (then.startsWith("y"))
               {
                  wisdom+=next;
                  points-=next;
                  System.out.println("You have "+points+" skill points left.");
                  x++;
               }
               else
               {
                  System.out.println("You have "+points+" skill points left. How many would you like to allot to wisdom?");
               }
            }
            else
            {
               System.out.println("You don't have enough points, try again! \nYou have "+points+" skill points left. \nHow many points would you like to allot to wisdom?");
            }
         }
         System.out.println("Last, the rest of your points go to magic. You have a magic of "+points+".");
         magic=points;
      }
      else
      {
         System.out.println("Alright, come back when your ready!");
      }
   }
}