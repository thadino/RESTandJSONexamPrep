/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonArray;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Dino
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

       public static JsonArray names = new JsonArray();
    


    

    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(exception.GeneralExceptionMapper.class);
        resources.add(exception.NotFoundExceptionMapper.class);
        resources.add(rest.userendpoint.class);
    }
    
}
