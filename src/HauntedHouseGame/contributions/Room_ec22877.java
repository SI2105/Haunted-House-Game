package HauntedHouseGame.contributions;

class Room_ec22877 extends Room {
            static final Item FIRSTAIDKIT = new Item("First Aid Kit");

            public Direction visit(Visitor visitor, Direction direct)
            {
                char[] angles = {'a', 'b', 'c'};
		            visitor.tell("You are currently in the Consulate which is under attack, you must eliminate the Opposing Forces immediately");


                char choice = visitor.getChoice("Which angle will you hold against the enemy 1) Bottom of Yellow stairs 2) Main Entrance  or 3) Visa office", angles);
                int medals = 0;

                if (choice == 'a') {
                    visitor.tell("There was an enemy patiently waiting at the top of the stairs. You were shot but managed to get away and found a First Aid kit to stop blood loss. You received a gold medal from the government after the mission");
                    visitor.giveItem(FIRSTAIDKIT);
                    visitor.giveGold(1);
                    medals = medals + 1;
                }

                if (choice == 'b') {
                    if (medals > 0) {
                        visitor.tell("There are several enemies barricaded behind the counters and you decide to run away and abort the mission. The government strips you of a Gold medal for abandoning the operation.");
                        visitor.takeGold(1);
                        medals = medals - 1;
                    }


                } else {
                    visitor.tell("You enter the building without caution causing you to be fatally wounded by enemies hidden behind the counters");
                }



                if (choice == 'c') {
                    visitor.tell("You valiantly battle until the threat has been neutralised. You are awarded 2 Gold Medals of honor.");
                    visitor.giveGold(2);
                    medals = medals + 2;
                }
                return direct.opposite(direct);
		//updated2
            }
        }
