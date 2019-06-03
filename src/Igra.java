import java.util.*;

//Ustvariva kaco, kot seznam tock, ki ima na zacetku vedno dolzino 5.
public class Igra {
	//dolocimo sirino in visino okna
	public static final int SIRINA = 40;
	public static final int VISINA = 40;
	Tocka hrana;
	
	//ustvarimo kaco, kot seznam tock
	public LinkedList<Tocka> kaca;
	public Tocka[] smeri = { new Tocka(1, 0), new Tocka(0, 1), new Tocka(-1, 0), new Tocka(0, -1)

	};

	int smer;

	public Igra(int size) {

		kaca = new LinkedList<Tocka>();
		smer = (int) (4 * Math.random());
		int x = (int) ((SIRINA - 10) * Math.random()) + 5;
		int y = (int) ((VISINA - 10) * Math.random()) + 5;
		kaca.add(new Tocka(x, y));
		Tocka nasprotna = smeri[(smer + 2) % 4];
		for (int i = 0; i < 5; i++) {
			x += nasprotna.getX();
			y += nasprotna.getY();
			kaca.add(new Tocka(x, y));

		}
		dodajHrano();

	}

	public boolean vsebujeTocko(int x, int y) {
		for (Tocka t : kaca) {
			if (t.getX() == x && t.getY() == y) {
				return true;
			}
		}
		return false;
	}

	public void dodajHrano() {
		while (true) {
			int x = (int) (SIRINA * Math.random());
			int y = (int) (VISINA * Math.random());
			if (vsebujeTocko(x, y))
				continue;
			hrana = new Tocka(x, y);
			break;
		}

	}
	static boolean obr=true;
	public boolean premik() {
		
		Tocka glava = kaca.getFirst();
		Tocka vektor = smeri[smer];
		glava.smer = smer;
		int x = glava.getX() + vektor.getX();
		int y = glava.getY() + vektor.getY();
		Tocka nova = new Tocka(x, y);
		if (x == hrana.getX() && y == hrana.getY()) {
			switch (hrana.getType()) {
			case 0:
			
				
				break;
			case 1:
				Okno.delay*=1.2;//kaca gre pocasneje
				break;
			case 2:
				Okno.delay*=0.8;//kaca gre hitreje
				break;
		
			}
			kaca.addFirst(nova);
			dodajHrano();
		} else {
			kaca.addFirst(nova);
			kaca.removeLast();
		}
		return true;

	}

	//pogledamo, kdaj se kaca zaleti in je s tem konec igre.
	public boolean siZaletena() {
		//ko se zaleti v rob
		Tocka glava = kaca.getFirst();
		if (glava.getX() < 0 || glava.getY() < 0 || glava.getX() >= SIRINA || glava.getY() >= VISINA) {
			return true;
		}

		for (Tocka t : kaca) {
			//ko se zaleti sama vase
			if (t != glava && glava.getX() == t.getX() && glava.getY() == t.getY()) {
				return true;
			}
		}
		return false;
	}

	public LinkedList<Tocka> getKaca() {
		return kaca;
	}

	public void setKaca(LinkedList<Tocka> kaca) {
		this.kaca = kaca;
	}

}

