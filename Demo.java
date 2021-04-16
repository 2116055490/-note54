package BookManage;

import java.text.ParseException;

/**
 * @author xujinwei
 * @date 2021/4/16 11:24
 */
public class Demo {
    public static void main(String[] args)
            throws ParseException {
        BookMarge tuShuManage = new BookMarge();
        tuShuManage.initila();
        tuShuManage.startMenu();
    }
}
