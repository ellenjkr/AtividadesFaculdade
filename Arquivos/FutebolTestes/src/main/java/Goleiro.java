/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Goleiro extends Jogador{
    BigDecimal notaAltura;
    int altura;
    int reflexos;

    public Goleiro(int gols, String nome, LocalDate nascimento, int numeroCamisa,int altura, int reflexos) {
    super(gols,nome,nascimento,numeroCamisa);
        this.altura = altura;
        this.notaAltura = this.calculaNotaAltura(this.altura);
        this.reflexos = reflexos;
    }
    
    public BigDecimal calculaNotaAltura(int altura){
        if(altura >= 210){
            BigDecimal notaAlturaArredondada = BigDecimal.valueOf(100);
            return notaAlturaArredondada;
        }
        else{
            float notaAltura;
            notaAltura = (altura*100)/210;
            BigDecimal notaAlturaArredondada = BigDecimal.valueOf(notaAltura).setScale(2, RoundingMode.HALF_EVEN);
            return notaAlturaArredondada;
        }
    }
    
    public int getHabilidade(){
        BigDecimal resultado = BigDecimal.ZERO;
        resultado = this.notaAltura.multiply(BigDecimal.valueOf(4)).add(BigDecimal.valueOf(this.reflexos*6));
        int resultadoInt = resultado.intValue();
        return resultadoInt;
    }

    public int getAltura(){
        return this.altura;
    }

    public BigDecimal getNotaAltura(){
        return this.notaAltura;
    }

    public int getReflexos(){
        return this.reflexos;
    }
}
