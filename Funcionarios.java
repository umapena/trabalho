package trabalho;

public class Funcionarios {

	private int codigo;
	private String nome;
	
	public Funcionarios(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "\nCódigo: " + codigo + "; Nome: " + nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	

	
}