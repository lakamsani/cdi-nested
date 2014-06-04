package tomee.cdi.test;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tomee.cdi.service.MyService;


/** 
 */

@Stateless
@Path("/testing")
public class MyResource {

   
   @Inject MyService service;

   @Path("/hello")
   @GET
   @Produces("text/plain")
   public String getIt()
   {
      System.out.println(getClass().getName() + " entered");
      return "got it";
   }

   
}
