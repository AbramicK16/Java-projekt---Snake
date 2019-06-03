//Tocka je class, v katerem ustvariva koordinate kovanckov. Kovancki so trije in vsak ima svojo funkcijo:
//Rumen kovancek-hitrost se poveca
//Rdec kovancek-hitrost se zmanjsa
//Rjav kovancek-hitrost se ne spremeni

public class Tocka {
	private int x, y;
	private int type;
	int smer;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Tocka(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.type = (int) (Math.random() * 3); //*3, ker imamo 3 razlicne kovancke, ki nastajajo random
	}

	@Override
	public boolean equals(Object arg0) {


		Tocka t = (Tocka) arg0;

		return x == t.getX() && y == t.getY();
	}

}

