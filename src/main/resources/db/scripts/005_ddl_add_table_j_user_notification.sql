CREATE TABLE j_user_notification
(
    id        SERIAL PRIMARY KEY,
    messenger TEXT,
    identity  TEXT,
    j_user_id INT REFERENCES j_user (id)
);
