import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

	//konzola je nov class, na kateri bodo gumbi, potrebi za igranje igrice. 
	//Ustvarili sva samo en gumb, Start, katerega funkcija je, da ponovno zazene igrico od zacetka, ko se ta konca
	public class Konzola extends JPanel {

		private static final long serialVersionUID = 1L;

		public Konzola(Okno okno) {
			super();		
			
			//ustvarimo gumb 
			JButton reset = new JButton("Start");
			reset.setFocusable(false);
			reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					okno.igra.kaca.clear();
					okno.igra.smer = (int)(4 * Math.random());
					int x = (int)((Igra.SIRINA - 10) * Math.random())+5;
					int y = (int)((Igra.VISINA - 10) * Math.random())+5;
					okno.igra.kaca.add(new Tocka(x, y));
					Tocka nasprotna = okno.igra.smeri[(okno.igra.smer + 2)%4];
					for (int i = 0; i < 5; i++) {
						x += nasprotna.getX();
						y += nasprotna.getY();
						okno.igra.kaca.add(new Tocka(x, y));
						okno.igra.dodajHrano();
						
					}
					okno.premikaj = true;
					okno.repaint();
					okno.delay = 200L;

				}
			});
			add(reset);
			

		}

		
	}


