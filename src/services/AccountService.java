package services;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Account;
import entities.Client;

public class AccountService {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Account> contasBancarias = new ArrayList<>();
	
	public static void createAccount() {
		System.out.print("Nome:");
		String nome = sc.nextLine();
		
		System.out.print("CPF:");
		String cpf = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		Client cliente = new Client(nome, cpf, email);
		Account account = new Account(cliente);
		contasBancarias.add(account);
		
		System.out.println("Conta criada com sucesso. " + cliente.getNome() + ", seja bem-vindo ao Soul Bank");
	}
	
	public static void deposit() {
		System.out.print("Número da conta para depósito:");
		int numeroConta = sc.nextInt();
		
		sc.nextLine();
		
		Account account = findAccount(numeroConta);
		
		if (account != null) {
			System.out.print("Valor para depósito R$: ");
			Double valor = sc.nextDouble();
			sc.nextLine();
			
			account.deposit(valor);
			System.out.println("Depósito realizado com sucesso!");
		}
		else {
			System.out.println("Não foi possível localizar a conta.");
		}
	}
	
	public static void withdraw() {
		System.out.print("Número da conta para saque: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		
		Account account = findAccount(numeroConta);
		
		if (account != null) {
			System.out.print("Valor para saque R$: ");
			Double valor = sc.nextDouble();
			sc.nextLine();
			
			account.withdraw(valor);
			System.out.println("Saque realizado com sucesso!");
		}
		else {
			System.out.println("Não foi possível localizar a conta.");
		}
	}
	
	public static void transfer() {
		System.out.print("Número da conta origem: ");
		int numeroContaOrigem = sc.nextInt();
		sc.nextLine();
		
		Account contaOrigem = findAccount(numeroContaOrigem);
		
		if (contaOrigem != null) {
			System.out.print("Número da conta destino: ");
			int numeroContaDestino = sc.nextInt();
			sc.nextLine();
			
			Account contaDestino = findAccount(numeroContaDestino);
			if (contaDestino != null) {
				System.out.print("Valor para transferência R$: ");
				Double valor = sc.nextDouble();
				sc.nextLine();
				
				contaOrigem.transfer(contaDestino, valor);
				System.out.println("Transferência realizada com sucesso.");
			}
			else {
				System.out.println("Conta de destino não foi encotrada.");
			}
		}
		else {
			System.out.println("Conta de Origem não foi encontrada.");
		}
	}
	
	public static void listAccounts() {
		System.out.println("Listando contas...");
		if (contasBancarias.isEmpty()) {
			System.out.println("Nenhuma conta encontrada.");
		}
		else {
			for (Account account : contasBancarias) {
				System.out.println(account);
			}
		}
	}
	
	public static Account findAccount(int numeroConta) {
		for (Account account : contasBancarias) {
			if (account.getNumeroConta() == numeroConta) {
				return account;
			}
		}
		return null;
	}
	
}
