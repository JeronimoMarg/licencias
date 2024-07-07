- Para crear la imagen:
```console
docker build -t mysql-licencias-configurado -f Dockerfile-mysql .
```

- Para ejecutar el contenedor:
```console
docker run -d -p 3306:3306 --name mysql-licencias-configurado mysql-licencias-configurado
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
