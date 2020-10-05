<?php
	include 'connection.php';
	$username = $_POST['username'];
	$message = $_POST['message'];
	$date = date("d/M/yy H:m");

	if (!isset($username) || !isset($message)) {
		header("HTTP/1.1 400 Data empty");
		return;
	}

	$sql = "INSERT INTO `chat`(`username`, `message`, `pub_date`) VALUES ('$username', '$message', '$date')";

	$result = $conn -> query($sql);
	if ($result) {
		header("HTTP/1.1 200 Chat success");
	} else {
		header("HTTP/1.1 400 Chat fail");
	}
?>