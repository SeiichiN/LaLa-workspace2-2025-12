<style>
.my-text {
background-color: #f5f5f5;
padding: 10px;
margin-left: 30%;
}
</style>
<div class="my-text">
Java21で、Mapを使った初心者向けのサンプルプログラムを作れますか？
</div>

---

はい！Java 21 で **Map（主に HashMap）** を使った、初心者向けのわかりやすいサンプルプログラムを作れます。

以下は、

* **果物の値段を Map に登録する**
* **ユーザーが果物名を入力すると、値段を表示する**
  というシンプルな例です。

---

# 🍎 Java21 / Map を使った初心者向けサンプル

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapSample {
    public static void main(String[] args) {
        // 果物の名前と値段を管理する Map
        Map<String, Integer> priceMap = new HashMap<>();

        // Map に値を登録
        priceMap.put("apple", 120);
        priceMap.put("banana", 98);
        priceMap.put("orange", 150);

        // ユーザー入力用 Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("果物名を入力してください（apple / banana / orange）：");
        String fruit = sc.nextLine().toLowerCase();

        // Map にキーが存在するか？
        if (priceMap.containsKey(fruit)) {
            int price = priceMap.get(fruit);
            System.out.println(fruit + " の値段は " + price + " 円です。");
        } else {
            System.out.println("その果物は登録されていません。");
        }

        sc.close();
    }
}
```

---

# 💡 プログラムのポイント

### ■ Map の作成

```java
Map<String, Integer> priceMap = new HashMap<>();
```

* `<String, Integer>` は、**キーが文字列、値が整数**という意味。

### ■ 値の登録（put）

```java
priceMap.put("apple", 120);
```

### ■ キーが存在するかチェック（containsKey）

```java
priceMap.containsKey(fruit)
```

### ■ 値を取り出す（get）

```java
priceMap.get(fruit)
```

---

# 📌 応用例（簡単に追加可能）

* Map にもっと果物を追加する
* ループして複数回検索できるようにする
* 値段だけでなく「在庫数」など複数の値を Map に持たせる
* Map<String, List<String>> のように、値にリストを持たせる

---

必要なら、

* **拡張版**
* **クラスを使った本格的 Map 例**
* **Enum × Map の例**
  なども作れます。

続き、作りましょうか？
