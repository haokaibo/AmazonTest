import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AuthGenerator {
    static String DELETE_TEMPLATE = "delete from `fcauth`.`t_role_resource` where `role_id` = %s; \n";
    static String INSERT_TEMPLATE = "INSERT INTO `fcauth`.`t_role_resource` " +
            "(`role_id`, `resource_id`) VALUES (%s, %s); -- %s \n";

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
        System.out.println(authGenerator.generateSQL("/Users/apple/Documents/石总/微购商城/权限设置1.0.csv"));
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
            for (Role role : roles){
                sb.append(String.format("\n-- %s\n", role.name));
                sb.append(String.format(DELETE_TEMPLATE, role.id));
                for (Resource resource : role.resources){
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
}
