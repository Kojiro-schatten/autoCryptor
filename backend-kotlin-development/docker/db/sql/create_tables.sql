CREATE TABLE users (
  id SERIAL NOT NULL,
  name varchar(255) NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE portfolios (
  id SERIAL NOT NULL,
  user_id bigint NOT NULL,
  title varchar(255) NOT NULL,
  created_at timestamp,
  updated_at timestamp,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE brands (
  id SERIAL NOT NULL,
  name varchar(255) NOT NULL,
  price integer NOT NULL,
  quantity integer,
  evaluated_price integer,
  profit_and_loss integer,
  yesterday_ratio integer,
  created_at timestamp,
  updated_at timestamp,
  PRIMARY KEY (id)
);

CREATE TABLE portfolios_belong_to_brand (
  id SERIAL NOT NULL,
  portfolio_id bigint NOT NULL,
  brand_id bigint NOT NULL,
  created_at timestamp,
  updated_at timestamp,
  PRIMARY KEY (id),
  FOREIGN KEY (portfolio_id) REFERENCES portfolios(id),
  FOREIGN KEY (brand_id) REFERENCES brands(id)
);

CREATE TABLE strategies (
  id SERIAL NOT NULL,
  brand_id bigint NOT NULL,
  name varchar(255) NOT NULL,
  created_at timestamp,
  updated_at timestamp,
  PRIMARY KEY (id)
);