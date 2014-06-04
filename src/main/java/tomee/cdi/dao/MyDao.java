package tomee.cdi.dao;

import javax.annotation.PostConstruct;

public class MyDao {

   @PostConstruct
   public void daoDone() {
      System.out.println(getClass().getName() + " post construct");
   }
}
