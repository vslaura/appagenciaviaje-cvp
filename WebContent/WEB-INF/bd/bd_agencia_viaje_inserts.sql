

use bd_appagenciaviajes;

insert into tb_agencia values ('AG001', 'CIVA', 'Habilitado');
insert into tb_agencia values ('AG002', 'La Molina', 'Habilitado');
insert into tb_agencia values ('AG003', 'Libertadores', 'Habilitado');
insert into tb_agencia values ('AG004', 'Mega Bus', 'Habilitado');
insert into tb_agencia values ('AG005', 'Red Bus', 'Habilitado');
insert into tb_agencia values ('AG006', 'Antezana', 'Habilitado');
insert into tb_agencia values ('AG007', 'Cruz del Sur', 'Habilitado');
insert into tb_agencia values ('AG008', 'Flores', 'Habilitado');
insert into tb_agencia values ('AG009', 'Exclusiva', 'Habilitado');
insert into tb_agencia values ('AG010', 'Tepsa', 'Habilitado');
insert into tb_agencia values ('AG011', 'Tu Agencia', 'Habilitado');

insert into tb_categoria values(1,'Administrador');
insert into tb_categoria values(2,'Chofer');

insert into tb_empleado values ('EA001','28788976','Juan','Valdes Martinez',1);
insert into tb_empleado values ('EC002','28788976','Ricardo','Perez Romero',1);
insert into tb_empleado values ('EC004', '84118523', 'Juana', 'Hoppe McClure', 2);
insert into tb_empleado values ('EC005', '87079401', 'Coralie', 'Lesch Rogahn', 2);
insert into tb_empleado values ('EC006', '70674170', 'Jessy', 'Towne Gerhold', 2);
insert into tb_empleado values ('EC007', '54178717', 'Dolores', 'Terry Schulist', 2);
insert into tb_empleado values ('EC008', '41994474', 'Payton', 'Stamm Harris', 2);
insert into tb_empleado values ('EC009', '31461955', 'Enoch', 'Davis Dickens', 2);
insert into tb_empleado values ('EC010', '28711490', 'Neva', 'Aufderhar Ortiz', 2);
insert into tb_empleado values ('EC011', '36179855', 'Darby', 'Schimmel Maggio', 2);
insert into tb_empleado values ('EC012', '39835284', 'Lacey', 'Reynolds Muller', 2);
insert into tb_empleado values ('EC013', '14158872', 'Enid', 'McClure Wilkinson', 2);
insert into tb_empleado values ('EC014', '73340836', 'Greta', 'Stamm Waelchi', 2);
insert into tb_empleado values ('EC015', '63303155', 'Rigoberto', 'Macejkovic Upton', 2);
insert into tb_empleado values ('EC016', '92059030', 'Eugene', 'Smith Skiles', 2);
insert into tb_empleado values ('EC017', '65648551', 'Ethelyn', 'Leannon Rogahn', 2);
insert into tb_empleado values ('EC018', '28936084', 'Providenci', 'Corkery Hauck', 2);
insert into tb_empleado values ('EC019', '68236960', 'Esmeralda', 'Berge Parker', 2);
insert into tb_empleado values ('EC020', '04266860', 'Catalina', 'Lehner Anderson', 2);

insert into tb_estado_bus values ('EB000', 'Seleccionar todo', 'Habilitado');
insert into tb_estado_bus values ('EB001', 'En servicio', 'Habilitado');
insert into tb_estado_bus values ('EB002', 'Fuera de servicio', 'Habilitado');
insert into tb_estado_bus values ('EB003', 'En Mantenmiento', 'Habilitado');

insert into tb_bus values('B0001','VSM242','Negro','HYundai',30, 'EB001');
insert into tb_bus values('B0002','MCV299','Blanco','HYundai',40, 'EB001');
insert into tb_bus values('B0003','MCV299','Blanco','HYundai',35, 'EB001');
insert into tb_bus values('B0004','BWT000','Negro','HYundai',50, 'EB001');
insert into tb_bus values('B0005','DEF678','Blanco','HYundai',30, 'EB001');
insert into tb_bus values('B0006','JUI897','Blanco','HYundai',40, 'EB001');
insert into tb_bus values('B0007','KIJ789','Negro','HYundai',45, 'EB001');
insert into tb_bus values('B0008','FRG534','Blanco','HYundai',50, 'EB001');
insert into tb_bus values('B0009','MKI876','Blanco','HYundai',35, 'EB001');
insert into tb_bus values('B0010','LOK897','Negro','HYundai',30, 'EB001');
insert into tb_bus values('B0011','POL543','Blanco','HYundai',50, 'EB001');
insert into tb_bus values('B0012','MVT465','Blanco','HYundai',40, 'EB001');
insert into tb_bus values('B0013','BFG342','Negro','HYundai',45, 'EB001');
insert into tb_bus values('B0014','YTU768','Blanco','HYundai',35, 'EB001');
insert into tb_bus values('B0015','IWJ700','Blanco','HYundai',30, 'EB001');
insert into tb_bus values('B0016','ITJ999','Negro','HYundai',50, 'EB002');
insert into tb_bus values('B0017','IPC700','Blanco','HYundai',40, 'EB002');
insert into tb_bus values('B0018','IPB701','Blanco','HYundai',35, 'EB002');
insert into tb_bus values('B0019','IDH812','Negro','HYundai',30, 'EB003');
insert into tb_bus values('B0029','IDF201','Blanco','HYundai',45, 'EB003');
insert into tb_bus values('B0030','BAA000','Blanco','HYundai',30, 'EB003');


insert into tb_departamento values ('DEP01','Amazonas');
insert into tb_departamento values ('DEP02','Ancash');
insert into tb_departamento values ('DEP03','Apurimac');
insert into tb_departamento values ('DEP04','Arequipa');
insert into tb_departamento values ('DEP05','Ayacucho');
insert into tb_departamento values ('DEP06','Cajamarca');
insert into tb_departamento values ('DEP07','Callao');
insert into tb_departamento values ('DEP08','Cusco');
insert into tb_departamento values ('DEP09','Huancavelica');
insert into tb_departamento values ('DEP10','Huanuco');
insert into tb_departamento values ('DEP11','Ica');
insert into tb_departamento values ('DEP12','Junin');
insert into tb_departamento values ('DEP13','La Libertad');
insert into tb_departamento values ('DEP14','Lambayeque');
insert into tb_departamento values ('DEP15','Lima');
insert into tb_departamento values ('DEP16','Loreto');
insert into tb_departamento values ('DEP17','Madre de Dios');
insert into tb_departamento values ('DEP18','Moquegua');
insert into tb_departamento values ('DEP19','Pasco');
insert into tb_departamento values ('DEP20','Piura');
insert into tb_departamento values ('DEP21','Puno');
insert into tb_departamento values ('DEP22','San Martin');
insert into tb_departamento values ('DEP23','Tacna');
insert into tb_departamento values ('DEP24','Tumbes');
insert into tb_departamento values ('DEP25','Ucayali');

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
