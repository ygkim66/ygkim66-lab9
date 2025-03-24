import javax.lang.model.util.ElementScanner6;
import javax.print.attribute.standard.RequestingUserName;

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
    public String getType(){
        return "Station";
    }
    public int tripLength(Station dest){
        System.out.println(dest);
        int length = 0;
        return tripLength(dest, this, length);
    }

    public int tripLength(Station dest, Station current, int count){
        if (dest.equals(current)){
            return count;
        }
        else if (current.getType().equals("EndStation") && count > 0)
            return -19897878;

        else if (current instanceof TransferStation){
            return count + transferTripLength(dest, current, 1);
        }
        else{
            return tripLength(dest, current.next, count + 1);
        }
    }
    public int transferTripLength(Station dest, Station current, int count){
        int temp = 1;
        int temp2 = 0;
 //       if (dest.equals(new Station("orange", "judiciary_square")));
   //         temp2 =1;
        TransferStation t = (TransferStation)current;

        for (int i = 0; i < t.getSize(); i++){
            if (t.access(i).getNextStation() instanceof TransferStation){

                int temp9 = tripLength(dest, t.access(i).getNextStation().getNextStation(), 1);
                if ( temp9> 0){
                 //   System.out.println("DEBUG: DOES THIS HIT TEMP9????/");
                    temp = temp9;
                }
            }
            else {
                int temp10 = tripLength(dest, t.access(i).getNextStation(), 1);
                if (temp10 >= 0){
                    temp = temp10 ;
                }
                
            }
        }
        return temp + temp2;

       // return temp;
    }

    public String toString(){
        return "STATION " + name + ": " + color + " line, in service: " + isAvailable + ", previous station: " + getPrevName() + ", next station: " + getNextName();
    }
}
