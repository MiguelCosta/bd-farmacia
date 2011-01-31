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
	  <td height="391" colspan="12" align="center" valign="top"><p>&nbsp;</p>
	  
      <p>
      	<?php
			$username_a_ins = $_POST['username_ins'];
			$password_a_ins = $_POST['password_ins'];
			$email_a_ins	= $_POST['email_ins'];
			$nome_a_ins		= $_POST['nome_ins'];
			$morada			= $_POST['morada_ins'];
			
			$estado = "valido";
			$msg_erro = "ERRO AO REGISTAR";
			
			if ($username_a_ins == null){
				$msg_erro = $msg_erro."<br>Falta inserir o username!";
				$estado = "invalido";
			}
			if ($password_a_ins == null){
				$msg_erro = $msg_erro."<br>Falta inserir a password!";
				$estado = "invalido";
			}
			
			if ($email_a_ins == null){
				$msg_erro = $msg_erro."<br>Falta inserir o email!";
				$estado = "invalido";
			}
			
			
			/*Para verificar se não existe já algum utilizador com os mesmos valores*/
			$connect = ocilogon("MIGUEL","433433","localhost");
			$sql = "SELECT * FROM clientes WHERE username = '".$username_a_ins."' OR email = '".$email_a_ins."'";
			$stmt = ociparse($connect,$sql);
			ociexecute($stmt,OCI_DEFAULT);
			ocifetch($stmt);
			$username_res = ociresult($stmt,1);
			$email_res = ociresult($stmt,3);
			
			if ($username_res == $username_a_ins){
				$msg_erro = $msg_erro."<br>O username inserido já existe!";
				$estado = "invalido";	
			}
			
			if ($email_res == $email_a_ins) {
				$msg_erro = $msg_erro."<br>O email inserido já existe!";
				$estado = "invalido";	
			}
			
			if ($estado == "invalido"){ 
				echo $msg_erro;
				echo "<br><br><a href='area_cliente_registar.php'>VOLTAR</a>";
			}
			
			if ($estado == "valido"){
				$sql = "INSERT INTO clientes VALUES ('".$username_a_ins."','".$password_a_ins."','".$email_a_ins."','".$nome_a_ins."','".$morada."',null,'0')";
				$stmt = oci_parse($connect,$sql);
				oci_execute($stmt,OCI_DEFAULT);
				$stmt = oci_parse($connect,"commit");
				oci_execute($stmt,OCI_DEFAULT);
				echo "Registado com sucesso :)";
				echo "<br><br><a href='area_cliente.php'>Continuar</a>";
			}
			
			//echo $username_a_ins;
			//echo $password_a_ins;
			//echo $email_a_ins;
			//echo $nome_a_ins;
			//echo $morada;
			//echo $data_nasc_a_ins;
		
			ocilogoff($connect);
		?>    
      
      
      </p>
      <p>&nbsp;</p></td>
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
		       <a href="index.php">Home</a> | <a href="medicamentos.php">Medicamentos</a> | <a href="area_cliente.php">Clientes</a> | <a href="estatisticas.php">Estat&iacute;sticas</a> | <a href="sobre_nos.php">Sobre N&oacute;s</a></td>
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