package HauntedHouseGame.contributions;

class Room_ec22467 extends Room {

    static final Item knife = new Item("knife");
    

public Direction visit( Visitor visitor, Direction direction)
        {
                visitor.tell("Welcome to Winchester Mystery House -  between a hammer (h), camera (c), rope (r), torch (t) choose the correct murder weapon - two out of four are correct.");

               
                char  [] choices  = {'h' , 'c' , 'r', 't'};
                char options = visitor.getChoice("You can choose between a hammer (h), camera (c), rope (r), torch (t)", choices);
    
                int tallyForGold = 0;
                int caseCount = 0;
               
                switch (options) {
                    case 'h':
                    visitor.tell("You decided to choose hammer as the guessed mystery weapon - you tried to picked up the item but dropped it on your right foot - this was the wrong choice");
                    caseCount = 7;
                    tallyForGold =  visitor.takeGold(caseCount);
                    visitor.tell("This choice made you lose " + tallyForGold + " pieces of gold.");
                        break;
    
                    case 'c':
                    visitor.tell("You decided to choose camera as the guessed mystery weapon - you picked  it up but all the film rolled out so it is now useless - this was the wrong choice");
                    caseCount = 3;
                    tallyForGold =  visitor.takeGold(caseCount);
                    visitor.tell("This choice made you lose " + tallyForGold + " pieces of gold.");
                        break;
    
                    case 'r':
                    visitor.tell("You decided to choose rope as the guessed mystery weapon - you picked up the item and inspected it - you found washed out blood stains at the sides of rope along with bloody finger prints - this was the correct murder weapon - CONGRATS!!!");
                    caseCount = 10;
                    tallyForGold =  visitor.takeGold(caseCount);
                    visitor.tell("This choice made was correct so you maintain all " + tallyForGold + " pieces of gold. Welll done");
                        break;
    
                    case 't':
                    visitor.tell("You decided to choose torch as the guessed mystery weapon - you picked up the item but accidentlly switched on the torch which blinded you, this made you stumbled backwards and you twisted your ankle - this was the wrong choice");
                    caseCount = 5;
                    tallyForGold =  visitor.takeGold(caseCount);
                    visitor.tell("This choice made you lose " + tallyForGold + " pieces of gold.");
                        break;
    
                    default:
                    visitor.tell("Invalid input of Charater");
                        break;
                }




                char [] new_choices  = {'x' , 'y'};
                char option = visitor.getChoice("Choose between x and y... a surprise awaits you", new_choices);
              
                
                switch(option) {
                    case 'x':
                    visitor.giveItem(knife);
                        visitor.tell("You have accuqired a knife");
                    break;
                        
                    case 'y':
                         visitor.tell("you didnt get anything...loser");
                        break;        
                }


              char [] option2  = {'X' , 'Y'};
                char new_choice = visitor.getChoice( "Welcome to Natalie's Room. Please tell us if you have seen the mace. Y for yes and N for no.", option2);
                    
                     
                switch(new_choice) {
                    case 'Y':
                        if (visitor.hasIdenticalItem(knife)){
                         visitor.tell("Gee thank you ");
                        }
                        else
                        {
                            visitor.tell("Ahh okay no worries");
                        }
                         break;
                        
                    case 'N':
                         visitor.tell("you didnt get anything...loser");
                        break;        
                }
                
    
    
                            switch (options) {
                                case 'h':
                                visitor.tell("You leave through the West exit");
                                break;
        
                                case 'c':
                                
                                visitor.tell("You leave through the North exit");
                            break;
                                case 'r':
                        
                                visitor.tell("You leave through the East exit");
                            break;
        
                                case 't':
                            
                                visitor.tell("You leave through the South exit");
                                break;
        
                                default:
                                visitor.tell("Invalid input of Charater");
                            
                    
                            }
                
    
                
            return direction;
        }
 }
       
    
     
    
    
