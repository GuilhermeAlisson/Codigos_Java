package cofrinho;

import java.util.ArrayList;

public class Cofre {

	private ArrayList<Moeda> ListaMoedas;
	
	public Cofre() { //metodo construtor
		this.ListaMoedas = new ArrayList<>(); // inicia a lista vazia
	}
	
	public void adicionar(Moeda moeda) { //metodo de adição de moeda
		this.ListaMoedas.add(moeda); 
	}
	
	public void remover(Moeda moeda) { //metodo de remoção de moeda
		this.ListaMoedas.remove(moeda);
	}
	
	
	public void listagemMoedas() {//metodo listagem de moedas
		
		if(this.ListaMoedas.isEmpty()) {//verifica se possui moedas no cofre caso não tenha passa a mensagem abaixo
			System.out.println("Nao tem moedas no cofre");
			return;
		}
		
		for(Moeda moeda :this.ListaMoedas) { // passa as moedas que estão dentro do cofre
			moeda.info();
		}
	}

	public double totalConvertido() {//metodo para chamar o conversor de moedas
		if (this.ListaMoedas.isEmpty()) { 
			return 0;
		}
		
		double acumulaValor = 0; //cria acumulador
		
		for(Moeda moeda : this.ListaMoedas) {
			acumulaValor = acumulaValor + moeda.converter();//acumula o valor convertido 
		}
		
		return acumulaValor;// retorna o valor acumulado
		
	}
	
}
