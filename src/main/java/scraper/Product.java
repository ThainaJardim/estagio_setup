package scraper;

public class Product {

    private String pageProduct;
    private String available;
    private String tagName ;
    private String tagPrice;
    private String tagImage;

    //str.substring(indexStart[, indexEnd])


    public Product(String pageProduct, String available, String tagName, String tagPrice, String tagImage) {
        this.pageProduct = pageProduct;
        this.available = available;
        this.tagName = tagName;
        this.tagPrice = tagPrice;
        this.tagImage = tagImage;
    }

//    public Product(String tagName, String tagPrice, String tagImage) {
//        this.tagName = tagName;
//        this.tagPrice = tagPrice;
//        this.tagImage = tagImage;
//    }

    public String getPageProduct() {
        return pageProduct;
    }

    public void setPageProduct(String pageProduct) {
        this.pageProduct = pageProduct;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(String tagPrice) {
        this.tagPrice = tagPrice;
    }

    public String getTagImage() {
        return tagImage;
    }

    public void setTagImage(String tagImage) {
        this.tagImage = tagImage;
    }
}
