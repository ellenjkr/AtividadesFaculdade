/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pichau
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PartidaTest {
    private static final Atacante atacante1 = new Atacante(0,"mateus",100,7,100,100);
    private static final Atacante atacante2 = new Atacante(0,"ellen",100,7,100,100);

    private static final Defensor defensor1 = new Defensor(0,"mateus",100,7,100,100);
    private static final Defensor defensor2 = new Defensor(0,"ellen",100,7,100,100);

    private static final Goleiro goleiro1 = new Goleiro(0,"mateus",100,7,100,100);

    private static final Time time1 = new Time("time 1");
    private static final Time time2 = new Time("time 2");
    
    private static final Date data = new Date();

    private static Partida partida1;
    
    @BeforeAll
    public static void setUp() {
        time1.adicionarAtacante(atacante1);
        time1.adicionarAtacante(atacante2);
        time1.adicionarDefensor(defensor1);
        time1.adicionarDefensor(defensor2);
        time1.adicionarGoleiro(goleiro1);

        time2.adicionarAtacante(atacante1);
        time2.adicionarAtacante(atacante2);
        time2.adicionarDefensor(defensor1);
        time2.adicionarDefensor(defensor2);
        time2.adicionarGoleiro(goleiro1);

        partida1 = new Partida(data, time1, time2);
    }
    
    @Test
    public void testSimulacao() {
        System.out.println("Simulacao");
        /*
        Partida instance = null;
        String expResult = "";
        String result = instance.Simulacao();
        assertEquals(expResult, result);*/
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
