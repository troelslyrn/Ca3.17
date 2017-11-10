create table user_roles(
	user_role varchar(45),
    primary key (user_role)
);

create table users(
	id int NOT NULL,
    username varchar(45),
    password_hashed varchar(71),
    primary key (id)
);

create table users_user_roles(
	id int,
    user_role varchar(45),
    foreign key(id) references users(id),
    foreign key(user_role) references user_roles(user_role)
);

create table adress(
	city varchar(45) NOT NULL,
    zip int NOT NULL,
    street varchar(45) NOT NULL,
    housenr int,
    primary key(zip)
);

create table location(
	idlocation int NOT NULL,
    description varchar(500),
    img blob,
    zip int,
    primary key(idlocation),
    foreign key(zip) references adress(zip)
);

create table ratings(
    idlocation int,
    rating smallint NOT NULL,
    foreign key(idlocation) references location(idlocation)
);

insert into adress(city, zip, street, housenr) values ('atlantis', 2013, 'high mountain', 4);
insert into adress(city, zip, street, housenr) values ('vesuv', 666, 'hexia blv', 1);
insert into adress(city, zip, street, housenr) values ('billund', 7190, 'lego street', 41);
insert into adress(city, zip, street, housenr) values ('crete', 0083, 'palace of crete', 23);
insert into adress(city, zip, street, housenr) values ('middle of the sea', 0000, 'wetstreet', 5000);

insert into location(idlocation, description, img, zip) values(1, "idyllic winter cottage in the snowy mountains", load_file('C:\img\img001.jpg'), 2013);
insert into location(idlocation, description, img, zip) values(2, "quaint little hut, near mt. vesuvius", load_file('C:\img\img001.jpg'), 666);
insert into location(idlocation, description, img, zip) values(3, "a fantastic plae to bring the entire family", load_file('C:\img\img001.jpg'), 7190);
insert into location(idlocation, description, img, zip) values(4, "fantastic place to get lost, watch out for the minotaur", load_file('C:\img\img001.jpg'), 0083);
insert into location(idlocation, description, img, zip) values(5, "a bit wet, but okay place", load_file('C:\img\img001.jpg'), 0000);

insert into ratings(idlocation,rating) values (1, 4);
insert into ratings(idlocation,rating) values (2, 5);
insert into ratings(idlocation,rating) values (3, 2);
insert into ratings(idlocation,rating) values (4, 3);
insert into ratings(idlocation,rating) values (5, 3);