package sogo;

import java.util.ArrayList;

public class Driver {
	public static void main(String args[]){
		//一覧表示呼び出し
		selectAll();
		//条件検索呼び出し
		jouken("00004");
		//項目を追加する
		insert("00011", "バナナ", 90);
		//項目を更新する
		update("00012", "魔法果物", 10000, "00001");
		//項目を削除する
		delete("00011");
	}

	//一覧表示
	public static void selectAll(){
		ShohinDAO dao = new ShohinDAO();
		ArrayList<ShohinBean> list = dao.selectAll();
		for(int i = 0; i<list.size();i++){
			System.out.print(list.get(i).getId()+",");
			System.out.print(list.get(i).getName()+",");
			System.out.println(list.get(i).getKakaku());
		}

		if(list.size()==0){
			System.out.println("条件に合致したデータは存在しません");
		}
	}

	//条件検索
	public static void jouken(String id) {
		ShohinDAO dao = new ShohinDAO();
		ShohinBean bean = dao.jouken(id);
		if (bean.getId() != null) {
			System.out.print(bean.getId() + ",");
			System.out.print(bean.getName() + ",");
			System.out.println(bean.getKakaku());
		} else {
			System.out.println("条件に合致したデータは存在しません");
		}
	}


	//項目を追加
	public static void insert(String id, String name, int kakaku) {
		ShohinDAO dao = new ShohinDAO();
		ShohinBean success = dao.insert(id, name, kakaku);
		if (success != null) {
			System.out.println("追加しました。");
		} else {
			System.out.println("追加できませんでした。");
		}
	}

	//項目を更新する
	public static void update(String id, String name, int kakaku, String idSearch) {
		ShohinDAO dao = new ShohinDAO();
		ShohinBean success = dao.update(id, name, kakaku, idSearch);
		if(success != null) {
			System.out.println("更新しました。");
		} else {
			System.out.println("変更できませんでした。");
		}
	}

	//項目を削除する
	public static void delete(String id) {
	    ShohinDAO dao = new ShohinDAO();
	    ShohinBean success = dao.delete(id);
	    if(success == null) {
	        System.out.println("削除しました。");
	    } else {
	        System.out.println("削除できませんでした。");
	    }
	}


}
