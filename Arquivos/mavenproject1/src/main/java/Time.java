/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */

import java.util.ArrayList;

public class Time {
    public String nome;    
    public Goleiro goleiro;
    private ArrayList<Defensor> defensores= new ArrayList<Defensor>();
    private ArrayList<Atacante> atacantes= new ArrayList<Atacante>();
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;
    private boolean visita;
    
    public Time(String nome){
        this.nome=nome;
        this.vitorias=0;
        this.empates=0;
        this.derrotas=0;
        this.pontos=0;
    }
    
    public void adicionarDefensor(Defensor defensor){
        if(this.defensores.size()>2){
            
        }else{
            this.defensores.add(defensor);
        }
    }
    
    public void adicionarAtacante(Atacante atacante){
        if(this.atacantes.size()>2){
            
        }else{
            this.atacantes.add(atacante);
        }
    }
    
    public void adicionarGoleiro(Goleiro goleiro){
        if(this.goleiro!=null){
            
        }else{
            this.goleiro=goleiro;
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
    
}
