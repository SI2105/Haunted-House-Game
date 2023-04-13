package OOP.ec22612.MP.contributions;// code adapted from ec22825

class Room_ec22802 extends Room{

        private boolean doorOpen = true;
        private boolean drawerOpen = true;
        private boolean curtainClosed = true;
        private Item rope = new Item("rope");
        private int Gold = 20;


         public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom)
         {
             visitor.tell("Welcome to my Room. It is \n door open: " + doorOpen + " \n drawer open: " + drawerOpen + " \n curtain closed: " + curtainClosed);

             if(!visitor.hasIdenticalItem(rope))
             {
                 visitor.giveItem(rope);
                 Gold += visitor.takeGold(10);
             }

             String options = "Do you want to: a)Keep the door open  b) Keep the door closed";
             char opt[] = {'a' , 'b'};
             char choice = visitor.getChoice(options , opt);
             switch (choice)
             {
                 case 'a': doorOpen = true;
                 break;

                 case 'b': doorOpen = false;
                 break; 
             }
            return Direction.opposite(directionVisitorArrivesFrom);
         }
     }
