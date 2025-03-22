import java.util.*;
public class TransferStation extends Station {
    protected ArrayList<Station> t;
    public TransferStation(String c, String n){
        super(c,n);
        t = new ArrayList<>();
    }

    public void addTransferStationPrev(Station s){
        t.add(s);
        s.addNext(this);
        this.addPrev(s);
    }
    public void addTransferStationNext(Station s){
        t.add(s);
        s.addPrev(this);
        this.addNext(s);

    }
    public String toString(){
        String temp = "TRANSFER" + super.toString() + "\tTransfers: \n";
        for (int i = 0; i < t.size(); i++){
            temp += t.get(i).toString();
        }
        return temp;
    }


}
