package nn.ru;

import org.hibernate.Session;
import nn.ru.entity.Product;
import nn.ru.entity.ProductId;
import nn.ru.entity.Address;

import nn.ru.util.HibernateUtil;
import org.hibernate.Transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppRunner {

    private static final Logger logger = LogManager.getLogger(AppRunner.class);
    private static final Logger fileLogger = LogManager.getLogger("FileLogger");

    public static void main(String[] args) {
        logger.info("Application started");
        fileLogger.debug("==>  This message will be logged to the file");
        fileLogger.info("==>  This message will be logged to noth the file and the console");

        // Create new product

        ProductId productId = new ProductId("P123", "S456");
        Address address = new Address("New York", "NY", "123 Broadway", "10001");
        Product product = new Product(productId, "Sample Product 1", 99.99, address);

        // Save product into db
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            HibernateUtil.shutdown();
        }


//        System.out.println("Current ID of product: " + product.getId());
//        product.setId(4L);

        // Get product
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product savedProduct = session.get(Product.class, product.getId());
            System.out.printf("id: %s, Product: %s, price: %s", savedProduct.getId(), savedProduct.getName(), savedProduct.getPrice());

        }

        // Update product:
//        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            Transaction transaction = session.beginTransaction();
//            Product savedProduct = session.get(Product.class, product.getId());
//            savedProduct.setPrice(79.99);
//            session.update(savedProduct);
//            transaction.commit();
//        }

//        // Delete product:
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Product savedProduct = session.get(Product.class, product.getId());
//            session.delete(savedProduct);
//            transaction.commit();
//        }


    }
}