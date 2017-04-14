CREATE TABLE rooms
(
  id bigint NOT NULL,
  name character varying(255),
  CONSTRAINT room_pkey PRIMARY KEY (id)
);

CREATE TABLE devices
(
  id bigint NOT NULL,
  devicegpio character varying(255),
  device_internal_port character varying(255),
  device_name character varying(255),
  device_physical_port character varying(255),
  device_type character varying(255),
  room_id bigint,
  CONSTRAINT device_pkey PRIMARY KEY (id),
  CONSTRAINT fkn_device_room FOREIGN KEY (room_id)
      REFERENCES rooms (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE roles
(
  id bigint NOT NULL,
  name character varying(255),
  CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
  user_id bigint NOT NULL,
  role_id bigint NOT NULL
);

CREATE TABLE users
(
  id bigint NOT NULL,
  login character varying(255),
  password character varying(255),
  email character varying(255),
  enabled boolean DEFAULT FALSE,
  CONSTRAINT user_pkey PRIMARY KEY (id)
);