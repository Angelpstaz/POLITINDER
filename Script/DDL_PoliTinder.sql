-- database: ../database/POLITINDER.sqlite

/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|isabellahq29@gmail.com       lalabell |
|______________________________________|
Autor: lalabell
Fecha: 16/02/1014
Script: Creación de la tabla Regalo
        Creación de la tabla RegaloTipo
        Creación de la tabla RegaloEnvio
        Creación de la tabla Persona
        Creación de la tabla PersonaRol
        Creación de la tabla PersonaSexo
        Creación de la tabla Relacion
        Creación de la tabla RelacionTipo
        Creación de la tabla Cita
*/


DROP TABLE If EXISTS Regalo;
DROP TABLE IF EXISTS RegaloTipo;
DROP TABLE IF EXISTS RegaloEnvio;
DROP TABLE IF EXISTS PersonaRol;
DROP TABLE IF EXISTS PersonaSexo;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS RelacionTipo;
DROP TABLE IF EXISTS Relacion;
DROP TABLE IF EXISTS Cita;


--Catalogo
CREATE TABLE RegaloTipo(
        IdRegaloTipo    INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre         TEXT  NOT NULL UNIQUE
        ,Observacion    TEXT
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica  DATETIME

);

CREATE TABLE PersonaRol(
        IdPersonaRol INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersonaRolPadre INTEGER  REFERENCES PersonaRol (IdPersonaRol)
        ,Nombre TEXT  NOT NULL UNIQUE
        ,Observacion TEXT
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica DATE

);

CREATE TABLE PersonaSexo(
        IdPersonaSexo    INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre         TEXT  NOT NULL UNIQUE
        ,Observacion    TEXT
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica  DATE

);

CREATE TABLE Persona(
        IdPersona    INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersonaRol INTEGER NOT NULL REFERENCES PersonaRol(IdPersonaRol)
        ,IdPersonaSexo    INTEGER REFERENCES PersonaSexo(IdPersonaSexo)
        ,Nombre         TEXT  NOT NULL UNIQUE
        ,Observacion    TEXT
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica  DATE

);

CREATE TABLE Regalo(
        IdRegalo        INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdRegaloTipo   INTEGER NOT NULL REFERENCES RegaloTipo(IdRegaloTipo)
        ,Nombre         TEXT  NOT NULL UNIQUE
        ,Observacion    TEXT
        ,Precio         REAL NOT NULL CHECK (Precio >= 0)
        ,Stock          INT NOT NULL
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica  DATE

);

CREATE TABLE RelacionTipo(
        IdRelacionTipo  INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre         TEXT  NOT NULL UNIQUE
        ,Observacion    TEXT
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica  DATE
);

CREATE TABLE Relacion(
        IdRelacion              INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdRelacionTipo         INTEGER  NOT NULL REFERENCES RelacionTipo(IdRelacionTipo)
        ,IdPersona1             INTEGER  NOT NULL REFERENCES Persona(IdPersona)
        ,IdPersona2             INTEGER  NOT NULL REFERENCES Persona(IdPersona)
        ,Observacion            TEXT
        ,FechaInicioRelacion    DATE NOT NULL DEFAULT (datetime('now'))
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);

CREATE TABLE Cita(
        IdCita                 INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersona1            INTEGER NOT NULL REFERENCES Persona(IdPersona)
        ,IdPersona2            INTEGER NOT NULL REFERENCES Persona(IdPersona)
        ,FechaCita             DATE NOT NULL
        ,FechaCrea      DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);

CREATE TABLE RegaloEnvio(
        IdRegaloEnvio            INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdRegalo                INTEGER   NOT NULL REFERENCES Regalo(IdRegalo)
        ,IdPersonaEnvia          INTEGER   NOT NULL REFERENCES Persona(IdPersona)
        ,IdPersonaRecibe         INTEGER   NOT NULL REFERENCES Persona(IdPersona)
        ,Observacion             TEXT
        ,FechaCrea               DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaEnvio              DATE NOT NULL
        ,FechaModifica           DATE



)