package HauntedHouseGame.contributions;

import java.util.Random;

class Lights {

    private final boolean lightsOn; // includes natural lights
    private final int lightBrightness; // between 0 and 10
    private final boolean flashing;
    private final String onOff;

    public Lights(boolean flashing, boolean lightsOn, int lightBrightness) {
        if (!lightsOn) {
            this.lightBrightness = 0;
            onOff = "off";
        } else {
            if (lightBrightness < 1 || lightBrightness > 10) {
                throw new IllegalArgumentException("Brightness must be between 1 and 10");
            } else {
                this.lightBrightness = lightBrightness;
                this.onOff = "on";
            }
        }
        this.lightsOn = lightsOn;
        this.flashing = flashing;

    }

    @Override
    public String toString() {
        if (!flashing) {
            if (lightsOn) {
                return "The lights are on and the room is well lit, with a brightness level of " + lightBrightness;
            } else {
                return "It's dark in here, the lights are off";
            }
        } else {
            return "The lights are flashing, and the brightness is set to " + lightBrightness;
        }
    }
}


class Doors{
    String [] doorTypes;
    String [] doorColors;
    String [] doorDestinations;
    String [] doorDirections;
    public Doors(String [] doorTypes,String [] doorColors,String[] doorDestinations, String [] doorDirections){
        this.doorTypes=doorTypes;
        this.doorColors=doorColors;
        this.doorDestinations=doorDestinations;
        this.doorDirections=doorDirections;
    }

    @Override
    public String toString() {
        String helpText = "You are standing in a room with " + doorTypes.length + " doors. ";

        for (int i = 0; i < doorTypes.length; i++) {
            String doorType = doorTypes[i];
            String doorColor = doorColors[i];
            String doorDestination = doorDestinations[i];
            String doorDirection = doorDirections[i];

            helpText += "Door " + (i+1) + " is a " + doorColor + " " + doorType + " door that leads to " + doorDestination + " in the " + doorDirection + " direction. ";
        }

        helpText += "Which door would you like to take?";

        return helpText;
    }
    }

class WallsItems {
    String wallColor;

    Item item;//if no item pass null
    String itemColor;//if item==null it won't be saved
    String floorColor;


    public WallsItems(String wallColor, Item item, String itemColor, String floorColor)
    {
        this.wallColor=wallColor;

        if(!(itemColor.equals("None")||itemColor.equals("none"))) {
            this.item = item;
            this.itemColor=itemColor;
        }
        this.floorColor=floorColor;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The walls are painted ").append(wallColor).append(". ");
        if (item != null) {
            sb.append("There is a ").append(item.name).append(" hanging on the wall, and it has a ").append(itemColor).append(" color. ");
        } else {
            sb.append("There are no decorations on the wall. ");
        }
        sb.append("The floor is covered in a ").append(floorColor).append(" carpet. ");
        return sb.toString();
    }


}
class RoomDetails {
    private final Lights lights;
    private final Doors doors;
    private final WallsItems wallsItems;

    public RoomDetails(Lights lights, Doors doors, WallsItems wallsItems) {
        this.lights = lights;
        this.doors = doors;
        this.wallsItems = wallsItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lights.toString()).append("\n");
        sb.append(doors.toString()).append("\n");
        sb.append(wallsItems.toString());
        return sb.toString();
    }
}
class entrance extends Room{
    Lights light=new Lights(false, true,3);
    String [] doorTypes= new String[]{"wooden"};
    String [] doorColors=new String[]{"black"};
    String [] doorDestinations= new String[]{"the corridor"};
    String [] doordirections= new String[]{"north"};
    Doors doors=new Doors(doorTypes,doorColors,doorDestinations,doordirections);
    WallsItems wallsItems=new WallsItems("blue", new Item("None"),"None", "white");
    RoomDetails roomDetails= new RoomDetails(light,doors,wallsItems);
    final Direction[] allDirections = new Direction[]{Direction.TO_NORTH, Direction.TO_EAST, Direction.TO_SOUTH, Direction.TO_WEST};
    final char [] directionsAvailable= new char[] {'s', 'n'};
    String toTell="You have reached the entrance of my house \n ";
    String choices=roomDetails.toString();
    String options="s for south or n for north";
    public Direction visit(Visitor visitor, Direction directionFrom)
    {
        visitor.tell(toTell);
        char chosen= visitor.getChoice(choices+options, directionsAvailable);
        if(chosen=='s')
            return allDirections[2];
        else
            return  allDirections[0];
    }

