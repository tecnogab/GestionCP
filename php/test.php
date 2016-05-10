<?php

/*Incluimos el fichero de la clase*/
require 'dbConn.php';

/*Creamos la instancia del objeto. Ya estamos conectados*/
$bd = DbConn::getInstance();

/*Creamos una query sencilla*/
$sql = 'select numero_par from t_parcelas LIMIT 0, 30';

/*Ejecutamos la query*/
$stmt = $bd -> ejecutar($sql);

/*Realizamos un bucle para ir obteniendo los resultados*/
while ($x = $bd -> obtener_fila($stmt, 0)){
   echo $x['numero_par'].'<br />';
}

?>