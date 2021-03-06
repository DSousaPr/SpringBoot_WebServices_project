package com.myproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myproject.course.entities.Category;
import com.myproject.course.entities.Order;
import com.myproject.course.entities.OrderItem;
import com.myproject.course.entities.Payment;
import com.myproject.course.entities.Product;
import com.myproject.course.entities.User;
import com.myproject.course.entities.enums.OrderStatus;
import com.myproject.course.repositories.CategoryRepository;
import com.myproject.course.repositories.OrderItemRepository;
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
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Ring", "high fantasy book", 30.0, "");
		Product p2 = new Product(null, "Smart TV", "TV with resolution 4K", 1399.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Apple powerfull laptop", 120.0, "");
		Product p4 = new Product(null, "Pc Gamer", "gaming desktop", 4250.0, "");
		Product p5 = new Product(null, "Clean code", "Book for programmers", 18.0, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
		User u2 = new User(null, "Alex Green", "alexgreen@gmail.com", "9777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-05-21T20:25:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-05-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-05-21T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1  = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2  = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3  = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4  = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2022-05-21T22:25:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
}
