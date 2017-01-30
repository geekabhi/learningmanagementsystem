CREATE TABLE `teachers` (
  `id`        int(11)                 NOT NULL AUTO_INCREMENT,
  `name`      varchar(45)             NOT NULL,
  `age`       int(11)                 NOT NULL,
  `gender`    ENUM('Male','Female')   NOT NULL,
  `created`   timestamp               NULL DEFAULT CURRENT_TIMESTAMP,
  `modified`  timestamp               NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
