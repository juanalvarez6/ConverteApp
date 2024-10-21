# ConverteApp

El siguiente programa es un convertidor de moneda, en el cual tenemos seis opciones para escoger.

El programa obtiene la tasa de cambio desde la API [ExchangeRate-API](https://www.exchangerate-api.com/).

## **Clases**

### **ConverterData**

![img_1.png](img_1.png)

Es el Record encargado de almacenar el dato del valor de la moneda.

### **QueryConverter**

![img_3.png](img_3.png)

Esta clase es la encargada de hacer la consulta en la API sobre la tasa de cambio de la moneda **baseCode** a la moneda **targetCode**, guardando el resultado en el Record **ConverterData**.

### **Menu**

![img_4.png](img_4.png)
![img_5.png](img_5.png)

Esta clase es la encargada de mostrar las opciones del cambio de moneda al usuario.

#### **Metodo ask**

![img_6.png](img_6.png)

Este metodo es el encargado de hacer el cambio de monedas dependiendo de la opcion que escoge el usuario.

### **Ejemplo de Funcionamiento**

![img_7.png](img_7.png)

Al correr el programa este muestra el anterior menu que nos permite realizar los cambio de moneda en la opciones, hasta que decidimos salir del programa.
