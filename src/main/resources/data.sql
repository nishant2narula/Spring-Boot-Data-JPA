INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Aarav Sharma', 'MALE', DATE '1990-05-10', 'aarav.sharma@example.com', 'O_POSITIVE');
INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Diya Patel', 'FEMALE', DATE '1995-08-20', 'diya.patel@example.com', 'A_POSITIVE');
INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Dishant Verma', 'MALE', DATE '1988-03-15', 'dishant.verma@example.com', 'A_POSITIVE');
INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Nishant Verma', 'MALE', DATE '1989-03-15', 'nishant.verma@example.com', 'A_POSITIVE');
INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Neha Iyer', 'FEMALE', DATE '1992-12-01', 'neha.iyer@example.com', 'AB_POSITIVE');
INSERT INTO patient (name, gender, birth_date, email, blood_group) VALUES ('Kabir Singh', 'MALE', DATE '1993-07-11', 'kabir.singh@example.com', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email) VALUES ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com');
INSERT INTO doctor (name, specialization, email) VALUES('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com');
INSERT INTO doctor (name, specialization, email) VALUES('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');


INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-01 10:30:00', 'General Checkup', 1, 2);
INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-02 11:00:00', 'Skin Rash', 2, 2);
INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-03 09:45:00', 'Knee Pain', 3, 3);
INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-04 14:00:00', 'Follow-up Visit', 1, 1);
INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-05 16:15:00', 'Consultation', 1, 4);
INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id) VALUES(TIMESTAMP '2025-07-06 08:30:00', 'Allergy Treatment', 2, 5);

