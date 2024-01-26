package HauntedHouseGame.contributions;

class Room_ec22952 extends Room{
    Boolean glasses_taken = false;
    Boolean Justins_basketball_returned = false;
    
    static final Item Ehimens_glasses = new Item("Ehimen's glasses");
        
    public Direction visit(Visitor vis, Direction dir){
        
        if (glasses_taken == true){
            char [] choices = {'a', 'b'};
            char option = vis.getChoice("Hi welcome to Justin's room. Have you seen Justin's basketball? (a)'Yes, I have it', (b)'nope'",choices);
            
            switch(option){
                case 'a':
                    vis.tell("That's perfect, leave it under the desk for a reward!");
                    return_ball(vis);
                    break;
                case 'b':
                    vis.tell("Ah darn. Well if you ever find it, bring it here for a reward!");
                    break;
            }
            
        }
        else{
            char [] choices = {'a', 'b'};
            char option = vis.getChoice("Hi welcome to Justin's room. Have you seen Justin's basketball? (a)'Yes, I have it', (b)'nope'",choices);
            
            switch(option){
                case 'a':
                    vis.tell("That's perfect, leave it under the desk for a reward!");
                    return_ball(vis);
                    break;
                case 'b':
                    vis.tell("Ah darn. Well if you ever find it, bring it here for a reward!");
                    break;
            }
            
            char take = vis.getChoice("Also, my friend Ehimen seemed to have left his glasses on my desk. Would you mind returning them to him? (a)'Yes of course!', (b)'No thank you'",choices);
            
            switch(take){
                case 'a':
                    vis.tell("Thank you friend! Take some gold for your kindness");
                    vis.giveItem(Ehimens_glasses);
                    vis.giveGold(3);
                    glasses_taken = true;
                    break;
                case 'b':
                    vis.tell("That's okay!");
                    break;
            }
        }
        
        Direction direc = Direction.opposite(dir);
        return direc;
    }
    
    void return_ball(Visitor vis){
        
        char [] choices = {'a', 'b'};
        char ans = vis.getChoice("What would you like to do? (a)Leave it here, (b)Keep it",choices);
        
        switch(ans){
            case 'a':
                if (vis.hasIdenticalItem(Room_ec22510.Justins_Basketball)){
                    vis.tell("Thank you so much! Take this:");
                    vis.giveGold(10);
                    Justins_basketball_returned = true;
                }
                else{
                    vis.tell("You lied... No reward received.");
                    vis.tell("I'll be taking this as compensation. *Takes two gold from visitor*");
                    vis.takeGold(2);
                }
                break;
            case 'b':
                vis.tell("A bit rude.");
                break;
    
        }
    }
}
