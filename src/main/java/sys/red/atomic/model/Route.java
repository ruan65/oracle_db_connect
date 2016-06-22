package sys.red.atomic.model;

public class Route {

    private int WONUM;
    private String DESCRIPTION;

    public Route(int WONUM, String DESCRIPTION) {

        this.WONUM = WONUM;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getWONUM() {
        return WONUM;
    }

    public void setWONUM(int WONUM) {
        this.WONUM = WONUM;
    }

    public String getDESCRIPTION() {

        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Route{" +
                "WONUM=" + WONUM +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}
