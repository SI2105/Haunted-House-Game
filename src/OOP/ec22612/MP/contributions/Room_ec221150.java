package OOP.ec22612.MP.contributions;

class Room_ec221150 extends Room{
    
    
    public Direction visit(Visitor v, Direction d){
        
        Direction rDirection = d;
        final Item Pen = new Item("Pen");

        
        boolean lights = false;
        String lightState = "";
        if(lights==false){
            lightState = "off";
        }
        else if(lights==true){
            lightState = "on";
        }
        
        boolean floor = true;
        String floorState = "";
        if(floor==true){
            floorState = "clean";
        }
        else if(floor==false){
            floorState = "dirty";
        }
        
        

        v.tell("Welcome to the painting room!");
        
        v.tell("lights are "+lightState);
        
        v.tell("floor is "+floorState);
        
        if(floor==true){
            v.tell("Wear overshoes to keep the floor clean");
        }
        
        char shoe = v.getChoice("1.Wear overshoes \n 2.Walk with dirty shoes", new char[]{1,2});
        
        switch(shoe){
            case '1':
                break;
            case '2':
                floor =false;
                break;
            default:
                break;
        }
        
        if(lights==false){
            v.tell("Switch lights on to see better and don't forget to switch off when you leave");
        }
        
        char light = v.getChoice("1.Turn lights on \n 2.Continue in dark", new char[]{1,2});
        
        switch(light){
            case '1':
                lights=true;
                break;
            case '2':
                break;
            default:
                break;
        }
        v.tell("Do you enjoy your visit so far?");
        
        char liked = v.getChoice("1.Yes these are good paintings \n 2.Not my particular area of interest", new char[]{1,2});
        
        switch(liked){
            case '1':
                
            System.out.println("-Yes these are good paintings");
            
            v.tell("Glad to hear that.");
            v.tell("You look like an artist yourself.");
            
            char ans1 = v.getChoice("1.Yes, I like to draw landscapes in my spare time \n 2.I've never tried but it seems interesting", new char[]{1,2});
            
                switch(ans1){
                    case '1':
                    System.out.println("-Yes, I like to draw landscapes in my spare time");
                    v.tell("Interesting. Can you draw something for me?");

                    char ans2 = v.getChoice("1. Sure, let me try. \n 2. Not really, I'm not that good at it",new char[] {1,2});
                    
                        switch(ans2){
                            case '1':
                                System.out.println("-Sure, let me try.");
                                v.tell("Amazing. I will bring you a pen and a piece of paper.");
                                if(v.hasEqualItem(Pen)){
                                    System.out.println("-Just a paper would be fine, I brought my own pen.");
                                }
                                else{
                                    System.out.println("-Sure");
                                    v.giveItem(Pen);
                                }

                                System.out.println("-Done! What do you think of it?");

                                String[] how_good = new String[4];
                                how_good[0] = "Okay";
                                how_good[1] = "Good";
                                how_good[2] = "Great";
                                how_good[3] = "Amazing";

                                int randN = (int)(Math.random()*3)+1;

                                v.tell("That looks "+ how_good[randN]);

                                if(randN==3){
                                    v.tell("I really love it, I will keep it and here's 4 gold for this.");
                                    v.giveGold(4);
                                }
                                break;
                            case '2':
                                System.out.println("-Not really, I'm not that good at it");
                                break;
                        }
                            break;
                        
                    case '2':
                        System.out.println("I've never tried but it seems interesting");
                        break;
                    }

                        break;
                    case '2':
                        System.out.println("-Not my particular area of interest");
                        break;
            }
                char ans3 = v.getChoice("1.Turn lights off \n 2.Leave lights on", new char[]{1,2});
                    switch(ans3){
                        case '1':
                            lights=false;
                            break;
                        case '2':
                            break;
                    }
        
        if(lights==true){
            System.out.println("You have left the lights on, that cost you 2 golds");
            v.takeGold(2);
        }

        int randN2 = (int)(Math.random()*4)+1;
        
        if(randN2==1){
            rDirection = Direction.TO_NORTH;
            v.tell("You're heading north exit");
        }
        
        if(randN2==2){
            rDirection = Direction.TO_EAST;
            v.tell("You're heading east exit");
        }
        if(randN2==3){
            rDirection = Direction.TO_SOUTH;
            v.tell("You're heading south exit");
        }
        if(randN2==4){
            rDirection = Direction.TO_WEST;
            v.tell("You're heading west exit");
        }
        
        return rDirection;
    }
}
