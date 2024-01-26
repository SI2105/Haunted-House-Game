package HauntedHouseGame.contributions;// Rahat Ali, ec22468
// 24/02/2023
// Updated again on 1/03/2023
// Assigment 4, OOP

class Room_ec22468 extends Room {
    private Item cake = new Item("Cake from Aperture Science cake shop");
    private boolean light = false;
    // make char array for yes/no
    char[] yesNo = new char[]{'y','n'};


    public Direction visit(Visitor v,Direction directionVistorArrivesFrom) {
        
        // If light is off, turn on the light.
        if (!light){
            light = true;
            v.tell("You turn on the light.");
        }
        else {
            v.tell("Which coconut decided not to turn off the lights on their way out? The energy bill is going to be huge! I am never gonna financially recover from this.");
        }
        
        v.tell("Welcome, test subject, to the Aperture Science cake shop.");
        v.tell("You thought it was a regular room but no, it was me, the cake shop!");

        // Check if v previously bought cake
        if (!v.hasEqualItem(cake)) {

            v.tell("We have a cake, which is not a lie, for 3 gold.");
            v.tell("You glace over at a table with a cake on it.");

            char choice = v.getChoice("Do you want buy the cake for 3 gold? (y/n)",yesNo);

            // Buy cake
            if (choice == 'y') {
                v.takeGold(3);
                v.giveItem(cake);
                v.tell("You bought the cake. It's not a lie, is it?");
            } else {
                v.tell("There's nothing here. You already bought the cake.");
            }
        }


        // User must cakes to view this hidden route.
        else {
            v.tell("You have unlocked the hidden cake route.");
            v.tell("For each question you get right, you get 1 gold.");
            v.tell("However, for each question you get wrong, you lose 1 gold.");
            
            char choice = v.getChoice("Do you want to participate? (y/n)", yesNo);

            if (choice == 'y') {
                // Count how much gold user won/lost
                int gold = 0;
                v.tell("Very well. Here is your first question:");
                
                // Question 1
                v.tell("1. Which chocolate layer cake is scarlet-coloured?");
                choice = v.getChoice("A) Chocolate cake\nB) Red velvet cake\nC) Devil's Food cake\nD) Chocolate chip cake", new char[]{'a','b','c','d'});
                
                if (choice == 'b') {
                    v.tell("Correct! You get 1 gold.");
                    v.giveGold(1);
                    gold++;
                } else {
                    v.tell("Incorrect! You lose 1 gold.");
                    v.takeGold(1);
                    gold--;
                }

                // Question 2
                v.tell("2. Which country does the Black Forest cake come from?");
                choice = v.getChoice("A) Germany\nB) France\nC) Italy\nD) Switzerland", new char[]{'a','b','c','d'});

                if (choice == 'a') {
                    v.tell("Correct! You get 1 gold.");
                    v.giveGold(1);
                    gold++;
                } else {
                    v.tell("Incorrect! You lose 1 gold.");
                    v.takeGold(1);
                    gold--;
                }

                // Question 3
                v.tell("3. What kind of cake is baked in a Bundt pan?");
                choice = v.getChoice("A) Angel food cake\nB) Pound cake\nC) Sponge cake\nD) Cheesecake", new char[]{'a','b','c','d'});

                if (choice == 'c') {
                    v.tell("Correct! You get 1 gold.");
                    v.giveGold(1);
                    gold++;
                } else {
                    v.tell("Incorrect! You lose 1 gold.");
                    v.takeGold(1);
                    gold--;
                }

                v.tell("You have finished the quiz. You have won " + gold + " gold.");

                if (gold > 0){
                    v.tell("I will never financially recover from this...");
                }
                else {
                    v.tell("Thank you for your generous donation. We will use it to pay for the energy bill.");
                }

        }
    }

        v.tell("You leave the room.");

        return Direction.opposite(directionVistorArrivesFrom);
    }
}
