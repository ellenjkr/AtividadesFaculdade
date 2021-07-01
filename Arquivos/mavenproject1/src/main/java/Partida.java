/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
import java.util.Date;
public class Partida {
    public Date data;
    public Time casa;
    public Time visitante;
    public int golsCasa;
    public int golsVisitante;
    
    public Partida( Date data, Time casa, Time visitante, int golsCasa, int golsVisitante){
        this.data = data;
        this.casa = casa;
        this.visitante = visitante;
        this.golsCasa = golsCasa;
        this.golsVisitante = golsVisitante;
    }
    
    public int getGolsCasa(){
        return this.golsCasa;
    }
    
    public int getGolsVisitante(){
        return this.golsVisitante;
    }
}
