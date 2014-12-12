package com.clueless;

import java.util.Random;
import java.util.ArrayList;

public class clueLessModel {
	private static clueLessModel instance = null;
	private static ArrayList<String> status;
	private static ArrayList<String> moveHistory;

	static int turn;
	static boolean active;
	static CaseFile caseFile;
	static Card studyCard;
	static Card hallCard;
	static Card loungeCard;
	static Card libraryCard;
	static Card billardRoomCard;
	static Card diningRoomCard;
	static Card conservatoryCard;
	static Card ballRoomCard;
	static Card kitchenCard;
	static Card candleStick;
	static Card wrench;
	static Card rope;
	static Card revolver;
	static Card knife;
	static Card leadPipe;
	static Card missS;
	static Card profP;
	static Card colM;
	static Card mrsP;
	static Card mrG;
	static Card mrsW;
	static Room study;
	static Room hall;
	static Room lounge;
	static Room library;
	static BillardRoom billardRoom;
	static Room diningRoom;
	static Room conservatory;
	static Room ballroom;
	static Room kitchen;
	static Player player1;
	static Player player2;
	static Player player3;
	static Player player4;
	static Player player5;
	static Player player6;
	static Player[] playerList;
	
	public static synchronized clueLessModel getInstance() {
        if (instance == null) {
            instance = new clueLessModel();
        }
 
        return instance;
    }
	
