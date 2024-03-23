package ControlWork2;

import com.sun.jdi.Value;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Задание 1
        Scanner s = new Scanner(new File("schedule.txt"));
        List<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();

        // Задание 4
        Map<String, List<Programm>> map = new HashMap<>();
        String nowChannel;
        int index = 0;
        List<Programm> miniList;
        while(index < list.size()){
            nowChannel = list.get(index);
            index++;
            miniList = new ArrayList<>();
            while(index < list.size() && list.get(index).charAt(0) != '#'){
                miniList.add(new Programm(nowChannel, list.get(index), list.get(index + 1)));
                index += 2;
            }
            map.put(nowChannel, miniList);
        }
        //map.forEach((key, value) -> System.out.println(key + "\n" + Arrays.toString(value.toArray())));

        // Задание 5
        List<Programm> allProgramsList = new ArrayList<>();
        for (List<Programm> ls : map.values()){
            allProgramsList.addAll(ls);
        }

        // Задание 6
        Collections.sort(allProgramsList, new Comparator<Programm>() {
            @Override
            public int compare(Programm o1, Programm o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
//        for (Programm pr : allProgramsList){
//            System.out.println(pr);
//        }

        // Задание 7
        programsInTime(map, new BroadcastsTime("12:00"));

        // Задание 8
        List<Programm> inStr = findByStr("тат", allProgramsList);
        System.out.println(Arrays.toString(inStr.toArray()));

        // Задание 9
        programsInTime(map, new BroadcastsTime("01:30"), "#ТНВ");

        // Задание 10
        List<Programm> list1 = findByTime(allProgramsList, new BroadcastsTime("10:00"), new BroadcastsTime("20:00"), "#НТВ");
        System.out.println(Arrays.toString(list1.toArray()));
    }

    public static List<Programm> findByTime(List<Programm> list, BroadcastsTime o1, BroadcastsTime o2, String channel){
        List<Programm> ret = new ArrayList<>();
        for (Programm pr : list){
            if (pr.getChannel().equals(channel)){
                if (pr.getTime().between(o1, o2)){
                    ret.add(pr);
                }
            }
        }
        return ret;
    }

    public static List<Programm> findByStr(String str, List<Programm> list){
        List<Programm> result = new ArrayList<>();
        for (Programm pr : list){
            if (pr.getName().indexOf(str) != -1){
                result.add(pr);
            }
        }
        return result;
    }

    public static void programsInTime(Map<String, List<Programm>> map, BroadcastsTime time, String chan){
        for (List<Programm> ls : map.values()){
            for (int i = 1; i < ls.size(); i++){
                if (time.between(ls.get(i - 1).getTime(), ls.get(i).getTime()) && ls.get(i - 1).getChannel().equals(chan)){
                    System.out.println(ls.get(i - 1));
                }
            }
        }
    }

    public static void programsInTime(Map<String, List<Programm>> map, BroadcastsTime time){
        for (List<Programm> ls : map.values()){
            for (int i = 1; i < ls.size(); i++){
                if (time.between(ls.get(i - 1).getTime(), ls.get(i).getTime())){
                    System.out.println(ls.get(i - 1));
                }
            }
        }
    }
}
