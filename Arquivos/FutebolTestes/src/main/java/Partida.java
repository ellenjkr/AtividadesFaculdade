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
    
    public String Simulacao(){
        int random = (int) ( Math.random() * 10 ) ;
        //System.out.println("golzão"+random);
        for(int i = 0; i < random; i++){
            if((casa.calculaForca()*(float) ( Math.random() * 1.5 ) + 1.1)>(visitante.calculaForca()*(float) ( Math.random() * 1.4 ) + 1)){
                this.casa.golDe(((int) ( Math.random() * 3 ) + 1), ((int) ( Math.random() * 1 )));               
                this.golsCasa++;
            }else{
                this.visitante.golDe(((int) ( Math.random() * 3 ) + 1), ((int) ( Math.random() * 1 )));
                this.golsVisitante++;
            }
        }

        if(this.golsCasa>this.golsVisitante){
            this.casa.setVitoria();
            this.visitante.setDerrota();
            return this.casa.nome;
        }else if(this.golsCasa<this.golsVisitante){
            this.casa.setDerrota();
            this.visitante.setVitoria();
            return this.visitante.nome;
        }else{
            this.casa.setEmpate();
            this.visitante.setEmpate();
            return "empate";
        }
    }
}
