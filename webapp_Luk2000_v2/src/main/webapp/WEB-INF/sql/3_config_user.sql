
-- Création de l'utilisateur pour se connecter à la base de données (Yassine)
CREATE USER 'lukadmin' IDENTIFIED BY 'lukpass';

-- Affectation des droits à l'utilisateur pour un accès en localhost
GRANT ALL PRIVILEGES ON luk2000.* TO lukadmin@localhost
IDENTIFIED BY "lukpass" WITH GRANT OPTION;

-- Affectation des droits à l'utilisateur pour un accès à distance
GRANT ALL PRIVILEGES ON luk2000.* TO lukadmin@"%"
IDENTIFIED BY "lukpass" WITH GRANT OPTION;

-- On recharge les privilèges
FLUSH PRIVILEGES;
