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
	  <td height="391" colspan="12" valign="top" align="center"">	    <form name="form1" method="post" action="medicamentos_procura.php">
	      <p><strong>Insira a informa&ccedil;&atilde;o sobre o medicamento que pretende procurar</strong></p>
	      <table width="521" border="0">
	        <tr>
	          <td width="169">ID</td>
	          <td width="244"><input type="text" name="id" id="2"></td>
            </tr>
	        <tr>
	          <td>Registo Infarmed</td>
	          <td><label for="registo_infarmed"></label>
              <input type="text" name="registo_infarmed" id="registo_infarmed"></td>
            </tr>
	        <tr>
	          <td>Nome</td>
	          <td><input type="text" name="nome" id="1"></td>
            </tr>
	        <tr>
	          <td>Quantidade Dispon&iacute;vel</td>
	          <td><input type="text" name="quantidade" id="textfield"> <input type="radio" name="quantidade_maior_ou_menor" value="maior" id="quantidade_maior_ou_menor_0">
	            <label>Maior que</label>
	            <input type="radio" name="quantidade_maior_ou_menor" value="menor" id="quantidade_maior_ou_menor_1">
              <label>Menor que</label></td>
            </tr>
	        <tr>
	          <td>Faixa Etária</td>
	          <td><label for="select"></label>
	            <select name="faixa_etaria" id="select">
	              <option></option>
	              <?php
					$connect = ocilogon("MIGUEL","433433","localhost");
					$stmt = ociparse($connect,"SELECT * FROM faixas_etarias");
					ociexecute($stmt,OCI_DEFAULT);
					
					while (ocifetch($stmt)){
						echo "<option>".ociresult($stmt,2)."</option>";
					}
					ocilogoff($connect);
				?>
	              
              </select></td>
            </tr>
	        <tr>
	          <td>&Aacute;rea Teraputica</td>
	          <td><select name="areas_terapeuticas" id="select">
	            <option></option>
	            <?php
					$connect = ocilogon("MIGUEL","433433","localhost");
					$stmt = ociparse($connect,"SELECT * FROM areas_terapeuticas");
					ociexecute($stmt,OCI_DEFAULT);
					
					while (ocifetch($stmt)){
						echo "<option>".ociresult($stmt,2)."</option>";
					}
					ocilogoff($connect);
				?>
              </select></td>
            </tr>
	        <tr>
	          <td>Temperatura</td>
	          <td><select name="temperaturas" id="select">
	            <option></option>
	            <?php
					$connect = ocilogon("MIGUEL","433433","localhost");
					$stmt = ociparse($connect,"SELECT * FROM temperaturas");
					ociexecute($stmt,OCI_DEFAULT);
					
					while (ocifetch($stmt)){
						echo "<option>".ociresult($stmt,2)."</option>";
					}
					ocilogoff($connect);
				?>
              </select></td>
            </tr>
	        <tr>
	          <td>Receita</td>
	          <td><p>
	            <label>
	              <input type="radio" name="receita_op" value="receita_sim" id="receita_op_0">
	              Sim</label>
	            <input type="radio" name="receita_op" value="receita_nao" id="receita_op_1">
	            <label>N&atilde;o</label>
  <br>
	            <br>
              </p></td>
            </tr>
	        <tr>
	          <td>Gen&eacute;rico</td>
	          <td><label>
	            <input type="radio" name="generico_op" value="generico_sim" id="generico_op_0">
	            Sim</label>
	            <input type="radio" name="generico_op" value="generico_nao" id="generico_op_1">
              <label>N&atilde;o</label></td>
            </tr>
	        <tr>
	          <td>Formato</td>
	          <td><select name="formatos" id="select">
	            <option></option>
	            <?php
					$connect = ocilogon("MIGUEL","433433","localhost");
					$stmt = ociparse($connect,"SELECT * FROM formatos");
					ociexecute($stmt,OCI_DEFAULT);
					
					while (ocifetch($stmt)){
						echo "<option>".ociresult($stmt,2)."</option>";
					}
					ocilogoff($connect);
				?>
              </select></td>
            </tr>
	        <tr>
	          <td>&nbsp;</td>
	          <td>&nbsp;</td>
            </tr>
          </table>
	      <p>&nbsp;</p>
	      <p>&nbsp;</p>
	      <p>&nbsp;</p>
	      <p>
	        <input type="submit" name="button" id="button" value="Procurar">
	        <input type="reset" name="button3" id="button3" value="Limpar Campos">
          </p>
        </form></td>
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