--insert into schema (id, name, schema) values (1, 'RTZ', FILE_READ('classpath:schemas/rtz-v1.0.xsd'));
insert into schema (id, name, schema) values (1, 'RTZ', FILE_READ('classpath:schemas/rtz_2_0_format.xsd'));
insert into schema (id, name, schema) values (2, 'TXTMSG', FILE_READ('classpath:schemas/textMessageSchema_1.2.xsd'));
insert into schema (id, name, schema) values (3, 'S124', FILE_READ('classpath:schemas/S124.xsd'));
insert into schema (id, name, schema) values (4, 'AREA-GMLPROFILE', FILE_READ('classpath:schemas/S100_gmlProfile.xsd'));
insert into schema (id, name, schema) values (5, 'AREA-GMLPROFILELEVELS', FILE_READ('classpath:schemas/S100_gmlProfileLevels.xsd'));
insert into schema (id, name, schema) values (6, 'AREA-GMLBASE', FILE_READ('classpath:schemas/s100gmlbase.xsd'));

insert into schema_schema(schema_id, related_schema_id) values (3, 4);
insert into schema_schema(schema_id, related_schema_id) values (3, 5);
insert into schema_schema(schema_id, related_schema_id) values (3, 6);
