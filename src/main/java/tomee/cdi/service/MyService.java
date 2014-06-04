package tomee.cdi.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.mybatis.cdi.Mapper;

import tomee.cdi.dao.ICustomerDao;
import tomee.cdi.dao.MyDao;


@Stateless
public class MyService {

   
   // regular DAO
   @Inject MyDao dao;
   
   // MyBatis DAO
   @Inject @Mapper ICustomerDao customerDao;
   
   public void hello() {
      System.out.println(" Hello world");
      if (dao == null) {
         System.out.println(" Dao is still null");
      }
      
      if (customerDao == null) {
         System.out.println(" Customer Dao is still null");
      }
   }
   
   @PostConstruct
   public void post() {
      
      assert dao != null;
      assert customerDao != null;
      
      System.out.println(getClass().getName() + " post construct");
   }
}
