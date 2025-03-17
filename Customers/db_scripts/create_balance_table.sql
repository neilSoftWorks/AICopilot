CREATE TABLE Balance (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(19, 2) NOT NULL,
    date DATE NOT NULL,
    -- Other balance details
);