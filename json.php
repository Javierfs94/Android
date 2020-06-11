<?php
$dbh = new PDO("mysql:host=localhost;dbname=sopa_letras","root","root");
$sql = "SELECT * FROM capitales";
$q = $dbh->prepare($sql);
$q->execute(array());

$array=array();
foreach ($q->fetchAll() as $row) {
    $capital = $row["capital"];
    $array[] = $capital;
}

echo json_encode($array);

?>