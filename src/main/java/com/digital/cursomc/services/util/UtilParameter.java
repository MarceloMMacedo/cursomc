package com.digital.cursomc.services.util;

import java.io.Serializable;
import java.lang.reflect.Field;

public class UtilParameter {

	public static Serializable clonarentity(Serializable fonte, Serializable destino, String[] campos) {
		Class classefonte = fonte.getClass();
		Class classedestino = destino.getClass();
 
		Field fldfonte = null;
		Field fldDestino = null; 
		for (String string : campos) {
 

			try {

				fldfonte = classefonte.getDeclaredField(string);
				fldfonte.setAccessible(true); 

				fldDestino = classedestino.getDeclaredField(string);
				fldDestino.setAccessible(true); 
//
				if (fldfonte != null) { 
//					
//					//Pegar valor fonte
					fldfonte.setAccessible(true);
					Object value = fldfonte.get(fonte); 
//
//					//Escrever Valor destino
					if (value != null) {
						fldDestino.setAccessible(true);
						fldDestino.set(destino, value);
					}
				}
			} catch (SecurityException | IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
				//System.out.println(e);
			}
		}

		return destino;
	}

}
