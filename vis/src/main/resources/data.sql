insert into schema (id, name, schema) values (1, 'RTZ', FILE_READ('classpath:schemas/rtz_format_1_1_29032017.xsd'));
insert into schema (id, name, schema) values (2, 'RTZ-STM-EXT', FILE_READ('classpath:schemas/stm_extensions_29032017.xsd'));
insert into schema (id, name, schema) values (3, 'TXTMSG', FILE_READ('classpath:schemas/textMessageSchema_1_33.xsd'));
insert into schema (id, name, schema) values (4, 'S124', FILE_READ('classpath:schemas/S1241.xsd'));
insert into schema (id, name, schema) values (5, 'AREA-GMLPROFILE', FILE_READ('classpath:schemas/S100_gmlProfile.xsd'));
insert into schema (id, name, schema) values (6, 'AREA-GMLPROFILELEVELS', FILE_READ('classpath:schemas/S100_gmlProfileLevels.xsd'));
insert into schema (id, name, schema) values (7, 'AREA-GMLBASE', FILE_READ('classpath:schemas/s100gmlbase.xsd'));

insert into schema_schema(schema_id, related_schema_id) values (1, 2);
insert into schema_schema(schema_id, related_schema_id) values (4, 5);
insert into schema_schema(schema_id, related_schema_id) values (4, 6);
insert into schema_schema(schema_id, related_schema_id) values (4, 7);

insert into event_number (id, name) values (1, 'VIS_get Voyage Plan_request ');
insert into event_number (id, name) values (2, 'VIS_get Voyage Plan_response ');
insert into event_number (id, name) values (3, 'VIS_upload Voyage Plan_request ');
insert into event_number (id, name) values (4, 'VIS_upload Voyage Plan_response ');
insert into event_number (id, name) values (5, 'VIS_upload Text Message_request ');
insert into event_number (id, name) values (6, 'VIS_upload Text Message_response ');
insert into event_number (id, name) values (7, 'VIS_upload Area Message_request ');
insert into event_number (id, name) values (8, 'VIS_upload Area Message_response ');
insert into event_number (id, name) values (9, 'VIS_subscribe To Voyage Plan_request ');
insert into event_number (id, name) values (10, 'VIS_subscribe To Voyage Plan_response ');
insert into event_number (id, name) values (11, 'VIS_remove Subscribe To Voyage Plan_request ');
insert into event_number (id, name) values (12, 'VIS_remove Subscribe To Voyage Plan_response ');
insert into event_number (id, name) values (13, 'VIS_acknowledgement_request ');
insert into event_number (id, name) values (14, 'VIS_acknowledgement_response ');
insert into event_number (id, name) values (15, 'VIS_publish Message ');
insert into event_number (id, name) values (16, 'VIS_send Acknowledgement ');
insert into event_number (id, name) values (17, 'VIS_consume Service ');
insert into event_number (id, name) values (18, 'SPIS_amss_request ');
insert into event_number (id, name) values (19, 'SPIS_amss_response ');
insert into event_number (id, name) values (20, 'SPIS_state Update_request ');
insert into event_number (id, name) values (21, 'SPIS_state Update_response ');
insert into event_number (id, name) values (22, 'SPIS_consume Service ');
insert into event_number (id, name) values (23, '- ');
insert into event_number (id, name) values (24, '- ');
insert into event_number (id, name) values (25, '- ');
insert into event_number (id, name) values (26, '- ');
insert into event_number (id, name) values (27, 'SPIS_upload PCM_response ');
insert into event_number (id, name) values (28, 'SPIS_upload PCM_request ');
insert into event_number (id, name) values (29, 'VIS_check Subscribe To Voyage Plan_request ');
insert into event_number (id, name) values (30, 'VIS_check Subscribe To Voyage Plan_response ');

insert into event_type (id, name) values (1, 'Successful ');
insert into event_type (id, name) values (2, 'Error_schema ');
insert into event_type (id, name) values (3, 'Error_parameters ');
insert into event_type (id, name) values (4, 'Error_communication ');
insert into event_type (id, name) values (5, 'Error_internal ');
insert into event_type (id, name) values (6, 'Error_authorization ');
insert into event_type (id, name) values (7, 'Info ');

insert into event_data_type (id, name) values (1, 'RTZ ');
insert into event_data_type (id, name) values (2, 'TXT ');
insert into event_data_type (id, name) values (3, 'PCM ');
insert into event_data_type (id, name) values (4, 'S124 ');
insert into event_data_type (id, name) values (5, 'Error Message ');
insert into event_data_type (id, name) values (6, 'Other ');
insert into event_data_type (id, name) values (7, 'Unknown ');
insert into event_data_type (id, name) values (8, 'None ');