	private clueLessModel() {
		status = new ArrayList<String>();
		status.add("***Begin Game***");
		
		moveHistory = new ArrayList<String>();
		study = new Room("Study");
		hall = new Room("Hall");
		lounge = new Room("Lounge");
		library = new Room("Library");
		billardRoom = new BillardRoom("Billard Room");
		diningRoom = new Room("Dining Room");
		conservatory = new Room("Conservatory");
		ballroom = new Room("Ballroom");
		kitchen = new Room("kitchen");
		Location hallway1 = new Location("Hallway One");
		Location hallway2 = new Location("Hallway Two");
		Location hallway3 = new Location("Hallway Three");
		Location hallway4 = new Location("Hallway Four");
		Location hallway5 = new Location("Hallway Five");
		Location hallway6 = new Location("Hallway Six");
		Location hallway7 = new Location("Hallway Seven");
		Location hallway8 = new Location("Hallway Eight");
		Location hallway9 = new Location("Hallway Nine");
		Location hallway10 = new Location("Hallway Ten");
		Location hallway11 = new Location("Hallway Eleven");
		Location hallway12 = new Location("Hallway Twelve");
		study.setMoveOptions(hallway1, hallway3, billardRoom);
		hallway1.setMoveOptions(study, hall);
		hall.setMoveOptions(hallway1, hallway2, hallway4);
		hallway2.setMoveOptions(hall, lounge);
		lounge.setMoveOptions(hallway2, hallway3, billardRoom);
		hallway3.setMoveOptions(study, library);
		hallway4.setMoveOptions(hall, billardRoom);
		hallway5.setMoveOptions(lounge, diningRoom);
		library.setMoveOptions(hallway3, hallway6, hallway8);
		billardRoom.setMoveOptions(hallway4, hallway6, hallway7, hallway9);
		diningRoom.setMoveOptions(hallway5, hallway7, hallway10);
		hallway8.setMoveOptions(library, conservatory);
		hallway9.setMoveOptions(billardRoom, ballroom);
		hallway10.setMoveOptions(diningRoom, kitchen);
		conservatory.setMoveOptions(hallway8, hallway11, billardRoom);
		hallway11.setMoveOptions(conservatory, ballroom);
		ballroom.setMoveOptions(hallway11, hallway9, hallway12);
		kitchen.setMoveOptions(hallway12, hallway10, billardRoom);
		player1 = new Player("Miss Scarlet", hallway2);
		player2 = new Player("Prof. Plum", hallway3);
		player3 = new Player("Col. Mustard", hallway5);
		player4 = new Player("Mrs. Peacock", hallway8);
		player5 = new Player("Mr. Green", hallway11);
		player6 = new Player("Mrs. White", hallway12);
		
		playerList = new Player[6];
		playerList[0] = player1;
		playerList[1] = player2;
		playerList[2] = player3;
		playerList[3] = player4;
		playerList[4] = player5;
		playerList[5] = player6;
		
		moveHistory.add(player1.name + " started in " + hallway2.name);
		moveHistory.add(player2.name + " started in " + hallway3.name);
		moveHistory.add(player3.name + " started in " + hallway5.name);
		moveHistory.add(player4.name + " started in " + hallway8.name);
		moveHistory.add(player5.name + " started in " + hallway11.name);
		moveHistory.add(player6.name + " started in " + hallway12.name);
		
		studyCard = new Card("Study", CardType.ROOM);
		hallCard = new Card("Hall", CardType.ROOM);
		loungeCard = new Card("Lounge", CardType.ROOM);
		libraryCard = new Card("Library", CardType.ROOM);
		billardRoomCard = new Card("Billard Room", CardType.ROOM);
		diningRoomCard = new Card("Dining Room", CardType.ROOM);
		conservatoryCard = new Card("Conservatory", CardType.ROOM);
		ballRoomCard = new Card("Ballroom", CardType.ROOM);
		kitchenCard = new Card("Kitchen", CardType.ROOM);
		candleStick = new Card("Candle Stick", CardType.WEAPON);
		wrench = new Card("Wrench", CardType.WEAPON);
		rope = new Card("Rope", CardType.WEAPON);
		revolver = new Card("Revolver", CardType.WEAPON);
		knife = new Card("Knife", CardType.WEAPON);
		leadPipe = new Card("Lead Pipe", CardType.WEAPON);
		missS = new Card("Miss Scarlet", CardType.PLAYER);
		profP = new Card("Prof. Plum", CardType.PLAYER);
		colM = new Card("Col. Mustard", CardType.PLAYER);
		mrsP = new Card("Mrs. Peacock", CardType.PLAYER);
		mrG = new Card("Mr. Green", CardType.PLAYER);
		mrsW = new Card("Mrs. White", CardType.PLAYER);
		Card[] rooms = {studyCard, hallCard, loungeCard, libraryCard, billardRoomCard, diningRoomCard, conservatoryCard, ballRoomCard, kitchenCard};
		Card[] weapons = {candleStick, wrench, rope, revolver, knife, leadPipe};
		Card[] players = {missS, profP, colM, mrsP, mrG, mrsW};
		shuffleArray(rooms);
		shuffleArray(weapons);
		shuffleArray(players);
		caseFile = new CaseFile(players[0], weapons[0], rooms[0]);
		Card[] toPlayers = new Card[18];
		int x = 0;
		for (int i = 1; i < rooms.length; i++){
			toPlayers[x] = rooms[i];
			x++;
		}//end for
		for (int i = 1; i < weapons.length; i++){
			toPlayers[x] = weapons[i];
			x++;
		}//end for
		for (int i = 1; i < players.length; i++){
			toPlayers[x] = players[i];
			x++;
		}//end for
		shuffleArray(toPlayers);
		player1.cards[0] = toPlayers[0];
		player1.cards[1] = toPlayers[1];
		player1.cards[2] = toPlayers[2];
		player2.cards[0] = toPlayers[3];
		player2.cards[1] = toPlayers[4];
		player2.cards[2] = toPlayers[5];
		player3.cards[0] = toPlayers[6];
		player3.cards[1] = toPlayers[7];
		player3.cards[2] = toPlayers[8];
		player4.cards[0] = toPlayers[9];
		player4.cards[1] = toPlayers[10];
		player4.cards[2] = toPlayers[11];
		player5.cards[0] = toPlayers[12];
		player5.cards[1] = toPlayers[13];
		player5.cards[2] = toPlayers[14];
		player6.cards[0] = toPlayers[15];
		player6.cards[1] = toPlayers[16];
		player6.cards[2] = toPlayers[17];
		turn = 1;
		active = false;
		System.out.println();
		System.out.println("CLUELESS: by J-Cubed");
		System.out.println();
		beginTurn();
	}//end main()
	
	public ArrayList<String> getStatus() {
		return status;
	}
	
	public ArrayList<String> getMoveHistory() {
		return moveHistory;
	}
	
	public static Player getCurrentPlayer() {
		switch(turn){
			case 1: return player1;
			case 2: return player2;
			case 3: return player3;
			case 4: return player4;
			case 5: return player5;
			case 6: return player6;
		}//end switch
		return null;
	}
	
	public void endTurn() {
		Player player = getCurrentPlayer();
		String statusMessage = "";
		
		player.endTurn();
		
		statusMessage = "***End " + player.name + "'s turn***";
		
		status.add(statusMessage);
		System.out.println(statusMessage);
		System.out.println();
		
		if (turn == 6)
			turn = 1;
		else
			turn++;
		
		beginTurn();
	}
	
