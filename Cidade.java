
public class Cidade {
	private int pos;
    private int x;
    private int y;           

    //Cria uma cidade baseada nas suas coordenadas. O valor de pos é o "nome" da cidade
	public Cidade(int pos, int x, int y){
		this.pos = pos;
        this.x = x;
        this.y = y;
    }            
    
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "" + pos + "";
	}
	
}
