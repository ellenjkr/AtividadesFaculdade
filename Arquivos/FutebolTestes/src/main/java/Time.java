
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
import java.util.ArrayList;

/**
 *
 * @author mateu
 */


public class Time extends Exception{
    public String nome;    
    public Goleiro goleiro;
    private ArrayList<Defensor> defensores= new ArrayList<Defensor>();
    private ArrayList<Atacante> atacantes= new ArrayList<Atacante>();
    private int vitorias;
    private int empates;
    private int derrotas;
    public boolean visita;
    
    public Time(String nome){
        this.nome=nome;
        this.vitorias=0;
        this.empates=0;
        this.derrotas=0;
    }
    
    public boolean adicionarDefensor(Defensor defensor){
        if(this.defensores.size()>=2){
            return false;
        }else{
            this.defensores.add(defensor);
            return true;
        }
    }
    
    
    public boolean adicionarAtacante(Atacante atacante){
        if(this.atacantes.size()>=2){
            return false;
        }else{
            this.atacantes.add(atacante);
            return true;
        }
    }
    
    public boolean adicionarGoleiro(Goleiro goleiro){
        if(this.goleiro!=null){
            return false;
        }else{
            this.goleiro=goleiro;
            return true;
        }
    }
    public boolean removeAtacante(int index){
       if(this.atacantes.size()>0){
            this.atacantes.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public boolean removeDefensor(int index){
       if(this.defensores.size()>0){
            this.defensores.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public boolean removeGoleiro(int index){
       if(this.goleiro!=null){
            this.goleiro=null;
            return true;
        }else{
            return false;
        }

    }
        
    public ArrayList<Defensor> getDefensores(){
        return defensores;
    } 
    
    public ArrayList<Atacante> getAtacantes(){
        return atacantes;
    }
    
    public int resultados(){
        int result=0;
        
        result += (this.vitorias*3)+(this.empates);
        return result;
    }

    public boolean visitante(){
        return this.visita;
    }
    public void setVitoria(){
        this.vitorias++;
    }
    public void setDerrota(){
        this.derrotas++;
    }
    public void setEmpate(){
        this.empates++;
    }
    
    
    
    public int calculaForca(){
       int forca=0;
       for(Atacante atacante: this.atacantes){
           forca += atacante.getHabilidade();
       }
       for(Defensor defensor: this.defensores){
           forca+= defensor.getHabilidade();
       }
       forca+=this.goleiro.getHabilidade();
       
       return forca;
   }
   
   public void golDe(int tipo, int local){
       if(tipo==1){
           if(local==0){
               this.atacantes.get(0).gols++;
           }else{
               this.atacantes.get(1).gols++;
           }           
       }else if(tipo ==2){
           
           if(local==0){
              this.defensores.get(0).gols++;
           }else{
               this.defensores.get(1).gols++;
           }
       }else{
           this.goleiro.gols++;
       
       }
   }
   
}
