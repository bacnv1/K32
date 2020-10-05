<?php
	include 'connection.php';
	$username = $_POST['username'];
	$password = $_POST['password'];
	$name = $_POST['name'];
	if (!isset($username) || !isset($password) || !isset($name)) {
		header("HTTP/1.1 400 Data empty");
		return;
	}
	$sql = "INSERT INTO `user`(`user_name`, `password`, `name`) VALUES ('$username', '$password', '$name')";
	$result = $conn -> query($sql);
	if ($result) {
		header("HTTP/1.1 200 Register success");
	} else {
		header("HTTP/1.1 400 Register fail");
	}
?>