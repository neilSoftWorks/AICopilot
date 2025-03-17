CREATE TABLE Vehicle (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    registrationNumber VARCHAR(255) NOT NULL,
    -- Other vehicle details
);