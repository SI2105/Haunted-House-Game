package HauntedHouseGame.contributions;

class Room_ec221014 extends Room {//class start
    //updated
    
    static final Item gun = new Item("gun");
    boolean morpheusAlive = true;
  
    public Direction visit(Visitor m, Direction entrance){//visit start
        if (morpheusAlive == true){//if 1 start
        
            m.tell("The Matrix");
            m.tell("is everywhere, it's all around us, here even in this room. You can see it out your window, or on your television.  You feel it when you go to work, or go to church or pay your taxes.  It is the world that has been pulled over your eyes to blind you from the truth.");
            m.tell("This is your last chance.  After this, there is no going back.");
            m.tell("You take the blue door ahead you and the story ends.  You wake in your bed and you believe whatever you want to believe.");
            m.tell("You take the red door behind you and you stay in Wonderland and I show you how deep the rabbit-hole goes.");

          
           

            char choiceSelected  = m.getChoice("Press (a) to go ahead or Press (b) to go back or Press(c) to go rogue",new char[]{'a','b','c'});
            if (choiceSelected == 'a'){//if 2 start
                return Direction.TO_NORTH;
            }//if 2 end
            else if (choiceSelected == 'b'){//else if 1 start

                return Direction.TO_SOUTH;
            }//if else 1 end
            else if (choiceSelected == 'c'){//else if 2 start
                if (m.hasEqualItem(gun)){//if 3 start
                    m.tell("You shot Morpheus!! Run!");
                    morpheusAlive = false;
                }// if 3 end
                else 
                {// else 1 start
                    m.giveItem(gun);
                    m.tell("You shot Morpheus!! Run!");
                    morpheusAlive = false;
                }// else 1 end
            }//else if 2 end
        }//if 1 end
        else if (morpheusAlive == false){//else if 3 start
            m.tell("Morpheus is dead. Run!!");
            return Direction.opposite(entrance);
        }// else if 3 end
        return Direction.opposite(entrance);
    }//visit end

}//class end