	public void beginTurn() {
		Player player = getCurrentPlayer();
		String statusMessage = "";
		
		if(player.disabled){
			statusMessage = "***" + player.name + " made an incorrect accusation earlier, and therefore has been skipped ***";
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();
			this.endTurn();
		}//end if
		else {
			player.hasTurn = true;
			player.moved = false;
			
			statusMessage = "***Begin " + player.name + "'s turn***";
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();
			
			//System.out.println("Select Action: 1 = MOVE, 2 = MAKE A SUGGESTION");
			//System.out.println("3 = MAKE AN ACCUSATION, 4 = SHOW YOUR CARDS");
			//System.out.println("5 = END YOUR TURN");
		}
	}
	
	public void endGame() {
		String statusMessage = "";
		
		statusMessage = "***GAME OVER***";
		
		status.add(statusMessage);
		System.out.println(statusMessage);
		System.out.println();
		
		active = false;
		instance = null;
	}
	
	public boolean hasMoved() {
		Player player = getCurrentPlayer();
		
		return player.moved;
	}
	
	public ArrayList<String> getMoveOptions() {
		Player player = getCurrentPlayer();
		
		if(player.hasTurn){
			Location current =  player.getLocation();
			Location[] options = current.moveOptions();
			Location one = options[0];
			Location two = options[1];
			Location three = options[0];
			Location four = options[0];
			ArrayList<String> outputOptions = new ArrayList<String>();
			
			System.out.print("1 = " + one.name + ", 2 = " + two.name);
			
			outputOptions.add(one.name);
			outputOptions.add(two.name);
			
			if (options[2] != null){
				three = options[2];
				System.out.print(", 3 = " + three.name);
				
				outputOptions.add(three.name);
			}//end if
			if (options[3] != null){
				four = options[3];
				System.out.print(", 4 = " + four.name);
				
				outputOptions.add(four.name);
			}//end if
			
			System.out.println();	
			
			return outputOptions;
		}
		
		return null;
	}

	public void move(int movePlace) throws Exception {
		Player player = getCurrentPlayer();
		String errorMessage = "";
		String statusMessage = "";
		
		if(player.hasTurn){
			System.out.println("");
			
			if (player.moved) {
				errorMessage = "You can only move once per turn";
				
				System.out.println(errorMessage);
				System.out.println();
				
				throw new Exception(errorMessage);
			}//end if
			else {
				System.out.println("Move to:");
				System.out.println();
				
				Location current =  player.getLocation();
				Location[] options = current.moveOptions();
				Location one = options[0];
				Location two = options[1];
				Location three = options[0];
				boolean threeTrue = false;
				Location four = options[0];
				boolean fourTrue = false;

				if (movePlace == 1){
					player.move(one);
					player.moved = true;

					statusMessage = player.name + " has moved to the " + one.name;
					
					moveHistory.add(statusMessage);
					System.out.println(statusMessage);
				}//end if
				else if (movePlace == 2){
					player.move(two);
					player.moved = true;
					
					statusMessage = player.name + " has moved to the " + two.name;
					
					moveHistory.add(statusMessage);
					System.out.println(statusMessage);
				}//end if
				else if (movePlace == 3 && threeTrue){
					player.move(three);
					player.moved = true;
					
					statusMessage = player.name + " has moved to the " + three.name;
					
					moveHistory.add(statusMessage);
					System.out.println(statusMessage);
				}//end if
				else if (movePlace == 4 &&  fourTrue){
					player.move(four);
					player.moved = true;
					
					statusMessage = player.name + " has moved to the " + four.name;
					
					moveHistory.add(statusMessage);
					System.out.println(statusMessage);
				}//end if
				else {
					errorMessage = "Invalid input, try again";
					
					System.out.println(errorMessage);
					System.out.println();
					
					throw new Exception(errorMessage);
				}
			}//end else
		}//end if
	}
	
	public ArrayList<String> getPlayerCardOptions() {
		Player player = getCurrentPlayer();
		
		if(player.hasTurn){
			ArrayList<String> outputOptions = new ArrayList<String>();
			
			System.out.println("Select cards to suggest/accuse:");
			System.out.println("Player: 1 = Miss Scarlet, 2 = Prof. Plum");
			System.out.println("3 = Col. Mustard, 4 = Mrs. Peacock");
			System.out.println("5 = Mr. Green, 6 = Mrs. White");
			
			System.out.println();
			
			outputOptions.add("Miss Scarlet");
			outputOptions.add("Prof. Plum");
			outputOptions.add("Col. Mustard");
			outputOptions.add("Mrs. Peacock");
			outputOptions.add("Mr. Green");
			outputOptions.add("Mrs. White");
			
			return outputOptions;
		}
		
		return null;
	}
	
