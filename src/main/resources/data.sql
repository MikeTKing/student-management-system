-- ====== STUDENTS ======
INSERT INTO students (first_name, last_name, email, version) VALUES
                                                                 ('John', 'Doe', 'john.doe@example.com', 0),
                                                                 ('Jane', 'Smith', 'jane.smith@example.com', 0),
                                                                 ('Michael', 'Johnson', 'michael.johnson@example.com', 0),
                                                                 ('Emily', 'Davis', 'emily.davis@example.com', 0),
                                                                 ('David', 'Wilson', 'david.wilson@example.com', 0),
                                                                 ('Sarah', 'Brown', 'sarah.brown@example.com', 0),
                                                                 ('Chris', 'Taylor', 'chris.taylor@example.com', 0),
                                                                 ('Jessica', 'Anderson', 'jessica.anderson@example.com', 0),
                                                                 ('Daniel', 'Thomas', 'daniel.thomas@example.com', 0),
                                                                 ('Olivia', 'Martinez', 'olivia.martinez@example.com', 0);

-- ====== COURSES ======
INSERT INTO courses (code, name, description, version) VALUES
                                                           ('CS101', 'Introduction to Computer Science', 'Basics of programming and algorithms', 0),
                                                           ('MATH201', 'Calculus I', 'Limits, derivatives, and integrals', 0),
                                                           ('ENG150', 'English Composition', 'Academic writing and composition', 0),
                                                           ('HIST210', 'World History', 'Survey of world civilizations', 0),
                                                           ('PHY110', 'Physics I', 'Mechanics and basic physics concepts', 0);

-- ====== ENROLLMENTS ======
-- We assume generated IDs:
-- students: 1..10 in order of insert
-- courses:  1..5  in order of insert

INSERT INTO enrollments (student_id, course_id, grade, version) VALUES
                                                                    (1, 1, 85.0, 0),
                                                                    (1, 2, 90.0, 0),
                                                                    (2, 1, 78.0, 0),
                                                                    (2, 3, 88.0, 0),
                                                                    (3, 1, 92.0, 0),
                                                                    (3, 4, 81.0, 0),
                                                                    (4, 2, 75.0, 0),
                                                                    (4, 5, 89.0, 0),
                                                                    (5, 1, 68.0, 0),
                                                                    (5, 2, 74.0, 0),
                                                                    (6, 3, 91.0, 0),
                                                                    (6, 4, 86.0, 0),
                                                                    (7, 5, 79.0, 0),
                                                                    (7, 1, 83.0, 0),
                                                                    (8, 2, 88.0, 0),
                                                                    (8, 3, 94.0, 0),
                                                                    (9, 4, 72.0, 0),
                                                                    (9, 5, 80.0, 0),
                                                                    (10, 1, 95.0, 0),
                                                                    (10, 2, 87.0, 0);

-- Optional: more enrollments for heavier testing
INSERT INTO enrollments (student_id, course_id, grade, version) VALUES
                                                                    (1, 3, 88.0, 0),
                                                                    (2, 2, 82.0, 0),
                                                                    (3, 2, 89.0, 0),
                                                                    (4, 1, 77.0, 0),
                                                                    (5, 3, 70.0, 0),
                                                                    (6, 5, 93.0, 0),
                                                                    (7, 2, 85.0, 0),
                                                                    (8, 4, 90.0, 0),
                                                                    (9, 1, 76.0, 0),
                                                                    (10, 3, 92.0, 0);