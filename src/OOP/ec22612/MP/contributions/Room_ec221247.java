package OOP.ec22612.MP.contributions;

/************************************
 * Winchester Mystery House: Room_ec221247
 * By Bala Siva
 * Student ID: 220349336
 * Version 3 amended: 24 March 2023
 * 1. Visitor get or loss things according to their choice
 * 2. Visitors get gold coins if they have a pen otherwise they get a pen
 * 3. Visitor always take a right turn in this room
 * ***********************************/


class Room_ec221247 extends Room{

    // Returns direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction arrivesFrom){

        final Item PEN = new Item("Pen");
        final Item NOTE_BOOK = new Item("Note Book");
        final Item KEY = new Item("Key");
        Direction rDirection = Direction.opposite(arrivesFrom);
        char [] choices = {'A', 'B', 'C', 'D'};

        // greeting
        visitor.tell("\n   Welcome to a wonderful room! Enter your choice:");

        // Game 1: get choice
        String option = "A: Open the cupboard\t B: Open the box\t C: Get Keys \t D: Get Note Book";
        char answer = visitor.getChoice(option, choices);


        // give items according to visitors choices
        if(answer == 'A'){
            visitor.tell("You won gold");
            visitor.giveGold(2);
        }
        else if (answer == 'B'){
            visitor.tell("You can have a pen");
            visitor.giveItem(PEN);
        }
        else if(answer == 'C'){
            visitor.giveItem(KEY);
            int goldTaken = visitor.takeGold(1);
            visitor.tell(goldTaken + " gold coins has been lost");
        }
        else if(answer == 'D'){
            visitor.giveItem(NOTE_BOOK);
        }
        else {
            visitor.tell("Sorry, you lost your chance.");
        }

        // Game 2: get choice
        visitor.tell("\n Guess an item you have; you might win gold:");
        option = "A: Pen\t B: Note Book \t C: Key \t D: Gold:";
        answer = visitor.getChoice(option, choices);

        // Give gold coins according to visitors guess
        switch (answer) {
            case 'A':
                if (visitor.hasEqualItem(PEN)) {
                    visitor.tell("You won 5 gold coins because you have a pen");
                    visitor.giveGold(5);
                }
                else{
                    visitor.tell("you don't have pen. lost the chance to win gold");
                }
                break;
            case 'B':
                if (visitor.hasEqualItem(NOTE_BOOK)) {
                    visitor.tell("You missed gold price but you can get a pen");
                    if (visitor.giveItem(PEN)) {
                        visitor.tell("Use your a pen to win gold");
                    }
                }
                else{
                    visitor.tell("you don't have a Note Book. lost the chance to win gold");
                }
                break;
            case 'C':
                if (visitor.hasEqualItem(KEY)) {
                visitor.tell("Correct guess you win 2 golds");
                visitor.giveGold(2);
                }
                else{
                    visitor.tell("you don't have a key. lost the chance to win gold");
                }
                break;
            case 'D':
                if (visitor.takeGold(1) > 0){
                visitor.tell("Sorry, you lost one gold coin");
                }
                else{
                    visitor.tell("You have no gold");
                    visitor.giveItem(PEN);
                }
                break;
            default:
                visitor.tell("Wrong choice, you lost the chance to win gold");
                break;
        }

        // visitor always takes a right turn
        if(arrivesFrom == Direction.FROM_NORTH){ rDirection = Direction.TO_WEST; }
        else if(arrivesFrom == Direction.FROM_SOUTH){ rDirection = Direction.TO_EAST; }
        else if(arrivesFrom == Direction.FROM_EAST){ rDirection = Direction.TO_NORTH; }
        else if (arrivesFrom == Direction.FROM_WEST) { rDirection = Direction.TO_SOUTH; }


        visitor.tell(rDirection.toString());
        return rDirection;

    }
}

