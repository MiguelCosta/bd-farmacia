<html>
<head>
<title>Farm�cia Virtual</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!-- ImageReady Preload Script (index.psd) -->
<script src="SpryAssets/SpryValidationPassword.js" type="text/javascript"></script>
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
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
<link href="SpryAssets/SpryValidationPassword.css" rel="stylesheet" type="text/css">
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
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
      
      
      <?php
	  	echo "<form name='form1' method='post' action='area_cliente_logado.php'>";
		echo "<p>LOGIN</p>";
	    echo "<p>Username   ";
		echo "<span id='sprytextfield1'>";
        echo "<input type='text' name='username_ins' id='text1'>";
        echo "<span class='textfieldRequiredMsg'><br>Insira o username.</span></span>";
	    echo "</p>";
	    echo "<p>Password   ";
		echo "<span id='sprypassword1'>";
	    echo "<input type='password' name='password_ins' id='password1'>";
        echo "<span class='passwordRequiredMsg'>";
		echo "<br>Insira a password.</span></span>";
	    echo  "</p>";
	    echo "<p>";
	    echo "<input type='submit' name='submeter' id='submeter' value='Entrar'>";
	    echo "</p>";
		echo "<br><a href='area_cliente.php'>Perdeu a password?</a>";
		echo "<br><br><a href='area_cliente_registar.php'>N�o est� registado? Registe-se agora!</a>";
        echo "</form>";
	  ?>
	    
	    <p>&nbsp;</p>
      <p></p></td>
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
<script type="text/javascript">
var sprypassword1 = new Spry.Widget.ValidationPassword("sprypassword1");
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
</script>
</body>
</center>
</html>