package proyectoalgoritmos;
import java.util.Scanner;
public class sistema {
    
public static void SistemaVentas(){
    Scanner teclado = new Scanner(System.in);

    int numeroProductos, cantidad, codigo,formaPago;
    int opcion;
    int ventas = 0;
    int productosVendidos = 0;
    int ventasEfectivo = 0;
    int ventasTarjeta = 0;
    int ventasTransferencia = 0;
    int cantidadVenta = 0;

    double subtotalProducto, descuento, preciodouble, porcentaje, precio, montoDescuento, iva, total;
            
    
    double efectivo = 0;
    double cambio = 0;
    double subtotal = 0;
    double totalVendido = 0;
    double ventaMayor = 0;
    double ventaMenor = 0;

    boolean salir = false;

        do {
            System.out.println("\u001B[33m\n===== SISTEMA DE VENTAS =====\u001B[0m");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Consultar caja");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            while (opcion < 1 || opcion > 4) {
                System.out.print("\u001B[31mOpcion incorrecta. \u001B[0m"
                        + "\nIngrese del 1 al 4: ");
                opcion = teclado.nextInt();
            }

            switch (opcion) {

                case 1: {

                    do {
                        System.out.print("Cuantos productos tendra la compra: ");
                        numeroProductos = teclado.nextInt();

                        if (numeroProductos <= 0) {
                        System.out.println("\u001B[31mDebe ingresar un numero mayor a cero.\u001B[0m");

                        }

                    } while (numeroProductos <= 0);


                    for (int i = 1; i <= numeroProductos; i++) {

                        System.out.println("\nProducto " + i);

                        System.out.print("Codigo: ");
                        codigo = teclado.nextInt();
                        teclado.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();

                        do {
                            System.out.print("Precio: Q ");
                            precio = teclado.nextDouble();

                            if (precio <= 0) {
                                System.out.println("\u001B[31mEl precio debe ser mayor que cero.\u001B[0m");
                            }

                        } while (precio <= 0);

                        do {
                            System.out.print("Cantidad: ");
                            cantidad = teclado.nextInt();

                            if (cantidad <= 0) {
                                System.out.println("\u001B[31mLa cantidad debe ser mayor que cero.\u001B[0m");
                            }

                        } while (cantidad <= 0);

                        subtotalProducto = precio * cantidad;

                        subtotal = subtotal + subtotalProducto;
                        cantidadVenta = cantidadVenta + cantidad;

                        System.out.println("Producto: " + nombre);
                        System.out.println("Codigo: " + codigo);
                        System.out.println("Subtotal del producto: Q" + subtotalProducto);
                    }


                    if (subtotal < 200) {
                        porcentaje = 0;
                    } else if (subtotal < 500) {
                        porcentaje = 0.05;
                    } else if (subtotal < 1000) {
                        porcentaje = 0.08;
                    } else {
                        porcentaje = 0.10;
                    }

                    descuento = subtotal * porcentaje;
                    montoDescuento = subtotal - descuento;
                    iva = montoDescuento * 0.12;
                    total = montoDescuento + iva;

                    System.out.println("\u001B[33m\n===== CALCULO DE VENTA =====\u001B[0m");
                    System.out.println("Subtotal: Q" + subtotal);
                    System.out.println("Descuento: Q" + descuento);
                    System.out.println("Monto con descuento: Q" + montoDescuento);
                    System.out.println("IVA: Q" + iva);
                    System.out.println("Total: Q" + total);

                    System.out.println("\u001B[32m\nForma de pago:\u001B[0m");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    System.out.println("3. Transferencia");
                    System.out.print("Seleccione una opcion: ");

                    formaPago = teclado.nextInt();

                    while (formaPago < 1 || formaPago > 3) {
                        System.out.print("\u001B[31mOpcion incorrecta. Ingrese del 1 al 3: \u001B[0m");
                        formaPago = teclado.nextInt();
                    }


                    switch (formaPago) {

                        case 1:
                            do {
                                System.out.print("Efectivo recibido: Q");
                                efectivo = teclado.nextDouble();

                                if (efectivo < total) {
                                    System.out.println("\u001B[31mEl efectivo es insuficiente.\u001B[0m");
                                }

                            } while (efectivo < total);

                            cambio = efectivo - total;
                            ventasEfectivo++;
                            break;

                        case 2:
                            ventasTarjeta++;
                            break;

                        case 3:
                            ventasTransferencia++;
                            break;
                    }

                    ventas++;
                    productosVendidos = productosVendidos + cantidadVenta;
                    totalVendido = totalVendido + total;

                    if (ventas == 1) {
                        ventaMayor = total;
                        ventaMenor = total;
                    } else {

                        if (total > ventaMayor) {
                            ventaMayor = total;
                        }

                        if (total < ventaMenor) {
                            ventaMenor = total;
                        }
                    }

                    System.out.println("\u001B[33m\n===== RESUMEN DE LA VENTA =====\u001B[0m");
                    System.out.println("Productos diferentes: " + numeroProductos);
                    System.out.println("Unidades vendidas: " + cantidadVenta);
                    System.out.println("Subtotal: Q" + subtotal);
                    System.out.println("Descuento: Q" + descuento);
                    System.out.println("IVA: Q" + iva);
                    System.out.println("Total: Q" + total);

                    switch (formaPago) {

                        case 1:
                            System.out.println("\u001B[32mForma de pago: Efectivo"
                                    + "\nexistosa\u001B[0m");
                            System.out.println("Efectivo recibido: Q" + efectivo);
                            System.out.println("Cambio: Q" + cambio);
                            break;

                        case 2:
                            System.out.println("\u001B[32mForma de pago: Tarjeta"
                                    + "\nexitosa\u001B[0m");
                            break;

                        case 3:
                            System.out.println("\u001B[32mForma de pago: Transferencia"
                                    + "\nexistosa\u001B[0m");
                            break;
                    }

                    break;
                }

                case 2:

                    System.out.println("\u001B[33m\n===== CONSULTA DE CAJA =====\u001B[0m");
                    System.out.println("Ventas realizadas: " + ventas);
                    System.out.println("Productos vendidos: " + productosVendidos);
                    System.out.println("Total vendido: Q" + totalVendido);
                    System.out.println("Ventas en efectivo: " + ventasEfectivo);
                    System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                    System.out.println("Ventas por transferencia: " + ventasTransferencia);

                    break;

                case 3:

                    System.out.println("\u001B[33m\n===== ESTADISTICAS =====\u001B[0m");

                    if (ventas == 0) {

                        System.out.println("\u001B[31mNo existen ventas registradas.\u001B[0m");

                    } else {

                        double promedio = totalVendido / ventas;

                        System.out.println("Numero total de ventas: " + ventas);
                        System.out.println("Productos vendidos: " + productosVendidos);
                        System.out.println("Total de dinero vendido: Q" + totalVendido);
                        System.out.println("Promedio por venta: Q" + promedio);
                        System.out.println("Ventas en efectivo: " + ventasEfectivo);
                        System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                        System.out.println("Ventas por transferencia: " + ventasTransferencia);
                        System.out.println("Venta de mayor valor: Q" + ventaMayor);
                        System.out.println("Venta de menor valor: Q" + ventaMenor);
                    }

                    break;

                case 4:

                    System.out.println("\u001B[32mDesea salir del programa?\u001B[0m");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.print("Seleccione una opcion: ");

                    int confirmar = teclado.nextInt();

                    while (confirmar < 1 || confirmar > 2) {
                        System.out.print("\u001B[31mIngrese 1 o 2: \u001B[0m");
                        confirmar = teclado.nextInt();
                    }

                    if (confirmar == 1) {
                        salir = true;
                    }

                    break;
            }

        } while (!salir);

        System.out.println("\u001B[32mPrograma Cerrado.\u001B[0m");
    }
}