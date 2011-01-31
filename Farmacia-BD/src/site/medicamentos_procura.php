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

	    
	    <?php
			$connect = ocilogon("MIGUEL","433433","localhost");
			$pesquisa = "invalida";
			
			$id_p 		= $_POST['id'];
			$reg_p 		= $_POST['registo_infarmed'];
			
			/*regista pelo id do produto*/
			if(ereg('[^0-9]',$id_p)){
        		echo " O Id inserido não é um número! Por favor altere a sua pesquisa";
				$pesquisa = "invalida";
			} else {
				if (strlen($id_p) > 0){
					echo "<table width='606' border='0' align='center'>";
						echo "<tr>";
							echo "<td>";
        					echo "A sua procura apenas foi feita pelo id";
							echo "</td>";
						echo "</tr>";
					echo "</table>";
					
					$stmt = ociparse($connect, "SELECT * FROM produtos WHERE produto = '".$id_p."'");
					$pesquisa = "valida";
			    }
			}
			
			/*Pesquisa pelo registo infarmed*/
			if(ereg('[^0-9]',$reg_p) & $pesquisa == "invalida"){
        		echo " O registo infarmed inserido não é um número! Por favor altere a sua pesquisa";
				$pesquisa = "invalida";
			} else {
				if (strlen($reg_p) > 0 & $pesquisa == "invalida"){
					echo "<table width='606' border='0' align='center'>";
						echo "<tr>";
							echo "<td>";
        					echo "A sua procura apenas foi feita pelo registo infarmed";
							echo "</td>";
						echo "</tr>";
					echo "</table>";
					
					$stmt = ociparse($connect, "SELECT * FROM produtos WHERE reg_infarmed = '".$reg_p."'");
					$pesquisa = "valida";
			    }
			}
			
			$quantidade = $_POST['quantidade'];
			/*se seleccionado igual a maior ou menor*/
			$quantidade_sel = $_POST['quantidade_maior_ou_menor'];
			
			/*devolve a linha que está selecionada das faixas etárias*/
			$faixa_etaria_sel = $_POST['faixa_etaria'];
			$stmt_faixa_etaria = ociparse($connect,"SELECT * FROM faixas_etarias WHERE nome = '".$faixa_etaria_sel."'");
			ociexecute($stmt_faixa_etaria,OCI_DEFAULT);
			ocifetch($stmt_faixa_etaria);
			$faixa_etaria = ociresult($stmt_faixa_etaria,1);
			
			/*devolve a linha que está selecionada das áreas terapeuticas*/
			$area_terapeutica_sel = $_POST['areas_terapeuticas'];
			$stmt_area_terapeutica = ociparse($connect,"SELECT * FROM areas_terapeuticas WHERE nome = '".$area_terapeutica_sel."'");
			ociexecute($stmt_area_terapeutica,OCI_DEFAULT);
			ocifetch($stmt_area_terapeutica);
			$area_terapeutica = ociresult($stmt_area_terapeutica,1);
			
			
			/*devolve a linha que está selecionada das temperaturas*/
			$temperatura_sel = $_POST['temperaturas'];
			$stmt_temperatura = ociparse($connect,"SELECT * FROM temperaturas WHERE nome = '".$temperatura_sel."'");
			ociexecute($stmt_temperatura,OCI_DEFAULT);
			ocifetch($stmt_temperatura);
			$temperatura = ociresult($stmt_temperatura,1);
			
			/*devolve a linha que está selecionada dos formatos*/
			$formatos_sel = $_POST['formatos'];
			$stmt_formato = ociparse($connect,"SELECT * FROM formatos WHERE nome = '".$formatos_sel."'");
			ociexecute($stmt_formato,OCI_DEFAULT);
			ocifetch($stmt_formato);
			$formato = ociresult($stmt_formato,1);
			
			
			/*Se não for possível procurar por id ou pelo registo infarmed vai usar o resto da informação inserida*/
			if($pesquisa == "invalida"){
				
				$sql = "SELECT * FROM produtos WHERE nome_generico LIKE '%".$_POST['nome']."%'";
			
				/*a variável campos, serve para saber se a informação introduzida nos vários campos pode ser realizada*/
				$campos = "valido";
				if(ereg('[^0-9]',$quantidade)){
        			echo " A quantidade inserida não é um número! Por favor altere a sua pesquisa";
					$pesquisa = "invalida";
					$campos = "invalido";
				} else {
					if ($quantidade_sel == maior & strlen($quantidade) > 0) $sql = $sql." AND quantidade > ".$quantidade;
					if ($quantidade_sel == menor & strlen($quantidade) > 0) $sql = $sql." AND quantidade < ".$quantidade;
				}
				
				
				if ($campos = "valido"){
					if ($faixa_etaria > 0) $sql = $sql." AND faixa_etaria = ".$faixa_etaria	;
					if ($area_terapeutica > 0) $sql = $sql." AND area_terapeutica = ".$area_terapeutica	;
					if ($temperatura > 0) $sql = $sql." AND temperatura = ".$temperatura ;
					if ($formato > 0) $sql = $sql." AND formato = ".$formato ;
					
					$receita_sel = $_POST['receita_op'];
					if ($receita_sel == receita_sim) $sql = $sql." AND receita = 1";
					if ($receita_sel == receita_nao) $sql = $sql." AND receita = 0";
					
					$generico_sel = $_POST['generico_op'];
					if ($receita_sel == generico_sim) $sql = $sql." AND generico = 1";
					if ($receita_sel == generico_nao) $sql = $sql." AND generico = 0";
				};
				
				
				
				$stmt = ociparse($connect, $sql);
				$pesquisa = "valida";
			}
			
			
			
			//$stmt = ociparse($connect,"SELECT * FROM produtos WHERE nome_generico LIKE '%".$_POST['nome']."%'"." OR nome_medicamento LIKE	'%".$_POST['nome']."%'" );

			if ($pesquisa == "valida") {
    			ociexecute($stmt,OCI_DEFAULT);

				echo "<table width='606' border='0' align='center'>";
					echo "<tr>";
					echo "<th><h5>ID</h5></th>";
					echo "<th align='left'><h5>NOME GENERICO</h5></th>";
					echo "<th align='left'><h5>NOME MEDICAMENTO</h5></th>";
					echo "<th align='left'><h5>DETALHES</h5></th>";
					echo "</tr>";
	
				for($i = 0; $i < 150	 & ocifetch($stmt) ; $i++){
					$id = ociresult($stmt,1);
					$nome_generico = ociresult($stmt,2);
					$nome_medicamento = ociresult($stmt,3);
					echo "<tr>";
					echo "<td>".$id."</td>";
					echo "<td>".$nome_generico."</td>";
					echo "<td>".$nome_medicamento."</td>";
					echo "<td><a href = 'mostrar_produto.php?prod_id=$id'> Ver Detalhes </td>";
					echo "</tr>";
				}
	
				echo "</table>";
			}
			ocilogoff($connect);
		?>
	    </td>
        

    </tr>
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