package sys.red.atomic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sys.red.atomic.DbQueriesExecutor;
import sys.red.atomic.model.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DbQueriesExecutor queriesExecutor;

    @RequestMapping("/givemeit")
    public String givingSomethingUseful() {

        return "Take it. It is very useful!!!!!!!!!!!!!!!!!";
    }

    @RequestMapping("/routes")
    public String findRoutes() {

        ResultSet resultSet = queriesExecutor.runRawSqlQuery("select WONUM, DESCRIPTION from MAXIMO.WORKORDER");

        StringBuilder sb = new StringBuilder();
        try {
            while (resultSet.next()) {

                String description = resultSet.getString("DESCRIPTION");
                int wonum = resultSet.getInt("WONUM");
                sb.append(wonum).append(" descr: ").append(description).append("\n********************");
                System.out.println(description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @RequestMapping("/routesobj")
    public List<Route> mapOnTheObject() {

        ResultSet rs = queriesExecutor.runRawSqlQuery("select WONUM, DESCRIPTION from MAXIMO.WORKORDER");

        List<Route> routes = new ArrayList<>();
        try {

            while (rs.next()) {

                String description = rs.getString("DESCRIPTION");

                if (null != description) {

                    Route route = new Route(rs.getInt("WONUM"), description);
                    routes.add(route);
                    System.out.println(route);
                }

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return routes;
    }
}
