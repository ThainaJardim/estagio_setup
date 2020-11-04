package application;

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
            Document htmlJsoup = Request_Jsoup.connect( "http://www.magazineluiza.com.br/suplemento-nutricional-adulto-nutridrink-protein-sem-sabor-700g/p/226716600/me/cmaa/" );
            System.out.println(html);
            System.out.println("------------------------------------------------------------");
            System.out.println(htmlJsoup);

            Product product = new Product("pagetype: 'product'", "'stockAvailability': true", "<h1 class=\"header-product__title\">(.*?)</h1>", "<span  class=\"price-template__text\">(.*?)</span>", "(?:showcase-product__big-img.*?src=)\"(.+?)\"" );
            Scraper.verification(html, product.getPageProduct(), product.getAvailable());
            Scraper.pattern(html, product.getTagName());
            Scraper.pattern(html, product.getTagPrice());
            Scraper.pattern(html, product.getTagImage());

//           Product productJsoup = new Product(  "body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.header-product.js-header-product > h1", "body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.wrapper-product__informations.js-block-product > div.information-values__product-page > div > div > div > span.price-template__text", "body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.showcase-product > ul > li:nth-child(2)" );
//            ScraperJsoup.busca( htmlJsoup, productJsoup.getTagName() );
//            ScraperJsoup.busca( htmlJsoup, productJsoup.getTagPrice() );
//            ScraperJsoup.busca( htmlJsoup, productJsoup.getTagImage() );

        try {
            FileOutputStream arq = new FileOutputStream("teste.txt");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            obj.writeObject(html);
            System.out.println("Salvo em diretório com sucesso!");
        } catch ( Exception e) {
            System.out.println("Erro ao salvar a conteúdo da página");
        }
    }


}