    @Override
    public String toString() {
        return "Entrance";
    }
}
class corridor extends entrance {
    Lights lights =new Lights(false, true,5);
    String [] doorTypes= new String[]{"wooden","mahogany", "oak","plastic"};
    String [] doorColors=new String[]{"black", "gold", "green", "wheat"};
    String [] doorDestinations= new String[]{"the exit","the casino","the bedroom", "the printing room"};
    String [] doordirections= new String[]{"south","west","north","east"};
    Doors doors=new Doors(doorTypes,doorColors,doorDestinations,doordirections);
    WallsItems wallsItems=new WallsItems("yellow", new Item("the Mona Lisa"),"bronze", "forest green");
    RoomDetails roomDetails= new RoomDetails(lights,doors,wallsItems);
    final String toTell = "You have reached the corridor. ";
    String choices= roomDetails +"n for north, e for east etc";
    final char [] directionsAvailable= new char[] {'n','e','s','w'};
    public Direction visit(Visitor visitor, Direction directionFrom) {
        visitor.tell(toTell);
        char chosen = visitor.getChoice(choices, directionsAvailable);
        if (chosen == 's')
            return allDirections[2];
        else if (chosen == 'n')
            return allDirections[0];
        else if (chosen == 'w')
            return allDirections[3];
        else
            return allDirections[1];

    }

    @Override
    public String toString() {
        return "Corridor";
    }
}
class casino extends entrance{
    Lights lights=new Lights(true,true,2);
    String [] doorTypes= new String[]{"mahogany"};
    String [] doorColors=new String[]{"gold"};
    String [] doorDestinations= new String[]{"the corridor"};
    String [] doordirections= new String[]{"east"};
    Doors doors=new Doors(doorTypes,doorColors,doorDestinations,doordirections);
    WallsItems wallsItems=new WallsItems("neon blue", new Item(" slot machine"),"black", "red");
    RoomDetails roomDetails= new RoomDetails(lights,doors,wallsItems);
    final String toTell="You have entered the casino\n ";
    String choices=roomDetails.toString()+"n for north, e for east etc";
    final char[] yesNoArray={'y','n'};
    final String yesNoDescription="/n y for yes n for no";
    final char [] directionsAvailable= new char[] {'e'};

    public Direction visit(Visitor visitor, Direction directionFrom) {
        visitor.tell(toTell);
        boolean stay=true;
        int moneySpent=0;
        while(stay) {
            moneySpent=moneySpent+casinoVariation(visitor);
            char choice=visitor.getChoice("Do You want to stay in the casino"+yesNoDescription,yesNoArray);
            if(choice=='n'||choice=='N')
                stay=false;

        }
        char chosen = visitor.getChoice(choices, directionsAvailable);
            return allDirections[1];//east is the only current choice. Will update later on

    }
    public int casinoVariation(Visitor visitor){
        char[] optionsToChooseFrom = {'a', 'b', 'c', 'd'};
        char userChoice = visitor.getChoice("I will offer you a choice. One of the options will give you 5 gold. The other 2 will take away 3 gold. Choose a to default and incur a 1 gold fine. Other options are b,c or d", optionsToChooseFrom);
        int correctPosition = generateRandom((optionsToChooseFrom.length));
        int gold=0;
        String toTell="";
        if(userChoice=='a'){
            gold=1;
        }
        else if (userChoice==optionsToChooseFrom[correctPosition]) {
            gold=-5;
            toTell="You have won 5 gold";
        }
        else {
            gold=3;
            toTell="You have lost 3 gold";
        }
        if(payments(visitor,gold))
            visitor.tell(toTell);

        else
        {
            visitor.tell("You will be ejected as you have been unable to pay.");
            gold= 0;
        }
        return gold;


    }
    public int generateRandom(int max) {
        Random rand = new Random();
        return rand.nextInt(max - 1) + 1;
    }
    public boolean payments(Visitor visitor,int golds)
    {
        int moneyTaken=0;
        if(golds>0)
            moneyTaken=visitor.takeGold(golds);
        if(golds<0) {
            visitor.giveGold(golds);
            return true;
        }
        if(moneyTaken==golds)
        {
            return true;
        }
        else {
            visitor.giveGold(moneyTaken);
            return false;
        }
    }
}
class printing extends casino{
    Lights lights=new Lights(false,true,10);
    String [] doorTypes= new String[]{"plastic"};
    String [] doorColors=new String[]{"wheat"};
    String [] doorDestinations= new String[]{"the corridor"};
    String [] doordirections= new String[]{"west"};
    Doors doors=new Doors(doorTypes,doorColors,doorDestinations,doordirections);
    WallsItems wallsItems=new WallsItems("neon blue", new Item("Hewlett-Packard printer"),"red", "pink");
    RoomDetails roomDetails= new RoomDetails(lights,doors,wallsItems);
    String toTell="You have entered the printing room";
    String choice=roomDetails+"n for north, e for east etc";

