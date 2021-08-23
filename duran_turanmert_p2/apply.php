<?php
session_start();
$password = $_SESSION['password'];
$cid = $_GET['rn'];
echo $cid;
$con = mysqli_connect("dijkstra.ug.bcc.bilkent.edu.tr","mert.duran","mkyRf3AL","mert_duran");
$query = "INSERT INTO apply(sid, cid) VALUES('$password', '$cid')";
$result = mysqli_query($con, $query);
if($result){
	$query = "UPDATE company SET quota = quota - 1 WHERE cid = '$cid'";
	$result = mysqli_query($con, $query);
	echo '<script>alert("APPLIED")</script>'; 

}else{
	echo '<script>alert("COULDNT APPLIED")</script>'; 

}
echo"<button onclick='history.go(-1);'>Go To Apply Page </button>";
echo "<a href = 'index.php'>LOGOUT</a>";
mysqli_close($con);
?>
