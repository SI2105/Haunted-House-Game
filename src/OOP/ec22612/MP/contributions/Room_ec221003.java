package OOP.ec22612.MP.contributions;

import java.util.*;

class Room_ec221003 extends Room {
	public static class _H {
		static Scanner keyboard = new Scanner(System.in);
		static String GetUserInput(String ...prompt) {
			_H.print(prompt);
			return keyboard.nextLine();
		}
		public static <T> void printList(T[] arrList, String ...modifiers) {
			String out = "";
			boolean isZeroIndexed = false;
			String listEntryKeyEnder = ": ";
			String lineEnding = "\n";
			for (int i = 0; i < modifiers.length; i += 1) {
				String modifier_str = modifiers[i];
				if (modifier_str.contains("zeroindexed=")) {
					modifier_str = modifier_str.replace("zeroindexed=", "");
					isZeroIndexed = Boolean.valueOf(modifier_str);
				} else if (modifier_str.contains("leke=")) {
					listEntryKeyEnder = modifier_str.replace("leke=", "");
				} else if (modifier_str.contains("endl=")) {
					lineEnding = modifier_str.replace("endl=", "");
				}
			}
			for (int i=0; i < arrList.length; i+=1) {
				int indexDependent = (isZeroIndexed) ? (0) : (1);
				String temp = "" + (i + indexDependent) + listEntryKeyEnder + arrList[i];
				print(temp);
				// out = out + "" + (i + indexDependent) + listEntryKeyEnder + arrList[i] + lineEnding;
			}
			// print(out);
			return;
		}
		public static void printList(double[] arrList) {
			String out = "";
			for (int i=0; i < arrList.length; i+=1) {
				out = out + "" + (i+1) + ": " + arrList[i] + "\n";
			}
			print(out);
			return;
		}
	
