import java.util.Date;

public class Main {
    public static void main(String args[]){
        Goleiro goleiro = new Goleiro(100, 2, "goleiro", 20, 8, 159, 80);
        Atacante atacante1 = new Atacante(90, 5, "atacante 1", 21, 10, 95, 80);
        Atacante atacante2 = new Atacante(80, 7, "atacante 2", 22, 9, 90, 85);
        Defensor defensor1 = new Defensor(90, 1, "defensor 1", 25, 7, 90, 75);
        Defensor defensor2 = new Defensor(85, 2, "defensor 2", 26, 6, 80, 85);
        
        Time time1 = new Time("time1");
        time1.adicionarGoleiro(goleiro);
        time1.adicionarAtacante(atacante1);
        time1.adicionarAtacante(atacante2); 
        time1.adicionarDefensor(defensor1);
        time1.adicionarDefensor(defensor2);

        Goleiro goleiro2 = new Goleiro(100, 2, "goleiro", 20, 8, 159, 80);
        Atacante atacante3 = new Atacante(90, 5, "atacante 1", 21, 10, 95, 80);
        Atacante atacante4 = new Atacante(80, 7, "atacante 2", 22, 9, 90, 85);
        Defensor defensor3 = new Defensor(90, 1, "defensor 1", 25, 7, 90, 75);
        Defensor defensor4 = new Defensor(85, 2, "defensor 2", 26, 6, 80, 85);

        Time time2 = new Time("time2");
        time2.adicionarGoleiro(goleiro2);
        time2.adicionarAtacante(atacante3);
        time2.adicionarAtacante(atacante4); 
        time2.adicionarDefensor(defensor3);
        time2.adicionarDefensor(defensor4);

        Partida partida = new Partida(new Date(), time1, time2, 2, 3);
    }
}

// REMOVER A NOTA, A NOTA É A HABILIDADE E ESSA DEVE SER CALCULADA
// LIMITAR OS VALORES DE 0 A 100
// CALCULAR ALTURA COM O HALF EVEN
// GOLS TAMBÉM NAO VAI NO CONSTRUTOR, GOLS SÃO ADICIONADOS CONFORME AS PARTIDAS ACONTECEM
// A IDADE ATUAL DEVE SER CALCULADA ENTAO TEM QUE FORNECER A DATA DE NASCIMENTO E NAO A IDADE
// O NUMERO DE CAMISA NAO PODE REPETIR
// TIME SO PODE TER 5 JOGADORES SENDO 1 GOLEIRO 2 ATACANTES E 2 DEFENSORES
// NO FINAL DE CADA PARTIDA TEM QUE ATUALIZAR A QUANTIDADE DE VITORIAS, EMPATES OU DERROTAS
// NO FINAL DE CADA PARTIDA DEVE SER CALCULADO O RESULTADO SOMANDO OS PONTOS
