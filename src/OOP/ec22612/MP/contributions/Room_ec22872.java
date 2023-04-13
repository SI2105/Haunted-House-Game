package OOP.ec22612.MP.contributions;

class Room_ec22872 extends Room{
    Visitor guest;
    Direction d;
    boolean watch_access;
    public Direction visit(Visitor visitor, Direction Direction_came_from){
        guest = visitor;
        d = Direction_came_from;
        char[] choice = new char[2];
        int items_given = 0;
        choice[0]= 'a';
        choice[1] = 'b';
        Item candle = new Item("candle");
        Item watch = new Item("Watch");
        Item doll = new Item("doll");
        
        
        //if(d.equals(Direction.FROM_SOUTH))
        //{
            guest.tell("You have entered from the southern entrance");
            
            if(guest.hasIdenticalItem(candle) == true || guest.hasEqualItem(candle) == true)
            {
                
            }
            else{
                guest.tell("There is a lit candle to your left.");
                guest.tell("Do you wish to take the item? (remember you can only take one item per visit)");
                if(guest.giveItem(candle) == true){
                    guest.tell("You have accepted the candle");
                    items_given = 1;
                }
                else{
                    guest.tell("you have left the candle behind.");
                }
            }
            
        //}
        guest.tell("you walk towards the centre of the room.");
        guest.tell("You notice that there is a chest in the middle of the room");
        char search_chest = guest.getChoice("Do you wish to open the chest? a) yes b) no", choice);
        if(search_chest == 'a')
        {
            guest.tell("You open the chest to see that it is empty.");
            if(guest.hasIdenticalItem(candle) == true || guest.hasEqualItem(candle) == true)
            {
                guest.tell("Using your lit candle you examine the inside of the chest and ignite the cobwebs that were seemingly inside the chest");
                guest.tell("This reveals a layer below the cobwebs and you see some gold coins.");
                guest.tell("Excited you retrieve the 3 coins");
                guest.giveGold(3);

            }
            else{
                guest.tell("You feel like that can't be all there is to this chest but you feel uneasy with sticking your hand inside the chest");
                guest.tell("You decide to brave it and to get over your nerves you shove your hand into the chest");
                guest.tell("You feel 3 gold coins and rejoice in joy");
                guest.tell("A spider suddenly bites your hand and you pull your hand out and drop the coins back in the chest");
                guest.tell("You decide it is not safe as you are not sure how many spiders are in the chest and close the chest hoping that they haven't left the chest yet");
            }
        }
        else if(search_chest == 'b')
        {
            guest.tell("You ignore the chest despite feeling like something good may be inside");

        }

        guest.tell("You move towards the Western door");
        guest.tell("You see a wardrobe on your way out thinking that you may have to come back to that");
        char search_wardrobe = guest.getChoice("Would you like to to search the wardrobe", choice);
        if(search_wardrobe == 'a')
        {
            guest.tell("You find nothing in the top shelf");
            guest.tell("You find nothing in the middle shelf");
            guest.tell("You hold your breath as you felt that there should be something special in the last drawer");
            guest.tell("You open the bottom drawer and find a gumbball machine");
            char gumbball_choice = guest.getChoice("Do you wish to insert 2 gold coins? a) yes b) no", choice);
            if(gumbball_choice == 'a')
            {
                if(items_given == 1){
                char confirm = guest.getChoice("You have already taken an item from the room do you still wish to insert the coins", choice);
                if(confirm == 'a')
                {
                    guest.tell("You insert two gold coins into the machine");
                    guest.tell("You receive a watch pop out of gumbball machine");
                    guest.takeGold(2);
                    guest.tell("You must leave the watch behind");
                    watch_access = true;
                }
                }
                else{
                    guest.tell("You insert two gold coins into the machine");
                    guest.tell("You receive a watch pop out of gumbball machine");
                    guest.takeGold(2);
                    guest.tell("You take the watch");
                    guest.giveItem(watch);
                    items_given =1;
                }
            }
            else{

            }
        }
        else{

        }
        guest.tell("On the mirror on top of the wardrobe you notice that there is a doll staring at you from across the room");
        guest.tell("You go towards the doll and look at it ");
        guest.tell("It gives you the creeps.");
        if(items_given == 0)
        {
            char doll_choice = guest.getChoice("Do you wish to take the doll? a) yes? b) no?", choice);
            if(doll_choice=='a')
            {
                guest.giveItem(doll);
            }
            else{}
        }
        else
        {
            guest.tell("You move on and decide that if you do need to take it that you will come back another time");
        }

        guest.tell("Which direction would you like to leave the room in?");
        char[] leaving_choice = new char[4];
        leaving_choice[0] = 'a';
        leaving_choice[1] = 'b';
        leaving_choice[2] = 'c';
        leaving_choice[3] = 'd';
        char leaving_direction = guest.getChoice("a) north? b) east? c) south? d) west?", leaving_choice);
        Direction leave = Direction_came_from;
        if(leaving_direction == 'a')
        {
            leave = Direction.TO_NORTH;
        }
        else if(leaving_direction == 'b')
        {
            leave = Direction.TO_EAST;
        }
        else if(leaving_direction == 'c')
        {
            leave = Direction.TO_SOUTH;
        }
        else if(leaving_direction == 'd')
        {
            leave = Direction.TO_WEST;
        }
        return leave;
    }
}


    
