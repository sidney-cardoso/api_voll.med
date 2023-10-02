ALTER TABLE pacientes ADD COLUMN status TINYINT;
UPDATE pacientes SET status = 1 WHERE status IS NULL;
ALTER TABLE pacientes MODIFY status TINYINT NOT NULL;
