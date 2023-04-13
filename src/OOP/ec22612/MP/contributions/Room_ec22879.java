package OOP.ec22612.MP.contributions;

class Room_ec22879 extends Room{
    
     private Item box= new Item("box");
      private int Gold= 0;
      static boolean drawer=false;
      static boolean wardrobe=false;
    
    public Direction visit (Visitor visitor, Direction arrivingdirection )
        
    {
     
        visitor.tell ("Welcome! Hope you like my room!");
        visitor.tell ("As you can see there are many different things.");
        
        char choices [] = {'a', 'b', 'c'};
        char choice = visitor.getChoice ("What do you want to do? a) Blow the candles b) Open the drawer c) Go inside the misterious wardrobe", choices);
        
        if (choice == 'a')
        
        {
           
                visitor.tell ("You have decided to blow the candles");
                visitor.tell ("You are such a brave person! Now there is no light");
                visitor.tell ("Due to you have been a brave person you have been recompensated. Take this gold!!! ");
                Gold = visitor.takeGold(100); //+100 of gold is given
            
        }
        
           else if (choice == 'b')
            
        {
             visitor.tell ("You have openned the drawer");
                
                if (drawer = true)
                {
                    visitor.tell ("The drawer is already opened!");
                    drawer=false;
                }
                else 
                {
                    visitor.tell ("You have opened the drawer");
                    visitor.tell ("Look what is inside the drawer!");
                    visitor.giveItem(box);
                    drawer=true;    
                }
        }
        
         else if (choice == 'c')       
          
         {
                visitor.tell ("Run!! There are mouses there.");
                Gold = visitor.takeGold (20); //+20 of gold is given
                visitor.tell ("You are very Brave!! Congratulations!");
         }
                
         else
             
         {
             visitor.tell ("That is not a valid option!");
         }
        
        return arrivingdirection;
        
    }
    
}
