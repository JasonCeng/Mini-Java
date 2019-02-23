package cn.jason.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.jason.gjp.domain.ZhangWu;
import cn.jason.gjp.tools.JDBCUtils;

/**
 * 账务数据层类
 * 
 * @author Jason Ceng
 * @date 2019年2月23日
 *
 */
public class ZhangWuDao {
	// 获取数据库连接池，得到操作表数据的对象QueryRunner
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 查询所有账务信息
	 * 
	 * @return
	 */
	public List<ZhangWu> selectAll() {
		String sql = "select * from gjp_zhangwu";
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据时间范围查询账务信息
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ZhangWu> select(String start, String end) {
		String sql = "select * from gjp_zhangwu where createtime between ? and ?";
		Object[] params = { start, end };
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加账务
	 * 
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zw) {
		String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";
		try {
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(),
					zw.getDescription() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 编辑账务
	 * 
	 * @param zw
	 */
	public void editZhangWu(ZhangWu zw) {
		String sql = "update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		try {
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(), zw.getDescription(),
					zw.getZwid() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除账务
	 * 
	 * @param zwid
	 */
	public void deleteZhangWu(int zwid) {
		String sql = "delete from gjp_zhangwu where zwid=?";
		try {
			qr.update(sql, zwid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}