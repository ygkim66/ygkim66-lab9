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
    public String getPrevName(){
        if (previous == null){
            return "none";
        }
        else
            return previous.getName();
    }
    public String getNextName(){
        if (next == null){
            return "none";
        }
        else
            return next.getName();
    }
    public void addPrev(Station p){
        previous = p;
      //  p.addNext(this);
        p.next = this;
    }
    public Station getPrevStation(){
        return previous;
    }
    public void addNext(Station n){
        next = n;
        n.previous = this;
      //  n.addPrev(this);
     //   connect(n);

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
        s.previous = this;
        //this.addPrev(s);
    }
/* 
    public int tripLength(Station dest){
        if (this.equals(dest)){
            return ___;
        }
    }
    public int tripLength(Station d, int count){
        if (count == )
    }*/
    public String toString(){
        return "STATION " + name + ": " + color + " line, in service: " + isAvailable + ", previous station: " + getPrevName() + ", next station: " + getNextName();
    }
}
