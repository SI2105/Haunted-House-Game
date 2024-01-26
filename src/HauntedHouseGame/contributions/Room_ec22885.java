package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_ec22885 extends Room
{
    //initial instance variable state for the room//
    static String wardrobe = "unopened";
    static String rug = "unturned";

    //visit method that takes in 2 arguements and returns user's new direction//
    public Direction visit(Visitor person, Direction visitFrom)
    {
          Scanner scanner = new Scanner(System.in);
          Room_ec22885 roomState = new Room_ec22885();
          
          //inform user about state of room//
          person.tell("The lights are on in this room, with an " + roomState.wardrobe + " rustic wardrobe at the back.");
          person.tell("There is also a dingy " + roomState.rug + " rug on the floor.");
          
          //if statement interaction depending on if user has been in the room before//
          char[] options = {'Y','y','N','n'};
          char visChoice1 = person.getChoice("Tell me visitor, have you been here before? Y/N: ",options);
          if ((visChoice1 == ('Y'|'y')) & (roomState.wardrobe.equals("opened")) & (roomState.rug.equals("turned")))
          {
              person.tell("No point being here again then, the wardrobe is already empty and the rug is turned.");
          }
          
          if ((roomState.wardrobe.equals("unopened")))
          {
              //if statement which either gives the user 4 pieces of gold and changes the state of the wardrobe or gives nothing//
              char visChoice2 = person.getChoice("Do you want to look inside the wardrobe? Y/N: ",options);
              if (visChoice2 == ('Y'|'y'))
              {
                  person.tell("You walk close to the wardrobe and pull the doors open.");
                  person.tell("Upon opening it, you find and take 4 pieces of gold!");
                  person.giveGold(4);
                  roomState.wardrobe = "opened";
              }
              else
              {
                  person.tell("Hope you don't regret that decision...");
              }
          }
          
          if ((roomState.rug.equals("unturned")))
          {
              //if statement which either gives the user 1 piece of gold and changes the state of the rug or gives nothing//
              char visChoice3 = person.getChoice("Do you want to turn over the rug? Y/N: ",options);
              if (visChoice3 == ('Y'|'y'))
              {
                  person.tell("You approach the rug, overcome with the stench.");
                  person.tell("You turn it over regardless and get 1 piece of gold!");
                  person.giveGold(1);
                  roomState.rug = "turned";
              }
              else
              {
                  person.tell("Unable to look past the rugs appearance, you look away.");
              }
          }
          person.tell("Time to leave...");
          Direction visitLeave = Direction.opposite(visitFrom);
          
          return visitLeave;
    }
}
