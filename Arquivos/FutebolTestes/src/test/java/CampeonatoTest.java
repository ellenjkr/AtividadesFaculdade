/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ellen
 */
public class CampeonatoTest {

    private static ArrayList<Time> times = new ArrayList<Time>();
    
    private static final Atacante atacante = new Atacante(0,"mateus",LocalDate.of(2000, 12, 23),7,100,100);
    private static final Defensor defensor = new Defensor(0,"ellen",LocalDate.of(2000, 12, 23),7,100,100);
    private static final Goleiro goleiro = new Goleiro(0,"kessy",LocalDate.of(2000, 12, 23),7,100,100);
    
    private static Campeonato campeonato = new Campeonato();
    
    @Test 
    public void testCadastrarTime(){
        Time time;
        for(int i=0; i <4; i++){
            time = new Time("time " + i+1);
            time.adicionarDefensor(defensor);
            time.adicionarDefensor(defensor);
            time.adicionarAtacante(atacante);
            time.adicionarAtacante(atacante);
            time.adicionarGoleiro(goleiro);
            
            campeonato.cadastrarTime(time);
        }
        assertEquals(4, campeonato.getTimes().size());
        
    }
    
    @Test 
    public void testCadastrarPartida(){
        Time time;
        for(int i=0; i <4; i++){
            time = new Time("time " + i+1);
            time.adicionarDefensor(defensor);
            time.adicionarDefensor(defensor);
            time.adicionarAtacante(atacante);
            time.adicionarAtacante(atacante);
            time.adicionarGoleiro(goleiro);
            
            this.times.add(time);
        }

        Partida partida;
        for(int i=0;i<4;i+=2){
            partida=new Partida(new Date(),this.times.get(i),this.times.get(i+1));
            campeonato.cadastrarPartida(partida);
        }
        assertEquals(2, campeonato.getPartidas().size());
        
    }

}