package com.springprojeto.demo.config;

import com.springprojeto.demo.entities.Category;
import com.springprojeto.demo.entities.Order;
import com.springprojeto.demo.entities.Product;
import com.springprojeto.demo.entities.User;
import com.springprojeto.demo.entities.enums.OrderStatus;
import com.springprojeto.demo.repositories.CategoryRepository;
import com.springprojeto.demo.repositories.OrderRepository;
import com.springprojeto.demo.repositories.ProductRepository;
import com.springprojeto.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2024-05-03T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2024-05-04T20:53:07Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2024-05-05T09:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Book", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "TV", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Laptop", 1250.5, "");
        Product p4 = new Product(null, "PC Gamer", "Computer", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dumies", "Book", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }

}
