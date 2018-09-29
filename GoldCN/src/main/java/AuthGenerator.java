import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class AuthGenerator {
    static String DELETE_TEMPLATE = "delete from `fcauth`.`t_role_resource` where `role_id` = %s; \n";
    static String INSERT_TEMPLATE = "INSERT INTO `fcauth`.`t_role_resource` " +
            "(`role_id`, `resource_id`) VALUES (%s, %s); -- %s \n";
    private static String ROLE_NAMES = "系统管理员,董事,总经理,副总经理,财务部总经理,财务部出纳员,财务部审计员,财务部会计," +
            "财务部商务员,市场部总经理,市场部客服,市场部展业研发,市场部客服总监,产品部总经理,产品部SEO推广,产品部货品管理主管," +
            "产品部库管,产品部物流员,套保交易员,销售部总经理,销售部副总经理,销售部区域总监,销售部渠道经理,综合部专员,综合部总经理," +
            "分销商,服务商,供应商,会员,客户经理";
    private static String ROLE_IDS = "0,x,1,2,4,11,x,x,x,6,x,x,16,7,x,23,x,24,30,8,x,x,28,x,x,34,32,33,31,x";
    private static String TABLE_NAMES = "t_goods,t_good_deduction_setting,t_good_specification,t_good_supply_only;" +
            "t_category;t_combo,t_combo_goods;t_distribution;t_tax;t_raw_material;t_warehouse,t_good_allocation;" +
            "t_inbound,t_order_goods;t_other_inbound,t_order_goods;t_inventory,t_warehouse,t_goods,t_good_specification;" +
            "t_inventory_check,t_inventory_check_checker,t_inventory_check_records;t_logistic_vendor;t_sales_order," +
            "t_order_goods;t_presale_order,t_order_goods;t_good_purchasing,t_raw_material_purchasing,t_order_goods;" +
            "t_good_purchasing,t_order_goods;t_raw_material_purchasing,t_raw_material_purchasing_detail;" +
            "t_outbound_process,t_outbound_process_raw_material,t_outbound_process_raw_material_goods,t_order_goods;" +
            "t_inventory_transfer_order,t_order_goods;t_exchange_goods_order,t_order_goods;t_repurchase_order," +
            "t_repurchase_order_goods;t_refund_order,t_order_goods;t_tao_bao_order;t_tao_bao_order;t_member;t_gold_card," +
            "t_member_gold_card;t_partner;t_company,t_person;t_user";
    private static String RESOURCE_NAMES2 = "商品信息管理,商品分类管理,套餐管理,渠道分销上下架,渠道税率设置,原料信息管理,仓库设置," +
            "采购入库管理,其他入库管理,库存查询,库存盘点,物流管理,销售订单,预售订单,采购订单查询,成品采购订单,原料采购单,去料加工单," +
            "库存调拨单,换货调拨单,收金订单,退货退款,套保订单,套保查询,会员信息," +
            "黄金卡,合作伙伴管理,公司信息管理,人员管理";
    private static String BUTTONS = "保存,返回;保存,返回;保存,返回;保存,返回,提交审核,同意,驳回,撤销;保存,返回;保存,返回;保存,返回;" +
            "保存,返回,打印入库单;保存,返回,打印入库单;;保存,返回,提交审核,同意,驳回,撤销;保存,返回;保存,返回,提交审核,撤销,确认出库,打印出库单;保存,返回," +
            "提交审核,同意,驳回,撤销,确认出库,打印出库单;;保存,返回,提交审核,同意,驳回,撤销,确认接单,确认完成;保存,返回,提交审核,同意," +
            "驳回,撤销,确认完成;保存,返回,提交审核,同意,驳回,撤销,确认接单,确认完成,确认出库,打印出库单,原料到货确认;保存,返回," +
            "提交审核,同意,驳回,撤销,确认出库,确认入库,打印出库单;保存,返回,提交审核,同意,驳回,撤销,确认出库,确认入库,打印出库单;" +
            "保存,返回,提交订单,同意,驳回,取消订单,确认收金,确认打款,确认完成;保存,返回,提交审核,同意,驳回,撤销,确认入库;保存,返回;;" +
            "保存,返回;保存,返回;保存,返回,提交审核,同意,驳回,撤销;保存,返回;保存,返回";
    private static String RESOURCE_NAMES = "商品信息管理,商品分类管理,套餐管理,渠道分销上下架,渠道税率设置,原料信息管理,仓库设置," +
            "采购入库管理,其他入库管理,库存查询,库存盘点,物流管理,销售订单,预售订单,采购订单查询,成品采购订单,原料采购单,去料加工单," +
            "库存调拨单,换货调拨单,收金订单,退货退款,套保订单,套保查询,待签任务,待办任务,会员信息,消费记录,积分记录,营销管理,优惠券," +
            "黄金卡,限时折扣,消费赠券,短信营销,公司信息管理,合作伙伴管理,人员管理";
    private static String RESOURCE_IDS = "16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41," +
            "42,43,44,45,46,47,48,49,50,51,52,53";
    private static String[] RIGHTS = new String[]{"可读", "可写"};

    public class Role {
        String id;
        String name;
        ArrayList<Resource> resources = new ArrayList<Resource>();

        Role(String id) {
            this(id, null);
        }

        Role(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public class Resource {
        String id;
        String name;

        Resource(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        AuthGenerator authGenerator = new AuthGenerator();
//        System.out.println(authGenerator.generateSQL("/Users/apple/Documents/石总/微购商城/权限设置1.0.csv"));
//        generateRecordLevelAuth("/Users/apple/Documents/石总/微购商城/记录级别权限设置1.0.csv");
//        authGenerator.generateFieldLevelAuth(
//                "/Users/apple/Documents/石总/微购商城/table_info1.1.csv",
//                "/Users/apple/Documents/石总/微购商城/字段级别权限设置1.0.csv"
//        );
        authGenerator.generateButtonAuth("/Users/apple/Documents/石总/微购商城/按钮级别权限设置1.0.csv");
    }

    public String generateSQL(String configFilePath) {
        StringBuilder sb = new StringBuilder();
        try {
            CSVReader reader = new CSVReader(new FileReader(configFilePath));
            String[] nextLine;
            int rowIndex = 0;
            ArrayList<Role> roles = new ArrayList<Role>();
            ArrayList<Resource> resources = new ArrayList<Resource>();
            while ((nextLine = reader.readNext()) != null) {
                if (rowIndex == 0) {
                    for (int i = 2; i < nextLine.length; i++) {
                        roles.add(new Role(nextLine[i]));
                    }
                    System.out.printf("There is %d roles.\n", roles.size());
                } else if (rowIndex == 1) {
                    for (int i = 2; i < nextLine.length; i++) {
                        roles.get(i - 2).name = nextLine[i];
                    }
                } else {
                    Resource resource = new Resource(nextLine[0], nextLine[1]);
                    resources.add(resource);
                    for (int i = 2; i < nextLine.length; i++) {
                        if (nextLine[i].equals("1"))
                            roles.get(i - 2).resources.add(resource);
                    }
                }
                rowIndex++;
//                System.out.printf("proceed %d row...\n", rowIndex);
            }
            for (Role role : roles) {
                sb.append(String.format("\n-- %s\n", role.name));
                sb.append(String.format(DELETE_TEMPLATE, role.id));
                for (Resource resource : role.resources) {
                    sb.append(String.format(INSERT_TEMPLATE, role.id, resource.id, resource.name));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void generateRecordLevelAuth(String outputFilePath) {

        String[] roleNames = ROLE_NAMES.split(",");
        String[] roleIds = ROLE_IDS.split(",");
        String[] resourceIDs = RESOURCE_IDS.split(",");
        String[] resourceNames = RESOURCE_NAMES.split(",");
        String[] scopes = new String[]{"个人", "部门", "公司", "子公司", "全部"};
        String[] rights = new String[]{"查看", "新增", "修改", "删除"};

        List<String> row = new ArrayList<String>();
        try {
            CSVWriter writer = new CSVWriter(new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFilePath),
                            Charset.forName("UTF-8"))), ',');
            row.add("");
            row.add("");
            row.add("");
            row.add("role_id");
            row.addAll(Arrays.asList(roleIds));
            String[] columns = new String[row.size()];
            columns = row.toArray(columns);
            writer.writeNext(columns);


            row = new ArrayList<String>();
            row.add("resourse_id");
            row.add("功能");
            row.add("范围");
            row.add("权限");
            row.addAll(Arrays.asList(roleNames));
            columns = new String[row.size()];
            columns = row.toArray(columns);
            writer.writeNext(columns);


            int rowSize = row.size();
            for (int i = 0; i < resourceIDs.length; i++) {
                row = new ArrayList<String>();
                row.add(resourceIDs[i]);
                row.add(resourceNames[i]);
                for (String scope : scopes) {
                    List<String> row2 = new ArrayList<String>();
                    row2.addAll(row);
                    row2.add(scope);
                    for (String right : rights) {
                        List<String> row3 = new ArrayList<String>();
                        row3.addAll(row2);
                        row3.add(right);
                        row3.addAll(Arrays.asList(new String[roleIds.length]));
                        writer.writeNext(row3.toArray(new String[row3.size()]));
                    }
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output the result to: " + outputFilePath);
    }

    public void generateFieldLevelAuth(String inputFilePath, String outputFilePath) {

        // form the dictionary for forms.
        String[] tablesNames = TABLE_NAMES.split(";");
        String[] menuNames = RESOURCE_NAMES2.split(",");
        String[] roleNames = ROLE_NAMES.split(",");
        String[] roleIds = ROLE_IDS.split(",");
        Map<String, Map<String, Integer>> dic = new HashMap<String, Map<String, Integer>>();
        for (int i = 0; i < tablesNames.length; i++) {
            String[] tables = tablesNames[i].split(",");
            for (int j = 0; j < tables.length; j++) {
                if (!dic.containsKey(tables[j])) {
                    dic.put(tables[j], new HashMap<String, Integer>());
                }
                if (!dic.get(tables[j]).containsKey(menuNames[i])) {
                    dic.get(tables[j]).put(menuNames[i], i + 1);
                }
            }
        }
        try {
            CSVReader reader = new CSVReader(new FileReader(inputFilePath));
            CSVWriter writer = new CSVWriter(new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFilePath),
                            Charset.forName("UTF-8"))), ',');
            String[] nextLine;
            int rowIndex = 0;
            List<String> row = new ArrayList<>();
            while ((nextLine = reader.readNext()) != null) {
                if (rowIndex == 0) {
                    for (int i = 0; i < 1 + nextLine.length; i++) {
                        row.add("");
                    }
                    row.add("role_id");
                    for (String roleId : roleIds) {
                        row.add(roleId);
                    }
                    writer.writeNext(row.toArray(new String[row.size()]));
                    System.out.printf("proceed %d row...\n", rowIndex);
                    rowIndex++;

                    row = new ArrayList<>();

                    row.add("序号");
                    row.add("功能");
                    for (int i = 0; i < nextLine.length; i++) {
                        row.add(nextLine[i]);
                    }
                    for (String roleName : roleNames) {
                        row.add(roleName);
                    }
                    writer.writeNext(row.toArray(new String[row.size()]));
                    System.out.printf("proceed %d row...\n", rowIndex);
                    rowIndex++;
                } else {
                    String tableName = nextLine[0];
                    if (dic.containsKey(tableName)) {
                        for (Map.Entry<String, Integer> entry : dic.get(tableName).entrySet()) {
                            row = new ArrayList<>();
                            row.add(entry.getValue().toString());
                            row.add(entry.getKey());
                            if (nextLine[2].endsWith("id"))
                                continue;
                            for (int i = 0; i < nextLine.length; i++) {
                                row.add(nextLine[i]);
                            }
                            writer.writeNext(row.toArray(new String[row.size()]));
                            System.out.printf("proceed %d row...\n", rowIndex);
                            rowIndex++;

                        }
                    } else {
                        continue;
                    }
                }
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateButtonAuth(String outputFilePath) {

        // form the dictionary for forms.
        String[] menuNames = RESOURCE_NAMES2.split(",");
        String[] roleNames = ROLE_NAMES.split(",");
        String[] roleIds = ROLE_IDS.split(",");
        String[] buttons = BUTTONS.split(";");
        Map<String, Map<String, Integer>> dic = new HashMap<String, Map<String, Integer>>();
        try {
            CSVWriter writer = new CSVWriter(new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFilePath),
                            Charset.forName("UTF-8"))), ',');
            List<String> items = new ArrayList<>();
            items.add("");
            items.add("role_id");
            items.addAll(Arrays.asList(roleIds));
            writer.writeNext(items.toArray(new String[items.size()]));

            items = new ArrayList<>();
            items.add("功能");
            items.add("按钮");
            items.addAll(Arrays.asList(roleNames));
            writer.writeNext(items.toArray(new String[items.size()]));

            int rowIndex = 1;
            for (int i = 0; i < menuNames.length; i++) {
                items = new ArrayList<>();
                items.add(menuNames[i]);
                String[] buttonsInFeature = buttons[i].split(",");
                for (int j = 0; j < buttonsInFeature.length; j++) {
                    List<String> subItems = new ArrayList<>();
                    subItems.addAll(items);
                    subItems.add(buttonsInFeature[j]);
                    writer.writeNext(subItems.toArray(new String[subItems.size()]));
                    System.out.printf("proceed %d row...\n", rowIndex);
                    rowIndex++;
                }

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
