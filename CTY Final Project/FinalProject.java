import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class FinalProject{
   public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      Random rng = new Random();
      Player player=new Player();
      int temp;
      int nextInt;
      boolean canProgress=true;
      boolean hasBasementKey=false;
      String nextLine;
      System.out.println("Please type out your character's name.");
      player.name=input.nextLine();
      System.out.println("Ok, "+player.name+", let's start by assigning your skill points.");
      System.out.println("You have 20 points to distribute among strength, dexterity, constitution, wisdom, and magic.\nYou start with a value of 1 in each category.");
      System.out.println("Let's start with strength. How many points would you like to alot to strength?");
      temp=0;
      while (temp==0){
         nextInt = input.nextInt();
         input.nextLine();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine();
            if (nextLine.startsWith("y")){
               player.strength+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a strength value of "+player.strength+". You have "+player.skillPoints+" skill points left.");
               temp++;
               System.out.println("Next, dexterity, or speed. How many points would you like to alot to dexterity?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to allot to strength?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again! \nYou have "+player.skillPoints+" skill points left. \nHow many points would you like to alot to strength?");
         }
      }
      while (temp==1){
         nextInt = input.nextInt();
         input.nextLine();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine();
            if (nextLine.startsWith("y")){
               player.dexterity+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a dexterity value of "+player.dexterity+". You have "+player.skillPoints+" skill points left.");
               temp++;
               System.out.println("Next, constitution, or defense. How many points would you like to alot to constitution?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to dexterity?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again! \nYou have "+player.skillPoints+" skill points left. \nHow many points would you like to alot to dexterity?");
         }
      }
      while (temp==2){
         nextInt = input.nextInt();
         input.nextLine();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine();
            if (nextLine.startsWith("y")){
               player.constitution+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a constitution value of "+player.constitution+". You have "+player.skillPoints+" skill points left.");
               temp++;
               System.out.println("Next, wisdom. How many points would you like to alot to wisdom?");
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to dexterity?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again! \nYou have "+player.skillPoints+" skill points left. \nHow many points would you like to alot to dexterity?");
         }
      }
      while (temp==3){
         nextInt = input.nextInt();
         input.nextLine();
         if (nextInt<=player.skillPoints & nextInt>=0){
            System.out.println("Are you sure?");
            nextLine = input.nextLine();
            if (nextLine.startsWith("y")){
               player.wisdom+=nextInt;
               player.skillPoints-=nextInt;
               System.out.println("You now have a wisdom value of "+player.wisdom+". You have "+player.skillPoints+" skill points left.");
               temp++;
               System.out.println("Lastly, magic. The rest of your skill point will be aloted to magic, so "+player.skillPoints+" skill points will go to magic. You have a magic value of "+player.magic+".");
               player.magic+=player.skillPoints;
               player.skillPoints=0;
            }
            else{
               System.out.println("You have "+player.skillPoints+" skill points left. How many would you like to alot to wisdom?");
            }
         }
         else{
            System.out.println("You don't have enough points, try again! \nYou have "+player.skillPoints+" skill points left. \nHow many points would you like to alot to wisdom?");
         }
      }
      System.out.println("You wake up in a dimly lit basement. There's a shiny object on a nearby table. Try using WASD or your arrow keys to move around.");
      while ((player.x>-185)&&(player.x<-175) && (player.y<-205)&&(player.y>-310) && canProgress==true){
         if (hasBasementKey=true){
            System.out.println("You use the key to open a trapdoor locking you in.");
            canProgress=false;
         }
         else{
            System.out.println("You try to push the trapdoor locking you in, but it won't budge. You notice a small keyhole.");
         }
      }
   }
}