--Me conecto a la base de datos a usar
USE testPokedexDB
GO

PRINT('Eliminacion de Schema anterior si es que existia') 
IF EXISTS (SELECT * FROM SYS.SCHEMAS WHERE name = 'pokedexSchema')
BEGIN
	DECLARE @Sql NVARCHAR(MAX) = '';

-------------------------------------
--		ELIMINACION DE CONSTRAINTS
-------------------------------------
PRINT('Eliminacion de Constraints anteriores') 
	SELECT @Sql = @Sql + 'ALTER TABLE ' + QUOTENAME('pokedexSchema') + '.' + QUOTENAME(t.name) + ' DROP CONSTRAINT ' 
																		+ QUOTENAME(f.name)  + ';' + CHAR(13)
	FROM SYS.TABLES t 
	INNER JOIN SYS.FOREIGN_KEYS f ON f.parent_object_id = t.object_id 
	INNER JOIN SYS.SCHEMAS s ON t.SCHEMA_ID = s.SCHEMA_ID
	WHERE s.name = 'pokedexSchema'
	ORDER BY t.name;
	PRINT @Sql
	EXEC  (@Sql)
	PRINT('Eliminacion HECHA') 
	/*
	*/
-------------------------------------
--		ELIMINACION DE TABLAS
-------------------------------------
PRINT('Eliminacion de tablas existentes') 
	DECLARE @SqlStatement NVARCHAR(MAX)
	SELECT @SqlStatement = COALESCE(@SqlStatement, N'') + N'DROP TABLE [pokedexSchema].' + QUOTENAME(TABLE_NAME) + N';' + CHAR(13)
	FROM INFORMATION_SCHEMA.TABLES
	WHERE TABLE_SCHEMA = 'pokedexSchema' AND TABLE_TYPE = 'BASE TABLE'
	PRINT @SqlStatement
	EXEC  (@SqlStatement)
	--DROP SCHEMA SQLEADOS
END
GO

PRINT('Creando Schema pokedexSchema') 
IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'pokedexSchema')
BEGIN
    EXEC ('CREATE SCHEMA pokedexSchema')
END
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Habilidad_x_pokemones'))
	DROP TABLE pokedexSchema.Habilidad_x_pokemones

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Pokemon_x_users'))
	DROP TABLE pokedexSchema.Pokemon_x_users

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Tipos_x_pokemones'))
	DROP TABLE pokedexSchema.Tipos_x_pokemones

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Evolucion_Pokemones'))
	DROP TABLE pokedexSchema.Evolucion_Pokemones

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.User_Pokemon'))
	DROP TABLE pokedexSchema.User_Pokemon

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Pokemones'))
	DROP TABLE pokedexSchema.Pokemones

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Habilidades'))
	DROP TABLE pokedexSchema.Habilidades
	
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.Tipos'))
	DROP TABLE pokedexSchema.Tipos

	PRINT('Si existian tablas de este esquema ahora fueron eliminadas')
	
----------------------------------------------------------------------------------------------
								/** CREACION DE SCHEMA **/
----------------------------------------------------------------------------------------------

PRINT('Creacion hecha')

CREATE TABLE [pokedexSchema].User_Pokemon(
usuario_id integer primary key identity,
usuario_nombre varchar(30) not null
)



CREATE TABLE [pokedexSchema].Habilidades(
hab_id integer primary key identity,
hab_nombre varchar(30) not null
)

CREATE TABLE [pokedexSchema].Tipos(
tipo_id integer primary key identity,
tipo_nombre varchar(30) not null
)

CREATE TABLE [pokedexSchema].Pokemones (
pok_id integer primary key identity,
pok_name varchar(30) unique not null,
)

CREATE TABLE [pokedexSchema].Evolucion_Pokemones(
evol_pok_pokemonID integer not null,
evol_pok_siguiente_evolucion integer not null,
evol_pok_nivel_requerido integer check (evol_pok_nivel_requerido>0),
CONSTRAINT FK_evol_pok_pokemonID FOREIGN KEY (evol_pok_pokemonID) REFERENCES [pokedexSchema].Pokemones (pok_id),
CONSTRAINT FK_evol_pok_siguiente_evolucion FOREIGN KEY (evol_pok_siguiente_evolucion) REFERENCES [pokedexSchema].Pokemones (pok_id),
)

