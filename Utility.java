import java.util.Random;

public class Utility {
	
	//Funcao para medir a distancia
	public static double distancia(Cidade city1, Cidade city2){
		int xDistance = Math.abs(city1.getX() - city2.getX());
		int yDistance = Math.abs(city1.getY() - city2.getY());
		double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
			
		return distance;
	}
	
	public static double probabilidadeAceitar(int currentDistance, int newDistance, double temperature) {
		//Se a solucao e melhor que a atual entao e aceita
		if (newDistance < currentDistance) {
			return 1.0;
		}
		//Se e pior, entao calcula a possibilidade de aceite baseado na temperatura atual
		return Math.exp((currentDistance - newDistance) / temperature);
	}
	
	//Funcoes para randomizar
	static double randomDouble()
	{
		Random r = new Random();
		return r.nextInt(1000) / 1000.0;
	}
	public static int randomInt(int min , int max) {
		Random r = new Random();
		double d = min + r.nextDouble() * (max - min);
		return (int)d;
	}
}
