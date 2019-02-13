package zzc.com.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zzc.com.db.DbClose;
import zzc.com.db.DbConn;
import zzc.com.entity.Goods;

/**
 * 查询&&打印 函数工具
 * 
 * @author Jason Ceng
 * @date 2019年2月13日
 *
 */
public final class QueryPrint {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 模糊查询并陈列查询信息函数小工具
	 * 
	 * @param oper
	 * @return
	 */
	public static int query(String oper) {
		int gid = -1;
		String shopping = ScannerChoice.ScannerInfoString(); // 键盘获取商品名称
		ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(-1, shopping); // 根据键盘获取的商品名字調用
																					// 精确查询函数，確定用戶所要操作的数据
		if (goodsList == null || goodsList.size() <= 0) {
			System.err.println("\t！！查无此商品 ！！");
			ScannerChoice.changedInfoNext(oper); // 调用选择下一步函数
		} else {// 查到有此商品，实现进行 更改商品 信息操作！
			Goods goods = goodsList.get(0);
			System.out.println("\t\t\t\t\t商品列表\n\n");
			System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
			System.out.print("\t" + goods.getGid() + "\t\t" + goods.getGname() + "\t\t" + goods.getGprice() + "\t\t"
					+ goods.getGnum());
			if (goods.getGnum() == 0) {
				System.out.println("\t\t该商品已售空");
			} else if (goods.getGnum() < 10) {
				System.out.println("\t\t该商品已不足10件");
			} else {
				System.out.println("\t\t-");
			}
			gid = goods.getGid();// 将商品编号返回给调用者
		}
		return gid;
	}

	/**
	 * 根据商品gid或gname查询商品
	 * 
	 * @param gId
	 * @param gName
	 * @return
	 */
	public ArrayList<Goods> queryGoodsKey(int gId, String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "select * from goods where gid=? or gname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gId);
			pstmt.setString(2, gName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int gid = rs.getInt("gid");
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);

				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return goodsList;
	}
}