CREATE TABLE [pokedexSchema].Tipos_x_pokemones(
tipo_x_pok_pokemonID integer not null,
tipo_x_pok_tipoID integer not null,
PRIMARY KEY(tipo_x_pok_pokemonID, tipo_x_pok_tipoID),
CONSTRAINT FK_tipo_x_pok_pokemonID FOREIGN KEY (tipo_x_pok_pokemonID) REFERENCES [pokedexSchema].Pokemones (pok_id),
CONSTRAINT FK_tipo_x_pok_tipoID FOREIGN KEY (tipo_x_pok_tipoID) REFERENCES [pokedexSchema].Tipos (tipo_id)
)

CREATE TABLE [pokedexSchema].Pokemon_x_users(
pok_x_user_ID integer PRIMARY KEY identity,
pok_x_user_userID integer not null,
pok_x_user_pokemonID integer not null,
pok_x_user_nivel integer check (pok_x_user_nivel>0),
CONSTRAINT FK_pok_x_user_userID FOREIGN KEY (pok_x_user_userID) REFERENCES [pokedexSchema].User_Pokemon (usuario_id),
CONSTRAINT FK_pok_x_user_pokemonID FOREIGN KEY (pok_x_user_pokemonID) REFERENCES [pokedexSchema].Pokemones (pok_id)
)

CREATE TABLE [pokedexSchema].Habilidad_x_pokemones(
hab_x_pok_pokemon_de_user_id integer not null,
hab_X_pok_habilidad_id integer not null,
CONSTRAINT FK_hab_x_pok_pokemon_de_user_id FOREIGN KEY (hab_x_pok_pokemon_de_user_id) REFERENCES [pokedexSchema].Pokemones (pok_id),
CONSTRAINT FK_hab_X_pok_habilidad_id FOREIGN KEY (hab_X_pok_habilidad_id) REFERENCES [pokedexSchema].Habilidades (hab_id)
)

INSERT INTO [pokedexSchema].Tipos(tipo_nombre) VALUES 
('Planta'), --0
('Veneno'), ('Fuego'), ('Volador'),--3
('Agua'), ('Bicho'), ('Normal'),--6
('Eléctrico'), ('Tierra'), ('Hada'),--9
('Lucha'), ('Psíquico'), ('Roca'),--12
('Hielo'), ('Fantasma'), ('Dragón'),--15
('Acero'), ('Siniestro');--17


INSERT INTO [pokedexSchema].Pokemones(pok_name) VALUES
('Bulbasur'), ('Ivysaur'), ('Venusaur'), 
('Charmander'), ('Charmeleon'), ('Charizard'),
('Squirtle'), ('Wartotle'), ('Blastoise'), 
('Caterpie'), ('Metapod'), ('Butterfree'), 
('Rattata'), ('Raticate'),
('Pidgey'), ('Pidgeotto'), ('Pidgeot'),
('Pikachu'), ('Raichu'), 
('Sandshrew'), ('Sandslash'),
('Zubat'), ('Golbat'),
('Mankey'), ('Primeape'),
('Seel'), ('Dewgong'),
('Gastly'), ('Haunter'), ('Gengar'),
('Dratini'), ('Dragonair'), ('Dragonite');



INSERT INTO [pokedexSchema].Habilidades(hab_nombre) VALUES
('Golpe'), ('Impactrueno'), ('Cabesazo'), ('Latigazo'), ('Mordida'),
('Endurecer'), ('Llamarada'), ('Hidrochorro'), ('Corte'),  ('Carga'), ('Burbuja'), ('Fuerza'), ('Picadura'), ('Terror');

INSERT INTO [pokedexSchema].User_Pokemon(usuario_nombre) VALUES
('Maestro'), ('Chico');

INSERT INTO [pokedexSchema].Evolucion_Pokemones(evol_pok_pokemonID, evol_pok_siguiente_evolucion, evol_pok_nivel_requerido) VALUES
(1,2,20), (2,3,45), 
(4,5,20), (5,6,50), 
(7,8,20), (8,9,50), 
(10,11,15), (11,12,35), 
(13,14,32),
(15,16,15), (16,17,40),
(18,19,35), 
(20,21,28), 
(22,23,28),
(24,25,42), 
(26, 27, 35),
(28,29,22), (29,30,48), 
(31,32,35), (32,33,65);  

