
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
	cod_em  char(5) not null,
	cod_bus char(5) not null,
    fec_par_vje date not null,
    fec_lleg_vje date not null,
    cod_dep_origen char(5) not null,
    cod_dep_destino char(5) not null,
    codigoAgencia varchar(8) not null
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
    dni_cli char(8) not null,
    nom_cli varchar(30) not null,
    apell_cli varchar(50) not null,
    email_cli varchar(50) not null,
    usu_cli varchar(30) not null,
	cla_cli varchar(30) not null
);

alter table tb_cliente
add constraint pk_cod_cli primary key (cod_cli);

create table tb_pasaje (
	cod_psje char(5) not null,
    nro_asiento int not null,
    preci_psje decimal not null,
    fech_comp_psje date not null,
    cod_cli char(5) not null,
    cod_vje char(5) not null
);

alter table tb_pasaje
add constraint pk_cod_psje primary key (cod_psje);

alter table tb_pasaje
add constraint fk_cod_cli foreign key (cod_cli)
references tb_cliente(cod_cli);


alter table tb_pasaje
add constraint fk_cod_vje foreign key (cod_vje)
references tb_viaje(cod_vje);

/*.---------------------------*/

insert into tb_agencia values ('AG001', 'CIVA', 'Habilitado');
insert into tb_agencia values ('AG002', 'La Molina', 'Habilitado');
insert into tb_agencia values ('AG003', 'Libertadores', 'Habilitado');
insert into tb_agencia values ('AG004', 'Mega Bus', 'Habilitado');
insert into tb_agencia values ('AG005', 'Red Bus', 'Habilitado');
insert into tb_agencia values ('AG006', 'Antezana', 'Habilitado');

insert into tb_categoria values(1,'Administrador');
insert into tb_categoria values(2,'Chofer');

insert into tb_empleado values('EA001','28788976','Juan','Valdes Martinez',1);
insert into tb_empleado values('EC002','28788976','Ricardo','Perez Romero',1);

insert into tb_estado_bus values ('EB000', 'Seleccionar todo', 'Habilitado');
insert into tb_estado_bus values ('EB001', 'En servicio', 'Habilitado');
insert into tb_estado_bus values ('EB002', 'Fuera de servicio', 'Habilitado');
insert into tb_estado_bus values ('EB003', 'En Mantenmiento', 'Habilitado');

insert into tb_bus values('B0001','VSM242','Negro','HYundai',30, 'EB001');
insert into tb_bus values('B0002','MCV299','Blanco','HYundai',30, 'EB002');
insert into tb_bus values('B0003','MCV299','Blanco','HYundai',30, 'EB001');

insert into tb_departamento values ('DEP01','Lima');
insert into tb_departamento values ('DEP02','Ayacucho');
insert into tb_departamento values ('DEP03','Cajamarca');
insert into tb_departamento values ('DEP04','Piura');
insert into tb_departamento values ('DEP05','Amazonas');
insert into tb_departamento values ('DEP06','Cusco');
insert into tb_departamento values ('DEP07','Arequipa');
insert into tb_departamento values ('DEP08','Huancavelica');
insert into tb_departamento values ('DEP09','Ica');
insert into tb_departamento values ('DEP10','Puno');

    
insert into tb_viaje values('V0001','EA001','B0001','2017/11/30','2017/12/28','DEP01','DEP02', 'AG001');
insert into tb_viaje values('V0002','EC002','B0002','2017/11/30','2017/12/28','DEP01','DEP02', 'AG002');
insert into tb_viaje values('V0003','EA001','B0001','2017/11/30','2017/12/28','DEP01','DEP02', 'AG003');
insert into tb_viaje values('V0004','EC002','B0002','2017/11/30','2017/12/28','DEP01','DEP02', 'AG004');
insert into tb_viaje values('V0005','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP02', 'AG005');
insert into tb_viaje values('V0006','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP02', 'AG006');

insert into tb_viaje values('V0007','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG001');
insert into tb_viaje values('V0008','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG002');
insert into tb_viaje values('V0009','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG003');
insert into tb_viaje values('V0010','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG004');
insert into tb_viaje values('V0011','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG005');
insert into tb_viaje values('V0012','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG006');

insert into tb_viaje values('V0013','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG001');
insert into tb_viaje values('V0014','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG002');
insert into tb_viaje values('V0015','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG003');
insert into tb_viaje values('V0016','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG004');
insert into tb_viaje values('V0017','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG005');
insert into tb_viaje values('V0018','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG006');


insert into tb_viaje values('V0019','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG001');
insert into tb_viaje values('V0020','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG002');
insert into tb_viaje values('V0021','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG003');
insert into tb_viaje values('V0022','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG004');
insert into tb_viaje values('V0023','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG005');
insert into tb_viaje values('V0024','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG006');

insert into tb_viaje values('V0025','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG001');
insert into tb_viaje values('V0026','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG002');
insert into tb_viaje values('V0027','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG003');
insert into tb_viaje values('V0028','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG004');
insert into tb_viaje values('V0029','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG005');
insert into tb_viaje values('V0030','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG006');



insert into tb_cliente values ('C0001','89787656','Pedro','Torres Fuentes','Pedro89@gmail.com', 'pedro300', 'miClave');
insert into tb_cliente values ('C0002','89787658','Gian Carlos','Macedo Valdivia','GianMacedo@gmail.com', 'g456', 'miClave');

insert into tb_pasaje values ('P0001',30,60,'2017/12/28','C0001','V0001');
insert into tb_pasaje values ('P0002',30,60,'2017/12/28','C0001','V0002');

select * from tb_viaje;
select * from tb_cliente;
select * from tb_pasaje;
select * from tb_pasaje;
select * from tb_agencia;

select * from tb_bus where mar_bus = 'HYundai';

select nro_asiento,preci_psje
from tb_pasaje where fech_comp_psje = '2017/12/28';

select * from tb_bus where cod_est_bus = 'EB001';

select * from tb_viaje where cod_dep_origen = 'DEP01' and cod_dep_destino = 'DEP02' and fec_par_vje = '2017/11/30';

select desc_dep from tb_departamento where cod_dep = 'DEP01';

select nombreAgencia from tb_agencia where codigoAgencia = 'AG001';