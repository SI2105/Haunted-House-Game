package HauntedHouseGame.contributions;

class Room_ec22815 extends Room
{
    static final Item MACGUFFIN = new Item("Key");
    static final Item Burger = new Item("Key");
    static final Item Pizza = new Item("Key");
    static final Item Knife = new Item("Key");
    char[] option = {'1','2'};
    boolean room_light = false;
    boolean wear_jacket = false;
    
    public Direction visit (Visitor v, Direction d)
    {
        v.tell("Visitor entered the room, which holds many objects hidden.");
        Direction direction = d;
        v.tell("Room entered from the North");
        if(v.hasEqualItem(MACGUFFIN))
        {
            v.tell("You have Macguffin");
            v.tell("The light is turned on by visitor!");
            room_light=true;
        }
        else
        {
            v.tell("Visitor interacts with the Macguffin!");
            if (v.giveItem(MACGUFFIN))
            {
                v.tell("Macguffin is kidnapped!");
            }
            else
            {
                v.tell("Mcguffin is not accepted, too ugly!");
            }
        }
        v.tell("Room entered from the South");
        if (v.hasIdenticalItem(MACGUFFIN))
        {
            v.tell("You have Macguffin");
            wear_jacket=true;
            v.tell("Visitor stole his jacket and wears the jacket!");
        }
        else
        {
            v.tell("You don't have Macguffin");
            v.tell("Take the Knife to fight him!");
            if (v.giveItem(Knife))
            {
                v.tell("Knife taken!, visitor takes him by force");
            }
            else
            {
                v.tell("Knife not accepted!");
            }
        }
        
        v.tell("Room entered from the West");
        v.tell("Visitor steals the gold!");
        v.giveGold(10);
            
        v.tell("Room entered from the East");
        char choice = v.getChoice("There is a burger or pizza in the room, what would you like (1/2)?",option);
   
        if (choice=='1')
        {
            v.tell("Visitor wants to eat the burger!");
            if (v.giveItem(Burger))
            {
                v.tell("Burger eaten!");
            }
            else
            {
                v.tell("Burger not accepted and liked!");
            }
        }
        else if (choice=='2')
        {
            v.tell("Pizza is desired by the Visitor!");
            if (v.giveItem(Pizza))
            {
                v.tell("Pizza eaten !");
            }
            else
            {
                v.tell("Pizza not accepted!");
            }   
        }
        return Direction.opposite(d);
    }
}