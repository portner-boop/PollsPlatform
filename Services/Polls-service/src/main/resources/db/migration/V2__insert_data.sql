-- Вставка данных в таблицу polls
INSERT INTO polls (title, description, date_of_creation)
VALUES
    ('Опрос о технологиях', 'Опрос про современные технологии', '2025-03-01 10:00:00+00'),
    ('Опрос о еде', 'Опрос о пищевых предпочтениях', '2025-03-01 12:00:00+00');

-- Вставка данных в таблицу questions
INSERT INTO questions (question, poll_id)
VALUES
    ('Какой язык программирования вы предпочитаете?', 1),
    ('Используете ли вы AI в работе?', 1),
    ('Какую кухню вы предпочитаете?', 2),
    ('Любите ли вы острую еду?', 2);

-- Вставка данных в таблицу answers
INSERT INTO answers (answer, correctness, question_id)
VALUES
    ('Java', true, 1),
    ('Python', false, 1),
    ('JavaScript', false, 1),
    ('Да', true, 2),
    ('Нет', false, 2),
    ('Итальянскую', true, 3),
    ('Китайскую', false, 3),
    ('Мексиканскую', false, 3),
    ('Да', true, 4),
    ('Нет', false, 4);