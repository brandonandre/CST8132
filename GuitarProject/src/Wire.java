
public class Wire{

	//Declare the tension and board variable. The board variable is passed on from the Guitar class.
	private int tension;
	private Board board;
	
	public Wire(Board board, int tension){
		//Receive the board class.
		this.board = board;
		this.tension = tension;
	}
	
	public void vibrate(){
		//The vibration creates the sound, based on the tension changes the pitch.
		board.soundNote(tension);
	}
	
	public void pluck(){
		//Whenever the guitar is plucked it will vibrate the string. 
		vibrate();
	}
	
	public void changeTension(int deltaTension){
		//Change the tension based on it's current position.
		tension+=deltaTension;
	}

}
