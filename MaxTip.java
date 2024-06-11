

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // Create a list of orders with respective tips for both waiters and the difference in tips
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            orders.add(new Order(arr[i], brr[i], Math.abs(arr[i] - brr[i])));
        }
        
        // Sort orders by the absolute difference in tips in descending order
        orders.sort((o1, o2) -> Integer.compare(o2.diff, o1.diff));
        
        long totalTips = 0;
        int aCount = 0;
        int bCount = 0;

        // Iterate through sorted orders
        for (Order order : orders) {
            if ((order.aTip >= order.bTip && aCount < x) || bCount == y) {
                totalTips += order.aTip;
                aCount++;
            } else {
                totalTips += order.bTip;
                bCount++;
            }
        }

        return totalTips;
    }

    // Helper class to store order details
    static class Order {
        int aTip;
        int bTip;
        int diff;

        Order(int aTip, int bTip, int diff) {
            this.aTip = aTip;
            this.bTip = bTip;
            this.diff = diff;
        }
    }
}