INSERT INTO [pokedexSchema].Pokemon_x_users(pok_x_user_userID, pok_x_user_pokemonID, pok_x_user_nivel) VALUES
(1, 25, 50), (1, 30, 55), (1, 17, 60), (1, 3, 50), (1, 11, 30),
(2, 1, 32), (2, 7, 20), (2, 6, 54), (2, 18, 45), 
(2, 11, 30), (2, 33, 70);

INSERT INTO [pokedexSchema].Tipos_x_pokemones(tipo_x_pok_pokemonID, tipo_x_pok_tipoID) VALUES 
(1,1), (1,2), (2,1), (2,2), (3,1), (3,2),
(4,3),(5,3), (6,3), (6,4),
(7,5), (8,5), (9,5),
(10,6), (11,6), (12,6), (12,4),
(13,7), (14,7),
(15,7), (15,4), (16,7), (16,4), (17,7), (17,4),
(18,8), (19,8), 
(20,9), (21,9), 
(22,4), (22,2), (23,4), (23,2), 
(24,11), (25,11), 
(26,5), (27,5), (27,14), 
(28,2), (28,15), (29,2), (29,15), (30,2), (30,15), 
(31,16), (32,16), (33,16), (33,4); 

INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_x_pok_pokemon_de_user_id, hab_X_pok_habilidad_id)
SELECT 11, h.hab_id FROM [pokedexSchema].Habilidades h
-- DRAGON POLENTA (DRAGONITE) TIENE TODAS LAS HABILIDADES

INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_x_pok_pokemon_de_user_id, hab_X_pok_habilidad_id)
SELECT p.pok_x_user_ID, 1 FROM [pokedexSchema].Pokemon_x_users p where p.pok_x_user_ID!=10 AND p.pok_x_user_ID!=5 AND p.pok_x_user_ID!=11
-- TODOS TENDRAN GOLPE POR DEFAUTL MENOS METAPOID PORQUE NO HACE NADA

INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_x_pok_pokemon_de_user_id, hab_X_pok_habilidad_id)
SELECT p.pok_x_user_ID, 3 FROM [pokedexSchema].Pokemon_x_users p where p.pok_x_user_ID!=10 AND p.pok_x_user_ID!=5 AND p.pok_x_user_ID!=11
-- TODOS TENDRAN CABEZASO POR DEFAUTL MENOS METAPOID PORQUE NO HACE NADA

INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_x_pok_pokemon_de_user_id, hab_X_pok_habilidad_id)
SELECT p.pok_x_user_ID, 5 FROM [pokedexSchema].Pokemon_x_users p where p.pok_x_user_ID!=10 AND p.pok_x_user_ID!=5 AND p.pok_x_user_ID!=11
-- TODOS TENDRAN MORDIDA POR DEFAUTL MENOS METAPOID PORQUE NO HACE NADA

INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_x_pok_pokemon_de_user_id, hab_X_pok_habilidad_id) VALUES
(10, 6), (4, 4), (2, 14), (1, 8), (1, 11), (1, 10), (8, 7), (8, 9), (8, 11), (9, 2), (9, 10);

PRINT('Se ha creado e insertado datos iniciales con éxito')

/*
--ME DA LOS DATOS QUE TIENE 1 USUARIO SOBRE SUS POKEMON
SELECT p.pok_name, pu.pok_x_user_nivel FROM [pokedexSchema].Pokemones p
	JOIN [pokedexSchema].Pokemon_x_users pu ON pu.pok_x_user_pokemonID = p.pok_id 
	JOIN [pokedexSchema].User_Pokemon u ON u.usuario_id = pu.pok_x_user_userID AND u.usuario_id=1
							ORDER BY p.pok_id asc

--ME DA TODAS EL NOMBRE DE LAS HABILIDADES QUE POSEE 1 POKEMON DE UN USUARIO
SELECT u.hab_id, u.hab_nombre FROM [pokedexSchema].Pokemon_x_users p
	JOIN [pokedexSchema].Habilidad_x_pokemones pu ON pu.hab_x_pok_pokemon_de_user_id = p.pok_x_user_ID
							AND pu.hab_X_pok_habilidad_id=1
	JOIN [pokedexSchema].Habilidades u ON u.hab_id = pu.hab_X_pok_habilidad_id
							ORDER BY u.hab_id asc

--ME DA LA INFO DE TODOS LOS USUARIOS QUE EXISTEN
SELECT u.usuario_id, u.usuario_nombre FROM [pokedexSchema].User_Pokemon u

--ME DA LA INFO SOBRE TODOS LOS TIPOS QUE EXISTEN
SELECT t.tipo_id, t.tipo_nombre FROM [pokedexSchema].Tipos t

--ME DA LA INFO SOBRE TODOS LOS TIPOS QUE EXISTEN EN UN POKEMON EN PARTICULAR
SELECT t.tipo_id, t.tipo_nombre FROM [pokedexSchema].Tipos t
	JOIN [pokedexSchema].Tipos_x_pokemones tt ON tt.tipo_x_pok_tipoID=t.tipo_id
	JOIN [pokedexSchema].Pokemones p ON p.pok_id=tt.tipo_x_pok_pokemonID
				AND p.pok_id=1

--ME DA INFO SOBRE TODO SLOS POKEMONS QUE EXISNTE
SELECT p.pok_id, p.pok_name FROM [pokedexSchema].Pokemones p

SELECT tipo_id, tipo_nombre FROM [pokedexSchema].Tipos
SELECT hab_id, hab_nombre FROM [pokedexSchema].Habilidades
SELECT u.usuario_id, u.usuario_nombre FROM [pokedexSchema].User_Pokemon u
*/
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[ObtenerTodosLosTiposDe1Pokemon]'))
    DROP function ObtenerTodosLosTiposDe1Pokemon
