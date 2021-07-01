/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Atacante extends Jogador{
    int velocidade;
    int tecnica;

    public Atacante(int nota, int gols, String nome, int idade, int numeroCamisa,int velocidade, int tecnica) {
    super(nota,gols,nome,idade,numeroCamisa);
        this.velocidade = velocidade;
        this.tecnica = tecnica;
    }

    public int getHabilidade(){
        int resultado = 0;
        resultado = (this.velocidade * 4) + (this.tecnica * 6);
        return resultado;
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    public int getTecnica(){
        return this.tecnica;
    }
}
