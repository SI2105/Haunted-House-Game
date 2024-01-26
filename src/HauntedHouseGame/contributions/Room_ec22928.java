package HauntedHouseGame.contributions;

class Room_ec22928 extends Room{
    public Direction visit(Visitor v, Direction d){
        Item torch  = new Item("torch");
        Item butter  = new Item("butter");
        boolean lightOn=false;

        char[] sOptions = {'a', 'b', 'c',};
        char[] yn = {'y','n'};
        
      if (!lightOn){
        char choice= v.getChoice("Would you like to turn on the light?",yn);
        switch(choice)
        {
            case'y':
            v.tell("lights are turned on");
            lightOn=true;
            break;
            
            case'n':
            v.tell("remain in the dark");
            break;
        }
      }
      else{
        v.tell("The lights are on in here");
      }
      
        
        
      
   

        v.tell("You've entered the kitchen");
        char choice= v.getChoice("Would you like to search the: (a) cupboard, (b) shelf, (c) fridge",sOptions);
        switch(choice)
        {
            
                case'a':
                v.tell("You found a torch and some gold!");
                v.giveItem(torch);
                v.giveGold(2);
                break;

                case'b':
                v.tell("This shelf appears to be empty");
                break;
                
                case 'c' :
                v.tell("There is some old butter in the fridge");
                choice = v.getChoice("Would you like to take it in exchange for some gold (y/n)", yn);
                switch(choice)
                {
                    case 'y':
                    
                        v.giveItem(butter);
                        v.takeGold(2);
                }

        }

        return Direction.opposite(d);

    }
}
