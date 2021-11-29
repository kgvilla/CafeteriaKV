CREATE TABLE IF NOT EXISTS  cliente(
    id serial,
    name VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    cedula VARCHAR(45) NULL,
    PRIMARY KEY (id)
    );

    CREATE TABLE IF NOT EXISTS  cafeteria(
  id serial,
  registro VARCHAR(45) NOT NULL,
  client VARCHAR(45) NOT NULL,
  entrega VARCHAR(45) NULL,
  PRIMARY KEY (id)

  );

CREATE TABLE IF NOT EXISTS  registration(
        id serial,
        lugar VARCHAR(45) NOT NULL,
        fecha VARCHAR(45) NOT NULL,
        hora VARCHAR(45) NULL,
        cliente_id int,
        FOREIGN KEY (cliente_id) REFERENCES cliente(id),
        cafeteria_id int,
        FOREIGN KEY (cafeteria_id) REFERENCES cafeteria(id),
        PRIMARY KEY (id)
        );





