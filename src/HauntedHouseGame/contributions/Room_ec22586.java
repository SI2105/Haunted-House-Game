package HauntedHouseGame.contributions;

class Room_ec22586 extends Room {

    boolean lightOn = true;
    static final Item DIAMOND = new Item("diamond");

    public Direction visit(Visitor visitor, Direction d) {
        visitor.tell("Hello, do you want to enter the room?");
        char userchoice = visitor.getChoice("Please choose a for come in, b for leave", new char [] {'a','b'});
        if(userchoice == 'a') {
            visitor.tell("You are in room ec22586.");
        }
        else {
            visitor.tell("See you next time!");
            return Direction.opposite(d);
        }
        if (visitor.hasEqualItem(DIAMOND))
		{
			visitor.tell("Thank you for your honesty when you visited the room last time.");
		}
        boolean treasureOrTrap = false;
        if(lightOn == true) {
            visitor.tell("The light is on, do you want to turn off the light?");
            userchoice = visitor.getChoice("Please choose y for yes, n for no", new char [] {'y','n'});
            if(userchoice == 'y') {
                visitor.tell("You turn off the light, and you can't see anything, so you touch a trap suddenly.");
                lightOn = false;
                treasureOrTrap = false;
            }
            else {
                visitor.tell("You see a coin in front of you.");
                treasureOrTrap = true;
            }
        }
        else {
            visitor.tell("The light is off, do you want to turn the light?");
            userchoice = visitor.getChoice("Please choose y for yes, n for no", new char [] {'y','n'});
            if(userchoice == 'y') {
                visitor.tell("You turn on the light, you see a coin in front of you.");
                lightOn = true;
                treasureOrTrap = true;
            }
            else {
                visitor.tell("You can't see anything, so you touch a trap suddenly.");
                treasureOrTrap = false;
            }
        }
        if (treasureOrTrap) 
        {
            visitor.tell("Do you want to take away the coin?");
            userchoice = visitor.getChoice("Please choose y for yes, n for no", new char [] {'y','n'});
            if(userchoice == 'y') {
                visitor.tell("You get a coin.");
                visitor.giveGold(1);
            }
            else {
                visitor.tell("You are really honest, so I will give you a diamond");
                Item diamondItem = new Item("diamond");
                visitor.giveItem(diamondItem);
            }
        }
        else
        {
            visitor.tell("You need to pay a coin for escape the trap.");
            int gold = visitor.takeGold(1);
            if(gold == 1) {
                visitor.tell("You are safe now!");
            }
            else {
                visitor.tell("I'll let you go this time. Remember to bring more gold with you!");
            }
        }
        return d;
    }
}
