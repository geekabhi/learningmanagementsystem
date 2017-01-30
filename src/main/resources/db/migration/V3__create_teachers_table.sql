CREATE TABLE `teachers` (
  `id`        int(11)                 NOT NULL AUTO_INCREMENT,
  `name`      varchar(45)             NOT NULL,
  `age`       int(11)                 NOT NULL,
  `gender`    ENUM('Male','Female')   NOT NULL,
  `klass_id`  int(11)                 NULL,
  `created`   timestamp               NULL DEFAULT CURRENT_TIMESTAMP,
  `modified`  timestamp               NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_klasses_id` FOREIGN KEY (`klass_id`) REFERENCES `klasses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)