		public static void print(String ...msg) {
			String[] msg_minis = {};
			int terminal_width = 80;
			int terminal_height = 24; // not going to be using height, maybe.
			boolean shouldUseTerminalSizeConstraints = true;
			String output = "";
			String separator = " ";
			String lineEnding = "\n";
			String lineBeginning = "";
			boolean includeSeparatorAtEndl = false;
	
			if (msg.length == 0) {
				output = lineBeginning + lineEnding;
				System.out.print(output);
				return;
			} else if (msg.length == 1 && msg[0].trim().length() == 0) {
				output = lineBeginning + msg[0] + lineEnding;
				System.out.print(output);
				return;
			}
	
			for (int i = 0; i < msg.length; i+=1) {
				String msg_component = msg[i];
				// "sep= endl="
				if (msg_component.contains("sep=")) {
					separator = msg_component.replace("sep=", "");
				} else if (msg_component.contains("include_sep_at_endl=;")) {
					includeSeparatorAtEndl = true;
				} else if (msg_component.contains("endl=")) {
					lineEnding = msg_component.replace("endl=", "");
				} else if (msg_component.contains("end=")) {
					lineEnding = msg_component.replace("end=", "");
				} else if (msg_component.contains("startl=")) {
					lineBeginning = msg_component.replace("startl=", "");
				} else if (msg_component.contains("terminalwidth=")) {
					String temp_int_termWidth = msg_component.replace("terminalwidth=", "");
					final int termWidth = (int)Double.valueOf(temp_int_termWidth).doubleValue();
					terminal_width = termWidth;
					if (terminal_width == -1) {
						shouldUseTerminalSizeConstraints = false;
					} else {
						shouldUseTerminalSizeConstraints = true;
					}
				} else {
					msg_minis = Arrays.copyOf(msg_minis, msg_minis.length + 1);
					msg_minis[msg_minis.length - 1] = msg_component;
				}
			}
	
	
			for (int i = 0; i < msg_minis.length; i+=1) {
				output = output + msg_minis[i] + ((i == msg_minis.length - 1 && !includeSeparatorAtEndl) ? ("") : ("SEPARATOR"));
			}
			output = lineBeginning + output.replace("SEPARATOR", separator) + lineEnding;
	
			if (shouldUseTerminalSizeConstraints) {
	
				// final Pattern ANSI_Codes = Pattern.compile("\\033[\\dm");
	
				// iterate over output string and split it up into chunks if it's too big to fit on one terminal-line, defined by terminal-width
				String[] output_corrected = {
					output
				};
				int cutOffPoint = terminal_width + 0;
	
	
				String[] output_corrected2 = {
					output
				};
				
				String[] firstPass_arr_newlinesRemoved = {};
				boolean firstPass_done = false;
				do {
					final String lastItem = output_corrected2[output_corrected2.length - 1];
					final String[] splitted_newLine = lastItem.split("\n");
					for (String item: splitted_newLine) {
						firstPass_arr_newlinesRemoved = _ArrayPush(firstPass_arr_newlinesRemoved, item);
					}
					firstPass_done = true;
				} while(!firstPass_done);
	
	
				String[] secondPass_arr_lengthConstrained = Arrays.copyOf(firstPass_arr_newlinesRemoved, firstPass_arr_newlinesRemoved.length);
				boolean secondPass_done = false;
				int secondPass_indexer = 0;
				while(!secondPass_done) {
					final String uncorrectedItem = secondPass_arr_lengthConstrained[secondPass_indexer];
					// uncorrectedItem = ANSI_Codes.matcher(uncorrectedItem).replaceAll("");
	
					if (uncorrectedItem.length() > terminal_width) {
						final String beforeAndIncludingCutOff = uncorrectedItem.substring(0, cutOffPoint);
						final String afterCutOff = uncorrectedItem.substring(cutOffPoint);
	
						// remove the item at position secondPass_indexer
						// then insert the items: beforeAndIncludingCutOff and afterCutOff
						// I could have used a longer way around this, but that's long.
						secondPass_arr_lengthConstrained = _ArraySplice(
							secondPass_arr_lengthConstrained, 
							secondPass_indexer, 
							1,
							beforeAndIncludingCutOff,
							afterCutOff
						);
	
						// increment the indexer, so it now iterates on the "afterCutOff" string
						secondPass_indexer = secondPass_indexer + 1;
					
						// allow to continue from the top
					} else {
						// don't need to do anything
						secondPass_done = true;
						break;
					}
				}
				output = String.join("\n", secondPass_arr_lengthConstrained) + lineEnding;
			}
			System.out.print(output);
			return;
		}
		public static String[] _ArraySplice(String[] arr, int spliceIndex, int numToRemove, String ...itemsToInsert) {
			String[] new_arr = new String[arr.length - numToRemove];
			// print("" + (arr.length - numToRemove));
			int k = 0;
			for (int i = 0; i < arr.length; i += 1) {
				if (numToRemove > 0 && i >= spliceIndex && i < spliceIndex + numToRemove) {
					continue;
				}
				new_arr[k] = arr[i];
				k += 1;
			}
	
			if (itemsToInsert.length > 0) {
				String[] new_arr2 = new String[new_arr.length + itemsToInsert.length];
				k = 0;
				for (int i = 0; i < new_arr2.length; i += 1) {
					// print(""+i + " -- ");
					if (i < spliceIndex) {
						new_arr2[i] = new_arr[i];
					} else if (i >= spliceIndex && i < spliceIndex + itemsToInsert.length) {
						// print("");
						new_arr2[i] = itemsToInsert[k];
						k += 1;
					} else {
						new_arr2[i] = new_arr[i - itemsToInsert.length];
					}
				}
				return new_arr2;
			} else {
				return new_arr;
			}
		}
		@SafeVarargs
		public static <T> T[] _ArraySplice(T[] arr, int spliceIndex, int numToRemove, T ...itemsToInsert) {
			T[] new_arr = Arrays.copyOf(arr, arr.length - numToRemove);
			int k = 0;
			for (int i = 0; i < arr.length; i += 1) {
				if (numToRemove > 0 && i >= spliceIndex && i < spliceIndex + numToRemove) {
					continue;
				}
				new_arr[k] = arr[i];
				k += 1;
			}
			if (itemsToInsert.length > 0) {
				T[] new_arr2 = Arrays.copyOf(new_arr, new_arr.length + itemsToInsert.length);
				k = 0;
				for (int i = 0; i < new_arr2.length; i += 1) {
					if (i < spliceIndex) {
						new_arr2[i] = new_arr[i];
					} else if (i >= spliceIndex && i < spliceIndex + itemsToInsert.length) {
						new_arr2[i] = itemsToInsert[k];
						k += 1;
					} else {
						new_arr2[i] = new_arr[i - itemsToInsert.length];
					}
				}
				return new_arr2;
			} else {
				return new_arr;
			}
		}

		/**
		 * Array Push
		 * @param <T> Generic Object Type 
		 * @param arr
		 * @param item a variadic argument. It has variable length, all of type T. Similar to Javascript rest operator.
		 * @return a new array to assign to the input arr variable.
		 */
		@SafeVarargs
		public static <T> T[] _ArrayPush(T[] arr, T ...item) {
			T[] new_arr = Arrays.copyOf(arr, arr.length + item.length);
			for (int i = 0; i < item.length; i += 1) {
				new_arr[arr.length + i] = item[i];
			}
			return new_arr;
		}

		public static int[] _ArrayPush(int[] arr, int ...item) {
			int[] new_arr = Arrays.copyOf(arr, arr.length + item.length);
			for (int i = 0; i < item.length; i += 1) {
				new_arr[arr.length + i] = item[i];
			}
			return new_arr;
		}
	
