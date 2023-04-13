package OOP.ec22612.MP.contributions;

import java.util.Random;

public class Room_ec22941 extends Room {
    int gold_taken;
    Random rnd;
    Item Souvenir = new Item("Souvenir");

    // get random int, new random is created every call
    int getRandomInt(int upperBound) {
        rnd = new Random();
        return rnd.nextInt(upperBound);
    };

    // if the visitor comes from west, it is instantly night, otherwise there is a
    // 1/3 chance that it will be night
    public Direction visit(Visitor vis, Direction dir) {
        char[] yesno_choices = { 'y', 'n' };
        int night_chance = getRandomInt(3);
        boolean isNight = false;

        vis.tell("The room you entered has a pleasant atmosphere.");
        vis.tell("You sit on the sofa and relax.");

        if (dir == Direction.FROM_WEST) {
            isNight = true;
            vis.tell("You get a weird feeling in your chest.");
            vis.tell("You may have not realised the passage of time, however it is already deep night.");
        } else {
            if (night_chance == 0) {
                isNight = true;
                vis.tell("You may have not realised the passage of time, however it is already deep night.");
            }
        }
        // if is night the visitor will sleep and wake up to find an item on the counter
        // which they can choose to take
        // if they already have the item from a previous encounter, they get gold

        // check if there is item
        if (vis.hasEqualItem(Souvenir) || vis.hasIdenticalItem(Souvenir)) {
            vis.tell("You notice some gold coins on the counter.");
            vis.tell("A voice tells you they are yours to take");
            vis.giveGold(8);
            vis.tell("You decide to rest until morning.");
        } else {
            // check time of day
            if (isNight) {
                vis.tell("You dream pleasantly of golden wheat fields, you wake peacefully in the morning.");
                vis.tell("You notice a glow on the top of the wardrobe.");
                char choice = vis.getChoice("Inspect the wardrobe?(y/n)", yesno_choices);
                if (choice == 'y') {
                    vis.tell("You find an odd looking coin on the top.");
                    vis.giveItem(Souvenir);
                } else if (choice == 'n')
                    vis.tell("You decide not to look up any wardrobes, it could have some risks");
                // if it is day the visitor is robbed by a ghost
            } else {
                vis.tell("You notice a faceless ghost enter your room in the middle of the day.");
                vis.tell("It's an outlaw ghost! It takes away some of your gold (5 gold)");
                gold_taken += vis.takeGold(5);
                vis.tell("You have lost " + gold_taken + " in this room.");
            }
        }

        vis.tell("You decide it's time to leave this room");
        return Direction.opposite(dir);
    }
}
