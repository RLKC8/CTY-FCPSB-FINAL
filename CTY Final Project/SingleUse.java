public class SingleUse extends Item{
   public boolean keyItem;
   public SingleUse(){
      super();
      consumable=true;
      type="Single Use";
      keyItem=true;
   }
   public void use(Player player){
      quantity--;
   }
}