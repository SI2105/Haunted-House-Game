package HauntedHouseGame.contributions;

class Room_ec22537 extends Room {
    public Direction visit (Visitor v, Direction directionFrom) {
        Item Sword = new Item ("Sword");
        Item Key = new Item ("Key");
        Item Torch = new Item ("Torch");
        
        boolean monsterKilled = false;
        
        char [] choices = {'a','b'};
        
        v.tell("You're a knight equipped with only a sword. You enter an abandoned castle.");
        v.giveItem(Sword);
        
        v.tell("You have entered the room from" + directionFrom);
    
        
        char choice = v.getChoice("You see a chest. \n a) Open Chest \n b) Hit with sword",choices);
        
        if(choice=='a') {
            v.tell("You open the chest. The chest turns into a monster and attacks you. You lose 2 gold.");
            v.tell("You decide it isn't worth risking your life. You decide to flee to another part of the castle.");
            v.takeGold(2);
        }
        
        else if(choice=='b') {
            v.tell("You use your sword to attack the chest. The chest morphs into a monster and dies.");
            v.tell("You find key and a few gold coins.");
            v.tell("You gain 4 gold");
            monsterKilled = true;
            v.giveGold(4);
            v.giveItem(Key);
        }
        
        char choice_1 = v.getChoice("You take a flight of stairs. You see a series of rooms. Which room do you wish to enter? . \n a) Room 1 \n b) Room 2",choices);
        
        if (choice_1=='a') {
            v.tell("You enter a bedroom. You find a locked drawer.");
            if(v.hasIdenticalItem(Key)) {
                v.tell("You use your key to unlock the drawer");
                v.tell("You gain 5 gold");
                v.giveGold(5);
            }    
        }
                   
        else if(choice_1=='b') {
            v.tell("You enter a pantry");
            v.tell("You find nothing worth taking.");
        }
                   
        
        if (monsterKilled) {
            v.tell("You feel like you've done enough exploration for today and leave through the entrance you took.");
        } else {
            v.tell("You feel like you've done enough exploration for today.");
            v.tell("You quickly past run the monster and close the entrance door behind you");
        }
        return directionFrom;
    }
}
