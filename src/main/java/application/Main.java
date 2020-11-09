package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import request.Request_Jsoup;
import request.Requisicao;
import scraper.Product;
import scraper.Scraper;
import scraper.ScraperJsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, NumberFormatException {


            String html = Requisicao.getHtml("https://www.magazineluiza.com.br/suplemento-nutricional-adulto-nutridrink-protein-sem-sabor-700g/p/226716600/me/cmaa/");
            Document htmlJsoup = Jsoup.parse(html);

            System.out.println(html);
            System.out.println("------------------------------------------------------------");
            System.out.println(htmlJsoup);

            Product product = new Product();
             Scraper.pageOfProduct(html, product.setPageProduct( "pagetype: 'product'" ) );
             Scraper.productIsAvailable( html, product.setAvailable( "'stockAvailability': true"));

            Scraper.pattern(html, product.setTagName("<h1 class=\"header-product__title\">(.*?)</h1>"));
            Scraper.pattern(html, product.setTagPrice("<span class=\"price-template__text\">(.*?)</span>"));
            Scraper.pattern(html, product.setTagImage("(?:showcase-product__big-img.*?src=)\"(.+?)\""));

           Product productJsoup = new Product( );
            ScraperJsoup.busca( htmlJsoup, productJsoup.setTagName("body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.header-product.js-header-product > h1") );
            ScraperJsoup.busca( htmlJsoup, productJsoup.setTagPrice("body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.wrapper-product__informations.js-block-product > div.information-values__product-page > div > div > div > span.price-template__text") );
            ScraperJsoup.busca2( htmlJsoup, productJsoup.setTagImage( "\"body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.showcase-product > div\"" ) );

//        try {
//            FileOutputStream arq = new FileOutputStream("teste.txt");
//            ObjectOutputStream obj = new ObjectOutputStream(arq);
//            obj.writeObject(html);
//            System.out.println("Salvo em diretório com sucesso!");
//        } catch ( Exception e) {
//            System.out.println("Erro ao salvar a conteúdo da página");
//        }
    }


}



