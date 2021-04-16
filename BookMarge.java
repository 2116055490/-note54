package BookManage;

/**
 * @author xujinwei
 * @date 2021/4/10 9:27
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookMarge {
    BookSet bookSet = new BookSet();
    // 仓库初始化  放入商品

    public void initila(){
        Book book1 = new Book();
        book1.setTuShu("已借出","<java基础教程>",new Date());
        Book book2 = new Book();
        book2.setTuShu("可借","<数据库技术>",null);
        Book book3 = new Book();
        book3.setTuShu("可借","<人与神话>",null);

        bookSet.tushus [0] = book1;
        bookSet.tushus [1] = book2;
        bookSet.tushus [2] = book3;
    }
    //菜单
    public void startMenu() throws ParseException {
        System.out.println("欢迎使用图书管理系统");
        System.out.println("-------------------------");
        boolean flag = true;

        do{
            System.out.println("1.新增图书");
            System.out.println("2.查看图书");
            System.out.println("3.删除图书");
            System.out.println("4.借出图书");
            System.out.println("5.归还图书");
            System.out.println("6.退出");
            System.out.println("请选择：");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number){
                case 1:
                    System.out.println("--->新增图书");
                    xinzeng();
                    break;
                case 2:
                    System.out.println("--->查看图书");
                    chakan();
                    break;
                case 3:
                    System.out.println("--->删除图书");
                    shanchu();
                    break;
                case 4:
                    System.out.println("--->借出图书");
                    jiechu();
                    break;
                case 5:
                    System.out.println("--->归还图书");
                    guihuan();
                    break;
                case 6:
                    System.out.println("--->退出");
                    flag = false;
                    break;
                default:
                    System.out.println("请再次输入：");

            }
        }while(flag);
    }

    private void xinzeng() {
        System.out.println("请输入图书馆名称");
        Scanner scanner = new Scanner(System.in);
        String mingzi1 = scanner.next();
        System.out.println("新增"+mingzi1+"成功");
        Book tushux = new Book();
        tushux.setTuShu("可借",mingzi1,null);
        for (int i=0;i<bookSet.tushus.length;i++){
            if (bookSet.tushus[i] == null){
                bookSet.tushus[i] = tushux;

                //把创建的对象放在数组中的第一个空位置
                break;//后续的空位置直接跳过
            }
        }
    }
    private void chakan() {
        System.out.println("序号"+"\t"+"状态"+"\t"+"名称"+"\t"+"借出日期");
        for (int i=0;i<bookSet.tushus.length;i++){
            if (bookSet.tushus[i]!=null){
                bookSet.tushus[i].print(i+1);
            }
        }
    }
    private void shanchu() {
        System.out.println("请输入图书馆名称：");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        for (int i=0;i<bookSet.tushus.length;i++){
            if (bookSet.tushus[i]!=null&&bookSet.tushus[i].name==next&&bookSet.tushus[i].stata=="可借"){
                int j = i;
                while(bookSet.tushus[j+1]!=null){
                    j++;
                }
                bookSet.tushus[j] = null;
                System.out.println("删除"+next+"成功");
                break;
            }else{
                System.out.println(next+"为借出状态，不能删除");
            }
        }
    }
    private void jiechu() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入借出书的名称：");
        String next1 = scanner.next();
        System.out.println("请输入借出日期（年-月-日）：");
        String time = scanner.next();
        DateFormat format= new SimpleDateFormat("yyyy年MM月ff日");
        Date date1 = format.parse(time);
        for (int i=0;i<bookSet.tushus.length;i++){
            if (bookSet.tushus[i]!=null&&bookSet.tushus[i].name==next1&&bookSet.tushus[i].stata == "可借"){
                bookSet.tushus[i].stata = "已借出";
                bookSet.tushus[i].date = date1;
                System.out.println("借出"+next1+"成功");

            }
        }

    }
    private void guihuan() throws ParseException {
        int num = 0;   //钱数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书名称：");
        String next2 = scanner.next();
        System.out.println("请输入归还日期（年-月-日）");
        String time2 = scanner.next();
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date date2 = format.parse(time2);
        for (int i=0;i<bookSet.tushus.length;i++){
            if (bookSet.tushus[i].name==next2&&bookSet.tushus[i]!=null&&bookSet.tushus[i].stata=="已借出"){
                System.out.println("借出时间"+bookSet.tushus[i].date);
                System.out.println("归还时间"+date2);
                long alnteger = ((bookSet.tushus[i].date.getTime()-date2.getTime())/(24*60*60*1000));
                num = (int)alnteger;
                System.out.println("需要支付"+num+"元");
                System.out.println("归还"+next2+"成功");
                bookSet.tushus[i].stata = "可借";
                bookSet.tushus[i].date = null;

            }
        }
    }


}
