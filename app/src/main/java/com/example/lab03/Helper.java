package com.example.lab03;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Helper {
    Context context;

    public Helper(ArrayList<Postulante> lista, Context context) {
        //this.lista = lista;
        this.context = context;
    }
    public Helper(Context context){
        this.context=context;
    }
    // Método que guarda la lista a un archivo interno
    public void GuardaEnArchivo(ArrayList<Postulante> lista) {
        // El objeto File me permite acceder el archivo (en este caso, para escribir en él)
        // (obtengo la ruta donde almacenarlo; en la carpeta de la app)
        File ruta = context.getApplicationContext().getFilesDir();
        // Éste es el nombre del archivo
        String nombreArch = "archivo.txt";

        // El acceso a archivo tiene que ir en un try catch por si sucede algo inesperado
        try {
            FileOutputStream escribirArch = new FileOutputStream(new File(ruta,nombreArch));
            // Tengo que usar un ObjectOutputStream porque el almacenamiento interno es un archivo de bytes
            // y este objeto es el que me permite convertir de objeto a byte. Si fuera un String u otra cosa,
            // bastaría escribirArch.write(lacadena.getBytes())
            // suponiendo que lacadena es un String que contiene el texto a guardar.
            ObjectOutputStream streamArch = new ObjectOutputStream(escribirArch);
            streamArch.writeObject(lista);
            streamArch.close();
        } catch (Exception e) {
            e.printStackTrace();        // Si hay error, que muestre datos sobre el fallo
        }
    }

    // Método que lee del archivo y lo pone en la lista
    public ArrayList<Postulante> LeeDelArchivo() {
        ArrayList<Postulante> lista = null;
        // El objeto File con la ruta donde almacenarlo
        File ruta = context.getApplicationContext().getFilesDir();
        // Éste es el nombre del archivo
        String nombreArch = "archivo.txt";


        // Leo los datos del archivo
        try {
            // FileInputStream me permite abri el archivo para leer de él
            FileInputStream leeArch = new FileInputStream (new File(ruta,nombreArch));
            // El ObjectInputStream me pemite traducir el arreglo de bytes al Arraylist
            ObjectInputStream streamArch = new ObjectInputStream (leeArch);
            // Leo todo y lleno la lista
            lista = (ArrayList<Postulante>) streamArch.readObject();
            // Cierro el stream
            streamArch.close();
        } catch (Exception e) {
            e.printStackTrace();        // Si hay error, que muestre datos sobre el fallo
        }
        return lista;
    }

}



