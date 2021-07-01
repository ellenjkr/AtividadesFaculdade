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
import java.time.LocalDate;
/**
 *
 * @author Pichau
 */
public class AtacanteTest {
    
    @Test
    public void testGetHabilidade() {
        Atacante atacante = new Atacante(0,"mateus",LocalDate.of(2000, 12, 23),7,80, 95);
        int expResult = (80 * 4) + (95 * 6);
        int result = atacante.getHabilidade();
        assertEquals(expResult, result);
    }

}