	public ArrayList<String> getWeaponCardOptions() {
		Player player = getCurrentPlayer();
		
		if(player.hasTurn){
			ArrayList<String> outputOptions = new ArrayList<String>();
			
			System.out.println("Weapon: 1 = Candle Stick, 2 = Wrench");
			System.out.println("3 = Rope, 4 = Revolver");
			System.out.println("5 = Knife, 6 = Lead Pipe");
			
			System.out.println();
			
			outputOptions.add("Candle Stick");
			outputOptions.add("Wrench");
			outputOptions.add("Rope");
			outputOptions.add("Revolver");
			outputOptions.add("Knife");
			outputOptions.add("Lead Pipe");	
			
			return outputOptions;
		}
		
		return null;
	}
	
	public ArrayList<String> getPlaceCardOptions() {
		Player player = getCurrentPlayer();
		
		if(player.hasTurn){
			ArrayList<String> outputOptions = new ArrayList<String>();
			
			System.out.println("Room: 1 = Study, 2 = Hall");
			System.out.println("3 = Lounge, 4 = Library");
			System.out.println("5 = Billard Room, 6 = Dining Room");
			System.out.println("7 = Conservatory, 8 = Ballroom");
			System.out.println("9 = Kitchen");
			
			System.out.println();
			
			outputOptions.add("Study");
			outputOptions.add("Hall");
			outputOptions.add("Lounge");
			outputOptions.add("Library");
			outputOptions.add("Billiard Room");
			outputOptions.add("Dining Room");	
			outputOptions.add("Conservatory");
			outputOptions.add("Ballroom");
			outputOptions.add("Kitchen");
			
			return outputOptions;
		}
		
		return null;
	}
	
	public String getCurrentPlace() {
		Player player = getCurrentPlayer();
		String currentPlace = player.getLocation().name;
		
		System.out.println("Current Place: " + currentPlace);
		System.out.println();
		
		return currentPlace;
	}
	
	public static boolean inRoom() {
		Player player = getCurrentPlayer();
		
		Location place = player.getLocation();

		boolean inRoom = true;
		if (place != study && place != hall && place != lounge && place != library && place != billardRoom && place != diningRoom && place != conservatory
				&& place != ballroom && place != kitchen) {
			inRoom = false;
		}
	
		return inRoom;
	}
	
	public boolean canSuggest() {
		Player player = getCurrentPlayer();
		
		if (inRoom() && !player.suggestionMadeHere)
			return true;
		
		return false;
	}

	public void suggest(int suggestPlayer, int suggestWeapon) throws Exception {
		Player player = getCurrentPlayer();
		String errorMessage = "";
		String statusMessage = "";
		
		if(player.hasTurn){
			if (player.suggestionMadeHere) {
				errorMessage = "You cannot make a suggestion because you have already made a suggestion in this location.";
				
				System.out.println(errorMessage);
				System.out.println();
				
				throw new Exception(errorMessage);
			}//end if
			else {
				Card playerS;
				if (suggestPlayer == 1)
					playerS = missS;
				else if (suggestPlayer == 2)
					playerS = profP;
				else if (suggestPlayer == 3)
					playerS = colM;
				else if (suggestPlayer == 4)
					playerS = mrsP;
				else if (suggestPlayer == 5)
					playerS = mrG;
				else
					playerS = mrsW;
					
				Card playerW;
				if (suggestWeapon == 1)
					playerW = candleStick;
				else if (suggestWeapon == 2)
					playerW = wrench;
				else if (suggestWeapon == 3)
					playerW = rope;
				else if (suggestWeapon == 4)
					playerW = revolver;
				else if (suggestWeapon == 5)
					playerW = knife;
				else
					playerW = leadPipe;
				
				Location place = player.getLocation();
				Card playerR = studyCard;//placeholder

				if (place == study)
					playerR = studyCard;
				else if (place == hall)
					playerR = hallCard;
				else if (place == lounge)
					playerR = loungeCard;
				else if (place == library)
					playerR = libraryCard;
				else if (place == billardRoom)
					playerR = billardRoomCard;
				else if (place == diningRoom)
					playerR = diningRoomCard;
				else if (place == conservatory)
					playerR = conservatoryCard;
				else if (place == ballroom)
					playerR = ballRoomCard;
				else if (place == kitchen)
					playerR = kitchenCard;
				else{
					errorMessage = "You must be in a room to make a suggestion";
					
					System.out.println(errorMessage);
					System.out.println();
					
					throw new Exception(errorMessage);
				}//end else
				
				if(inRoom()){
					player.makeSuggestion(playerS, playerW, playerR);
					
					statusMessage = player.name + " has suggested: " + playerS.name + " with the " + playerW.name + " in the " + playerR.name;
					
					status.add(statusMessage);
					System.out.println(statusMessage);
					System.out.println();
					
					for (Player p : playerList) {
						Card[] c = p.proveOrDisproveSuggestion(player.suggestion);
						for (int i = 0; i < 3; i++) {
							if (c[i] != null) {
								statusMessage = "Suggestion disproved by " + p.name + "'s " + c[i].name + " card";
								
								status.add(statusMessage);
								System.out.println(statusMessage);
								System.out.println();
								
								endTurn();
								
								return;
							}
						}
					}
					
					statusMessage = "No player was able to disprove your suggestion";
					
					status.add(statusMessage);
					System.out.println(statusMessage);
					System.out.println();

				}//end else
			}//end if
		}//end if
	}	

