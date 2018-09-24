import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthGenerator {
    static String DELETE_TEMPLATE = "delete from `fcauth`.`t_role_resource` where `role_id` = %s; \n";
    static String INSERT_TEMPLATE = "INSERT INTO `fcauth`.`t_role_resource` " +
            "(`role_id`, `resource_id`) VALUES (%s, %s); -- %s \n";
    private static String ROLE_NAMES = "系统管理员,总经理,副总经理,财务部总经理,财务部出纳员,市场部总经理,市场部客户总监," +
            "产品部总经理,产品部货品管理主管,产品部套保交易员,产品部物流员,销售部总经理,销售部渠道经理,分销商,服务商,供应商,会员";
    private static String ROLE_IDS = "0,1,2,4,11,6,16,7,23,30,24,8,28,34,32,33,31";
    private static String RESOURCE_NAMES = "商品信息管理,商品分类管理,套餐管理,渠道分销上下架,渠道税率设置,原料信息管理,仓库设置," +
            "采购入库管理,其他入库管理,库存查询,库存盘点,物流管理,销售订单,预售订单,采购订单查询,成品采购订单,原料采购单,去料加工单," +
            "库存调拨单,换货调拨单,收金订单,退货退款,套保订单,套保查询,待签任务,待办任务,会员信息,消费记录,积分记录,营销管理,优惠券," +
            "黄金卡,限时折扣,消费赠券,短信营销,合作伙伴管理,公司信息管理,人员管理";
    private static String RESOURCE_IDS = "16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41," +
            "42,43,44,45,46,47,48,49,50,51,52,53";

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
//        AuthGenerator authGenerator = new AuthGenerator();
//        System.out.println(authGenerator.generateSQL("/Users/apple/Documents/石总/微购商城/权限设置1.0.csv"));
        generateRecordLevelAuth("/Users/apple/Documents/石总/微购商城/记录级别权限设置1.0.csv");
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
        String[] scopes = new String[]{"个人", "部门", "公司", "全部"};
        String[] rights = new String[]{"查看", "修改", "删除"};

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
}
