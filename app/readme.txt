1. Contenido:
	- Ejecutable: PronosticoFutbol.jar
	- Red bayesiana: redFutbol.xdsl		(no renombrar)
	- Biblioteca jSMILE: smile.jar		(no renombrar)
	- Bibliotecas propias jSMILE del sistema operativo:
    	+ Windows
    	+ Linux
    	+ Linux 64 bits
    	+ MacOS X
    	* código fuente

2. Instalación:

Para poder ejecutar correctamente el programa es necesario que los ficheros
PronosticoFutbol.jar, redFutbol.xdsl y smile.jar estén en la misma carpeta, y no
cambiarles el nombre.

Además, se debe tener instalada la máquina virtual de Java.

Por último es imprescindible colocar la biblioteca propia del sistema operativo en
el ClassPath de java; así evitaremos el error: "no jsmile in java.library.path".
Todas las bibliotecas están en la carpeta BibliotecasJSMILE.

* Windows:
	Copiar el archivo smile.dll en una carpeta y añadir la biblioteca al path.
	Para añadirla al path hay que seguir la siguiente secuencia de pasos:
	(suponiendo que la hemos copiado en C:/lib/win32)
	1. Picar con el botón derecho sobre MiPC y en Propiedades, y a continuación seleccionar la pestaña Opciones avanzadas.
	2. Seleccionar el botón Variables de entorno. En la sección de variables del sistema seleccionar la variable Path.
	3. Pulsando sobre el botón modificar pasamos a introducir la ruta del directorio donde se encuentra smile.dll, en nuestro caso C:/lib/win32. Finalmente pulsar en aceptar.

* Linux:
 	Copiar el fichero libjsmile.so en la ruta: /usr/lib/jvm/java-6-sun-VERSION/jre/lib/ARQUITECTURA/

	donde VERSION es la versión de java instalada, por ejemplo 1.6.0.20
	y ARQUITECTURA es la arquitectura del ordenador (i386, amd64, ...).		

* MacOSX:

	Copiar el fichero libjsmile.jnilib a la carpeta /Sistema/Librería/Frameworks/JavaVM.framework/Versions/1.6.0/Libraries
	
3. Ejecución:

Doble clic sobre PronosticoFutbol.jar o bien mediante línea de comandos con la instrucción:
java -jar PronosticoFutbol.jar
