<?php
session_start();
$password = $_SESSION['password'];
$cid = $_GET['rn'];
$con = mysqli_connect("dijkstra.ug.bcc.bilkent.edu.tr","mert.duran","mkyRf3AL","mert_duran");
$query = "DELETE FROM apply WHERE ('$cid','$password') = (cid, sid)";
$result = mysqli_query($con, $query);

if($result){
	$query = "UPDATE company SET quota = quota + 1 WHERE cid = '$cid'";
	$result = mysqli_query($con, $query);
	echo '<script>alert("DELETED")</script>'; 

}else{
	echo '<script>alert("COULDNT DELETED")</script>'; 

}
echo"<button onclick='history.go(-1);'>Go Student Page </button>";
echo "<br><br/>";
echo "<a href = 'index.php'>LOGOUT</a>";
mysqli_close($con);
?>
