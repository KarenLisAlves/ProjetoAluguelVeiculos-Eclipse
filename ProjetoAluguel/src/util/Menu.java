package util;

public class Menu {

	public static void bemVindo() {
		System.out.println("============================================");
		System.out.println("Bem Vindo ao sistema de aluguel de ve�culos!");
		System.out.println("============================================");
	
	}
	
	
	public static void identificar() {
		
		System.out.println();
		System.out.println("Digite uma op��o:");
		System.out.println("1 - Cliente");
		System.out.println("2 - Vendedor");
		System.out.println("3 - Administrador");
		System.out.println("0 - Sair do Sistema");
	}
	
	
public static void menuCliente1() {
		
		System.out.println();
		System.out.println("Voc� j� tem cadastro?");
		System.out.println("Sim? Digite seu CPF");
		System.out.println("N�o? Digite 'n�o'");
	}
	
	
	public static void menuCliente2() {
		
		System.out.println();
		System.out.println("Digite uma op��o");
		System.out.println("1 - Alugar um ve�culo");
		System.out.println("2 - Devolver um ve�culo");
	}
	
	
	public static void menuVendedor() {
		
		System.out.println();
		System.out.println("Digite uma op��o");
		System.out.println("1 - Ver seu sal�rio atual + comiss�o");
		System.out.println("2 - Ver carros alugados");
	}
	
	
	public static void menuAdministrador() {
		
		System.out.println();
		System.out.println("Digite uma op��o");
		System.out.println("1 - Cadastrar Ve�culo");
		System.out.println("2 - Cadastrar vendedor");
		System.out.println("3 - Ver total de vendas");
	}
	
	
	
	public static void alugarVeiculo() {
		
		System.out.println();
		System.out.println("Digite uma op��o");
		System.out.println("1 - Alugar um ve�culo");
		System.out.println("2 - Devolver um ve�culo");
	}

}
