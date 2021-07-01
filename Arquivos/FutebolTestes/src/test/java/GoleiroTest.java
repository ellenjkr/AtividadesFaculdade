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

/**
 *
 * @author Pichau
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GoleiroTest {
  
    @Test
    public void testGetHabilidade() {
        Goleiro goleiro = new Goleiro(0,0,"kessy",100,7,181,90);
        int expResult = (86 * 4) + (90 * 6);
        int result = goleiro.getHabilidade();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculaNotaAltura(){
        int altura = 181;
        var expResult = BigDecimal.valueOf(86);
        
        Goleiro goleiro = new Goleiro(0,0,"kessy",100,7,181,90)
        var result = goleiro.calculaNotaAltura(goleiro.getAltura());
        
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
