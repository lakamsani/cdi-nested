package tomee.cdi.dao;


import java.io.InputStream;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
        
public class MySessionFactoryProvider {

  
  @Resource DataSource myDS;
  
  /* add this to tomee.xml 
  <Resource id="myDS" type="DataSource">
  JdbcDriver org.hsqldb.jdbcDriver
  JdbcUrl jdbc:hsqldb:file:hsqldb
  UserName sa
  Password
</Resource>
*/
   
  @Produces
  @ApplicationScoped
  public SqlSessionFactory produceFactory() {
     
     try {
        
        InputStream inputStream = Resources.getResourceAsStream("test-mybatis-config.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream, null, null);
        
        Configuration  configuration = xmlConfigBuilder.parse();
        TransactionFactory trxFactory = new JdbcTransactionFactory();
        Environment env = new Environment("xyz", trxFactory, myDS);
        configuration.setEnvironment(env);
        
        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(configuration);
        return factory;
     } catch (Exception e) {
        e.printStackTrace();
     }
     
     return null;
  }

}

