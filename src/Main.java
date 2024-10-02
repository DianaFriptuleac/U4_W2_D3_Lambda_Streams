import streams.Customer;
import streams.Order;
import streams.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------Lista Prodotti--------------------");

        // Lista dei prodotti esistenti
        List<Product> products = new ArrayList<>();
        products.add(new Product(1254444464, "Samsung Galaxy A15", "Elettronica", 199.99));
        products.add(new Product(1254452111, "The Message", "Books", 111.60));
        products.add(new Product(1258488611, "How to Catch an Elf", "Baby", 6.99));
        products.add(new Product(1256894464, "IPhone 15", "Elettronica", 1180.00));
        products.add(new Product(1254446564, "TV", "Elettronica", 850.00));
        products.add(new Product(1254444464, "", "Elettronica", 199.99));
        products.add(new Product(1589994464, "Be Ready When the Luck Happens", "Books", 155.99));
        products.add(new Product(1254444464, "Culla", "Baby", 355.99));
        products.add(new Product(1254444464, "Latte in polvere", "Baby", 44.99));
        products.add(new Product(1254444464, "Harry Potter", "Books", 29.95));
        products.add(new Product(1254458445, "Toy Bear", "Boys", 55.00));
        products.add(new Product(855223445, "Puzzle", "Boys", 85.50));

        // Stampo la lista dei prodotti
        products.forEach(System.out::println);

        System.out.println("--------------------Ex1 Lista categoria Books--------------------");

        // Filtro e stampa i libri con prezzo superiore a 100
        List<Product> listOfBooks = listBook(products);
        listOfBooks.forEach(System.out::println);

        System.out.println("--------------------Ex2 Lista categoria Baby--------------------");

        // Creo i customers
        Customer mario = new Customer(25122, "Mario", 2);
        Customer anna = new Customer(25256122, "Anna", 2);
        Customer carlo = new Customer(222, "Carlo", 3);

        // Creo gli ordini
        List<Order> myOrders = new ArrayList<>();

        // Ordine 1: con "Harry Potter" e "IPhone 15"
        List<Product> firstOrderProducts = new ArrayList<>();  //creo la lista prodotti chiamata firstOrderProducts
        firstOrderProducts.add(products.get(9)); // Harry Potter
        firstOrderProducts.add(products.get(3)); // IPhone 15
        Order firstOrder = new Order(1254414, "Elaborazione", LocalDate.now().plusDays(5), firstOrderProducts, mario);
        myOrders.add(firstOrder);

        // Ordine 2: con "How to Catch an Elf" e "Latte in polvere"
        List<Product> secondOrderProducts = new ArrayList<>();
        secondOrderProducts.add(products.get(2)); // How to Catch an Elf
        secondOrderProducts.add(products.get(8)); // Latte in polvere
        Order secondOrder = new Order(1254415, "Spedito", LocalDate.now().plusDays(2), secondOrderProducts, anna);
        myOrders.add(secondOrder);

        // Ordine 3: con "Culla"
        List<Product> thirdOrderProducts = new ArrayList<>();
        thirdOrderProducts.add(products.get(7)); // Culla
        Order thirdOrder = new Order(1254416, "Preso in carico", LocalDate.now().plusDays(6), thirdOrderProducts, carlo);
        myOrders.add(thirdOrder);

        // Filtro gli ordini che contengono prodotti della categoria "Baby"
        List<Order> listOfBabyOrders = ordinaBaby(myOrders);

        // Stampo gli ordini che contengono prodotti della categoria "Baby"
        listOfBabyOrders.forEach(System.out::println);


        System.out.println("--------------------Lista categoria Boys con sconto del 10%--------------------");

        // Filtro i prodotti della categoria "Boys" e applico lo sconto del 10% usando map
        List<Product> boysProductsWithDiscount = products.stream()
                .filter(p -> p.getCategory().equals("Boys")) // Filtro per categoria Boys
                .map(p -> {  // Applico lo sconto del 10% con map
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                })
                .collect(Collectors.toList());

        // Stampo i prodotti
        for (Product product : boysProductsWithDiscount) {
            System.out.println("ID: " + product.getId());
            System.out.println("Nome: " + product.getName());
            System.out.println("Categoria: " + product.getCategory());
            System.out.println("Prezzo (con sconto): " + product.getPrice());
            System.out.println("--------------------------");
        }
    }


    // Metodo per filtrare libri con prezzo > 100
    public static List<Product> listBook(List<Product> products) {
        return products.stream()
                .filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100) // Filtro per categoria Books e prezzo > 100
                .collect(Collectors.toList()); // Ritorno la lista filtrata
    }

    // Metodo per filtrare ordini con prodotti della categoria "Baby"
    public static List<Order> ordinaBaby(List<Order> babyOrders) {
        return babyOrders.stream()  // Creo uno stream dai prodotti di ogni ordine
                .filter(myOrder -> myOrder.getProducts()
                        .stream().anyMatch(product -> product.getCategory()
                                .equalsIgnoreCase("Baby")))  // Se almeno un prodotto è della categoria "Baby"; equalsIgnoreCase non case sensitive.
                .collect(Collectors.toList());
    }
}
