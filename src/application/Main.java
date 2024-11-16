package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import operations.OptionsMenu;

/* A classe {Main} é o ponto de entrada do programa bancário.
 * Ela inicializa o sistema, criando a lista de contas bancárias e o menu de operações. */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Account> contasBancarias = new ArrayList<>();
		Locale.setDefault(Locale.US);
		
		OptionsMenu menu = new OptionsMenu(contasBancarias, sc);
		menu.displayMenu();
	}

}
