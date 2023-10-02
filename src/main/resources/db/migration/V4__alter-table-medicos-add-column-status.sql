ALTER TABLE medicos ADD status TINYINT;
UPDATE medicos SET status = 1;
/* 1 = ativo, 0 = inativo */