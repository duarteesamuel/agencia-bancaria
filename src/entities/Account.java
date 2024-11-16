package entities;

import utils.Utils;

/* Esta classe encapsula os detalhes da conta bancária, incluindo o número da conta, 
 * o saldo e as informações do cliente associado a ela. Ela também fornece métodos 
 * para realizar operações financeiras como depósito, saque e transferência */


public class Account {
	
	private Integer numeroConta;
	private Client cliente;
	private Double saldo = 0.0;
	private String dataCriacao;
	
	public Account(Client cliente) {
		this.numeroConta = Utils.accountGenerator();
		this.cliente = cliente;
		this.dataCriacao = Utils.createDate();
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}
	
	public void deposit(Double valor) {
		if (valor > 0) {
			saldo += valor;
		}
		else {
			throw new IllegalArgumentException("O valor de depósito deve ser maior que 0.");
		}
	}
	
	public void withdraw(Double valor) {
		if (valor > 0 && saldo >= valor) {
			saldo -= valor;
		}
		else {
			throw new IllegalArgumentException("Saldo insuficiente ou valor inválido");
		}
	}
	
	public void transfer(Account contaDeposito, Double valor) {
		if (valor > 0 && saldo >= valor) {
			this.withdraw(valor);
			contaDeposito.deposit(valor);
		}
		else {
			throw new IllegalArgumentException("Transferência não realizada"
					+ " por favor tente novamente.");
		}
	}
	
	@Override
	public String toString() {
		return String.format(
				"\nId Cliente: %d\nNumero da Conta: %d\nNome: %s\nCPF: %s\n"
				+ "Email: %s\nSaldo: %d\nData de Criação: %s"
						,cliente.getIdCliente(),
						numeroConta,
						cliente.getNome(),
						cliente.getCpf(),
						cliente.getEmail(),
						Utils.doubleToString(saldo),
						getDataCriacao());
	}
}
