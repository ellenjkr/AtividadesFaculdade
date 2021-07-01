

import java.util.ArrayList;
import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class teste {
    public static void main(String[] args){
        
        int sorteio;
        sorteio = (int) ( Math.random() * 100 ) + 1;
        
        Atacante atacante1 = new Atacante(0,0,"mateus",100,7,100,100);
        Atacante atacante2 = new Atacante(0,0,"ellen",100,7,100,100);

        Defensor defensor1 = new Defensor(0,0,"mateus",100,7,100,100);
        Defensor defensor2 = new Defensor(0,0,"ellen",100,7,100,100);
        
        Goleiro goleiro1 = new Goleiro(0,0,"mateus",100,7,100,100);
        
        Time time1 = new Time("time 1");
        
        time1.adicionarAtacante(atacante1);
        time1.adicionarAtacante(atacante2);
        time1.adicionarDefensor(defensor1);
        time1.adicionarDefensor(defensor2);
        time1.adicionarGoleiro(goleiro1);
        
        Time time2 = new Time("time 2");
        
        time2.adicionarAtacante(atacante1);
        time2.adicionarAtacante(atacante2);
        time2.adicionarDefensor(defensor1);
        time2.adicionarDefensor(defensor2);
        time2.adicionarGoleiro(goleiro1);
        
        Date data = new Date();
        Partida partida1 = new Partida(data, time1, time2);
        for(int i=0;i<10;i++){
            System.out.println(new Partida(data, time1, time2).Simulacao());
        } 
       
       
       
    }
}
