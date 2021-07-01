import java.util.ArrayList;

public class Campeonato {

    ArrayList<Time> times = new ArrayList<Time>();
    
    ArrayList<Partida> partidas = new ArrayList<Partida>();

    public void cadastrarTime(Time time){
        this.times.add(time);
    }

    public void cadastrarPartida(Partida partida){
        this.partidas.add(partida);
    }
}