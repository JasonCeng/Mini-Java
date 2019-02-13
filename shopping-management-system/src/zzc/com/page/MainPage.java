package zzc.com.page;

import zzc.com.tools.ScannerChoice;

public final class MainPage extends ScannerChoice {
	public static void main(String[] args) {
		MainPage.mainPage();
	}

	public static void mainPage() {
		System.out.println("***************************\n");
		System.out.println("\t 1.商品维护\n");
		// System.out.println("\t 2.前台收银\n");
		// System.out.println("\t 3.商品管理\n");
		System.out.println("***************************");

		System.out.println("\n请输入选项,或者按0退出.");
		do {
			String choice = ScannerInfoString();
			String regex = "[0-3]";// 正则表达式
			if (choice.matches(regex)) {
				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					System.out.println("------------------");
					System.out.println("您已经退出系统!");
					System.exit(1);// 退出程序，返回值随便设置
					break;
				case 1:
					MaintenancePage();
					break;
				case 2:
					checkstandLogPage();
					break;
				case 3:
					commodityManagementPage();
					break;
				default:
					break;
				}
			}
		} while (true);
	}

	/**
	 * 1.商品维护界面
	 */
	public static void MaintenancePage() {
		System.out.println("***************************\n");
		System.out.println("\t 1.添加商品\n");
		System.out.println("\t 2.更改商品\n");
		System.out.println("\t 3.删除商品\n");
		System.out.println("\t 4.查询商品\n");
		System.out.println("\t 5.显示所有商品\n");
		System.out.println("***************************");

		System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
		do {
			String choice = ScannerInfoString();
			String regex = "[0-5]";
			if (choice.matches(regex)) {
				int info = Integer.parseInt(choice);
				switch (info) {
				case 0:
					mainPage();
					break;
				case 1:
					GoodsPage.addGoodsPage();
					break;
				case 2:
					GoodsPage.updateGoodsPage();
					break;
				case 3:
					GoodsPage.deleteGoodsPage();
					break;
				case 4:
					GoodsPage.queryGoodsPage();
					break;
				case 5:
					GoodsPage.displayGoodsPage();
					break;
				default:
					break;
				}
				System.err.println("!输入有误!");
				System.out.println("重新输入或按 0 返回上一级菜单.");
			}
		} while (true);

	}

	/**
	 * 2.前台收银登录界面
	 */
	private static void checkstandLogPage() {
		// TODO Auto-generated method stub

	}

	/**
	 * 3.商品管理界面
	 */
	private static void commodityManagementPage() {
		// TODO Auto-generated method stub

	}

}
