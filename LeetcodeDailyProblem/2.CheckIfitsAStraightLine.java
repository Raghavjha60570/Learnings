
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Calculate the slope between the first two points (coordinates[0] and coordinates[1])
        int xDiff = coordinates[1][0] - coordinates[0][0];
        int yDiff = coordinates[1][1] - coordinates[0][1];
        
        // Check the slope for all other consecutive points
        for (int i = 2; i < coordinates.length; i++) {
            // Use cross multiplication to avoid floating-point division
            if (yDiff * (coordinates[i][0] - coordinates[0][0]) != xDiff * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }
}
