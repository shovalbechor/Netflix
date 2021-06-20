import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String password;
    private ArrayList<Series> seriesWatched;
    private Map<Series,Integer> map;
    private String initDate;

    public User(String name, String password) {
        map = new HashMap<>();
        initDate =new Date().toString();
        this.name = name;
        this.password = password;
        seriesWatched = new ArrayList<>();
    }

    public ArrayList<Series> getSeriesWatched() {
        return seriesWatched;

    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void userSeries() {
        for (Series series : seriesWatched) {
            System.out.println(series);
            System.out.println(series.getEpisode());
        }

    }

    public String getInitDate() {
        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        return day+"/"+month+"/"+year+"/";
    }
    public String getExpressionDate() {
        LocalDate localDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        return day+"/"+month+"/"+(year+1)+"/";
    }

    public Map<Series, Integer> getMap() {
        return map;
    }
}
