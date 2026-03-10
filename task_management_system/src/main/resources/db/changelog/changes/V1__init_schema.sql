-- TEMP USER TABLE
CREATE TABLE temp_user (
    email VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    submitted_at TIMESTAMP
);

-- USERS TABLE
CREATE TABLE users (
    email VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    joined_at TIMESTAMP NOT NULL
);

-- TASK TABLE
CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    status VARCHAR(50),
    assignee VARCHAR(255),
    created_date TIMESTAMP,
    created_by VARCHAR(255),
    update_date TIMESTAMP,
    updated_by VARCHAR(255),
    CONSTRAINT fk_task_assignee
        FOREIGN KEY (assignee)
        REFERENCES users(email)
        ON DELETE SET NULL
);

-- EMAIL_LOGS Table
CREATE TABLE email_logs (
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    recipient_email VARCHAR(255),
    sender_email VARCHAR(255),
    subject VARCHAR(255),
    triggered_by VARCHAR(255),
    api_response_code INT,
    send_grid_message_id VARCHAR(255),
    send_time TIMESTAMP,
    failure_reason TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- EMAIL OTP TABLE
CREATE TABLE email_otps (
    email VARCHAR(255) PRIMARY KEY,
    otp VARCHAR(20) NOT NULL,
    expires_at TIMESTAMP NOT NULL
);