package Entities;

import java.util.Scanner;

public class ControleFinanceiro {
		
		private double valorDespesa;
		private double saldo;
		private String despesa;
		
		// Construtores
		public ControleFinanceiro() {
			
		}
		
		public ControleFinanceiro(double valorDespesa, String despesa, double saldo) {
			this.valorDespesa = valorDespesa;
			this.despesa = despesa; 
			this.saldo = saldo;
		}
		
		// Gets e Sets

		public double getValorDespesa() {
			return valorDespesa;
		}

		public void setValorDespesa(double valorDespesa) {
			this.valorDespesa = valorDespesa;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setDespesa(String despesa) {
			this.despesa = despesa;
		}
		
		// Métodos
		public void addSaldo(double saldo) {
			this.saldo += saldo;
			
		}
		public double addDespesa(double valorDespesa) {
			  if (saldo < valorDespesa) {
			    System.out.println("Saldo insuficiente.");
			    return -1;
			  }
			  this.saldo -= valorDespesa;
			  this.valorDespesa += valorDespesa;
			  return saldo;
			}
		
		public void selecaoMenu (Scanner sc){
			System.out.println("Selecione a opção desejada: \n1 - Cadastro de Saldo \n2 - Cadastro de Despesa \n3 - Visualizar Saldo \n4 - Encerrar.");
			int selecao = sc.nextInt();
			switch (selecao) {
			case 1:
				System.out.println("Você escolheu Cadastro de Saldo!!");
				System.out.println("\nInforme o valor de saldo que deseja cadastrar: \n");
				double saldo = sc.nextDouble();
				addSaldo(saldo);
				dadosConta();
				selecaoMenu(sc);
				
				break;
			case 2: 
				System.out.println("Você escolheu Cadastro de Despesa ");
				System.out.println("Informe o nome do Produto que você deseja gastar o dinheiro: ");
				String despesa = sc.next();
				setDespesa(despesa);
				
				System.out.println("Informe o valor do Produto: ");
				double valorDespesa = sc.nextDouble();
				setValorDespesa(valorDespesa);
				addDespesa(valorDespesa);
				dadosConta();
				outraCompra(sc);
				
				break;
			case 3: 
				dadosConta();
				selecaoMenu(sc);
			
				break;
			case 4: 
				System.out.println("Obrigada por utilizar o nosso sistema. Nos vemos na próxima!! ");
				break;
				
			default: 
				System.out.println("Opção inválida! Selecione uma opção válida.");
				selecaoMenu(sc);
				break;
				
				}
			}
			
		public void dadosConta() {
			System.out.println("Segue os dados atualizados do Saldo abaixo: ");
			System.out.println(toString());
		}
		public String toString() {
			return "O valor do seu saldo é: R$" + String.format("%.2f", getSaldo());
		}
		public void outraCompra(Scanner sc) {
			System.out.println("Deseja cadastrar uma nova Despesa? (S/N)");
			char letra = sc.next().charAt(0);
			switch(letra) {
			case 's','S': 
				
				System.out.println("Informe o nome do Produto que você deseja gastar o dinheiro: ");
				String despesa = sc.next();
				setDespesa(despesa);
				System.out.println("Informe o valor do Produto: ");
				double valorDespesa = sc.nextDouble();
				addDespesa(valorDespesa);
				dadosConta();
				outraCompra(sc);
				break;
				
			case 'n','N':
				
				selecaoMenu(sc);
				break;
			
			default: 
				System.out.println("Opção inválida! Selecione uma opção válida.");
				
				break;
			}
		}
		
}
