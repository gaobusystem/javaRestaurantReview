DROP TABLE t_review;
DROP TABLE m_restaurant;

/*--●aji_userで実行する（テーブル作成）-----------------*/
/* 店舗マスタ作成 */
CREATE TABLE m_restaurant (
  restaurant_id    INT          NOT NULL AUTO_INCREMENT,
  restaurant_name  VARCHAR(32)  NOT NULL,
  catch_phrase     VARCHAR(64)  NOT NULL,
  PRIMARY KEY(restaurant_id)
);

/* レビューテーブル作成 */
CREATE TABLE t_review (
  review_id        INT          NOT NULL AUTO_INCREMENT,
  restaurant_id    INT          NOT NULL,
  user_id          VARCHAR(16)  NOT NULL,
  visit_date       DATE         NOT NULL,
  rating           INT          NOT NULL,
  comment          VARCHAR(50)  NOT NULL,
  PRIMARY KEY(review_id),
  FOREIGN KEY(restaurant_id) REFERENCES m_restaurant (restaurant_id)
);