GO
/*
SELECT CASE WHEN COUNT(*)>0 THEN '1' ELSE '0' END FROM [pokedexSchema].Pokemones u WHERE pok_name LIKE 'ASD'

INSERT INTO [pokedexSchema].Pokemones(pok_name) VALUES ()

SELECT TOP 1 p.pok_id FROM [pokedexSchema].Pokemones p ORDER BY 1 DESC
SELECT p.pok_id, p.pok_name, ObtenerTodosLosTiposDe1Pokemon(p.pol_id) FROM [pokedexSchema].Pokemones p

SELECT p.tipo_x_pok_pokemonID, p.tipo_x_pok_tipoID, tt.tipo_nombre FROM [pokedexSchema].Tipos_x_pokemones P
				JOIN [pokedexSchema].Tipos tt ON tt.tipo_id=p.tipo_x_pok_tipoID
				WHERE p.tipo_x_pok_pokemonID IN 
					(SELECT TOP 1 pok_id FROM [pokedexSchema].Pokemones order by 1 desc)

SELECT p.pok_name FROM [pokedexSchema].Pokemon_x_users u JOIN [pokedexSchema].Pokemones p
		ON p.pok_id = u.pok_x_user_pokemonID WHERE u.pok_x_user_userID=1
		*/
CREATE FUNCTION ObtenerTodosLosTiposDe1Pokemon(@idpok integer) RETURNS NVARCHAR(1000)
AS
BEGIN
   DECLARE @string NVARCHAR(256)
   SET @string=''
   DECLARE @cadena nvarchar(30)
   Declare @c as CURSOR
	set @c =CURSOR FOR  SELECT t.tipo_nombre FROM [pokedexSchema].Tipos_x_pokemones
			JOIN [pokedexSchema].Tipos t ON t.tipo_id=tipo_x_pok_tipoID 
			WHERE tipo_x_pok_pokemonID=@idPok
   OPEN @c 
   FETCH NEXT FROM @c INTO @cadena
	WHILE @@FETCH_STATUS = 0
		BEGIN
		SET @string= @string+@cadena+','
		FETCH NEXT FROM @c INTO @cadena;
		END
   CLOSE @c
   DEALLOCATE @c
   RETURN @string
END
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[tri_aniadir_pokemon_a_user]'))
    DROP trigger tri_aniadir_pokemon_a_user
GO

CREATE TRIGGER tri_aniadir_pokemon_a_user ON [pokedexSchema].Pokemon_x_users
AFTER INSERT AS
BEGIN
	declare @id integer
	declare @id_habilidad_golpe integer
	SELECT @id=i.pok_x_user_ID FROM inserted i
	SELECT @id_habilidad_golpe=h.hab_id FROM [pokedexSchema].Habilidades h WHERE h.hab_nombre LIKE 'Golpe'
	INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_X_pok_habilidad_id, hab_x_pok_pokemon_de_user_id)
		VALUES(@id_habilidad_golpe, @id)
	
END
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[AumentarNivelPokemon]'))
    DROP proc [pokedexSchema].AumentarNivelPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].AumentarNivelPokemon(@idpokemonDeUser integer, @nivelNuevo integer)
