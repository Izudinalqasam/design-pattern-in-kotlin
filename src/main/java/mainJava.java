import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class mainJava {

    public static AtomicInteger nilai = new AtomicInteger(0);

    public static <T> void addInteger(List<? super T> list, T nama){
        list.add(nama);
    }

    public static void addValue(List<? super Integer> list){
        list.add(nilai.getAndIncrement());
    }
    public static void main(String [] args){
        ArrayList<Integer> nameList = new ArrayList<>();
        addValue(nameList);
        addValue(nameList);

        nameList.forEach(System.out::println);
    }
}
