use lms_test;

TRUNCATE TABLE students;
TRUNCATE TABLE klasses;

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