import java.util.ArrayList;

public class Series {
    private String name;
    private ArrayList<Episode> episodes;

    public Series(String name, ArrayList<Episode> episodes) {
        this.name = name;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }

    public ArrayList<Episode> getEpisode() {
        return episodes;
    }

    public String getName() {
        return name;
    }
}
