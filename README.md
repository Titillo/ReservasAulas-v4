# Tarea Reservas de Aulas
## Profesor: AndrÃ©s Rubio del RÃ­o
## Alumno: Fabricio Israel Conde Rojas

Desde el IES Al-�ndalus nos acaban de dar unos nuevos requisitos a aplicar sobre la �ltima versi�n que le mostramos y que les gust� bastante. Lo que nos piden es lo siguiente:

Quieren conservar la interfaz de texto de la aplicaci�n.
Quieren tambi�n tener una nueva interfaz de usuario gr�fica para ejecutar la aplicaci�n.
Tu tarea consiste en dotar a la aplicaci�n de la tarea anterior de una interfaz gr�fica de usuario, utilizando JavaFX. La interfaz se puede dise�ar al gusto de cada un@, pero deber� utilizar los componentes m�s adecuados en cada caso. Cuanto m�s elaborada est� mayor ser� la calificaci�n. Para ello debes emplear los diferentes tipos de controles, men�s y contenedores que nos proporciona la API de JavaFX. Se pide al menos:

Un men� que nos permita salir de la aplicaci�n, o acceder a las diferentes opciones sobre aulas, profesores y reservas.
La gesti�n de aulas permitir� a�adir una nueva, borrar una ya existente, mostrar todas las aulas, mostrar las reservas de un aula o consultar su disponibilidad.
La gesti�n de profesores permitir� a�adir uno nuevo, borrar uno ya existente y mostrar todos los profesores. Tambi�n permitir� mostrar las reservas de un profesor.
La gesti�n de reservas nos permitir� realizar una nueva reserva o anular una reserva dada. Tambi�n permitir� mostrar todas las reservas.
Por tanto, tu tarea va a consistir en completar los siguientes apartados:

Debes realizar un fork del repositorio de tu tarea anterior en otro nuevo llamado ReservasAulas-v4. Dicho repositorio lo clonar�s localmente y realizar�s las diferentes modificaciones que se piden en esta tarea.
Modifica el fichero de configuraci�n de gradle para que incluya las librer�as necesarias para poder trabajar correctamente con JavaFX. Crea un nuevo paquete para la vista gr�fica. En principio la ventana principal s�lo incluir� el men� adecuado. Cada fichero debe estar en la carpeta adecuada (bien sea un recurso -imagen o .fxml- o un fichero .java). Realiza el commit correspondiente.
Mueve la interfaz textual al paquete adecuado y renombra la aplicaci�n que utilizaba dicha interfaz textual. Realiza un commit.
Crea un nuevo paquete para la vista gr�fica. Crea una nueva aplicaci�n que haga uso de dicha interfaz gr�fica de usuario y que contenga el men� adecuado. Realiza un commit.
Realiza la gesti�n de aulas tal y como se indica anteriormente. Realiza un commit.
Realiza la gesti�n de profesores tal y como se indica anteriormente. Realiza un commit.
Realiza la gesti�n de reservas tal y como se indica anteriormente. Realiza un commit.
Al final debes tener dos aplicaciones que utilicen el mismo modelo, pero que una utilice la interfaz textual y otra la interfaz gr�fica. Realiza un commit y sube los cambios a tu repositorio remoto.
Se valorar�:

La nomenclatura del repositorio de GitHub y del archivo entregado sigue las indicaciones de entrega.
La indentaci�n debe ser correcta en cada uno de los apartados.
El nombre de las variables debe ser adecuado.
Se debe utilizar la clase Entrada para realizar la entrada por teclado.
El proyecto debe pasar todas las pruebas que van en el esqueleto del mismo y toda entrada del programa ser� validada para evitar que el programa termine abruptamente debido a una excepci�n.
Se deben utilizar los comentarios adecuados.
Se valorar� la correcci�n ortogr�fica tanto en los comentarios como en los mensajes que se muestren al usuario.