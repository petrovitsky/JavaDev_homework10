CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    CONSTRAINT client_min_name_length
    CHECK (LENGTH(name) > 2)
);
CREATE TABLE IF NOT EXISTS planet (
    id VARCHAR(200) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CONSTRAINT planet_id_is_uppercase
        CHECK  (UPPER(id) = id)
);
CREATE TABLE IF NOT EXISTS ticket (
    id IDENTITY PRIMARY KEY,
    create_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP(),
    client_id BIGINT,
    from_planet_id VARCHAR(500),
    to_planet_id VARCHAR(500),
    FOREIGN KEY (client_id) REFERENCES client(id)
    ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planet(id)
    ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
    ON DELETE CASCADE
);