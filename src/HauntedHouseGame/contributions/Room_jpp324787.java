package HauntedHouseGame.contributions;

class Room_jpp324787 extends Room{
    static final Item TorchLight=new Item("Torch");
    static final Item Key=new Item("Key");
    private boolean lightsState=false;
    public Direction visit(Visitor v, Direction d){
        if(d==Direction.FROM_SOUTH)
            v.tell("HEY there,welcome to my room,You entered from the South!!");
        else if(d==Direction.FROM_NORTH)
            v.tell("HEY there,welcome to my room,You entered from the North!!");
        else if(d==Direction.FROM_EAST)
            v.tell("HEY there,welcome to my room,You entered from the East!!");
        else if(d==Direction.FROM_WEST)
            v.tell("HEY there,welcome to my room,You entered from the West!!");
        else
            v.tell("Welcome to my Room, hope you will like it");
        if(lightsState)
            v.tell("Ohh it's dark out there,a bit scary ngl,you need to find a way to get out");
        else
            v.tell("lights on!!, easy peasy to get out, just grab the key");
        char[] choices={'t','k','l'};
        v.tell("Alright mate, let's spice it up");
        char choice=v.getChoice("pick a random character(t,k or g)",choices);
        switch(choice){
            case 't':
                v.tell("you now have a torch,limited battery,use it wisely");
                v.giveItem(TorchLight);
                v.giveGold(3);
                break;
            case'k':
                v.tell("congrats!!!, you found the key");
                v.giveItem(Key);
                v.giveGold(3);
                break;
            case 'l':
                v.tell("you leave the room immediately ,take care!!");
                return Direction.opposite(d);
        }
        if(v.hasIdenticalItem(Key)){
            v.tell("you've got the key,now just open the door and leave");
        }else{
            v.tell("ok, since you couldn't find the key,i'll let you leave but without the gold");
            v.tell("Cheers lad, needed that gold to survive the living crisis, bye for now!!");
        }
        //return the user to the opposite direction he came from
        return Direction.opposite(d);
    }
}
