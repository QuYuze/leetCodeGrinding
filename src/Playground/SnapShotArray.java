package Playground;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapShotArray {

    //bbinary search approach
    class SnapshotArray1{
        //at each index are the versions
        List<int[]>[] snapShots;
        int version;

        public SnapshotArray1(int length) {
            version = 0;
            snapShots = new ArrayList[length];

            for(int i=0; i<length; i++){
                snapShots[i] = new ArrayList<>();
                snapShots[i].add(new int[]{-1, 0});
            }

        }

        //[0, 0]  [1. 0] [1, 0]
        //[2, 5]
        //[4, 6]


        //[0, 0] -> 1
        //[1, 5] -> 1
        public void set(int index, int val) {
            snapShots[index].add(new int[]{version, val});

        }

        public int snap() {
            return version++;
        }

        public int get(int index, int snap_id) {
            List<int[]> versions = snapShots[index];

            int left = 0;
            int right = versions.size() - 1;
            int mid = 0;

            while (left < right) {
                mid = right - (right - left) / 2;
                if (versions.get(mid)[0] <= snap_id) {
                    left = mid;
                } else{
                    right = mid - 1;
                }
            }

            //System.out.println(Arrays.toString(versions.get(left)));

            return versions.get(left)[1];

        }
    }

    class SnapshotArray {
        TreeMap<Integer, Integer>[] Tm;
        int snap_id = 0;
        public SnapshotArray(int length) {
            Tm = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                Tm[i] = new TreeMap<Integer, Integer>();
                Tm[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            Tm[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snap_id) {
            return Tm[index].floorEntry(snap_id).getValue();
        }
    }


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}
