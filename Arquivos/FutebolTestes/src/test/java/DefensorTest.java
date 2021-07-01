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
public class DefensorTest {
    
    @Test
    public void testGetHabilidade() {
        Defensor defensor = new Defensor(0,0,"ellen",100,7,80,100);
        int expResult = (80 * 6) + (100 * 4);
        int result = defensor.getHabilidade();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }    
}
