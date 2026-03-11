import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylistManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LinkedList to store songs
        LinkedList<String> playlist = new LinkedList<>();

        int choice;

        do {

            System.out.println("\n===== Music Playlist Manager =====");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. View Playlist");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();

                    playlist.add(song);

                    System.out.println("Song added to playlist.");
                    break;

                case 2:
                    System.out.print("Enter song name to remove: ");
                    String removeSong = sc.nextLine();

                    if (playlist.remove(removeSong)) {
                        System.out.println("Song removed.");
                    } else {
                        System.out.println("Song not found.");
                    }

                    break;

                case 3:

                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty.");
                    } else {

                        System.out.println("\nCurrent Playlist:");

                        for (String s : playlist) {
                            System.out.println(s);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Exiting Playlist Manager.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 4);

        sc.close();
    }
}