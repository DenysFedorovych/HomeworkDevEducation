# Вывести общее число жителей
SELECT COUNT(*)
FROM citizen;

# Вывести средний возраст жителей
SELECT AVG(age) AS average
FROM citizen;

# Вывести отсортированный по алфавиту список фамилий без повторений
SELECT DISTINCT last_name
FROM citizen
ORDER BY last_name;

# Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке
SELECT last_name, COUNT(*)
FROM citizen
GROUP BY last_name;

# Вывести фамилии, которые содержат в середине букву «б»
SELECT last_name
FROM citizen
WHERE last_name LIKE '_%b%_';

# Вывести список «бомжей»
SELECT *
FROM citizen
WHERE street_id IS NULL;

# Вывести список несовершеннолетних, проживающих на проспекте Правды
SELECT *
FROM citizen
WHERE age < 18
  AND street_id = 1;

# Вывести упорядоченный по алфавиту список всех улиц с указанием, сколько жильцов живёт на улице
SELECT street.id, street.name, COUNT(citizen.street_id)
FROM street
         JOIN citizen ON street.id = citizen.street_id
GROUP BY street.id, street.name;

# Вывести список улиц, название которых состоит из 6-ти букв
SELECT *
FROM street
WHERE LENGTH(name) = 6;

# Вывести список улиц с количеством жильцов на них меньше 3
SELECT street.id, street.name FROM street JOIN citizen ON Street.Id = citizen.street_id
GROUP BY street.id, street.name
HAVING COUNT(citizen.id) < 3;







