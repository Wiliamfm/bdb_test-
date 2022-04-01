create table person(
	id varchar(10) primary key,
	full_name text not null,
	birth_date date not null,
	father varchar(10) references person(id),
	mother varchar(10) references person(id)
);