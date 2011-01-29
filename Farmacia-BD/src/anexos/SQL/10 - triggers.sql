create or replace
TRIGGER regista_venda
BEFORE INSERT ON vendas
FOR EACH ROW
DECLARE
n_venda varchar2(8);
BEGIN
  UPDATE produtos SET produtos.quantidade = quantidade - 1 WHERE produto = :NEW.produto;

  SELECT numero INTO n_venda FROM lista_vendas WHERE numero = :NEW.numero;
  
  UPDATE lista_vendas SET montante_total = montante_total + :NEW.montante WHERE numero = :NEW.numero;
  UPDATE clientes SET montante_gasto = montante_gasto + :NEW.montante WHERE username = :NEW.cliente_username;

   EXCEPTION when no_data_found 
    THEN
      INSERT INTO lista_vendas VALUES (:NEW.numero, sysdate, :NEW.cliente_username, :NEW.montante);
      UPDATE clientes SET montante_gasto = montante_gasto + :NEW.montante WHERE username = :NEW.cliente_username;
END regista_venda;
/
ALTER TRIGGER regista_venda ENABLE;



CREATE OR REPLACE FUNCTION ver_var (numero_venda IN varchar2) RETURN varchar2
IS
  resultado varchar2(20);
BEGIN
  SELECT numero INTO resultado FROM lista_vendas WHERE numero = numero_venda;
  
  IF resultado IS NULL
    THEN resultado := 'ola';
  END IF;
  
  RETURN 'as';
END ver_var;
/
