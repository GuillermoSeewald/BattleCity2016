package Mapa;

import Lista.*;
import Obstaculo.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Tester {

	public static void main(String[] args) throws IOException {
		String s="Mapas/Mapa 1.txt";
		Mapa mapa= new Mapa(s);
		String[][] arreglo= new String[mapa.getLongitud()][mapa.getLongitud()];
		int fila=0;int columna=0;
		Iterator<Celda> it;
		for(ListaSimplementeEnlazada<Celda> l: mapa.retornarMapa()){
			it=l.iterator();
			while(it.hasNext()){
				arreglo[fila][columna]=it.next().getNombre();
				columna++;
			}
			columna=0;
			fila++;
		}
		for(int i=0;i<arreglo.length;i++){
			for(int j=0;j<arreglo.length;j++){
				System.out.print(arreglo[i][j].charAt(0));
			}
			System.out.println();
		}
		System.out.println(mapa.getLongitud());
	}
}
