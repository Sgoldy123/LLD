//package ExternalAPIwithCache;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.time.Duration;
//import java.util.concurrent.ConcurrentHashMap;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class ExternalApiWithCache {
//    private final HttpClient httpClient;
//    private final ConcurrentHashMap<String, String> cache;
//
//    public ExternalApiWithCache() {
//        this.httpClient = HttpClient.newBuilder()
//                .connectTimeout(Duration.ofSeconds(10))
//                .build();
//        this.cache = new ConcurrentHashMap<>();
//    }
//
//    public String fetchUserData(String endpoint, int userId) throws Exception {
//        String cacheKey = endpoint + "?userId=" + userId;
//
//        // Check the cache for user-specific data
//        if (cache.containsKey(cacheKey)) {
//            System.out.println("Returning data from cache for userId: " + userId);
//            return cache.get(cacheKey);
//        }
//
//        // Build the HTTP request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI(endpoint))
//                .GET()
//                .timeout(Duration.ofSeconds(10))
//                .build();
//
//        // Call the external API
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Handle the response
//        if (response.statusCode() == 200) {
//            String responseBody = response.body();
//            JSONArray jsonArray = new JSONArray(responseBody);
//
//            // Filter data for the specific userId
//            String userData = null;
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                if (jsonObject.getInt("userId") == userId) {
//                    userData = jsonObject.toString();
//                    break;
//                }
//            }
//
//            if (userData != null) {
//                // Cache the result for this user
//                cache.put(cacheKey, userData);
//                return userData;
//            } else {
//                throw new RuntimeException("User with userId " + userId + " not found in the response.");
//            }
//        } else {
//            throw new RuntimeException("Failed to fetch data. Status code: " + response.statusCode());
//        }
//    }
//
//    public static void main(String[] args) {
//        ExternalApiWithCache apiWithCache = new ExternalApiWithCache();
//        try {
//            String url = "https://jsonplaceholder.typicode.com/posts";
//
//            System.out.println("Fetching details for userId 1:");
//            System.out.println(apiWithCache.fetchUserData(url, 1));
//
//            System.out.println("\nFetching details for userId 2:");
//            System.out.println(apiWithCache.fetchUserData(url, 2));
//
//            System.out.println("\nFetching details for userId 1 again (from cache):");
//            System.out.println(apiWithCache.fetchUserData(url, 1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
