package set_sample;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {

        // Set（HashSet）を作成
        Set<String> fruits = new HashSet<>();

        // 要素を追加
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // ← 2回追加しても重複は入らない

        // Set の内容を表示
        System.out.println("Setの中身: " + fruits);

        // 要素が含まれているか確認
        System.out.println("Banana はある？: " + fruits.contains("Banana"));

        // 要素を削除
        fruits.remove("Orange");
        System.out.println("Orange を削除後: " + fruits);

        // 拡張for文で全要素をループ
        System.out.println("1つずつ表示:");
        for (String fruit : fruits) {
            System.out.println(" - " + fruit);
        }
    }
}

