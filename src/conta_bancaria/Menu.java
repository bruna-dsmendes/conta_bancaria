package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupança;
import conta_bancaria.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opcao;
		
		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND 
					+ "**************************************");
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
			} catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}
			
			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}	
				
				switch(opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n\n");
					keyPress();
					break;
					
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD + "Listas todas as contas\n\n");
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
		
		
	}

