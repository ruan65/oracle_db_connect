package sys.red.atomic;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQueriesExecutor {

    private OracleDataSource ods;

    public DbQueriesExecutor() {
        try {
            this.ods = (OracleDataSource) dataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Bean
    DataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();

        dataSource.setUser("maxread");
        dataSource.setPassword("maximoread1");
        dataSource.setURL("jdbc:oracle:thin:@10.0.7.51:1521:CTGINST1");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);

        return dataSource;
    }

    public OracleDataSource getOds() {
        return ods;
    }


    public ResultSet runRawSqlQuery(String query) {

        ResultSet res = null;

        try {
            Connection conn = ods.getConnection();

            Statement statement = conn.createStatement();

            res = statement.executeQuery(query);

//            if (!conn.isClosed()) {
//                conn.close();
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
