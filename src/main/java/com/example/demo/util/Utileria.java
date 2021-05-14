package com.example.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utileria {

    public static String guardarArchivo(MultipartFile multipart, String ruta){
        //obtenemos el nombre original del archivo
        String nombreOriginal = multipart.getOriginalFilename();
        nombreOriginal.replace(" ", "-");

        String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;

        try {

            //formamos el nombre del archivo para guardarlo en el disco duro
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            //Guardamos fisicamente el archivo en HD
            multipart.transferTo(imageFile);

            return nombreFinal;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /*
    Metodo para generar una cadena aleatoria de longitud N
    */
    public static String randomAlphaNumeric(int count){
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0){
            int character = (int) (Math.random() * CARACTERES.length());
            builder.append( CARACTERES.charAt( character ) );
        }
        return builder.toString();
    }
}
