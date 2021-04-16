package BookManage;

/**
 * @author xujinwei
 * @date 2021/4/10 9:05
 */
import java.util.Date;
public class Book {
    public String stata;  //状态
    public String name;   //名称
    public Date date;     //日期

    public void setTuShu(String zhuangtai,String mingzi,Date riqi){
        stata = zhuangtai;
        name = mingzi;
        date = riqi;
    }
    public void print(int index){
        System.out.println(index + "\t" + name + "\t" + stata + "\t" + date);
    }

}
