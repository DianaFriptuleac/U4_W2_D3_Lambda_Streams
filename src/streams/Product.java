package streams;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

//Set and Get

    //Stream per ottenere i Books > 100

    public static List<Product> listBook(List<Product> products) {     //List<Product>- tipo di ritorno;  Accetta come parametro una lista di Product con il nome products
        return products.stream().filter(product -> product.getCategory()
                        .equalsIgnoreCase("Books")).  //Verifico se la categoria e "Books" (non e case sensitive)
                filter(product -> product.getPrice() > 100)  //filtro per prezzo
                .collect(Collectors.toList());//inserisci i prodotti filtrati in una lista
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price ='" + price + '\'' +
                '}';
    }
}
