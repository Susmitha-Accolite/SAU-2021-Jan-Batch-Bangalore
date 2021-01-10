CREATE TABLE Teams
(
TeamID varchar(20) NOT NULL,
TeamName varchar(255),
Country varchar(255),
No_of_wins int,
No_of_losses int,
No_of_Bowlers int,
No_of_Batsmen int,
primary key(TeamID)
);


INSERT INTO Teams(TeamID, TeamName,Country, No_of_wins, No_of_losses, No_of_Bowlers, No_of_Batsmen)
VALUES ('IND1221', 'MEN IN BLUE', 'India', 5, 1, 6, 5);
INSERT INTO Teams(TeamID, TeamName,Country, No_of_wins, No_of_losses, No_of_Bowlers, No_of_Batsmen)
VALUES ('AUS2332', 'KANGAROO', 'Australia', 3, 3, 5, 6);
INSERT INTO Teams(TeamID, TeamName,Country, No_of_wins, No_of_losses, No_of_Bowlers, No_of_Batsmen)
VALUES ('SA3443', 'PROTEA', 'South Africa', 1, 5, 7, 4);
INSERT INTO Teams(TeamID, TeamName,Country, No_of_wins, No_of_losses, No_of_Bowlers, No_of_Batsmen)
VALUES ('NZ4554', 'BLACK CAPS', 'New Zealand', 4, 2, 4, 7);
INSERT INTO Teams(TeamID, TeamName,Country, No_of_wins, No_of_losses, No_of_Bowlers, No_of_Batsmen)
VALUES ('BAN5665', 'TIGERS', 'Bangladesh',2, 4, 8, 3);

SELECT * FROM Teams;







CREATE TABLE Matches
(
MatchID varchar(20) NOT NULL,
MatchDate date,
Winner varchar(255),
Looser varchar(255),
primary key(MatchID)
);


INSERT INTO Matches(MatchID, MatchDate, Winner,Looser)
 VALUES ('MAT101', '2021-01-02','India', 'Bangladesh');
 INSERT INTO Matches(MatchID, MatchDate, Winner,Looser)
 VALUES ('MAT102', '2021-01-04', 'Australia', 'New Zealand');
  INSERT INTO Matches(MatchID, MatchDate, Winner,Looser)
 VALUES ('MAT103', '2021-01-06', 'New Zealand', 'South Africa');
  INSERT INTO Matches(MatchID, MatchDate, Winner,Looser)
 VALUES ('MAT104', '2021-01-08', 'India', 'South Africa');
  INSERT INTO Matches(MatchID, MatchDate, Winner,Looser)
 VALUES ('MAT105', '2021-01-10', 'Bangladesh', 'Australia');
 
 select * FROM Matches;
 
CREATE TABLE Players
(
PlayerID varchar(225) NOT NULL,
TeamID varchar(225),
PlayerName varchar(255),
CountryName varchar(255),
No_of_Mactches int,
No_of_Runs int,
No_of_Wickets int,
Player_Type varchar(225),
PRIMARY KEY(PlayerID),
FOREIGN KEY (TeamID) REFERENCES Teams(TeamID)
);

