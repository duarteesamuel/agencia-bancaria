package entities;

/* Esta classe encapsula os detalhes da conta bancária, incluindo o número da conta, 
 * o saldo e as informações do cliente associado a ela. Ela também fornece métodos 
 * para realizar operações financeiras como depósito, saque e transferência */


public class Account {
	
	private Integer numeroConta;
	private Client cliente;
	private Double saldo = 0.0;
	private String dataCriacao;
	
	public Account(Client cliente) {
	}
	
}
