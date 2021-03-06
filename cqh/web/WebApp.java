package cqh.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cqh.domain.ProductBean;
import cqh.service.ProductService;

public class WebApp {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("欢迎使用要你命3000系统!");
		
		
		while (true) {
			System.out.println("请输入以下命令操作");
			System.out.println("c：创建\nu：修改\nd：删除\nda：删除一组\ni：通过id查询\nfa：查询所有\nq:退出\n"
					+ "p:分页\ncd:不要碰!!!");
			String choise = sc.nextLine();
			switch (choise) {
			case "c":
				add();
				break;
			case "u":
				update();
				break;
			case "d":
				delId();
				break;
			case "da":
				delAll();
				break;
			case "i":
				queryId();
				break;
			case "fa":
				queryAll();
				break;
			case "q":
				System.out.println("欢迎下次使用");
				System.exit(0);
			case "p":
				queryPage();
				break;
			case "cd":
				doNotTouch();
				break;
			default:
				System.out.println("输入正确的指令");
				break;
			}
		}
	}
	

	/**
	 * 分页
	 */
	private static void queryPage() {
		// TODO Auto-generated method stub
		System.out.println("输入要查询的页数");
		int pageNum = Integer.valueOf(sc.nextLine());
		int pageCount = 4;
		
		ProductService ps = new ProductService();
		List<ProductBean> list = ps.queryPage(pageNum,pageCount);
		
		if (list.size() == 0) {
			System.out.println("没有更多数据!");
		}else {
			for (ProductBean pb : list) {
				System.out.println(pb);
			}
		}
		
	}

	/**
	 * 根据id删除一组数据
	 */
	private static void delAll() {
		// TODO Auto-generated method stub
		System.out.println("批量删除模式,输入 0 确定");
		ArrayList<Integer> list = new ArrayList<Integer>();
		ProductService ps = new ProductService();
		
		while (true) {
			System.out.println("输入删除的id");
			int id = Integer.valueOf(sc.nextLine());
			
			if (id == 0) {
				System.out.println("输入结束");
				break;
			}
			ProductBean pb = ps.queryId(id);
			if (pb == null) {
				System.out.println("该商品不存在!");
			}else {
				System.out.println("已确认删除的商品"+pb);
				list.add(id);
			}
			
		}
		
		System.out.println("最后确认是否删除"+list.size()+"个商品? y/是 ");
		String choise = sc.nextLine();
		
		if (choise.equalsIgnoreCase("y")) {
			boolean b = ps.delAll(list);
			if (b) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		}else {
			System.out.println("取消删除");
		}
		
	}
	
	/**
	 * 根据id删除
	 */
	private static void delId() {
		// TODO Auto-generated method stub
		System.out.println("输入要删除的ID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService(); 
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("无此商品");
		}else {
			System.out.println(pb);
			System.out.println("是否确定删除?(y/是 n/否)");
			
			String choise = sc.nextLine();
			
			if (choise.equalsIgnoreCase("y")) {
				boolean b = ps.delId(id);
				if (b) {
					System.out.println("删除成功");
				}else {
					System.out.println("删除失败");
				}
			}else {
				System.out.println("取消删除");
			}
		}
	}
	
	/**
	 * 修改商品信息
	 */
	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("输入要修改的商品ID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService();
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("暂无");
		}else {
			System.out.println(pb);
			System.out.println("输入修改的商品名称");
			String pname = sc.nextLine();
			System.out.println("输入修改的商品价格");
			int price = Integer.valueOf(sc.nextLine());
			
			ProductBean pbu = new ProductBean(id,pname,price,"c001");
			
			//ProductService psu = new ProductService();
			boolean b = ps.update(pbu);
			
			if (b) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");				
			}
					
		}
		
	}

	/**
	 * 查询全部
	 */
	public static void queryAll() {
		ProductService ps = new ProductService();
		List<ProductBean> list = ps.queryAll();
		
		for (ProductBean p:list) {
			System.out.println(p);
		}
	}
	
	/**
	 * 根据id查询
	 */
	public static void queryId() {
		
		System.out.println("输入ID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService();
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("暂无");
		}else {
			System.out.println(pb);
		}
	}
	/**
	 * 添加商品
	 */
	public static void add() {
		
		System.out.println("输入商品名称");
		String pname = sc.nextLine();
		System.out.println("输入商品价格");
		int price = Integer.valueOf(sc.nextLine());
		
		
		ProductService ps = new ProductService();
		
		ProductBean pb = new ProductBean();
		pb.setPname(pname);
		pb.setPrice(price);
		
		boolean b = ps.add(pb);
		
		if (b) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	private static void doNotTouch() {
		// TODO Auto-generated method stub
		System.out.println("/**\r\n" + 
				" * /**\r\n" + 
				" *                    _ooOoo_\r\n" + 
				" *                   o8888888o\r\n" + 
				" *                   88\" . \"88\r\n" + 
				" *                   (| -_- |)\r\n" + 
				" *                    O\\ = /O\r\n" + 
				" *                ____/`---'\\____\r\n" + 
				" *              .   ' \\\\| |// `.\r\n" + 
				" *               / \\\\||| : |||// \\\r\n" + 
				" *             / _||||| -:- |||||- \\\r\n" + 
				" *               | | \\\\\\ - /// | |\r\n" + 
				" *             | \\_| ''\\---/'' | |\r\n" + 
				" *              \\ .-\\__ `-` ___/-. /\r\n" + 
				" *           ___`. .' /--.--\\ `. . __\r\n" + 
				" *        .\"\" '< `.___\\_<|>_/___.' >'\"\".\r\n" + 
				" *       | | : `- \\`.;`\\ _ /`;.`/ - ` : | |\r\n" + 
				" *         \\ \\ `-. \\_ __\\ /__ _/ .-` / /\r\n" + 
				" * ======`-.____`-.___\\_____/___.-`____.-'======\r\n" + 
				" *                    `=---='\r\n" + 
				" *\r\n" + 
				" * .............................................\r\n" + 
				" *          佛祖保佑             永无BUG\r\n" + 
				" */\r\n" + 
				"");
	}
}

/**
 * /**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */

 










