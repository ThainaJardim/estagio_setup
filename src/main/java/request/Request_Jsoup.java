package request;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Request_Jsoup {

        public static Document connect(String link) throws IOException {
            System.setProperty( "http.proxyhost", "haproxy.lett.global" );
            System.setProperty( "http.proxyport", "3130" );
            Document document = Jsoup
                    .connect(link)
                    .userAgent( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/601.6.17 (KHTML, like Gecko) Version/9.1.1 Safari/601.6.17" )
                    .followRedirects( true )
                    .get();

            return document;
        }



    }

