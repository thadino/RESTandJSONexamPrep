/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import static rest.ApplicationConfig.names;

/**
 *
 * @author Dino
 */
public class UserFacade {
    
    
    public static void populatetestusers()
    {
        CreateUser("lars", "Olsen", "a", "ged");
        CreateUser("b", "Olsen", "se", "fs");
        CreateUser("c", "pip", "re", "ew");
        CreateUser("d", "Olsen", "fs", "sdsd");   
    }
 
    
    public static JsonObject getUser(int data, String firstname, String lastname)
    {
   

    for (Object o : names) {
        JsonObject jsonLineItem = (JsonObject) o;
        String fname = jsonLineItem.get("fName").toString();
        String lname = jsonLineItem.get("lName").toString();
        if(fname.equals('"' + firstname + '"') && lname.equals('"' + lastname + '"'))
        {
            
                        if(data == 100)
            {
            return jsonLineItem;    
            }
            else
            {
           jsonLineItem.remove("street");
           jsonLineItem.remove("city");
            return jsonLineItem; 
            }
            
        }
       
    }
    
     JsonObject errormessage = new JsonObject();
        errormessage.addProperty("ERROR", "No Search Results Found from searching Firstname: " + firstname + " Lastname: " + lastname );
        return errormessage;
 
    }

   public static JsonArray CreateUser(String firstname, String lastname, String Street, String City){
       
 JsonObject person = new JsonObject();
 person.addProperty("fName", firstname);
 person.addProperty("lName", lastname);
 person.addProperty("street", Street);
 person.addProperty("city", City);
 names.add(person);
   return names;
    }
   
   
}
