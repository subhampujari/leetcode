class Solution {
    public int strongPasswordChecker(String password) {
       int n = password.length();
    int lowercase = 1; // 1 means missing
    int uppercase = 1; // 1 means missing
    int digit = 1;     // 1 means missing
    char[] characterList = password.toCharArray();
    int[] passwordArray = new int[password.length()];
    int result = 0;
   
    // Step 1: Check for missing character types
    for (int i = 0; i <  passwordArray.length; ) {
        if (Character.isLowerCase(characterList[i])) {
            lowercase = 0; // Found a lowercase letter
        }
        if (Character.isUpperCase(characterList[i])) {
            uppercase = 0; // Found an uppercase letter
        }
        if (Character.isDigit(characterList[i])) {
            digit = 0; // Found a digit
        }

        int j = i;
        while (i <  passwordArray.length && characterList[i] == characterList[j]) {
            i++;
        }

        passwordArray[j] = i - j; // Count the length of the repeating characters
    }

    // Step 2: Calculate total missing character types
    int totalMissing = (lowercase + uppercase + digit);

    if ( passwordArray.length < 6) {
        // If the password is too short
        result += totalMissing + Math.max(0, 6 -(passwordArray.length+ totalMissing));
    } else {
        // If the password is too long
        int extrCharacter = Math.max( passwordArray.length - 20, 0); // Excess characters
        int repeatingCharacter = 0;
        result += extrCharacter;

        // Step 3: Reduce repeating characters
        for (int k = 1; k < 3; k++) { // Check for groups of 1 and 2
            for (int i = 0; i < passwordArray.length && extrCharacter > 0; i++) {
                if (passwordArray[i] < 3 || passwordArray[i] % 3 != (k - 1)) {
                    continue;
                }
                passwordArray[i] -= Math.min(extrCharacter, k);
                extrCharacter -= k;
            }
        }
        // Step 4: Count repeating characters
        for (int i = 0; i <  passwordArray.length; i++) {
            if (passwordArray[i] >=3 && extrCharacter>0) {
                int need=passwordArray[i]-2;
                passwordArray[i]-=extrCharacter;
                extrCharacter-=need;
     
            }
            if(passwordArray[i]>=3){
               repeatingCharacter += passwordArray[i] / 3; // Count groups of 
        }
        }

        result += Math.max(totalMissing,repeatingCharacter); // Add the number of changes needed for repeating characters
    }

    return result; // Return the total number of changes needed
    }
}
