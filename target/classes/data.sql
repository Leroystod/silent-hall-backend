-- Insert a Test Student
-- Using the format your Regex expects: UMAT/CS/21/0042
INSERT INTO students (full_name, reference_number, program, department, course, level, email, is_active, enrollment_date)
VALUES ('Frederick Frimpong', 'UMAT/CS/21/0042', 'Computer Science', 'Computer Science', 'Java Programming', 200, 'frederick@student.umat.edu.gh', true, NOW())
ON DUPLICATE KEY UPDATE full_name=full_name;

-- Insert a Test Lecturer
-- Username: admin | Password: password123
INSERT INTO lecturers (full_name, username, password, department, email)
VALUES ('Dr. Kweku Assistant', 'admin', '$2a$10$8K1p/a0PdzS.6AInNYvWp.vL5r.f8O6lRMBfS.bVvW9W.h7K8i5G6', 'CS Department', 'kweku@umat.edu.gh')
ON DUPLICATE KEY UPDATE username=username;