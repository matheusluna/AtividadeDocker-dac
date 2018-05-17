create table banda(
  nome text primary key,
  localdeorigem text
);
create table integrante(
  banda text,
  nome text,
  foreign key (banda) references banda(nome)
);
create table album(
  id serial,
  estilo text,
  banda text,
  anodelancamento date,
  primary key (id),
  foreign key (banda) references banda(nome)
)
