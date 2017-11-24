

drop database bd_appagenciaviajes;

create database bd_appagenciaviajes;
use bd_appagenciaviajes;

create table tb_agencia (
	codigoAgencia varchar(8) not null,
	nombreAgencia varchar(50) not null,
	estado varchar(12) not null
);

alter table tb_agencia
add constraint pk_agencia primary key (codigoAgencia);

create table tb_departamento(
	cod_dep char(5) not null,
    desc_dep varchar(30) not null
);

alter table tb_departamento
add constraint pk_cod_dep primary key (cod_dep);


create table tb_categoria(
	cod_cate int not null,
	tipo_cate varchar(20) not null
);

alter table tb_categoria
add constraint pk_cod_cate primary key (cod_cate);

create table tb_estado_bus(
	cod_est_bus char(5) not null,
	desc_est_bus varchar(30) not null,
	estado	varchar(20) not null
);

alter table tb_estado_bus
add constraint pk_estado_bus primary key (cod_est_bus);

create table tb_empleado(
	cod_em char(5) not null,
	dni_em char(8) not null,
	nom_em varchar(25)not null,
	ape_em varchar(50)not null,
	cod_cate int not null
);

alter table tb_empleado
add constraint pk_cod_em primary key (cod_em);

alter table tb_empleado
add constraint fk_cod_cate foreign key (cod_cate)
references tb_categoria(cod_cate);

create table tb_bus(
	cod_bus char(5) not null,
	placa_bus char(6) not null,
	col_bus varchar(30) not null,
	mar_bus varchar(35) not null,
	asien_bus int not null,
	cod_est_bus char(5) not null

);   

alter table tb_bus
add constraint pk_cod_bus primary key (cod_bus);


alter table tb_bus
add constraint fk_estado_bus foreign key (cod_est_bus)
references tb_estado_bus (cod_est_bus);

create table tb_viaje(
	cod_vje char(5) not null,
	cod_em  char(5) null,
	cod_bus char(5) null,
    fec_par_vje date null,
	hora_par_vje time null,
    fec_lleg_vje date null,
    cod_dep_origen char(5) null,
    cod_dep_destino char(5) null,
    codigoAgencia varchar(8) null,
	cantidadAsientos int null,
	precioViaje double null
);


alter table tb_viaje
add constraint pk_cod_vje primary key (cod_vje);

alter table tb_viaje
add constraint pk_cod_em foreign key (cod_em)
references tb_empleado(cod_em);

alter table tb_viaje
add constraint fk_cod_bus foreign key (cod_bus)
references tb_bus(cod_bus);

alter table tb_viaje
add constraint fk_cod_dep_origen foreign key (cod_dep_origen)
references tb_departamento(cod_dep);

alter table tb_viaje
add constraint fk_cod_dep_destino foreign key (cod_dep_destino)
references tb_departamento(cod_dep);

alter table tb_viaje
add constraint fk_cod_agencia foreign key (codigoAgencia)
references tb_agencia(codigoAgencia);


create table tb_cliente(
	cod_cli char(5) not null,
    dni_cli char(8) not null unique,
    nom_cli varchar(30) not null,
    apell_cli varchar(50) not null,
    email_cli varchar(50) not null unique,
    usu_cli varchar(30) not null unique,
	cla_cli varchar(30) not null
);

alter table tb_cliente
add constraint pk_cod_cli primary key (cod_cli);

create table tb_pasaje (
	cod_psje char(5) not null,
    nro_asiento int null,
    fech_comp_psje date null,
	hora_psje time null,
    cod_cli char(5) null,
    cod_vje char(5) not null,
	reservado varchar(30) null,
	actualizado varchar(30) null
);

alter table tb_pasaje
add constraint pk_cod_psje primary key (cod_psje);

/*
alter table tb_pasaje
add constraint fk_cod_cli foreign key (cod_cli)
references tb_cliente(cod_cli);


alter table tb_pasaje
add constraint fk_cod_vje foreign key (cod_vje)
references tb_viaje(cod_vje);
*/