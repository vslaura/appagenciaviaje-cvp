

use bd_appagenciaviajes;

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

    
insert into tb_viaje values('V0001','EA001','B0001','2017/11/30','2017/12/28','DEP01','DEP02', 'AG001', 30, 45.00);
insert into tb_viaje values('V0002','EC002','B0002','2017/11/30','2017/12/28','DEP01','DEP02', 'AG002', 30, 45.00);
insert into tb_viaje values('V0003','EA001','B0001','2017/11/30','2017/12/28','DEP01','DEP02', 'AG003', 30, 45.00);
insert into tb_viaje values('V0004','EC002','B0002','2017/11/30','2017/12/28','DEP01','DEP02', 'AG004', 30, 45.00);
insert into tb_viaje values('V0005','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP02', 'AG005', 30, 45.00);
insert into tb_viaje values('V0006','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP02', 'AG006', 30, 45.00);

insert into tb_viaje values('V0007','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG001', 30, 45.00);
insert into tb_viaje values('V0008','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG002', 30, 45.00);
insert into tb_viaje values('V0009','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG003', 30, 45.00);
insert into tb_viaje values('V0010','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG004', 30, 45.00);
insert into tb_viaje values('V0011','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG005', 30, 45.00);
insert into tb_viaje values('V0012','EC002','B0002','2017/11/02','2017/12/28','DEP01','DEP03', 'AG006', 30, 60.00);

insert into tb_viaje values('V0013','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG001', 30, 60.00);
insert into tb_viaje values('V0014','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG002', 30, 60.00);
insert into tb_viaje values('V0015','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG003', 30, 60.00);
insert into tb_viaje values('V0016','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG004', 30, 60.00);
insert into tb_viaje values('V0017','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG005', 30, 60.00);
insert into tb_viaje values('V0018','EC002','B0002','2017/11/03','2017/12/28','DEP01','DEP04', 'AG006', 30, 60.00);


insert into tb_viaje values('V0019','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG001', 30, 60.00);
insert into tb_viaje values('V0020','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG002', 30, 60.00);
insert into tb_viaje values('V0021','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG003', 30, 100.00);
insert into tb_viaje values('V0022','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG004', 30, 100.00);
insert into tb_viaje values('V0023','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG005', 30, 100.00);
insert into tb_viaje values('V0024','EC002','B0002','2017/11/04','2017/12/28','DEP01','DEP05', 'AG006', 30, 100.00);

insert into tb_viaje values('V0025','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG001', 30, 100.00);
insert into tb_viaje values('V0026','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG002', 30, 100.00);
insert into tb_viaje values('V0027','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG003', 30, 100.00);
insert into tb_viaje values('V0028','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG004', 30, 100.00);
insert into tb_viaje values('V0029','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG005', 30, 100.00);
insert into tb_viaje values('V0030','EC002','B0002','2017/11/05','2017/12/28','DEP01','DEP06', 'AG006', 30, 100.00);



