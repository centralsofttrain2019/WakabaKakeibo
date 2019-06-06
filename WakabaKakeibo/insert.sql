INSERT INTO users(UserID, Password,  UserName,   Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific) 
VALUES (    1,   'pass', 'テスト太郎', 'Man','1990-05-12',      3000000,        100000, '2019-06-01',           3,            2,     'さん');
INSERT INTO users(UserID, Password,  UserName,    Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific) 
VALUES (    2,   'abcd', 'テスト花子','Woman','1999-06-07',       200000,           5000, '2019-06-05',         10,            5,    'ちゃん');
INSERT INTO users(UserID, Password,  UserName,    Sex,    Birthday, TargetAmount, PresentAmount,    LastLogin, RunningDays, FeelingLevel, Honorific) 
VALUES    (    2,   'abcd', 'テスト花子','Woman','1999-06-07',       200000,           5000, '2019-06-05',         10,            5,    'ちゃん');

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


