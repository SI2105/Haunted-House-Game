package OOP.ec22612.MP.contributions;

class Room_ec221008 extends Room {
    
    Item cute_painting = new Item("cute painting");
    boolean map_collected = false;
    
    public Direction visit (Visitor v, Direction d) {
        
        if(v.hasIdenticalItem(cute_painting))
        {
            boolean map_collected = true;
        }
        v.tell("You enter a new room. You hear the sound of a creaking floorboard as you close the door behind you.");
        v.tell("In the distance you see the sillhouette of something appearing to be moving. Are you alone in this room?");
        if(map_collected)
        {
            v.tell("You remember about the panda painting that you took, which calms your nerves");
        }
        else
        {
            v.tell("Luckily, your nerves are momentarily calmed by the sight of a cute painting of a panda on the wall next to you!");
        }
        v.tell("However, you still can't seem to shake off the feeling that you might not be alone here.");
        
        
        char [] choices = {'a','b','c','d'};
        
        v.tell("a) Check creaky floorboard");
        v.tell("b) Investigate moving shadow");
        v.tell("c) Pick up cute painting");
        v.tell("d) Panic");
        
        char option = v.getChoice("What option will you take?", choices);
        
        if(option=='a')
        {
            v.tell("You accidentally tripped over the creaky floorboard and lost some gold in the process. How clumsy...");
            v.tell("Lost 7 gold");
            v.takeGold(7);
        }
        else if (option=='b')
        {
            v.tell("Foolishly, you decide to investigate the moving sillhouette.");
            v.tell("Luckily for you, it was just a moving piggybank! You decided to steal some gold from it for your troubles. Thief...");
            v.tell("Gained 4 gold");
            v.giveGold(4);
        }
        else if (option=='c')
        {
            if(map_collected)
            {
                v.tell("You remember that you took the map earlier! What a waste of time...");
            }
            else
            {
                v.tell("For some reason, this painting on the wall really interests you.");
                v.tell("Ignoring all other oddities in the room, you decide to simply collect the painting.");
                v.tell("You notice something written on the back of the painting, but don't pay too much attention to it for now.");
                v.giveItem(cute_painting);
            }
        }
        else if (option=='d')
        {
            v.tell("You started panicking at the sight of this room.");
            v.tell("After a while, nothing happened to you, so your nerves calmed.");
            v.tell("Maybe this room isn't so dangerous!");
        }
        
        v.tell("You finally decide that you've done enough exploring. Time to go!");
        if(map_collected)
        {
            v.tell("Just as you were about to leave, you notice the panda painting glowing!");
            v.tell("There is now a map in glowing ink on the back of the painting, leading to the west exit...");
            v.tell("a) Follow map");
            v.tell("b) Ignore");
            char [] choices2 = {'a','b'};
            option = v.getChoice("Will you trust the map?", choices2);
            if(option=='a')
            {
                v.tell("You decide to follow the map and head to the west exit...");
                return Direction.TO_WEST;
            }
            else if(option=='b')
            {
                v.tell("You choose to ignore the map.");
                v.tell("Maybe another time!");
            }
        }
        return Direction.opposite(d);
        
    }
    
    
    
}
