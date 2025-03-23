public class MetroSimulator{
	
		// make all stations
		public static EndStation va_square;
		public static Station clarendon;
		public static Station court_house;
		public static Station rosslyn;
		public static Station foggy_bottom;
		public static Station farragut_west;
		public static Station mcpherson_square;
		public static TransferStation metro_center;
		public static Station federal_triangle;
		public static EndStation smithsonian;

		public static EndStation woodley_park;
		public static Station dupont_circle;
		public static Station farragut_north;
		// Metro Center defined above
		public static Station gallery_place;
		public static EndStation judiciary_square;

		public static EndStation s1;
		public static Station s2;
		public static Station s3;
		// Metro Center defined above
		public static Station s4;
		public static EndStation s5;

	public static void main(String[] args){
		initialize();
		makeOrangeLine();
		makeRedLine();
		makePurpleLine();

	//	int stops = va_square.tripLength(metro_center);
	//	System.out.println("There are " + stops + " stops between Virginia Square and Metro Center");
	}

	public static void initialize(){
		va_square = new EndStation("orange", "Virginia Square");
		clarendon = new Station("orange", "Clarendon");
		court_house = new Station("orange", "Court House");
		rosslyn = new Station("orange", "Rosslyn");
		foggy_bottom = new Station("orange", "Foggy Bottom");
		mcpherson_square = new Station("orange", "McPherson Square");
		farragut_west = new Station("orange", "Farragut West");
	//System.out.println("DEBUG 39243: " + farragut_west.getPrevName());
		//System.out.println("DEBUG 392433434: " + farragut_west.getNextName());

		metro_center = new TransferStation("orange/red/purple", "Metro Center");
		federal_triangle = new Station("orange", "Federal Triangle");
		smithsonian = new EndStation("orange", "Smithsonian");

		woodley_park = new EndStation("red", "Woodley Park");
		dupont_circle = new Station("red", "Dupont Circle");
		farragut_north = new Station("red", "Farragut North");
		// Metro Center defined above
		gallery_place = new Station("red", "Gallery Place");
		judiciary_square = new EndStation("red", "Judiciary Square");

		s1 = new EndStation("purple", "S1");
		s2 = new Station("purple", "S2");
		s3 = new Station("purple", "S3");
		// Metro Center defined above
		s4 = new Station("purple", "S4");
		s5 = new EndStation("purple", "S5");
	}

	public static EndStation makeOrangeLine(){
		va_square.connect(clarendon);
		va_square.makeEnd();
		clarendon.connect(court_house);
		court_house.connect(rosslyn);
		rosslyn.connect(foggy_bottom);
		foggy_bottom.connect(farragut_west);
		farragut_west.connect(mcpherson_square);
		mcpherson_square.connect(metro_center);
		metro_center.connect(federal_triangle);
		//mcpherson_square.connect(federal_triangle);
		federal_triangle.connect(smithsonian);
		smithsonian.makeEnd();
		//smithsonian.makeEnd(federal_triangle);
		//connect the other stations here

		return va_square;

	}

	public static EndStation makeRedLine(){
		woodley_park.connect(dupont_circle);
		woodley_park.makeEnd();
		dupont_circle.connect(farragut_north);
		
		farragut_north.connect(metro_center);
		mcpherson_square.connect(metro_center);
		
		metro_center.connect(federal_triangle);
		//metro_center.connect(gallery_place);
		
		metro_center.addTransferStationPrev(farragut_north);
		metro_center.addTransferStationNext(gallery_place);


		//metro_center.addTransferStationNext(judiciary_square);
		gallery_place.connect(judiciary_square);
		//judiciary_square.connect(court_house);
		judiciary_square.makeEnd();
		//connect the other stations here

		return woodley_park;
	}

	public static EndStation makePurpleLine(){
		s1.connect(s2);
		s1.makeEnd();
		s2.connect(s3);
		s3.connect(metro_center);

		metro_center.addPrev(mcpherson_square);
		metro_center.addTransferStationPrev(s3);
		metro_center.addTransferStationNext(s4);

		s4.connect(s5);
		s5.makeEnd();

		return s1;
	}
}