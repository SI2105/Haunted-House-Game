package HauntedHouseGame.contributions;

class Room_ec22720 extends Room
{
    static final Item KEY = new Item("Key_ec22720");
    static final Item JAVA_BOOK = new Item("Java Programming Book");
    boolean door_is_locked = false;
    boolean chest_looted = false;
    boolean key_broken = false;

    public Direction visit(Visitor visitor, Direction direction)
    {
        // If the door is blocked, the visitor has been here before
        visitor.tell("You enter an abandoned celler.");
        if (door_is_locked)
        {
            visitor.tell("You seem to have been here before, the door to the " + this.directionToString(Direction.opposite(direction)) + " is locked.");
        }
        else
        {
            visitor.tell("The door closes and locks behind you.");
            door_is_locked = true;
        }

        // Allow the visitor to unlock the door if they have a key
        if (visitor.hasEqualItem(KEY) && !key_broken)
        {
            visitor.tell("You have a key, would you like to unlock the door to the " + this.directionToString(Direction.opposite(direction)) + "?");
            visitor.tell("If you don't, maybe you can look around to use it somewhere else");
            char[] choices = new char[] {'y', 'n'};
            char doorChoice = visitor.getChoice("y/n", choices);
            if (doorChoice == 'y')
            {
                visitor.tell("You unlock the door to the " + this.directionToString(Direction.opposite(direction)) + ".");
                door_is_locked = false;
            }
            else
            {
                visitor.tell("You decide not to unlock the door.");
                visitor.tell("Looking around the celler, you spot a chest, the keyhole looks a lot like the door. Do you want to try to open it?");
                char chestChoice = visitor.getChoice("y/n", choices);
                if (chestChoice == 'y')
                {
                    visitor.tell("You struggle to open the chest, eventually the key snaps but the chest unlocks!");
                    visitor.tell("You find ten gold!");
                    visitor.giveGold(10);
                    this.key_broken = true;
                }
            }
        }

        // Offer the user places to search
        visitor.tell("You look around the celler, there's a bookshelf and a desk.");
        visitor.tell("Which do you want to search?\na) the bookshelf\nb) the desk");
        char[] choices = new char[] {'a', 'b'};
        char searchChoice = visitor.getChoice("a/b", choices);
        if (searchChoice == 'a')
        {
            visitor.tell("You search the bookshelf, and you find a book on Java programming!");
            visitor.giveItem(JAVA_BOOK);
        }
        else if (searchChoice == 'b')
        {
            visitor.tell("You search the desk, and you find a key!");
            visitor.giveItem(KEY);
        }
        else
        {
            visitor.tell("You decide not to search anything.");
        }

        // Offer the user a way out
        Direction onwards_direction = direction;
        visitor.tell("You look around; there's a door to the " + this.directionToString(onwards_direction) + ", and a door to the " + this.directionToString(Direction.opposite(direction)) + ".");
        if (door_is_locked)
        {
            visitor.tell("The door to the " + this.directionToString(Direction.opposite(direction)) + " is locked.");
        }

        char exit_choice;
        choices = new char[] {'a'};
        visitor.tell("Which way do you want to go?\na) " + this.directionToString(onwards_direction));
        if (!door_is_locked)
        {
            visitor.tell("b) " + this.directionToString(Direction.opposite(direction)));
            choices = new char[] {'a', 'b'};
            exit_choice = visitor.getChoice("a/b", choices);
        }
        else
        {
            exit_choice = visitor.getChoice("a/a", choices);
        }

        if (exit_choice == 'b')
        {
            visitor.tell("You go through the door to the " + this.directionToString(Direction.opposite(direction)) + ".");
            return Direction.opposite(direction);
        }
        else
        {
            visitor.tell("You go through the door to the " + this.directionToString(onwards_direction) + ".");
            return onwards_direction;
        }
    }

    private String directionToString(Direction d)
    {
        return d.toString();
    }
}
