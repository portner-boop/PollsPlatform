-- V1__create_tables.sql

-- Создание таблицы polls_completed_by_user
CREATE TABLE analytic.polls_completed_by_user (
                                                  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                                  user_id VARCHAR(255) NOT NULL
);

-- Recreate dependent tables (poll and answer) after dropping
CREATE TABLE analytic.poll (
                               id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                               type_of_poll VARCHAR(50),
                               poll_id BIGINT,
                               polls_completed_by_user_id BIGINT,
                               CONSTRAINT fk_poll_polls_completed_by_user FOREIGN KEY (polls_completed_by_user_id)
                                   REFERENCES analytic.polls_completed_by_user(id)
                                   ON DELETE SET NULL
);

CREATE TABLE analytic.answer (
                                 id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                 question_id BIGINT NOT NULL,
                                 answer_id BIGINT NOT NULL,
                                 answer VARCHAR(255) NOT NULL,
                                 correctness BOOLEAN,
                                 poll_id BIGINT NOT NULL,
                                 CONSTRAINT fk_answer_poll FOREIGN KEY (poll_id)
                                     REFERENCES analytic.poll(id)
                                     ON DELETE CASCADE
);