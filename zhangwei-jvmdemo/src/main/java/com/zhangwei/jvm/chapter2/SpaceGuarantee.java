package com.zhangwei.jvm.chapter2;

public class SpaceGuarantee {
    /**
     * 运行参数 -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M
     * x新生代10M
     * <p>
     * -XX:PretenureSizeThreshold  大对象直接分配到老年代
     * -XX:MaxTenuringThreshold=15  长期存活的对象分配老年代
     * -XX:HandlePromotionFaiLure 空间分配担保 检查老年代最大可用连续空间是否大于历史晋升到老年代对象的平均大小
     * -XX:TargetSurvivorRation 动态对象年龄对象
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] d1 = new byte[2 * 1024 * 1024];
        byte[] d2 = new byte[2 * 1024 * 1024];
        byte[] d3 = new byte[2 * 1024 * 1024];
        byte[] d4 = new byte[4 * 1024 * 1024];

        System.gc();

    }
}
