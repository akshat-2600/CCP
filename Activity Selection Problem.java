// T.C : O(NLOGN)
// S.C : O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
    int id;
    int start;
    int finish;

    public Activity(int id, int start, int finish) {
        this.id = id;
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelectionUnsorted {

    public static void printMaxActivities(int[] s, int[] f) {
        int n = s.length;
        List<Activity> activities = new ArrayList<>();

        // Step 1: Pack the values alongside their original indices
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(i, s[i], f[i]));
        }

        // Step 2: Sort activities based on finish times in ascending order.
        // If finish times match, it sorts by start times.
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if (a1.finish != a2.finish) {
                    return Integer.compare(a1.finish, a2.finish);
                }
                return Integer.compare(a1.start, a2.start);
            }
        });

        System.out.println("Following activities are selected:");

        // Step 3: Select the first activity from the sorted list
        Activity prev = activities.get(0);
        System.out.print(prev.id + " ");

        // Step 4: Process the remaining activities greedily
        for (int j = 1; j < n; j++) {
            Activity curr = activities.get(j);
            
            // If the start time is greater than or equal to the previous finish time
            if (curr.start >= prev.finish) {
                System.out.print(curr.id + " ");
                prev = curr; // Update the tracking pointer
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Notice these inputs are unsorted by finish times!
        int[] s = {5, 1, 3, 0, 5, 8};
        int[] f = {9, 2, 4, 6, 7, 9};

        printMaxActivities(s, f);
        // Correct Output: 1 2 4 5 (matching original IDs)
    }
}
