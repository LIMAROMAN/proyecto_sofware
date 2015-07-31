package pck.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;

public class TForma{

	public class Nodo{
		public double x;
		public double y;
	}
	public enum FormaGeometrica{ELE_INV,ELE, TE,CUADRO,ESE,ZETA,LINIA};//tipo de forma
	public enum Posicion{N0,N90,N180,N270};//posicion de giro
	
	private TCanvas canvas; 
	private Context2d context;
	private double x,y;
	private double h;//altura de la forma
	
	private FormaGeometrica formaGeometrica;
	private Posicion posicion;
	private int desplazamiento;
	private Nodo[][] structFiguras;
	
	
////////////////////////////////PROPIEDADES////////////////////////////////////////////////////////
	
	public Nodo[] getStructura() {
		
			 int index=obtenerNodo();
					
		return structFiguras[index];
	}
	public double getH() {
		return h;
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		ActualizarStruct(obtenerNodo(), x, y);	
		return y;
	}
	
////////////////////////////////////////////CONSTRUCTOR////////////////////////////////////////////////////////
	
	public TForma(TCanvas _canvas,FormaGeometrica _formaGeometrica,Posicion _posicion,double _x,double _y)
	{

		structFiguras=new Nodo[7][];
		for(int i=0;i<7;i++){
			structFiguras[i]=new Nodo[4]; //ELE_INV
			for(int j=0;j<4;j++){
				structFiguras[i][j]=new Nodo();
				
			}//end for
		}//end for
	    
	    //structFiguras[0][0].x=1;
	    
		canvas=_canvas;
		context=canvas.getContext();
		
		formaGeometrica=_formaGeometrica;
		posicion=_posicion;
		x=_x;
		y=_y;
		desplazamiento=10;
		ActualizarStruct(obtenerNodo(), x, y);
		
		//x=10;
	    //y=10;
	}//end class

