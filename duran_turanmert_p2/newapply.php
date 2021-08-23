<?php
echo "Welcome New Apply Process";
session_start();
$password = $_SESSION['password'];
session_start();
$_SESSION['password']= $password;
$con = mysqli_connect("dijkstra.ug.bcc.bilkent.edu.tr","mert.duran","mkyRf3AL","mert_duran");
$query = "SELECT cid, cname FROM company WHERE quota>0 AND cid NOT IN (SELECT cid FROM apply WHERE sid='$password')";
$result = mysqli_query($con, $query);	
echo "<br><br/>";
if($result-> num_rows > 0){
	while( $row = $result->fetch_assoc()){
		echo $row["cid"];
		echo " ";
		echo $row["cname"];
		echo " ";
		echo "<a href = 'apply.php?rn=$row[cid]'>APPLY</a>";
		echo "<br><br/>";
	}
}
echo"<button onclick='history.go(-1);'>Go Student Page </button>";
echo "<br><br/>";
echo "<a href = 'index.php'>LOGOUT</a>";
?>