as 
BEGIN
	UPDATE [pokedexSchema].Pokemon_x_users SET pok_x_user_nivel=@nivelNuevo WHERE pok_x_user_ID=@idpokemonDeUser
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[AniadirEvolucionAPokemon]'))
    DROP proc [pokedexSchema].AniadirEvolucionAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].AniadirEvolucionAPokemon(@idpokemon integer, @idEvolucion integer, @nivel integer)
as 
BEGIN
	IF((SELECT COUNT(*) FROM [pokedexSchema].Evolucion_Pokemones e 
			WHERE e.evol_pok_pokemonID=@idpokemon AND e.evol_pok_siguiente_evolucion=@idEvolucion)
					=0)
	INSERT INTO [pokedexSchema].Evolucion_Pokemones(evol_pok_pokemonID, evol_pok_siguiente_evolucion, evol_pok_nivel_requerido)
		VALUES(@idpokemon, @idEvolucion, @nivel)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[EliminarEvolucionAPokemon]'))
    DROP proc [pokedexSchema].EliminarEvolucionAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].EliminarEvolucionAPokemon(@idpokemon integer, @idEvolucion integer)
as 
BEGIN
	DELETE FROM [pokedexSchema].Evolucion_Pokemones WHERE evol_pok_pokemonID=@idpokemon AND evol_pok_siguiente_evolucion=@idEvolucion
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[ActualizarEvolucionAPokemon]'))
    DROP proc [pokedexSchema].ActualizarEvolucionAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].ActualizarEvolucionAPokemon(@idpokemon integer, @idEvolucion integer, @nivel integer)
as 
BEGIN
	UPDATE [pokedexSchema].Evolucion_Pokemones SET evol_pok_nivel_requerido=@nivel
		WHERE evol_pok_pokemonID=@idpokemon AND evol_pok_siguiente_evolucion=@idEvolucion
RETURN	
END	
GO



IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[AniadirNuevoPokemonAUser]'))
    DROP proc [pokedexSchema].AniadirNuevoPokemonAUser

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].AniadirNuevoPokemonAUser(@idpokemon integer, @idUser integer, @nivel integer)
as 
BEGIN
	INSERT INTO [pokedexSchema].Pokemon_x_users(pok_x_user_userID, pok_x_user_pokemonID, pok_x_user_nivel)
		VALUES(@idUser, @idpokemon, @nivel)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[AnaidirNuevoTipoAPokemon]'))
    DROP proc [pokedexSchema].AnaidirNuevoTipoAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].AnaidirNuevoTipoAPokemon(@idpokemon integer, @idTipo integer)
as 
BEGIN
	INSERT INTO [pokedexSchema].Tipos_x_pokemones(tipo_x_pok_pokemonID, tipo_x_pok_tipoID)
		VALUES(@idpokemon, @idTipo)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[CrearNuevoPokemon]'))
    DROP proc [pokedexSchema].CrearNuevoPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].CrearNuevoPokemon(@nombre varchar(30))
as 
BEGIN
	INSERT INTO [pokedexSchema].Pokemones(pok_name)
		VALUES(@nombre)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[AnaidirNuevoHabilidadAPokemon]'))
    DROP proc [pokedexSchema].AnaidirNuevoHabilidadAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].AnaidirNuevoHabilidadAPokemon(@idpokemonDeUser integer, @idHabilidad integer)
as 
BEGIN
			INSERT INTO [pokedexSchema].Habilidad_x_pokemones(hab_X_pok_habilidad_id, hab_x_pok_pokemon_de_user_id)
			SELECT TOP 1 @idHabilidad, @idpokemonDeUser FROM [pokedexSchema].Habilidad_x_pokemones h
				WHERE h.hab_x_pok_pokemon_de_user_id=@idpokemonDeUser AND
					 @idHabilidad NOT IN 
						(SELECT hh.hab_X_pok_habilidad_id 
						FROM [pokedexSchema].Habilidad_x_pokemones hh 
						WHERE hh.hab_x_pok_pokemon_de_user_id=@idpokemonDeUser)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[EliminarHabilidadAPokemon]'))
    DROP proc [pokedexSchema].EliminarHabilidadAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].EliminarHabilidadAPokemon(@idpokemonDeUser integer, @nombreHbailidad nvarchar(25))