	public boolean accuse(int suggestPlayer, int suggestWeapon, int place) throws Exception {
		Player player = getCurrentPlayer();
		String statusMessage = "";
		
		if(player.hasTurn){
			Card playerS;
			if (suggestPlayer == 1)
				playerS = missS;
			else if (suggestPlayer == 2)
				playerS = profP;
			else if (suggestPlayer == 3)
				playerS = colM;
			else if (suggestPlayer == 4)
				playerS = mrsP;
			else if (suggestPlayer == 5)
				playerS = mrG;
			else
				playerS = mrsW;

			Card playerW;
			if (suggestWeapon == 1)
				playerW = candleStick;
			else if (suggestWeapon == 2)
				playerW = wrench;
			else if (suggestWeapon == 3)
				playerW = rope;
			else if (suggestWeapon == 4)
				playerW = revolver;
			else if (suggestWeapon == 5)
				playerW = knife;
			else
				playerW = leadPipe;
			
			Card playerR;
			if (place == 1)
				playerR = studyCard;
			else if (place == 2)
				playerR = hallCard;
			else if (place == 3)
				playerR = loungeCard;
			else if (place == 4)
				playerR = libraryCard;
			else if (place == 5)
				playerR = billardRoomCard;
			else if (place == 6)
				playerR = diningRoomCard;
			else if (place == 7)
				playerR = conservatoryCard;
			else if (place == 8)
				playerR = ballRoomCard;
			else
				playerR = kitchenCard;
			
			player.makeAccusation(playerS, playerW, playerR);
			
			statusMessage = player.name + " has accused: " + playerS.name + " with the " + playerW.name + " in the " + playerR.name;
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();
			
			for (Player p : playerList) {
				Card[] c = p.proveOrDisproveAccusation(player.accusation);
				for (int i = 0; i < 3; i++) {
					if (c[i] != null) {
						statusMessage = "Accusation disproved by " + p.name + "'s " + c[i].name + " card";
						
						status.add(statusMessage);
						System.out.println(statusMessage);
						System.out.println();
						
						player.disable();
						endTurn();
						
						return false;
					}
				}
			}
			
			statusMessage = "No player was able to disprove your accusation";
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();

			active = false;
			Card[] finale = caseFile.reveal();		
			statusMessage = finale[0].name + " committed the murder " + " with the " + finale[1].name + " in the " + finale[2].name;
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();
			
			statusMessage = "*** " + player.name + " wins! ***";
			
			status.add(statusMessage);
			System.out.println(statusMessage);
			System.out.println();
			
			return true;
		}//end if
		
		return false;
	}
	
	public static boolean isGameActive() {
		return active;
	}
	
	public ArrayList<String> getCaseFile() {
		Card[] finale = caseFile.reveal();
		ArrayList<String> outputCards = new ArrayList<String>();
		
		for(Card x: finale){
			outputCards.add(x.name);
		}//end for
		
		return outputCards;
	}
			
	public ArrayList<String> getCards() {
		Player player = getCurrentPlayer();
		
		if(player.hasTurn){
			Card[] playerCards = player.getCards();
			ArrayList<String> outputCards = new ArrayList<String>();
			
			for(Card x: playerCards){
				outputCards.add(x.name);
			}//end for
			
			return outputCards;
		}
		
		return null;
	}

	// Implementing Fisher–Yates shuffle
	static void shuffleArray(Card[] ar){
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}//end for
	}//end shuffleArray
}//end clueLessModel class
