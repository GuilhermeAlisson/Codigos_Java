package cofrinho;

public abstract class Moeda { //classe "mãe"
	
	double valor;//valor que sera usado em cada moeda
	
	public abstract void info();//chama as infos
	
	public abstract double converter();//chama a conversão
	
}
