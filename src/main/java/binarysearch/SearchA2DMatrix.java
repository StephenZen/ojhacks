    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;    
        }
        
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        
        if (rowLength == 0 || columnLength == 0) {
            return false;
        }

        int start = 0;
        int end = rowLength * columnLength - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / columnLength;
            int column = mid % columnLength;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (matrix[start / columnLength][start % columnLength] == target) {
            return true;
        }
        if (matrix[end / columnLength][end % columnLength] == target) {
            return true;
        }

        return false;
    }
