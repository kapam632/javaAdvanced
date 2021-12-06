DROP TABLE IF EXISTS dbo."Heroes";
CREATE TABLE IF NOT EXISTS dbo."Heroes"
(
    id integer,
    name varchar(32),
    ultimate varchar(255)
);
INSERT INTO dbo."Heroes"(id, name, ultimate)
	VALUES (6, 'Baal', 'the Lord of Destruction');
INSERT INTO dbo."Heroes"(id, name, ultimate)
	VALUES (4, 'Diablo', 'the Lord of Terror');
INSERT INTO dbo."Heroes"(id, name, ultimate)
	VALUES (5, 'Mephisto', 'the Lord of Hatred');