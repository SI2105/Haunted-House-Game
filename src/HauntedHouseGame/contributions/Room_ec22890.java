package HauntedHouseGame.contributions;

class Room_ec22890 extends Room{


    public Direction visit(Visitor v, Direction d){

        char[] possible_choices = {'a','b','c'};
        char[] possible_choices2 = {'a','b'};
        v.tell("Welcome To My House");
        Item key = new Item("key");

        v.tell("Look around the house and find items");
        v.tell("You can also collect some gold along the way");
        v.tell("Be carefull with what you choose:");

        char user_choice = v.getChoice("(a. Look in the chest) or (b. look under the bed) or (c. Try open the door)", possible_choices);
        
        if (user_choice == 'a'){
            
            v.tell("You walk towards the chest and kneel to take a better look");
            v.tell("You open the chest and take a better look and find");

            if(v.hasIdenticalItem(key) || v.hasEqualItem(key)){
                int gold_lost = v.takeGold(3);
                v.tell("Unfortunatly you have lost " + gold_lost + " gold");
                v.tell("You now proceed to the door and leave");
            }

            else{
                v.giveGold(10);
                v.tell("You have found a key and earn more gold");
                v.giveItem(key);
            }
            
            v.tell("Now where do you want to go to now");
            char user_choice2 = v.getChoice("(a. look under the bed) or (b. Try open the door)", possible_choices2);
            
            if (user_choice == 'a'){
                v.tell("You look under the bed");
                v.tell("You walk towards the bed and look underneath the bed");
                v.tell("You light a flashlight to see better");

                if(v.hasIdenticalItem(key) || v.hasEqualItem(key)){
                    int gold_lost = v.takeGold(3);
                    v.tell("Unfortunatly you have lost as you already have a key " + gold_lost + " gold");
                    v.tell("You now proceed to the door and leave having lost gold");
                }
            
                else{
                    v.giveGold(10);
                    v.giveItem(key);
                    v.tell("You have found a key and earn more gold");
                    v.tell("You can unlock the door and leave peacefully");
                    v.tell("You proceed to leave and earned 10 gold today");
                }
            }
            
            if (user_choice == 'c'){
                v.tell("You walk towards the door");

                if(v.hasIdenticalItem(key) || v.hasEqualItem(key)){
                    v.tell("You put the key into the lock and twist it");
                    v.tell("You open the door and escape with earning more gold");
                }

                else{
                    v.tell("You dont have the key and the door is locked");
                    int gold_lost = v.takeGold(5);
                    v.tell("The door opens but you have lost " + gold_lost + " gold");
                }
            }
            
        }

        else if (user_choice == 'b'){
            v.tell("You look under the bed");
            v.tell("You walk towards the bed and look underneath the bed");
            v.tell("You light a flashlight to see better");

            if(v.hasIdenticalItem(key) || v.hasEqualItem(key)){
                int gold_lost = v.takeGold(3);
                v.tell("Unfortunatly you have lost as you already have a key " + gold_lost + " gold");
                v.tell("You now proceed to the door and leave having lost gold");
            }
            
            else{
                v.giveGold(10);
                v.giveItem(key);
                v.tell("You have found a key and earn more gold");
                v.tell("You can unlock the door and leave peacefully");
                v.tell("You proceed to leave and earned 10 gold today");
            }
        }

        else if (user_choice == 'c'){
            v.tell("You walk towards the door");

            if(v.hasIdenticalItem(key) || v.hasEqualItem(key)){
                v.tell("You put the key into the lock and twist it");
                v.tell("You open the door and escape with earning more gold");
            }

            else{
                v.tell("You dont have the key and the door is locked");
                int gold_lost = v.takeGold(5);
                v.tell("The door opens but you have lost " + gold_lost + " gold");
            }
            
            
        }
        
        return d;
    }
}
