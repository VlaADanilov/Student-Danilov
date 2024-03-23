package ControlWork2;

public class Programm {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Programm(String channel, String time, String name) throws Exception {
        this.channel = channel;
        this.time = new BroadcastsTime(time);
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        channel = channel;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public void setTime(BroadcastsTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Программа: канал - " + channel + ", время - " + time + ", название - " + name + ".";
    }
}
