INSERT INTO sensor_pos(pos_code, pos_dtl, pos_name) values('I', '전자정보대학 331호', 'ICNS');
INSERT INTO sensor_pos(pos_code, pos_dtl, pos_name) values('S', '전자정보대학 332호', '서버실');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('T', '온도센서', '온도', '#f2b345');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('H', '습도센서', '습도', '#249e53');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('D', '분진센서', '분진', '#3848bc');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('G', '가스센서', '가스', '#622aa7');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('CC', '이산화탄소 센서', 'CO2', '#9e9e9e');
INSERT INTO sensor_type(type_code, type_dtl, type_name, type_color_code) values('C', '일산화탄소 센서', 'CO', '#795548');




INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,1);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,2);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,3);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',1,4);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',2,5);
INSERT INTO sensor_manage(ss_contact, ss_contact_ext, ss_contact_phone, sensorpos_id, sensortype_id) values('허의남','01','0101111',2,6);