package ControlWork2;

public class BroadcastsTime implements Comparable<BroadcastsTime>{
    private byte min;
    private byte h;

    public String toString() {
        return h + ":" + min;
    }

    public BroadcastsTime(String str) throws Exception {
        String[] duo = str.split(":");
        if (duo.length != 2){
            throw new Exception();
        }
        min = (byte) (Byte.parseByte(duo[1]) % 60);
        h = (byte)((Byte.parseByte(duo[0]) + (byte)(Byte.parseByte(duo[1]) / 60)) % 24);
    }
    byte hour() {
        return h;
    }
    byte minutes() {
        return min;
    }
    boolean after(BroadcastsTime t) {
        if (hour() != t.hour()) return hour() > t.hour();
        else{
            return minutes() > t.minutes();
        }
    }
    boolean befor(BroadcastsTime t) {
        if (hour() != t.hour()) return hour() < t.hour();
        else{
            return minutes() < t.minutes();
        }
    }
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        if (t1.hour() > t2.hour()){
            return false;
        }
        if (t1.hour() <= hour() && hour() <= t2.hour()){
            if ((t1.hour() == hour() && t1.minutes() > minutes())){
                return false;
            }
            if ((t2.hour() == hour()) && minutes() >= t2.minutes()){
                return false;
            }
            return true;
        }
        return false;
    }

    public int compareTo(BroadcastsTime o) {
        if(after(o)){
            return 1;
        }
        if (befor(o)){
            return -1;
        }
        return 0;
    }
}
