/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.enrique;

/**
 *
 * @author enrique
 */
public class Persona {

    // Atributos de Persona
    private String nombre;
    private int edad;

    // Constructor parametrizado
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Mñetodo llamar despierta al animal
    public void llamar(Animal pet) {
        pet.despertar();
    }

    // Método alimentar el cual da al animal de comer aumentando su peso
    public void alimentar(Animal pet, double cantidadGramos) {
        pet.comer(cantidadGramos);
    }

    // Método jugar el cual controlará el tiempo de juego y reducirá el peso de la mascota.
    public void jugar(Animal pet, int cantidadMinutos) {
        try {
            pet.jugar(cantidadMinutos);
        } catch (IllegalArgumentException e) {
            System.out.println("Tiempo de juego hasta que se canse el animal superado, reducicendo la cantidad de tiempo de juego...");
            cantidadMinutos = Animal.maxJuego;
        }
//        if(cantidadMinutos > Animal.maxJuego){
//            cantidadMinutos = Animal.maxJuego;
//        }
    }
}
