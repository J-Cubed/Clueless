package com.clueless;


public class Player {
		String name;
		String codename;
		String id;
		Location location;
		Card[] cards = new Card[3];
		boolean suggestionMadeHere;
		boolean hasTurn;
		boolean moved = false;
		boolean disabled = true;
		boolean notActivated = true;
		private boolean isAdmin = false;
		Card[] suggestion = new Card[3];
//		ArrayList<String> suggestion = new ArrayList<String>(3);
		Card[] accusation = new Card[3];
		public Player(String name, String codename, Location initialLocation) {
			this.name = name;
			this.codename = codename;
			location = initialLocation;
		}//end constructor
		public void move(Location newLocation) {
			if(hasTurn || moved) {
				location = newLocation;
				suggestionMadeHere = false;
			}//end if
			else
				System.out.println("You cannot move because it is not your turn.");
			moved = false;
		}//end move()
		public void endTurn() {
			hasTurn = false;
			moved = false;
		}//end endTurn()
		public void makeSuggestion(Card player, Card weapon, Card location) {
			if(hasTurn && !suggestionMadeHere) {
				suggestion[0] = player;
				suggestion[1] = weapon;
				suggestion[2] = location;
//				suggestion.add(0, player.codename);
//				suggestion.add(1, weapon.name);
//				suggestion.add(2, location.name);
				
				suggestionMadeHere = true;
			}//end if
			else {
				System.out.println("You cannot make a suggestion because it is not your turn,");
				System.out.println("or you have already made a suggestion in this location.");
			}//end else
		}//end makeSuggestion()
		public void makeAccusation(Card accusedPlayer, Card accusedWeapon, Card accusedLocation) {
			if(hasTurn) {
				accusation[0] = accusedPlayer;
				accusation[1] = accusedWeapon;
				accusation[2] = accusedLocation;
			}//end if
			else
				System.out.println("You cannot make an accusation because it is not your turn.");
		}//end makeAccusation()
		
		public Card[] proveOrDisproveSuggestion(Card[] attemptedSuggestion) {
			Card[] matches = new Card[3];
			for (int i = 0; i < attemptedSuggestion.length; i++) {
				for (int n = 0; n < cards.length; n++) {
					if (attemptedSuggestion[i] == cards[n]) {
						matches[i] = attemptedSuggestion[i];
					}//end if
				}//end for
			}//end for
			if ((matches[0] == null) && (matches[1] == null) && (matches[2] == null))
				System.out.println(name + " cannot disprove the suggestion");
			return matches;
		}//end proveOrDisproveSuggestion()
		
		public Card[] proveOrDisproveAccusation(Card[] attemptedAccusation) {
			Card[] matches = new Card[3];
			for (int i = 0; i < attemptedAccusation.length; i++) {
				for (int n = 0; n < cards.length; n++) {
					if (attemptedAccusation[i] == cards[n]) {
						matches[i] = attemptedAccusation[i];
					}//end if
				}//end for
			}//end for
			if ((matches[0] == null) && (matches[1] == null) && (matches[2] == null))
				System.out.println(name + " cannot disprove the accusation");
			return matches;
		}//end proveOrDisproveSuggestion()
		
		public Location getLocation() {
			return location;
		}//end getLocation()
		public void disable() {
			disabled = true;
		}//end disable()
		public Card[] getCards(){
			return cards;
		}//end showCards()
		public String getId() {
			return id;
		}
		public void setId(String s) {
			id = s;
		}
		public void makeAdmin() {
			isAdmin = true;
		}
		public boolean isAdmin() {
			return isAdmin;
		}
	}//end Player class
