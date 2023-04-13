package OOP.ec22612.MP.contributions;

class Room_ec22841 extends Room{
    public Direction visit(Visitor v, Direction d){
        boolean button_pushed = false;
        v.tell("Welcome to my room.");
        if(button_pushed == false){
            char choice = v.getChoice("Push button? (y/n)", new char[]{'y','n'});
            if(choice == 'y'){
		button_pushed = true;
                final Item scooby_snack = new Item("Scooby Snacks");
                v.giveItem(scooby_snack);
                int gotGold = v.takeGold(3);
                v.tell("Well done, your curiosity has rewarded you with gold and scooby snacks");   
            }
            else if(choice == 'n'){
                v.tell("You get nothing.");
            }
            else{
                v.tell("You get nothing.");
            }
        }
	else{
	    v.tell("You get nothing.");
	}
        v.tell("You have already visted this room.");
        Direction exit_direction = Direction.opposite(d);
        
        return exit_direction;
    }
}
