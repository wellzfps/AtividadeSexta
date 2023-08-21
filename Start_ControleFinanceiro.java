package Aplication;

import java.util.Scanner;

import Entities.ControleFinanceiro;

public class Start_ControleFinanceiro {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			ControleFinanceiro programa = new ControleFinanceiro(0, null, 0);
			
			System.out.println("Informe o valor do seu sálario para iniciar o Programa: ");
			double saldo = sc.nextDouble();
			programa.addSaldo(saldo);
			
			programa.selecaoMenu(sc);
			
		
			sc.close();

	}

}
