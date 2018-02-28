package cqh.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import cqh.dao.ProductDao;
import cqh.domain.ProductBean;
import cqh.utils.C3P0Utils;


public class ProductService {

	/**
	 * 
	 * @return
	 */
	public List<ProductBean> queryAll() {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDao();
		
		List<ProductBean> list = null;
		try {
			list = pd.queryAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProductBean queryId(int id) {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDao();
		ProductBean pb= null;
		try {
			pb = pd.queryId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pb;
	}

	/**
	 * 
	 * @param pb
	 * @return
	 */
	public boolean add(ProductBean pb) {
		// TODO Auto-generated method stub
		
		ProductDao pd = new ProductDao();
		boolean b = true;
		
		try {
			pd.add(pb);
			return b;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param pbu
	 * @return
	 */
	public boolean update(ProductBean pbu) {
		// TODO Auto-generated method stub
		ProductDao pdu = new ProductDao();
		boolean b = false;
		try {
			pdu.update(pbu);
			b = true;
			return b;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @param id
	 * @return 
	 */
	public boolean delId(int id) {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDao();
		boolean b = false;
		try {
			pd.delId(id);
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean delAll(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDao();
		boolean b = false;
		Connection con = C3P0Utils.getConnection();
		
		try {		
			con.setAutoCommit(false);
			
			for (Integer id : list) {
				pd.delAll(id);
			}
			b = true;
			DbUtils.commitAndCloseQuietly(con);		
		}catch (Exception e) {
			e.printStackTrace();
			DbUtils.rollbackAndCloseQuietly(con);
		}finally {
			C3P0Utils.removeThreadLocal();
		}
		
		return b;
	}

	/**
	 * 
	 * @param pageNum
	 * @param pageCount
	 * @return
	 */
	public List<ProductBean> queryPage(int pageNum, int pageCount) {
		// TODO Auto-generated method stub
		ProductDao pd = new ProductDao();
		List<ProductBean> list = null ;
		try {
			list= pd.queryPage(pageNum,pageCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}

}









