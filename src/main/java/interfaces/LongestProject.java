package interfaces;

public class LongestProject {
    private String NAME;
    private int MONTH_COUNT;

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public int getMonthCount() {
        return MONTH_COUNT;
    }

    public void setMonthCount(int MONTH_COUNT) {
        this.MONTH_COUNT = MONTH_COUNT;
    }

    @Override
    public String toString() {
        return "{" + "NAME: " + getName() + ", MONTH_COUNT: " + getMonthCount() + "}";
    }
}
