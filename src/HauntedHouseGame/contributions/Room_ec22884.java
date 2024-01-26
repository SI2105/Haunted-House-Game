package HauntedHouseGame.contributions;

class Room_ec22884 extends Room {
    final Item key = new Item("key");
    final Item leverWin = new Item("leverWin");
    
    public Direction visit(Visitor visitor, Direction arrivalDirection) {
        
        if (arrivalDirection.equals(Direction.FROM_WEST)) {
            TreasureCompartment(visitor);
            return Direction.opposite(arrivalDirection);
        }
        else if (arrivalDirection.equals(Direction.FROM_NORTH)) {
            CollectKey(visitor);
            return Direction.opposite(arrivalDirection);
        }
        else if (arrivalDirection.equals(Direction.FROM_SOUTH)) {
            GiantCross(visitor);
            return Direction.opposite(arrivalDirection);
        }
        else if (arrivalDirection.equals(Direction.FROM_EAST)) {
            LeverRoom(visitor);
            return Direction.opposite(arrivalDirection);
        }
        else {
            visitor.tell("How did you come from this direction?");
            return Direction.FROM_NORTH;
        }
    }

    private void TreasureCompartment(Visitor visitor) {
        WallDescription(visitor);
        TreasureRoomDescription(visitor);
        if (visitor.hasIdenticalItem(key))
        {
            OpenChest(visitor);
            return;
        }
        KeyPrompt(visitor);
        return;
    }

    private void WallDescription(Visitor visitor) {
        visitor.tell("You find yourself in a small room. It seems that parts of the room is being blocked by walls. \nPerhaps entering the room from an another direction will let you discover more.\n");
        return;
    }

    private void TreasureRoomDescription(Visitor visitor) {
        visitor.tell("You find a room with a giant golden chest, unfortunately the chest is locked. \nUsing the drawings on the walls you decipher that the key must be in this room, perhaps in a different section.");
        return;
    }

    private void OpenChest(Visitor visitor) {
        char choice = visitor.getChoice("You remember that you already have the key.\n Would you like to open the chest? (Y/N)", new char[]{'Y', 'N'});
        if (choice== 'Y' || choice == 'y') {
            visitor.tell("Congrats, you have found 10 gold");
            visitor.giveGold(10);
        }
        return;
    }

    private void KeyPrompt(Visitor visitor) {
        visitor.tell("You don't seem to have the right key.\nMaybe you should try to come in from a different direction.");
    }

    private void CollectKey(Visitor visitor) {
        WallDescription(visitor);
        PickUpKey(visitor);
        ZayanCollab(visitor);
        return;
    }

    private void PickUpKey(Visitor visitor) {
        visitor.tell("You see a key in the middle of the room.\nFrom the drawings in the walls you decipher that this key must open something in this room.\nPerhaps you should try to enter the room from a different direction to find out what the key opens."); 
        while(visitor.giveItem(key)) {}
        return;
    }
    
    private void ZayanCollab(Visitor visitor)
    {
        char choice = visitor.getChoice(".\n.\n.\nYou see a piece of paper underneath some cobwebs.\nPick it up? (Y,N)", new char[] {'Y','N'});
        if (choice == 'Y' || choice == 'y') {
            visitor.tell("You found a newspaper article about a car crash about a guy that died of a car crash.\n'Alex Green' poor person.");
            while (visitor.giveItem(new Item("NewspaperZAM"))) {}
        }
        return;
    }

    private void GiantCross(Visitor visitor) {
        WallDescription(visitor);
        CrossRoomExplanation(visitor);
        if (visitor.hasEqualItem(new Item("shovel")) || visitor.hasEqualItem(new Item ("Shovel")))
        {
            ShovelPrompt(visitor);
            visitor.giveGold(10);
        }
        return;
    }

    private void ShovelPrompt(Visitor visitor) {
        visitor.tell("You recall that you do have a shovel and decide to dig underneath the cross.\n.\n.\n.You discovered 10 hidden gold!");
        return;
    }

    private void CrossRoomExplanation(Visitor visitor) {
        visitor.tell("The room is filled with varius flora as if to resemble a small garden \nIn the middle of the room you see a giant red cross, perhaps you could dig to find out what's underneath.\nPerhals a shovel could help, maybe a garden room might have one.");
    }

    private void LeverRoom(Visitor visitor) {
        WallDescription(visitor);
        LeverRoomPrompt(visitor);
        if (visitor.hasEqualItem(new Item("LeverCodeZM")))
        {
            CodePrompt(visitor);
        }
        while (PickLever(visitor)) {}
        return;
    }

    private void LeverRoomPrompt(Visitor visitor) {
        visitor.tell("You see 6 different levers infront of you.\nYou feel as though you will be rewarded for flipping the right lever but picking the wrong will probably have consequences as well.\nPerhaps an old resident might know which lever is correct.\nThough if someone is that old they are probably dead as well...");
        return;
    }

    private void CodePrompt(Visitor visitor) {
        visitor.tell("You recall that the unaware ghost had told you about an old lever that he used to hide some gold.\nYou think it was the forth lever.");
        return;
    }

    private boolean PickLever(Visitor visitor) {
        String prompt = new String("Which lever do you want to flip? (0 for none");
        char[] options = {'1', '2', '3', '4', '5', '6', '0'};
        switch (visitor.getChoice(prompt, options)) {
            case '4':
                visitor.tell("Congrats you gained 10 gold.");
                visitor.giveGold(10);
                while (visitor.giveItem(leverWin)) { };
                return true;
            case '0':
                return false;
            default:
                visitor.tell("Unfortunetly, you picked the wrong lever, lose 5 gold");
                int temp = visitor.takeGold(5);
                return true;
        }       
    }
}
