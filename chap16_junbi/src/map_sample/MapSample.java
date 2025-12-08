package map_sample;

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

