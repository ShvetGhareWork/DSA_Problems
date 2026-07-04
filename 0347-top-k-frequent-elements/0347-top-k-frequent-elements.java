class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()) q.offer(key);

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = q.poll();
        }
        return ans;
    }
}

/*
1. Frequency Counting
java

Copy
HashMap<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < nums.length; i++){
    int num = nums[i];
    map.put(num, map.getOrDefault(num, 0) + 1);
}
What it does: Iterates through the input array nums.
Logic: map.put(num, count + 1) stores the number as the key and its occurrence count as the value.
Result: A map like {1: 3, 2: 2, 3: 1} (if 1 appeared 3 times, 2 appeared 2 times, etc.).
2. The Custom PriorityQueue
java

Copy
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
Default Behavior: A standard PriorityQueue is a Min-Heap (smallest element at the top).
The Lambda: (a, b) -> map.get(b) - map.get(a) creates a Custom Comparator.
It compares the frequencies of two numbers a and b.
map.get(b) - map.get(a):
If freq(b) > freq(a), result is positive $\to$ b is "smaller" in the heap logic $\to$ b moves to the top.
This effectively creates a Max-Heap based on frequency. The number with the highest count will be at the root.
3. Populating the Queue
java

Copy
for(int key : map.keySet()){
    pq.offer(key);
}
Iterates over the unique keys in the map.
Adds each number to the PQ. The PQ automatically reorganizes itself so the element with the highest frequency is always at the top (poll() will return it first).
4. Extracting the Top K
java

Copy
int[] ans = new int[k];
for(int i = 0; i < k; i++){
    ans[i] = pq.poll();
}
return ans;
Creates an array of size k.
Polls the top element $k$ times. Since the PQ is ordered by frequency (highest first), you get the $k$ most frequent numbers.
Dry Run Example
Input: nums = [1, 1, 1, 2, 2, 3], k = 2

Map Construction:

1 appears 3 times.
2 appears 2 times.
3 appears 1 time.
map = {1: 3, 2: 2, 3: 1}
PriorityQueue Insertion:

Add 1 (freq 3). PQ: [1]
Add 2 (freq 2). PQ: [1, 2] (1 is at top)
Add 3 (freq 1). PQ: [1, 2, 3] (1 is at top, then 2, then 3)
Note: The internal array structure might differ, but the root is always the max frequency.
Extraction:

i = 0: pq.poll() returns 1 (freq 3). ans[0] = 1.
i = 1: pq.poll() returns 2 (freq 2). ans[1] = 2.
Output: [1, 2]
 */