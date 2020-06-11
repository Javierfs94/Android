package com.example.hundirlaflota;

//include "barco.php";

class Flota_phpv {
    public $_tablero = array();
    public $barcos = array();

    public function __construct(){
        for($i=0;$i<10;$i++){
            array_push($this->_tablero, array(0,0,0,0,0,0,0,0,0,0));
        }
    }

    public function addBarco($barco){
        $this->_barcos[] = $barco;
    }

    public function colocarBarcos(){
        $direccion = array("N","S","E","O");
        foreach($this->_barcos as $barco){
            do{
                $fila = mt_rand(0,9);
                $columna = mt_rand(0,9);
                $ind = mt_rand(0,3);
            }
            while (!($barco->navega($fila,$columna,$direccion[$ind],$this)));
        }
    }

    public function getEspacio($fila, $columna){
        return $this->_tablero[$fila][$columna];
    }

    public function ocupaEspacio($fila, $columna, $valor){
        $this->_tablero[$fila][$columna]=$valor;
    }

    public function mostrarFlota(){
        echo "<table>";
        for ($i=0;$i<10;$i++){
            echo "<tr>";
            for($j=0;$j<10;$j++){
                echo "<td>";
                if($this->_tablero[$i][$j] == 0){
                    echo "0";
                }
                else{
                    echo $this->_tablero[$i][$j];
                }
                echo "</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
    }
}