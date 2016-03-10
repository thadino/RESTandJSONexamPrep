/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facade.UserFacade;
import static facade.UserFacade.getUser;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dino
 */
@Path("users")
public class userendpoint {
    
    
Gson gson;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public userendpoint() {
        
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @param Data
     * @param firstname
     * @param lastname
     * 
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getuser/{data}/{fname},{lname}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetData(@PathParam("data") int Data, @PathParam("fname") String firstname, @PathParam("lname") String lastname) {
             

        
        
        
        UserFacade.populatetestusers(); // populates test users...
        
     // creats a new user.   UserFacade.CreateUser(firstname, lastname, lastname, lastname)
        
        JsonObject data = getUser(Data, firstname, lastname);

gson = new GsonBuilder().setPrettyPrinting().create();
String jsonResponse = gson.toJson(data);

        return jsonResponse;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
