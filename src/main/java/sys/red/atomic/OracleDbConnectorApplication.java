package sys.red.atomic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

@SpringBootApplication
public class OracleDbConnectorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OracleDbConnectorApplication.class, args);

        System.out.println("\nLet's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("\nLet's do something useful now...............\n");


        DbQueriesExecutor dbQueriesExecutor = new DbQueriesExecutor();

        ResultSet resultSet = dbQueriesExecutor.runRawSqlQuery("select DESCRIPTION from MAXIMO.WORKORDER");

        try {
            while (resultSet.next()) {

                System.out.println(resultSet.getString("DESCRIPTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Statement statement = connection.createStatement();

            ResultSet newResultSet = statement.executeQuery("select DESCRIPTION from MAXIMO.WORKORDER");

            while (newResultSet.next()) {

                System.out.println(" --++ " + newResultSet.getString("DESCRIPTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