as 
BEGIN
	DECLARE @idHabilidadAQuitar integer
	SELECT @idHabilidadAQuitar=h.hab_id FROM [pokedexSchema].Habilidades h WHERE h.hab_nombre = @nombreHbailidad
	DELETE FROM [pokedexSchema].Habilidad_x_pokemones 
		WHERE hab_X_pok_habilidad_id = @idHabilidadAQuitar AND hab_x_pok_pokemon_de_user_id = @idpokemonDeUser
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[EliminarTipoAPokemon]'))
    DROP proc [pokedexSchema].EliminarTipoAPokemon

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].EliminarTipoAPokemon(@idpokemon integer, @idTipo integer)
as 
BEGIN
	if((SELECT COUNT(*) FROM [pokedexSchema].Tipos_x_pokemones t WHERE t.tipo_x_pok_pokemonID=@idpokemon) > 1)
		BEGIN
			DELETE FROM [pokedexSchema].Tipos_x_pokemones WHERE tipo_x_pok_pokemonID=@idpokemon AND tipo_x_pok_tipoID=@idTipo
		END
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[crearUsuario]'))
    DROP proc [pokedexSchema].crearUsuario

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].crearUsuario(@nombreUser nvarchar(25))
as 
BEGIN
	INSERT INTO [pokedexSchema].User_Pokemon(usuario_nombre) VALUES (@nombreUser)
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[EliminarPokemonDeUsuario]'))
    DROP proc [pokedexSchema].EliminarPokemonDeUsuario

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].EliminarPokemonDeUsuario(@idpok_de_user integer)
as 
BEGIN
	--ELIMINAR EN CASCADA
	DELETE FROM [pokedexSchema].Habilidad_x_pokemones WHERE hab_x_pok_pokemon_de_user_id=@idpok_de_user
	DELETE FROM [pokedexSchema].Pokemon_x_users WHERE pok_x_user_ID=@idpok_de_user
RETURN	
END	
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'pokedexSchema.[EliminarUsuario]'))
    DROP proc [pokedexSchema].EliminarUsuario

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [pokedexSchema].EliminarUsuario(@idUser integer)
as 
BEGIN
	--ELIMINAR EN CASCADA
	DECLARE @id_pokxuser integer
	if(exists(SELECT p.pok_x_user_ID FROM [pokedexSchema].Pokemon_x_users  p WHERE p.pok_x_user_userID=@idUser))
		BEGIN
			SELECT TOP 1 @id_pokxuser=p.pok_x_user_ID FROM [pokedexSchema].Pokemon_x_users  p WHERE p.pok_x_user_userID=@idUser
			EXEC [pokedexSchema].EliminarPokemonDeUsuario @id_pokxuser
		END
	DELETE FROM [pokedexSchema].User_Pokemon WHERE usuario_id=@idUser
RETURN
END
GO


/* ME DI CUENTA QUE ESTO ESTÁ DE MAS, DE TODAS FORMAS NO LO QUITO POR SI QUIERO CONTINUAR ESTE TRABAJO POR MI CUENTA PROPIA
INSERT INTO Tipo_es_debil_contra(tipo_es_debil_parteDebil, tipo_es_debil_parteFuerte)
VALUES 
(6, 12), (6,16), (2,2), (2,4), (0,2), (13,2), (5,2), 
(2,12), (2,15), (16,2), (4,4), (0,4), (8,4), (12,4),(4,15), 
(7,7), (7,0), (3,7), (7,15), 
(0,0), (0,1), (8,0), (0,3), (0,5), (12,0), (0,15),
(13,13), (8,13), (3,13), (15,13), (13,16),
(10,1), (10,3), (10,11), (10,5), (12,10), (17,10), (16,10), (10,9), 
(1,1), (1,8), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), 
(0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), 
(0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0), (0,0);
*/

PRINT('Base de datos POKEDEX creada')

/*
SELECT * FROM [pokedexSchema].User_Pokemon

SELECT pu.pok_x_user_ID ,p.pok_name, pu.pok_x_user_nivel FROM [pokedexSchema].Pokemones p
	JOIN [pokedexSchema].Pokemon_x_users pu ON pu.pok_x_user_pokemonID = p.pok_id AND pu.pok_x_user_userID=1
	JOIN [pokedexSchema].User_Pokemon u ON u.usuario_id = pu.pok_x_user_userID AND u.usuario_id=1
							ORDER BY p.pok_id asc

*/
