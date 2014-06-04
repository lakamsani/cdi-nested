package tomee.cdi.test;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tomee.cdi.service.MyService;


/** 
 */

@Path("/testing")
public class MyResource {

   
   @Inject MyService service;

   // test with: curl http://localhost:8080/cdi-nested/testing/hello
   @Path("/hello")
   @GET
   @Produces("text/plain")
   public String getIt()
   {
      System.out.println(getClass().getName() + " entered");
      service.hello();
      return "got it";
   }

   
}
