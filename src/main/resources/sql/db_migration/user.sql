create database java_interview_guru;

use java_interview_guru;

CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL
);