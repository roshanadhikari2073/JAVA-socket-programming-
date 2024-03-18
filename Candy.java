class Candy {
    public int candy(int[] ratings) {
   
        int[] candies = new int[ratings.length];
        candies[0] = 1;

        int len = ratings.length;

        for(int i = 1; i < len; i++) {

            candies[i] = 1; 

            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i - 1] + 1;
            }

        }

        int totalSum = candies[len - 1];

        for(int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }

            totalSum += candies[i];
        }

        return totalSum;

    }

}

