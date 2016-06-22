package sys.red.atomic.maximo;

import com.ibm.maximo.oslc.*;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;

public class MaximoRestClient {


    public static MaximoConnector connectToMaximo() {

        Options option = new Options()
                .user("maxadmin")
                .password("Passw0rd1")
                .auth("maxauth")
                .host("10.0.7.51")
                .lean(true);

        MaximoConnector connector = new MaximoConnector(option).debug(true);

        try {
            connector.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OslcException e) {
            e.printStackTrace();
        }

        return connector;

    }

    public static void main(String[] args) {


        MaximoConnector connector = connectToMaximo();
        ResourceSet resourceSet;

        try {
            ResourceSet rs = connector.resourceSet("mxwodetail").select("wonum", "status").where("wonum=1849").fetch();

            Resource member = rs.member(0);

            JsonObject status = Json.createObjectBuilder().add("description", "blablabla.................").build();


            member.update(status, "description");



//            resourceSet = connector.resourceSet("mxwodetail").select("wonum","status").where("status").equalTo("APPR").fetch();
//                    .select("wonum", "status")
//                    .where("wonum")
//                    .equalTo()
//                    .fetch()
//            ;


            System.out.println(member.toJSON());

            rs = connector.resourceSet("mxwodetail").select("wonum", "status").where("wonum=1849").fetch();

            member = rs.member(0);

            Util.jsonPrettyPrinter(member.toJSON());

        } catch (OslcException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
