public static int[] solution(int area) {
        // Your code here
        int[] squares = new int[0];
        while(area>0){
            int l = (int) Math.sqrt(area);;
            squares = Arrays.copyOf(squares, squares.length + 1);
            squares[squares.length-1]=l*l;
            area-=l*l;
        }
        return squares;
    }
