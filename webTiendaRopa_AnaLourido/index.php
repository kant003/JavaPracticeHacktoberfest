<?php
session_start();
include 'productos.php';

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['producto_id'])) {
    $producto_id = $_POST['producto_id'];
    if (isset($productos[$producto_id])) {
        if (!isset($_SESSION['carrito'][$producto_id])) {
            $_SESSION['carrito'][$producto_id] = 1;
        } else {
            $_SESSION['carrito'][$producto_id]++;
        }
    }
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['eliminar_id'])) {
    $eliminar_id = $_POST['eliminar_id'];
    if (isset($_SESSION['carrito'][$eliminar_id])) {
        unset($_SESSION['carrito'][$eliminar_id]);
    }
}

function calcularTotalCarrito($productos) {
    $total = 0;
    foreach ($_SESSION['carrito'] as $producto_id => $cantidad) {
        $total += $productos[$producto_id]['precio'] * $cantidad;
    }
    return $total;
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>La tienda de Ana</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <h1>Catálogo de Productos</h1>
    <div class="container">
        <div class="catalog">
            <?php foreach ($productos as $id => $producto): ?>
                <div class="product">
                    <img src="<?php echo $producto['imagen']; ?>" alt="<?php echo $producto['nombre']; ?>">
                    <h3><?php echo $producto['nombre']; ?></h3>
                    <div class="descripcion">
                        <p><?php echo $producto['descripcion']; ?></p>
                    </div>
                    <p>Precio: <?php echo $producto['precio']; ?> €</p>
                    <div class="button-container">
                        <form method="post" action="index.php">
                            <input type="hidden" name="producto_id" value="<?php echo $id; ?>">
                            <button type="submit">Comprar</button>
                        </form>
                        <br>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>

        <div class="cart">
            <h2>Carrito de Compra</h2>
            <?php if (!empty($_SESSION['carrito'])): ?>
                <ul>
                    <?php foreach ($_SESSION['carrito'] as $producto_id => $cantidad): ?>
                        <li>
                            <?php echo $productos[$producto_id]['nombre']; ?><br>   Unidades:
                            <?php echo $cantidad; ?> <br>   Precio total: 
                            <?php echo $productos[$producto_id]['precio'] * $cantidad; ?> €
                            <form method="post" action="index.php">
                                <input type="hidden" name="eliminar_id" value="<?php echo $producto_id; ?>">
                                <button class="eliminar" type="submit">Eliminar</button>
                            </form>
                        </li>
                        <br>
                    <?php endforeach; ?>
                </ul>
                <p>Total: <?php echo calcularTotalCarrito($productos); ?> €</p>
            <?php else: ?>
                <p>Tú carrito está vacío.</p>
            <?php endif; ?>
        </div>
    </div>

</body>
</html>