INSERT INTO role(role_id, name) VALUES (999, 'ROLE_USER')
INSERT INTO role(role_id, name) VALUES (998, 'ROLE_ADMIN')

INSERT INTO parking_slot(id, available, slot_number) VALUES (101, true, '3M')
INSERT INTO parking_slot(id, available, slot_number) VALUES (102, true, '7M')
INSERT INTO parking_slot(id, available, slot_number) VALUES (103, false, '4C')

INSERT INTO vehicle(id, vehicle_number, vehicle_type) VALUES (111, '13MM3423', 'MOTORCYCLE')
INSERT INTO vehicle(id, vehicle_number, vehicle_type) VALUES (112, '37MM7927', 'MOTORCYCLE')
INSERT INTO vehicle(id, vehicle_number, vehicle_type) VALUES (113, '44CC3429', 'CAR')

INSERT INTO booking(id, end_time, parking_name, reservation_date, start_time, parking_slot_id, vehicle_id) VALUES (121, '11:30', 'Resepark', '2022-08-12', '09:15', 101, 111)
INSERT INTO booking(id, end_time, parking_name, reservation_date, start_time, parking_slot_id, vehicle_id) VALUES (122, '14:20', 'Resepark', '2022-08-29', '13:05', 103, 113)
INSERT INTO booking(id, end_time, parking_name, reservation_date, start_time, parking_slot_id, vehicle_id) VALUES (123, '12:25', 'Parkrevo', '2022-07-17', '10:05', 102, 112)