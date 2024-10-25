<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado de la Operación</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Resultado de la Operación</h1>
        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            if (empty($_POST['numero1']) || empty($_POST['numero2']) || empty($_POST['operacion'])) {
                echo "<p>Debe ingresar todos los campos. <a href='operacion.html'>Volver al formulario</a></p>";
            } else {
                $numero1 = (int)$_POST['numero1'];
                $numero2 = (int)$_POST['numero2'];
                $operacion = $_POST['operacion'];

                switch ($operacion) {
                    case 'suma':
                        $resultado = $numero1 + $numero2;
                        echo "<p$resultado</p>";
                        break;

                    case 'resta':
                        $resultado = $numero1 - $numero2;
                        echo "<p>$resultado</p>";
                        break;

                    case 'producto':
                        $resultado = $numero1 * $numero2;
                        echo "<p>$resultado</p>";
                        break;

                    case 'cociente':
                        if ($numero2 != 0) {
                            $resultado = $numero1 / $numero2;
                            echo "<p>$resultado</p>";
                        } else {
                            echo "<p>No se puede dividir entre 0.</p>";
                        }
                        break;

                    default:
                        echo "<p>Operación no válida.</p>";
                }
            }
        } else {
            echo "<p>Acceso denegado.</p>";
        }
        ?>
        <a href="operacion.html">Volver al formulario</a>
    </div>
</body>
</html>
