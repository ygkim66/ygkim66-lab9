public class EndStation extends Station{
    public EndStation(String c, String n){
        super(c,n);
    }
    public void makeEnd(){
      //  System.out.println("DEBUG: IN MAKENED METHOD" + previous);
      //  System.out.println(next);
       // next = previous;
        Station temp = previous;
    //    next = this;
        if (next == null)
            next = previous;

        if (previous == null)
            previous = next;

      //  next = temp;
    //    previous.addNext(next);
     //   next.addPrev(previous.getNextStation());
       // next = getPrevStation().getNextStation();
       // next = temp;
    }
    public String toString(){
        return "END" + super.toString();
    }
}
