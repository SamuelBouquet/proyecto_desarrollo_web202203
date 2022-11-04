use libreria;

drop table if exists shopping cascade ;
drop table if exists book cascade;
drop table if exists editorial;
drop table if exists client;



create table editorial (
    id int primary key auto_increment,
    name varchar(200) not null
);

create table client(
    id int primary key auto_increment,
    email varchar(50) not null,
    password varchar(50) not null,
    name varchar(100) not null,
    activado boolean not null
);

create table book (
    id int primary key auto_increment,
    name varchar(200) not null,
    description varchar(3000) not null,
    image_url varchar(3000),
    editorial_id int not null,
    foreign key (editorial_id) references editorial(id)
);

create table shopping(
    id int not null auto_increment primary key ,
    id_book int not null,
    id_client int not null,
    foreign key (id_book) references book(id),
    foreign key (id_client) references client(id)
);

insert into editorial
(id,name) values
                                                      (1,     'Ballard & Tighe, Publishers'),
                                                      (2,     'Bilingual Review Press'),
                                                      (3,     'Ediciones Baquiana'),
                                                      (4,     'Unknown');

insert into book
(id,    name,description,image_url,editorial_id) values
(1,     'El Siconalista',       'Frederick Starks, psicoanalista de larga experiencia y vida tranquila, recibe una amenaza anónima. Tendrá que emplear toda su astucia para averiguar quién es el autor de esa misiva que promete hacerle la existencia imposible.',    'https://images-na.ssl-images-amazon.com/images/I/41Zc7DRsnoL._SX327_BO1,204,203,200_.jpg',1),
(2,     'Billy Summers',        'Novela sobre un buen tipo con un trabajo muy malo.',                                                                                                                                                                                   'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1618151020l/56852407.jpg',2),
(3,     'Los Ilusionistas',     'Cuenta la historia de un golpe militar en Chile.',                                                                                                                                                                                     'https://images-na.ssl-images-amazon.com/images/I/61887EOsA0L.jpg',3),
(4,     'Cien Años de Soledad', 'El único premio novel de literatura de Colombia.',                                                                                                                                                                                     'https://images-na.ssl-images-amazon.com/images/I/51g1mv8VEnL._SX322_BO1,204,203,200_.jpg',4);



select book.name,editorial.name from editorial join book on editorial.id = book.editorial_id

