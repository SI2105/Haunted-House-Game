package OOP.ec22612.MP.contributions;// Main framework class for A4.
import java.util.Scanner;

class Room_ec22846 extends Room { 

    public int askInt(String message){
        String answer = askString(message);
        return Integer.parseInt(answer);
    }
    public String askString(String message){
        final String answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        answer = scanner.nextLine();
        scanner.close();
        return answer;
    }

    public void  pr(String message){
        System.out.println(message);

    }
    

        public void intro(Visitor visitor){
            String startingMessage = "You enter into a room and there is a mysterious chest in the middle.";
            String startingMessage2 = "You look around and there doesnt seem to be anything else that catches you eye apart a looked door.";
            String startingMessage3 = "There is nothing else to note of in the room so you head back to the chest. "; 
            pr(startingMessage + "\n" + startingMessage2 + "\n" + startingMessage3);
            char[] yes_noQ = {'y','n'};
            String startingQuestion = "There is nothing to do; will you open the chest?(y/n)";
            
            boolean hasItem = false;
            Item sword = new Item("sword");
            Item fists = new Item("Fists");
            char userInput = visitor.getChoice(startingQuestion,yes_noQ);
            
            boolean flag = false;
            while (flag == false){
                if (userInput == 'n'){
                    flag = true;
                    String startingMessage4 = "True, that chest was sus asf. Probably shouldnt open it.(Forboding music starts playing)";
                    hasItem = visitor.giveItem(fists);
                    if (hasItem == true){
                        pr(startingMessage4);
                    }

                    
                }
                else if (userInput == 'y'){
                    flag = true;
                    String startingMessage5 ="Congrat !!! You opened the first chest :D and received a prize";
                    hasItem = visitor.giveItem(sword);
                    if (hasItem == true){
                        pr(startingMessage5);
                    }
                    visitor.giveGold(10);


                }
                else{
                    flag = false;
                    String checkInput = "Please enter a valid input(y/n)";
                    userInput = visitor.getChoice(checkInput, yes_noQ);
                }
            
            
            }

        }


        public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
            
            intro(visitor);

            
            
            return Direction.FROM_EAST;
        }
}
