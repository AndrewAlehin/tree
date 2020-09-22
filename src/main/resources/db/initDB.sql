DROP TABLE IF EXISTS objects;
DROP SEQUENCE IF EXISTS objects_id_seq;

CREATE SEQUENCE objects_id_seq;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE objects
(
    id               bigint                            NOT NULL DEFAULT nextval('objects_id_seq'::regclass),
    uid              text COLLATE pg_catalog."default" NOT NULL DEFAULT uuid_generate_v1(),
    object_type      integer                           NOT NULL,
    data             jsonb,
    parent_object_id bigint                            NOT NULL DEFAULT 0,
    CONSTRAINT objects_pkey PRIMARY KEY (id)
)