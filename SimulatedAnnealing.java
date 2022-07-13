import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SimulatedAnnealing {
    
    public static void main(String[] args) throws FileNotFoundException {
    	
    	Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("Digite o tamanho do arquivo (tipo int): ");
    	int tam;
    	tam = entrada.nextInt();
    	
    	int pos, x, y;
    	double tempMax;
    	
    	System.out.println("Digite a temperatura máxima (tipo double): ");
    	double tempDigitadoUsuario;
    	tempDigitadoUsuario = entrada.nextDouble();
    	
    	System.out.println("Digite a temperatura mínima (tipo double): ");
        double tempMin;
        tempMin = entrada.nextDouble();
        
        System.out.println("Digite a taxa de resfriamento (tipo double): ");
        double kResfriamento;
        kResfriamento = entrada.nextDouble();
        
        System.out.println("Digite a quantidade de iterações KT (tipo int): ");
        int kt;
        kt = entrada.nextInt();
        
        System.out.println("Digite o diretório + o nome do arquivo (tipo String sem espaco em branco): ");
        String diretorioString;
        diretorioString = entrada.next();
        
    	Scanner in = new Scanner(new FileReader(""+ diretorioString));
		for (int i = 0; i < tam; i++) {
			
		    pos = in.nextInt();
		    x = in.nextInt();
			y = in.nextInt();
			//Criando as cidades
			Cidade city = new Cidade(pos, x, y);
			Gerenciador.addCidade(city);
		}

        //Por enquanto a melhor solucao e aleatoria
        Viagem melhor = new Viagem();
        melhor.gerarViagemAleatoria();
        
        for (;kt>0; kt--) {
        	tempMax = tempDigitadoUsuario;
        	
        	//Criando uma solucao inicial aleatoria
        	Viagem solucaoCorrente = new Viagem();
            solucaoCorrente.gerarViagemAleatoria();
            
	        //Repetimos a operacao ate "esfriar"
	        while (tempMax >= tempMin) {
	            //Criando um novo sistema de vizinhos
	            Viagem novaSolucao = new Viagem(solucaoCorrente.getViagen());
	
	            //Pegando posicoes aleatorias na viagem
	            int viagemPos1 = Utility.randomInt(0 , novaSolucao.tamanhoViagem());
	            int viagemPos2 = Utility.randomInt(0 , novaSolucao.tamanhoViagem());
	            
	            //Apenas pra ter certeza que pegamos posicoes diferentes
	    		while(viagemPos1 == viagemPos2) {viagemPos2 = Utility.randomInt(0 , novaSolucao.tamanhoViagem());}
	
	            //Pega as cidades nas posicoes selecionadas da viagem
	            Cidade cidadeTrocada1 = novaSolucao.getCidade(viagemPos1);
	            Cidade cidadeTrocada2 = novaSolucao.getCidade(viagemPos2);
	
	            //Troca elas
	            novaSolucao.setCidade(viagemPos2, cidadeTrocada1);
	            novaSolucao.setCidade(viagemPos1, cidadeTrocada2);
	            
	            //Pega a distancia das solucoes
	            int distanciaAtual   = solucaoCorrente.getDistanciaTotal();
	            int distanciaVizinho = novaSolucao.getDistanciaTotal();
	
	            //Aceitacao do novo vizinho
	            double rand = Utility.randomDouble();
	            if (Utility.probabilidadeAceitar(distanciaAtual, distanciaVizinho, tempMax) > rand) {
	                solucaoCorrente = new Viagem(novaSolucao.getViagen());
	            }
	
	            //Mantendo a nova viagem achada
	            if (solucaoCorrente.getDistanciaTotal() < melhor.getDistanciaTotal()) {
	                melhor = new Viagem(solucaoCorrente.getViagen());
	            }
	            
	            //Resfriando
	            tempMax *= 1 - kResfriamento;
	        }
	    }

        System.out.println("Distância da solução final: " + melhor.getDistanciaTotal());
        System.out.println("Viagem: " + melhor);
    }
}
