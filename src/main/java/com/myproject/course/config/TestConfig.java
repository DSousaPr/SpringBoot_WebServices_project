package com.myproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myproject.course.entities.Category;
import com.myproject.course.entities.Order;
import com.myproject.course.entities.Product;
import com.myproject.course.entities.User;
import com.myproject.course.entities.enums.OrderStatus;
import com.myproject.course.repositories.CategoryRepository;
import com.myproject.course.repositories.OrderRepository;
import com.myproject.course.repositories.ProductRepository;
import com.myproject.course.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

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
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Ring", "high fantasy book", 400.0, "");
		Product p2 = new Product(null, "Smart TV", "TV with resolution 4K", 400.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Apple powerfull laptop", 400.0, "");
		Product p4 = new Product(null, "Pc Gamer", "gaming desktop", 400.0, "");
		Product p5 = new Product(null, "Clean code", "Book for programmers", 400.0, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
		User u2 = new User(null, "Alex Green", "alexgreen@gmail.com", "9777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-05-21T23:25:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-05-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-05-21T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
