package trabalho;

public class Programadores extends Funcionarios implements Beneficios {

	private double salarioLiquido;
	private double salarioBruto;
	private double bonificacao;
	private final double valorHora = 50;
	
	public Programadores(int codigo, String nome) {
		super(codigo, nome);
	}

	public double calcularLiquido(double horasTrab) { 
		
		//calculando o valor do salário pelas horas
		salarioBruto = horasTrab * this.valorHora;		
		
		//calculando o valor do inss
		double inss;
		
		if(salarioBruto <= 1100) {
			inss = salarioBruto * 0.075;		
		}
		else if (salarioBruto > 1100 && salarioBruto <= 2203.48) {
			inss = (salarioBruto * 0.09) - 16.5;
		}
		else if (salarioBruto > 2203.48 && salarioBruto <= 3305.22) {
			inss = (salarioBruto * 0.12) - 82.6;
		}
		else if (salarioBruto > 3305.22 && salarioBruto <= 6433.57) {
			inss = (salarioBruto * 0.14) - 148.71;
		}
		else {
			inss = 1100 * 0.075 + (2203.48 - 1100) * 0.09 + (3305.22 - 2203.48) * 0.12 + (6433.57 - 3305.22) * 0.14;
		}
		
		//calculando o valor do irrf
		double baseIrrf = salarioBruto - inss;
		double irrf;
		
		if(baseIrrf <= 1903.98) {
			irrf = 0;		
		}
		else if (baseIrrf > 1903.98 && baseIrrf <= 2826.65) {
			irrf = (baseIrrf * 0.075) - 142.80;
		}
		else if (baseIrrf > 2826.65 && baseIrrf <= 3751.05) {
			irrf = (baseIrrf * 0.15) - 354.80;
		}
		else if (baseIrrf > 3751.05 && baseIrrf <= 4664.68) {
			irrf = (baseIrrf * 0.225) - 636.13;
		}
		else {
			irrf = (baseIrrf * 0.275) - 869.36;
		}
		
		this.salarioLiquido = salarioBruto - inss - irrf;
		System.out.println("Salário bruto: R$" + salarioBruto);
		System.out.println("Inss: R$" + inss);
		System.out.println("Irrf: R$" + irrf);
		System.out.println("Salário líquido: R$" + this.salarioLiquido);
		return this.salarioLiquido;
	}


	@Override
	public void bonificacao(double horasTrab) {
			
		if (horasTrab < 50) { 
			bonificacao = 0;
			System.out.println("O funcionário não atingiu as horas necessárias para receber bonificação (50h)!");
			return;
		}
		
		bonificacao = this.salarioLiquido * 0.4;
		System.out.println("Bonificação: R$" + bonificacao);
		return;
	}
	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public double getBonificacao() {
		return bonificacao;
	}

}
