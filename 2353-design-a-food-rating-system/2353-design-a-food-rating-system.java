import java.util.*;

class FoodRatings {

    HashMap<String, Integer> a = new HashMap<>();
    HashMap<String, String> b = new HashMap<>();
    HashMap<String, TreeMap<Integer, TreeSet<String>>> c = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for(int i = 0; i < foods.length; i++){

            a.put(foods[i], ratings[i]);
            b.put(foods[i], cuisines[i]);

            c.putIfAbsent(cuisines[i], new TreeMap<>());

            c.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());

            c.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {

        String s = b.get(food);
        int old = a.get(food);

        TreeMap<Integer, TreeSet<String>> d = c.get(s);

        d.get(old).remove(food);

        if(d.get(old).isEmpty()){
            d.remove(old);
        }

        a.put(food, newRating);

        d.putIfAbsent(newRating, new TreeSet<>());
        d.get(newRating).add(food);
    }

    public String highestRated(String cuisine) {

        int r = c.get(cuisine).lastKey();

        return c.get(cuisine).get(r).first();
    }
}