package com.example.hundirlaflota;

public class index {


    //include "Flota.php";

    $barco = null;
    $tipo = 1;
    $flota= new Flota_phpv();

        for($i=0; $i<10; $i++){
        switch($i){
            case 1:
            case 2:
            case 3:
            case 4:
                $tipo=1;
                break;
            case 5:
            case 6:
            case 7:
                $tipo=2;
                break;
            case 8:
            case 9:
                $tipo=3;
                break;
            case 10:
                $tipo=4;
                break;
        }
        $barco = new Barco_phpv($i, $tipo);
        $flota->addBarco($barco);
    }
    $flota->colocarBarcos();
    $flota->mostrarFlota();

}
