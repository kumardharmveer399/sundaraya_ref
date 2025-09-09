INSERT IGNORE INTO states (country_id, name, state_code)
SELECT id, 'Jharkhand', 'JH' FROM countries WHERE iso_code = 'IND';

INSERT IGNORE INTO states (country_id, name, state_code)
SELECT id, 'Bihar', 'BR' FROM countries WHERE iso_code = 'IND';