package OOP.ec22612.MP.contributions;

class Room_ec221022 extends Room{
    
    static final Item Boxing_gloves = new Item("Boxing gloves");
    static final Item Running_shoes = new Item("Running shoes");
    static final Item Typewriter = new Item("Typewriter");
    boolean is_light_on = false; // checks if the light is on false means its not

    // option of items in room for visitor to take 
    
    public Direction visit(Visitor v, Direction d){
        char[] choices = {'a', 'b','c'};
        char[] yes_no ={'y', 'n'};
        
        if(is_light_on = false){
            v.tell("would you like to turn the light on");
            String ask = "y) yes, n) no";
            char turn = v.getChoice(ask,yes_no);
            if(turn == 'y'){
                is_light_on = true;
            }
            if(turn == 'n'){
                v.tell("you trip over and break an artifact");
                v.takeGold(2);
                v.tell("should have turned the light on");
                is_light_on = false;
            }
        }
    // choices that the visitors can make
            
        v.tell("Welcome visitor to Needful Things. What do you desire?, everything is free, but there is a price to everything. I'll even give you gold, here!");
        v.giveGold(5);
        
        String options = "a)Do you want to look around the room?, or b) take a look at what we have, or c) ask a question";
        char INPUT_option = v.getChoice(options,choices);
        if (INPUT_option == 'a'){
            v.tell("Looking around the room you stumble across a box, you open it and there is 5 pieces of gold!");
            v.giveGold(5);
        }
        else if(INPUT_option == 'b'){
            v.tell("Here is what we have, remember a price for everything...");
            String options2 = "a) Boxing gloves, become the national champion!! b) Running shoes, be the fastest!! , c) Typewriter, write bestselling murder mysteries!!";
            char chosen_item = v.getChoice(options2,choices);
            
            if(chosen_item == 'a'){
                v.giveItem(Boxing_gloves);
            }
            else if(chosen_item == 'b'){
                v.giveItem(Running_shoes);
            }
            else if(chosen_item == 'c'){
                v.giveItem(Typewriter);
            }
        }
        
        else if(INPUT_option == 'c'){
            String options3 = "a)ask what is the price? b)what happened to n33dful.com c) can I have more gold? ";
            char chosen_question = v.getChoice(options3,choices);
            
            if(chosen_question == 'a'){
                v.tell("depends on what you get");
                v.tell("heres more gold");
                v.giveGold(2);
            }
            else if(chosen_question == 'b'){
                v.tell("...");
                v.takeGold(5);
                v.tell("be on your way");
            }
            else if(chosen_question == 'c'){
                v.tell("sure! Heres more gold!");
                v.giveGold(5);
    
            }
        
        }     
        
         
        if(is_light_on = true){
            v.tell("would you like to turn the light off");
            String ask = "y) yes, n) no";
            char turn = v.getChoice(ask,yes_no);
            if(turn == 'y'){
                is_light_on = false;
            }
            if(turn == 'n'){
                is_light_on = true;;
            }
        }
           return Direction.opposite(d); 
                
        
    
    }


}
