package HauntedHouseGame.contributions;

class Room_ec22449  extends Room{
    
    public Direction visit(Visitor person ,Direction compass){
        char[] directionalArray =  {1,2,3,4};
    
        // You should first tell the visitor about the room and the state it is in
        person.tell("Wellcome to the ec22449 room. You are coming from "+compass);

        Item moneybags = new Item("gold moneybags ");

        if (person.hasIdenticalItem(moneybags)){
            person.giveGold(5);
        }

        char personChoice = person.getChoice("Choose the direction to leave my humble abode", directionalArray);
        switch (personChoice){
            case 1:
            compass = compass.TO_NORTH;
            break;
            case 2:
            compass = compass.TO_SOUTH;
            break;
            case 3:
            compass = compass.TO_WEST;
            break;
            case 4:
            compass = compass.TO_EAST;
            break;
        }
        return compass;

    }
}
