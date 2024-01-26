package HauntedHouseGame.contributions;

class Room_ec22940 extends Room {
    static final Item Key = new Item("Key");
    static final Item Gun = new Item("Gun");

    public Direction visit(Visitor visitor, Direction direction){

        String arrivingDirection = "";
        String leavingDirection = "";
        Direction oppositeDirection =  direction.opposite(direction);

        if(direction == Direction.FROM_NORTH){
            arrivingDirection = "North";
        }
        if(direction == Direction.FROM_EAST){
            arrivingDirection = "East";
        }
        if(direction == Direction.FROM_SOUTH){
            arrivingDirection = "South";
        }
        if(direction == Direction.FROM_WEST){
            arrivingDirection = "West";
        }

        if(oppositeDirection == Direction.TO_NORTH){
            leavingDirection = "North";
        }
        if(oppositeDirection == Direction.TO_EAST){
            leavingDirection = "East";
        }
        if(oppositeDirection == Direction.TO_SOUTH){
            leavingDirection = "South";
        }
        if(oppositeDirection == Direction.TO_WEST){
            leavingDirection = "West";
        }

        char[] choices = {'a', 'b', 'c', 'd'};

        visitor.tell("A random Visitor has appeared from the " + arrivingDirection);
        visitor.tell("Welcome to the haunted house");

        char option = visitor.getChoice("Choice a) Get a gun\n" +
                "Choice b) Shoot the Ghost\n" +
                "Choice c) Ask Ghost for mercy\n" +
                "Choice d) Try to Scare the Ghost\n",choices);

        if(option == choices[0]){
            visitor.giveItem(Gun);
            visitor.tell("You have obtained a Gun");
            option = visitor.getChoice(
                    "Choice b) Shoot the Ghost\n" +
                    "Choice c) Ask Ghost for mercy\n" +
                    "Choice d) Try to Scare the Ghost\n",choices);

        }
        if(option == choices[1]){
            if(visitor.hasEqualItem(Gun)){
                visitor.giveItem(Key);
                visitor.giveGold(10);
                visitor.tell("You killed the ghost! You have gained the key to escape the room");
                visitor.tell("The Visitor has successfully escaped. He is heading to the " + leavingDirection);
            }
            else{
                visitor.takeGold(5);
                visitor.tell("You do not have a Gun. The Ghost has stolen gold from you!!!");
                visitor.tell("You will have another chance");
                option = visitor.getChoice("Choice a) Get a gun\n" +
                        "Choice b) Shoot the Ghost\n" +
                        "Choice c) Ask Ghost for mercy\n" +
                        "Choice d) Try to Scare the Ghost\n",choices);
            }
        }

        if(option == choices[2]){
            if(visitor.hasEqualItem(Gun)){
                visitor.tell("You have a Gun. The Ghost will show no mercy");
                visitor.tell("Ghost trapped you. You will be stuck here forever");
            }
            else{
                visitor.tell("the Ghost has shown you mercy. He has given you the key to escape");
                visitor.tell("The Visitor has successfully escaped. He is heading to the " + leavingDirection);
            }
        }
        if(option == choices[3]){
            if(visitor.hasEqualItem(Gun)){
                visitor.tell("You have a Gun. The Ghost is scared. He has given you the key");
                visitor.tell("The Visitor has successfully escaped. He is heading to the " + leavingDirection);

            }
            else{
                visitor.tell("The Ghost is not scared from you. The Ghost is very angry");
                visitor.takeGold(10);
            }

        }



        return direction.opposite(direction);
    }
}
