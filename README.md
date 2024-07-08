# Licencias
## Inicializar la base de datos
### Inicializar la base de datos utilizando Docker
El archivo `Dockerfile-mysql` permite crear una imagen Docker con el programa mysql
configurado con el esquema, modelo y los datos iniciales para utilizar la aplicacion.
Este paso requiere que un servicio Docker se encuentre ejecutando en el equipo.

- El directorio debe ser el del proyecto
```console
cd licencias
```

- Para crear la imagen:
```console
docker build -t mysql-licencias-configurado -f Dockerfile-mysql .
```

- Para ejecutar el contenedor:
```console
docker run -d -p 3307:3306 --name mysql-licencias-configurado mysql-licencias-configurado
```

- Para eliminar el contenedor y empezar de nuevo
```
docker stop mysql-licencias-configurado   # Detiene el contenedor
docker rm mysql-licencias-configurado     # Elimina el contenedor
```

- Para verificar que ande
```console
docker exec -it mysql-licencias-configurado mysql -uroot -p
```

- IMPORTANTE
En el application properties cambiar el nombre de user a 'usuario' y la password a 'root'
Ademas, escuchar en el puerto 3307

### Inicializar la base de datos con una instancia local de MySQL
Es necesario que MySQL este instalado en el mismo equipo donde se ejecuta la aplicacion.

- Conexion a la base de datos:
Debe modificarse el puerto al correspondiente, segun el que escuche MySQL en
la instancia local, por lo general, el puerto 3306. Para esto se debe modificar
el archivo "application.properties" en el directorio donde se encuentra el ejecutable
o en main/resources (en este caso sera necesario volver a compilar).
```console
spring.datasource.url = jdbc:mysql://127.0.0.1:<puerto>/metodosagiles
```
- Inicializacion del esquema
Debe importarse el archivo `01_schema.sql`
- Inicializacion del modelo
Debe importarse el archivo `02_tablas.sql`
- Carga de datos: estos datos son necesarios para el correcto funcionamiento de la aplicacion
Debe importarse el archivo `03_data.sql`
- Carga de tablas de secuencia
Debe importarse el archivo `04_seq.sql`
