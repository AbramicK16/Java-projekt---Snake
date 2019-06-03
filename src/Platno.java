import java.awt.*;


import javax.swing.*;

//Tu narisemo kaco, cekincke in igralno polje. Polje je crne barve, obroba pa bele. 
@SuppressWarnings("serial")
public class Platno extends JPanel {
	
	public Igra igra;

	public Platno(Igra igra) {
		this.igra = igra;

	}
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

    //definiramo barve, s katerimi bodo pobarvane kaca in vsi trije kovancki
	public static final Color DARK_GREEN = new Color(0, 153, 0);
	public static final Color VERY_DARK_GREEN = new Color(0, 102, 0);
	public static final Color LIGHT_BROWN = new Color(153, 102, 0);
	public static final Color VERY_DARK_GRAY = new Color(51, 51, 51);
	public static Color[] tocke = {
			new Color(153, 102, 0),
			new Color(255, 102, 102),
			new Color(255, 204, 0)
	};
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(VERY_DARK_GRAY);
		int width = getWidth()/Igra.SIRINA;
		int height = getHeight()/Igra.VISINA;
		int size = Math.min(width, height);
		int x = (getWidth() - size*Igra.SIRINA)/2;
		int y = (getHeight() - size*Igra.VISINA)/2;
		
		g.translate(x, y);

		//obroba platna
		g.setColor(Color.WHITE);
		g.drawLine(0, 0, 0, Igra.VISINA*size);
		g.drawLine(Igra.SIRINA*size, 0, Igra.SIRINA*size, Igra.VISINA*size);
		g.drawLine(0, 0, Igra.SIRINA*size, 0);
		g.drawLine(0, Igra.VISINA*size, Igra.SIRINA*size, Igra.VISINA*size);
		
		//glava je prva tocka v nizu in jo pobarvamo v temno zeleno
	    Tocka glava = igra.kaca.getFirst();
	    g.setColor(DARK_GREEN);
	    for (Tocka t : igra.kaca) {
		    if (t != glava) {
			    
		    	g.fillOval(size * t.getX(), size * t.getY(), size, size);
		    }
	    }
	    g.setColor(VERY_DARK_GREEN);
	    g.fillOval(size * glava.getX(), size * glava.getY(), size, size);
	    
		//g.setColor(LIGHT_BROWN);
	    g.setColor(tocke[igra.hrana.getType()]);
	    g.fillOval(size * igra.hrana.getX(), size * igra.hrana.getY(), size, size);
	    
	    //ko se igra zakljuci, se na sredini izpiseta GAME OVER in Score
	    int i = igra.kaca.size()-6;
	    if (igra.siZaletena()) {
	    	Font font = new Font("Verdana", Font.BOLD, 20);
	    	g.setColor(Color.WHITE); 
	    	g.setFont(font);
	    	g.drawString("GAME OVER!", Igra.SIRINA*size/2 - 70, Igra.VISINA*size/2);
	    	g.drawString("Score: " + i, Igra.SIRINA*size/2 - 50, Igra.VISINA*size/2 + 50);
	    }
	}
	


}

