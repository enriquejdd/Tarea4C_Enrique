/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.enrique;

import java.time.LocalDate;

/**
 *
 * @author enrique
 */
public class Animal {

    private String nombre;
    private int tipo; // 1-gato, 2-perro, 3-lagarto, 4-cobaya, 5-periquito
    private double peso;
    private int estado; // 1-comiendo, 2-durmiendo, 3-despierto/reposo, 4-jugando.
    private LocalDate nacimiento;
    private int contadorInstancias = 0;
    public static int maxJuego = 180;

    public Animal() {
        this.nombre = "Turron";
        this.tipo = 1;
        this.peso = 2200;
        this.estado = 2;
        this.nacimiento = LocalDate.now();
        contadorInstancias++;
    }

    public Animal(String nombre, int tipo, double peso, int estado, LocalDate nacimiento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.estado = estado;
        this.nacimiento = nacimiento;
        contadorInstancias++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getContadorInstancias() {
        return contadorInstancias;
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", tipo=" + tipo + ", peso=" + peso + ", estado=" + estado + ", nacimiento=" + nacimiento + ", contadorAnimales=" + contadorInstancias + '}';
    }

    public void comer(double cantidadGramos) {
        if (cantidadGramos < 0) {
            cantidadGramos = cantidadGramos * -1;
            this.peso = +cantidadGramos;
        } else {
            this.peso = +cantidadGramos;
        }
    }

    public void dormir() {
        this.estado = 2;
    }

    public void despertar() {
        this.estado = 3;
    }

    public void descansar() {
        this.estado = 3;
    }

    public void jugar(int cantidadMinutos) {
        this.estado = 4;

        if (cantidadMinutos < 0) {
            cantidadMinutos = cantidadMinutos * -1;

            if (cantidadMinutos > maxJuego) {
                throw new IllegalArgumentException("Tiempo de juego máximo superado");
            } else if (cantidadMinutos < 30) {
                this.peso -= 10;
            } else {
                int tramos = cantidadMinutos % 30;
                tramos *= 20;

                this.peso = -tramos;
            }
        } else {
            if (cantidadMinutos > maxJuego) {
                throw new IllegalArgumentException("Tiempo de juego máximo superado");
            } else if (cantidadMinutos < 30) {
                this.peso -= 10;
            } else {
                int tramos = cantidadMinutos % 30;
                tramos *= 20;

                this.peso = -tramos;
            }
        }

    }
}
