package HauntedHouseGame.contributions;

class Room_ec22943 extends Room
 {
     final char[] choiceOptions = {'1','2'};
     final Item ac = new Item("ac");
     final Item tv = new Item("tv");
     final Item windows = new Item("windows");

      boolean acOn = true;
      boolean windowOpen = true;
      boolean candleLit = true;

      public Direction visit(Visitor visitor, Direction d)
      {
         int options = 0;
         if (d == Direction.FROM_NORTH)
         {
             visitor.tell("You are located at the front door of the room");
         }    
         else if (d == Direction.FROM_WEST)
         {
             visitor.tell("You are located in front of the windows.");
         }
         else if (d == Direction.FROM_EAST)
         {
             visitor.tell("You are located next to the hidden entrance.");
         }
         else
         {
             visitor.tell("You are located on top the ceiling.");
         }
         visitor.tell("This is a bedroom");
          visitor.tell("Tv is on the wall to the left");
          visitor.tell("There's an AC to the right of the tv");
          visitor.tell("The windows are the right of the room on the wall");
          visitor.tell("Candle on the table in the center of the room");
          if (acOn)
          {
              visitor.tell("The room is very cold.");
             visitor.tell("To turn the ac off 5 gold coins will be taken.");
             options = visitor.getChoice("1. Turn ac off 2. Open windows", choiceOptions);
             if (options == 1)
             {
                 visitor.takeGold(5);
             }
             else
             {
                 visitor.tell("Window is now open. ");
             }
         }
         else if (windowOpen)
         {
             visitor.tell("Its very windy.");
             visitor.tell("To close the windows 5 gold coins will be taken.");
             options = visitor.getChoice("1. Close windows 2. turn on tv ", choiceOptions);
             if (options == 1)
             {
                 visitor.takeGold(5);
                 visitor.tell("The windows are now closed");
             }
             else
             {
                 visitor.tell("tv is now switched on");
                 visitor.tell("You have found 7 gold coins next to the tv, take them");
                  visitor.giveGold(7);
              }
          }
          else if (candleLit)
          {
                visitor.tell("Candle is lit on the table");
                visitor.tell("Turn the candle off for 5 gold coins");
                visitor.tell("If you don't turn off candle 3 gold cpins will be taken");
                options = visitor.getChoice("1. Turn off candle 2. Don't turn off candle", choiceOptions);
                if (options == 1 )
                {
                     visitor.giveGold(5);
                     visitor.tell("The candles have now been turned off,you have received 5 gold coins");
                }
                else
                {
                     visitor.takeGold(3);
                     visitor.tell("Candle is not turned off, 3 gold coins have been taken.");
                }
          } 
          else
          {
              visitor.tell("Window is closed, Ac is turned off and candle is lit ");
              options = visitor.getChoice("1. Entre room and search 2. Turn tv on. ", choiceOptions);
              if (options == 1)
              {
                 visitor.tell("You've found 3 gold coins, take them");
                 visitor.giveGold(3);
             }
             else 
             {
                 visitor.tell("tv is now switched on");
                 visitor.tell("You have found 2 gold coins next to the tv, take them");
                 visitor.giveGold(2);
             }
         }
         return d;
     }
 }
 
