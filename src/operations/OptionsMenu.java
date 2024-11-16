package operations;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import services.AccountService;

public class OptionsMenu implements BankOperations {
	
	private ArrayList<Account> contasBancarias;
	private Scanner sc;
	
	public OptionsMenu(ArrayList<Account> contasBancarias, Scanner sc) {
		this.contasBancarias = contasBancarias;
		this.sc = sc;
	}
	
	@Override
	public void execute() {
		Locale.setDefault(Locale.US);
		displayMenu();
	}
	
	public void displayMenu() {
		System.out.println("--------------------------------------");
		System.out.println("--------Bem-Vindo ao SoulBank---------");
		System.out.println("--------------------------------------");
		System.out.println("********Selecione uma operação********");
		System.out.println("--------------------------------------");
		System.out.println("|1. - Criar uma conta     |");
		System.out.println("|2. - Deposito            |");
		System.out.println("|3. - Saque               |");
		System.out.println("|4. - Transferência       |");
		System.out.println("|5. - Listar Contas       |");
		System.out.println("|0. - Finalizar           |");
		
		System.out.print("Escolha uma opção: ");
		int opcao = sc.nextInt();
		
		switch(opcao) {
			case 1:
				AccountService.createAccount();
				break;
			case 2:
				AccountService.deposit();
				break;
			case 3:
				AccountService.withdraw();
				break;
			case 4:
				AccountService.transfer();
				break;
			case 5:
				AccountService.listAccounts();
				break;
			case 0:
				System.out.println("Encerrando...");
				System.out.println("Obrigado por utilizar o Soul Bank!");
				System.exit(0);
			default:
				System.out.println("Opção inválida, digite novamente!");
				displayMenu();
				break;
		}
		displayMenu();
	}
}
