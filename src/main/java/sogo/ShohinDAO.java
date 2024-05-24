package sogo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShohinDAO extends DBAccess {

	//List all
	public ArrayList<ShohinBean> selectAll() {

		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();

		// SQL文を作成する
		String sql = "SELECT * FROM shohin";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				ShohinBean bean = new ShohinBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setKakaku(rs.getInt("kakaku"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	
	//Create new data
	public ShohinBean insert(String id, String name, int kakaku) {
	    ShohinBean bean = new ShohinBean();

	    String sql = "INSERT INTO shohin(id, name, kakaku) VALUES (?, ?, ?)";

	    try {
	        connect();
	        // ステートメントの作成
	        PreparedStatement ps = getConnection().prepareStatement(sql);
	        ps.setString(1, id);
	        ps.setString(2, name);
	        ps.setInt(3, kakaku);
	        // SQLの実行
	        // 結果の取得
	        int rs = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }

	    return bean;
	}


	//Search by ID
	public ShohinBean jouken(String id) {

		ShohinBean bean = new ShohinBean();

		// SQL文を作成する
		String sql = "SELECT id,name,kakaku FROM shohin WHERE id = ?";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setKakaku(rs.getInt("kakaku"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bean;
	}


	//Update by ID
	public ShohinBean update(String id, String name, int kakaku, String idSearch) {
		
		ShohinBean bean = new ShohinBean();
		
		// SQL文を作成する
		String sql = "UPDATE shohin SET id = ?, name = ? , kakaku= ? WHERE id = ?";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, kakaku);
			ps.setString(4, idSearch);
			// SQLを発行する
			int rs = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bean;

	}


	//Delete by ID
	public ShohinBean delete(String id) {
	    String sql = "DELETE FROM shohin WHERE id = ?";
	    
	    try {
	        connect();
	        PreparedStatement ps = getConnection().prepareStatement(sql);
	        ps.setString(1, id);
	        int rs = ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	}
}
