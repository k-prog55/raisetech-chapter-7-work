# 概要
HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを実装しました。
リクエストの内容は以下のとおりです。
- GET/POST: 名前、ID、生年月日を取得、登録
- PATCH/DELETE: 名前の更新、削除

# 動作確認（Postman）
## GETリクエスト
### クエリ文字列を介して送付したid、名前、生年月日を取得するGETリクエスト
<img width="1039" alt="スクリーンショット 2023-08-13 7 55 20" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/821bd74c-feba-41a3-8011-47d439f1b58c">  

### クエリ文字列を介して送付したi複数のid、名前、生年月日を取得するGETリクエスト
<img width="1030" alt="スクリーンショット 2023-08-13 8 01 29" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/1c103673-52e2-428c-8ea1-114704923620">

### クエリ文字列を介して送付した名前を取得するGETリクエスト
<img width="1034" alt="スクリーンショット 2023-08-13 8 06 30" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/267263c8-acd7-48a4-affb-1a93686055fb">

### id、名前、生年月日を登録するPOSTリクエスト（nameが空文字、null、20文字以上の場合はエラーとする）
<img width="1034" alt="スクリーンショット 2023-08-13 8 10 32" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/3145274d-6893-4f92-a355-024cb52b9c8f">

### 名前を更新するPATCHリクエスト
<img width="1036" alt="スクリーンショット 2023-08-13 8 13 03" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/f55f1cfc-8244-4415-b235-9a4487c87c2e">

### 名前を削除するDELETEリクエスト
<img width="1042" alt="スクリーンショット 2023-08-13 8 14 46" src="https://github.com/k-prog55/raisetech-chapter-7-work/assets/138343132/a93719f5-d303-4463-8162-a784685cb38b">