insert into tb_cliente values ('C0001','89787656','Pedro','Torres Fuentes','Pedro89@gmail.com', 'pedro300', 'miClave');
insert into tb_cliente values ('C0002','89787658','Gian Carlos','Macedo Valdivia','GianMacedo@gmail.com', 'g456', 'miClave');
insert into tb_cliente values ('C0003', '79642439', 'Nelson', 'BrownStamm', 'Icie@gmail.com', 'Keeley', 'Jacobi');
insert into tb_cliente values ('C0004', '81667345', 'Roberto', 'HintzCollier', 'Lester@gmail.com', 'Dayne', 'Wilkinson');
insert into tb_cliente values ('C0005', '67539369', 'Doris', 'StarkFisher', 'Niko@gmail.com', 'Demetris', 'Bartell');
insert into tb_cliente values ('C0006', '40043364', 'Mabel', 'VandervortWelch', 'Brett@gmail.com', 'Ophelia', 'Steuber');
insert into tb_cliente values ('C0007', '36934331', 'Urban', 'HillsZiemann', 'Jerrod@gmail.com', 'Jerrold', 'Quitzon');
insert into tb_cliente values ('C0008', '80095354', 'Gia', 'KreigerHackett', 'Oleta@gmail.com', 'Lilian', 'Streich');
insert into tb_cliente values ('C0009', '79652001', 'Dock', 'FritschAnkunding', 'Dejon@gmail.com', 'Jaylon', 'Auer');
insert into tb_cliente values ('C0010', '37996758', 'Carrie', 'MosciskiCronin', 'Elyssa@gmail.com', 'Dameon', 'Greenfelder');
insert into tb_cliente values ('C0011', '17144285', 'Xander', 'RosenbaumPfannerstill', 'Melyssa@gmail.com', 'Abdullah', 'Oberbrunner');
insert into tb_cliente values ('C0012', '57316970', 'Tom', 'SipesCollins', 'Ramon@gmail.com', 'Maybell', 'Weissnat');
insert into tb_cliente values ('C0013', '22595324', 'Reilly', 'ParkerOKeefe', 'Hattie@gmail.com', 'Connor', 'Schoen');
insert into tb_cliente values ('C0014', '53618245', 'Cassandre', 'KrajcikLebsack', 'Vivianne@gmail.com', 'Hilario', 'Champlin');
insert into tb_cliente values ('C0015', '11216667', 'Melody', 'ErdmanSchimmel', 'Amya@gmail.com', 'Dandre', 'Crooks');
insert into tb_cliente values ('C0016', '02265353', 'Donald', 'HowellJones', 'Amanda@gmail.com', 'Darion', 'Wilkinson');
insert into tb_cliente values ('C0017', '85485129', 'Ariel', 'BergstromYost', 'Winnifred@gmail.com', 'Mariana', 'Feeney');
insert into tb_cliente values ('C0018', '82069292', 'Meagan', 'HowellEffertz', 'Jaylen@gmail.com', 'Garfield', 'Reichert');
insert into tb_cliente values ('C0019', '09571341', 'Jena', 'BarrowsFerry', 'London@gmail.com', 'Everette', 'Barrows');
insert into tb_cliente values ('C0020', '66112822', 'Elroy', 'CreminDaugherty', 'Emil@gmail.com', 'Meghan', 'Nikolaus');
insert into tb_cliente values ('C0021', '80001768', 'Benjamin', 'JaskolskiKuphal', 'Kody@gmail.com', 'Justus', 'Haag');
insert into tb_cliente values ('C0022', '59701057', 'Lester', 'HeathcoteRath', 'Noe@gmail.com', 'Brielle', 'Homenick');
insert into tb_cliente values ('C0023', '85380608', 'Rosalind', 'BoyerBogan', 'Clay@gmail.com', 'Rowland', 'Welch');
insert into tb_cliente values ('C0024', '81364091', 'Valerie', 'PourosMetz', 'Justina@gmail.com', 'Erika', 'Klein');
insert into tb_cliente values ('C0025', '42118879', 'Aniyah', 'BogisichSkiles', 'Mavis@gmail.com', 'Georgiana', 'Schumm');
insert into tb_cliente values ('C0026', '48303491', 'Maxine', 'RutherfordCorkery', 'Korey@gmail.com', 'Stephany', 'Runolfsson');
insert into tb_cliente values ('C0027', '96486375', 'Bonnie', 'StrosinRodriguez', 'Christ@gmail.com', 'Vincenza', 'Monahan');
insert into tb_cliente values ('C0028', '09329645', 'Haskell', 'VolkmanTorphy', 'Tiara@gmail.com', 'Annamae', 'Robel');
insert into tb_cliente values ('C0029', '26942162', 'Erwin', 'VeumKertzmann', 'Clyde@gmail.com', 'Damaris', 'Kon');
insert into tb_cliente values ('C0030', '05304752', 'Tiffany', 'BalistreriHarris', 'Tania@gmail.com', 'Josiah', 'Crona');
insert into tb_cliente values ('C0031', '88680729', 'Ignatius', 'PurdyCorwin', 'Adan@gmail.com', 'Morgan', 'Towne');
insert into tb_cliente values ('C0032', '52838699', 'Juana', 'MarksConroy', 'Arlo@gmail.com', 'Hobart', 'Fahey');


insert into tb_pasaje values ('P0001',1,'2017/12/28','C0001','V0001', 'No');
insert into tb_pasaje values ('P0002',30,'2017/12/28','C0001','V0002', 'Si');

select * From tb_pasaje a inner join tb_cliente b on a.cod_cli = b.cod_cli;

select * from tb_viaje;
select * from tb_cliente;
select * from tb_pasaje;
select * from tb_pasaje;
select * from tb_agencia;

select * from tb_bus where mar_bus = 'HYundai';

select nro_asiento
from tb_pasaje where fech_comp_psje = '2017/12/28';

select * from tb_bus where cod_est_bus = 'EB001';

select * from tb_viaje where cod_dep_origen = 'DEP01' and cod_dep_destino = 'DEP02' and fec_par_vje = '2017/11/30';

select desc_dep from tb_departamento where cod_dep = 'DEP01';

select nombreAgencia from tb_agencia where codigoAgencia = 'AG001';


select * from tb_pasaje;
update tb_pasaje set cod_cli = 'C0001', reservado = 'Si' where cod_psje = 'P0001';

select * from tb_pasaje where reservado = 'No' and cod_vje = 'V0031';


select * from tb_viaje;
select * from tb_departamento;