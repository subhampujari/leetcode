import java.util.*;

class Solution {
 /*   public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        // Build graphs for day 1 and day 2
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

        // Run Floyd-Warshall to get all pair maximum conversion rates for both graphs
        Map<String, Map<String, Double>> day1Rates = floydWarshall(graph1);
        Map<String, Map<String, Double>> day2Rates = floydWarshall(graph2);

        // Initialize the map of amounts for day 1 (initial currency is 1)
        Map<String, Double> day1Amount = new HashMap<>();
        day1Amount.put(initialCurrency, 1.0);

        // Calculate the possible amount for each currency on day 1
        for (Map.Entry<String, Map<String, Double>> entry : day1Rates.entrySet()) {
            String currency = entry.getKey();
            if (day1Rates.containsKey(initialCurrency) && day1Rates.get(initialCurrency).containsKey(currency)) {
                day1Amount.put(currency, day1Rates.get(initialCurrency).get(currency));
            }
        }

        // Now calculate the maximum amount of initialCurrency we can get by converting through day 2 rates
        double amount = 1.0;
        for (Map.Entry<String, Double> entry : day1Amount.entrySet()) {
            String currency = entry.getKey();
            double currentAmount = entry.getValue();
            if (day2Rates.containsKey(currency)) {
                Map<String, Double> currencyRatesOnDay2 = day2Rates.get(currency);
                if (currencyRatesOnDay2.containsKey(initialCurrency)) {
                    amount = Math.max(amount, currentAmount * currencyRatesOnDay2.get(initialCurrency));
                }
            }
        }

        return amount;
    }

    // Method to build the graph from pairs and rates
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];

            // Add edge from 'from' to 'to' and from 'to' to 'from'
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(from).put(to, rate);
            graph.get(to).put(from, 1.0 / rate);
        }

        return graph;
    }

    // Floyd-Warshall Algorithm to compute the maximum conversion rates between currencies
    private Map<String, Map<String, Double>> floydWarshall(Map<String, Map<String, Double>> graph) {
        // Extract all the currencies (nodes)
        List<String> currencies = new ArrayList<>(graph.keySet());
        
        // Initialize the distance map (dist[i][j] = max rate from i to j)
        Map<String, Map<String, Double>> dist = new HashMap<>();

        for (String from : currencies) {
            dist.put(from, new HashMap<>());
            for (String to : currencies) {
                if (from.equals(to)) {
                    dist.get(from).put(to, 1.0);
                } else if (graph.get(from).containsKey(to)) {
                    dist.get(from).put(to, graph.get(from).get(to));
                } else {
                    dist.get(from).put(to, 0.0);
                }
            }
        }

        // Floyd-Warshall Algorithm: maximize the rate using intermediate currencies
        for (String k : currencies) {
            for (String i : currencies) {
                for (String j : currencies) {
                    dist.get(i).put(j, Math.max(dist.get(i).get(j), dist.get(i).get(k) * dist.get(k).get(j)));
                }
            }
        }

        return dist;
    }*/
        public double maxAmount(String init, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> dp = new HashMap<>();
        dp.put(init, 1.0);
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < pairs1.size(); ++j) {
                String a = pairs1.get(j).get(0), b = pairs1.get(j).get(1);
                dp.put(b, Math.max(dp.getOrDefault(b, 0.0), dp.getOrDefault(a, 0.0) * rates1[j]));
                dp.put(a, Math.max(dp.getOrDefault(a, 0.0), dp.getOrDefault(b, 0.0) / rates1[j]));
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < pairs2.size(); ++j) {
                String a = pairs2.get(j).get(0), b = pairs2.get(j).get(1);
                dp.put(b, Math.max(dp.getOrDefault(b, 0.0), dp.getOrDefault(a, 0.0) * rates2[j]));
                dp.put(a, Math.max(dp.getOrDefault(a, 0.0), dp.getOrDefault(b, 0.0) / rates2[j]));
            }
        }
        return dp.get(init);// or we can also solvd it using bfs or dfs 
    }
}

