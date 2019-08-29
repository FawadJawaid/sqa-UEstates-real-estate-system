CREATE TABLE owner (
  id INTEGER   NOT NULL ,
  name VARCHAR(45)    ,
  address VARCHAR(45)    ,
  phone INTEGER      ,
PRIMARY KEY(id));




CREATE TABLE property (
  id INTEGER   NOT NULL ,
  owner_id INTEGER   NOT NULL ,
  e_type VARCHAR(45)    ,
  size INTEGER    ,
  value INTEGER    ,
  right VARCHAR(45)    ,
  asking_price INTEGER    ,
  var_price INTEGER    ,
  age INTEGER    ,
  p_type VARCHAR(45)    ,
  location VARCHAR(255)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(owner_id)
    REFERENCES owner(id));


CREATE INDEX property_FKIndex1 ON property (owner_id);


CREATE INDEX IFK_Rel_01 ON property (owner_id);


CREATE TABLE services (
  id INTEGER   NOT NULL ,
  property_id INTEGER   NOT NULL ,
  name VARCHAR(45)    ,
  cost INTEGER      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(property_id)
    REFERENCES property(id));


CREATE INDEX services_FKIndex1 ON services (property_id);


CREATE INDEX IFK_Rel_03 ON services (property_id);


CREATE TABLE agent (
  id INTEGER   NOT NULL ,
  owner_id INTEGER   NOT NULL ,
  name VARCHAR(45)    ,
  phone INTEGER    ,
  Description VARCHAR(255)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(owner_id)
    REFERENCES owner(id));


CREATE INDEX agent_FKIndex1 ON agent (owner_id);


CREATE INDEX IFK_Rel_02 ON agent (owner_id);


CREATE TABLE physical_character (
  id INTEGER   NOT NULL ,
  property_id INTEGER   NOT NULL ,
  name INTEGER    ,
  value VARCHAR(45)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(property_id)
    REFERENCES property(id));


CREATE INDEX physical_character_FKIndex1 ON physical_character (property_id);


CREATE INDEX IFK_Rel_04 ON physical_character (property_id);



