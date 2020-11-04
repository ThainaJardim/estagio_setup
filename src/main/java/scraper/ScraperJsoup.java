package scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ScraperJsoup {

    public static void busca( Document htmlJsoup, String s) {
        String nome;
        Elements tags = htmlJsoup.select(s);
        Element tag = tags.first();
        nome = tag.text();
        System.out.println(nome);

    }

}
