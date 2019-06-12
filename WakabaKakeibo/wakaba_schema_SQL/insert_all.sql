truncate table blogcomments;
ALTER TABLE blogcomments auto_increment = 1;
truncate table bloglikes;
ALTER TABLE bloglikes auto_increment = 1;
truncate table deposits;
ALTER TABLE deposits auto_increment = 1;
truncate table favoriteusers;
ALTER TABLE favoriteusers auto_increment = 1;
truncate table messages;
truncate table quotenotes;
ALTER TABLE quotenotes auto_increment = 1;
truncate table purchasepatterns;
ALTER TABLE purchasepatterns auto_increment = 1;
delete from moneynotes where MoneyNoteID > 0;
ALTER TABLE moneynotes auto_increment = 1;
delete from products where ProductID > 0;
delete from moneycategorys where MoneyCategorysID > 0;
delete from blogs where BlogID > 0;
ALTER TABLE blogs auto_increment = 1;
delete from users where userID > 0;

INSERT INTO users
(UserID, Password,  UserName,    Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific, UserIcon) VALUES
(     1,   'pass', 'テスト太郎',  'MAN','1990-05-12',      3000000,        100000, '2019-06-01',           3,            2,     'さん',     NULL),
(     2,   'abcd', 'テスト花子','WOMAN','1999-06-07',       200000,          5000, '2019-06-05',          10,            5,    'ちゃん',     NULL);

INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES
(1,'おはよう like', 'LIKE', 'MORNING'),
(2,'おはよう normal', 'NORMAL', 'MORNING'),
(3,'おはよう dislike', 'DISLIKE', 'MORNING'),
(4,'こんにちは like', 'LIKE', 'NOON'),
(5,'こんにちは normal', 'NORMAL', 'NOON'),
(6,'こんにちは dislike', 'DISLIKE', 'NOON'),
(7,'こんばんわ like', 'LIKE', 'NIGHT'),
(8,'こんばんわ normal', 'NORMAL', 'NIGHT'),
(9,'こんばんわ dislike', 'DISLIKE', 'NIGHT'),
(10,'誕生日おめでとう like', 'LIKE', 'BIRTHDAY'),
(11,'誕生日おめでとう normal', 'NORMAL', 'BIRTHDAY'),
(12,'誕生日おめでとう dislike', 'DISLIKE', 'BIRTHDAY'),
(13,'復元漏れがあるよ like', 'LIKE', 'RECONSTRUCT'),
(14,'復元漏れがあるよ normal', 'NORMAL', 'RECONSTRUCT'),
(15,'復元漏れがあるよ dislike', 'DISLIKE', 'RECONSTRUCT');

INSERT INTO products(ProductID,ProductName) VALUES
(101,'パン'),
(102,'おにぎり'),
(103,'卵'),
(201,'トイレットペーパー'),
(202,'ティッシュボックス'),
(203,'シャンプー'),
(401,'洋服');

INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES
(11,'食費'),
(12,'日用品'),
(13,'交通費'),
(14,'衣服'),
(21,'給与'),
(22,'おこづかい');

INSERT INTO MoneyNotes
( UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays) VALUES
(      1, '2019-06-05', 'EXPENSE',        101,         11,                1,    300,                 null),
(      1, '2019-05-10', 'EXPENSE',        103,         11,                2,    200,                 null),
(      1, '2019-05-17', 'EXPENSE',        103,         11,                2,    200,                    7),
(      1, '2019-05-24', 'EXPENSE',        103,         11,                2,    200,                    7),
(      1, '2019-05-31', 'EXPENSE',        103,         11,                2,    200,                    7),
(      1, '2019-04-25', 'EXPENSE',        202,         12,                1,    300,                 null),
(      1, '2019-05-09', 'EXPENSE',        202,         12,                1,    300,                   14),
(      1, '2019-05-23', 'EXPENSE',        202,         12,                1,    300,                   14),
(      1, '2019-04-25', 'EXPENSE',        202,         12,                1,    300,                   14),
(      1, '2019-06-02', 'EXPENSE',        401,         14,                1,   6000,                 null),
(      1, '2019-03-25',  'INCOME',       null,         21,                1, 300000,                 null),
(      1, '2019-04-25',  'INCOME',       null,         21,                1, 300000,                   31),
(      1, '2019-05-25',  'INCOME',       null,         21,                1, 300000,                   30),
(      1, '2019-05-25',  'INCOME',       null,         22,                1,   5000,                 null);

INSERT INTO PurchasePatterns
( userID, productID, DatePatternType, LastPurchaseDate, NumberPattern, AmountPattern) VALUES
(    1,        103,       'ONEWEEK',     '2019-05-31',             2,          200),
(    1,        202,      'TWOWEEKS',     '2019-05-31',             1,          300);

INSERT INTO deposits(Date, Balance, UserID) VALUES
('2019-04-01'	,	10000	,	1	),
('2019-05-01'	,	30000	,	1	),
('2019-06-01'	,	40000	,	1	),
('2019-07-01'	,	50000	,	1	),
('2019-08-01'	,	90000	,	1	),
('2019-09-01'	,	110000	,	1	),
('2019-10-01'	,	120000	,	1	),
('2019-11-01'	,	130000	,	1	),
('2019-12-01'	,	140000	,	1	),
('2020-01-01'	,	190000	,	1	),
('2020-02-01'	,	200000	,	1	),
('2020-03-01'	,	200000	,	1	),
('2020-04-01'	,	210000	,	1	),
('2020-05-01'	,	230000	,	1	),
('2020-06-01'	,	240000	,	1	),
('2020-07-01'	,	260000	,	1	),
('2020-08-01'	,	310000	,	1	),
('2020-09-01'	,	320000	,	1	),
('2020-10-01'	,	340000	,	1	),
('2020-11-01'	,	350000	,	1	);

INSERT INTO blogs
(userID,           createDate,              title,                     content,   category, image1, image2, reblogID) VALUES
(     1,'2019-05-12 15:25:07',         'テスト１：BBQ',    'テスト1:バーベキュー行きました。',  'OUTDOOR',   NULL,   NULL,     NULL),
(     2,'2019-05-30 13:22:02', 'テスト2:中間ミーティング', 'テスト2:中間ミーティングがありました。', 'BUSINESS',   NULL,   NULL,     NULL),
(     1,'2019-06-13 22:54:26',       'テスト3:宅呑み',   'テスト3：誰かの家で宅呑みします。',    'FOODS',   NULL,   NULL,     NULL);
