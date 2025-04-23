package Playground;

import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandomO1 {
    class RandomizedSet {

        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list= new ArrayList<>();
        }

        public boolean insert(int val) {

            if(map.containsKey(val)){
                return false;
            }else{
                map.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        public boolean remove(int val) {

            if(map.containsKey(val)){
                int index = map.get(val);
                list.set(index, list.get(list.size()-1));
                map.put(list.get(index), index);
                list.remove(list.size()-1);
                map.remove(val);
                return true;
            }else{
                return false;
            }

        }

        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
