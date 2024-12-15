import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Define a max heap to prioritize classes with the highest ratio gain
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Populate the heap with the ratio gain and the current pass/fail count
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double gain = gainWithExtraStudent(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Distribute extra students
        while (extraStudents > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            extraStudents--;
            double newGain = gainWithExtraStudent(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }

        // Calculate the total average pass ratio
        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }

    // Helper function to calculate the gain in pass ratio for adding one student
    private double gainWithExtraStudent(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
