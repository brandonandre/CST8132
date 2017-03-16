
// Brandon Andre

public class Guitar {

	public final int WIRES = 6; //How many pegs and wires will be required.
	
	//Declare the main board variable
	private Board board; 
	//Declare the wires array variable
	private Wire wires[];
	//Declare the pegs array variable.
	private Peg pegs[];
	
    // sixth Wire (E6), sounds an E2 note, which is midi 40
    public final static int MIDI_E2 = 40;
    // fifth Wire (A), sounds an A2 note, which is midi 45
    public final static int MIDI_A2 = 45;
    // fourth Wire (D), sounds a D3 note, which is midi 50
    public final static int MIDI_D3 = 50;
    // third Wire (G), sounds a G3 note, which is midi 55
    public final static int MIDI_G3 = 55;
    // second Wire (B), sounds a B3 note, which is midi 59
    public final static int MIDI_B3 = 59;
    // first Wire (E1), sounds an E4 note, which is midi 64
    public final static int MIDI_E4 = 64;

	public Guitar(){
		//Default constructor to build the guitar, The guitar has to create all the components that a guitar requires.
	
		//Instantiate the board variable.
		board = new Board();
		//Instantiate the wire variable
		wires = new Wire[WIRES+1];
		
		//Initialize the wire variable.
		wires[1] = new Wire(board, MIDI_E4);
		wires[2] = new Wire(board, MIDI_B3);
		wires[3] = new Wire(board, MIDI_G3);
		wires[4] = new Wire(board, MIDI_D3);
		wires[5] = new Wire(board, MIDI_A2);
		wires[6] = new Wire(board, MIDI_E2);

		//Initialize pegs
		pegs = new Peg[7];
		for(int i=1; i<pegs.length; i++){
			//Create an instance of peg, pass the corresponding wire to it's constructor.
			pegs[i] = new Peg(wires[i]);
		}
	}
    
	public void pluck(int wireNum){
		//Using the array find the wire object then 'pluck' the corresponding wire.
		wires[wireNum].pluck();
	}
	
	public void turn(int pegNum, int deltaTension){
		//Using the pegs array, change the tension based on it's current position.
		pegs[pegNum].turn(deltaTension);
	}

}
