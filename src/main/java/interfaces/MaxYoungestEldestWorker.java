package interfaces;

public class MaxYoungestEldestWorker {
    private String TYPE;
    private String NAME;
    private String BIRTHDAY;

    public String getType() {
        return TYPE;
    }

    public void setType(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }



    public String getBirthday() {
        return BIRTHDAY;
    }


    public void setBirthday(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    @Override
    public String toString() {
        return "{" + "TYPE: " + getType() + ", NAME: " + getName() + ", BIRTHDAY:" + getBirthday() + "}";
    }
}
