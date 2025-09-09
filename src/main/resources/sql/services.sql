-- Nail Art
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='NAIL'), 'NAIL_SIMPLE', 'Simple Nail Art', 300, 30),
((SELECT id FROM categories WHERE code='NAIL'), 'NAIL_HAND_WASH', 'Hand Wash Nail Art', 400, 40),
((SELECT id FROM categories WHERE code='NAIL'), 'NAIL_HAND_LEG', 'Hand + Leg Nail Design', 700, 60);

-- Makeup
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='MAKEUP'), 'MAKEUP_NORMAL', 'Normal Makeup', 1000, 60),
((SELECT id FROM categories WHERE code='MAKEUP'), 'MAKEUP_HD', 'HD Makeup', 2000, 90),
((SELECT id FROM categories WHERE code='MAKEUP'), 'MAKEUP_AIRBRUSH', 'Airbrush Makeup', 3000, 90),
((SELECT id FROM categories WHERE code='MAKEUP'), 'MAKEUP_BRIDAL', 'Bridal Makeup', 5000, 150);

-- Threading
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='THREAD'), 'THREAD_EYEBROW', 'Eyebrow Threading', 100, 10),
((SELECT id FROM categories WHERE code='THREAD'), 'THREAD_FACE', 'Face Threading', 300, 20);

-- Bleaching
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='BLEACH'), 'BLEACH_FACE', 'Face Bleaching', 500, 30),
((SELECT id FROM categories WHERE code='BLEACH'), 'BLEACH_HAND_FULL', 'Hand Bleaching (Full)', 600, 30),
((SELECT id FROM categories WHERE code='BLEACH'), 'BLEACH_LEG', 'Leg Bleaching', 700, 40);

-- Facial
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='FACIAL'), 'FACIAL_FRUIT', 'Fruit Facial', 800, 45),
((SELECT id FROM categories WHERE code='FACIAL'), 'FACIAL_BRIDAL', 'Bridal Facial', 2500, 90);

-- Waxing
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='WAX'), 'WAX_FULL_BODY', 'Full Body Waxing', 2000, 90),
((SELECT id FROM categories WHERE code='WAX'), 'WAX_BIKINI', 'Bikini Waxing', 1000, 45);

-- Hair
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='HAIR'), 'HAIR_CUT', 'Haircut (Ladies)', 500, 30),
((SELECT id FROM categories WHERE code='HAIR'), 'HAIR_BRIDAL_STYLE', 'Bridal Hairstyle', 1500, 60),
((SELECT id FROM categories WHERE code='HAIR'), 'HAIR_COLOR', 'Hair Coloring', 2000, 120);

-- Massage
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='MASSAGE'), 'MASSAGE_HEAD', 'Head Massage', 400, 30),
((SELECT id FROM categories WHERE code='MASSAGE'), 'MASSAGE_FULL_BODY', 'Full Body Massage', 2000, 90);

-- Manicure & Pedicure
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='MANI_PEDI'), 'MANI_HAND', 'Hand Manicure', 600, 40),
((SELECT id FROM categories WHERE code='MANI_PEDI'), 'PEDI_FOOT', 'Foot Pedicure', 700, 50);

-- Mehendi
INSERT INTO services (category_id, code, name, base_price, duration_minutes)
VALUES
((SELECT id FROM categories WHERE code='MEHENDI'), 'MEHENDI_SIMPLE', 'Simple Mehendi', 500, 60),
((SELECT id FROM categories WHERE code='MEHENDI'), 'MEHENDI_BRIDAL', 'Bridal Mehendi', 3000, 180);
