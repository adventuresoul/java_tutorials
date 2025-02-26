package Tutorials;
import java.util.*;


public class Main {
    
    public static void findGeometricTriplets(int arr[], int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(arr[0]);

        // b * b = a * c
        // a = elt in hashSet
        // check for c by iterating in such a way that b * b / c = a
        for (int b = 1; b < n; b++) {
            for (int c = b + 1; c < n; c++) {
                int existing = 0;
                if ((arr[b] * arr[b]) % arr[c] == 0) {
                    existing = (arr[b] * arr[b]) / arr[c];
                }
                if (hashSet.contains(existing)) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(existing);
                    temp.add(arr[b]);
                    temp.add(arr[c]);
                    res.add(temp);
                }
            }
            hashSet.add(arr[b]);
        }

        // res.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));


        // usually implementing class for interface is through keyword 'implement'
        // example, class MyComparator implements Comparator<Type> {\
        //  @override
        //  public int compare(int a, int b) {
        //      comparision logic
        //  }
        // }
        // however in this case we are making ananymous inner class for implementing Comparator interface, no need to specify implements keyword
        // making a custom sort by passing custom comparator
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> r1, ArrayList<Integer> r2) {
                return Integer.compare(r1.get(0), r2.get(1));
            }
        });

        for (ArrayList<Integer> temp : res) {
            System.out.printf("%d %d %d", temp.get(0), temp.get(1), temp.get(2));
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        findGeometricTriplets(arr, N);
        sc.close();
    }
}