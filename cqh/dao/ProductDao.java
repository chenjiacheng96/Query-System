package cqh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cqh.domain.ProductBean;
import cqh.utils.C3P0Utils;

public class ProductDao {

	public List<ProductBean> queryAll() throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product";
		
		List<ProductBean> list = qr.query(sql, new BeanListHandler<ProductBean>(ProductBean.class));
		return list;
	}

	public ProductBean queryId(int id) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "Select * from product where pid = ?";
		
		ProductBean pb = qr.query(sql, new BeanHandler<ProductBean>(ProductBean.class), id);
		return pb;
	}

	public void add(ProductBean pb) throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "insert into product values(?,?,?,?)";
		
		qr.update(sql, null,pb.getPname(),pb.getPrice(),"c001");
	}

	public void update(ProductBean pbu) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "update product set pname = ?,price = ? where pid = ?";
		
		Object [] params = {pbu.getPname(),pbu.getPrice(),pbu.getPid()};
		qr.update(sql,params);
		
	}

	public void delId(int id) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "delete from product where pid = ?";
		
		qr.update(sql, id);
	}

	public void delAll(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		
		Connection con = C3P0Utils.getConnection();
		
		String sql = "delete from product where pid = ?";
		
		qr.update(con, sql, sql);
	}

	public List<ProductBean> queryPage(int pageNum, int pageCount) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product limit ?,?";
		
		List<ProductBean> list = qr.query(sql, new BeanListHandler<ProductBean>(ProductBean.class), 
				(pageNum-1)*pageCount,pageCount);
		return list;
	}

}

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 *  O\ = /O
 * ___/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '< `.___\_<|>_/___.' >'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 *          .............................................
 *           ·ðÔ»£ºbug·ºÀÄ£¬ÎÒÒÑÌ±»¾£¡
 */









