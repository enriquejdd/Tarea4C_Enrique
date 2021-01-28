/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.programa;

import daw.enrique.Animal;
import daw.enrique.Estado;
import daw.enrique.Persona;
import daw.enrique.TipoAnimal;
import java.time.LocalDate;

/**
 *
 * @author enrique
 */
public class Prueba {

    public static void main(String[] args) {
        // Crea dos objetos animal (a1 y a2), uno por defecto y otro con los valores que tú quieras. 
        Animal a1 = new Animal("Perri", TipoAnimal.Perro, 3500, Estado.Despierto_reposo, LocalDate.of(2017, 7, 14));
        Animal a2 = new Animal();

        // Crea dos personas (p1 y p2) con los valores que tú quieras.
        Persona p1 = new Persona("Enrique", 21);
        Persona p2 = new Persona("Carmen", 12);

        //Imprime por consola los valores de a1 y a2 usando toString.
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println("");

        // Imprime por consola el valor del contador de instancias.
        System.out.println(a2.getContadorInstancias());
        System.out.println("");

        // Clona al animal a2 en un nuevo animal a3.
        Animal a3 = Animal.clonar(a2);
        System.out.println(a3.toString());
        System.out.println("");
//        Animal a3 = new Animal(a1);
//        System.out.println(a3.toString());
//        System.out.println("");

        // Imprime por consola el valor del contador de instancias.
        System.out.println(Animal.contadorInstancias);
        System.out.println("");

        //p1 debe despertar a todos los animales.
        p1.llamar(a1);
        p1.llamar(a2);
        p1.llamar(a3);
//        System.out.println(a1.getEstado());
//        System.out.println(a2.getEstado());
//        System.out.println(a3.getEstado());

        // p2 juega con a2 durante 120 minutos.
        p2.jugar(a2, 120);
//        System.out.println(a2.getPeso());

        // p1 alimenta a a1 1000 gramos. Imprime el nuevo peso de a1.
        p1.alimentar(a1, 1000);
        System.out.println(a1.getPeso());
        System.out.println("");

        // p1 debe jugar con a1 200 minutos. Imprime el nuevo peso de a1.
        p1.jugar(a1, 200);
        System.out.println(a1.getPeso());

    }
}
