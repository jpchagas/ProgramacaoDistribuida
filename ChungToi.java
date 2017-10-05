import java.util.ArrayList;

public class ChungToi {
	
	private static final int colorP1 = 0;
	private static final int colorP2 = 1;
	
	private int numJogadores;
	private Player p1,p2;
	private ArrayList<String> board;
	private int turno;
	
	public ChungToi() {
		turno = 1;
		numJogadores = 0;
		board = new ArrayList<String>(9);
		board.add(0, ".");
		board.add(1, ".");
		board.add(2, ".");
		board.add(3, ".");
		board.add(4, ".");
		board.add(5, ".");
		board.add(6, ".");
		board.add(7, ".");
		board.add(8, ".");
	}
	
	public int getNumJogadores(){
		return numJogadores;
	}
	
	public void setNumJogadores(int num) {
		this.numJogadores = num;
	}
	
	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}
	
	public ArrayList<String> findBoard(){
		return board;
	}

	public String getBoard() {
		String sboard = "Mapa:\n";
		for (int i = 0; i < board.size(); i++) {
			if(i==2 || i==5) {
				sboard += board.get(i) + "\n"; 
			}else {
				sboard += board.get(i);
			}
		}
		return sboard;
	}
	

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "ChungToi [numJogadores=" + numJogadores + ", p1=" + p1 + ", p2=" + p2 + ", board=" + board + "]";
	}
	
	
	
}
