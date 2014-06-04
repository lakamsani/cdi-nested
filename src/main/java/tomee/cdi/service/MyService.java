package tomee.cdi.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import tomee.cdi.dao.MyDao;


@Stateless
public class MyService {

   
   @Inject MyDao dao;
   
   public void hello() {
      System.out.println(" Hello world");
      if (dao == null) {
         System.out.println(" Dao is still null");
      }
   }
   
   @PostConstruct
   public void post() {
      System.out.println(getClass().getName() + " post construct");
   }
}
