package tomee.embedded.test;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import tomee.cdi.service.MyService;


public class MyBatisEmbeddedTomEE {

   
   
   @EJB
   MyService service;

   @Before
   public void setUp() throws Exception {
      
      Properties p = new Properties();
      p.put("myDS", "new://Resource?type=DataSource");
      p.put("myDS.JdbcDriver", "org.hsqldb.jdbcDriver");
      p.put("myDS.JdbcUrl", "jdbc:hsqldb:mem:mydb");
      p.put("myDS.UserName", "sa");
      //jdbc:hsqldb:file:hsqldb

      EJBContainer.createEJBContainer(p).getContext().bind("inject", this);

   }
   
   @Test
   public void test()
   {
      assertTrue(service != null);

   }

}
