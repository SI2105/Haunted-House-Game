package OOP.ec22612.MP.contributions;

class Room_ec22779 extends Room
{
      

  public Direction visit(Visitor vis, Direction dir)
  {

    final Item Key = new Item("Key");
    vis.tell("Welcome to the House of the Rising Sun!");
    vis.tell("In order to gain entry, you need to donate one gold coin to the The Animals band.");
    vis.takeGold(1);
    //One gold coin is taken away.

    vis.tell("Now it's time to go Down In New Orleans in the house of the Rising Sun!");
    String UserOption = ("Would you like to a) Go upstairs to the bedroom b) Go downstairs to the basement c) Go left to the living room or d) Go right to the kitchen?");
    char[] Choice = {'a', 'b', 'c', 'd'};
    //Allows uer to select which room to go into.

    char UserSelect = vis.getChoice(UserOption, Choice);

    if(UserSelect == 'a')
    {
      vis.tell("You have gone upstairs but you enter into the bedroom and someone is sleeping! You lose 2 gold coins for being rude :(.");
      vis.takeGold(2);
      //If user selects a, they have 2 gold coind taken away.
    }

    else if(UserSelect == 'b')
    {
      vis.tell("You have decided to go downstairs to the basement. Unfortunately, you are slip and fall. Because you are in New Orleans, you have to pay for your medical bills, which will cost you dearly :(.");
      vis.takeGold(8);
      //If user selects b, they have 8 gold coins taken away.
    }
    else if(UserSelect == 'c')
    {
      vis.tell("You have gone into the living room and you see your father gambling, because he was a gamblin' man dow in New Orleans, he asks for some money from you which he loses :(.");
      vis.takeGold(5);
      //If user selects c, they have 5 gold coins taken away.
    }
    else if(UserSelect == 'd')
    {
      vis.tell("You go into the kitchen and you see your mother sewing your new blue jeans. The jeans are amazing and you thank her for being the best mother ever. She then gives you $8 to buy sweets with. She also gives you a key, so you can always come back to the House of the Rising Sun! :).");
      vis.giveItem(Key);
      vis.giveGold(8);
      //If user selects d, they have 8 gold coins given to them.
    }
    vis.tell("Thank you for visiting this house in New Orleans they call the Rising Sun!");
    vis.tell("Even though it's been the ruin of many a poor boy.");
    vis.tell("And God, you know your wanna them.");
    vis.tell("You've enjoyed your time in the House of the Rising Sun! :)");

    return dir;
    }
}
