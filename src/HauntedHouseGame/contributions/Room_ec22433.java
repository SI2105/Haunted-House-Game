package HauntedHouseGame.contributions;

class Room_ec22433 extends Room {
    public Direction visit(Visitor vPerson, Direction dIntoRoom) {
        final Item goldenPen = new Item("goldenPen");
        // Initial entry
        vPerson.tell("Welcome to Academia, the House for gifted individuals among the already gifted!");
        vPerson.tell("Entry into this house requires unfathomable intellectual capabilities, " +
                "Extraordinary gifts, heightened imagination and a £2 fee to help pay for rent in the UK - its not " +
                "cheap!");
        vPerson.takeGold(2);

        vPerson.tell("Time to see what Academia is really about - You've heard about the cursed boy, "
                + "Right???");
        String routes = ("Would you like to a) Go downstairs to the Great Hall b) Go outside in the garden c) Go upstairs to the attic or d) Go through to the wine room?");
        char[] options = {'a', 'b', 'c', 'd'};

        char choice = vPerson.getChoice(routes, options);

        if(choice == 'a') {
            vPerson.tell("You are now exploring the Great Hall - wasn't easy for students to rip their way out.");
            vPerson.tell("You've reached desk 3A, you've seen the claw marks and the dents, along with the sandwich taped underneath.");
            vPerson.tell("However you realised you entered the hall with the lights off, thinking money will be saved on the monthly bill");
            vPerson.tell("But its the UK so you also get charged for lights off ;) {£3} - you know, inflation, cost of living blah blah etc etc");
            vPerson.takeGold(3);
        }

        else if(choice == 'b') {
            vPerson.tell("The house gave you creeps, so you go out into the garden for some air.");
            vPerson.tell("Walking around, adoring all that nature gives until you come across a pen?");
            vPerson.tell("You try to remind yourself where you've heard about / seen this pen before but " +
                    "you remember your mortgage payment has gone up on your personal home - you know inflation blah blah");
            vPerson.tell("So you think nothing of it and only acknowledge its gold so you wanna sell it later to treat yourself to some good food");
            vPerson.tell("But you know, UK, inflation, cost of living, not really serious so hey why not :).");
            vPerson.giveItem(goldenPen);
        }

        else if(choice == 'c') {
            vPerson.tell("You reached the attic and notice some elixir that makes you taller - because being 6ft 3 isn't enough :(.");
            vPerson.tell("Highlights of some story about a young boy and the elixir, rings some bells and you begin to remember something "
                    + "about imminent death but brush it off because the lack of heating in your own home will probably get to you first - you know cost of living blah blah etc etc");
            vPerson.tell("Drinking the potion wasn't that bad to begin with, but it made you smaller instead so you start panicking and slip down the stairs out the attic");
            vPerson.takeGold(4);
        }

        else if(choice == 'd') {
            vPerson.tell("Making it through to the wine room was easy - just walked right and i was already there.");
            vPerson.tell("You go to pick up a wine bottle but as you do so, you hear what you think is a young boy, crying !?");
            vPerson.tell("The sound of the boy then sounds like laughter and before you know it, the bottle shatters and shines golden, hurting your eyes :/ .");
            vPerson.takeGold(2);
        }

        vPerson.tell("Was nice having you explore the grounds of Academia.");
        vPerson.tell("Despite all the weird sounds and things happening around you and some story about a cursed boy, you realize your behind on your car payments :(");
        vPerson.tell("Bye. For now ;)");

        return Direction.opposite(dIntoRoom);
    }
}
