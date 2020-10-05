<?php
	include 'connection.php';
	$username = $_POST['username'];
	$password = $_POST['password'];
	if (!isset($username) || !isset($password)) {
		header("HTTP/1.1 400 Data empty");
		return;
	}
	$sql = "SELECT * FROM `user` WHERE `user_name` = '$username' and `password` = '$password'";
	$result = $conn -> query($sql);
	$row = $result -> fetch_assoc();
	if ($row) {
		echo json_encode($row);
	} else {
		header("HTTP/1.1 400 Register fail");
	}
?>