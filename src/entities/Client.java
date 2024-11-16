package entities;

public class Client {
	
	private static Integer counterId = 1;
	
	//Atributos do cliente
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	
	public Client(String nome, String cpf, String email) {
		super();
		this.idCliente = counterId++;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return String.format(
				"\nId: %d\nNome: %s\nCPF: %s\nEmail: %s",
				idCliente, nome, cpf, email);
	}
	
}
