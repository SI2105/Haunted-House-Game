package HauntedHouseGame.contributions;

import java.util.Random;
class Room_ec22459 extends Room{
    private final Item rifleItem = new Item("Rifle");
    private boolean trapDoor;

    private Visitor rouletteGamble(Visitor v){
        v.tell("Welcome to the roulette table");
        v.tell("You can only bet 1 gold at a time");
        char roll = v.getChoice("Do you wish to roll the roulette table?", new char[] {'y','n'});

        if (roll == 'n'){
        }
        else{
            v.takeGold(1);
            v.tell("1 gold has been deducted from your balance");

            char blackRed = v.getChoice("Do you wish to bet on red or black? r/b", new char[] {'r','b'});
            Random rand = new Random();
            int roulette = rand.nextInt(2);
            if(roulette == 0){
                if (blackRed == 'r'){
                    v.tell("You won!");
                    v.giveGold(2);
                }
                else{
                    v.tell("You lost...");
                }
            }
            else{
                if (blackRed == 'b'){
                    v.tell("You won!");
                    v.giveGold(2);
                }
                else{
                    v.tell("You lost...");
                }
            }
        }
        return v;
    }

    private Direction randomDirection() {
        Random rand = new Random();
        switch (rand.nextInt(4)) {
            case 0:
                return Direction.TO_NORTH;
            case 1:
                return Direction.TO_EAST;
            case 2:
                return Direction.TO_SOUTH;
            case 3:
                return Direction.TO_WEST;
            default:
                return Direction.TO_NORTH;
        }
    }


    public Direction visit(Visitor v, Direction d){
        v.tell("You have entered room");
        v.tell("The room is dimly lit, red tinted room");

        v.tell("a: There is an elegant looking man standing behind a covered table");
        v.tell("b: There is a  friendly looking woman standing behind a bar");
        v.tell("c: Explore the room");



        char choiceRoute = v.getChoice("Select a route to go, a b or c", new char[] {'a','b','c'});
        switch(choiceRoute){
            case 'a':
                v.tell("The man grins as you approach him");
                v.tell("He pulls off the cover from the table to reveal a roulette table");
                rouletteGamble(v);
                v.tell("The man tells you to leave from the opposite direction you came from");
                return Direction.opposite(d);

            case'b':
                v.tell("As you approach the bartender you notice her unusually pale skin");
                char drink = v.getChoice("Welcome, would you like a drink y/n", new char[] {'y','n'});
                if(drink == 'y'){ // bad ending drink
                    v.tell("The bartender begins making you a drink");
                    v.tell("Drink up, the bartender tells you");
                    v.tell("As you drink your vision starts to darken, with your mind going blank");
                    v.tell("");
                    v.tell("");
                    v.tell("");
                    v.tell("You wake up next to a random door with a bitemark in your neck, the woman was a vampire...");
                    v.takeGold(5);
                    v.tell("5 gold has been deducted from your balance");
                    return randomDirection();
                }
                else{ // good ending no drink
                    v.tell("I have no use for customers who dont drink, says the bartender");
                    v.tell("The bartender kicks you out");
                    v.tell("As you're leaving you notice a coin on the floor and pick it up");
                    v.takeGold(1);
                    return randomDirection();
                }

            case'c':
                v.tell("You look around the room");
                if(v.hasEqualItem(rifleItem)){
                    v.tell("You found a rifle, but already have one so choose to leave it");
                }
                else{
                    char rifle = v.getChoice("You find a hunting rifle, do you wish to take it? y/n", new char[] {'y','n'});
                    if(rifle == 'y'){
                        v.tell("You took the rifle");
                        v.giveItem(rifleItem);
                    }
                    else{
                        v.tell("You chose to leave the rifle");
                    }
                }
                v.tell("Suddenly, you hear growling from behind you");
                v.tell("A zombie like wolf with bloodshot eyes approaches you");
                if (v.hasEqualItem(rifleItem)){ 
                    v.tell("You pull out your rifle and shoot at the wolf");
                    v.tell("The wolf dies");
                    v.tell("Its blood bubbles and boils as it pours out of its corpse");
                    v.tell("The blood unnaturally streams in a certain direction");
                    char follow = v.getChoice("Do you wish to follow the stream of blood? y/n", new char[] {'y','n'});
                    if(follow == 'y'){ // good ending
                        v.tell("You decide to follow the stream");
                        v.tell("You find a bag with 5 gold inside");
                        v.takeGold(5);
                        v.tell("A door appears as you take the bag");
                        v.tell("You leave through the door");
                        return d.TO_NORTH;
                    }
                    else{ // mid ending
                        v.tell("You decided not to follow the stream");
                        v.tell("You explore more and find a door to exit from");
                        v.tell("You leave through the door");
                        return d.TO_EAST;
                    }

                }
                else{ 
                    v.tell("The wolf charges towards you");
                    v.tell("You have no way of defending yourself");
                    Random rand = new Random();
                    trapDoor = rand.nextBoolean();
                    if (trapDoor == true){ // good ending
                        v.tell("As you are running away you see a trapdoor");
                        v.tell("You decide to bait the wolf into falling into the trapdoor");
                        v.tell("The wolf falls into the trapdoor");
                        v.tell("You successfully escape the wolf");
                        v.giveGold(3);
                        v.tell("You explore more and find a door to exit from");
                        v.tell("You leave through the door");
                        return d.TO_EAST;
                    }
                    else{ // bad ending
                        v.tell("The wolf bites your leg as you frantically run off");
                        v.tell("You eventually end up at a random door and escape from the wolf");
                        v.takeGold(2);
                        v.tell("2 gold has been deducted from your balance");
                        return randomDirection();
                    }
                }

            default:
                return randomDirection();
        }
    }
}
