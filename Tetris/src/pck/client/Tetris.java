package pck.client;

import pck.client.TForma.FormaGeometrica;
import pck.client.TForma.Posicion;
import sun.reflect.generics.tree.BottomSignature;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tetris implements EntryPoint {
	TCanvas canvas;
	TPrincipalTetris prt;
	public void onModuleLoad() {

 canvas=new  TCanvas();
	
		Button btnNoPoli =new Button("JUGAR");
		
		RootPanel.get("siguientePieza").add(btnNoPoli);
		RootPanel.get("tablero").add(canvas.getCanvas());
		

		btnNoPoli.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
			
					OnClickAceptar();
			
			}
		});
		
	}
	
	private void OnClickAceptar(){
		
		if(prt!=null){
		
			prt.Parar();
			RootPanel.get("tablero").remove(canvas.getCanvas());
			canvas=new TCanvas();
			RootPanel.get("tablero").add(canvas.getCanvas());	
			
		}
		prt=new TPrincipalTetris(canvas);
		prt.Ejecutar();
	

	}
	
}

