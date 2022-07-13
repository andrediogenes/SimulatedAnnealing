
import java.util.ArrayList;
import java.util.Collections;

public class Viagem{

    private ArrayList<Cidade> viagem = new ArrayList<Cidade>();
    
    private int distancia = 0;
    
    //Construtor
    public Viagem(){
        for (int i = 0; i < Gerenciador.numeroDeCidades(); i++) {
            viagem.add(null);
        }
    }
    
	public Viagem(ArrayList<Cidade> viagem){
        this.viagem = (ArrayList<Cidade>) viagem.clone();
    }
    
    public ArrayList<Cidade> getViagen(){
        return viagem;
    }
     
    //Cria uma viagem aleatória
    public void gerarViagemAleatoria() {
        //Seta todas as cidades
        for (int indexCidade = 0; indexCidade < Gerenciador.numeroDeCidades(); indexCidade++) {
          setCidade(indexCidade, Gerenciador.getCidade(indexCidade));
        }
        //Randomiza a ordem das cidades
        Collections.shuffle(viagem);
    }

    //Retorna uma cidade baseado no index
    public Cidade getCidade(int index) {
        return viagem.get(index);
    }

    //Seta uma cidade baseado no index
    public void setCidade(int index, Cidade cidade) {
        viagem.set(index, cidade);
        //Se a viagem foi alterada entao precisa se setar a distancia pra 0
        distancia = 0;
    }
    
    //Calcula a distancia total de uma viagem
    public int getDistanciaTotal(){
    	if (distancia == 0) {
            int distanciaTotal = 0;
            //Cidades
            for (int indexCidade=0; indexCidade < tamanhoViagem(); indexCidade++) {
                //cidade partida
                Cidade cidadePartida = getCidade(indexCidade);
                //cidade destino
                Cidade cidadeDestino;
                //Checando se nao ta na ultima cidade
                if(indexCidade+1 < tamanhoViagem()){
                    cidadeDestino = getCidade(indexCidade+1);
                }
                else{
                    cidadeDestino = getCidade(0);
                }                
                //Calcula a distancia
                distanciaTotal += Utility.distancia(cidadePartida, cidadeDestino); 
        		
            }
            distancia = distanciaTotal;
        }
        return distancia;
    }

    //Retorna o numero de cidades em uma viagem
    public int tamanhoViagem() {
        return viagem.size();
    }
    
    //Retorna todas as cidades de uma viagem
    public String toString() {
        String s = getCidade(0).toString();
        for (int i = 1; i < tamanhoViagem(); i++) {
            s += " -> " + getCidade(i).toString();
        }
        return s;
    }
}
    
