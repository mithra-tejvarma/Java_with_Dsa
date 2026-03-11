import java.util.*;

// Movie class
class Movie {
    int movieId;
    String movieName;
    String showTime;
    int availableSeats;

    // Constructor
    Movie(int movieId, String movieName, String showTime, int seats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.availableSeats = seats;
    }

    // Display movie details
    void displayMovie() {
        System.out.println("ID: " + movieId +
                " | Movie: " + movieName +
                " | Show Time: " + showTime +
                " | Available Seats: " + availableSeats);
    }

    // Book seats
    void bookSeats(int seats) {

        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(seats + " seat(s) booked successfully.");
        } else {
            System.out.println("Not enough seats available.");
        }
    }
}

// Booking System class
class BookingSystem {

    HashMap<Integer, Movie> movies = new HashMap<>();

    // Add movie
    void addMovie(Movie movie) {
        movies.put(movie.movieId, movie);
    }

    // Show all movies
    void showMovies() {

        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        System.out.println("\nAvailable Movies:");

        for (Movie m : movies.values()) {
            m.displayMovie();
        }
    }

    // Book ticket
    void bookTicket(int movieId, int seats) {

        Movie movie = movies.get(movieId);

        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        movie.bookSeats(seats);
    }
}

// Main class
public class MovieTicketSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        // Adding movies
        system.addMovie(new Movie(1, "Avengers", "10:00 AM", 50));
        system.addMovie(new Movie(2, "Inception", "1:00 PM", 40));
        system.addMovie(new Movie(3, "Interstellar", "6:00 PM", 60));

        int choice;

        do {

            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Show Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    system.showMovies();
                    break;

                case 2:
                    System.out.print("Enter Movie ID: ");
                    int movieId = sc.nextInt();

                    System.out.print("Enter number of seats: ");
                    int seats = sc.nextInt();

                    system.bookTicket(movieId, seats);
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}