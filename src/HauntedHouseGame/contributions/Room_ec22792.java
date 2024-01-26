package HauntedHouseGame.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22792 extends Room{
    
    //visit a place
    public Direction visit(Visitor v, Direction d){
        int gold=0;
        boolean windowOpen= false;
        boolean ghosts= true;
        
        welcomeMsg();
        settings();
        gold= giveGold(gold, 5);
        
        if (!windowOpen) {
            char option= options();
            if (option=='a'){
            d=move(d);
            }
            else if (option=='b') {
                String name=itemChoice();
                v.giveItem(new Item(name));
            }
            else if (option== 'c') {
                gold= gold + goldMystery(gold);
            }
            else if (option== 'd') {
                surprise();
            }
            else if (option=='e'){
                gold= fight(gold);
                ghosts= false;
            }
            else {
                tell("Invalid option: you are banished!");
            }
        }
        
        else{
            ghosts=false;
            tell("The ghosts left through the window");
            tell("Not much to do around here");
            windowOpen= true;
        }
        
        tell("You have a total of " + gold + " gold");
        tell("Good bye. I shall see you soon. On the other side...");
        
        return d;
    }
    
    //Fight
    int fight(int gold){
        tell("Oh the Winchester ghosts are fighting again!");
        tell("Do me a favour and stop them");
        
        int health= 20;
        tell("The ghost's health is " + health);
        String name= ghost();
        tell("You are fighting " + name);
        char[] options= {'a','b','c'};
        char choice= getChoice("a) left hook b) kick c) do nothing?", options);
        
        while (health>=0){
            if (choice=='a') {
            tell("*punch noises*");
            health= changeHealth(health);
            gold= gold+2;
            }
            else if (choice=='b'){
                tell("*kicking noises*");
                health=changeHealth(health);
                gold=gold+1;
            }
            else if (choice =='c') {
                tell("No confrontation: fair enough");
            }
        }
        return gold;
    }
    
    //Change health
    int changeHealth(int health) {
        Random ran= new Random();
        int damage= ran.nextInt(21);
        health= health - damage;
        if (health<0) {
            health=0;
        }
        return health;
    }
    
    //Pick random ghost
    String ghost() {
        String name="";
        Random ran= new Random();
        int ghost= ran.nextInt(4);
        
        if (ghost==0) {
            name= "Sarah Winchester";
        }
        else if (ghost==1) {
            name = "Annie Pardee Winchester";
        }
        else if (ghost==2) {
            name= "William Wirt Winchester";
        }
        else {
            name= "Mother-in-law Winchester";
        }
        
        return name; 
    }
   
    //Surprise
    void surprise() {
        tell("Ooh we are taking quite the risk I see");
        tell("You are going to have to face a terribly hard challenge");
        tell("Almost comparable to Heracles' 12 labours");
        tell("...");
        tell("Your task is to find a friend and...");
        tell("Choose who is moving using WASD and who with the arrows");
        tell("And take a break. Here is the link");
        tell("https://www.coolmathgames.com/0-fireboy-and-water-girl-in-the-forest-temple");
        return;
    }
    
    //Gold mystery: take or give some?
    int goldMystery(int gold){
        int given=0;
        
        tell("Ooh adventerous I see");
        tell("Will you get gold, or lose it?");
        tell("If you can answer this question, you'll earn some gold.");
        tell("What was the prisoner number for Jean Valjean? (No hints here)");
        String ans= inputString();
        ans= ans.toLowerCase();
        
        if (ans.equals("24601")){
            tell("I see you have taste! Here is 10 gold");
            given=10;
        }
        else {
            tell("The answer is 24601");
            tell("Shame on you for not knowing *tsk*");
            tell("Leave this room and go watch/read/listen Les Miserables");
            tell("You lost 3 golds");
            given=-3;
        }
        
        return given;
    }
    
    
    //Give an item to the user
    String itemChoice(){
        tell("You have two options. Option a or b");
        tell("I am not going to tell you what they are. But I will give you hints");
        tell("Option A can be helpful (or not) for you or another thing here in this room.");
        tell("You probably need Option B");
        tell("...");
        
        char[] options= {'a', 'b'};
        char choice= getChoice("So which one will it be a or b?", options);
        String name="";
        
        if (choice=='a'){
            tell("You have just received *drum roll please* a cup of water!");
            tell("You can drink it or water those flowers in the corners");
            tell("I can assure you it is not poisoned... Or is it?");
            name="water";
        }
        else if (choice=='b'){
            tell("Here is a bar of soap: after your journey you need it!");
            tell("The first soap was made from heroes' ashes like the first monkey shot into space");
            name="soap";
        }
        else {
            tell("Incorrect choice");
            itemChoice();
        }
        return name;
    }
    
    //Give user options for actions
    char options() {
        char[] options={'a', 'b', 'c', 'd', 'e'};
        tell("Choose your options");
        String msg="a) move b) get an item c) gold mystery d) surprise e) fight";
        char choice= getChoice(msg, options);
        return choice;
    }
    
    //Move user in the opposite direction they chose
    Direction move(Direction d){
        char [] options = {'n', 's', 'w', 'e'};
        Direction dir= d;
        
        String msg="Which directions do you want to go in: North, South, West, East?";
        char choice=getChoice(msg, options);
        
        if (choice=='n') {
            dir= d.TO_SOUTH;
        }
        else if (choice=='s'){
            dir= d.TO_NORTH;
        }
        else if (choice=='w'){
            dir= d.TO_EAST;
        }
        else if (choice=='e'){
            dir= d.TO_WEST;
        }
        else {
            tell("Incorrect option");
            move(d);
        }
   
        return dir;
        
    }
    
    //Tell the user something
    void tell(String s) {
        System.out.println(s);
        return;
    }
    
    //Get the user's choice
    char getChoice(String choice, char [] options){

        System.out.println(choice + " " + options);
        String uChoice = inputString();
        uChoice= uChoice.toLowerCase();
        char uChar= uChoice.charAt(0);
        
        return uChar;
    }
    
    //Describe settings
    void settings(){
        tell("You are in the relax room. Rest a bit");
        tell("There is a flower pot in the corner. They look a bit dead, don't they?");
        tell("Sorry about the awfully orange sheets and old furniture.");
        tell("Haunted houses have a standard to follow, you know?");
        tell("Sarah Winchester made sure of that...");
        tell("We got some detailed ceilings and chandeliers though");
        tell("I wonder if the Phantom would like them... Anyway");
        return;
    }
    //Welcome message
    void welcomeMsg () {
        
        String hello= "Welcome to room ec22792!";
        String welcome= "The room where we just want to rest after a good day's work";
        String goldGive= "Here are 5 golds as a reward for your hard work";
        tell(hello);
        tell(welcome);
        tell(goldGive);
        return;
    }
    
    //Give gold
    int giveGold( int newGold, int total){
        tell("You have received " + newGold + " gold");
        total= total+newGold;
        tell("You have " + total + " gold");
        return total;
    }
    
    //inputString
    String inputString() {
        Scanner sc= new Scanner(System.in);
        String ans= sc.nextLine();
        return ans;
    }
    
}
        
