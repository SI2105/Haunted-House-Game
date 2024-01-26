package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_ec22515 extends Room {
    
    static final Item lightsaber = new Item("Lightsaber"); 
    
    
    public Direction visit(Visitor v, Direction d) {
         
        //interaction
        v.tell("Welcome to the Star Wars Room!");
        
        //give choice of GOLD or ITEM
        char[] choices = new char[2];
        choices[0] = 'a';
        choices[1] = 'b';
        char choice = getChoice("a - get credits \n b - get item", choices);
        
        if (choice == 'a') {
            giveGold(50);
        } else {
            giveItem(lightsaber);
        }
        
        v.tell("May the force be with you :)");
        
        //get opposite direction
        Direction leaveDirection = Direction.opposite(d);
        return leaveDirection;
        
    }
    
    //tell method
    public void tell(String s){
        System.out.println(s);
    }
    
    public char getChoice(String description, char[] choices) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        
        tell(description);
        
        
        System.out.println("Choose: ");
        System.out.println(choices[0] + " or " + choices[1]);
        String input = scanner.nextLine();
        choice = input.charAt(0);
        return choice;
        
    }
    
    public void giveGold(int gold) {
        tell("You are given " + gold + " gold credits!");
        return;
    }
    
    public void giveItem(Item item){
        tell("Here is the item: " + lightsaber.name + " - it is a space sword");
        return;
    }
    

}
