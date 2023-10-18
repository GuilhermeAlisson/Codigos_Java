package cofrinho;

import java.util.Scanner;

public class Menu {
	
	private Scanner sca; //scanear valores digitados
	private Cofre cofre; // chama o cofre dentro do menu
	
	public Menu() {
		sca = new Scanner(System.in); 
		cofre = new Cofre(); //"cria" o cofre dentro do Menu
	}
	
	public void ExibirMenu() { //exibe o Menu com as opções
		System.out.println("Cofrinho");
		System.out.println("1 - Adicionar Moeda");
		System.out.println("2 - Remover Moeda");
		System.out.println("3 - Listar Moedas");
		System.out.println("4 - Calcular valor total convertido para real:");
		System.out.println("0 - Encerrar");

		String selecionarOpcao = sca.next(); //pega o valor digitado pelo usuario
		
		switch(selecionarOpcao) {
			case "0": //faz a ação de encerrar
				System.out.println("Encerrando o programa");
				break;
			case "1": //faz a ação para entrar no sub menu de adicionar moeda
				subMenuAdicionarMoedas();
				ExibirMenu(); // chama o menu novamente
				break;
			case "2": //faz a ação para entrar no sub menu de remover moeda
				subMenuRemoverMoedas();
				break;
			case "3": //chama a listagem de moedas do cofre
				cofre.listagemMoedas();
				ExibirMenu();
				break;
			case "4"://chama o total convertido de moedas que está dentro do cofre
				double valorTotalConvertido = cofre.totalConvertido();//pega o total convertido
				String valorTotalConvertidoTexto = String.format("%.2f", valorTotalConvertido);//formata para aparecert somente 2 digitos após a virgula
				valorTotalConvertidoTexto = valorTotalConvertidoTexto.replace(".",","); // converte o ponto(.) em virugla(,)
				System.out.println("Valor total convertido para Real: R$"+ valorTotalConvertidoTexto);//imprime o valor total convertido para real
				ExibirMenu();
				break;
			default: //valida as opções invalidas
				System.out.println("Opcao invalida!");
				ExibirMenu();
				break;
					
		//1:16
		} 
	}
	private void subMenuAdicionarMoedas() { // sub menu de adição de moedas
		System.out.println("Escolha uma Moeda:\n" //abre a opção de escolha de moedas
				+ "1 - Real\n"
				+ "2 - Dolar\n"
				+ "3 - Euro");
		int opcaoMoeda = sca.nextInt();//pega o valor da moeda desejada
		System.out.println("Digite o valor:");//pede para o usuario adicionar o valor
		
		String valorTextoMoeda = sca.next();//pega o valor digitado pelo o usuario
		valorTextoMoeda = valorTextoMoeda.replace(",",".");//converte a virgula(,) em ponto (.)
		double valorMoeda = Double.valueOf(valorTextoMoeda); // guarda o valor
		
		Moeda moeda = null; //criação da variavel moeda null é usado para tratamento de erro
		
		if(opcaoMoeda == 1) { //se a opção escolhida for 1 adicionara o valor no real
			moeda = new Real(valorMoeda);
		} else if(opcaoMoeda == 2) {//se a opção escolhida for 1 adicionara o valor no dolar
			 moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {//se a opção escolhida for 1 adicionara o valor no euro
			 moeda = new Euro(valorMoeda);
		}else {// caso for uma opção inexistente ele retorna que não existe
			System.out.println("Voce escolheu uma moeda que neo exite!");
			ExibirMenu();//exibe o menu novamente
		}
		cofre.adicionar(moeda);//adiciona o valor da moeda no cofre
		System.out.println("Moeda foi adicionada!"); //printa q moeda foi adicionada
		
	}
	
	private void subMenuRemoverMoedas() {//sub menu de remoção de moedas
		System.out.println("Escolha uma Moeda para remover:\n"
				+ "1 - Real\n"
				+ "2 - Dolar\n"
				+ "3 - Euro");
		int opcaoMoeda = sca.nextInt();//pega a moeda que deseja remover
		System.out.println("Digite o valor:");//pede o valor a ser removido
		
		String valorTextoMoeda = sca.next();//pega o valor digitado pelo o usuario
		valorTextoMoeda = valorTextoMoeda.replace(",",".");//converte o ponto em virgula
		double valorMoeda = Double.valueOf(valorTextoMoeda);//guarda o valor
		
		Moeda moeda = null;//criação da variavel moeda
		
		if(opcaoMoeda == 1) {//se a opção escolhida for 1 removera o valor no real passado pelo usuario
			moeda = new Real(valorMoeda);
		} else if(opcaoMoeda == 2) {
			 moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {
			 moeda = new Euro(valorMoeda);
		}else {
			System.out.println("Voce escolheu uma moeda que neo exite!");
			ExibirMenu();
		}
		cofre.remover(moeda);//remove a moeda escolhida pelo usuario
	}
}
