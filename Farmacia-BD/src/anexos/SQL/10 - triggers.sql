CREATE OR REPLACE TRIGGER actualiza_quantidade
AFTER INSERT OR UPDATE ON vendas
FOR EACH ROW
DECLARE
BEGIN
  UPDATE produtos SET produtos.quantidade = quantidade - 1 WHERE produto = :NEW.produto;
END actualiza_quantidade;
/
ALTER TRIGGER actualiza_quantidade ENABLE;
