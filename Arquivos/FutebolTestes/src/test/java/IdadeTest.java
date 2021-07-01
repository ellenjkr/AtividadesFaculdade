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
 * @author ellen
 */
public class IdadeTest {
    @Test
    public void testCalculaIdade() {
        LocalDate nascimento = LocalDate.of(2000, 12, 23);
        int idade = Idade.calculaIdade(nascimento, LocalDate.of(2021, 7, 1));
        assertEquals(20, idade);
    }
}