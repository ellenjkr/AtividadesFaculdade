/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class Jogador{
    int gols;
    String nome;
    int idade;
    int numeroCamisa;
    
    public Jogador(int gols, String nome, int idade, int numeroCamisa){
        this.gols = gols;
        this.idade = idade;
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
    }
    
    public void setGols( int gols ){
        this.gols = gols;
    }
    
    public void setNome( String nome ){
        this.nome = nome;
    }
    
    public void setIdade( int idade ){
        this.idade = idade;
    }
    
    public void setNumeroCamisa( int numeroCamisa ){
        this.numeroCamisa = numeroCamisa;
    }
    
    public int getGols(){
        return this.gols;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getIdade(){
        return this.idade;
    }
    
    public int setNumeroCamisa(){
        return this.numeroCamisa;
    }
}
