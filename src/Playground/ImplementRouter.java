package Playground;

import java.util.*;

//https://leetcode.com/problems/implement-router/
public class ImplementRouter {
    class Router {

        static class Packet{
            private final int src;
            private final int dst;
            private final int time;

            public Packet(int src, int dst, int time){
                this.src = src;
                this.dst = dst;
                this.time = time;
            }

            @Override
            public boolean equals(Object obj){
                if(this == obj){
                    return true;
                }
                if(!(obj instanceof Packet)){
                    return false;
                }
                Packet packet = (Packet) obj;
                return this.src == packet.src && this.dst == packet.dst && this.time == packet.time;
            }

            @Override
            public int hashCode(){
                return Objects.hash(src, dst, time);
            }



        }

        private int limit;
        private Queue<Packet> q;
        private HashSet<Packet> set;
        private HashMap<Integer, List<Packet>> dstToPacket;
        private HashMap<Integer, Integer> dstStartIndex;

        public Router(int memoryLimit) {
            this.limit = memoryLimit;
            q = new LinkedList<>();
            set = new HashSet<>();
            dstToPacket = new HashMap<>();
            dstStartIndex = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet packet = new Packet(source, destination, timestamp);

            if(set.contains(packet)){
                return false;
            }

            if(limit > 0){
                limit --;
            }else{
                Packet oldPacket = q.remove();
                set.remove(oldPacket);
                int oldDst = oldPacket.dst;
                int currtIndex = dstStartIndex.get(oldDst);
                dstStartIndex.put(oldDst, currtIndex+1);
            }

            q.add(packet);
            set.add(packet);
            dstToPacket.putIfAbsent(destination, new ArrayList<>());
            dstToPacket.get(destination).add(packet);
            dstStartIndex.putIfAbsent(destination, 0);

            return true;
        }

        public int[] forwardPacket() {

            if(q.isEmpty()){
                return new int[]{};
            }

            Packet packet = q.remove();
            set.remove(packet);

            List<Packet> packetsForDst = dstToPacket.get(packet.dst);
            int startIndex = dstStartIndex.get(packet.dst)+1;


            if(startIndex >= packetsForDst.size()){
                dstToPacket.remove(packet.dst);
                dstStartIndex.remove(packet.dst);
            }else{
                dstStartIndex.put(packet.dst, startIndex);
            }

            limit++;

            return new int[]{packet.src, packet.dst, packet.time};
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Packet> list = dstToPacket.get(destination);
            if(list==null || list.isEmpty()){
                return 0;
            }
            int start = dstStartIndex.getOrDefault(destination, 0);
            int lower = findLower(list, startTime, start);
            int upper = findUpper(list, endTime, start);
            return upper - lower;
        }

        private int findLower(List<Packet> list, int time, int start){
            int left = start;
            int right = list.size();

            while(left < right){
                int mid = (left + right) / 2;
                if(list.get(mid).time >= time){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            return left;
        }

        private int findUpper(List<Packet> list, int time, int start){
            int left = start;
            int right = list.size();

            while(left < right){
                int mid = (left + right) / 2;
                if(list.get(mid).time > time){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            return left;
        }
    }

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
}
