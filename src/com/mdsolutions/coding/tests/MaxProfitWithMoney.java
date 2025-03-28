package com.mdsolutions.coding.tests;

import java.util.Arrays;
import java.util.List;

public class MaxProfitWithMoney {

    public static int maxProfit(int[] prices, int money) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = 0;
        
        List<Integer> list = Arrays.stream(prices).boxed().map(p -> p).toList(); 
        System.out.println(list);
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice && prices[i] <= money) {
                buyPrice = prices[i];
            }
            int j = i+1;
            if(j < prices.length && prices[j] > buyPrice) {
            	System.out.println("==========================");
//            	for(int j=i+1; j < prices.length; j++){
            	while(j<prices.length) {
            		System.out.println("prices of j["+j+"] = "+prices[j]);
            		System.out.println("prices of i["+i+"] = "+prices[i]);
            		System.out.println("BuyPrice:: "+buyPrice);
            		if(prices[j] > prices[i] ){
            			int currentProfit = prices[j] - buyPrice;
            			if (currentProfit > maxProfit) {
            				maxProfit = currentProfit;
            				sellPrice = prices[j];
            			}
            		}
            		System.out.println("selling price:: "+sellPrice);
            		j++;
            	}
            }
        }
      if(buyPrice == Integer.MAX_VALUE){
        return 0;
      }
      System.out.println(buyPrice+":: "+sellPrice);

        return maxProfit;
    }

    public static void main(String[] args) {
        int money = 20;
        int[] prices = {23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17};

        int maxProfit = maxProfit(prices, money);
        System.out.println("Max Profit: " + maxProfit);
    }
}