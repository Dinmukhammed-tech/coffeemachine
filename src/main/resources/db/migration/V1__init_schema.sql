-- Таблица для хранения кофе машин
CREATE TABLE coffee_machine (
                                id BIGSERIAL PRIMARY KEY
);

-- Таблица для хранения рецептов
CREATE TABLE recipe (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) UNIQUE NOT NULL
);

-- Связующая таблица между кофе машинами и рецептами
CREATE TABLE coffee_machine_recipe (
                                       id BIGSERIAL PRIMARY KEY,
                                       coffee_machine_id BIGINT NOT NULL REFERENCES coffee_machine(id),
                                       recipe_id BIGINT NOT NULL REFERENCES recipe(id)
);

-- Таблица для хранения заказов
CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        recipe_id BIGINT NOT NULL REFERENCES recipe(id),
                        date TIMESTAMP NOT NULL
);
