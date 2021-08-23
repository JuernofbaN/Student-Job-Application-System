<html>
 <head>
  <title>DatabaseHomework</title>
 </head>
 <body>
 <h1>Index Page</h1>
 <form name ="formLog" onsubmit="return validateForm()" action = "login.php" method = "POST">
        <label>Username</label>
        <input type = "text" name = "username">
        <label>Password</label>
        <input type = "text" name = "password">
        <input type="submit" value="Login"> 
</form>
<script>
	function validateForm() 
	{
        if (document.forms["formLog"]["username"].value == ""){
        	alert("Username and Password can not be empty");
        	return false;
    	} 
        if (document.forms["formLog"]["password"].value == ""){
        	alert("Username and Password can not be empty");
        	return false;
    	}       
    }
</script>
 </body>
</html>
