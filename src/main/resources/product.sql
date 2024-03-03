CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          category VARCHAR(255) NOT NULL,
                          photoUrl VARCHAR(255),
                          description VARCHAR(1000),
                          price DOUBLE NOT NULL
);


INSERT INTO products (name, category, photoUrl, description, price) VALUES
                                                                        ('Product1', 'Category1', 'photo1.jpg', 'Description for Product1', 19.99),
                                                                        ('Product2', 'Category2', 'photo2.jpg', 'Description for Product2', 29.99),
                                                                        ('Product3', 'Category1', 'photo3.jpg', 'Description for Product3', 39.99);