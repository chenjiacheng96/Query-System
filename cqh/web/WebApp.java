package cqh.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cqh.domain.ProductBean;
import cqh.service.ProductService;

public class WebApp {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("��ӭʹ��Ҫ����3000ϵͳ!");
		
		
		while (true) {
			System.out.println("�����������������");
			System.out.println("c������\nu���޸�\nd��ɾ��\nda��ɾ��һ��\ni��ͨ��id��ѯ\nfa����ѯ����\nq:�˳�\n"
					+ "p:��ҳ\ncd:��Ҫ��!!!");
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
				System.out.println("��ӭ�´�ʹ��");
				System.exit(0);
			case "p":
				queryPage();
				break;
			case "cd":
				doNotTouch();
				break;
			default:
				System.out.println("������ȷ��ָ��");
				break;
			}
		}
	}
	

	/**
	 * ��ҳ
	 */
	private static void queryPage() {
		// TODO Auto-generated method stub
		System.out.println("����Ҫ��ѯ��ҳ��");
		int pageNum = Integer.valueOf(sc.nextLine());
		int pageCount = 4;
		
		ProductService ps = new ProductService();
		List<ProductBean> list = ps.queryPage(pageNum,pageCount);
		
		if (list.size() == 0) {
			System.out.println("û�и�������!");
		}else {
			for (ProductBean pb : list) {
				System.out.println(pb);
			}
		}
		
	}

	/**
	 * ����idɾ��һ������
	 */
	private static void delAll() {
		// TODO Auto-generated method stub
		System.out.println("����ɾ��ģʽ,���� 0 ȷ��");
		ArrayList<Integer> list = new ArrayList<Integer>();
		ProductService ps = new ProductService();
		
		while (true) {
			System.out.println("����ɾ����id");
			int id = Integer.valueOf(sc.nextLine());
			
			if (id == 0) {
				System.out.println("�������");
				break;
			}
			ProductBean pb = ps.queryId(id);
			if (pb == null) {
				System.out.println("����Ʒ������!");
			}else {
				System.out.println("��ȷ��ɾ������Ʒ"+pb);
				list.add(id);
			}
			
		}
		
		System.out.println("���ȷ���Ƿ�ɾ��"+list.size()+"����Ʒ? y/�� ");
		String choise = sc.nextLine();
		
		if (choise.equalsIgnoreCase("y")) {
			boolean b = ps.delAll(list);
			if (b) {
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
			}
		}else {
			System.out.println("ȡ��ɾ��");
		}
		
	}
	
	/**
	 * ����idɾ��
	 */
	private static void delId() {
		// TODO Auto-generated method stub
		System.out.println("����Ҫɾ����ID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService(); 
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("�޴���Ʒ");
		}else {
			System.out.println(pb);
			System.out.println("�Ƿ�ȷ��ɾ��?(y/�� n/��)");
			
			String choise = sc.nextLine();
			
			if (choise.equalsIgnoreCase("y")) {
				boolean b = ps.delId(id);
				if (b) {
					System.out.println("ɾ���ɹ�");
				}else {
					System.out.println("ɾ��ʧ��");
				}
			}else {
				System.out.println("ȡ��ɾ��");
			}
		}
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 */
	private static void update() {
		// TODO Auto-generated method stub
		System.out.println("����Ҫ�޸ĵ���ƷID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService();
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("����");
		}else {
			System.out.println(pb);
			System.out.println("�����޸ĵ���Ʒ����");
			String pname = sc.nextLine();
			System.out.println("�����޸ĵ���Ʒ�۸�");
			int price = Integer.valueOf(sc.nextLine());
			
			ProductBean pbu = new ProductBean(id,pname,price,"c001");
			
			//ProductService psu = new ProductService();
			boolean b = ps.update(pbu);
			
			if (b) {
				System.out.println("�޸ĳɹ�");
			}else {
				System.out.println("�޸�ʧ��");				
			}
					
		}
		
	}

	/**
	 * ��ѯȫ��
	 */
	public static void queryAll() {
		ProductService ps = new ProductService();
		List<ProductBean> list = ps.queryAll();
		
		for (ProductBean p:list) {
			System.out.println(p);
		}
	}
	
	/**
	 * ����id��ѯ
	 */
	public static void queryId() {
		
		System.out.println("����ID");
		int id = Integer.valueOf(sc.nextLine());
		
		ProductService ps = new ProductService();
		ProductBean pb = ps.queryId(id);
		
		if (pb == null) {
			System.out.println("����");
		}else {
			System.out.println(pb);
		}
	}
	/**
	 * �����Ʒ
	 */
	public static void add() {
		
		System.out.println("������Ʒ����");
		String pname = sc.nextLine();
		System.out.println("������Ʒ�۸�");
		int price = Integer.valueOf(sc.nextLine());
		
		
		ProductService ps = new ProductService();
		
		ProductBean pb = new ProductBean();
		pb.setPname(pname);
		pb.setPrice(price);
		
		boolean b = ps.add(pb);
		
		if (b) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
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
				" *          ���汣��             ����BUG\r\n" + 
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
 *          ���汣��             ����BUG
 */

 










