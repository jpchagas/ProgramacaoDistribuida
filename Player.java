
public class Player {
	int id;
	String nome;
	int cor;
	
	public Player(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
