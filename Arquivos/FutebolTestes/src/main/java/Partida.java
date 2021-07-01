/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */

import java.util.Date;
public class Partida {
    public Date data;
    public Time casa;
    public Time visitante;
    public int golsCasa;
    public int golsVisitante;
    
    public Partida( Date data, Time casa, Time visitante){
        this.data = data;
        this.casa = casa;
        this.casa.visita=false;
        this.visitante = visitante;
        this.visitante.visita=true;
        this.golsCasa = 0;
        this.golsVisitante = 0;
    }
    
    public int getGolsCasa(){
        return this.golsCasa;
    }
    
    public int getGolsVisitante(){
        return this.golsVisitante;
    }
    
    public void Simulacao(){
        int random = (int) ( Math.random() * 10 ) ;// sorteia quantidade de gols

        for(int i = 0; i < random; i++){ // percorre cada gol
            if((casa.calculaForca()*(float) ( Math.random() * 1.5 ) + 1.1)>(visitante.calculaForca()*(float) ( Math.random() * 1.4 ) + 1)){ // Calcula as chances da casa e do visitante randômicamente (casa com vantagem)
                this.casa.golDe(((int) ( Math.random() * 3 ) + 1), ((int) ( Math.random() * 1 ))); // sorteia tipo do jogador e qual deles que fez o gol            
                this.golsCasa++;
            }else{
                this.visitante.golDe(((int) ( Math.random() * 3 ) + 1), ((int) ( Math.random() * 1 )));
                this.golsVisitante++;
            }
        }
    }

    public String defineVencedor(){
        if(this.golsCasa>this.golsVisitante){
            this.casa.setVitoria();
            this.visitante.setDerrota();
            System.out.println("Vencedor: " + this.casa.nome);
            return this.casa.nome;
        }else if(this.golsCasa<this.golsVisitante){
            this.casa.setDerrota();
            this.visitante.setVitoria();
            System.out.println("Vencedor: " + this.visitante.nome);
            return this.visitante.nome;
        }else{
            this.casa.setEmpate();
            this.visitante.setEmpate();
            System.out.println("Empate");
            return "empate";
        }
    }
}
