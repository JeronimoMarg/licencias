- Para crear la imagen:
```console
sudo docker build -t mysql-licencias-configurado -f Dockerfile-mysql .
```

- Para ejecutar el contenedor:
```console
sudo docker run --name mysql-lic -p 3306:3306 -d mysql-licencias-configurado
```