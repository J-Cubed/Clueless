package com.clueless;

public class BillardRoom extends Location {
		public BillardRoom (String name, String codename) {
			super(name, codename);
		}//end constructor
		public void setMoveOptions(Location option1, Location option2, Location option3, Location option4) {
			adjacent[0] = null;
			adjacent[1] = null;
			adjacent[2] = null;
			adjacent[3] = null;
			int count = 0;
			//if (option1.isOccupied() == false){
				adjacent[count] = option1;
				count++;
			//}//end if
			//if (option2.isOccupied() == false){
				adjacent[count] = option2;
				count++;
			//}//end if
			//if (option3.isOccupied() == false){
				adjacent[count] = option3;
				count++;
			//}//end if
			//if (option4.isOccupied() == false){
				adjacent[count] = option4;
				count++;
			//}//end if
		}//end setToMoveOptions()
}//end BillardRoom class
