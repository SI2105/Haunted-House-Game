package HauntedHouseGame.contributions;

class Room_ec22748 extends Room{

       private Item box= new Item("box");
       private Item book= new Item("book");
       private int Gold = 50;


        public Direction visit(Visitor visitor, Direction directionFrom)
        {
            visitor.tell("Welcome to my room! It is a bit messy but I'm sure you'll love what is inside of it. You will have to pick the right choice, so think very carefully now.");

          

            String Question= "Do you want to: a) Open the mystery box b) open a magical book c) recieve the cursed statue ";
            char options[] = {'a' , 'b', 'c'};
            char choice = visitor.getChoice(Question, options);
	
            if(choice == 'a') {
                visitor.giveItem(box); 
                Gold += visitor.takeGold(10);	
            }
            
            else if(choice == 'b'){
                visitor.giveItem(book);
                Gold += visitor.takeGold(5);
            }
      
            else if(choice == 'c'){
                visitor.tell("Run before you will get the curse of the statue!");
            }
          
            else{
                visitor.tell("You have not chosen from the options");
            }




           return directionFrom;
       }
 }
