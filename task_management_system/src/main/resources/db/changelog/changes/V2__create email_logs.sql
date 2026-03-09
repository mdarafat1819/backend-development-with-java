CREATE TABLE email_logs (
    id BIGSERIAL PRIMARY KEY,
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