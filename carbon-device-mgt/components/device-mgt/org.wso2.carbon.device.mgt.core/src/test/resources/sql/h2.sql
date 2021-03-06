CREATE TABLE IF NOT EXISTS DM_DEVICE_TYPE (
     ID   INT auto_increment NOT NULL,
     NAME VARCHAR(300) NULL DEFAULT NULL,
     PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS DM_DEVICE (
     ID                    INTEGER auto_increment NOT NULL,
     DESCRIPTION           TEXT NULL DEFAULT NULL,
     NAME                  VARCHAR(100) NULL DEFAULT NULL,
     DATE_OF_ENROLLMENT    BIGINT NULL DEFAULT NULL,
     DATE_OF_LAST_UPDATE   BIGINT NULL DEFAULT NULL,
     OWNERSHIP             VARCHAR(45) NULL DEFAULT NULL,
     STATUS                VARCHAR(15) NULL DEFAULT NULL,
     DEVICE_TYPE_ID        INT(11) NULL DEFAULT NULL,
     DEVICE_IDENTIFICATION VARCHAR(300) NULL DEFAULT NULL,
     OWNER                 VARCHAR(45) NULL DEFAULT NULL,
     TENANT_ID INTEGER DEFAULT 0,
     PRIMARY KEY (ID),
     CONSTRAINT fk_DM_DEVICE_DM_DEVICE_TYPE2 FOREIGN KEY (DEVICE_TYPE_ID )
     REFERENCES DM_DEVICE_TYPE (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS DM_OPERATION (
    ID INTEGER AUTO_INCREMENT NOT NULL,
    TYPE VARCHAR(50) NOT NULL,
    CREATED_TIMESTAMP TIMESTAMP NOT NULL,
    RECEIVED_TIMESTAMP TIMESTAMP NULL,
    STATUS VARCHAR(50) NULL,
    OPERATION_CODE VARCHAR(1000) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS DM_CONFIG_OPERATION (
    OPERATION_ID INTEGER NOT NULL,
    PRIMARY KEY (OPERATION_ID),
    CONSTRAINT fk_dm_operation_config FOREIGN KEY (OPERATION_ID) REFERENCES
    DM_OPERATION (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS DM_COMMAND_OPERATION (
    OPERATION_ID INTEGER NOT NULL,
    ENABLED BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (OPERATION_ID),
    CONSTRAINT fk_dm_operation_command FOREIGN KEY (OPERATION_ID) REFERENCES
    DM_OPERATION (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS DM_PROFILE_OPERATION (
    OPERATION_ID INTEGER NOT NULL,
    ENABLED INTEGER NOT NULL DEFAULT 0,
    OPERATION_DETAILS BLOB DEFAULT NULL,
    PRIMARY KEY (OPERATION_ID),
    CONSTRAINT fk_dm_operation_profile FOREIGN KEY (OPERATION_ID) REFERENCES
    DM_OPERATION (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS DM_DEVICE_OPERATION_MAPPING (
    ID INTEGER AUTO_INCREMENT NOT NULL,
    DEVICE_ID INTEGER NOT NULL,
    OPERATION_ID INTEGER NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT fk_dm_device_operation_mapping_device FOREIGN KEY (DEVICE_ID) REFERENCES
    DM_DEVICE (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_dm_device_operation_mapping_operation FOREIGN KEY (OPERATION_ID) REFERENCES
    DM_OPERATION (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);