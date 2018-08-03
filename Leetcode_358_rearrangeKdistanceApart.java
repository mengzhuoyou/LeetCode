package com.company;

import java.util.*;

public class Leetcode_358_rearrangeKdistanceApart {
    class Solution {
        class element {
            Character key;
            Integer value;

            element(Character key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        public String rearrangeString(String s, int k) {
            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> map = new HashMap<>();
            for (Character c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            PriorityQueue<element> maxHeap = new PriorityQueue<element>(map.size(), new Comparator<element>() {
                public int compare(element e1, element e2) {
                    if (e1.value > e2.value) {
                        return -1;
                    } else if (e1.value == e2.value) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

            for (Character key : map.keySet()) {
                maxHeap.offer(new element(key, map.get(key)));
            }

            Queue<element> waitQueue = new LinkedList<>();

            while (!maxHeap.isEmpty()) {
                element cur = maxHeap.poll();
                sb.append(cur.key);
                cur.value--;
                waitQueue.offer(cur);

                if (waitQueue.size() < k) {
                    continue;
                }

                element candidate = waitQueue.poll();
                if (candidate.value > 0) {
                    maxHeap.offer(candidate);
                }
            }

            return sb.length() == s.length() ? sb.toString() : "";
        }
    }
}
