package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22842 extends Room implements Visitable{
    Item Rev = new Item("Rev Bank Card");
    Item Yapi = new Item("Yapi Bank Card");
    Item Credit = new Item("Credit Bank Card");
        
    private char [] arr = {'a', 'b', 'c', 'd'};
    private String password = "ILoveOOP";
    private boolean accept = false;
    private boolean hasBankCard = false;
    private boolean leave = false;
    private String bank = "";
    private String mailsuffix = "@burakcompany.com";
    private boolean storeSta = false;
    
    public Direction visit(Visitor v, Direction d){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        v.tell("Hello welcome to the office department of bank services. You are " + d + "\nPlease enter your full name :");
        String fullname = scanner.nextLine();
        String name = fullname.replaceAll(" ", ""); 
        char choice = 'e';
        int randomNumber;
        int round = 0;
        
        
        while(!hasBankCard){
            v.tell("You can choose between different type of bank cards. Each bank cards give you multiple advantages.\nRevolut offers 20 coins free for each new subscriber. \nCredit Mutuel gives you the possibility to pay everywhere feeless but has a 20 coin card fee. \nYapiKredi gives you a metal card.");
            System.out.println();
            choice = v.getChoice("Which bank card do you want ?\n Press (a) for Revolut\n Press (b) for YapiKredi\n Press (c) for Credit Mutuel", arr);
            
            if(choice == 'a'){
                accept = v.giveItem(Rev);
                if(accept == true){
                    v.tell("\nCongratulations for choosing your new Revolut Bank Card");
                    v.giveGold(20);
                    bank = "Revolut";
                    hasBankCard = true;
                }    
                if(accept == false)v.tell("Please take your time to choose.");
            }
             if(choice == 'b'){
                accept = v.giveItem(Yapi);
                if(accept == true){
                    v.tell("\nCongratulations for choosing your new YapiKredi Bank Card");
                    v.takeGold(20);
                    bank = "YapiKredi";
                    hasBankCard = true;
                }    
                if(accept == false)v.tell("Please take your time to choose.");
            }
             if(choice == 'c'){
                accept = v.giveItem(Credit);
                if(accept == true)
                    v.tell("\nCongratulations for choosing your new Credit Mutuel Metallic Bank Card");
                    bank = "Credit Mutuel";
                    hasBankCard = true;
                }
                if(accept == false)v.tell("Please take your time to choose.");
            }
          while(!leave){
              String mail = "";
              String parola = "";
              int number = 0;
             char action = v.getChoice("\nNow that you have your first bank card, what do you want to do?\nPress (a) to withdraw money\nPress (b) to take a credit\nPress (c) to participate to a draw \nPress (d) to leave the place.", arr);
    
                if(action == 'a'){
                    v.tell("How much do you want to withdraw from your sold ?\nEnter the amount: ");
                    number = scanner.nextInt();
                    v.takeGold(number);
                }else if(action == 'b'){
                    v.tell("How much coin do you want to insert to your sold ?\nEnter the amount: ");
                    number = scanner.nextInt();
                    v.giveGold(number);
                }else if(action == 'c'){
                    v.tell("You are participating to Room_ec22842's draw !!!");
                    v.tell("3 people are participating into this draw");
                    v.tell("As I can see, your full name is : " + fullname + "And I can see that you are registered in the following Bank : " + bank);
                    v.tell("Here is your personalized address e-mail : " + name.toLowerCase() + mailsuffix + " and your password is :" + password + "\nThe results of the draw has been sent to your email.");
                        v.tell("Enter your email address :");
                        mail = scanner.nextLine();
                        v.tell("Enter your password : ");
                        parola = scanner.nextLine();
                        if(mail.equals((name.toLowerCase() + mailsuffix)) && parola.equals(password)){
                            randomNumber = random.nextInt((3 - 1) + 1) + 1;
                            if(randomNumber == 1){
                                v.giveGold(850000);
                            }else{
                                v.tell("You have not won the draw");
                            }
                        }
                }else if (action == 'd'){
                    leave = true;
                }
            }
        return d.TO_NORTH;
        }
    }
