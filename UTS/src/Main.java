import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public Main() {
		
		int menu;
		
		String id;
		String title;
		int year;
		int track;
		int rating;
		double price;
		
		String song;
		String genre;
		
		String pop = "Pop";
		String jazz = "Jazz";
		String bal = "Ballad";
		String rock = "Rock";
		
		Vector<Album> Vec = new Vector<>();
	
		do {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("##########################");
			System.out.println("--------------------------");
			System.out.println("-     Bluejack Music     -");
			System.out.println("--------------------------");
			System.out.println("##########################");
			
			System.out.println("\n");
			
			System.out.println("1. ADD NEW ALBUM");
			System.out.println("2. VIEW ALBUMS");
			System.out.println("3. DELETE ALBUM");
			System.out.println("4. EXIT");
			System.out.printf("CHOOSE: ");
			
			menu = scan.nextInt();
			scan.nextLine();
			
			switch (menu) {
			case 1:
				System.out.printf("Input Album Title [min. 5 characters]: ");
				title = scan.nextLine();
				while(title.length() < 5) {
					System.out.printf("Input album title [min. 5 characters]: ");
					title = scan.nextLine();
				}
				
				System.out.printf("Input Album Rating [1 - 10]: ");
				rating = scan.nextInt();
				scan.nextLine();
				while(rating < 1 || rating > 10) {
					System.out.printf("Input Album Rating [1 - 10]: ");
					rating = scan.nextInt();
					scan.nextLine();
				}
				
				System.out.printf("Input Album Release Year [2000 - 2021]: ");
				year = scan.nextInt();
				scan.nextLine();
				while(year < 2000 || year > 2021) {
					System.out.printf("Input Album Release Year [2000 - 2021]: ");
					year = scan.nextInt();
					scan.nextLine();
				}
				
				System.out.printf("Input Number of Track(s) [1 - 7]: ");
				track = scan.nextInt();
				scan.nextLine();
				while(track < 1 || track > 7) {
					System.out.printf("Input Number of Track(s) [1 - 7]: ");
					track = scan.nextInt();
					scan.nextLine();
				}
				
				Vector<Tracks> SubVec = new Vector<>();
				
				for (int i = 0; i < track; i++) {
					System.out.printf("Input #%d Song Title [3 - 15]: ", i+1);
					song = scan.nextLine();
					while (song.length() < 3 || song.length() > 15) {
						System.out.printf("Input %d Song Title [3 - 15]: ", i+1);
						song = scan.nextLine();
					}
					
					for(;;) {
						System.out.printf("Input #%d Song Genre [Pop | Jazz | Ballad | Rock]: ", i+1);
						genre = scan.nextLine();
						if(genre.matches(pop) == true || genre.matches(jazz) == true || genre.matches(bal) == true || genre.matches(rock) == true) {
							break;
						}
					}
					
	
					Tracks tr = new Tracks(song, genre);
					
					SubVec.add(tr);
				}
				
				System.out.println("Successfully add new album!");
				
				Random rand = new Random();
				int rand1 = rand.nextInt(1000);
				
				String randnum;
				randnum = String.format("%03d", rand1);
				
				id = "AB" + randnum;
				
				price = (rating * 0.5 * track) + 50; 
				Album alb = new Album(id, title, year, track, rating, price, SubVec);
				
				Vec.add(alb);
				Util.PressEnter();
				break;
			
			case 2:
				if(Vec.isEmpty() == true) {
					System.out.println("SORRY THERE IS NO DATA :(");
					System.out.println("PLEASE INPUT THE DATA FIRST");
					break;
				}
				else {
					System.out.println("\n");
					for(int i=0 ; i<Vec.size(); i++) {
						System.out.printf("Album No. %d\n", i+1);
						System.out.println("==========================");
						System.out.println("Id: " + Vec.get(i).getId());
						System.out.println("Album Title: " + Vec.get(i).getTitle());
						System.out.println("Release Year: " + Vec.get(i).getYear());
						System.out.println("Number of Track(s): " + Vec.get(i).getTrack());
						System.out.println("Album Rating: " + Vec.get(i).getRating());
						System.out.println("Album Price: $" + Vec.get(i).getPrice());
						System.out.println("---------------------------");
						System.out.println("Songs: ");
						
						for(int j=0; j < Vec.get(i).getSubVec().size();j++) {
							System.out.printf("#%d " + Vec.get(i).getSubVec().get(j).getGenre() + " - " + Vec.get(i).getSubVec().get(j).getSong() + "\n", j+1);
						}
						System.out.println("----------------------------");
						System.out.println("\n");
					}

					Util.PressEnter();
					break;
				}
			case 3:
				if(Vec.isEmpty() == true) {
					System.out.println("SORRY THERE IS NO DATA :(");
					System.out.println("PLEASE INPUT THE DATA FIRST");
					break;
				}
				else {
						
					int del;
					System.out.printf("Select album [1 - %d]: ", Vec.size());
					del = scan.nextInt();
					
					while(del < 1 || del > Vec.size()) {
						System.out.printf("Select album [1 - %d]: ", Vec.size());
						del = scan.nextInt();
					}
					
					System.out.printf("Success remove " + Vec.get(del).getTitle() + " from album list");
		
					Vec.remove(del-1);
						
					System.out.println("\n");
						
					Util.PressEnter();
					break;
				}
			case 4:
				break;
			}
		} while (menu != 4);
	}

	public static void main(String[] args) {
		new Main();
	}

}
