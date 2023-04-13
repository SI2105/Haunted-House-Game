package OOP.ec22612.MP.contributions;

class Room_ec22661 extends Room
{

   static final Item TORCH = new Item("Torch");
   static final Item PHONE = new Item("Phone");
   static final Item AXE = new Item("Axe");
   static final Item KEY = new Item("Key");

   public Direction visit (Visitor v, Direction startpoint)
   {
       v.tell("You have entered a dark, mysterious house.");
       v.tell("As you explore, you go down a staircase into the basement but a sudden loud noise startles you and you trip and fall down the stairs");
       v.tell("You fall heavily onto the basement floor, landing on your arms. Both of your arms are in severe pain.");
       v.tell("You get up and look around the basement, noticing a door marked ec22661");
       v.tell("You open the door and enter the room. As you do so, the door behind you closes and locks.");
       v.tell("The room is dark and it is hard to see, you stumble around and your hands rest upon four locked chests that have the letters T, P, A and K marked on them.");
       v.tell("With the amount of strength left in your damaged arms, you can only break one of the chests - except for K as it is made of a stronger wood.");

       char [] itemchoices = {'T', 'P', 'A'};
       char chosenitem = v.getChoice("Do you want to break open the chest marked T, P, or A?", itemchoices);

       if (chosenitem == 'P')
       {
           v.tell("You break the chest open and find a phone!");
           v.giveItem(PHONE);
           v.tell("As you pick up the phone, you notice 3 gold pieces underneath it and take them.");
           v.giveGold(3);

           v.tell("You then remember that the chest marked as K has a tiny slot with a gold piece symbol above it, so you put one gold piece in it.");
           v.takeGold(1);

           v.tell("Inside the chest there is a key! You take it.");
           v.giveItem(KEY);
           v.tell("Using the key, you open the locked door and exit.");
       }
       else if (chosenitem == 'T')
       {
           v.tell("You break the chest open and find a torch!");
           v.giveItem(TORCH);
           v.tell("Using the torch, you find a catflap on the door and squeeze through to exit the room.");
       }
       else
       {
           v.tell("You break the chest open and find an axe! It's withered but still can do some serious damage!");
           v.giveItem(AXE);
           v.tell("Using the axe, you break open the locked door and exit.");
       }

       return Direction.opposite(startpoint);
   }
  }
