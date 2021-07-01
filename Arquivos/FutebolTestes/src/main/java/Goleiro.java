/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Goleiro extends Jogador{
    BigDecimal notaAltura;
    int altura;
    int reflexos;

    public Goleiro(int nota, int gols, String nome, int idade, int numeroCamisa,int altura, int reflexos) {
    super(nota,gols,nome,idade,numeroCamisa);
        this.altura = altura;
        this.notaAltura = this.calculaNotaAltura(this.altura);
        this.reflexos = reflexos;
    }
    
    public BigDecimal calculaNotaAltura(int altura){
        if(altura >= 210){
            var notaAlturaArredondada = BigDecimal.valueOf(100);
            return notaAlturaArredondada;
        }
        else{
            int notaAltura;
            notaAltura = (altura*100)/210
            var notaAlturaArredondada = BigDecimal.valueOf(notaAltura).setScale(2, RoundingMode.HALF_EVEN);
            return notaAlturaArredondada;
        }
    }

    public int getHabilidade(){
        int resultado = 0;
        resultado = (this.notaAltura * 4) + (this.reflexos * 6);
        return resultado;
    }

    public int getAltura(){
        return this.altura;
    }

    public int getNotaAltura(){
        return this.notaAltura;
    }

    public int getReflexos(){
        return this.reflexos;
    }
}
