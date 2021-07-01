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
public class JogadorTest {
    
    public JogadorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setNota method, of class Jogador.
     */
    @Test
    public void testSetNota() {
        System.out.println("setNota");
        int nota = 0;
        Jogador instance = null;
        instance.setNota(nota);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGols method, of class Jogador.
     */
    @Test
    public void testSetGols() {
        System.out.println("setGols");
        int gols = 0;
        Jogador instance = null;
        instance.setGols(gols);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Jogador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Jogador instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdade method, of class Jogador.
     */
    @Test
    public void testSetIdade() {
        System.out.println("setIdade");
        int idade = 0;
        Jogador instance = null;
        instance.setIdade(idade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroCamisa method, of class Jogador.
     */
    @Test
    public void testSetNumeroCamisa_int() {
        System.out.println("setNumeroCamisa");
        int numeroCamisa = 0;
        Jogador instance = null;
        instance.setNumeroCamisa(numeroCamisa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNota method, of class Jogador.
     */
    @Test
    public void testGetNota() {
        System.out.println("getNota");
        Jogador instance = null;
        int expResult = 0;
        int result = instance.getNota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGols method, of class Jogador.
     */
    @Test
    public void testGetGols() {
        System.out.println("getGols");
        Jogador instance = null;
        int expResult = 0;
        int result = instance.getGols();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Jogador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Jogador instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdade method, of class Jogador.
     */
    @Test
    public void testGetIdade() {
        System.out.println("getIdade");
        Jogador instance = null;
        int expResult = 0;
        int result = instance.getIdade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroCamisa method, of class Jogador.
     */
    @Test
    public void testSetNumeroCamisa_0args() {
        System.out.println("setNumeroCamisa");
        Jogador instance = null;
        int expResult = 0;
        int result = instance.setNumeroCamisa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