    @Override
    public Direction visit(Visitor visitor, Direction directionFrom) {
        visitor.tell(toTell);
        boolean stay=true;
        int moneySpent=0;
        while (stay)
        {
            moneySpent=moneySpent+printingVariation(visitor);
            char choice= visitor.getChoice("Would you like to stay in the printing room"+yesNoDescription,yesNoArray);
            if(choice=='y'||choice=='Y')
                stay=false;
        }
        char chosen = visitor.getChoice(choices, directionsAvailable);
        return allDirections[3];//west is the only current choice. Will update later on
    }
    //text was generated using notion.
    public int printingVariation(Visitor visitor){
        final Item printer= new Item("printer Cannon");
        visitor.tell("You step into the printing room and are greeted by the steady hum of machinery. ");
        visitor.tell("The room is filled with towering printing presses, each one churning out page after page of crisp, clear text and vibrant images.");
        char yesOrNo=visitor.getChoice("Would you like to buy your own printer for 5 gold?"+yesNoDescription,yesNoArray);
        if(yesOrNo=='y')
        {
            if(visitor.hasEqualItem(printer)||visitor.hasIdenticalItem(printer))
            {
                visitor.tell("I cannot sell you 2 printers as I'm against the hoarding of my property");
            }
            else {
                if(payments(visitor,5)){
                    visitor.giveItem(printer);
                    return 5;
                }
            }
        }
        else{
            yesOrNo=visitor.getChoice("For you my friend: 3 gold"+yesNoDescription,yesNoArray);
            if(yesOrNo=='y'){
                if(payments(visitor,3))
                {
                    visitor.giveItem(printer);
                    return 3;
                }
            }
        }
        return 0;
    }
}
class bedroom extends casino{
    Lights lights=new Lights(false,true,3);
    String [] doorTypes= new String[]{"green"};
    String [] doorColors=new String[]{"oak"};
    String [] doorDestinations= new String[]{"the corridor"};
    String [] doordirections= new String[]{"south"};
    Doors doors=new Doors(doorTypes,doorColors,doorDestinations,doordirections);
    WallsItems wallsItems=new WallsItems("green", new Item("single bed"),"green", "green");
    RoomDetails roomDetails= new RoomDetails(lights,doors,wallsItems);
    String toTell="You have entered the bedroom";
    String choice=roomDetails+"n for north, e for east etc";

    @Override
    public Direction visit(Visitor visitor, Direction directionFrom) {
        visitor.tell(toTell);
        boolean stay=true;
        while (stay)
        {
            bedroomVariation(visitor);
            char choice= visitor.getChoice("Would you like to sleep again?"+yesNoDescription,yesNoArray);
            if(choice=='N'||choice=='n')
                stay=false;
        }
        char chosen = visitor.getChoice(choices, directionsAvailable);
        return allDirections[2];//west is the only current choice. Will update later on
    }
    public void bedroomVariation(Visitor visitor) {
        visitor.tell("You enter the bedroom and see a comfortable bed with fresh sheets and fluffy pillows.");
        visitor.tell("You decide to lie down and close your eyes for a few minutes.");
        try {
            Thread.sleep(60000); // Wait for 1 minute (in milliseconds)
        } catch (InterruptedException e) {
            // Interrupted sleep
        }
        visitor.tell("You feel refreshed and energized after your nap.");
    }

}
class Room_ec22593 extends Room{

    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        entrance entrance=new entrance();
        casino casino=new casino();
        printing printing=new printing();
        bedroom bedroom=new bedroom();

        final Direction[] allDirections = new Direction[]{Direction.TO_NORTH, Direction.TO_EAST, Direction.TO_SOUTH, Direction.TO_WEST};
        boolean stay=true;
        Direction toGo=allDirections[0];
        while (stay)
        {
            toGo=entrance.visit(visitor,toGo);
            if(toGo==allDirections[0]||toGo.equals(allDirections[0]))
                bedroom.visit(visitor,toGo);
            if(toGo==allDirections[1]||toGo.equals(allDirections[1]))
                printing.visit(visitor,toGo);
            if(toGo==allDirections[3]||toGo.equals(allDirections[3]))
                casino.visit(visitor,toGo);
            else
                stay=false;

        }
        return toGo;
    }
}
