
public class Peg {

	//Declare the wire variable, this is passed on the from the Guitar class.
	private Wire wire;
	
	public Peg(Wire wire) {
		//Default constructor, when Peg is created pass the wire that pairs with the peg. 
		this.wire = wire;
	}
	
	public void turn(int deltaTension){
		//When the peg is turned change the wire that is attached to the peg. 
		wire.changeTension(deltaTension);
	}

}
