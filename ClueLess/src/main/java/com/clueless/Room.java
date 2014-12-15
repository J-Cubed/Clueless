package com.clueless;

public class Room extends Location {
		public Room (String name, String codename) {
			super(name, codename);
		}//end constructor
		public void setMoveOptions(Location option1, Location option2, Location option3) {
			adjacent[0] = null;
			adjacent[1] = null;
			adjacent[2] = null;
			adjacent[3] = null;
			int count = 0;
			if (option1.isOccupied() == false){
				adjacent[count] = option1;
				count++;
			}//end if
			if (option2.isOccupied() == false){
				adjacent[count] = option2;
				count++;
			}//end if
			if (option3.name.equals("Study") ||  option3.name.equals("Lounge") || option3.name.equals("Conservatory") || option3.name.equals("Kitchen") || option3.isOccupied() == false){
				adjacent[count] = option3;
				count++;
			}//end if
			
		}//end setToMoveOptions()
	}//end Room class