	public void ActualizarStruct(int index,double x, double y){
		  
		  if(formaGeometrica==FormaGeometrica.ELE_INV){
			
			  if(posicion==Posicion.N0){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x;
				  structFiguras[index][1].y=y+10; 
				  
				  structFiguras[index][2].x=x-10;
				  structFiguras[index][2].y=y+10;
				  
				  structFiguras[index][3].x=x;
				  structFiguras[index][3].y=y-10;  
			  }//end if
			  
			  if(posicion==Posicion.N90){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x-10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x-10;
				  structFiguras[index][2].y=y-10;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y;  
			  }//end if
			  if(posicion==Posicion.N180){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x;
				  structFiguras[index][1].y=y+10; 
				  
				  structFiguras[index][2].x=x;
				  structFiguras[index][2].y=y-10;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y-10;  
			  }//end if
			  if(posicion==Posicion.N270){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x-10;
				  structFiguras[index][1].y=y; 
				  
				  structFiguras[index][2].x=x+10;
				  structFiguras[index][2].y=y;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y+10;  
			  }//end if
		}//end if
		  if(formaGeometrica==FormaGeometrica.ELE){
				
			  if(posicion==Posicion.N0){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x;
				  structFiguras[index][1].y=y+10;
				  
				  structFiguras[index][2].x=x;
				  structFiguras[index][2].y=y-10;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y+10;  
			  }//end if
			  if(posicion==Posicion.N90){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x+10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x-10;
				  structFiguras[index][2].y=y;
				  
				  structFiguras[index][3].x=x-10;
				  structFiguras[index][3].y=y+10;  
			  }//end if
			  
			  if(posicion==Posicion.N180){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x;
				  structFiguras[index][1].y=y+10;
				  
				  structFiguras[index][2].x=x;
				  structFiguras[index][2].y=y-10;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y-10;  
			   }//end if
			  if(posicion==Posicion.N270){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x-10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x+10;
				  structFiguras[index][2].y=y;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y-10;  
			  }//end if
            }//end if
		  if(formaGeometrica==FormaGeometrica.TE){
				
			  if(posicion==Posicion.N0){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x-10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x+10;
				  structFiguras[index][2].y=y;
				  
				  structFiguras[index][3].x=x;
				  structFiguras[index][3].y=y+10;
				  
				  }//end if
			  if(posicion==Posicion.N90){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x-10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x;
				  structFiguras[index][2].y=y+10;
				  
				  structFiguras[index][3].x=x;
				  structFiguras[index][3].y=y-10;
				  
				  }//end if
			  if(posicion==Posicion.N180){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x+10;
				  structFiguras[index][1].y=y;
				  
				  structFiguras[index][2].x=x-10;
				  structFiguras[index][2].y=y;
				  
				  structFiguras[index][3].x=x;
				  structFiguras[index][3].y=y-10;
				  
				  }//end if
			  if(posicion==Posicion.N270){
				  structFiguras[index][0].x=x;
				  structFiguras[index][0].y=y;
				  
				  structFiguras[index][1].x=x;
				  structFiguras[index][1].y=y+10;
				  
				  structFiguras[index][2].x=x;
				  structFiguras[index][2].y=y-10;
				  
				  structFiguras[index][3].x=x+10;
				  structFiguras[index][3].y=y;
				  
				  }//end if
			  }//end if
			  if(formaGeometrica==FormaGeometrica.ZETA){
					
				  if(posicion==Posicion.N0 ){
					 
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  
					  structFiguras[index][1].x=x-10;
					  structFiguras[index][1].y=y;
					  
					  structFiguras[index][2].x=x;
					  structFiguras[index][2].y=y+10;
					  
					  structFiguras[index][3].x=x+10;
					  structFiguras[index][3].y=y+10;
					  }//end if
				  if( posicion==Posicion.N180){
					  
					 
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  
					  structFiguras[index][1].x=x-10;
					  structFiguras[index][1].y=y;
					  
					  structFiguras[index][2].x=x;
					  structFiguras[index][2].y=y+10;
					  
					  structFiguras[index][3].x=x+10;
					  structFiguras[index][3].y=y+10;
					
					  
					 
					  
					
					  
					  }//end if
				  if(posicion==Posicion.N90){
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  structFiguras[index][3].x=x;
					  structFiguras[index][3].y=y-10;
					  structFiguras[index][2].x=x-10;
					  structFiguras[index][2].y=y;
					  structFiguras[index][1].x=x-10;
					  structFiguras[index][1].y=y+10;
					  }
				  if( posicion==Posicion.N270){
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  structFiguras[index][3].x=x;
					  structFiguras[index][3].y=y-10;
					  structFiguras[index][2].x=x-10;
					  structFiguras[index][2].y=y;
					  structFiguras[index][1].x=x-10;
					  structFiguras[index][1].y=y+10;
					  
					  }
				  //end if
				  }//end if
			  if(formaGeometrica==FormaGeometrica.ESE){
					
				  if(posicion==Posicion.N0|| posicion==Posicion.N180){
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  
					  structFiguras[index][1].x=x-10;
					  structFiguras[index][1].y=y;
					  
					  structFiguras[index][2].x=x;
					  structFiguras[index][2].y=y-10;
					  
					  structFiguras[index][3].x=x+10;
					  structFiguras[index][3].y=y-10;
					  
					  }//end if
				  if(posicion==Posicion.N90 || posicion==Posicion.N270){
					  structFiguras[index][0].x=x;
					  structFiguras[index][0].y=y;
					  
					  structFiguras[index][1].x=x;
					  structFiguras[index][1].y=y-10;
					  
					  structFiguras[index][2].x=x+10;
					  structFiguras[index][2].y=y;
					  
					  structFiguras[index][3].x=x+10;
					  structFiguras[index][3].y=y+10;
					  
					  }//end if
				 
				  }//end if
				  if(formaGeometrica==FormaGeometrica.LINIA){
						
					  if(posicion==Posicion.N0|| posicion==Posicion.N180){
						  structFiguras[index][0].x=x;
						  structFiguras[index][0].y=y;
						  
						  structFiguras[index][1].x=x;
						  structFiguras[index][1].y=y-10;
						  
						  structFiguras[index][2].x=x;
						  structFiguras[index][2].y=y+10;
						  
						  structFiguras[index][3].x=x;
						  structFiguras[index][3].y=y+20;
						  }
					  if(posicion==Posicion.N90|| posicion==Posicion.N270){
						  structFiguras[index][0].x=x;
						  structFiguras[index][0].y=y;
						  
						  structFiguras[index][1].x=x-10;
						  structFiguras[index][1].y=y;
						  
						  structFiguras[index][2].x=x+10;
						  structFiguras[index][2].y=y;
						  
						  structFiguras[index][3].x=x+20;
						  structFiguras[index][3].y=y;
						  }//end if
					  }//end if
				  if(formaGeometrica==FormaGeometrica.CUADRO){
						
					  if(posicion==Posicion.N0 ||posicion==Posicion.N90||posicion==Posicion.N180|| posicion==Posicion.N270){
						  structFiguras[index][0].x=x;
						  structFiguras[index][0].y=y;
						  
						  structFiguras[index][1].x=x+10;
						  structFiguras[index][1].y=y;
						  
						  structFiguras[index][2].x=x;
						  structFiguras[index][2].y=y+10;
						  
						  structFiguras[index][3].x=x+10;
						  structFiguras[index][3].y=y+10;
						  }//end if
					  
					  }//end if
				  }//end function
	private int obtenerNodo(){
		int index=-1;
		if(formaGeometrica==FormaGeometrica.ELE_INV){
			index=0;	//Window.alert(Double.toString(temp[0][0].x));
		}
		if(formaGeometrica==FormaGeometrica.ELE){
			index=1;
		}
		if(formaGeometrica==FormaGeometrica.TE){
			index=2;
		}
		if(formaGeometrica==FormaGeometrica.ZETA){
			index=3;
		}
		if(formaGeometrica==FormaGeometrica.ESE){
			index=4;
		}
		if(formaGeometrica==FormaGeometrica.LINIA){
			index=5;
		}
		if(formaGeometrica==FormaGeometrica.CUADRO){
			index=6;
		}
		return index;
	}
	///////////////////////////////////////METODOS PUBLICOS////////////////////////////////////////////////////
	public void moverAbajo(){
	
		if(LimpiarForma()==true){
	     	y+=desplazamiento;
		    ActualizarStruct(obtenerNodo(), x, y);
		    GraficarForma();
		}
	}

