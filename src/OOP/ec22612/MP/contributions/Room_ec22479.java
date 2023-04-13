package OOP.ec22612.MP.contributions;// Mohamed Ait-Hocine
// Assignment 4
// 23/02/2023
// V1.1
// Changed absolutely nothing.


class Room_ec22479 extends Room {
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        String direction = "";
        if (directionVistorArrivesFrom == Direction.TO_NORTH) {
            direction = "south";
        }
        else if (directionVistorArrivesFrom == Direction.TO_EAST) {
            direction = "west";
        }
        else if (directionVistorArrivesFrom == Direction.TO_SOUTH) {
            direction = "north";
        }
        else if (directionVistorArrivesFrom == Direction.TO_WEST) {
            direction = "east";
        }
        visitor.tell("You entered a large empty room.. \nEvery wall is a mirror..? \nYou just came from the " + direction + ".");
        visitor.tell("As you slowly make sense of where you are, you realise there are only two options for you. \nWhat will you choose?");
        char [] possibleChoices = {'1', '2'};
        char selectedChoice = visitor.getChoice("1) Stare at your reflection. \n2) Charge straight into your reflection.", possibleChoices);
        if (selectedChoice == '1') {
            visitor.tell("You stare at your reflection. Your face is clearer than ever.");
            selectedChoice = visitor.getChoice("1) Stare at your reflection. \n2) Charge straight into your reflection.", possibleChoices);
            if (selectedChoice == '1') {
                visitor.tell("You look at your eyes, filled with this desire to ponder.. \nThey sparkle with determination.. \n'I will make it out alive!' You exclaim.");
                selectedChoice = visitor.getChoice("1) Stare at your reflection. \n2) Charge straight into your reflection.", possibleChoices);
                if (selectedChoice == '1') {
                    visitor.tell("You continue to look at your eyes, slowly sinking into them.. \nYou can't stop looking.. \nYour fixed gaze is interrupted. \nThis reflection of yours.. is moving on its own.");
                    selectedChoice = visitor.getChoice("1) Stare at your reflection. \n2) Charge straight into your reflection.", possibleChoices);
                    if (selectedChoice == '1') {
                        visitor.tell("It seeps out of the mirror. Holding a shiny object in its hand.");
                        visitor.giveGold(10);
                        visitor.tell("It has given you 10 gold. You've given yourself 10 gold?");
                        possibleChoices[0] = '2';
                        selectedChoice = visitor.getChoice("\n2) Follow your reflection", possibleChoices);
                    }
                }
            }
        }

        final Item BrokenGlass = new Item("Broken Glass");
        
        if (selectedChoice == '2') {
            visitor.tell("The mirrors shatter, and a door is revealed. \nYou decide to pick up some broken glass.");
            visitor.giveItem(BrokenGlass);
        }
        return Direction.TO_NORTH;
    }
}
