package OOP.ec22612.MP.contributions;

import java.util.Scanner;

class Room_ec221099 extends Room{
    //print method
    public void print(String message){
        System.out.println(message);
    }
    //inputString method
    public static String inputString (String message)
    {
    // make a scanner to get input from user
        String answer;
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        answer = scanner.nextLine();
        scanner.close();

        return answer;
    }
    

    public void enterRoom(Visitor visitor){
        //item created
        Item AncientChestKey = new Item("AncientChestKey");
        //initiating variables
        boolean HasKey = false;
        char pickupKey = ' ';
        //enter room message
        print("You Enter a Plane White Room /n <ERROR 101:: Texture not found>");
        //Event Message 1
        char options[] = {'y','n'};
        pickupKey = visitor.getChoice("You Notice a Key, Would You Like to Pick it up?" , options);
        //sequence to pickup the key
        if(pickupKey == 'y'){
            //gives item
            HasKey = visitor.giveItem(AncientChestKey);
        }else if(pickupKey == 'n'){
            //skips item
            print("You Decide to Leave the VERY IMPORTANT Key on the Floor, Good Luck!");
            HasKey = false;
        }
        Item TIMMY_REPELLENT = new Item("TIMMY REPELLENT");
        //Event Message 2
        print("You Notice a Chest Conveniently Positioned in the Centre of The Room");
        print("If Only You Had a Key to Somehow Open this Conveniently Placed Chest (Which May or May Not Contain an Important Item.)");
        //sequence to open chest
        boolean HasRepellent = false;
        if(HasKey = true){
            print("You Unlock The Chest");
            print("You Fine a Spray Can labelled: 'TIMMY REPELLENT'");
            visitor.giveItem(TIMMY_REPELLENT);
            HasRepellent = true;
            print("You also Find 10 Gold Coins, (coz why not)");
            visitor.giveGold(10);
        }else if(HasKey = false){
            print("Such a Shame You Don't Have THAT Key From Earlier");
            HasRepellent = false;
        }
        
        //sequence TIMMY encounter
        boolean TimmyAlive = true;
        print("You Hear a Ominous Sound of Wheels Sqeaking, Moving in Your Direction");
        print("A Small Rectangular Silhouette Emerges");
        //initial HP
        int TimmyHP = 100;
        int playerHP = 10;
        //TIMMY speaks:
        print("... : TIMMY!! *It Squeals*");
        print("*You Have Been Challenged by TIMMY*");
        print("Your HP: " + playerHP + "TIMMY's HP: " + TimmyHP);
        //Fight Begins
        print("If You Only Had Some Sort of Repellent You Could Dispose of TIMMY Instantly");
        if(HasRepellent = false){
            //Your Turn
            print("Shame You're Missing that Important Item from Earlier");
            print("Your Eye Contact Inflicts 10 Damage By Scaring TIMMY");
            print("*TIMMY Takes 10 DMG*");
            //updated HP
            TimmyHP = TimmyHP - 10;
            print("Your HP: " + playerHP + "TIMMY's HP: " + TimmyHP);
            //TIMMY's Turn
            print("TIMMY Almost Kills you With his Bike");
            playerHP = playerHP - 9;
            print("Your HP: " + playerHP + "TIMMY's HP: " + TimmyHP);
            print("You Manage to Escape But Lose 10 Gold in the Process");
            visitor.takeGold(10);
            //fail ending
            TimmyAlive = true;
            //leave room

        }else if(HasRepellent = true){
            //TIMMY insta-kill
            print("You Back Out The 'TIMMY REPELLENT' and Spray it on Him");
            print("*TIMMY Screams and Scirmishes Away*");
            print("You Win!");
            TimmyAlive = false;
        }

        //sequence to leave
        char leaveRoom = ' ';
        if(TimmyAlive = false){
            //Event Message 3
            print("It Appears You Have Nothing Left to do in This Room.");
            leaveRoom = visitor.getChoice("Would You like to Leave?" , options);
            if(leaveRoom == 'y'){
                print("You Leave the Room a Hero");
                //leaves room
            }else if(leaveRoom == 'n'){
                print("You go Back to Look at TIMMY's Corpse");
                print("You go Through TIMMY's Pockets and find an additional 10 Gold");
                visitor.giveGold(10);
                //leaves room
            }
        }
    }
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
        enterRoom(visitor);
        return Direction.FROM_EAST;
    }

}