	public void moverAbajo(int i){
		
		if(LimpiarForma(i)==true){
	     	y+=desplazamiento;
		    ActualizarStruct(obtenerNodo(), x, y);
		    GraficarForma();
		}
	}
	
	 public void moverDerecha(){
		
		if(LimpiarForma()==true){
		x+=desplazamiento;
		ActualizarStruct(obtenerNodo(), x, y);
		GraficarForma();
		}
	}
	public void moverIzquierda(){
		
		
		if(LimpiarForma()==true){
		x-=desplazamiento;
		ActualizarStruct(obtenerNodo(), x, y);
		GraficarForma();
		}
	}
	public void girarDerecha(){
		//if (x>10  & x <150 || y<300){
			if(LimpiarForma()==true){
				if(posicion==Posicion.N0){
					posicion=Posicion.N90;
					ActualizarStruct(obtenerNodo(), x, y);
					GraficarForma();
				}
				else if(posicion==Posicion.N90){
					posicion=Posicion.N180;
					ActualizarStruct(obtenerNodo(), x, y);
					GraficarForma();
				}
				else if(posicion==Posicion.N180){
					posicion=Posicion.N270;
					ActualizarStruct(obtenerNodo(), x, y);
					GraficarForma();
				}
				else if(posicion==Posicion.N270){
					posicion=Posicion.N0;
					ActualizarStruct(obtenerNodo(), x, y);
					GraficarForma();
				}
				}
		//}
		
	}
	public void girarIzquierda(){
		//if( x>10  & x <150 || y<300){
		if(LimpiarForma()==true){
		if(posicion==Posicion.N0){
			posicion=Posicion.N270;
			ActualizarStruct(obtenerNodo(), x, y);
			GraficarForma();
		}
		else if(posicion==Posicion.N270){
			posicion=Posicion.N180;
			ActualizarStruct(obtenerNodo(), x, y);
			GraficarForma();
		}
		else if(posicion==Posicion.N180){
			posicion=Posicion.N90;
			ActualizarStruct(obtenerNodo(), x, y);
			GraficarForma();
		}
		else if(posicion==Posicion.N90){
			posicion=Posicion.N0;
			ActualizarStruct(obtenerNodo(), x, y);
			GraficarForma();
		//}
		}}
	}//end class
	public void GraficarForma()
	{
		int index=obtenerNodo();
		
		for(int i=0;i<4;i++){
			if(index==0){
				context.setFillStyle("Yellow");
				context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);
			}//end if
				
				if(index==1){
					context.setFillStyle("Green");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
				if(index==2){
					context.setFillStyle("Red");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
				if(index==3){
					context.setFillStyle("Violet");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
				if(index==4){
					context.setFillStyle("Blue");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
				if(index==5){
					context.setFillStyle("Brown");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
				if(index==6){
					context.setFillStyle("Turquoise");
					context.fillRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);	
				}//end if
			
		}//end for
			//context.beginPath();//beginPath () método cada vez que queremos empezar a dibujar un nuevo figura
			//El método fillRect () dibuja un rectángulo "lleno". El color por defecto del relleno es negro.
			//context.setFillStyle("red");
			//context.fillRect(structFiguras[index][1].x, structFiguras[index][1].y, 10, 10);
			//context.setFillStyle("red");
			//context.fillRect(structFiguras[index][2].x, structFiguras[index][2].y, 10, 10);
			//context.setFillStyle("red");
			//context.fillRect(structFiguras[index][3].x, structFiguras[index][3].y, 10,10);
			//context.closePath();	
		    		
	 }//end function	
		
	public boolean LimpiarForma()
	{
		 int index=obtenerNodo();
		 
			for(int i=0;i<4;i++){
				context.clearRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);
				
			}
			return true;
			
	}
	public boolean LimpiarForma(int i)
	{
		int index=obtenerNodo();
		
			context.clearRect(structFiguras[index][i].x, structFiguras[index][i].y, 10, 10);
			
		
			return true;
			
	}
	
	//end function
	/*
public void limpiarFila(){
	int numFilasLena=0;
	for(int i=canvas.getContext().getCanvas().getHeight();i>=0;--i){
		 boolean filallena=true;
}*/}

//end class