public class EndStation extends Station{
    public EndStation(String c, String n){
        super(c,n);
    }
    public void makeEnd(){
        addNext(this.getPrevStation());
        addPrev(this.getPrevStation());
    }
    public String toString(){
        return "END" + super.toString();
    }
}