		public static <T> void PrintArrayList(List<T> arr, String ...extra) {
			String buffer = "";
			final boolean includeBrackets = true;
			final String delimiter = ", ";
			for (int i = 0; i < arr.size(); i += 1) {
				System.out.println(arr.get(i));
				Object item = arr.get(i);
				if (item instanceof String) {
					buffer += item;
				} else {
					buffer += item.toString();
				}
				if (i < arr.size() - 1) {
					buffer += delimiter;
				}
			}
			if (includeBrackets) {
				buffer = "[" + buffer + "]";
			}
			String[] extra_arr = _ArraySplice(extra, 0, 0, buffer);
			_H.print(extra_arr);
			return;
		}

		public static class DirectionsUtil {
			static String ToString(Direction direction) {
				if (direction == Direction.FROM_NORTH || direction == Direction.TO_SOUTH) {
					return "north";
				} else if (direction == Direction.FROM_EAST || direction == Direction.TO_WEST) {
					return "east";
				} else if (direction == Direction.FROM_SOUTH || direction == Direction.TO_NORTH) {
					return "south";
				} else if (direction == Direction.FROM_WEST || direction == Direction.TO_EAST) {
					return "west";
				} else if (direction == Direction.UNDEFINED) {
					return "undefined";
				} else {
					return "unknown";
				}
			}
			static final char char_n = 'N';
			static final char char_e = 'E';
			static final char char_s = 'S';
			static final char char_w = 'W';
			static Direction GetFromCharacter(char directionChar) {
				if (directionChar == char_n) {
					return Direction.FROM_NORTH;
				} else if (directionChar == char_e) {
					return Direction.FROM_EAST;
				} else if (directionChar == char_s) {
					return Direction.FROM_SOUTH;
				} else if (directionChar == char_w) {
					return Direction.FROM_WEST;
				} else {
					return Direction.UNDEFINED;
				}
			}
		}
	}
	
	public static class Robot implements Visitor {
		List<Item> inventory = new ArrayList<Item>();
		int gold = 0;
		public void Robot() {
			_H.print("New Robot created.");
			return;
		}

