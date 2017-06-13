public int strStr(String source, String target) {
    if(null == source || null == target){
        return -1;
    }
    for(int i; i < source.length() - target.length() + 1; i++){
        for(int j; j < target.length(); j++){
            if(source.charAt(i+j) != target.charAt(j)
                    break;
        }
        if(j.length() == target.lenght()){
            return i;
        }
    }
    return -1;
}
