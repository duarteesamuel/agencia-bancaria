package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {
	private static final NumberFormat formatarValor = new DecimalFormat("R$ #,##0.00");
	private static final Random geradorNumero = new Random();
	private static final Set<Integer> numerosGerados = new HashSet<>();
	private static final LocalDateTime dataHora = LocalDateTime.now();
	private static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private Utils() {
		//Não permitir modificações na classe.
	}
	
	//Método para formatar os valores de 0.00 para R$ 0,00
	public static String doubleToString(Double valor) {
		return formatarValor.format(valor);
	}
	
	//Método para gerar números de conta aleatorio, sem gerar números iguais
	public static int accountGenerator() {
		int numeroConta;
		
		do {
			numeroConta = geradorNumero.nextInt(9999) + 1;	
		}while (numerosGerados.contains(numeroConta));
		
		numerosGerados.add(numeroConta);
		
		return numeroConta;
	}
	
	public static String createDate() {
		return dataHora.format(formatoData);
	}
}