		public void tell(String message) {
			_H.print(message);
		}
		public char getChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
			_H.print(descriptionOfChoices);
			ArrayList<String> choiceArrayAsStringsList = new ArrayList<String>();
			for (char theCharacter: arrayOfPossibleChoices) {
				choiceArrayAsStringsList.add(Character.toString(theCharacter));
			}
			// choiceArrayAsStringsList.add("POP");
			// final String thing = choiceArrayAsStringsList.toString();
			// _H.print(thing);
			// _H.PrintArrayList(choiceArrayAsStringsList);
			_H.print();
			_H.printList(choiceArrayAsStringsList.toArray());
			boolean valid = false;
			String userChoice = "";
			final char defaultChoice = '.';
			final int MAX_ATTEMPTS = 1;
			final boolean shouldSayTooManyAttempts = false;
			int attempts = 0;
			while(!valid) {
				userChoice = _H.GetUserInput("Enter your choice: ", "endl=");
				attempts += 1;
				if (choiceArrayAsStringsList.contains(userChoice)) {
					valid = true;
				} else if (attempts >= MAX_ATTEMPTS) {
					if (shouldSayTooManyAttempts) {
						_H.print("Too many invalid choices...");
					}
					break;
				} else {
					_H.print("Invalid choice.  Please try again.");
				}
			}
			if (valid) {
				return userChoice.charAt(0);
			} else {
				return defaultChoice;
			}
		}
		public boolean giveItem(Item itemGivenToVisitor) {
			try {
				this.inventory.add(itemGivenToVisitor);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		public boolean hasIdenticalItem(Item itemToCheckFor) {
			for (Item item : inventory) {
				if (item == itemToCheckFor) {
					return true;
				}
			}
			return false;
		}
		public boolean hasEqualItem(Item itemToCheckFor) {
			for (Item item : inventory) {
				if (item.equals(itemToCheckFor)) {
					return true;
				}
			}
			return false;
		}
		public void giveGold(int numberOfPiecesToGive) {
			if (numberOfPiecesToGive > 10) {
				numberOfPiecesToGive = 10;
			}
			this.gold += numberOfPiecesToGive;
			return;
		}
		public int takeGold(int numberOfPiecesToTake) {
			if (numberOfPiecesToTake > this.gold) {
				numberOfPiecesToTake = this.gold;
			}
			if (numberOfPiecesToTake > 10) {
				numberOfPiecesToTake = 10;
			}
			this.gold -= numberOfPiecesToTake;
			return numberOfPiecesToTake;
		}
		
	}



	public int numberOfTimesVisited = 0;
	public Random randomGen = new Random();
	public int waterLevel = 5;


	public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
		this.numberOfTimesVisited += 1;

		// print the direction which the visitor came from
		visitor.tell("You came from the " + _H.DirectionsUtil.ToString(directionVistorArrivesFrom) + " direction.");

		final Item cheehoTokenItem = new Item("CheehoToken");
		visitor.giveItem(cheehoTokenItem);

		final int MAX_ATTEMPTS = 3;

		visitor.tell("You look around the room, and see a fountain.");
		if (this.numberOfTimesVisited > 1) {
			visitor.tell("You think you have been here before... that fountain is rather distinctive.");
		}
		boolean hasCup = false;
		if (this.waterLevel > 0) {
			visitor.tell("There is a stack of cups on a table next to the fountain.");
			final String choiceText1 = "(T) Take a cup from the stack of cups.\n"
									  +"(D) Drink from the fountain.\n"
									  +"(C) Carry on.";
			final char char_t = 'T';
			final char char_d = 'D';
			final char char_c = 'C';
			final char defaultChoice = 'C';
			int attempts = 0;
			boolean validChoice = false;
			char choiceGiven1 = defaultChoice;
			while(!validChoice) {
				final char temp_choice = visitor.getChoice(choiceText1, new char[]{char_t, char_d, char_c});
				validChoice = (temp_choice == char_t || temp_choice == char_d || temp_choice == char_c);
				attempts += 1;
				if (validChoice) {
					choiceGiven1 = temp_choice;
					break;
				} else if (attempts >= MAX_ATTEMPTS) {
					visitor.tell("You have made too many invalid choices.\n You will now be forced to carry on.");
					break;
				} else {
					visitor.tell("Invalid choice. Please try again.");
				}
			}
			if (choiceGiven1 == char_t) {
				visitor.tell("You take a cup from the stack of cups.");
				hasCup = true;
			} else if (choiceGiven1 == char_d) {
				visitor.tell("You drink from the fountain. (No cup? Gross...)");
				this.waterLevel -= 1;
			} else if (choiceGiven1 == char_c) {
				visitor.tell("You carry on.");
			}
		}

		final boolean visitorAlreadyHas_aCupOfWater = visitor.hasEqualItem(new Item("Cup of Water"));
		if (visitorAlreadyHas_aCupOfWater) {
			visitor.tell("Despite the fact that you already have a cup of water... ");
		}
		if (hasCup) {
			visitor.tell("You dip the cup into the fountain and collect some water.");
			visitor.tell(" + 1 \"Cup of Water\"");
			visitor.giveItem(new Item("Cup of Water"));
			this.waterLevel -= 1;
		}

		if (this.waterLevel <= 0) {
			visitor.tell("The fountain is empty. Aww.");
			visitor.tell("You take a seat for a while...");
		}

		visitor.tell("\n\n");

		String choiceText2 = "Rested up, you decide to continue on in the...\n"
							+"(N) North\n"
							+"(E) East\n"
							+"(S) South\n"
							+"(W) West\n"
							+" direction...";
		final char char_n = 'N';
		final char char_e = 'E';
		final char char_s = 'S';
		final char char_w = 'W';
		// boolean differentDirectionAsOrigin = false;
		Direction directionWantsToLeaveTowards = Direction.UNDEFINED;
		boolean exitLoop = false;
		while (!exitLoop) {
			final char choiceGiven = visitor.getChoice(choiceText2, new char[]{char_n, char_e, char_s, char_w});
			_H.print("You answered: " + choiceGiven);
			final boolean validChoice = (choiceGiven == char_n || choiceGiven == char_e || choiceGiven == char_s || choiceGiven == char_w);
			final Direction directionChosen = _H.DirectionsUtil.GetFromCharacter(choiceGiven);
			directionWantsToLeaveTowards = directionChosen;
			exitLoop = validChoice;
			// if (!differentDirectionAsOrigin) {
			// 	visitor.tell("You cannot go back that way... because reasons.");
			// }
		}
		
		visitor.tell("You will leave in the " + _H.DirectionsUtil.ToString(directionWantsToLeaveTowards) + " direction.");
		return directionWantsToLeaveTowards;
	}



	public static void main(String[] program_args) {
		// _H.print("Hello, ", "World", "!");
		// final String answer = _H.GetUserInput("What is your name?\n > ", "endl=");
		// _H.print("Hello, ", answer, "!");

		Room_ec221003 someRoom = new Room_ec221003();
		Visitor someVisitor = new Robot();
		someRoom.visit(someVisitor, Direction.FROM_EAST);

		return;
	}
}


// "End of File";
