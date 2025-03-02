CREATE TABLE polls (
                       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       title VARCHAR(255),
                       description TEXT,
                       date_of_creation TIMESTAMP WITH TIME ZONE
);

CREATE TABLE questions (
                           id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           question TEXT,
                           poll_id BIGINT,
                           CONSTRAINT fk_questions_polls FOREIGN KEY (poll_id) REFERENCES polls(id)
);

CREATE TABLE answers (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         answer TEXT,
                         correctness BOOLEAN,
                         question_id BIGINT,
                         CONSTRAINT fk_answers_questions FOREIGN KEY (question_id) REFERENCES questions(id)
);