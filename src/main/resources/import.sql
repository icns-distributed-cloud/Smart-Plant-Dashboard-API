INSERT INTO sensor_pos(pos_code, pos_dtl, pos_name) values('I', '전자정보대학 331호', 'ICNS');
INSERT INTO sensor_pos(pos_code, pos_dtl, pos_name) values('S', '전자정보대학 332호', '서버실');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('T', '온도센서', '온도', 'effff');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('H', '습도센서', '습도', 'ffff2');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('D', '분진센서', '분진', 'ffff3');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('G', '가스센서', '가스', 'ffff4');


INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,1);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,2);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,3);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,4);