import streams.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------Lista Prodotti--------------------");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1254444464, "Samsung Galaxy A15", "Elettronica", 199.99));
        products.add(new Product(1254452111, "The Meessage", "Books", 111.60));
        products.add(new Product(1258488611, "How to Catch an Elf", "Books", 6.99));
        products.add(new Product(1256894464, "IPhone 15", "Elettronica", 1180.00));
        products.add(new Product(1254446564, "TV", "Elettronica", 850.00));
        products.add(new Product(1254444464, "", "Elettronica", 199.99));
        products.add(new Product(1589994464, "Be Ready When the Luck Happens", "Books", 155.99));
        products.add(new Product(1254444464, "Mascara Lancome", "Beauty", 35.99));
        products.add(new Product(1254444464, "Lip Balm Dior", "Beauty", 44.99));
        products.add(new Product(1254444464, "Harry Potter", "Books", 29.95));

        //stampon la lista dei prodotti
        products.forEach(product -> System.out.println(product));


        System.out.println("--------------------Ex1 Lista cattegoria Books--------------------");
        List<Product> listOfBooks = Product.listBook(products);

        for (Product product : listOfBooks) {
            System.out.println(product);
        }

    }
}