package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupança;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		criarContasTeste();
		
		int opcao;

		while (true) {

			System.out.println(
					Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "**************************************");
			System.out.println("                                      ");
			System.out.println("     BANCO DO BRAZIL COM Z            ");
			System.out.println("                                      ");
			System.out.println("**************************************");
			System.out.println("                                      ");
			System.out.println("  1 - Criar conta                     ");
			System.out.println("  2 - Listar todas as contas          ");
			System.out.println("  3 - Buscar conta por número         ");
			System.out.println("  4 - Atualizar Dados da Conta        ");
			System.out.println("  5 - Apagar conta                    ");
			System.out.println("  6 - Sacar                           ");
			System.out.println("  7 - Depositar                       ");
			System.out.println("  8 - Transferir valores entre contas ");
			System.out.println("  0 - Sair                            ");
			System.out.println("                                      ");
			System.out.println("**************************************");
			System.out.println("Entre com a opção desejada:           ");
			System.out.println("                                      " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n\n");
				
				cadastrarConta();
				
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listas todas as contas\n\n");
				
				listarContas();
				
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta  - por número\n\n");
				
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta\n\n");
				
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");
				
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!\n");
				
				keyPress();
				break;
			}
		}
	}

	private static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Maria dos Santos", 2000.00f, 200.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 789, 2, "Mariana Hernandez", 10000.00f, 12));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 123, 3, "Giovanna Giunchetti", 8000.00f, 23));

		
	}

	public static void sobre() {
		System.out.println("\n**************************************");
		System.out.println("Projeto Desenvolvido por: Bruna Mendes");
		System.out.println("Generation Brasil - brunam@generation.org");
		System.out.println("github.com/bruna-dsmendes");
		System.out.println("****************************************");
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}

	private static void listarContas() {
		contaController.listarTodas();

	}
	public static void cadastrarConta() {
		System.out.print("Digite o número da Agência: ");
		int agencia = leia.nextInt();
		
		System.out.println("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.println("Digite o Saldo inicial da conta: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta:");
			float limite = leia.nextFloat();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta:");
			int aniversario = leia.nextInt();
			contaController.cadastrar(new ContaPoupança(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default ->
		System.out.println(Cores.TEXT_RED_BOLD + "Tipo de conta inválida!" + Cores.TEXT_RESET);
		}
		
		
		
		
		
	}
	
	

}