Evaluación Unidad 3 – Patrones de Diseño
Asignatura: Patrones de Diseño
Profesor: Giovanni Caceres
Total: 70 puntos → Nota 7,0

🎯 Objetivo General
Desarrollar un proyecto en Java libre que integre de forma práctica patrones de diseño GoF, aplicándolos en una solución funcional, con justificación técnica clara y una defensa oral argumentada.

Gestor de pedidos
Descripción del sistema y problema a resolver.

Este sistema consiste en una gestion de pedidos y entregas, su proposito es permitir a un operador registrar pedidos nacionales o internacionales, validar la informacion, enviarlos a su destino y mantener un historial para consultarlo

En muchas empresas que gestionan ventas y entregas de productos, uno de los desafios comunes es contar con un sistema que pueda registrar pedidos, valide con logica cada pedido, simule la entrega a su destino, permita ver el historial consultable de pedidos realizados, por eso el sistema utiliza patrones de diseño para aplicar buenas practicas que abordan estas necesidades

El programa se ejecuta por consola e incluye un menu interactivo con las siguientes funcionalidades:

1: ingresar nuevo pedido, 2: ver historial de pedidos registrados, 3: salir

En este sistema se encuentran 4 patrones de diseño: Patron creacional, Patron estructural, Patron de comportamiento, patron iterativo

Patron creacional
¿Porque lo uso?
Este patron se utiliza para encapsular la creacion de objetos complejos sin especificar sus clases, en este caso necesitamos permitir la creacion de distintos pedidos (Nacional o Internacional) esto permite agregar nuevos tipos de pedidos en el futuro sin necesidad de modificar el flujo principal 
¿Como se implementa?

Se define en la interfaz de PedidoFactory con el metodo crearPedido() y luego se implementa, NacionalPedidoFactory, InternacionalPedidoFactory y se utiliza cuando el usuario elige el tipo de pedido si es nacional o internacional

Cada uno vuelve un objeto pedido, pero el codigo que las usa no necesita saber donde es exactamente

El usuario escoge el tipo de pedido, luego, segun esa eleccion, se crea la instancia concreta mediante una fabrica adecuada nuestro main no sabe si esta ocupando pedido nacional o internacional directamente




Patron Estructural

¿Porque se usa?
Se implementa para interceptar el acceso a un servicio real (En este caso el envio del pedido), tambien sirve para simular un comportamiento externo de un sistema externo puede ser una API 

¿Como se implementa?

Se crea la interfaz ServicioEnvio con el metodo Enviar(String destino)

ServicioEnvioReal implementa el comportamiento real de envio
ServicioEnvioProxy Contiene la misma interfaz, pero actúa como intermediario
Puede imprimir mensajes, validar si el destino es valido etc

¿Donde se usa? 
en el mismo metodo de Main despues de que el usuario ingrese la direccion
El sistema no interactua directamente , si no lo que hace a travez del proxy, que puede controlar o modificar el envio



Patron de comportamiento

¿Porque se usa?
Este patron permite encadenar multiples objetos para procesar una solicitud paso a paso, se utiliza cuando se necesita realizar validaciones o acciones ordenadas
Antes de procesar cualquier pedido necesitamos que el Stock sea suficiente, la direccion este bien ingresada

¿como se implementa?

En  la clase Validador, que define validar y establecerSiguiente

contiene subclases que son ValidarStock, ValidarDireccion, ValidarPago

¿Donde se usa?

En main despues de procesar el pedido
Asi se encadena el flujo de validacion, de forma flexible y puedes agregar mas validadores con una sola linea de codigo en un futuro si es requerido



Patron iterator (Eleccion)

¿Porque se usa?
Se utiliza este patron para recorrer una coleccion sin exponer la estructura interna, esto permite abstraer la forma en que se almacenan los pedidos (Ejemplo ArrayList), ademas mejora la claridad al acceder al historial de forma controlada y ordenada


¿Como se implementa? 

En la clase HistorialPedidos contiene una coleccion (Por ejemplo un List pedido)
Define un metodo crearIterator que nos devuelve un objeto PedidoIterator
En la clase PedidoIterator implementa los metodos Hasnext y next esto es para recorrer los pedidos uno en uno 

¿Donde se usa?


Cuando el ususario elije la opcion 2 del menu (Ver historial de pedidos)

De esta manera, el sistema recorre los pedidos de forma limpia y desacoplada, no accede directamente al Arraylist lo que lo hace mas estable


























