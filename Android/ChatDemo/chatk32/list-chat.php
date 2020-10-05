<?php
	include 'connection.php';
	$sql = "SELECT * FROM `chat`";
	$result = $conn -> query($sql);

	$array = array();
	while ($row = $result -> fetch_assoc()) {
		$array[] = $row;
	}
	echo json_encode($array);
?>