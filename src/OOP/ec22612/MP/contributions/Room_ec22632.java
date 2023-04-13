package OOP.ec22612.MP.contributions;

class Room_ec22632 extends Room {
    public Direction visit(Visitor guest, Direction originalDirection){
        Direction finalDirection = Direction.opposite(originalDirection);
        boolean lightSwitchON = false;
        guest.tell("You have entered ec_22632's room, The door locks behind you.");
        guest.tell("The room is dark, All you can make out is the lightswitch next to you");
        char turnOnLight = guest.getChoice("Options: a) Press the lightswitch, b) Use a light-giving item in your inventory, c) Scurry around in the dark like a goblin", new char[] {'a','b','c','d'});
        
        //User has the choice of turning on a lightswitch or using their own light source//
        if (turnOnLight == 'a'){
            lightSwitchON = true;
            guest.tell("You press the lightswitch. A faint light emits from the ceiling. It is enough for you to make out your immediate surroundings.");
        }
        if (turnOnLight == 'b'){
            if (turnOnLight == 'b'){
                if (guest.hasEqualItem(new Item("Flashlight"))){
                    guest.tell("You point the light around the room.");
                }
                else{
                    guest.tell("Why did you pick that option when you don't have a flashlight?");
                    turnOnLight = 'c';
                }
            }
        }
        //User falls down a hole and loses gold//
        if (turnOnLight == 'c'){
            guest.tell("You decide to brave the darkness. \nYou take a step forward and fall\nYou fall down a crudely dug hole.\nGold starts falling out of your pockets");
            guest.tell("After a minute of tumbling you reach the bottom. After recounting your gold you realise you've lost 5 gold pieces! That'll teach you a lesson.");
            guest.takeGold(5);
            guest.tell("You fell into a cavern. There is nowhere else for you to go but forward. That was a quick trip through the room. Goodbye!");
            if (originalDirection == Direction.FROM_SOUTH){finalDirection = Direction.TO_WEST;}
            if (originalDirection == Direction.FROM_WEST){finalDirection = Direction.TO_NORTH;}
            if (originalDirection == Direction.FROM_NORTH){finalDirection = Direction.TO_EAST;}
            if (originalDirection == Direction.FROM_EAST){finalDirection = Direction.TO_SOUTH;}
            return finalDirection;
        }
        //If the user didn't fall down the hole, they see this section//
        guest.tell("You look around the room. It looks like you're in a rundown shack. There is an identical door on the opposite wall. There is a window on the side of the room leading to the dark forests surrounding the shack\n In the middle of the room is a crudely dug hole. On the opposite to the window is a chest");
        char whatToDo = guest.getChoice("a) Climb through the window or b) Open the chest", new char[] {'a','b'});
        if (whatToDo == 'a'){
            guest.tell("You climb out the window and come face to face with a massive brown bear\nIt stands up on its hind legs and towers over you\n It's almost taller than the shack \n It opens its mouth as you get ready to be eaten");
            guest.tell("'Hello traveler' it speaks\n'I am the guardian of the forest or something'");
            guest.tell("'Here have this...' He gives you 5 gold and a torch. 'Tally ho', the bear disappears into the woods");
            guest.giveGold(5);
            Item torch = new Item("Torch");
            guest.giveItem(torch);
            guest.tell("You leave the room by leaving the woods. Goodbye!");
            if (originalDirection == Direction.FROM_SOUTH){finalDirection = Direction.TO_EAST;}
            if (originalDirection == Direction.FROM_NORTH){finalDirection = Direction.TO_WEST;}
            if (lightSwitchON){
                guest.tell("Hold on a second! You used the lightswitch. Time to pay the electricity bill! 5 gold please!");
                guest.takeGold(5);
            }
        }
        //The user chooses to open the chest//
        else if (whatToDo == 'b'){
            guest.tell("You open the chest and a loud mechanical sound echos across the room. It seems like the opposite door opened. You search through the chest");
            guest.tell("The chest has 3 gold and a dead fish...\n Take it.");
            guest.giveGold(3);
            Item fish = new Item("Fish");
            guest.giveItem(fish);
            guest.tell("You leave the room up 3 gold and a dead fish, congrats!");
            if (lightSwitchON){
                guest.tell("Hold on a second! You used the lightswitch. Time to pay the electricity bill! 5 gold please!");
                guest.takeGold(5);
            }
        }
        return finalDirection;
    }
}
