class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // Separate the letter-logs and digit-logs
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            // Split each log into identifier and content
            String[] parts = log.split(" ", 2);
            String identifier = parts[0];
            String content = parts[1];

            if (Character.isDigit(content.charAt(0))) {
                // It's a digit-log
                digitLogs.add(log);
            } else {
                // It's a letter-log
                letterLogs.add(log);
            }
        }

        // Sort the letter-logs:
        // 1. First by content, then by identifier if contents are the same
        Collections.sort(letterLogs, (log1, log2) -> {
            String[] parts1 = log1.split(" ", 2);
            String[] parts2 = log2.split(" ", 2);
            String content1 = parts1[1];
            String content2 = parts2[1];
            String id1 = parts1[0];
            String id2 = parts2[0];

            // Compare content
            int contentCompare = content1.compareTo(content2);
            if (contentCompare != 0) {
                return contentCompare; // Sort by content lexicographically
            }

            // If contents are the same, compare by identifier
            return id1.compareTo(id2);
        });

        // Convert the lists to arrays and concatenate
        String[] result = new String[logs.length];
        int index = 0;

        // Add all letter-logs first
        for (String log : letterLogs) {
            result[index++] = log;
        }

        // Add all digit-logs, maintaining their original order
        for (String log : digitLogs) {
            result[index++] = log;
        }

        return result;
    }
}
