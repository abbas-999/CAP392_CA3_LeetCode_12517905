import java.util.*;

class NumberContainers {

    HashMap<Integer, Integer> a = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> b = new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {

        if(a.containsKey(index)){

            int old = a.get(index);

            b.get(old).remove(index);
        }

        a.put(index, number);

        b.putIfAbsent(number, new TreeSet<>());

        b.get(number).add(index);
    }

    public int find(int number) {

        if(!b.containsKey(number) || b.get(number).isEmpty()){
            return -1;
        }

        return b.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * i
Saved$0nt param_2 = obj.find(number);
 */