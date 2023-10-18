package cofrinho;

public class Euro extends Moeda{

	public Euro(double valorEuro) {
		this.valor = valorEuro;
	}
	
	@Override
	public void info() {
		System.out.println("Euro - " + valor);

	}

	@Override
	public double converter() {
		return this.valor * 5.5; //valor do euro na conversão é de 5.5
	}
	
	@Override
	public boolean equals(Object objeto) {
		if(this.getClass() != objeto.getClass()) {
			return false;
		}
		
		Euro objetoDeEuro = (Euro) objeto;
		
		if(this.valor != objetoDeEuro.valor) {
			return false;
		}
			
		
		return true;
	}
	
}
