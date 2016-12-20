<?php
    $x = 76; 
    function inc(&$x) {
        $x++;
    }
    
    function dec(&$x) {
        $x--;
    }
    inc($x); 
    dec($x); 
    inc($x); 
    var_dump($x); 