package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

public class Room_ec22763 extends Room{
  private String locationName;
  private String description;
  private int currentGold;
  private boolean lightsOn;
  private String choices = "What do you want to do?\n1. Turn on the lights\n2. Turn on the lights\n3. Take gold\n4.Search for goods\n5. Leave";
  private int numOfItemsFound;
  static Item key = new Item("Key");
  
  public Room_ec22763(){
    locationName = "Abandoned bedroom";
    description = "You enter the bedroom, running your fingers against the walls. Light shines through the holes in the cutrains, revealing particles of dust flying around the room almost as if it were happy to see you. The bedroom contains a double bed, a small wardrobe and two nightstands.";
    currentGold = 10;
    lightsOn = false;
    numOfItemsFound = 0;
  }
  
  public int getChoice(int[] possibleChoicesArray){
    Scanner scanner = new Scanner(System.in);
    Boolean validOption = false;
    
    int option = Integer.parseInt(scanner.nextLine());
    
    while(validOption = false){
      for(int count = 0; count < possibleChoicesArray.length; count++){
        if(option == possibleChoicesArray[count]){
          validOption = true;
        }
      }
      
      System.out.println("This choice is invalid. Enter a valid answer.");
      System.out.println(choices);  
      option = Integer.parseInt(scanner.nextLine());
    }
    
    return option;
  }
  
  public void giveGold(Visitor v, int numberReceived){
    currentGold += numberReceived;
    v.tell("You have received " +numberReceived+" pieces of gold.");
  }
  
  public void takeGold(Visitor v, int numberTaken){
    currentGold -= numberTaken;
    v.tell("You have lost " +numberTaken+" pieces of gold.");
  }
  
  public void provideInfo(Visitor v){
    v.tell("You are currently in the "+locationName+".");
    v.tell(description);
    
    if(lightsOn){
      v.tell("The lights are on.");
    }
    
    else{
      v.tell("The lights are off.");
    }
    
    v.tell("Unfortunately you lost some pieces of gold as you have visited this room.");
    
    Random random = new Random();
    int goldLost = random.nextInt(10);
    takeGold(v, goldLost);
    
    v.tell("You currently have "+currentGold+" pieces of gold.");
  }
  
  public Direction visit(Visitor v, Direction d){
    provideInfo(v);
    
    v.tell(choices);
    
    int[] possibleChoices = {1, 2, 3, 4, 5};
    int choice = getChoice(possibleChoices);
    
    while(choice != 5){
      if(choice ==1){
        if(lightsOn = false){
          v.tell("You turned the lights on.");
          lightsOn=true;
        }
        else{
          v.tell("Lights are already on.");
        }
      }
      
      else if(choice==2){
        if(lightsOn = true){
          v.tell("You turned the lights off.");
          lightsOn=false;
        }
        else{
          v.tell("Lights are already off.");
        }
      }
      
      else if(choice==3){
        if(lightsOn = true){
          Random random = new Random();
          int goldObtained = random.nextInt(10);
          giveGold(v, goldObtained);
        }
        
        else{
          v.tell("You tried to take the gold, but its too dark, you cant see anything!");
        }
      }
      
      else{
        if(lightsOn = true){
          v.giveItem(key);
        }
        
        else{
          v.tell("You tried to search the room, but its too dark, you cant see anything!");
        }
      }
      v.tell(choices);
    }
    v.tell("Goodbye!");
    return Direction.opposite(d);
  } 
}
