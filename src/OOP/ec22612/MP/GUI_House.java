package OOP.ec22612.MP;
import OOP.ec22612.MP.contributions.*;

import java.util.*;

public class GUI_House extends House{

    ArrayList<ArrayList<Room>> Rooms;
    int RoomSize;

    int x;
    int y;
    boolean inhouse;

    GUI_House(String room_size){
        inhouse = true;
        x=0;
        y=0;
        if(room_size.equals("big")){

            RoomSize = 6;

        }

        else if(room_size.equals("medium")){

            RoomSize = 4;
        }

        else{

            RoomSize = 2;
        }

        Rooms = new ArrayList<ArrayList<Room>>();

        Populate_House();

    }

    GUI_House(int room_size){
        inhouse = true;
        x=0;
        y=0;
        RoomSize = room_size;
        Rooms = new ArrayList<ArrayList<Room>>();

        Populate_House();

    }
    public Direction visit(Visitor v, Direction d) {




        while(inhouse){


            d = Rooms.get(x).get(y).visit(v,d);





            if(y == 0 && d == Direction.TO_SOUTH){
                inhouse = false;

            }

            else if(x == 0 && d == Direction.TO_WEST){
                inhouse = false;

            }

            else if(y == (RoomSize-1) && d == Direction.TO_NORTH){
                inhouse = false;

            }

            else if(x == (RoomSize-1) && d == Direction.TO_EAST){

                inhouse = false;

            }

            else if (d == Direction.TO_NORTH){
                y += 1;
            }

            else if (d == Direction.TO_SOUTH){
                y -= 1;
            }

            else if (d == Direction.TO_EAST){
                x+= 1;
            }

            else if (d == Direction.TO_WEST){
                x-= 1;
            }

        }

        v.tell("You have left the House");

        return d;
    }

    public void Populate_House(){

        Set<Room> roomstoadd = rooms_to_add();
        Iterator<Room> rmiterator = roomstoadd.iterator();

        for(int i = 0; i<RoomSize;i++){
            Rooms.add(new ArrayList<Room>());
            for (int j = 0; j<RoomSize; j++){
                Rooms.get(i).add(rmiterator.next());
            }
        }

    }

    public Set<Room> rooms_to_add(){
        String[] Usernames = Contributions.getRoomUsernames();

        Set<Room> roomstoadd = new HashSet<>();

        while (roomstoadd.size() != (RoomSize*RoomSize)){
            int randomindex = randomInt(Usernames.length);
            Room newroom;
            try {
                newroom = Contributions.newRoomByUsername(Usernames[randomindex]);

            }

            catch (Exception a){
                newroom = Contributions.newRoomByUsername("ec22612");
            }

            roomstoadd.add(newroom);

        }

        return roomstoadd;

    }

    public static int randomInt(int bound) {
        Random r = new Random();
        return r.nextInt(bound);
    }
}
