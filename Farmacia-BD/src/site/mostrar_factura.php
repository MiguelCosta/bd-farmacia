<html>
<head>
<title>Farmácia Virtual</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- ImageReady Preload Script (index.psd) -->
<script type="text/javascript">
<!--

function newImage(arg) {
	if (document.images) {
		rslt = new Image();
		rslt.src = arg;
		return rslt;
	}
}

function changeImages() {
	if (document.images && (preloadFlag == true)) {
		for (var i=0; i<changeImages.arguments.length; i+=2) {
			document[changeImages.arguments[i]].src = changeImages.arguments[i+1];
		}
	}
}

var preloadFlag = false;
function preloadImages() {
	if (document.images) {
		home_over = newImage("images/home-over.jpg");
		company_profile_over = newImage("images/company-profile-over.jpg");
		services_over = newImage("images/services-over.jpg");
		support_over = newImage("images/support-over.jpg");
		contacts_over = newImage("images/contacts-over.jpg");
		preloadFlag = true;
	}
}

// -->
</script>
<!-- End Preload Script -->
</head>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<center>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="preloadImages();">
<!-- ImageReady Slices (index.psd) -->
<table width="776" height="592" border="0" cellpadding="0" cellspacing="0" class="frame" id="Table_01">
	<tr>
		<td height="73" colspan="3">
			<img src="images/m1.jpg" width="169" height="73" alt=""></td>
		<td>
			<a href="index.php"
				onmouseover="window.status='home'; changeImages('home', 'images/home-over.jpg'); return true;"
				onmouseout="window.status=''; changeImages('home', 'images/home.jpg'); return true;"
				onmousedown="changeImages('home', 'images/home-over.jpg'); return true;"
				onmouseup="changeImages('home', 'images/home-over.jpg'); return true;">
			  <img name="home" src="images/home.jpg" width="89" height="73" border="0" alt="home"></a></td>
		<td colspan="3">
			<a href="medicamentos.php"
				onmouseover="window.status='company profile'; changeImages('company_profile', 'images/company-profile-over.jpg'); return true;"
				onmouseout="window.status=''; changeImages('company_profile', 'images/company-profile.jpg'); return true;"
				onmousedown="changeImages('company_profile', 'images/company-profile-over.jpg'); return true;"
				onmouseup="changeImages('company_profile', 'images/company-profile-over.jpg'); return true;">
				<img name="company_profile" src="images/company-profile.jpg" width="159" height="73" border="0" alt="company profile"></a></td>
		<td colspan="2">
			<a href="area_cliente.php"
				onmouseover="window.status='services'; changeImages('services', 'images/services-over.jpg'); return true;"
				onmouseout="window.status=''; changeImages('services', 'images/services.jpg'); return true;"
				onmousedown="changeImages('services', 'images/services-over.jpg'); return true;"
				onmouseup="changeImages('services', 'images/services-over.jpg'); return true;">
				<img name="services" src="images/services.jpg" width="107" height="73" border="0" alt="services"></a></td>
		<td>
			<a href="estatisticas.php"
				onmouseover="window.status='support'; changeImages('support', 'images/support-over.jpg'); return true;"
				onmouseout="window.status=''; changeImages('support', 'images/support.jpg'); return true;"
				onmousedown="changeImages('support', 'images/support-over.jpg'); return true;"
				onmouseup="changeImages('support', 'images/support-over.jpg'); return true;">
				<img name="support" src="images/support.jpg" width="107" height="73" border="0" alt="support"></a></td>
		<td colspan="2">
			<a href="sobre_nos.php"
				onmouseover="window.status='contacts'; changeImages('contacts', 'images/contacts-over.jpg'); return true;"
				onmouseout="window.status=''; changeImages('contacts', 'images/contacts.jpg'); return true;"
				onmousedown="changeImages('contacts', 'images/contacts-over.jpg'); return true;"
				onmouseup="changeImages('contacts', 'images/contacts-over.jpg'); return true;">
				<img name="contacts" src="images/contacts.jpg" width="144" height="73" border="0" alt="contacts"></a></td>
	</tr>
	<tr>
		<td height="41" colspan="12"><p><img src="images/Untitled-1.jpg" width="776" height="49"></p></td>
	</tr>
	<tr>
	  <td height="391" colspan="12" align="center" valign="top">

	    
	    <p>&nbsp;</p>
	    <p><span class="text1">Detalhes da Factura</span></p>
	    <?php
			$connect = ocilogon("MIGUEL","433433","localhost");
			$stmt = ociparse($connect,"SELECT * FROM lista_vendas WHERE numero = '".$_GET['fact_id']."'");
			//echo "SELECT * FROM lista_vendas WHERE numero = '".$_GET['fact_id']."'";
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			
			$numero = ociresult($stmt,1);
			$montante = ociresult($stmt,4);
			$data_registo = ociresult($stmt,2);
			$cliente_username = ociresult($stmt,3);
			
			echo "<table width='200' border='0' align='center'>";
				echo "<tr>";
					echo "<td align='right'><strong>N.º da Factura - </strong></td>";
					echo "</td>";
					echo "<td>";
						echo $numero;
					echo "</td>";
				echo "</tr>";
				
				echo "<tr>";
					echo "<td align='right'><strong>Data de Facturação - </strong></td>";
					echo "</td>";
					echo "<td>";
						echo $data_registo;
					echo "</td>";
				echo "</tr>";
				
				echo "<tr>";
					echo "<td align='right'><strong>Username do Cliente - </strong></td>";
					echo "<td>".$cliente_username."</td>";
				echo "</tr>";
				
				echo "<tr>";
					echo "<td align='right'><strong>Montante total - </strong></td>";
					echo "<td>".$montante." €</td>";
				echo "</tr>";
				
			echo "</table>";
			$sql = "SELECT produto, count(produto), montante FROM vendas WHERE numero = '".$numero."' GROUP BY produto, montante";
			$stmt = ociparse($connect,$sql);
			ociexecute($stmt,OCI_DEFAULT);
			
			echo "<br>";
			echo "<br>";	
			echo "<table width='300' border='0' align='center'>";
				echo "<tr>";
					echo "<td><strong>Produto</strong></td>";
					echo "<td><strong>Quantidade</strong></td>";
					echo "<td><strong>Preço Unitário</strong></td>";
					echo "<td><strong>Preço Total</strong></td>";
					
				echo "</tr>";
				$total = 0;
				while (ocifetch($stmt)){
					echo "<tr>";
						$id_produto = ociresult($stmt,1);
						$quantidade = ociresult($stmt,2);
						$preco_unit = ociresult($stmt,3);
						$preco_total = $quantidade * $preco_unit;
						$total = $total + $preco_total; 
						echo "<td align='center'><a href = 'mostrar_produto.php?prod_id=$id_produto'>".$id_produto."</td>";
						echo "<td align='center'>".$quantidade."</td>";
						echo "<td align='right'>".$preco_unit." €</td>";
						echo "<td align='right'>".$preco_total." €</td>";
					echo "</tr>";					
				}
					echo "<tr>";
						echo "<td></td>";
						echo "<td></td>";
						echo "<td align='right'><strong>Total</strong></td>";
						echo "<td align='right'><strong>".$total." €</strong></td>";
					echo "</tr>";
				
			echo "</table>";
	
			/*
			$id = ociresult($stmt,1);
			$nome_generico = ociresult($stmt,2);
			$nome_medicamento = ociresult($stmt,3);
			$quantidade = oci_result($stmt,4);
			$faixa_etaria = oci_result($stmt,5);
			$registo_infarmed = oci_result($stmt,6);
			$area_terapeutica = oci_result($stmt,7);
			$lote = oci_result($stmt,8);
			$dosagem = oci_result($stmt,9);
			$temperatura = oci_result($stmt,10);
			$preco = oci_result($stmt,11);
			$administracao = oci_result($stmt,12);
			$receita = oci_result($stmt,13);
			$generico = oci_result($stmt,14);
			$formato = oci_result($stmt,15);
			$folheto_url = oci_result($stmt,16);
			
			$stmt = ociparse($connect, "SELECT * FROM faixas_etarias WHERE faixa_etaria = '".$faixa_etaria."'");
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$faixa_etaria_n = oci_result($stmt,2);
			
			$stmt = ociparse($connect, "SELECT * FROM areas_terapeuticas WHERE areaterapeutica = '".$area_terapeutica."'");
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$area_terapeutica_n = oci_result($stmt,2);
			
			$stmt = ociparse($connect, "SELECT * FROM temperaturas WHERE temperatura = '".$temperatura."'");
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$temperatura_n = oci_result($stmt,2);	
			
			$stmt = ociparse($connect, "SELECT * FROM administracoes WHERE administracao = '".$administracao."'");
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$administracao_n = oci_result($stmt,2);
			
			if ($receita == "0") $receita = "Não";
			else $receita = "Sim";
			
			if ($generico == "0") $generico = "Não";
			else $generico = "Sim";
			
			$stmt = ociparse($connect, "SELECT * FROM formatos WHERE formato = '".$formato."'");
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$formato_n = oci_result($stmt,2);
			
			
			echo "<table width='350' border='0' align='center'>";
				echo "<tr>";
					echo "<td align='right'><strong>ID Produto</strong></td>";
					//echo "<td width='10' height='10'></td>";
					echo "<td>"." - ".$id."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Nome Generico</strong></td>";
					echo "<td>"." - ".$nome_generico."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Nomde do Medicamento</strong></td>";
					echo "<td>"." - ".$nome_medicamento."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Quantidade Disponível</strong></td>";
					echo "<td>"." - ".$quantidade."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Faixa Etária</strong></td>";
					echo "<td>"." - ".$faixa_etaria_n."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Registo Infarmed</strong></td>";
					echo "<td>"." - ".$registo_infarmed."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Area Terapeutica</strong></td>";
					echo "<td>"." - ".$area_terapeutica_n."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Lote</strong></td>";
					echo "<td>"." - ".$lote."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Dosagem</strong></td>";
					echo "<td>"." - ".$dosagem."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Temperatura</td>";
					echo "<td>"." - ".$temperatura_n."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Preço</strong></td>";
					echo "<td>"." - ".$preco." €</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Administração</strong></td>";
					echo "<td>"." - ".$administracao_n."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Receita</strong></td>";
					echo "<td>"." - ".$receita."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Generico</td>";
					echo "<td>"." - ".$generico."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Formato</strong></td>";
					echo "<td>"." - ".$formato_n."</td>";
				echo "</tr>";
				echo "<tr>";
					echo "<td align='right'><strong>Folheto</strong></td>";
					echo "<td>"." - ".$folheto_url."</td>";
				echo "</tr>";
			echo "</table>";
			*/
			
	?> 
	    </td>
    </tr	>
	<tr>
		<td height="19" colspan="12">
			<img src="images/dn1.jpg" width="775" height="19" alt=""></td>
	</tr>
	<tr>
		<td height="61" colspan="5" align="center" valign="middle" class="text2">Copyright &copy; Farm&aacute;cia Virtual<br></td>
		<td>
			<img src="images/dn2.jpg" width="47" height="61" alt=""></td>
		<td colspan="6" align="center" valign="middle" class="text2">
		       <a href="index.php">Home</a> | <a href="medicamentos.php">Medicamentos</a> | <a href="stocks.html">Clientes</a> | <a href="estatisticas.php">Estat&iacute;sticas</a> | <a href="sobre_nos.php">Sobre N&oacute;s</a></td>
	</tr>
	<tr>
		<td>
			<img src="images/spacer.gif" width="55" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="89" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="25" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="89" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="84" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="47" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="28" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="59" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="48" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="107" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="121" height="1" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="23" height="1" alt=""></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</body>
</center>
</html>