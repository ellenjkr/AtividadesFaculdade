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
import java.time.LocalDate;
public class GoleiroTest {
  
    @Test
    public void testGetHabilidade() {
        Goleiro goleiro = new Goleiro(0,"kessy",LocalDate.of(2000, 12, 23),7,181,90);
        int expResult = (86 * 4) + (90 * 6);
        int result = goleiro.getHabilidade();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalculaNotaAltura(){
        int altura = 181;
        BigDecimal expResult = BigDecimal.valueOf(86).setScale(2);
        
        Goleiro goleiro = new Goleiro(0,"kessy",LocalDate.of(2000, 12, 23),7,181,90);
        BigDecimal result = goleiro.calculaNotaAltura(goleiro.getAltura());
        
        assertEquals(expResult, result);
    }
}
