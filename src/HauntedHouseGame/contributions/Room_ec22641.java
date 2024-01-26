package HauntedHouseGame.contributions;

class Room_ec22641 extends Room{

    Item ElderWand = new Item("Elder Wand");

    Item InvisibilityCloak = new Item("Invisibility Cloak");

    Item Stone = new Item("Ressurection Stone");

    char [] options = new char[]{'a','b','c'};

    char [] options1 = new char[] {'a','b'};

    static int visited_door = 0;

 

    public Direction visit (Visitor visitor, Direction d){

 

      visitor.tell("Hello there! Welcome to room ec22641");

 

        if ((visited_door==1))

        {
            visitor.tell("Wow so brave that you came here");

            visitor.tell("Hi there, welcome to the house of ancient magic");

        }

 

 

        visitor.tell("The ancestors of the ancient magic have chosen you to become the protector of the magic world.");

        visitor.tell("You have three choices and these choices include the three famous deathly hallows.");

        visitor.tell("There can be consequences about what you choose, so choose wisely");

        visitor.tell("If you never heard the three deadly hallows are;");

        visitor.tell("Invisibility Cloak");

        visitor.tell("Resurrection Stone");

        visitor.tell("And the most famous of all, The Elder Wand");

        visitor.tell("If you choose Invisibility Cloak you will become invisible when you wear it.");

        visitor.tell("If you choose Resurrection Stone you will have the chance to bring back a loved one form the grave but at a cost.");

        visitor.tell("If you choose The Elder Wand you will have the most powerful wand in the world.");

        visitor.tell("So choose wisely and make a selection.");

        char option = visitor.getChoice("(a) Invisibility Cloak  (b) Resurrection Stone  (c) The Elder Wand", options);

 

        if (option == 'a')

        {

            visitor.tell("Hmm... You chose the Invisibility Cloak. Not the most popular one, but most certainly a good one.");

            visitor.tell("I will give you 5 golds, do not lose them. And if you manage to survive you can keep all of them");

            visitor.giveGold(5);

            visitor.tell("OH NO! Well it is time to put your cloak skills to the test. There are enemies.");

            visitor.tell("Go past them quietly or if you are feeling brave take them out quietly by casting Petrificus Totalus");

 

            char option1 = visitor.getChoice("(a) Go quietly (b) Cast spell", options1);

            if (option1 == 'a')

            {

                visitor.tell("Phew. You chose the easy way and you were successfull");

                visitor.tell("That was a close call but lets continue");

            }

 

            else if (option1 == 'b')

            {

                visitor.tell("Well you chose the hard way lets see how is it going to turn out for you.");

                visitor.tell("OH NO! They saw you casting the spell on an enemy.");

                visitor.tell("RUN!!! RUN FOR YOUR LIFE!!");

                visitor.tell("Well you chose the hard way and you survived but with a cost");

                visitor.takeGold(3);

                visitor.tell("You just lost 3 golds!");

                visitor.tell("Well lets continue");

            }

 

            else

            {

                visitor.tell("Please select one above");

               

            }

 

            visitor.tell("Well somehow you managed to get into the main room");

            visitor.tell("In this room you can take 1 more gold");

            visitor.tell("However the golds won't fit with you inside the cloak and there are enemies and thieves all around you.");

            visitor.tell("So you have to make a one last choice and the wrong one can be brutal for you.");

            char option2 = visitor.getChoice("(a) Hide the golds inside the cloak (b) Hide yourself in the cloak with with golds being outside", options1);

 

            if (option2 == 'a')

            {

                visitor.tell("Well you chose the dangerous way. Lets see how it turns out for you");

                visitor.tell("You are proceeding good. You are blending in really good.");

                visitor.tell("Who would've thought. They thought you were one of them.");

                visitor.tell("Congratulations! You have made it through.");

                visitor.giveGold(1);

            }

 

            else if (option2 == 'b')

            {

                visitor.tell("Well you chose the more subtle way.");

                visitor.tell("Lets see how does it turn out for you.");

                visitor.tell("Ok. Looking good here...");

                visitor.tell("OH NO! They saw the golds floating and recognised you!");

                visitor.tell("All of them are attacking you!");

                visitor.tell("Well... You couldn't survive and you are actually dead.");

                visitor.tell("Have a good after life...");

            }

 

 

            else

            {

                visitor.tell("Please select one from above");

                char options2 = visitor.getChoice("(a) Hide the golds inside the cloak (b) Hide yourself in the cloak with with golds being outside", options1);

            }
        }

      

 

 

 

 

 

        else if (option == 'b')

        {

            visitor.tell("Well you chose the Resurrection Stone.");

            visitor.tell("I didn't actually think you would select it.");

            visitor.tell("Well... I would give you 5 golds but there is no way that you are surviving with the stone");

            visitor.tell("So I just assume you are dead and please do not continue to this journey");

            visitor.tell("Thank you for understanding and BYE!");

        }

 

        else if (option == 'c')

        {

            visitor.tell("Well well well... I thought you would choose this.");

            visitor.tell("The most popular of them all. The Elder Wand.");

            visitor.tell("This is going to be easy for you.");

            visitor.tell("Ok then lets start");

            visitor.tell("You entered the room and there are enemies all over you");

            visitor.tell("What do you wanna do? Cast Bombarda Maxima which will take out your enemies in one spell or fight them individually?");

            char option3 = visitor.getChoice("(a) Bombarda Maxima (b) Fight them", options1);

 

            if (option3 == 'a')

            {

                visitor.tell("Wise choice");

                visitor.tell("Lets see what happens");

                visitor.tell("You enter the door and you take out the enemies instantly with the spell.");

                visitor.tell("That was easy for you");

                visitor.tell("I am sure you are up for another challenge because it won't be easy");

                visitor.tell("Your next opponent in the other room will be Voldemort.");

                visitor.tell("You'll have two choices. Either you fight Harry Potter way or fight random.");

                char option4 = visitor.getChoice("(a) Harry Potter way (b) Random", options1);

 

                if (option4 == 'a')

                {

                    visitor.tell("Hmm... The classic answer");

                    visitor.tell("Well here you go into to the room.");

                    visitor.tell("As you go into the room Voldemort starts attacking you.");

                    visitor.tell("You go expelliarmus and he goes Avada Kadavra.");

                    visitor.tell("In the end you beat him and survive through this house.");

                    visitor.tell("For this achievement I award you 3 more golds");

                    visitor.giveGold(3);

                }

 

                else if (option4 == 'b')

                {

                    visitor.tell("Not the answer I was hoping for but lets see how it turns out.");

                    visitor.tell("You go inside without a plan and start casting spells randomly.");

                    visitor.tell("Surprisingly you survive, however because of the heavy damage you dealt, you lost some golds in thr end.");

                    visitor.takeGold(2);

                    visitor.tell("It seems like you lost 2 golds, however you survived.");

                    visitor.tell("Congratulations!");

                }

            }

         

 

            else if (option3 == 'b')

            {

                visitor.tell("Not the best choice but we'll see how it turns out");

                visitor.tell("You start of great with disarming one enemy and taking out another enemy.");

                visitor.tell("However they are too much and someone disarms you and casts crucio");

                visitor.tell("Well... I don't know how did you managed to mess this up but here we are.");

                visitor.tell("THE END");

            }

 

        }

    

 

        return Direction.opposite(d);

 

       }

 

    }
