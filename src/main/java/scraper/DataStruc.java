package scraper;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DataStruc {

    private ConcurrentLinkedQueue<String> url_to_visit = new ConcurrentLinkedQueue<String>();

    private ArrayList<String> visited_url = new ArrayList<String>();


    public DataStruc(String initial_url) {

        url_to_visit.offer(initial_url);
    }

    public void addURL(String url) {

        url_to_visit.offer(url);
    }


    public String getURL() {
        return url_to_visit.poll();
    }


    public int url_to_visit_size() {

        return url_to_visit.size();
    }


    public void addVisitedURL(String url) {

        visited_url.add(url);
    }


    public boolean oldLink(String link) {
        for(String s : visited_url) {
            if(s.equals(link)) {
                return true;
            }
        }
        return false;
    }
}
