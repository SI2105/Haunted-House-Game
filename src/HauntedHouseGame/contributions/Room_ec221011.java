package HauntedHouseGame.contributions;

class Room_ec221011 extends Room {
    
    public static Item Stick = new Item("Stick");
    public static Item Jacket = new Item("Jacket");
    public static Item Rock = new Item("Rock");
    public static Item Specs = new Item("Glasses");
    
    public Direction visit(Visitor v, Direction d){
        char [] choices = {'a', 'b', 'c', 'd'};
        v.tell("Salam Brother or Sister to my rooom");
        v.tell("In order to gain some bit of Gold you must first pick your poison");
        
        char choice = v.getChoice("Do you pick a, b, c, or d", choices);
        v.tell("Sorry Harry Potter, I couldn't think of anything else");
        
        if(choice == 'a'){
            v.giveItem(Stick);
            v.tell("You've chosen the stick of truth, this will make you one of the most powerful beings in the world");
            v.tell("Here is a small amount of gold. (You're a bit too powerful so you might as well be broke, sorry lad");
            v.giveGold(1);
        }
        else if(choice == 'b'){
            v.giveItem(Jacket);
            v.tell("You've chosen the not-see-jacket, you will not be seen by anyone once you wear this jacket. A bit like me on a friday night");
            v.tell("Take some gold, you're gonna need it.");
            v.giveGold(5);
        }
        else if(choice == 'c'){
            v.giveItem(Rock);
            v.tell("You've chosen nine-lives-rock, you have cat-like agility, and you will have nine lives.");
            v.tell("I envy you. You don't need that much gold.");
            v.giveGold(3);
        }
        else if (choice == 'd'){
            v.giveItem(Specs);
            v.tell("You've chosen a pair of glasses. To be honest this doesn't help you at all, sorry mate.");
            v.tell("At least you get gold");
            v.giveGold(10);
        }
        
        v.tell("Leave now!! You've ruined my mood.");
        d = Direction.TO_EAST;
        
        return d;
    }
}
