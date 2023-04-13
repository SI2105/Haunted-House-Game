package OOP.ec22612.MP.contributions;

class Room_ec22871 extends Room{
    public boolean musicOn=false;
    
    public Direction visit(Visitor vis, Direction d){
        vis.tell("Welcome to my cozy, magical room full of mysteries..:) You must be tired, take a seat!");
        
        if(musicOn==false){
            vis.tell("It's quiet. Would you like to turn the music on?");
        }
        else{
            vis.tell("The music's on. Currently playing: Kyoto by Phoebe Bridgers. Would you like to turn it off?");
        }
        
        char[] opt=new char[2];
        opt[0]='y';
        opt[1]='n';
        char ans=vis.getChoice("Turn the music on/off?",opt);
        
        if(ans=='y'&&musicOn==false){
            vis.tell("That's a great song! Here's some money.");
            vis.giveGold(7);
        }
        else if(ans=='y'&&musicOn==true){
            vis.tell("Hey, I liked that song! Here's your punishment.");
            vis.takeGold(4);
        }
        
        Item give=new Item("Knife");
        if(!vis.hasEqualItem(give)){
            vis.tell("Here's a gift that may help you in your adventures. Use with caution..");
            boolean response=vis.giveItem(give);
            if(!response){
                vis.tell("You ungrateful brat!");
            }
        }
        vis.tell("Thank you for stopping by.. have a safe journey, visitor!");
        Direction re=Direction.opposite(d);
        return re;
    }
}
