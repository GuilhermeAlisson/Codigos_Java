package cofrinho;

public class Dolar extends Moeda { //extende da classe moeda

	public Dolar(double valorDolar) {
		this.valor = valorDolar; //atribui o valor de dolar
	}
	
	@Override
	public void info() {
		System.out.println("Dolar - " + valor); //informa o valor de dolar

	}

	@Override
	public double converter() {
		return this.valor * 4.8; //valor do dolar na conversão é de 4.8
	}
	
	@Override
	//equal é usado para comparação entre dois objetos
	public boolean equals(Object objeto) {
		if(this.getClass() != objeto.getClass()) { //valida se a classe é diferente
			return false;
		}
		
		Dolar objetoDeDolar = (Dolar) objeto; //força a conversão do objeto
		
		if(this.valor != objetoDeDolar.valor) { //valida se o valor é diferente
			return false;
		}
			
		return true;
	}

}
