import java.util.*;

/**
 * MovieRentingSystem:
 * - Allows searching, renting, dropping, and reporting movies.
 * - Efficient operations using TreeSet + HashMap.
 */
public class MovieRentingSystem {

    // Store available movies: movieId -> TreeSet of MovieEntry (sorted by price, then shopId)
    private Map<Integer, TreeSet<MovieEntry>> availableMovies;

    // Store rented movies in a global TreeSet (sorted by price, then shopId, then movieId)
    private TreeSet<MovieEntry> rentedMovies;

    // Price lookup: (shopId, movieId) -> price
    private Map<String, Integer> priceMap;

    /**
     * Initializes the system with entries.
     * Each entry = {shopId, movieId, price}.
     */
    public MovieRentingSystem(int n, int[][] entries) {
        availableMovies = new HashMap<>();
        rentedMovies = new TreeSet<>();
        priceMap = new HashMap<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            priceMap.put(key(shop, movie), price);

            availableMovies
                .computeIfAbsent(movie, k -> new TreeSet<>())
                .add(new MovieEntry(price, shop, movie));
        }
    }

    /** Search: return up to 5 cheapest shops renting a given movie */
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (availableMovies.containsKey(movie)) {
            Iterator<MovieEntry> it = availableMovies.get(movie).iterator();
            int count = 0;
            while (it.hasNext() && count < 5) {
                result.add(it.next().shopId);
                count++;
            }
        }
        return result;
    }

    /** Rent: move from available -> rented */
    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        MovieEntry entry = new MovieEntry(price, shop, movie);

        availableMovies.get(movie).remove(entry);
        rentedMovies.add(entry);
    }

    /** Drop: move from rented -> available */
    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        MovieEntry entry = new MovieEntry(price, shop, movie);

        rentedMovies.remove(entry);
        availableMovies.get(movie).add(entry);
    }

    /** Report: return up to 5 cheapest rented movies as {shop, movie} */
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<MovieEntry> it = rentedMovies.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            MovieEntry entry = it.next();
            result.add(Arrays.asList(entry.shopId, entry.movieId));
            count++;
        }
        return result;
    }

    /** Utility: generate unique key for (shop, movie) */
    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }

    /** Helper class for storing movie info with sorting rules */
    private static class MovieEntry implements Comparable<MovieEntry> {
        int price;
        int shopId;
        int movieId;

        MovieEntry(int price, int shopId, int movieId) {
            this.price = price;
            this.shopId = shopId;
            this.movieId = movieId;
        }

        @Override
        public int compareTo(MovieEntry other) {
            if (this.price != other.price)
                return Integer.compare(this.price, other.price);
            if (this.shopId != other.shopId)
                return Integer.compare(this.shopId, other.shopId);
            return Integer.compare(this.movieId, other.movieId);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MovieEntry)) return false;
            MovieEntry other = (MovieEntry) obj;
            return this.price == other.price && this.shopId == other.shopId && this.movieId == other.movieId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shopId, movieId);
        }
    }

    // ======= Example Usage =======
    public static void main(String[] args) {
        int[][] entries = {
            {1, 101, 5},
            {2, 101, 4},
            {3, 101, 7},
            {1, 102, 6},
            {2, 103, 2}
        };

        MovieRentingSystem mrs = new MovieRentingSystem(3, entries);

        System.out.println("Search 101: " + mrs.search(101)); // cheapest shops for movie 101
        mrs.rent(2, 101);
        System.out.println("Report after renting: " + mrs.report());
        mrs.drop(2, 101);
        System.out.println("Report after dropping: " + mrs.report());
    }
}
