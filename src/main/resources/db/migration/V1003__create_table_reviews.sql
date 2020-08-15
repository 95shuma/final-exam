create table reviews (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    review VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    ldt datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    user_id INT NOT NULL,
    place_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (place_id) REFERENCES places (id)
)