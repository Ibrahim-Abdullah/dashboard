CREATE TABLE category
(
  id serial NOT NULL,
  parentid bigint,
  name character varying(255),
  createbyuserid bigint,
  createtimemillis bigint,
  lastupdatetimemillis bigint,
  updatebyuserid bigint,
  userrequest boolean,
  show boolean,
  description text,
  picturename character varying(255),
 picturepath character varying(255),
 index integer,
   CONSTRAINT category_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE talent
  OWNER TO promytheus;