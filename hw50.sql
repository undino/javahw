create database if not exists cinemadb;
use cinemadb;
create table if not exists Genres (
	GenreID int primary key auto_increment not null unique,
    GenreName varchar(100) not null check( GenreName != '')
   
);

create table if not exists Movies (
	MovieID int primary key auto_increment unique,
    DirectorID int not null check( DirectorID !=''),
    Title varchar(100) not null check( Title != ''),
    ReleaseYear int not null check(ReleaseYear !=''),
    Rating int not null check(Rating >=0 and Rating <= 5),
    Plot varchar(10000) not null check( Plot != ''),
    MovieLength time not null
);

create table if not exists Actors(
	ActorID int primary key auto_increment not null unique,
    FirstName varchar(20) not null check(FirstName !=''),
    LastName varchar(20) not null check(FirstName !=''),
    Nationality varbinary(20) not null check(Nationality !=''),
    Birth date not null
);

create table if not exists Directors(
	DirectorID int primary key auto_increment not null unique,
    FirstName varchar(20) not null check(FirstName !=''),
    LastName varchar(20) not null check(FirstName !=''),
    Nationality varbinary(20) not null check(Nationality !=''),
    Birth date not null
);

create table if not exists MovieGenres(
	MovieID int not null,
	GenreID int not null
);

create table if not exists MovieActor(
	MovieID int not null,
	ActorID int not null
);

alter table MovieGenres add constraint fk_MG_Genres foreign key (GenreID) references Genres(GenreID); 
alter table MovieGenres add constraint fk_MG_Movies foreign key (MovieID) references Movies(MovieID); 

alter table MovieActor add constraint fk_MA_Movies foreign key (MovieID) references Movies(MovieID); 
alter table MovieActor add constraint fk_MA_Actors foreign key (ActorID) references Actors(ActorID); 
alter table Movies add constraint fk_Movies_Directors foreign key (DirectorID) references Directors(DirectorID);

insert Genres (GenreName)
values
("Боевик"),
("Вестерн"),
("Драмма"),
("Комедия"),
("Детектив");

insert Actors (FirstName, LastName, Nationality, Birth)
values
("Брэд", "Питт", "Американец", "1963-12-18"),
("Брюс", "Уиллис", "Американец", "1955-03-19"),
("Уилл", "Смит", "Американец", "1968-09-25"),
("Том", "Харди", "Англичанин", "1963-12-18"),
("Орди", "Тоту", "Французка", "1976-08-19");

insert Directors (FirstName, LastName, Nationality, Birth)
values 
("Джерри", "Брукхаймер", "Американец", "1943-09-21"),
("Джордж", "Лукач", "Американец", "1944-05-14"),
("Аарон", "Спеллинг", "Американец", "1923-04-22");

insert Movies (DirectorID, Title, ReleaseYear, Rating, Plot, MovieLength)
value
(1, "Одинокие рейнджеры", 2013, 4, "История блюстителя закона Джона Рейда, который с помощью индейца Тон", "02:55:13"),
(1, "Гермин", 2019, 5, "Генри Броган, первоклассный киллер, становится мишенью таинственного оперативник", "01:57:06"),
(2, "Такер", 1988, 4, "американский биографический фильм режиссёра Фрэнсиса Форда Копполы", "02:10:46");
