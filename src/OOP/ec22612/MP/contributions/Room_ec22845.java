package OOP.ec22612.MP.contributions;

import java.util.Random;

class Enemy {
    String name;

    int maxHp;
    int hp;

    int def;
    int defenseFactor;

    int atk;

    Enemy(String name, int maxHp, int defenseFactor, int atk) 
    {
        this.name = name; 
        this.maxHp = maxHp; 
        this.atk = atk;
        this.defenseFactor = defenseFactor;

        this.hp = this.maxHp;

        this.def = 1;

        return;
    }

    int attack(int attackedHp) 
    {
        int newHp = attackedHp - atk;

        if (newHp < 0) { newHp = 0; }

        return newHp;
    }

    void defend () 
    {
        def = defenseFactor;
    }

    void stopDefend () 
    {
        def = 1;
    }

    int takeDamage(int attackerAtk) // TRUE IF DEAD, FALSE IF ALIVE
    {
        int dmg = (int) ((double) attackerAtk * 1/(double) def); dmg = (hp - dmg < 0)? hp : dmg;
        this.hp -= dmg;

        return dmg;
    }
}

class Room_ec22845 extends Room 
{
    private static <T> String flavourText (T m) { return ("~\n" + m + "\n~\n"); }

    private static char[] appendToCharArray (char[] array, char item) 
    {
        char[] newArray = new char[array.length+1];

        for (int i=0; i<array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[newArray.length-1] = item;
        
        return newArray;
    }

    // ROOM VARS //
    private boolean roomTidy = false;
    private boolean northDoorClosed = false;
    private boolean drawerOpen = false;
    private boolean floorboardOpen = false;
    private boolean holeOpen = false;

    // PLAYER VARS //
        // STATS //
        private int playerMaxHp = 100;
        private int playerHp = 100;
        private int playerDef = 1;
        private int defenseFactor = 3;

        private int playerAtk = 120;
        

        // ITEMS //
            // KEY // 
            private static Item drawerKey = new Item("Drawer Key");
            private boolean hasKey = false;

            // SHIELD //
            private static Item shield = new Item("Sturdy Shield");
            private boolean hasShield = true;

            private int shieldDef = 4;

            // MELEE //
            private static Item shiv = new Item("Blunt Shiv");
            private boolean hasShiv = true;

            private int shivAtk = 195;

            // RANGED //
            private static Item gun = new Item("Handgun");
            private int gunUses = 5;

            private int gunAtk = 110;

            // STUN //
            private static Item stunPowder = new Item("Stun Powder");
            private int stunUses = 3;

            // HEAL //
            private static Item bandages = new Item("Bandages");
            private int bandageUses = 5;

            private int bandageHeal = 10;


    void ResetRoom () 
    {
        // ROOM VARS //
     roomTidy = false;
     northDoorClosed = false;
     drawerOpen = false;
     floorboardOpen = false;
     holeOpen = false;

    // PLAYER VARS //
        // STATS //
        playerMaxHp = 100;
        playerHp = 100;
        playerDef = 1;
        defenseFactor = 3;
        playerAtk = 120;
    
        // ITEMS //
            // KEY // 
            drawerKey = new Item("Drawer Key");
             hasKey = false;

            // SHIELD //
            shield = new Item("Sturdy Shield");
             hasShield = false;

            shieldDef = 4;

            // MELEE //
            shiv = new Item("Blunt Shiv");
             hasShiv = false;

            shivAtk = 195;

            // RANGED //
            gun = new Item("Handgun");
            gunUses = 0;

            gunAtk = 110;

            // STUN //
            stunPowder = new Item("Stun Powder");
            stunUses = 0;

            // HEAL //
            bandages = new Item("Bandages");
            bandageUses = 0;

            bandageHeal = 10;
    }

    String displayHealthbar (String name, int maxHp, int hp, int scale) 
    {
        double hpPercent = (double)hp / (double)maxHp;

        String title = "- " + name + " -   |" + hp + "/" + maxHp + "|\n";
        String healthbarFrame1 = "    +" + new String(new char[scale+2]).replace("\0", "-") + "+\n    |";
        
        String healthbarDisplay =   new String(new char[(int) Math.floor(hpPercent*scale)]).replace("\0", "▓") + 
                                    new String(new char[scale - (int) Math.floor(hpPercent*scale)]).replace("\0", "░");
        String healthbarFrame2 =    " |\n    +" + new String(new char[scale+2]).replace("\0", "-") + "+";

        String healthbar = title + healthbarFrame1 + healthbarDisplay + healthbarFrame2;

        return healthbar;
    }

    boolean chance (double chance) 
    {
        Random rnd = new Random();

        return (chance > rnd.nextDouble());
    }

    int takeDamage(int attackerAtk) 
    {
        int dmg = (int) ((double) attackerAtk * 1/(double) playerDef); dmg = (playerHp - dmg < 0)? playerHp : dmg;
        playerHp -= dmg;

        return dmg;
    }
    
    boolean fight (Visitor visitor, Enemy enemy) 
    {
        boolean win = false;
        boolean dead = false;

        boolean dodge = false;

        boolean enemyBlock = false;

        boolean enemyStunned = false;
        int stunDuration = 0;

        if (hasShield) { defenseFactor = shieldDef; }
        if (hasShiv) { playerAtk = shivAtk; } 

        visitor.tell("A fight commences with \"" + enemy.name + "\" !");

        while (!win && !dead) 
        {
            playerDef = 1;

            visitor.tell(displayHealthbar(enemy.name, enemy.maxHp, enemy.hp, 50) + "\n");

            visitor.tell(displayHealthbar("Visitor", playerMaxHp, playerHp, 20));

            String action = "Action:\n    a) attack\n    d) defend";
            char[] choices = {'a','d'};

            if (gunUses > 0) { action = action + "\n    g) [" + gunUses + "]shoot (80% hit, 50% dodge)"; choices = appendToCharArray(choices, 'g'); }
            if (stunUses > 0) { action = action + "\n    s) [" + stunUses + "]stun powder (50% 1-turn, 25% 2-turns)"; choices = appendToCharArray(choices, 's'); }
            if (bandageUses > 0) { action = action + "\n    h) [" + bandageUses + "]heal (+10HP)"; choices = appendToCharArray(choices, 'h'); }

            char choice = visitor.getChoice(action, choices);

            if (choice == 'a') 
            {
                int enemyDMGtaken = enemy.takeDamage(playerAtk);
                win = (enemy.hp == 0);

                visitor.tell("\n*You attacked for " + enemyDMGtaken + " damage.*\n");

            } else if (choice == 'd') 
            {
                playerDef = defenseFactor;

                visitor.tell("\n*You raise your guard for 1 turn.*\n");

            } else if (choice == 'g')
            {
                gunUses--;
                boolean hit = chance(0.8);
                dodge = chance(0.5); 

                if (dodge) { visitor.tell("\n*You successfully dodged before firing a round.*\n"); }

                if (hit) { int enemyDMGtaken = enemy.takeDamage(gunAtk); visitor.tell("\n*You attacked for " + enemyDMGtaken + " damage.*\n"); } 
                else { visitor.tell("\n-=You missed the shot.=-\n"); }

                win = (enemy.hp == 0);

            } else if (choice == 's') 
            {
                stunUses--;
                stunDuration = 0; stunDuration = (chance(0.5))? 2:0; stunDuration = (chance(0.25))? 3:0;

                if (stunDuration == 0) { visitor.tell("\n-=Stun attempt failed=-\n"); }
            } else if (choice == 'h') 
            {
                bandageUses--;
                int playerHealTaken = takeDamage(-bandageHeal);

                visitor.tell("\n*You healed for " + -playerHealTaken + " health.*\n");
            }

            // ENEMY TURN //

            boolean enemyTurn = true;

            if (win || dodge) { enemyTurn = false; }
            if (enemyBlock) { enemyTurn = false; enemyBlock = false;}
            if (stunDuration > 0) { visitor.tell("\n*Enemy stunned for " + (stunDuration-1) + " turn(s).*\n"); stunDuration--; enemyTurn = false; }

            if (enemyTurn) 
            {
                enemy.stopDefend();

                boolean enemyAttack = chance(0.75);

                if (enemyAttack) 
                {
                    int playerDMGtaken = takeDamage(enemy.atk);
                    visitor.tell("\n-=You were attacked for " + playerDMGtaken + " damage.=-\n");
                } else 
                {
                    enemy.defend();
                    enemyBlock = true;

                    visitor.tell("\n*The enemy defends for 1 turn.*\n");
                }

                dead = (playerHp == 0);
            }
        }

        visitor.tell(displayHealthbar(enemy.name, enemy.maxHp, enemy.hp, 50) + "\n");

        visitor.tell(displayHealthbar("Visitor", playerMaxHp, playerHp, 20));

        return win;
    }

    public Direction visit (Visitor visitor, Direction dir)  
    {
        ResetRoom ();
        Enemy ratKing = new Enemy("Rat King", 1000, 3, 20);
        

        if (dir == Direction.FROM_NORTH) 
        {
            if (!northDoorClosed) {
                visitor.tell("You entered from the north.");
                visitor.tell("The door closes behind you.\n");
                northDoorClosed = true;
            }

            else { visitor.tell("This door is sealed now sealed. However, you remember seeing the South doorway open..."); return Direction.TO_NORTH; }

        } else if (dir == Direction.FROM_EAST) {
            visitor.tell("The east door is sealed. There must be another way in...");
            return Direction.TO_EAST;

        } else if (dir == Direction.FROM_SOUTH) {
            visitor.tell("You entered from the south.");

        } else if (dir == Direction.FROM_WEST) {
            visitor.tell("The west door is sealed. There must be another way in...");
            return Direction.TO_WEST;

        } else {
            visitor.tell("You entered from... somewhere...");
        }

        final char SENTINEL = 'e';
        char choice = 'a';
        while (choice != SENTINEL) 
        {
            // ROOM IS DIRTY //

            if (!roomTidy)
            {
                visitor.tell("The room is a mess.");

                choice = visitor.getChoice("Do you:\n    s) search the room\n    c) clean the room\n    l) look around the room\n    i) check inventory\n    e) leave via the south exit?", 
                new char[]{'s','c','l','i','e'});
            }

            else 
            {
                visitor.tell("The room is somewhat tidy.");

                choice = visitor.getChoice("Do you:\n    s) search the room\n    l) look around the room\n    i) check inventory\n    e) leave via the south exit?", 
                new char[]{'s','l','i','e'});
            }

            // SEARCH ROOM //

            if (choice == 's') 
            {
                visitor.tell("You see a cabinet, a raised floorboard, and hole in the wall");
                choice = visitor.getChoice("Do you:\n    c) search the cabinet\n    f) check the floorboard\n    h) check the hole?", 
                new char[]{'c','f','h'});

                // SEARCH CABINET //

                if (choice == 'c') {
                    visitor.tell("You approach cabinet.");

                    // DRAWER UNLOCKED //

                    if (drawerOpen) { visitor.tell("\nYou've already searched through it."); }

                    // DRAWER LOCKED //

                    if (!drawerOpen) 
                    {
                        // SEARCH CABINET //

                        
                        if (!hasShield) {
                            visitor.tell("You search through the main cabinet.");
                            visitor.tell(".");
                            visitor.tell("..");
                            visitor.tell("...");
                            visitor.tell("You find a shield - makeshift, yet sturdy looking.");
                            visitor.giveItem(shield); hasShield = true;
                        }
                        
                        visitor.tell("\nThe drawer is locked."); 

                        // HAS KEY //

                        if (visitor.hasIdenticalItem(drawerKey)) 
                        {
                            visitor.tell("\nYou have a key.");

                            choice = visitor.getChoice("Do you:\n    k) try to unlock the drawer\n    b) step away from the drawer", 
                            new char[]{'k','b'});

                            // UNLOCKS DRAWER //

                            if (choice == 'k') 
                            {
                                drawerOpen = true;

                                visitor.tell("You unlock the drawer.");
                                visitor.tell("You search through it.");
                                visitor.tell(".");
                                visitor.tell("..");
                                visitor.tell("...");
                                visitor.tell("You found 5 gold inside!\n");
                                visitor.giveGold(5);
                                visitor.tell("Next to the gold, you find:");
                                visitor.tell("A pack of 3 treated bandages");
                                visitor.tell("A handgun, with 5 rounds");
                                visitor.tell("You take both");
                                visitor.giveItem(bandages); bandageUses = 3;
                                visitor.giveItem(gun); gunUses = 5;
                            }
                        }
                        else 
                        { 
                            visitor.tell("You need the key.");
                            
                        }
                        visitor.tell("\nYou step away from the drawer.\n");
                    }
                }

                // SEARCH FLOORBOARD //
                else if (choice == 'f') 
                {
                    visitor.tell("You approach the raised floorboard.");

                    // FLOORBOARD OPENED //

                    if (floorboardOpen) { visitor.tell("\nYou've already searched through it."); }

                    // FLOORBOARD NOT OPENED //

                    if (!floorboardOpen) 
                    {
                        
                        floorboardOpen = true;

                        visitor.tell("You wedge the floorboard upwards.");
                        visitor.tell("Amongst the dust and debris, you find a small burlap sack.");
                        visitor.tell("You begin to feel dizzy when you hold it near your face...");
                        visitor.tell("Better not get it on your skin, but it may be useful.");
                        
                        visitor.giveItem(stunPowder); stunUses = 3;

                        visitor.tell("You dig further...");
                        visitor.tell("A shiv, made by grinding a plastic piece tirelessly against the wall.");
                        visitor.tell("You feel a bit safer with it in your hand. You take it with you.");

                        visitor.giveItem(shiv); hasShiv = true;

                        visitor.tell("\nYou step away from the now-boardless floor.\n");
                    }
                }

                
                // SEARCH HOLE (FIGHT) //
                else if (choice == 'h') 
                {
                    // HOLE OPENED //

                    if (holeOpen) { visitor.tell("\nYou've already searched through it."); }

                    // HOLE NOT OPENED //

                    if (!holeOpen) 
                    {
                        
                        holeOpen = true;

                        visitor.tell("You approach the whole in the wall.");
                        visitor.tell("As you step towards it, you hear scurrying and scratching from inside the wall.");
                        visitor.tell("You reach into the hole, and prod around it...");
                        visitor.tell(".");
                        visitor.tell("..");
                        visitor.tell("...");
                        visitor.tell("You grab something... The scurrying stops...");
                        visitor.tell("The air feels heavy... What could you have possibly made contact with?");

                        boolean fightResult = false;

                        choice = visitor.getChoice("Do you:\n    p) pull\n    b) let go and step away from the hole?", 
                            new char[]{'p','b'});

                        if (choice == 'p') 
                        {
                            visitor.tell("\nYou pull swiftly, but meet resistance!");
                            visitor.tell("You pull even harder, the wall seemingly buckling to the strain!");
                            visitor.tell("Suddenly, a creature bursts through the dank, decrepit wall!");
                            visitor.tell("A... rat? Rats! A creature of 9 rats fused together at the tail!");
                            visitor.tell("It towers above you! It's the fabled RAT KING!");
                            visitor.tell("You have no choice but to fight back!\n");

                            fightResult = fight(visitor, ratKing);
                        }
                        else 
                        {
                            visitor.tell("You slowly release the thing, and creep slowly away from the hole...");
                        }
                        
                        if (fightResult) { 
                            visitor.tell("You've triumphed over the cursed RAT KING!!!");
                            visitor.tell("From its open stomach, you spot a mass of glistening pieces...");
                            visitor.tell("Gold! 8 pieces of gold!");

                            visitor.giveGold(7);

                            visitor.tell("You pick them up.\n");
                            visitor.tell("Despite the bloodied corpse in the room, you feel a peace with the RAT KING defeated."); 
                            visitor.tell("You take a deep, triumphant breath, unphased by the putrid smell."); 
                        } 
                        else 
                        {
                            visitor.tell("You were struck down by the cunning RAT KING...");
                            visitor.tell("Just before the RAT KING could begin gorging itself on your weakened body, the room...");
                            visitor.tell("The room begins to warp around you, as if rejecting you...");
                            visitor.tell("\"Be prepared before challenging it again\" an ephemeral voice rung in your head...");
                            visitor.tell("\"Tools to aid you are hidden in its lair\" it says...");
                            visitor.tell("\"I'll be taking 10 gold, think of it as a toll\"");
                            visitor.tell("You feel your pocket get lighter...");
                            visitor.takeGold(10);
                            
                            visitor.tell("\nPerhaps you should head its warning next-time...\n");

                            return Direction.TO_SOUTH;
                        }
                    }
                }
            }

            // CLEAN ROOM //

            else if (choice == 'c') 
            {
                visitor.tell("You begin cleaning.");
                visitor.tell(".");
                visitor.tell("..");
                visitor.tell("...");
                visitor.tell("Almost done cleaning...");

                visitor.tell("Suddenly, a mouse bolts out from a crack in the wall, stealing 2 gold from you!");
                visitor.takeGold(2);

                visitor.tell("You chase it to the hole.");
                visitor.tell("You reach in trying to grab it. However, you feel something else... A key!");
                visitor.giveItem(drawerKey);
                hasKey = true;

                visitor.tell("You finish cleaning, curious what the key opens...\n");

                roomTidy = true;
            }

            // LOOK AROUND ROOM //

            else if (choice == 'l') 
            {
                visitor.tell("The room is caked in dust and debris.");
                visitor.tell("In the center of the room, a lone cabinet stands.");
                visitor.tell("Leaning against the wall is a well-worn broom.\n");
            }

            // CHECK INVENTORY //

            else if (choice == 'i') 
            {
                if (hasKey) { visitor.tell("You've picked up a key in this room."); }
                else { visitor.tell("You haven't found anything noteworthy here... Yet...\n"); }
            }

            // EXIT ROOM //

            else 
            {
                visitor.tell("You exit the room via the South doorway.\n");
            }
        }

        return Direction.TO_SOUTH;
    }
}