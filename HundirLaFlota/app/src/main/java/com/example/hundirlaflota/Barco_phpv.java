package com.example.hundirlaflota;

class Barco_phpv {
    private $_id;
    private $_tipo; //serán 1,2,3 o 4.
    private $_modulo= array(); //$fila, $columna, $estado
    private $_color;
    private $_mensaje;


    public function __construct($id, $tipo){
        $this->_id = $id;
        $this->_tipo = $tipo;

        for ($i=0; $i < $tipo; $i++) {
            $this->_modulo[] = array("fila" => -1, "columna" => -1, "estado" => 0);     //estado 0 significa intacto
        }
        $this->_mensaje = "Barco $tipo creado con el id $id";
    }

    public function navega($fila, $columna, $direccion, $flota){
        //valores de direccion N, S, E, O.
        switch ($direccion) {
            case 'N':
                $columnaFinal = $columna;
                $filaFinal = $fila - ($this ->_tipo - 1);
                $saltoFila = -1;
                $saltoColumna = 0;
                $lError = ($filaFinal <0)? true : false;
                break;

            case 'S':
                $columnaFinal = $columna;
                $filaFinal = $fila + ($this ->_tipo - 1);
                $saltoFila = +1;
                $saltoColumna = 0;
                $lError = ($filaFinal > 9)? true : false;
                break;

            case 'E':
                $filaFinal = $fila;
                $columnaFinal = $columna + ($this ->_tipo - 1);
                $saltoFila = 0;
                $saltoColumna = +1;
                $lError = ($columnaFinal > 9)? true : false;
                break;

            case 'O':
                $filaFinal = $fila;
                $columnaFinal = $columna - ($this ->_tipo - 1);
                $saltoFila = 0;
                $saltoColumna = -1;
                $lError = ($columnaFinal < 0)? true : false;
                break;

            default:
                break;
        }

        if (!$lError && !$this->objetoEnRadar(min($fila,$filaFinal), min($columna, $columnaFinal), max($fila, $filaFinal), max($columna, $columnaFinal), $flota)) {
            for ($i=0; $i < $this->_tipo; $i++) {
                $this->_modulo[$i][$fila] = $fila;
                $this->_modulo[$i][$columna] = $columna;
                $flota->ocupaEspacio($fila, $columna, $this->_tipo);

                $fila = $fila+$saltoFila;
                $columna = $columna+$saltoColumna;
            }

            $this->_mensaje = "En posición $fila : $columna";
            return true;
        }else{
            $this->_mensaje = "Barco no colocado";
            return false;
        }

    }

    private function objetoEnRadar($filaInicio, $columnaInicio, $filaFinal, $columnaFinal, $flota){
        $filaInicio = max(0, $filaInicio-1); //Si la fila empieza en la fila 0, no va a comprobar la fila de la izquierda, ya que no existe
        $columnaInicio = max(0, $columnaInicio-1);
        $filaFinal = min(9, $filaFinal+1);
        $columnaFinal = min(9,$columnaFinal+1);

        $lexisteObstaculo = false;

        for($i=$filaInicio; $i<=$filaFinal; $i++){
            for($j=$columnaInicio; $j<=$columnaFinal; $j++){
                if($flota->getEspacio($i, $j) !=0){
                    return true;
                }
            }
        }return $lexisteObstaculo;
    }
    public function getMensaje(){
        return $this->_mensaje;
    }
}

