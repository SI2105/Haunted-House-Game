package OOP.ec22612.MP.contributions;

class Room_ec221218 extends Room
 {
     private Item Axe = new Item("Axe");
     private Item CrossBow = new Item("Crossbow");
     private Item Torch = new Item("Torch");
     private Item FlameThrower = new Item("Flame Thrower");

     public Direction visit(Visitor visitor, Direction Incoming) 
     {
         visitor.tell("Welcome to ec221218's room! You are entering at your own risk");


         String TaskOption = ("What would you like to do? a) Look around, b) Fix equipment, c) Help complete task ");
         char[] options = {'a', 'b', 'c'};
         char userOption = visitor.getChoice(TaskOption, options);

         if (userOption == 'a') 
         {
             visitor.tell("You're looking around my room, Try not to make a lot of noise!");
             visitor.tell("You found some gold. You can keep it");
             visitor.giveGold(2);

         } 
         else if (userOption == 'b') 
         {
             String ItemToFix = ("Which item do you want to fix? a) Axe, b) Crossbow, c) Torch, d) Flame Thrower");
             
             char[] options2 = {'a', 'b', 'c', 'd'};
             char EquipOption = visitor.getChoice(ItemToFix, options2);
             
             if (EquipOption == 'a') 
             {
                 visitor.giveItem(Axe);
                 visitor.tell("Thanks for fixing the Axe, here is some gold");
                 visitor.giveGold(2);
             }
             else if (EquipOption == 'b') 
             {
                 visitor.giveItem(CrossBow);
                 visitor.tell("Thanks for fixing the Crossbow, here is some gold");
                 visitor.giveGold(2);
             }
              
             else if (EquipOption == 'c') 
             {
                 visitor.giveItem(Torch);
                 visitor.tell("The torch is not very useful, What a waste of time. 2 gold is needed for this");
                 visitor.takeGold(2);
             }
             else if (EquipOption == 'd') 
             {
                 visitor.giveItem(FlameThrower);
                 visitor.tell("Thanks for fixing the Axe, This will help a lot. Here is some gold");
                 visitor.giveGold(3);
             }
             
         } 
             
         else if (userOption == 'c') 
         {
             visitor.tell("Use a weapon and help me kill this bloater");
             visitor.tell("Thanks for helping me kill this bloater, This room is safe now. Here is some gold for your troubles.");
             visitor.giveGold(5);
         }
         
         else
         {
             visitor.tell("Not Available");
         }
         
         visitor.tell("Thanks for visiting my room. Hope you enjoyed it");
         return Direction.opposite(Incoming);
        
        
     }
        
}
