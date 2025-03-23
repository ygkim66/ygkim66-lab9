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
            return -245345;

        else if (current instanceof TransferStation){
            System.out.println("debug transferstation recurs" + current);
           // count += transferTripLength(dest, (TransferStation)current, count + 1);
            return count + transferTripLength(dest, current, count + 1);
           // return count + 2435243;//tripLength(dest, current.getNextStation(), count+1);
        }
        else{
            System.out.println("DEBUG CURRENT.NEXT" + current.next);
            return tripLength(dest, current.next, count + 1);
        }
    }
    public int transferTripLength(Station dest, Station current, int count){
        int temp = 1;
        /*System.out.println("DEBUG CURRENT.GETSIZE():" + current.getSize());
        for (int i = 0; i < current.getSize(); i++){
            int temp1 = 0;
            System.out.println( current.access(i));

            if (current.access(i).getNextName().equals(this.getName())){
                System.out.println("DEBUG GET INTO CURRENT.ACCESS?");
                temp += tripLength(dest, current.access(i).getNextStation().getNextStation(), temp1 + 1);
                System.out.println("DEBUG TEMP" + temp);
            }
           // else
             //   temp += tripLength(dest, current.access(i).getNextStation(), temp1 + 1);
        }*/
        TransferStation t = (TransferStation)current;
        int temp1 = 0;
        boolean found = false;
        for (int i = 0; i < t.getSize(); i++){
            if ((t.access(i).getNextStation().equals(this))){
             //   System.out.println("Current.next = " + t.access(i).getNextStation().toString());
             //   temp = tripLength(dest, t.access(i).getNextStation().getNextStation(), temp1+1);
            //    System.out.println("temp = " + temp);
                if (t.getNextStation().getNextStation().tripLength(dest) > 0){
                    temp = temp+ (t.getNextStation().getNextStation().tripLength(dest)) + 1;
                }
            }
            else {
                int temp10 = t.getNextStation().tripLength(dest);
                if (temp10 > 0)
                    temp = temp10 + 1;
            }
        }
        return temp ;

       // return temp;
    }

    public String toString(){
        return "STATION " + name + ": " + color + " line, in service: " + isAvailable + ", previous station: " + getPrevName() + ", next station: " + getNextName();
    }
}
