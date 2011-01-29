-- Procedures

-- actualiza os precos de todos os produtos
CREATE OR REPLACE PROCEDURE actualizar_preco_geral (perc IN number)
IS
  perc_final NUMBER;

BEGIN
  perc_final := perc/100;
  UPDATE produtos SET preco = preco * (1 + perc_final);

END actualizar_preco_geral;
/



-- actualizar os produtos de uma determinada faixa etária
CREATE OR REPLACE PROCEDURE actualizar_preco_faixa_etaria (perc IN number, id_faixa_etaria IN VARCHAR2)
IS
  perc_final NUMBER;

BEGIN
  perc_final := perc/100;
  UPDATE produtos SET preco = preco * (1 + perc_final) WHERE faixa_etaria = id_faixa_etaria;


END actualizar_preco_faixa_etaria;
/



-- actualizar os produtos de uma determinada area terapeutica
CREATE OR REPLACE PROCEDURE actualizar_preco_area_terapeu (perc IN number, id_area_terapeutica IN VARCHAR2)
IS
  perc_final NUMBER;

BEGIN
  perc_final := perc/100;
  UPDATE produtos SET preco = preco * (1 + perc_final) WHERE area_terapeutica = id_area_terapeutica;


END actualizar_preco_area_terapeu;
/