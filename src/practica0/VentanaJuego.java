package practica0;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.Image;


public class VentanaJuego extends JFrame {
	Coche mCoche = null;
	public JLabel label;
	public Thread hilo;
	public Image imagen;
	public Dimension pantalla;
public VentanaJuego(Coche coche) {
	mCoche = coche;
	this.setTitle("VENTANA PRINCIPAL");
	this.setBackground(Color.white);
	this.setLayout(new BorderLayout());
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setSize(1000,700);
	this.setResizable(false);

	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension ventana = this.getSize();
	int x = (pantalla.width - ventana.width) / 2;
	int y = (pantalla.height - ventana.height) / 2;
	this.setLocation(x, y);
	
	
	
	
	JPanel pnl = new JPanel();
	
	
	 ImageIcon icono = new ImageIcon("C:\\Users\\eleniixx\\eclipse-workspace\\PRACTICA_0\\src\\practica0\\coche.png");
		Image imagen= icono.getImage();
		int a = 100;
		int b = 100;
		Image ima2 =imagen.getScaledInstance(a, b, Image.SCALE_SMOOTH); 
		ImageIcon ima3 = new ImageIcon(ima2);
		label = new JLabel(ima3);
		
	
	
	
    
    
    pnl.add(label);

    getContentPane().add(pnl);
	
    
    
	//botones
	
	JPanel botones = new JPanel();
	JButton btnAcelera = new JButton("Acelera");
	botones.add(btnAcelera);
	btnAcelera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double vel = mCoche.getVelocidad();
			if(vel ==0) {
				mCoche.acelera(5);
			}else if(vel<0) {
				mCoche.acelera(-5);
			}else if(vel>0) {
				mCoche.acelera(+5);
			}
			
			
		}
	});
	
	
	
	
	JButton btnFrena = new JButton("Frena");
	botones.add(btnFrena);
	btnFrena.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double vel = mCoche.getVelocidad();
			if(vel ==0) {
				mCoche.setVelocidad(0);
			}else if(vel<0) {
				mCoche.acelera(5);
			}else if(vel>0) {
				mCoche.acelera(-5);
			}
			
			
		}
	});
	
	JButton btnIZQ = new JButton("Izquierda");
	botones.add(btnIZQ);
	btnIZQ.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mCoche.gira(-5);
		}
	});
	
	JButton btnDER = new JButton("Derecha");
	botones.add(btnDER);
	btnDER.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mCoche.gira(5);
		}
	});
	
	
	
	
	
	
	
	this.add(botones,BorderLayout.SOUTH);
	botones.setVisible(true);
	
	
	
	
	
	
	
	this.setVisible(true);

	
	
}



public static void main(String[] args) {
	
	
	//System.out.println(coche.toString()); 
	Thread hilo = new Thread(new Runnable() {
		public void run() {
			Coche coche = new Coche();
			VentanaJuego j = new VentanaJuego(coche);
			
			
			while(true) {
				
				j.mCoche.mueve(1, j.mCoche);
				
				ImageIcon icon = new ImageIcon("C:\\Users\\eleniixx\\eclipse-workspace\\PRACTICA_0\\src\\practica0\\coche.png");
			    Image imagen = icon.getImage();
			    Image imagenRotada = rotateImage(imagen, j.mCoche.getDiract(), 100, 100);
			    ImageIcon rotatedIcon = new ImageIcon(imagenRotada);
			    j.label.setIcon(rotatedIcon);
				
				
				
				
				j.label.setBounds((int)j.mCoche.getPosX(), (int)j.mCoche.getPosY(), 100,100);
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	})
	{
		
	};
	hilo.start();
	
	
	
	
	
	
}
public static Image rotateImage(Image img, double degrees, int width, int height) {
    
    BufferedImage bufferedImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();

    
    int centerX = width / 2;
    int centerY = height / 2;

    AffineTransform transform = new AffineTransform();
    transform.rotate(Math.toRadians(degrees+90), centerX, centerY);

    g2d.setTransform(transform);
    g2d.drawImage(img, 0, 0, width, height, null);
    g2d.dispose();

    return bufferedImage;
}





}


