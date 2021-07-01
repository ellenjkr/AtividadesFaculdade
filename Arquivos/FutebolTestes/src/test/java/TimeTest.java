/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pichau
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TimeTest {
    private static final Atacante atacante1 = new Atacante(0,"mateus",100,7,100,100);
    private static final Atacante atacante2 = new Atacante(0,"ellen",100,7,100,100);

    private static final Defensor defensor1 = new Defensor(0,"mateus",100,7,100,100);
    private static final Defensor defensor2 = new Defensor(0,"ellen",100,7,100,100);
        
    private static final Goleiro goleiro1 = new Goleiro(0,"mateus",100,7,100,100);
        
    private static final Time time1 = new Time("time 1");
    
    @BeforeAll
    public static void setUp() {
        time1.adicionarAtacante(atacante1);
        time1.adicionarAtacante(atacante2);
        time1.adicionarDefensor(defensor1);
        time1.adicionarDefensor(defensor2);
        time1.adicionarGoleiro(goleiro1);
    }
    
    @Test
    public void testAdicionarDefensor() {
       assertEquals(false, time1.adicionarDefensor(defensor1));
    }

    @Test
    public void testAdicionarAtacante() {
       assertEquals(false, time1.adicionarAtacante(atacante1));
    }

    @Test
    public void testAdicionarGoleiro() {
       assertEquals(false, time1.adicionarGoleiro(goleiro1));
    }

    @Test
    public void testResultados() {
        int vitorias = 3;
        int empates = 4;
        int expResult = vitorias*3 + empates;

        time1.setVitoria();
        time1.setVitoria();
        time1.setVitoria();

        time1.setEmpate();
        time1.setEmpate();
        time1.setEmpate();
        time1.setEmpate();

        int result = time1.resultados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    @Test
    public void testCalculaForca() {
       int expResult=0;
       int habilidadeAtacante1 = atacante1.getHabilidade();
       int habilidadeAtacante2 = atacante2.getHabilidade();
       int habilidadeDefensor1 = defensor1.getHabilidade();
       int habilidadeDefensor2 = defensor2.getHabilidade();
       int habilidadeGoleiro = goleiro1.getHabilidade();
       
       expResult += habilidadeAtacante1 + habilidadeAtacante2 + habilidadeDefensor1 + habilidadeDefensor2 + habilidadeGoleiro;
       

       int result = time1.calculaForca();
       
       assertEquals(expResult, result);
    }

    @Test
    public void testGolDe() {
        int tipo = 1; // atacante
        int local = 0; // posição
        
        int golsAtacante1 = atacante1.getGols();
        
        time1.golDe(tipo, local); // primeiro atacante fez gol

        int expResult = golsAtacante1 + 1;
        int result = atacante1.getGols(); // gols do primeiro atacante

        assertEquals(expResult, result);
    }
}
