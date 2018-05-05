package com.codeYudian.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.PreparedStatement;

import com.codeYudian.entity.Items;
import com.codeYudian.util.InitDB;;

public class ItemsDAO {

	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Items> list = new ArrayList<Items>();
		try {
			conn = InitDB.getConnection();
			String sql = "select * from items;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Items item = new Items();

				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));

				list.add(item);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {

				rs.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return list;

	}

	public Items getItemsById(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			conn = InitDB.getConnection();
			String sql = "select * from items where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;

			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			try {

				rs.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	public ArrayList<Items> getViewList(String list) {
		System.out.println("list:" + list);
		ArrayList<Items> itemlist = new ArrayList<Items>();
		int iCount = 5; // 每次返回前五条记录
		if (list != null && list.length() > 0) {
			String[] arr = list.split(",");
			System.out.println("arr.length=" + arr.length);
			// 如果商品记录大于等于5条
			if (arr.length >= 5) {
				for (int i = arr.length - 1; i >= arr.length - iCount; i--) {
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			} else {
				for (int i = arr.length - 1; i >= 0; i--) {
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemlist;
		} else {
			return null;
		}

	}

}
