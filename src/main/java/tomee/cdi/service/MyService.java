package tomee.cdi.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import tomee.cdi.dao.MyDao;


@Stateless
public class MyService {

   
   @Inject MyDao dao;
   
   @PostConstruct
   public void post() {
      System.out.println(getClass().getName() + " post construct");
   }
}
