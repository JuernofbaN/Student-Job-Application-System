<?php
session_start();
$con = mysqli_connect("dijkstra.ug.bcc.bilkent.edu.tr","mert.duran","mkyRf3AL","mert_duran");
$username = $_POST['username'];
$pass     = $_POST['password'];
$query = "SELECT * FROM student WHERE sname='$username' and sid='$pass'";
$result = mysqli_query($con, $query);
mysqli_close($con);
$num = mysqli_num_rows($result);
$_SESSION['username'] = $username;
session_start();
$_SESSION['password'] = $pass;
if ($num > 0)
{
	header("Location: studentwelcomepage.php");
	exit();
}
else
{
	echo "<a href='index.php'>PRESS HERE TO TRY AGAIN!</a>";
	echo "<br><br/>";
	echo "Username and password didnt match.!";
}
echo "<br><br/>";
echo "<a href = 'index.php'>LOGOUT</a>";
?>
