create table images (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    data MEDIUMBLOB NOT NULL,
    place_id INT NOT NULL,
    FOREIGN KEY (place_id) REFERENCES places (id)
)