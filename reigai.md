SimpleDateFormatクラスのparseメソッドはチェック例外
だけど、DateTimeFormatterクラスのparseメソッドは
Runtime例外なのは、なぜですか？

---

理由を一言でまとめると **「API設計思想と歴史の違い（新旧APIの違い）」** です。

以下で分かりやすく説明します。

---

# ? 結論

* **SimpleDateFormat（旧API）**

  * Java初期（JDK1.1の1997年頃）に作られた。
  * 当時の Java API は「入力エラーはチェック例外で通知する」方針が一般的だった。
  * よって `parse()` は **checked exception（ParseException）** を投げる。

* **DateTimeFormatter（新API, Java 8?）**

  * 新しい日付 API（JSR-310）は「エラーは unchecked（RuntimeException） にすべき」というモダンな方針で設計された。
  * そのため `parse()` は **unchecked exception（DateTimeParseException）** を投げる。

---

# ? もう少し詳しく

## 1. SimpleDateFormat は古く、設計が古い

* 1997年、Java が今ほど洗練されていなかった時代の API。
* チェック例外が多用されており

  > 問題が起きそうなら、とりあえず checked exception にしよう
  > という文化があった。

→ そのため `parse()` は **ParseException（checked）** を強制的に try-catch で処理する仕様。

---

## 2. 新しい Date and Time API（JSR-310）は設計方針が完全に違う

Java 8（2014年）で導入された新 API は、明確に次の方針を採用しました：

### ? “使用者に不要な強制 try-catch をさせない”

* エラーが発生しても強制的に捕捉させる必要はない
* 多くのエラーは “Programming mistake（プログラムの書き方が間違ってるだけ）” と位置づけた

→ そのため **RuntimeException 派生の DateTimeParseException** を採用。

### ? 実際、フォーマットエラーは「回復不能エラー」

* `"2025/13/40"` のような入力が来たらどうしようもない
* その場で対処するより、呼び出し側に判断させる方が自然
* webアプリやAPIでは validation エラーとして扱うのが主流

→ checked にするより unchecked の方が“自然”という判断。

---

## 3. API の一貫性

* 新APIの方は **immutable** & **thread-safe**
* 入出力エラーはそれほど “重要な復旧可能エラー” とは見なされない
* 結果として
  **DateTimeParseException（Runtime）** が妥当という結論になった。

---

# ? まとめ（超要約）

| API               | 時代          | parse の例外                         | 理由                         |
| ----------------- | ----------- | --------------------------------- | -------------------------- |
| SimpleDateFormat  | 古い（Java1.1） | checked（ParseException）           | 当時の設計文化（checked 多用）        |
| DateTimeFormatter | 新しい（Java8?） | unchecked（DateTimeParseException） | モダン設計。不要な try-catch を強制しない |

---

# ? 補足：実務ではどちらを使うべき？

**100% DateTimeFormatter** を使うべきです。
SimpleDateFormat は

* 非スレッドセーフ
* 古い
* バグを生みやすい
  ため、実務での利用は非推奨。

---

必要であれば

* 両者の動作比較コード
* DateTimeParseException のカスタムメッセージ例
* パース失敗を事前にチェックする方法
  なども紹介できます。
