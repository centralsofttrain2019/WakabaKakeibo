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
VALUES           (    1,   'pass', 'テスト太郎', 'Man','1990-05-12',      3000000,        100000, '2019-06-01',           3,            2,     'さん',NULL);
INSERT INTO users(UserID, Password,  UserName,    Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific, UserIcon)
VALUES           (    2,   'abcd', 'テスト花子','Woman','1999-06-07',       200000,           5000, '2019-06-05',         10,            5,    'ちゃん',NULL);

INSERT INTO products(ProductID,ProductName) VALUES (1,'パン');
INSERT INTO products(ProductID,ProductName) VALUES (2,'トイレットペーパー');
INSERT INTO products(ProductID,ProductName) VALUES (3,'ティッシュボックス');
INSERT INTO products(ProductID,ProductName) VALUES (4,'シャンプー');

INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (1,'食費');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (2,'日用品');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (3,'交通費');
INSERT INTO MoneyCategorys(moneycategorysID, categoryName) VALUES (4,'衣服');

INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          1,      1, '2019-06-05', 'Expense',          1,          1,                2,    300,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          2,      1, '2019-05-10', 'Expense',          4,          2,                1,    500,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          3,      1, '2019-05-17', 'Expense',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          4,      1, '2019-05-24', 'Expense',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          5,      1, '2019-05-31', 'Expense',          4,          2,                1,    500,                    7);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          6,      1, '2019-04-25', 'Expense',          2,          2,                1,    300,                 null);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          7,      1, '2019-05-09', 'Expense',          2,          2,                1,    300,                   14);
INSERT INTO MoneyNotes(MoneyNoteID, UserID, PurchaseDate,      type,  ProductID, CategoryID, NumberOfPurchase, Amount, PurchaseIntervalDays)
VALUES			      (          8,      1, '2019-05-23', 'Expense',          2,          2,                1,    300,                   14);


INSERT INTO PurchasePatterns(purchasepatternID, userID, productID, DatePatternType, LastPurchaseDate, NumberPattern, AmountPattern)
VALUES		                 (                  1,     1,         4,       'OneWeek',     '2019-05-31',             1,           300);


LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` VALUES (1,1,'2019-05-12 15:25:07','テスト１：BBQ','テスト1:バーベキュー行きました。','アウトドア',NULL,NULL,NULL),(2,2,'2019-05-30 13:22:02','テスト2:中間ミーティング','テスト2:中間ミーティングがありました。','ビジネス',NULL,NULL,NULL),(3,1,'2019-06-13 22:54:26','テスト3:宅呑み','テスト3：誰かの家で宅呑みします。','インドア',NULL,NULL,NULL);
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;


