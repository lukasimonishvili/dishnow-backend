USE dishnowdb;
-- Inserción de 5 categorías
INSERT INTO `category` (`id`, `nameca`, `nameen`, `namees`) VALUES (1, 'Sopa', 'Soup', 'Sopa');
INSERT INTO `category` (`id`, `nameca`, `nameen`, `namees`) VALUES (2, 'Plato principal', 'Main course', 'Plato principal');
INSERT INTO `category` (`id`, `nameca`, `nameen`, `namees`) VALUES (3, 'Postre', 'Dessert', 'Postre');
INSERT INTO `category` (`id`, `nameca`, `nameen`, `namees`) VALUES (4, 'Bebida', 'Beverage', 'Bebida');
INSERT INTO `category` (`id`, `nameca`, `nameen`, `namees`) VALUES (5, 'Ensalada', 'Salad', 'Ensalada');
-- Inserción de 3 usuarios
INSERT INTO `user` (`id`, `birthday`, `email`, `last_name`, `name`, `password_hash`, `role`, `verified`) VALUES (1, '1990-05-15', 'chef_joan@example.com', 'Pérez', 'Joan', 'hash123', 1, 1);
INSERT INTO `user` (`id`, `birthday`, `email`, `last_name`, `name`, `password_hash`, `role`, `verified`) VALUES (2, '1985-08-22', 'maria_recipes@example.com', 'Gómez', 'María', 'hash456', 1, 1);
INSERT INTO `user` (`id`, `birthday`, `email`, `last_name`, `name`, `password_hash`, `role`, `verified`) VALUES (3, '1992-11-30', 'healthy_eats@example.com', 'López', 'Carlos', 'hash789', 1, 1);