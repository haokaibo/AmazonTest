package com.google;

public class SQLHelper {
    static String delete_template = "delete from `fcauth`.`t_role_resource` where `role_id` = %d; \n";
    static String insert_template = "INSERT INTO `fcauth`.`t_role_resource` " +
            "(`role_id`, `resource_id`) VALUES (%d, %d); \n";

    public static void main(String[] args) {

        SQLHelper sqlHelper = new SQLHelper();

        System.out.println("-- 系统管理员");
        System.out.println(buildSQL(0, getSystemAdminRights()));

        System.out.println("-- 总经理");
        System.out.println(buildSQL(1, new int[]{1, 3, 6, 19, 40, 41, 54}));

        System.out.println("-- 副总经理");
        System.out.println(buildSQL(2, new int[]{1, 3, 6, 19, 40, 41, 54}));

        System.out.println("-- 财务部出纳员");
        System.out.println(buildSQL(11, new int[]{1, 3, 4, 6, 29, 31, 32, 36, 37, 40, 41, 54}));

        System.out.println("-- 产品部货品管理主管");
        System.out.println(buildSQL(23, new int[]{1, 3, 4, 6, 7, 8, 16, 17, 18, 21, 22, 23, 24, 25, 26, 27, 40, 41, 42,
                43, 44, 45, 46, 47, 48, 49, 50, 51, 53, 54}));

        System.out.println("-- 产品部物流员");
        System.out.println(buildSQL(24, new int[]{1, 3, 6, 27, 40, 41}));

        System.out.println("-- 销售渠道经理");
        System.out.println(buildSQL(28, new int[]{1, 4, 6, 7, 8, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 40,
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54}));

        System.out.println("-- 产品部套保交易员");
        System.out.println(buildSQL(30, new int[]{1, 5, 6, 8, 38, 39, 40, 41, 51, 53, 54}));

    }

    public static int[] getSystemAdminRights() {
        int N = 54;
        int[] rids = new int[N];
        for (int i = 0; i < N; i++) {
            rids[i] = i + 1;
        }
        return rids;
    }

    public static String buildSQL(int role_id, int[] resource_ids) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(delete_template, role_id));
        for (int rid : resource_ids)
            sb.append(String.format(insert_template, role_id, rid));
        return sb.toString();
    }
}
