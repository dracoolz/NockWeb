package sogo;

public class Errcheck {

    // 商品データ登録時のエラーチェック
    public static String numCheck(int id, int kakaku) {
        String message = "";

        // IDまたは価格が数値以外の場合
        try {
            Integer.parseInt(String.valueOf(id));
            Integer.parseInt(String.valueOf(kakaku));
        } catch (NumberFormatException e) {
            message = "ID と価格には数字を入力してください";
        }

        // IDまたは価格がマイナスの場合
        if (id < 0 || kakaku < 0) {
            message = "ID と価格には整数を入力してください";
        }

        return message;
    }

    // IDが商品テーブルに存在するかチェック
    public static String exitId(String id) {
        String message = "";
        ShohinDAO dao = new ShohinDAO();
        ShohinBean bean = dao.jouken(id);
        if (bean != null) {
            message = "既に存在しています";
        } else {
            message = "";
        }

        return message;
    }

    // IDが商品テーブルに存在しないかチェック
    public static String notExitId(String id) {
        String message = "";
        ShohinDAO dao = new ShohinDAO();
        ShohinBean bean = dao.jouken(id);
        if (bean == null) {
            message = "対象データはありません";
        } else {
            message = "";
        }

        return message;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test numCheck method
        System.out.println("\nnumCheck : ");
        System.out.println(numCheck(1, 2));
        System.out.println(numCheck(-1, 2));
        System.out.println(numCheck(1, -2));
        System.out.println(numCheck(0, 2));

        // Test exitId method
        System.out.println("\nexitid : ");
        System.out.println(exitId("1"));
        System.out.println(exitId("00010"));

        // Test notExitId method
        System.out.println("\nnotexitid : ");
        System.out.println(notExitId("00001"));
        System.out.println(notExitId("11"));

    }
}
