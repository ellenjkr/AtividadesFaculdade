/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
import java.time.LocalDate;
import java.time.Period;

public class Idade {
    public static int calculaIdade(LocalDate nascimento, LocalDate dataAtual) {
        if ((nascimento != null) && (dataAtual != null)) {
            return Period.between(nascimento, dataAtual).getYears();
        } else {
            return 0;
        }
    }
}
