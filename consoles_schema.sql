USE consoles;

DROP TABLE IF EXISTS user_consoles;
DROP TABLE IF EXISTS user_games;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS games_on_consoles;
DROP TABLE IF EXISTS consoles;

CREATE TABLE consoles (
  console_name varchar(25) NOT NULL,
  controllers int NOT NULL, 
  release_year year NOT NULL,
  release_price double(8,2),
  online_capable tinyint(1),
  PRIMARY KEY (console_name)
);

-- CREATE TABLE games_on_consoles (
--   game_id int NOT NULL auto_increment,
--   game_name varchar(25) NOT NULL,
--   console_name varchar(25) NOT NULL, 
--   PRIMARY KEY (game_id),
--   FOREIGN KEY (console_name) references consoles(console_name)
-- );

CREATE TABLE games_on_consoles (
  game_name varchar(50) NOT NULL,
  console_name varchar(25) NOT NULL,
  PRIMARY KEY (game_name, console_name),
  FOREIGN KEY (console_name) references consoles(console_name)
);

CREATE TABLE users (
  person_id int NOT NULL auto_increment,
  full_name varchar(40) NOT NULL,
  user_name varchar(25),
  PRIMARY KEY (person_id)
);

CREATE TABLE user_consoles (
  user_console_id int NOT NULL auto_increment,
  person_id int NOT NULL,
  console_serial_num int NOT NULL,
  console_name varchar(25) NOT NULL,
  PRIMARY KEY (user_console_id),
  FOREIGN KEY (person_id) references users(person_id),
  FOREIGN KEY (console_name) references consoles(console_name)
);

CREATE TABLE user_games (
  user_game_id int NOT NULL auto_increment,
  person_id int NOT NULL,
  game_serial_num int NOT NULL,
  game_name varchar(50) NOT NULL,
  console_name varchar(25) NOT NULL,
  PRIMARY KEY (user_game_id),
  FOREIGN KEY (person_id) references users(person_id),
  FOREIGN KEY (game_name) references games_on_consoles(game_name),
  FOREIGN KEY (console_name) references consoles(console_name)
);