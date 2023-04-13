package OOP.ec22612.MP.contributions;

class Room_ec22671 extends Room{
    
    
   public Direction visit(Visitor v, Direction D)
   {
       
       v.tell("welcome to my luxury house!");
       v.tell("I love fashion and luxurious lifestyle. So, I am interested to see if you are the same or not.");
       v.tell("As I love expensive stuff I will be giving you gold depend on how nuch you impress me with your lifestyle and choices.");
       v.tell("So, before we start let me show you how generous I am by giving you 10 golds!");
       v.giveGold(10);
       
         
       char [] L = {'y', 'n'};
       String des = "would you want to turn the lights on? y)for yes and  n)for no";
       char light = v.getChoice(des, L);

          if (light == 'y')
          {
            
              v.tell("nice choice! now I can see your outfit."); 
              
              Item G = new Item("Gucci");
              Item B = new Item("Balenciaga");
              Item P = new Item("Prada");
              
              
              char[] F = {'G', 'B', 'P', 'n'};
              des = "I love your outfit! What brand is it? G)for Gucci  B)for Balenciaga  P)for Prada  and n)for none of them";
              char fit = v.getChoice(des, F);
              
              
              if (fit == 'G')
              {
                  v.giveItem(G);
              }
              
              else if(fit == 'B')
              {
                  v.giveItem(B);
              }
              
              else if(fit == 'P')
              {
                  v.giveItem(P);
              }
              
              
              
              if (v.hasEqualItem(G)) 
              {
                  v.tell("you are quite classy!");            
                  v.tell("I would give a solid 7 golds to a Gucci outfit.");
                  v.giveGold(7);
              }
               
              
              
              else if (v.hasEqualItem(B))
                
              {
                  v.tell("Fancy and expensive. But I don't support child abuse so may I have 5 golds to donate to a charity to help children?");
                  v.takeGold(5);
              }
              
              
              else if (v.hasEqualItem(P))
              { 
                  v.tell("Prada is my favoratie");
                  v.tell("10 out of 10");
                  v.giveGold(10);
              }
              
               
              else
              {
                  v.tell("You don't have to have luxury cloths on to be welcome in this house");
              }
         }
       
       
         else
         {
           v.tell("if you don't turn on the lights then how am I supposed to see you or your outfit and how are you supposed to see the house?");
         }
       
       
       
         char [] set = {'n', 'e', 's', 'w'};
         char answer = v.getChoice("So, what direction do you want to go next? n)for north  e)for east  s)for south  and w)for west", set);
       
       
         if (answer == 'n')
         {
           return Direction.TO_NORTH;
         }
       
         else if( answer == 's')
         {
           return Direction.TO_SOUTH;
         }
       
         else if (answer == 'w')
         {
           return Direction.TO_WEST;
         }
       
         else if (answer == 'e')
         {
           return Direction.TO_EAST;
         }
       
         else
         {
           v.tell("the direction you have chosen is not in the options. So, the direction is going to be north by default.");
           return Direction.TO_NORTH;
         }
   }
 }
