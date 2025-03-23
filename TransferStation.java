import java.util.*;
public class TransferStation extends Station {
    protected ArrayList<Station> otherStations;

    public TransferStation(String c, String n){
        super(c,n);
        otherStations = new ArrayList<>();
    }
    public String getType(){
        return "TransferStation";
    }
    public int getSize(){
        return otherStations.size();
    }
    public Station access(int index){
        return otherStations.get(index);
    }
    public void addTransferStationPrev(Station s){
        otherStations.add(s);
      //  previous.next = this;
        s.next = this;
      //  s.addNext(this);
       // this.addPrev(s);
      // previous = s;
    }
    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.previous = this;
     //   s.addPrev(this);
      //  this.addNext(s);

    }
    public String toString(){
        String temp =  "TRANSFER" + super.toString() + "\n\tTransfers: \n";
        for (int i = 0; i < otherStations.size(); i++){
            temp += "\t" + otherStations.get(i).toString() + "\n";
        }
        return temp;
    }


}