INSERT INTO Players VALUES('PLR1001', 'IND1221', 'AAA','India', 4, 20, 5, 'Bowler');
INSERT INTO Players VALUES('PLR1002', 'AUS2332', 'BBB', 'Australia',5, 120, 0, 'Batsmen');
INSERT INTO Players VALUES('PLR1003', 'SA3443', 'CCC','South Africa', 3, 70, 1, 'Batsmen');
INSERT INTO Players VALUES('PLR1004', 'NZ4554', 'DDD', 'New Zealand', 4, 90, 0, 'Batsmen');
INSERT INTO Players VALUES('PLR1005', 'BAN5665', 'EEE', 'Bangladesh',4, 10, 8, 'Bowler');
INSERT INTO Players VALUES('PLR1006', 'NZ4554', 'FFF', 'New Zealand',6, 20, 6, 'Bowler');
INSERT INTO Players VALUES('PLR1007', 'AUS2332', 'GGG','Australia', 2, 13, 9, 'Bowler');
INSERT INTO Players VALUES('PLR1008', 'SA3443', 'HHH', 'South Africa',4, 7, 7, 'Bowler');
INSERT INTO Players VALUES('PLR1009', 'IND1221', 'SSS', 'India',4, 150, 0, 'Batsmen');
INSERT INTO Players VALUES('PLR10010', 'SA3443', 'JJJ', 'South Africa',4, 11, 3, 'Bowler');
INSERT INTO Players VALUES('PLR10011', 'IND1221', 'KKK', 'India',5, 17, 8, 'Bowler');
INSERT INTO Players VALUES('PLR10012', 'BAN5665', 'LLL', 'Bangladesh',4, 115, 0, 'Batsmen');
INSERT INTO Players VALUES('PLR10013', 'AUS2332', 'MMM', 'Australia',2, 50, 1, 'Batsmen');
INSERT INTO Players VALUES('PLR10014', 'NZ4554', 'NNN', 'New Zealand',3, 12, 10, 'Bowler');
INSERT INTO Players VALUES('PLR10015', 'IND1221', 'PPP', 'India',4, 170, 0, 'Batsmen');
select * FROM Players;


CREATE TABLE Scores
(
ScoreID varchar(225) NOT NULL,
MatchID varchar(225),
TeamID varchar(225),
CountryName varchar(255),
Score int,
PRIMARY KEY(ScoreID),
FOREIGN KEY (MatchID) REFERENCES Matches(MatchID),
FOREIGN KEY (TeamID) REFERENCES Teams(TeamID)
);

INSERT INTO Scores VALUES('SOR1', 'MAT101','IND1221','India', 250);
INSERT INTO Scores VALUES('SOR2', 'MAT101', 'BAN5665','Bangladesh', 200);
INSERT INTO Scores VALUES('SOR3', 'MAT102','NZ4554','New Zealand', 190);
INSERT INTO Scores VALUES('SOR4', 'MAT102', 'AUS2332','Australia', 237);
INSERT INTO Scores VALUES('SOR5', 'MAT103','NZ4554','New Zealand', 308);
INSERT INTO Scores VALUES('SOR6', 'MAT103', 'SA3443','South Africa', 265);
INSERT INTO Scores VALUES('SOR7', 'MAT104','SA3443','South Africa', 300);
INSERT INTO Scores VALUES('SOR8', 'MAT104','IND1221','India', 311);
INSERT INTO Scores VALUES('SOR9', 'MAT105','BAN5665','Bangladesh', 210);
INSERT INTO Scores VALUES('SOR10', 'MAT105','AUS2332','Australia', 188);
SELECT * FROM Scores; 


SELECT PlayerID, PlayerName FROM Players where Player_Type = "Batsmen" order by No_of_Runs desc LIMIT 5;

SELECT PlayerID, PlayerName FROM Players where Player_Type = "Bowler" order by No_of_Wickets desc LIMIT 5;

SELECT CountryName, AVG(Score) as Average_Score FROM Scores group by CountryName having AVG(Score) > 0;


Update Players SET No_of_Runs = (No_of_Runs + 10) Where CountryName In 
(select CountryName From Scores Group by CountryName having AVG(Score) = 
(Select Min(Score) from (Select AVG(Score) as Score from Scores group by Scores.CountryName having AVG(Score) > 0) as MINScore));

select * FROM Players;




DELIMITER $$

DROP PROCEDURE IF EXISTS CountryMaxScore$$
CREATE PROCEDURE CountryMaxScore(country VARCHAR(255), OUT s INT)
BEGIN
SELECT max(Score) INTO s from Scores where Scores.CountryName = country;
END$$

DELIMITER ;
CALL CountryMaxScore("South Africa",@s);
SELECT @s;