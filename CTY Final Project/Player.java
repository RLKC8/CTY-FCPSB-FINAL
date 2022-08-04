import java.util.ArrayList;
public class Player extends Entity{
   String name;
   int skillPoints;
   int xp;
   int level;
   int xpForNextLevel;
   int storage;
   ArrayList<Item>inventory=new ArrayList<>();
   Weapon equippedWeapon;
   boolean weaponEquipped;
   Armor equippedArmor;
   boolean armorEquipped;
   int gold;
   int x;
   int y;
   public Player(){
      super();
      species="Human";
      x=0;
      y=0;
      skillPoints=20;
      level=1;
      storage=1;
      weaponEquipped=false;
      armorEquipped=false;
      gold=0;
      health=20;
      strength=1;
      dexterity=1;
      constitution=1;
      wisdom=1;
      magic=1;
      friendly=true;
    }
}