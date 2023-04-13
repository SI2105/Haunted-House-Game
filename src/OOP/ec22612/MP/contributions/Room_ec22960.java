package OOP.ec22612.MP.contributions;

import java.util.Scanner;

class Room_ec22960 extends Room{
    public void print (String msg){
        System.out.println(msg);
    }

    public String inputString(String msg){
        Scanner scanner = new Scanner(System.in);
        print(msg);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }

    boolean unlockChest(Visitor visitor){
        String code = inputString("Enter the 7 letter code(as one string in lower case):");
        boolean unlocked = false;
        if(code.equals("ccggaag")){
            unlocked = true;
            print("You manage to open the chest and find 10 gold");
            visitor.giveGold(10);
        }else{
            unlocked = false;
            print("The chest doesn't open. Maybe try again or look for the clue");
        }
        return unlocked;
    }

    void searchCupboard(){
        print("You find the missing piece of sheet music.\nThe title reads Twinkle twinkle little star and you can just about make out the 1st 7 notes.");
    }

    boolean optionA(Visitor visitor, boolean chestUnlocked){
        boolean exitRoom = false;
        boolean checkChestUnlocked = chestUnlocked;
        if(chestUnlocked == false){
            checkChestUnlocked = unlockChest(visitor);
        }
        if(chestUnlocked == true || checkChestUnlocked == true){
            exitRoom = true;
        }
        return exitRoom;
    }

    boolean optionB(Visitor visitor, boolean cupboardUnlocked, Item cupboardKey){
        boolean checkCupboardUnlocked = cupboardUnlocked;
        if(visitor.hasEqualItem(cupboardKey) && checkCupboardUnlocked == false){
            checkCupboardUnlocked = true;
            searchCupboard();
        }else if(cupboardUnlocked == true || checkCupboardUnlocked == true){
            searchCupboard();
        }
        return checkCupboardUnlocked;
    }

    public Direction visit( Visitor visitor, Direction directionVistorArrivesFrom){
        String intro  = "As you enter the room you notice chest sitting at the back of the room.\nUnfortunatey its lock and the padlock needs a 7 letter code.";
        String intro2 = "Maybe there might be a clue somewhere else in the room?";
        String intro3 = "Theres a piano in the back corner, a bunch of book shelves and a cupboard.";
        String intro4 = "Search the room and see if you can find a way to open the .";
        print(intro + "\n" + intro2 + "\n" + intro3 + "\n" + intro4);

        char[] options = {'a','b','c','d','e'};
        String optionList = "a)Open chest\nb)Check cupboard\nc)check bookshelves\nd)Check piano\ne)exit";
        
        Item cupboardKey = new Item("Cupboard Key");

        boolean exitRoom = false;
        boolean chestUnlocked = false;
        boolean cupboardUnlocked = false;
        boolean keyAquired = false;


        while(exitRoom == false){
            char userInput =  visitor.getChoice(optionList,options);
            switch (userInput) {
                case 'a':
                    exitRoom = optionA(visitor,chestUnlocked);
                    break;
                case 'b':
                    cupboardUnlocked = optionB(visitor,cupboardUnlocked,cupboardKey);
                    break;
                case 'c':
                    if(keyAquired == false){
                        boolean giveKey = visitor.giveItem(cupboardKey);
                        if(giveKey){
                            print("You have found a key. Maybe it could be used to unlock something");
                            keyAquired = true;
                        }
                    }
                    break;
                case 'd':
                    print("You check the piano and noticed one of the sheets of music have been ripped out. Where might it be?");
                    break;
                case 'e':
                    exitRoom = true;
                    break;
                default:
                    print("Please enter a valid option.");
            }
        }

        return Direction.TO_EAST;
    }

}
