USE dishnowdb;
-- Inserción de ingredientes para las recetas
-- Receta 1: Sopa Cremosa de Tomate
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (1, 1);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (1, 4);

-- Receta 2: Paella de Marisco
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (2, 2);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (2, 15);

-- Receta 3: Pastel de Queso
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (3, 4);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (3, 13);

-- Receta 4: Limonada con Menta
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (4, 5);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (4, 6);

-- Receta 5: Ensalada de Quinoa
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (5, 7);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (5, 5);

-- Receta 6: Sopa de Pollo con Fideos
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (6, 3);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (6, 8);

-- Receta 7: Arroz con Pollo
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (7, 2);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (7, 3);

-- Receta 8: Galletas de Avena
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (8, 9);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (8, 13);

-- Receta 9: Batido de Frutas Rojas
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (9, 10);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (9, 5);

-- Receta 10: Ensalada Griega
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (10, 4);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (10, 1);

-- Receta 11: Crema de Calabaza
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (11, 11);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (11, 4);

-- Receta 12: Lasaña de Carne
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (12, 12);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (12, 4);

-- Receta 13: Brownie de Chocolate
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (13, 13);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (13, 9);

-- Receta 14: Zumo de Naranja
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (14, 14);

-- Receta 15: Ensalada César
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (15, 3);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (15, 4);

-- Receta 16: Sopa de Ramen
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (16, 8);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (16, 3);

-- Receta 17: Salmón al Horno
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (17, 15);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (17, 5);

-- Receta 18: Trufas de Chocolate
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (18, 13);

-- Receta 19: Batido de Proteína
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (19, 10);

-- Receta 20: Ensalada de Pasta con Pesto
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (20, 8);
INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`) VALUES (20, 1);

-- Inserción de 20 fotos para las recetas
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (1, 'https://example.com/photos/tomato_soup.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (2, 'https://example.com/photos/seafood_paella.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (3, 'https://example.com/photos/cheesecake.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (4, 'https://example.com/photos/mint_lemonade.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (5, 'https://example.com/photos/quinoa_salad.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (6, 'https://example.com/photos/chicken_soup.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (7, 'https://example.com/photos/chicken_rice.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (8, 'https://example.com/photos/oatmeal_cookies.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (9, 'https://example.com/photos/red_fruit_smoothie.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (10, 'https://example.com/photos/greek_salad.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (11, 'https://example.com/photos/pumpkin_cream.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (12, 'https://example.com/photos/meat_lasagna.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (13, 'https://example.com/photos/chocolate_brownie.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (14, 'https://example.com/photos/orange_juice.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (15, 'https://example.com/photos/caesar_salad.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (16, 'https://example.com/photos/ramen_soup.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (17, 'https://example.com/photos/baked_salmon.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (18, 'https://example.com/photos/chocolate_truffles.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (19, 'https://example.com/photos/protein_smoothie.jpg');
INSERT INTO `recipe_photos` (`recipe_id`, `photo_url`) VALUES (20, 'https://example.com/photos/pasta_salad_pesto.jpg');