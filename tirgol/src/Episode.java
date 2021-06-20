import java.util.Date;

public class Episode {

    private String name;
    private String summary;
    private String dataOfBroadCast;

    public Episode(String name, String summary) {
        this.name = name;
        this.summary = summary;
        this.dataOfBroadCast = new Date().toString();
    }

    @Override
    public String toString() {
        return "Episode{" +
                "name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", dataOfBroadCast='" + dataOfBroadCast + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

}
