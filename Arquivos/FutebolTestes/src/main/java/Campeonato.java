import java.util.ArrayList;

public class Campeonato {

    private ArrayList<Time> times ;
    
    private ArrayList<Partida> partidas;

    public Campeonato(){
        this.partidas= new ArrayList<Partida>();
        this.times  = new ArrayList<Time>();
    }

    public void cadastrarTime(Time time){
        this.times.add(time);
    }

    public ArrayList<Time> getTimes(){
        return times;
    }

    public void cadastrarPartida(Partida partida){
        this.partidas.add(partida);
    }

    public ArrayList<Partida> getPartidas(){
        return partidas;
    }
}