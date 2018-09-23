import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CodeGenerator {

    static String DATE_TEMPLATE = "yyyyMMdd";

    public String generateCode(String template, int value) {

        int zeroIndex = template.indexOf("0");
        if (zeroIndex == -1)
            return String.format("%s%d", template, value);
        String prefix = template.substring(0, zeroIndex);
        if (prefix.contains(DATE_TEMPLATE)) {
            int dateTempateIndex = prefix.indexOf(DATE_TEMPLATE);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TEMPLATE, new Locale("zh", "CN"));
            String date = simpleDateFormat.format(new Date());
            prefix = String.format("%s%s", prefix.substring(0, dateTempateIndex), date);
        }

        String number = template.substring(zeroIndex);
        String leadingZeroTemplate = prefix + "%0" + number.length() + "d";
        return String.format(leadingZeroTemplate, value);
    }


    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        int[] values = new int[]{1, 11, 101, 1001};
        String code_template = "FWSyyyyMMdd000000";
        for (int value : values) {
            String result = codeGenerator.generateCode(code_template, value);
            System.out.printf("%s\n", result);
        }
    }
}
