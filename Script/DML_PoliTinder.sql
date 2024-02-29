-- database: ../database/POLITINDER.sqlite

/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|isabellahq29@gmail.com       lalabell |
|______________________________________|
Autor: lalabell
Fecha: 16/02/1014
Script: Ingreso de datos en la tabla Regalo
        Ingreso de datos en la tabla RegaloTipo
        Ingreso de datos en la tabla RegaloEnvio
        Ingreso de datos en la tabla Persona
        Ingreso de datos en la tabla PersonaRol
        Ingreso de datos en la tabla PersonaSexo
        Ingreso de datos en la tabla Relacion
        Ingreso de datos en la tabla RelacionTipo
        Ingreso de datos en la tabla Cita
*/


INSERT INTO RegaloTipo
    (Nombre,Observacion) 
VALUES 
    ("VIRTUAL","Regalo Virtual para pruebas") 
    ,("PRESENCIAL","Regalo Presencial para pruebas");

INSERT INTO PersonaSexo 
    (Nombre)
VALUES 
    ("MASCULINO")
    ,("FEMENINO")
    ,("BINARIO") 
    ,("FLUIDO");

INSERT INTO PersonaRol 
    (IdPersonaRolPadre, Nombre)
VALUES 
    (NULL, "ADMINISTRADOR APP")
    ,(1, "USUARIO") 
    ,(NULL, "ADMIN")
    ,(3, "MENSAJERO");

INSERT INTO RelacionTipo
    (Nombre)
VALUES
    ('AMIGOS')
    ,('FAMILIA')
    ,('TRABAJO')
    ,('LIGUE')
    ,('PAREJA')
    ,('AMANTE')
    ,('ESPOS@');

 INSERT INTO Persona
    (IdPersonaRol, IdPersonaSexo, Nombre)
VALUES
    (1,1, 'Conan')   -- USUARIO ADMIN
    ,(3,2, 'Olivia')
    ,(4,1, 'Adrien Agreste')
    ,(4,1, 'Peter Parker')
    ,(4,1, 'Kanye West')
    ,(4,2, 'Taylor Swift')
    ,(2,1, 'Light Yagami')
    ,(2, 1, 'Gojo Satoru')
    ,(2,1, 'Geto Suguru')
    ,(2,2, 'Rouge')
    ,(2,1, 'Roger')
    ,(2,2, 'Camila')
    ,(2,1, 'Shawn')
    ,(2,1, 'Chayanne' )
    ,(2,2, 'Las mamás')
    ,(2,1, 'Ash')
    ,(2,1, 'Eiji')
    ,(2,2, 'Yo')
    ,(2,1, 'Chrollo')
    ,(2,1, 'Chat noir')
    ,(2,2, 'Ladybug')
    ,(2,2, 'Sana')
    ,(2,2, 'Tzuyu')
    ,(2,1, 'Nanami')
    ,(2,1, 'Joji')
    ,(2,1, 'Kuroko')
    ,(2,1, 'Aomine')
    ,(2,2, 'Lisa')
    ,(2,2, 'Jennie')
    ,(2,4, 'Gege vas a caer')
    ,(2,3, 'Sukuna');


INSERT INTO Regalo
    (IdRegaloTipo, Nombre, Stock, Precio)
VALUES
    (1, 'Poema', -1, 1.99)
    ,(1, 'Tarjeta', -1, 1.99)
    ,(1, 'Tarjeta de regalo te quiero', -1, 15)
    ,(1, 'Tarjeta de regalo te amo', -1, 50)
    ,(1, 'Tarjeta de regalo casate conmigo', -1, 100)
    ,(1, 'Tarjeta de regalo toda la vida juntos', -1, 1000)
    ,(2, 'Peluche Osito', 50, 7.99)
    ,(2, 'Peluche gatito', 50, 7.99)
    ,(2, 'Chocolates feastable', 1500, 2)
    ,(2, 'Bombones', 35, 4.50)
    ,(2, 'Rosas (Docena)', 80, 10)
    ,(2, 'Tulipanes (Docena)', 80, 15)
    ,(2, 'girasoles (Docena)', 80, 20)
    ,(2, 'Cupcakes Chocolate (Media docena)', 25, 9)
    ,(2, 'Cupcakes Vainilla (Media docena)', 25, 9)
    ,(2, 'Cupcakes Red Velvet (Media docena)', 25, 9);

INSERT INTO Cita
(IdPersona1, IdPersona2, FechaCita)
VALUES
(8,9, 'now' );

WITH RECURSIVE
  contador(x) AS (SELECT 1 UNION ALL SELECT x+1 FROM contador LIMIT 300
  )
INSERT INTO Relacion (IdRelacion, IdRelacionTipo, IdPersona1, IdPersona2) 

SELECT 
x AS id
, abs(random()) % (7 - 1) + 1 
, abs(random()) % (31 - 7) + 1
, abs(random()) % (31 - 7) + 1  FROM contador;

WITH RECURSIVE
  contadordos(x) AS (SELECT 1 UNION ALL SELECT x+1 FROM contadordos LIMIT 1000
  )
INSERT INTO RegaloEnvio (IdRegaloEnvio, IdRegalo, IdPersonaEnvia, IdPersonaRecibe, FechaEnvio)
SELECT 
x 
, abs(random()) % (16 - 1) + 1 
, abs(random()) % (31 - 7) + 1 
, abs(random()) % (31 - 7) + 1 
, datetime(strftime('%s', '2024-02-16 00:00:00') +
                abs(random() % (strftime('%s', '2026-12-31 23:59:59') -
                                strftime('%s', '2024-01-16 00:00:00'))
                   ),
                'unixepoch')  from contadordos;


