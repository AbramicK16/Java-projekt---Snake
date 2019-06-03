import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Okno extends JFrame implements KeyListener {

	public Platno platno;
	public Igra igra;
	public boolean premikaj;
	public static long delay = 200L;
	public static void main(String[] args) {
	    Okno okno = new Okno();
	    okno.pack();
	    okno.setVisible(true);
	    
	    while (true) {
	    	
	    	// premakni kaco
	    	
	    	if (okno.premikaj) {
	    		okno.igra.premik();
	    		if (okno.igra.siZaletena()) {
	    			okno.premikaj = false;
	    		}
	    		

				okno.repaint();
	    	}
	    	
	    	try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	
	    }

		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	//dolocimo tipke, s katerimi bomo igrali
	@Override
	public void keyPressed(KeyEvent e) {
		int tipka = e.getKeyCode();
		if (tipka == KeyEvent.VK_LEFT) {
			igra.smer = (igra.smer + 3)%4;
		}
		if (tipka == KeyEvent.VK_RIGHT) {
			igra.smer = (igra.smer + 1)%4;
		}
	}


	
	public Okno() {
		super();
	    setTitle("Kaèa");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	    igra = new Igra(20);
	    premikaj = true;

	    platno = new Platno(igra);
	    add(platno, BorderLayout.CENTER); //igralno platno postavimo v center, tako, da vedno ko povecamo okno, ostane v centru
	    add(new Konzola(this), BorderLayout.NORTH); //gumb postavimo na vrh 
		setFocusable(true);
		addKeyListener(this);
		
	}

}

