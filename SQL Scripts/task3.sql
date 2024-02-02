CREATE TABLE Country(
	id SERIAL PRIMARY KEY,
	name_country VARCHAR(100) NOT NULL
);

CREATE TABLE League(
	id SERIAL PRIMARY KEY,
	name_league VARCHAR(100) NOT NULL,
	id_country INTEGER REFERENCES Country(id)
);

CREATE TABLE Team(
	id SERIAL PRIMARY KEY,
	name_team VARCHAR(100) NOT NULL,
	id_league INTEGER REFERENCES League(id),
	founding_year INTEGER NOT NULL,
	goal_scored INTEGER DEFAULT 0,
	conceded_goal INTEGER DEFAULT 0,
	score INTEGER DEFAULT 0,
	team_level INTEGER NOT NULL
);

CREATE TABLE Player (
	id SERIAL PRIMARY KEY,
	name_player VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	id_team INTEGER REFERENCES Team(id),
	id_country INTEGER REFERENCES Country(id),
	goal_scored INTEGER DEFAULT 0
);

INSERT INTO Country (name_country) VALUES
    ('Turkey'),
    ('England'),
    ('Spain'),
    ('Germany'),
	('Argentina'),
	('Bosnia and Herzegovina'),
	('Egypt'),
	('Croatia'),
	('France'),
	('Belgium');
	

INSERT INTO League (name_league, id_country) VALUES
    ('Super Lig', 1),
    ('1. Lig', 1),
    ('Premier League', 2),
    ('La Liga', 3),
    ('Bundesliga', 4);
	
INSERT INTO Team (name_team, id_league, founding_year, goal_scored, conceded_goal, score, team_level) VALUES
    ('Galatasaray', 1, 1905, 50, 20, 65, 1),
    ('Fenerbahçe', 1, 1907, 55, 18, 70, 1),
    ('Beşiktaş', 1, 1903, 60, 15, 68, 1),
    ('Trabzonspor', 1, 1967, 40, 25, 55, 1),
	('Göztepe', 2, 1925, 25, 20, 50, 2),
    ('Gençlerbirliği', 2, 1923, 18, 20, 45, 2),
    ('Manchester United', 3, 1878, 50, 20, 65, 1),
	('Liverpool', 3, 1892, 55, 25, 70, 1),
    ('Real Madrid', 4, 1902, 70, 10, 80, 1),
    ('Barcelona', 4, 1899, 75, 12, 78, 1),
    ('Bayern Munich', 5, 1900, 80, 8, 90, 1),
    ('Borussia Dortmund', 5, 1909, 70, 15, 72, 1),
    ('PSG', 6, 1970, 65, 15, 75, 1);
	
INSERT INTO Player (name_player, surname, id_team, id_country, goal_scored) VALUES
    ('Mauro', 'Icardi', 1, 5, 25),
    ('Edin', 'Dzeko', 2, 6, 20),
    ('Cenk', 'Tosun', 3, 1, 15),
    ('Edin', 'Visca', 4, 6, 18),
    ('Marcus', 'Rashford', 5, 2, 30),
    ('Mohamed', 'Salah', 6, 7, 35),
    ('Luka', 'Modric', 7, 8, 12),
    ('Ousmane', 'Dembele', 8, 9, 10),
    ('Thomas', 'Müller', 9, 4, 22),
    ('Marco', 'Reus', 10, 4, 28),
    ('Lionel', 'Messi', 11, 5, 45),
	('Dries','Mertens',1,1,11);
	
COMMIT;	

-- "Türkiye" ülkesinin liglerinin listesi:
SELECT * FROM League 
WHERE id_country = (SELECT id FROM Country WHERE name_country = 'Turkey');

-- "Türkiye" olan ülkenin takımların listesi
SELECT * FROM Team WHERE Team.id_league IN (SELECT id FROM League WHERE id_country = (SELECT id FROM Country WHERE name_country = 'Turkey'));

-- "Türkiye" ülkesinin en üst seviyeli ligdeki puan tablosu
SELECT * FROM Team 
WHERE id_league IN (SELECT id FROM League WHERE id_country = (SELECT id FROM Country WHERE name_country = 'Turkey')) AND team_level = 1 
ORDER BY score DESC;

-- Türkiye liglerindeki puan ortalamaları
SELECT League.name_league, AVG(Team.score) AS Avg_Score
FROM League
JOIN Team ON League.id = Team.id_league
WHERE League.id_country = (SELECT id FROM Country WHERE name_country = 'Turkey')
GROUP BY League.name_league 
ORDER BY Avg_Score DESC

--Bir ligin Gol kralı
SELECT Player.name_player, Player.surname, Team.name_team AS Team_name, Country.name_country
FROM Player
JOIN Team ON Player.id_team = Team.id
JOIN Country ON Player.id_country = Country.id
WHERE Team.id_league = 1
ORDER BY Player.goal_scored DESC
LIMIT 1;

--Tüm liglerde attığı gol yediği golden daha küçük olan takımlar
SELECT * FROM Team
WHERE goal_scored < conceded_goal;

--Bir takımın oyuncularının toplam gol sayısı ve takımın gol sayısı
SELECT Team.id, Team.name_team, SUM(Player.goal_scored) AS total_goal_scored, Team.goal_scored AS team_goal_scored
FROM Team
JOIN Player ON Team.id = Player.id_team
WHERE Team.id = (SELECT id FROM Team WHERE name_team = 'Galatasaray')
GROUP BY Team.id;
