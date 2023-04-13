package OOP.ec22612.MP.contributions;

class Room_ec22977 extends Room {
    private boolean wardrobe_emptied = false;
    public Direction visit(Visitor v, Direction d) {


        String message = "Here is the bedroom" + "n/" + "The wardrobe is in front of you." + "n/" + "The table is on your left.";
        v.tell(message);

        String choice_message1 = "1)Go to the wardrobe in front of you. - You pick up the scream mask";
        String choice_message2 = "2)Go left to the table. - You hide under the table.";
        String choice_message3 = "3)Exit - Leave the room";
        String choice_message = choice_message1 + "n/" + choice_message2 + "n/" + choice_message3;
        Item scream_mask = new Item("scream mask");
        char[] choices = {'1', '2', '3'};
        char choice = v.getChoice(choice_message, choices);

        if (wardrobe_emptied == false) {
            if (choice == '1') {
                v.giveItem(scream_mask);
                wardrobe_emptied = true;
                v.tell("You picked up a scream mask from the wardrobe and you are now wearing it. You also found a bag of gold.");
                v.giveGold(8);
                String option_leave1 = "1)Go hide under the table 2)Leave the room ";
                char[] choices_leave1 = {'1', '2'};
                choice = v.getChoice(option_leave1, choices_leave1);
                if (choice == '1') {
                    v.tell("You are now hiding from the ghosts under the table and find some gold");
                    v.giveGold(5);
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                }
            } else if (choice == '2') {
                v.tell("You are now hiding from the ghosts under the table where there was some gold");
                v.giveGold(5);
                String option_leave2 = "1)Go to the wardrobe - Pick up a scream mask 2)Leave the room";
                char[] choices_leave2 = {'1', '2'};
                choice = v.getChoice(option_leave2, choices_leave2);
                if (choice == '1') {
                    v.giveItem(scream_mask);
                    wardrobe_emptied = true;
                    v.tell("You picked up a scream mask from the wardrobe and you are now wearing it. You also find a bag of gold.");
                    v.giveGold(8);
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as a human and are haunting you");
                    v.tell("You lose some gold while you were running away from the ghosts");
                    v.takeGold(3);
                    return Direction.opposite(d);
                }
            } else if (choice == '3') {
                v.tell("The ghosts recognise you as a human and are haunting you");
                v.tell("You lose some gold while you were running away from the ghosts");
                v.takeGold(3);
                return Direction.opposite(d);
            }
        } else if (wardrobe_emptied == true) {
            if (choice == '1') {
                v.tell("You already picked up a scream mask from the wardrobe and you are now wearing it.");
                String option_leave1 = "1)Go hide under the table 2)Leave the room ";
                char[] choices_leave1 = {'1', '2'};
                choice = v.getChoice(option_leave1, choices_leave1);
                if (choice == '1') {
                    v.tell("You are now hiding from the ghosts under the table");
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                }
            } else if (choice == '2') {
                v.tell("You are now hiding from the ghosts under the table where there was some gold");
                v.giveGold(5);
                String option_leave2 = "1)Go to the wardrobe - Pick up a scream mask 2)Leave the room";
                char[] choices_leave2 = {'1', '2'};
                choice = v.getChoice(option_leave2, choices_leave2);
                if (choice == '1') {
                    v.giveItem(scream_mask);
                    wardrobe_emptied = true;
                    v.tell("You picked up a scream mask from the wardrobe and you are now wearing it. You also find a bag of gold.");
                    v.giveGold(8);
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as a human and are haunting you");
                    v.tell("You lose some gold while you were running away from the ghosts");
                    v.takeGold(3);
                    return Direction.opposite(d);
                }
            } else if (choice == '3') {
                v.tell("The ghosts recognise you as a human and are haunting you");
                v.tell("You lose some gold while you were running away from the ghosts");
                v.takeGold(3);
                return Direction.opposite(d);
            }
        } else if (wardrobe_emptied == true) {
            if (choice == '1') {
                v.tell("You already picked up a scream mask from the wardrobe and you are now wearing it.");
                String option_leave1 = "1)Go hide under the table 2)Leave the room ";
                char[] choices_leave1 = {'1', '2'};
                choice = v.getChoice(option_leave1, choices_leave1);
                if (choice == '1') {
                    v.tell("You are now hiding from the ghosts under the table");
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                }
            } else if (choice == '2') {
                v.tell("You are now hiding from the ghosts under the table ");
                String option_leave2 = "1)Go to the wardrobe 2)Leave the room";
                char[] choices_leave2 = {'1', '2'};
                choice = v.getChoice(option_leave2, choices_leave2);
                if (choice == '1') {
                    v.tell("You already picked up a scream mask from the wardrobe and you are now wearing it.");
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                } else if (choice == '2') {
                    v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                    return Direction.opposite(d);
                }
            } else if (choice == '3') {
                v.tell("The ghosts recognise you as one of their own because of the scream mask so you do not lose any gold");
                return Direction.opposite(d);
            }
        }
        return Direction.opposite(d);
    }
}
