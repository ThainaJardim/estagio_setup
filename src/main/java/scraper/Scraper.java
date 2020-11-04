package scraper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Scraper {

    public static void verification (String html, String pageProduct, String available) {
        if (html.contains(pageProduct)) {
            if (html.contains(available)) {
                System.out.println("Esta pagína é de um produto e está disponível para compra");

            } else {
                System.out.println("Esta pagína é de um produto, mas não está disponível");
            }
        } else {
            System.out.println("Esta página não é de um produto");
        }
    }

    public static void pattern (String html, String s) {
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }

}


