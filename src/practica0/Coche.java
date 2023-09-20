package practica0;

public class Coche {
	private double velocidad;
	private double diract;
	private double posX;
	private double posY;
	private String piloto;


	public double getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}


	public double getDiract() {
		return diract;
	}


	public void setDiract(double diract) {
		this.diract = diract;
	}


	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}


	public String getPiloto() {
		return piloto;
	}


	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	public Coche(double velocidad, double diract, double posX, double posY, String piloto) {
		super();
		this.velocidad = velocidad;
		this.diract = diract;
		this.posX = posX;
		this.posY = posY;
		this.piloto = piloto;
	}
	public Coche() {
		this.velocidad = 0;
		this.diract = 0;
		this.posX = 0;
		this.posY = 0;
		this.piloto = null;

	}


	public String toString() {
		return "Coche [velocidad=" + velocidad + ", diract=" + diract + ", posX=" + posX + ", posY=" + posY + ", piloto="
				+ piloto + "]";
		}
	public void acelera(double aceleracion) {
		velocidad+= aceleracion;
	};
	public void gira(double giro) {
		if (giro >= -180 && giro <= 180) {
            diract += giro;
        } else {
            System.out.println("Error.");
        }
	};

	public void mueve(double tiempoMov, Coche coche) {
		double despX = velocidad * Math.cos(Math.toRadians(diract)) ;
        double despY = velocidad * Math.sin(Math.toRadians(diract));
        
        posX +=despX*tiempoMov;
        posY +=despY*tiempoMov;
        
        
        
        if(posX<0 || posX+100 >1000) {
        	diract= 180-diract;
        }
        if(posY<0 || posY +100> 700 ) {
        	diract=-diract;
        }
        coche.setPosX(posX);
        coche.setPosY(posY);
	};
	




}
