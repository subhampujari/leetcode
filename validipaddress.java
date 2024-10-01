import java.util.regex.Pattern;
class Solution {
    public String validIPAddress(String queryIP) {
         if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    private boolean isValidIPv4(String ip) {
        // Check for leading or trailing dots
    if (ip.startsWith(".") || ip.endsWith(".")) return false;

    String[] parts = ip.split("\\.");
    if (parts.length != 4) return false;

    for (String part : parts) {
        // Check if part is a valid integer between 0 and 255 and no leading zeros
        if (part.length() == 0 || part.length() > 3 || (part.length() > 1 && part.startsWith("0"))) {
            return false;
        }
        try {
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    return true;
    }
private boolean isValidIPv6(String ip) {
         // Check for leading or trailing colons
    if (ip.startsWith(":") || ip.endsWith(":")) return false;

    String[] parts = ip.split(":");
    if (parts.length != 8) return false;

    for (String part : parts) {
        if (part.length() == 0 || part.length() > 4) return false;
        if (!Pattern.matches("[0-9a-fA-F]{1,4}", part)) {
            return false;
        }
    }
    return true;
    }
}
