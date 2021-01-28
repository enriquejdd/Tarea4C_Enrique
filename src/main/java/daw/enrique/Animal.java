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

    // Creamos los atributos obligatorios y los generamos como private.
    // Creamos los valores staticos para que se puedan usar en otras clase (contador y maxJuego)
    // Y los atributos que nos ayuden a finalizar la practica.
    private String nombre;
    private TipoAnimal tipo; // 1-gato, 2-perro, 3-lagarto, 4-cobaya, 5-periquito
    private double peso;
    private Estado estado; // 1-comiendo, 2-durmiendo, 3-despierto/reposo, 4-jugando.
    private LocalDate nacimiento;
    public static int contadorInstancias;
    public static final int maxJuego = 180;
    private int tramos;

    // Creamos el constructor por defecto
    public Animal() {
        this.nombre = "Turron";
        this.tipo = TipoAnimal.Gato;
        this.peso = 2200;
        this.estado = Estado.Durmiendo;
        this.nacimiento = LocalDate.now();
        contadorInstancias++;
    }

    // Creamos el constructor con parámetros.
    public Animal(String nombre, TipoAnimal tipo, double peso, Estado estado, LocalDate nacimiento) {
        this.nombre = nombre;
        this.tipo = tipo;
        if (tipo != TipoAnimal.Gato && tipo != TipoAnimal.Perro && tipo != TipoAnimal.Lagarto && tipo != TipoAnimal.Cobaya && tipo != TipoAnimal.Periquito) {
            this.tipo = TipoAnimal.Gato;
        }
        this.peso = peso;
        this.estado = estado;
        if (estado != Estado.Comiendo && estado != Estado.Durmiendo && estado != Estado.Despierto_reposo && estado != Estado.Jugando) {
            this.estado = Estado.Durmiendo;
        }
        this.nacimiento = nacimiento;
        contadorInstancias++;
    }

    // Getters y setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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

    // toString, en el cual hacemos swtch para que muestre el tipo de animal y su estado.
    // Modificamos el return para que se vea mejor visualmente y cambiamos tipo y estado por tipo2 y estado2 para que sean texto
    @Override
    public String toString() {

        return "El animal se llama " + nombre + ", su especie es " + tipo + ", tiene un peso de " + peso + ", se encuentra " + estado + " y nacio el " + nacimiento;
    }

    // Método comer
    public void comer(double cantidadGramos) {
        // Si el valor es negativo lo pasamos a positivo
        if (cantidadGramos < 0) {
            cantidadGramos = cantidadGramos * -1;
            this.peso = peso + cantidadGramos;
        } else {
            this.peso = peso + cantidadGramos;
        }
        this.estado = Estado.Comiendo;
    }

    // Método dormir
    public void dormir() {
        this.estado = Estado.Durmiendo;
    }

    // Método despertar
    public void despertar() {
        this.estado = Estado.Despierto_reposo;
    }

    // Método descansar
    public void descansar() {
        this.estado = Estado.Despierto_reposo;
    }

    // Método jugar
    public void jugar(int cantidadMinutos) {
        this.estado = Estado.Jugando;

        // Si la cantidad de minutos es negativa la pasamos a positiva
        if (cantidadMinutos < 0) {
            cantidadMinutos = cantidadMinutos * -1;
        }
        // Si es mayor a 180 cambiamos su valor, calculamos el peso a quitar y lanzamos el IllegalArgumentException
        if (cantidadMinutos > maxJuego) {
            cantidadMinutos = maxJuego;
            tramos = cantidadMinutos / 30;
            tramos *= 20;

            this.peso = peso - tramos;
            throw new IllegalArgumentException("Tiempo de juego máximo superado");

            // En caso de que no llegue a los 30 minutos le restamos solo 10gr.
        } else if (cantidadMinutos < 30) {
            this.peso = peso - 10;
            // En caso contrario solo realizamos el calculo.
        } else {
            tramos = cantidadMinutos / 30;
            tramos *= 20;

            this.peso = peso - tramos;
        }

    }

    // Método de clase para copiar los datos de las mascotas.
    public static Animal clonar(Animal pet) {
        if (pet == null) {
            return new Animal();
        } else {
            Animal copia = new Animal(pet.nombre, pet.tipo, pet.peso, pet.estado, pet.nacimiento);
            return copia;
        }
    }

    public Animal(Animal pet) {
        this(pet.nombre, pet.tipo, pet.peso, pet.estado, pet.nacimiento);
    }
}
