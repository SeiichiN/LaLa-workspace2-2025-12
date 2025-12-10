<style>
.my-text {
background-color: #f5f5f5;
padding: 10px;
margin-left: 30%;
}
</style>
<div class="my-text">
Java21で、次のようなPersonクラスを使ったHashMapのサンプルプログラムが作れますか？
一覧表示の仕方も知りたいです。
```
public class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof Person p) {
			return this.name.equals(p.name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
```
</div>

---

以下は **Java 21** で書ける、あなたの `Person` クラスをキーとして使う **HashMap のサンプルプログラム** です。
一覧表示の方法も複数紹介しています。

---

# ✅ HashMap を使ったサンプルプログラム（Java 21）

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Mapの作成（キー：Person、値：年齢などの情報）
        Map<Person, Integer> map = new HashMap<>();

        // データ追加
        map.put(new Person("Alice"), 20);
        map.put(new Person("Bob"), 25);

        // 同じ名前のPersonは equals/hashCode により同一キー扱い
        map.put(new Person("Alice"), 30);  // 上書きされる

        // 特定のキーで取得
        Integer age = map.get(new Person("Alice"));
        System.out.println("Alice の年齢: " + age);

        System.out.println("\n--- 一覧表示1: entrySet() を使う ---");
        for (Map.Entry<Person, Integer> entry : map.entrySet()) {
            System.out.println("名前: " + entry.getKey().name +
                               ", 年齢: " + entry.getValue());
        }

        System.out.println("\n--- 一覧表示2: forEach を使う（ラムダ） ---");
        map.forEach((person, value) ->
            System.out.println("名前: " + person.name + ", 年齢: " + value)
        );

        System.out.println("\n--- 一覧表示3: keySet と get を使う ---");
        for (Person person : map.keySet()) {
            Integer v = map.get(person);
            System.out.println("名前: " + person.name + ", 年齢: " + v);
        }
    }
}
```

---

# 📌 実行結果イメージ

```
Alice の年齢: 30

--- 一覧表示1: entrySet() を使う ---
名前: Alice, 年齢: 30
名前: Bob, 年齢: 25

--- 一覧表示2: forEach を使う（ラムダ） ---
名前: Alice, 年齢: 30
名前: Bob, 年齢: 25

--- 一覧表示3: keySet と get を使う ---
名前: Alice, 年齢: 30
名前: Bob, 年齢: 25
```

---

# 🔍 補足：equals/hashCode が効いている理由

あなたの `Person` は名前が同じなら同一とみなすようになっています。

```java
new Person("Alice")
new Person("Alice")
```

これらは `equals()` が true になり、`hashCode()` も同じなので
HashMap では同じキーとして扱われ、値が上書きされます。

---

必要なら以下も作れます：

* `Person` をキーではなく値にしたサンプル
* `TreeMap` 版（比較可能にする）
* 一覧表示を表形式にする
* 名前以外のフィールド（id、歳など）を追加

気軽に言ってください！
