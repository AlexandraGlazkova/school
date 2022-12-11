
-- 1. Получить всех студентов, возраст которых находится между 10 и 20
-- (можно подставить любые числа, главное, чтобы нижняя граница была меньше верхней).
SELECT * FROM students WHERE age BETWEEN 20 AND 23;
-- 2. Получить всех студентов, но отобразить только список их имен.
SELECT name FROM students;
-- 3. Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
SELECT * FROM students WHERE name LIKE '%л%';
-- 4. Получить всех студентов, у которых возраст меньше идентификатора.
SELECT * FROM students WHERE age<id;
-- 5. Получить всех студентов упорядоченных по возрасту.
SELECT * FROM students ORDER BY age;
-- получить факультет студента
SELECT f.id, s.name FROM students as s,faculty as f
WHERE s.faculty_id = f.id
  AND s.id = 4;
-- получить студентов факультета
SELECT f.id, s.name FROM students as s,faculty as f
WHERE s.faculty_id = f.id
  AND f.id = 3;