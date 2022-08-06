public class PhysicalWeapon extends Weapon{
   String weaponClass;
   int damage;
   
   public PhysicalWeapon(){
      super();
      weaponClass="Physical";
      damage=0;
   }
   public int getDamage(){
      return damage;
    }
}
