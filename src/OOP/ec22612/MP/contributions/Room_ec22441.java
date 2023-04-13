package OOP.ec22612.MP.contributions;

class Room_ec22441 extends Room{
	static final Item RubiksCube = new Item("Rubiks Cube");
    static final Item PieceOfPaperNew = new Item("Piece Of Paper");

	public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom){
	visitor.tell("You entered from the " + WhichWay.ToString(directionVisitorArrivesFrom) + "side of the house");
    visitor.tell("On your left you see a Rubiks cube");
    visitor.tell("On your right you see a piece of paper");
    visitor.tell("In front of you there is a piece of gold");
	
	char [] listOfChoices = {'a', 'b', 'c'};
    char user_choice = visitor.getChoice("Do you want to go to the left (a), go to the right? (b) or walk forward (c) ", listOfChoices);
    if (user_choice == listOfChoices[0]) {
        if(visitor.hasIdenticalItem(RubiksCube)== true){
            visitor.tell("You already have this item");
        }
        else{
            visitor.giveItem(RubiksCube);
        }
    }
    else if (user_choice == listOfChoices[1]){
        if(visitor.hasIdenticalItem(PieceOfPaperNew) == true){
            visitor.tell("You already have this item");
        }
        else{
            visitor.giveItem(PieceOfPaperNew);
            visitor.tell("You have been given a beautiful picture of Rochelle");
        }
        
    }
	else if(user_choice == listOfChoices[2]){
        char amount;
        char[] how_much = {'a', 'b', 'c', 'd'};
        amount = visitor.getChoice("How much gold do you want (a) 1 piece, (b) 2 pieces, (c) 5 pieces? ", how_much);
        if (amount == how_much[0]){
            visitor.giveGold(1); 
            visitor.takeGold(1);
visitor.tell("The amount of gold taken is "+ amount);
        }
        else if (amount == how_much[1]){
            visitor.giveGold(2);
            visitor.takeGold(2);
visitor.tell("The amount of gold taken is 2 ");
        }
        else if (amount == how_much[2]){
            visitor.giveGold(5);
            visitor.takeGold(5);
visitor.tell("The amount of gold taken is 5 ");
        }
        else if (amount == how_much[3]){
            visitor.giveGold(10);
            visitor.takeGold(10);
visitor.tell("The amount of gold taken is 10 ");
        }
        else {
    visitor.giveGold(10);
    visitor.takeGold(10);
visitor.tell("The amount of gold taken is 10 ");
        }
        }
	return directionVisitorArrivesFrom;}
	
	public static class WhichWay {
        static String ToString(Direction b){
            if (b == Direction.FROM_NORTH || b == Direction.TO_SOUTH  ){
			return "North";
			}
	else if (b == Direction.FROM_EAST || b == Direction.TO_WEST ){
			return "East";
			}
	else if (b == Direction.FROM_SOUTH || b==Direction.TO_NORTH){
			return "South";
			}
	else if (b== Direction.FROM_WEST || b==Direction.TO_EAST){
			return "West";
			}
	else if(b == Direction.UNDEFINED){
			return "Undefined";
			}
	else {
		return "Direction is not known";
			} //closes else statement
        } //closes to string
    } //closes whichWay

}
	
