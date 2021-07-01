/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Goleiro extends Jogador{
    int altura;
    int reflexos;

    public Goleiro(int nota, int gols, String nome, int idade, int numeroCamisa,int altura, int reflexos) {
        super(nota,gols,nome,idade,numeroCamisa);
        this.altura = altura;
        this.reflexos = reflexos;
    }

    public int getHabilidade(){
        int resultado = 0;
        resultado = (this.altura * 4) + (this.reflexos * 6);
        return resultado;
    }

    public int getAltura(){
        return this.altura;
    }

    public int getReflexos(){
        return this.reflexos;
    }
}