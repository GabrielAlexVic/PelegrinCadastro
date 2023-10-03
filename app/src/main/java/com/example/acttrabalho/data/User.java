package com.example.acttrabalho.data;

import java.io.Serializable;

public class User {
    String name;
    String age;
    String address;

    public String getName() {
        return name;
        /**
         * Obtém o nome do usuário.
         *
         * @return O nome do usuário como uma string.
         */
    }
    public void setName(String name) {
        this.name = name;
        /**
         * Define o nome do usuário.
         *
         * @param nome O novo nome a ser definido para o usuário.
         */
    }
    public String getAge() {
        return age;
        /**
         * Obtém a idade do usuário.
         *
         * @return A idade do usuário como uma string.
         */
    }
    public void setAge(String age) {
        this.age = age;
        /**
         * Define a idade do usuário.
         *
         * @param age A idade do usuário, como uma string.
         */
    }
    public String getAddress() {
        return address;
        /**
         * Obtém o endereço do objeto.
         *
         * @return O endereço do objeto.
         */
    }
    public void setAddress(String address) {
        this.address = address;
        /**
         * Define o endereço do objeto.
         *
         * O endereço é um identificador único do objeto no sistema.
         *
         * @param address O novo endereço do objeto.
         */
    }
}
