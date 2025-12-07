<style>
.my-text {
background-color: #f5f5f5;
padding: 10px;
margin-left: 30%;
}
</style>

<div class="my-text">
次のようなメソッドを書きました。
```
public static Date getDate(String dateTxt) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	sdf.setLenient(false);
	try {
		return sdf.parse(dateTxt);
	} catch (ParseException e) {
		System.out.println("正しい日付を入力してください");
		return null;
	}
}
```
sdf.parse(dateTxt) が例外を発生せず、null を返す場合があるとききましたが、本当でしょうか？
また、それはどのような場合なんでしょうか？
</div>

---

結論から言うと、

### **✔ `SimpleDateFormat#parse()` が例外を出さずに `null` を返すことはありません。**

`parse()` は以下のように **必ず `Date` を返すか、`ParseException` を投げる** という仕様です。

---

# ■ 公式仕様（Java 21 でも同じ）

`java.text.DateFormat#parse(String source)` の仕様では：

* パースに成功したら `Date` を返す
* パースできない場合は **`ParseException` をスロー**
* **`null` を返すとは明記されていないし、実装上もそのようになっていない**

OpenJDK の `SimpleDateFormat#parse` の内部はこうなっています（簡略化）：

```java
public Date parse(String text) throws ParseException {
    ParsePosition pos = new ParsePosition(0);
    Date date = parse(text, pos);
    if (pos.getIndex() == 0) {
        throw new ParseException("Unparseable date", pos.getErrorIndex());
    }
    return date;
}
```

ここで分かる通り、

* `parse(text, pos)` は内部メソッドで、失敗すると **`null` を返す** ことはある
* しかし `parse(String)` のほうでは **pos.getIndex() == 0 をチェックし、必ず例外を投げる**

つまり **利用者が呼ぶ通常の `parse(String)` では null は返らない** 仕様です。

---

# ■ 「null が返る」と誤解されやすいケース

### ❶ `parse(String, ParsePosition)` を使った場合は null が返る

こちらは null を返す可能性があります。

```java
ParsePosition pos = new ParsePosition(0);
Date d = sdf.parse("aaaa", pos);
System.out.println(d);  // null
```

このメソッドは例外を投げず、null を返すことがあります。
この挙動が混同され「parse は null を返す」という誤解が生まれやすいです。

---

### ❷ lenient(true) にしていると、変な日付でも例外を投げない

例：

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
sdf.setLenient(true);

Date d = sdf.parse("2025/13/40");  // 例外なし
```

ただしこの場合でも **null は返りません**。
内部的に補正されて「正しい日に変換」されます (例：翌年の日付)。

---

# ■ まとめ

### ❌ `SimpleDateFormat#parse(String)` が null を返す → **間違い**

### ✔ パース失敗 → 必ず `ParseException`

### ✔ null を返すのは `parse(String, ParsePosition)` のほう

---

必要であれば「パース成功か失敗かを boolean で返す安全なメソッド」を作る形にも書き直せますので、言っていただければサンプルを作ります！
