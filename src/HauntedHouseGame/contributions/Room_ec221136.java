package HauntedHouseGame.contributions;

import java.util.Random;


class Room_ec221136 extends Room {

     public Direction visit(Visitor v, Direction arrival) {
         
         Random r = new Random();
         boolean spectre = r.nextBoolean();
         boolean window = false;
         v.tell("You have enter the Spectre's room.");
         v.tell("As you step into the room, you feel an eerie sense of emptiness and neglect that seems to hang heavily in the air. The room is small, with peeling wallpaper and dirty, cracked tiles on the floor. The only light comes from a small, grimy window high up on the wall, which barely lets in enough light to see by. \n The furniture is sparse, with a rickety wooden chair in one corner and a stained mattress on the floor in another. A thin layer of dust covers everything, and cobwebs cling to the corners of the ceiling. The air is stale and musty, and you can smell the faint scent of mildew. \n you look around, you notice that there are no personal items in the room - no pictures on the walls, no books or magazines on the floor. It's as if the room has been stripped of all signs of life, leaving only a cold and empty shell behind. \n Despite the silence, you can't shake the feeling that someone - or something - is watching you. The hairs on the back of your neck stand up, and you feel a chill run down your spine. You can't explain it, but you sense that this room has a dark history, and that something terrible might have happened here.");


         if (window) {
             v.tell("The window is closed.");
         } else {
             v.tell("The window is open.");
         }

         char choice = v.getChoice("Would you prefer to? A) Open the window, B) Close the window, C) Inspect the Bag", new char[]{'A', 'B', 'C'});

         if (choice == 'A') {
             if (window) {
                 v.tell("The window is already open.");
                 window = true;
             } 
             
             else {
                 v.tell("You opened the window");
                 window = true;
             }
         } 
         
         else if (choice == 'B') {
             if (window) {
                 v.tell("You closed on the window");
                 window = false;
             } 
             
             else {
                 v.tell("The window is already closed");
                 window = false;
             }
             
         } 
         
         else if (choice == 'C') {
             
             v.tell("It looks like it has been there for a while, with a thick layer of dust covering its surface. Would you like to open it?");
             
             if (v.giveItem(new Item("bag"))) {
                 v.tell("The bag is made of worn canvas, with frayed edges and several patches sewn onto it. It looks like it has been through a lot, as if it has traveled to many places and seen many things. \n As you unzip the bag, you find a few items inside. There is a small flashlight, a crumpled map, a half-empty water bottle, and a worn-out notebook. It seems like these are the belongings of someone who has been traveling for a while, trying to survive in this desolate place. \n As you examine the contents of the bag, you notice that there is something else inside, tucked away in a small pocket. It's a small, weathered photograph of a person, with a warm smile and kind eyes. The photograph has been folded several times, as if it has been carried around and looked at frequently. \n You can't help but wonder who this person is, and what kind of relationship they had with the owner of the bag. Perhaps this bag belonged to someone who was searching for someone else, or who was running away from something. \n As you put the photograph back into the pocket and close the bag, you feel a sense of curiosity and intrigue. It's as if this bag holds a story that is waiting to be told, and you can't wait to unravel the mystery that it holds. \n As you continue to search the bag you find 10 Gold, and decide to carry the whole thing with you as you leave the room. ");
                 v.giveGold(10);
             }
             
             else {
                 v.tell("You put the bag down.");
             }
         }
         if (window) {
             if (spectre) {
                v.tell("As you spend more time in the desolate room, you begin to feel a sense of unease and discomfort. You can't shake the feeling that you're being watched, and that something is lurking in the shadows. \n Suddenly, you hear a faint whisper, and you turn around to see a ghostly figure materialize out of thin air. It's a pale, translucent figure, with hollow eyes and a twisted, malevolent grin. You try to back away, but it's too late. \n The spirit lunges at you, its hands reaching out to grab you. You feel a cold chill run down your spine, and you realize that you are in grave danger. You try to scream, but no sound comes out. \n The spirit's grip tightens around you, and you feel as if you're being suffocated. You struggle to break free, but the spirit is too strong. \n  Just when you think it's all over, the spirit suddenly disappears, leaving you alone in the desolate room. You're shaken and disoriented, but you're alive. \n Fuelled with adrenaline and sheer fear, you quickly gather your belongings and leave the room.");
                v.takeGold(5);
                 
             }
             else {
                 v.tell("You leave the room peacfully");
             }
         }
         else {
                 v.tell("You leave the room peacfully");
         }
         return Direction.opposite(arrival);
     }

}
