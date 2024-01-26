package HauntedHouseGame.contributions;

class Room_ec22420 extends Room {
    
    static final Item Cross = new Item("Cross");
    static final Item Key = new Item("Key");
    static final Item Detector = new Item("Mars bar");
    
    boolean poltergeist = true; //Returns true if the poltergeist in the room is angry
    
    public Direction visit(Visitor v, Direction d)
    {
        
        if (d == Direction.FROM_NORTH) 
        {
             v.tell("You entered from the North side of the building");
             v.tell("Poltergeist didnt like that and robbed 1 of your gold");
             v.takeGold(1);
         } 
        else if (d == Direction.FROM_EAST) {
             v.tell("You entered from the East side of the building");
             v.tell("Lucky, you found 2 gold next to the door!");
             v.giveGold(2);
         } 
        else if (d == Direction.FROM_SOUTH) 
        {
             v.tell("You entered from the South side of the building");
             v.tell("Poltergeist didnt like that and robbed 1 of your gold");
             v.takeGold(1);
         } 
        else if (d == Direction.FROM_WEST) 
        {
             v.tell("You entered from the West side of the building");
             v.tell("Lucky, you found 2 gold next to the door!");
             v.giveGold(2);
         }

        if(poltergeist) //altering statements depending on polts mood
        {
            v.tell("He's angry, watch out.");
        }
        else
        {
            v.tell("He's in a good mood, you're in luck");
        }
        
        v.tell("Let's look around.");
        v.tell("There's a trunk! But it's locked...");
        v.tell("On the floor, there's a cross, key, or a mars bar. You can only pick one");
        
        char [] choices = {'a', 'b', 'c'};
        char userChoice = v.getChoice(("a) Use the cross to deter the poltergeist\n b) Use the key to unlock the trunk c) Eat mars bar coz ur hungry."), choices);
        
        if (userChoice == choices[0])
        {
            v.tell("By the power invested in you, the poltergeist is gone and you gained 3 gold.");
            v.giveGold(3);
        }
        else if (userChoice == choices[1])
        {
            v.tell("You unlocked the trunk! There was 5 gold just for you ;)");
            v.giveGold(5);
        }
        else
        {
            v.tell("Are you full now loser? No gold for you.");
        }
                 
        return d.opposite(d);
                 
    }
}
