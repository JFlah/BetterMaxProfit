public class Pal {
    
    // [4,0,4,2] -> Buy on day 1 and sell on day 2
    
    static int potentialProfit;
    static int daySawLowest = 0;
    static int dayBought = 0;
    static int daySold = 1;
    
    
    public static void main(String args[]) {
        int[] prices = [4,1,4,2,0,2];
        int max = getMaxProfit(goldPrices);
    }
    
    static int getMaxProfit(int[] goldPrices) {
        // we bought on 0, sold on 1
        int maxProfit = goldPrices[1] - goldPrices[0];
        // buy for the first time
        int lowPrice = goldPrices[0];
        
        for (int i = 1; i < goldPrices.length; i++) {
            int currentPrice = goldPrices[i];
            
            // if lowPrice changes, we bought
            int tempLow = lowPrice;
            lowPrice = Math.min(lowPrice, currentPrice);
            if (lowPrice != tempLow) {
                daySawLowest = i;
            }
            
            potentialProfit = currentPrice - lowPrice;
            
            // if maxProfit changes, we sold
            if (daySawLowest != i) {
                int tempProf = maxProfit;
                maxProfit = Math.max(maxProfit, potentialProfit);
                if (maxProfit != tempProf) {
                    dayBought = daySawLowest;
                    daySold = i;
                }
            }
        }
        
        System.out.println("We bought on day: " + dayBought + " and we sold on day: " + daySold + ". The max profit was: " + maxProfit);
        
        return maxProfit;
    }
}