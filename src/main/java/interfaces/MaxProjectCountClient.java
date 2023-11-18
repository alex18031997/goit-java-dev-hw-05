package interfaces;

public class MaxProjectCountClient {
    private String NAME;
    private int PROJECT_COUNT;

    public MaxProjectCountClient() {
        this.NAME = "";
        this.PROJECT_COUNT = 0;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public int getProjectCount() {
        return PROJECT_COUNT;
    }

    public void setProjectCount(int PROJECT_COUNT) {
        this.PROJECT_COUNT = PROJECT_COUNT;
    }

    @Override
    public String toString() {
        return "{" + "PROJECT_COUNT: " + getProjectCount() + ", name: " + getName() + "}";
    }

}
