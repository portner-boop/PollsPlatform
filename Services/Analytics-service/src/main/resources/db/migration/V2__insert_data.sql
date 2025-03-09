INSERT INTO analytic.polls_completed_by_user (user_id) VALUES ('user101');
INSERT INTO analytic.polls_completed_by_user (user_id) VALUES ('user102');
INSERT INTO analytic.polls_completed_by_user (user_id) VALUES ('user103');

-- Вставка в poll without specifying id
INSERT INTO analytic.poll (type_of_poll, poll_id, polls_completed_by_user_id)
VALUES ('Survey', 1001, 1);

INSERT INTO analytic.poll (type_of_poll, poll_id, polls_completed_by_user_id)
VALUES ('Quiz', 1002, 2);

INSERT INTO analytic.poll (type_of_poll, poll_id, polls_completed_by_user_id)
VALUES ('Feedback', 1003, 3);

-- Вставка в answer without specifying id
INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (1, 1, 'Yes', true, 1);

INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (2, 2, 'No', false, 1);

INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (3, 3, 'Option A', true, 2);

INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (4, 4, 'Option B', false, 2);

INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (5, 5, ' Agree', true, 3);

INSERT INTO analytic.answer (question_id, answer_id, answer, correctness, poll_id)
VALUES (6, 6, 'Disagree', false, 3);