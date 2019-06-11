truncate table blogcomments;
truncate table bloglikes;
truncate table deposits;
truncate table favoriteusers;
truncate table messages;
truncate table quotenotes;
truncate table purchasepatterns;
delete from moneynotes where MoneyNoteID > 0;
delete from products where ProductID > 0;
delete from moneycategorys where MoneyCategorysID > 0;
delete from blogs where BlogID > 0;
delete from users where userID > 0;


INSERT INTO users(UserID, Password,  UserName,   Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific   ,UserIcon)
VALUES           (    1,   'pass', 'テスト太郎', 'MAN','1990-05-12',      3000000,        100000, '2019-06-01',           3,            2,     'さん',NULL);
INSERT INTO users(UserID, Password,  UserName,    Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific, UserIcon)
VALUES           (    2,   'abcd', 'テスト花子','WOMAN','1999-06-07',       200000,           5000, '2019-06-05',         10,            5,    'ちゃん',NULL);

INSERT INTO products(ProductID,ProductName) VALUES (1,'パン');
INSERT INTO products(ProductID,ProductName) VALUES (2,'トイレットペーパー');
INSERT INTO products(ProductID,ProductName) VALUES (3,'ティッシュボックス');
INSERT INTO products(ProductID,ProductName) VALUES (4,'シャンプー');

INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (1,'おはよう like', 'LIKE', 'MORNING');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (2,'おはよう normal', 'NORMAL', 'MORNING');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (3,'おはよう dislike', 'DISLIKE', 'MORNING');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (4,'こんにちは like', 'LIKE', 'NOON');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (5,'こんにちは normal', 'NORMAL', 'NOON');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (6,'こんにちは dislike', 'DISLIKE', 'NOON');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (7,'こんばんわ like', 'LIKE', 'NIGHT');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (8,'こんばんわ normal', 'NORMAL', 'NIGHT');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (9,'こんばんわ dislike', 'DISLIKE', 'NIGHT');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (10,'誕生日おめでとう like', 'LIKE', 'BIRTHDAY');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (11,'誕生日おめでとう normal', 'NORMAL', 'BIRTHDAY');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (12,'誕生日おめでとう dislike', 'DISLIKE', 'BIRTHDAY');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (13,'復元漏れがあるよ like', 'LIKE', 'RECONSTRUCT');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (14,'復元漏れがあるよ normal', 'NORMAL', 'RECONSTRUCT');
INSERT INTO messages(MessageID,MessageContent,MessageType,EventType) VALUES (15,'復元漏れがあるよ dislike', 'DISLIKE', 'RECONSTRUCT');

INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (1,'食費');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (2,'日用品');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (3,'交通費');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (4,'衣服');

INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          1,      1, '2019-06-05', 'EXPENSE',          1,          1,                2,    300,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          2,      1, '2019-05-10', 'EXPENSE',          4,          2,                1,    500,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          3,      1, '2019-05-17', 'EXPENSE',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          4,      1, '2019-05-24', 'EXPENSE',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          5,      1, '2019-05-31', 'EXPENSE',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          6,      1, '2019-04-25', 'EXPENSE',          2,          2,                1,    300,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          7,      1, '2019-05-09', 'EXPENSE',          2,          2,                1,    300,                   14);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          8,      1, '2019-05-23', 'EXPENSE',          2,          2,                1,    300,                   14);


INSERT INTO PurchasePatterns(purchasepatternID, userID, productID, DatePatternType, LastPurchaseDate, NumberPattern, AmountPattern)
VALUES		                 (                  1,     1,         4,       'ONEWEEK',     '2019-05-31',             1,           300);

INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	1	,'2019-04-01'	,	10000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	2	,'2019-05-01'	,	30000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	3	,'2019-06-01'	,	40000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	4	,'2019-07-01'	,	50000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	5	,'2019-08-01'	,	90000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	6	,'2019-09-01'	,	110000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	7	,'2019-10-01'	,	120000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	8	,'2019-11-01'	,	130000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	9	,'2019-12-01'	,	140000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	10	,'2020-01-01'	,	190000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	11	,'2020-02-01'	,	200000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	12	,'2019-05-01'	,	200000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	13	,'2019-04-01'	,	210000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	14	,'2019-05-01'	,	230000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	15	,'2019-04-01'	,	240000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	16	,'2019-05-01'	,	260000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	17	,'2019-04-01'	,	310000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	18	,'2019-05-01'	,	320000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	19	,'2019-04-01'	,	340000	,	1	);
INSERT INTO deposits(DepositID, Date, Balance, UserID) VALUES (	20	,'2019-05-01'	,	350000	,	1	);


LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` VALUES (1,1,'2019-05-12 15:25:07','テスト１：BBQ','テスト1:バーベキュー行きました。','OUTDOOR',NULL,NULL,NULL),(2,2,'2019-05-30 13:22:02','テスト2:中間ミーティング','テスト2:中間ミーティングがありました。','BUSINESS',NULL,NULL,NULL),(3,1,'2019-06-13 22:54:26','テスト3:宅呑み','テスト3：誰かの家で宅呑みします。','FOODS',NULL,NULL,NULL);
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;


