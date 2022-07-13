
import java.util.ArrayList;


public class Gerenciador {

    //Lista de cidades
    private static ArrayList<Cidade> destinoCidades = new ArrayList<Cidade>();

	public static void addCidade(Cidade city) {
		destinoCidades.add(city);
	}

	//Retorna uma cidade pelo seu index
	public static Cidade getCidade(int index){
		return (Cidade)destinoCidades.get(index);
	}

	//Calcula o numero de cidades
	public static int numeroDeCidades(){
		return destinoCidades.size();
	}
}
