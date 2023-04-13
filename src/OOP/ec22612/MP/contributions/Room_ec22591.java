package OOP.ec22612.MP.contributions;

import java.util.Random;


public class Room_ec22591 extends Room{
    boolean firstTime = true;
    boolean meltCandle= false;
    boolean chestOpen = false;
    boolean pulledLever = false;
    boolean[] doorsOpen = new boolean[]{true,true,true,true};
    Direction[] doors = new Direction[]{Direction.TO_NORTH, Direction.TO_EAST, Direction.TO_SOUTH, Direction.TO_WEST};
    int closedDoor = -1;
    String[] doorsAsString= new String[]{"north","east","south","west"};
    Random random = new Random();
    Item key = new Item("key");
    Item luckyToken = new Item("lucky_token");
    
    public Direction visit( Visitor visitor, Direction direction){
        int interactionCount = 0;
        boolean run = true;
        if (firstTime){
        visitor.tell("Welcome to my room. Explore around, but be careful\n");
        }

        else{
            visitor.tell("Hello again. What made you come back? Oh well, the rooms in the same state you left it in\n");

            if(visitor.hasIdenticalItem(luckyToken)){
                visitor.tell("Youre lucky charm is glowing. It just gave you some gold\n**+2 gold**\n");
                visitor.giveGold(2);
            }
        }
        firstTime = false;
    
        while (run){
            if(interactionCount < 7){
                char visitorChoice = visitor.getChoice(("a) Lift the heavy lever\n" + "b) Light the candle\n" + "c) Rest on the bed\n"+"d) Open chest\n"+"e) Exit this room\n"), new char[]{'a','b','c','d','e'});
                interactionCount++;

                if (visitorChoice == 'a'){
                    if (!pulledLever){
                        int randint = random.nextInt(4);
                        doorsOpen[randint] = false;
                        closedDoor = randint;
                        visitor.tell("BAM! The " + doorsAsString[randint]+ " door has been locked. You cannot leave this room through that door\n");
                        pulledLever = true;
                    }

                    else{
                        visitor.tell("Seems like nothing happened\n");
                    }
                }

                else if(visitorChoice =='b'){
                    if (!meltCandle){
                        visitor.tell("The wax has melted and it seems there was a key inside. You now have a key\n");
                    }
                    else{
                        visitor.tell("Wax has fully melted. The candle cannot be lit\n");
                    }
                    meltCandle = true;
            
                    if(!visitor.hasIdenticalItem(key)){
                        visitor.giveItem(key);
                    }  
                }

                else if (visitorChoice =='c'){
                    int badDream = random.nextInt(1);

                    if (badDream == 0){
                        visitor.tell("**A few hours later**\n");

                        if(visitor.hasIdenticalItem(luckyToken)){
                            visitor.tell("Oi, rent isnt free you know. I charge 3 gold a night\n**-3 Gold**\n");
                            visitor.takeGold(3);
                        }
                        else{
                            visitor.tell("Good Morning, you must be well rested\nYou got a lucky token... I wonder what it means\n");
                            visitor.giveItem(luckyToken);
                        }
                    } 

                    else{
                        int randomDoor = random.nextInt(doors.length);
                        visitor.tell("You had a very bad dream. You ran out from fear through the " + doorsAsString[randomDoor] + " door!!\n");
                        run = false;
                    }
                }

                else if(visitorChoice =='d'){

                    if(visitor.hasIdenticalItem(key) && !chestOpen){
                        chestOpen = true;

                        if(visitor.hasIdenticalItem(luckyToken)){
                            visitor.tell("Youre lucky token has helped you. You found double gold\n**+8 Gold**\n");
                            visitor.giveGold(8);
                        }
                        else{
                            visitor.tell("The key worked!! The chest has some gold\n**+4 Gold**\n");
                            visitor.giveGold(4);
                        }
                    }

                    else if (visitor.hasEqualItem(key) && !chestOpen){
                        visitor.tell("It seems that you do have a key but it does not fit\nYou need to find a key from this room\n");
                    }

                    else if (chestOpen && visitor.hasIdenticalItem(key)){
                        visitor.tell("There is no gold left\n");
                    }

                    else{
                        visitor.tell("The chest is locked, I can see there is a keyhole... maybe I need to find a key\n");
                    }
                }
                else if (visitorChoice =='e'){
                    
                    String mapToDisplay = "";
                    // displays the menu option for the visitor
                    for (int i = 0 ; i < 4; i++){
                        if(i == closedDoor){
                            mapToDisplay = mapToDisplay + (i+1) + ") " + doorsAsString[i] + " (IT IS CLOSED SHUT)" + "\n" ;
                        }
                        else{
                        mapToDisplay = mapToDisplay + (i+1) + ") " + doorsAsString[i] +"\n";
                        }
                    }

                    visitor.tell("Which direction would you like to exit from\n");
                    char userChoice = visitor.getChoice(mapToDisplay, new char[]{'1','2','3','4'});

                    // if else statements to make the direction north south or whatever it is
                    
                    char temp = Integer.toString(closedDoor+1).charAt(0);
                    if(!(userChoice == temp)){
                        run = false;
                        if (userChoice == '1'){
                            direction = doors[0];
                        }
                        else if(userChoice == '2'){
                            direction = doors[1];
                        }
                        else if(userChoice == '3'){
                            direction = doors[2];
                        }
                        else if(userChoice == '4'){
                            direction = doors[3];
                        }

                        if (pulledLever){
                            visitor.tell("The " + doorsAsString[closedDoor]+ " door has now opened...\n");
                        }
                        else{
                             visitor.tell("Bye bye!\n");
                        }        
                    }

                    else{
                        visitor.tell("That door is closed shut\n"); 
                    } 
                }
            }

            else{
                int randomDoor = random.nextInt(doors.length);
                direction = doors[randomDoor];
                visitor.tell("You have done too many action. I'm kicking you out through the " + doorsAsString[randomDoor]);
                run = false;
            }
        }
        doorsOpen = new boolean[]{true,true,true,true};
        pulledLever = false;
        closedDoor=-1;
        return direction;
    } 
}