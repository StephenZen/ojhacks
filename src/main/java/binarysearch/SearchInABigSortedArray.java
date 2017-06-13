    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int start = 0;
        int end = 0;
        
        while (reader.get(end) < target) {
            start = end + 1;
            end = start * 2;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (reader.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        } 
        if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
    }