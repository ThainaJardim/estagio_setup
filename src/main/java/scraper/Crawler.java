package scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import request.Request_Jsoup;
import java.io.IOException;

public class Crawler implements Runnable {

    DataStruc data;

    private final int INDEX_LIMIT = 20;

    public Crawler(DataStruc d) {
        data = d;
    }

    public void run() {

        int counter = 0;

        while((data.url_to_visit_size() > 0) && counter<INDEX_LIMIT) {

            String currentUrl = data.getURL();

            try {
                Document doc = Request_Jsoup.connect(currentUrl);
                counter++;
                Elements links = doc.select( "[href^=https://www.magazineluiza.com.br]" );

//                public List<String> getAlbumsToQueue(Document doc) {
//                    List<String> urlsToAddToQueue = new ArrayList<>();
//                    for (Element elem : doc.select("#trends_all_purchases > ul > li:nth-child(2) > a")) {
//                        urlsToAddToQueue.add(elem.attr("href"));
//                    }
//                    return urlsToAddToQueue;
//                }

                addLinksToQueue(links);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addLinksToQueue(Elements el) {
        for(Element e : el) {
            String theLink = e.attr("abs:href");
            if(theLink.startsWith("http") && !data.oldLink(theLink)) {
                data.addURL(theLink);
                data.addVisitedURL(theLink);
                System.out.println(theLink);
            }
        }
    }
}
