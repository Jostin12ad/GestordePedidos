Evaluación Unidad 3 – Patrones de Diseño
Asignatura: Patrones de Diseño
Profesor: Giovanni Caceres
Total: 70 puntos → Nota 7,0

🎯 Objetivo General
Desarrollar un proyecto en Java libre que integre de forma práctica patrones de diseño GoF, aplicándolos en una solución funcional, con justificación técnica clara y una defensa oral argumentada.

Gestor de pedidos
Descripcion del sistema a resolver

Este sistema consiste en una gestion de pedidos y entregas, su proposito es permitir a un operador registrar pedidos nacionales o internacionales, validar la informacion, enviarlos a su destino y mantener un historial para consultarlo

El programa se ejecuta por consola e incluye un menu interactivo con las siguientes funcionalidades:

1: ingresar nuevo pedido, 2: ver historial de pedidos registrados, 3: salir

En este sistema se encuentran 4 patrones de diseño: Patron creacional, Patron estructural, Patron de comportamiento, patron iterativo

Patron creacional
¿Porque lo uso?
Se necesita pedidos de 2 tipos (Nacional o internacional), sin que el archivo MAIN dependa de clases concretas, asi se puede extender el sistema facilmente agregando nuevos tipos de pedidos 
¿Como se implementa?

Se define en la interfaz de PedidoFactory con el metodo crearPedido() y luego se implementa, NacionalPedidoFactory, InternacionalPedidoFactory y se utiliza cuando el usuario elige el tipo de pedido si es nacional o internacional
