package OOP.ec22612.MP.contributions;

class Room_ec22962 extends Room {
    public Direction visit(Visitor vis, Direction dir) {
        vis.tell("Greetings visitor, you have entered the lost armoury.");
        vis.tell("You should take care when exploring this room, some weapons are cursed and some are haunted.");

        vis.tell("\n Before you is a rough wooden table with two weapons lying on it.");
        vis.tell("You can chose to take one of the firearms on the table.");
        char[] choices = {'S', 'R', 'N'};
        char visitorChoice = vis.getChoice("\nTake SXP (S)hotgun,\nTake Model 1866 Winchester (R)ifle,\nTake (N)othing", choices);

        // Convert visitorChoice to always be lower case so user can input upper or lower case char
        visitorChoice = Character.toLowerCase(visitorChoice);
        switch(visitorChoice) {
            case 's':
                vis.tell("The haunted shotgun fired at you the moment you touched it. Luckily it was pointed away from you.");
                vis.tell("You got hit with the stock of the shotgun into your abdomen.\n\u001B[31m  >> 8 gold pieces fell out of your pocket.\u001B[0m");
                vis.takeGold(8);
                break;
            case 'r':
                vis.tell("You picked up the rifle.. nothing happened. Might as well take it with you.");
                vis.giveItem(new Item("Model 1866 Winchester Rifle"));
                vis.tell("\n\u001B[32m  >> New item added to inventory: Model 1866 Winchester Rifle\u001B[0m");
                break;
            case 'n':
                vis.tell("You decided not to touch either firearm. As you set to leave the room you noticed 3 pieces of gold lying on the floor.\n\u001B[32m  >> You got 3 gold pieces!\u001B[0m");
                vis.giveGold(4);
                break;
            default:
                vis.tell("Do something worthwhile visitor...");
                break;
        }

        return Direction.TO_EAST;
    }
}
