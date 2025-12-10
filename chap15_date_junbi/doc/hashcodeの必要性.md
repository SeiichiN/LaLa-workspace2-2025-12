<style>
.my-text {
background-color: #f5f5f5;
padding: 10px;
margin-left: 30%;
}
</style>

<div class="my-text">
HashSetなどでは、hashCode()をオーバーライドしないと、equals()メソッドが
正しく動作しないことを説明するための、わかりやすいサンプルコードを書けますか？
</div>

---

はい、**hashCode() をオーバーライドしないと、HashSet が equals() だけでは正しく動作しない**ことを示す、短くてわかりやすいサンプルを作ります。

---

# ■ サンプルコード（NG例とOK例）

## ★ NG例：equals() だけオーバーライドして hashCode() をオーバーライドしない場合

```java
import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // equals だけ実装（これが原因で問題が起きる）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return Objects.equals(this.name, p.name);
    }

    // hashCode をオーバーライドしない → Object のものが使われる
}

public class Main {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();

        Person p1 = new Person("Taro");
        Person p2 = new Person("Taro");  // 中身は p1 と等しい

        set.add(p1);
        set.add(p2);

        System.out.println("要素数: " + set.size());   // 本来なら 1 のはず → 2 になってしまう
    }
}
```

---

### ■ なぜ 2 になってしまうのか？

* `equals()` は同じ値（name が "Taro"）なら true を返すようにしている
* しかし `hashCode()` をオーバーライドしていないため
  → p1 と p2 は **異なる hashCode を持つ**
* HashSet は
  **hashCode が違う時点で、そもそも equals() を呼ばない**
* 結果として別々のバケットに入ってしまい、重複だと判断できない

---

# ★ OK例：equals と hashCode の両方をオーバーライドする

```java
import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return Objects.equals(this.name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();

        Person p1 = new Person("Taro");
        Person p2 = new Person("Taro");  // equals は true

        set.add(p1);
        set.add(p2);

        System.out.println("要素数: " + set.size());  // 1 になる
    }
}
```

---

# ■ まとめ（説明用のポイント）

* HashSet は「hashCode → equals」の順で重複判定を行う
* equals が true でも、hashCode が違うと重複扱いされない
* そのため、equals をオーバーライドしたら
  **必ず hashCode もオーバーライドする必要がある**

---

必要なら、図解つきの説明バージョンや授業用スライド形式にもできますよ！

<!-- 修正時刻: Wed 2025/12/10 21:46:46 -->
