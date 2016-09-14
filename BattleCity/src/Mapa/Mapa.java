package Mapa;

import Obstaculo.*;
import Lista.*;
import Tanque.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mapa{
	private Celda[][] obstaculos;
	private Tanque jugador;
	private Tanque[] enemigos;
	
	public Mapa(String mapa){
		jugador= new Jugador();
		obstaculos=new Celda[26][26];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
	}
		
	
	
	public int getLongitud(){
		return obstaculos.length;
	}
	public Iterable<ListaSimplementeEnlazada<Celda>> retornarMapa(){
		PositionList<ListaSimplementeEnlazada<Celda>> lista= new ListaSimplementeEnlazada<ListaSimplementeEnlazada<Celda>>();
		ListaSimplementeEnlazada<Celda> listaAux= new ListaSimplementeEnlazada<Celda>();
		for(int i=0;i<getLongitud();i++){
			for(int j=0;j<getLongitud();j++){
				listaAux.addLast(obstaculos[i][j]);
			}
			lista.addLast(listaAux);
			listaAux= new ListaSimplementeEnlazada<Celda>();
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void cargarMapa(String map) throws IOException, FileNotFoundException{
		String cadena;
		char[] c;
		int fila=0;
		FileReader f= new FileReader(map);
		BufferedReader b= new BufferedReader(f);
		while((cadena=b.readLine())!=null){
			c=cadena.toCharArray();
			for(int i=0;i<c.length;i++){
				if(c[i]=='A'){
					obstaculos[fila][i]= new Acero();
				}
				else{
					if(c[i]=='L'){
						obstaculos[fila][i]= new Ladrillo();
					}
					else{
						if(c[i]=='G'){
							obstaculos[fila][i]= new Agua();
						}
						else{
							if(c[i]=='C'){
								obstaculos[fila][i]= new Cesped();
							}
							else{
								if(c[i]=='N'){
									obstaculos[fila][i]= new Vacio();
								}
								else{
									if(c[i]=='B'){
										obstaculos[fila][i]= new Bandera();
									}
								}
							}
						}
					}
				}
			}
			fila++;
		}
		b.close();
	}
}