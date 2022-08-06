import java.util.ArrayList;
public class Player extends Entity{
   String name;
   int skillPoints;
   int xp;
   int level;
   int xpForNextLevel;
   int storage;
   PhysicalWeapon equippedPhsyicalWeapon;
   MagicWeapon equippedMagicalWeapon;
   boolean physicalWeaponEquipped;
   boolean magicalWeaponEquipped;
   Armor equippedArmor;
   boolean armorEquipped;
   int gold;
   int x;
   int y;
   EntityAnimation PlayerSprite;
   
   public Player(EntityAnimation p){
      super();
      PlayerSprite = p;
      species="Human";
      x=0;
      y=0;
      skillPoints=10;
      level=1;
      storage=1;
      physicalWeaponEquipped=false;
      magicalWeaponEquipped=false;
      armorEquipped=false;
      gold=0;
      health=20;
      strength=3;
      dexterity=3;
      constitution=3;
      wisdom=3;
      magic=3;
      friendly=true;
    }
    
    public EntityAnimation getSprite(){
      return PlayerSprite;
    }
    /*public int getPhysicalDamage(){
      int bob=equippedPhysicalWeapon.getDamage;
      return bob;
    }
    */
    
}
