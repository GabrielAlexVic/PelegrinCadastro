package com.example.acttrabalho.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
    private static Gson gson;
    /**

     A classe Utils fornece utilitários para trabalhar com JSON.

     Ela fornece um método estático para obter um objeto Gson, que pode ser usado para serializar e deserializar objetos JSON.
     */
    public static Gson getGsonParser() {
        if(null == gson) {
            GsonBuilder builder = new GsonBuilder();
            gson = builder.create();
        }
        return gson;
    }
}
