package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Programadores programador = null; 
		OutrosFuncionarios outroFuncionario = null;
		
		List<Funcionarios> meusFuncionarios = new ArrayList<Funcionarios>();
				
		System.out.println("Bem vindo ao programa de cadastro de funcion�rios Betha Code!");
		
		int opcao;
		int tipo = 0;
		
		do { 
			
			System.out.println("\nMenu: ");
			System.out.println("1 - Cadastrar funcion�rio");
			System.out.println("2 - Excluir funcion�rio");
			System.out.println("3 - Exibir lista de funcion�rios");
			System.out.println("4 - Calcular sal�rio");
			System.out.println("0 - Encerrar programa");
			System.out.print("Informe a op��o desejada: ");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				System.out.print("Infome o c�digo do funcion�rio: ");
				int codigo = sc.nextInt();

				System.out.print("Infome o nome do funcion�rio: ");
				String nome = sc.next();
				
				do { 
					
					System.out.println("Informe a fun��o: ");
					System.out.println("1 - Programador");
					System.out.println("2 - Outros");
					System.out.print("Escolha: ");
					tipo = sc.nextInt();
					
					if (tipo != 1 && tipo != 2) {
						System.out.println("Op��o inv�lida!");
					}
					
				} while (tipo != 1 && tipo != 2);
				
				if (tipo == 1) {
					programador = new Programadores(codigo, nome);
					meusFuncionarios.add(programador);
				}
				else {
					outroFuncionario = new OutrosFuncionarios(codigo, nome);
					meusFuncionarios.add(outroFuncionario);
				}
				System.out.println("Cadastro efetuado com sucesso!");
				break;				

			}
			case 2: {
				if (meusFuncionarios.isEmpty()) { 
					System.out.println("N�o h� funcion�rios cadastrados!");	

				} else {
					System.out.print("Qual o c�digo do funcion�rio a ser exclu�do?");
					int codRemovido = sc.nextInt();
						
					if (meusFuncionarios.removeIf(funcionario -> funcionario.getCodigo() == codRemovido)) {
						System.out.println("Exclus�o realizada com sucesso!");	
					}
					else { 
					System.out.println("N�o h� funcion�rios com esse c�digo!");	
					}		
				}	
				break;	
			}			
			case 3: {
				if (meusFuncionarios.isEmpty()) {
	                System.out.println("N�o h� funcion�rios cadastrados!");
				} else { 
					System.out.println(meusFuncionarios);
				}
				break;
			}
			case 4: {	
				if (meusFuncionarios.isEmpty()) { 
					System.out.println("N�o h� funcion�rios cadastrados!");	

				} else {
				
					System.out.println("Informe a quantidade de horas trabalhadas: ");
					double horasTrab = sc.nextDouble();
				
					double calculo;
				
					if (tipo == 1) {
						System.out.println(programador);
						programador.calcularLiquido(horasTrab);
						programador.bonificacao(horasTrab);
						calculo = programador.getSalarioLiquido() + programador.getBonificacao();
						System.out.println("Valor Final: R$" + calculo);
					}
					else { 
						System.out.println(outroFuncionario);
						outroFuncionario.calcularLiquido(horasTrab);
						outroFuncionario.bonificacao(horasTrab);
						calculo = outroFuncionario.getSalarioLiquido() + outroFuncionario.getBonificacao();
						System.out.println("Valor Final: R$" + calculo);
					}
				}
				break;
			}
			case 0: {
				System.out.println("Encerrando...");
				break;
			}
			default:
				System.out.println("Op��o inv�lida!");
			}

		} while (opcao != 0); 
				
	}
}
