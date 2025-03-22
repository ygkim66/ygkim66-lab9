public class Station {
    protected String name;
    protected String color;
    protected boolean isAvailable;
    protected Station previous;
    protected Station next;

    public Station(String c, String n){
        color = c;
        name = n;
        isAvailable = true;
        previous = null;
        next = null;
    }
    public String getName(){
        return name;
    }
    public void addPrev(Station p){
        previous = p;
    //    p.addNext(this);
    }
    public Station getPrevStation(){
        return previous;
    }
    public void addNext(Station n){
        next = n;
    //    n.addPrev(this);
    }
    public Station getNextStation(){
        return next;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void switchAvailable(){
        isAvailable = !isAvailable;
    }
    public String getColor(){
        return color;
    }
    public boolean equals(Station s){
        if (this.name.equals(s.getName()) && this.color.equals(s.getColor()))
            return true;
        return false;
    }
    public void connect(Station s){
        next = s;
        this.addPrev(s);
    }
    public String toString(){
        return "STATION " + name + ": " + color + " line, in service: " + isAvailable + ", previous station: " + previous + ", next station: " + next;
    }
}
