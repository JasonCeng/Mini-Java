package cn.jason.gjp.service;

import java.util.List;

import cn.jason.gjp.dao.ZhangWuDao;
import cn.jason.gjp.domain.ZhangWu;

/**
 * 账务业务层类
 * 
 * @author Jason Ceng
 * @date 2019年2月23日
 *
 */
public class ZhangWuService {
	// service都依赖dao
	private ZhangWuDao zhangWuDao = new ZhangWuDao();

	/**
	 * 查询所有账务信息
	 * 
	 * @return
	 */
	public List<ZhangWu> selectAll() {
		return zhangWuDao.selectAll();
	}

	/**
	 * 根据时间范围查询账务信息
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ZhangWu> select(String start, String end) {
		return zhangWuDao.select(start, end);
	}

	/**
	 * 添加账务
	 * 
	 * @param zw
	 */
	public void addZhangWu(ZhangWu zw) {
		zhangWuDao.addZhangWu(zw);

	}

	/**
	 * 编辑账务
	 * 
	 * @param zw
	 */
	public void editZhangWu(ZhangWu zw) {
		zhangWuDao.editZhangWu(zw);

	}

	/**
	 * 删除账务
	 * 
	 * @param nextInt
	 */
	public void deleteZhangWu(int zwid) {
		zhangWuDao.deleteZhangWu(zwid);

	}
}
