/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author ellen
 */
@Path("menu")
public class MenuWS {

    @Context
    private UriInfo context;

    public MenuWS() {
    }


    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("Menu/get")
    public String getItem(){
        Usuario u = new Usuario();
        u.setEmail("aaa@a.com");
        u.setLogin("aaa");
        u.setSenha("23");
        u.setPerfil("Administrador");
        
        Gson g = new Gson();
        
        return g.toJson(u);
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("Menu/list")
    public String listItems(){
        List<Usuario> lista = new ArrayList<Usuario>();
        
        Usuario u = new Usuario();
        u.setEmail("aaa@a.com");
        u.setLogin("aaa");
        u.setSenha("23");
        u.setPerfil("Administrador");
        
        lista.add(u);
        
        u = new Usuario();
        u.setEmail("bbb@b.com");
        u.setLogin("bbb");
        u.setSenha("45");
        u.setPerfil("Administrador");
        
        lista.add(u);
        
        Gson g = new Gson();
        
        return g.toJson(lista);
    }
    
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
