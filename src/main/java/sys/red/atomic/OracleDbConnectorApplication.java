package sys.red.atomic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OracleDbConnectorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OracleDbConnectorApplication.class, args);

//        System.out.println("\nLet's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
//
//        System.out.println("\nLet's do something useful now...............\n");
//
//
//        DbQueriesExecutor dbQueriesExecutor = new DbQueriesExecutor();
//
//        ResultSet resultSet = dbQueriesExecutor.runRawSqlQuery("select DESCRIPTION from MAXIMO.WORKORDER");
//
//        try {
//            while (resultSet.next()) {
//
//                System.out.println(resultSet.getString("DESCRIPTION"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
