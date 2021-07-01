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
public class Defensor extends Jogador{
    int cobertura;
    int desarme;

    public Defensor(int gols, String nome, LocalDate nascimento, int numeroCamisa,int cobertura, int desarme) {
    super(gols,nome,nascimento,numeroCamisa);
        this.cobertura = cobertura;
        this.desarme = desarme;
    }

    public int getHabilidade(){
        int resultado = 0;
        resultado = (this.cobertura * 6) + (this.desarme * 4);
        return resultado;
    }

    public int getCobertura(){
        return this.cobertura;
    }

    public int getDesarme(){
        return this.desarme;
    }
}
