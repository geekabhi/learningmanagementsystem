use lms_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table teachers;
truncate table klasses;
set FOREIGN_KEY_CHECKS = 1;

TRUNCATE TABLE students;

INSERT INTO `students`
(`email`)
VALUES
('asdf@asdf.asdf');

INSERT INTO `klasses`
(`name`,
 `semester`,
 `credits`,
 `department`,
 `fee`)
VALUES
  ('asdf', '2017-01-30 11:10:49', 2, 'ENGINEERING', 200.00);

INSERT INTO `teachers`
(
 `name`,
 `age`,
 `gender`,
 `klass_id`)
VALUES
  ('Andreas', 35, 'Male', 1);

INSERT INTO `teachers`
(
  `name`,
  `age`,
  `gender`,
  `klass_id`)
VALUES
  ('Chyld', 35, 'Male', 1);