package com.zhangwei.jvm.chapter2;

public class SelfAdd {

	public static void main(String[] args) {
		f3();
		f4();
	}

	/**
	 * 反编译 命令 javap -verbose  StringAdd.class
	 *  javap -c -v StringAdd.class
	 *   javap -v -c Test1.class >p.text 直接输出到某个文件
	 * 问题：i++ ++i 哪个性能好  性能一样的
	 */
	/**
	 public static void f1();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2 栈深度, locals=1 局部变量数量, args_size=0 参数数量
         0: iconst_0   压栈 变量0
         1: istore_0   存储到变量0上 对应i
         2: goto          15  到15行
         5: getstatic     #19                 // Field java/lang/System.out:Ljava/io/PrintStream;   执行System.out方法
         8: iload_0
         9: invokevirtual #25                 // Method java/io/PrintStream.println:(I)V
        12: iinc          0, 1
        15: iload_0     加载到内存
        16: bipush        10  压栈10 用于后面的比较
        18: if_icmplt     5   跳转到第5行
        21: return
	 * */
	public static void f1() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
	}
	/**
	 public static void f2();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=0
         0: iconst_0
         1: istore_0
         2: goto          15
         5: getstatic     #19                 // Field java/lang/System.out:Ljava/io/PrintStream;
         8: iload_0
         9: invokevirtual #25                 // Method java/io/PrintStream.println:(I)V
        12: iinc          0, 1
        15: iload_0
        16: bipush        10
        18: if_icmplt     5
        21: return
	 * */
	public static void f2() {
		for(int i=0;i<10;++i) {
			System.out.println(i);
		}
	}


	/**
	 * 反编译 命令 javap -verbose  StringAdd.class
	 *
	 * i++ 先赋值后自增
	 * ++i 先自增后赋值
	 */

	/**
	 public static void f3();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=0
         0: iconst_0
         1: istore_0
         2: iload_0
         3: iinc          0, 1
         6: istore_1
         7: getstatic     #19                 // Field java/lang/System.out:Ljava/io/PrintStream;
        10: iload_1
        11: invokevirtual #25                 // Method java/io/PrintStream.println:(I)V
        14: return
	 * */
	public static void f3() {
		int i=0;
		int j = i++;
		System.out.println(j);
	}
	/**
	public static void f4();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=0
         0: iconst_0
         1: istore_0
         2: iinc          0, 1
         5: iload_0
         6: istore_1
         7: getstatic     #19                 // Field java/lang/System.out:Ljava/io/PrintStream;
        10: iload_1
        11: invokevirtual #25                 // Method java/io/PrintStream.println:(I)V
        14: return
	 * */
	public static void f4() {
		int i=0;
		int j = ++i;
		System.out.println(j);
	}
}
