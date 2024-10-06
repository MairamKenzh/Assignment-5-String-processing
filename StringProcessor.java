public class StringProcessor {

    // Method to check if the password is strong
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    // Method to count the number of digits in a sentence
    public int calculateDigits(String sentence) {
        if (sentence == null) return 0;

        int digitCount = 0;
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount;
    }

    // Method to calculate the number of words in a sentence
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Method to calculate the result of an arithmetic expression
    public double calculateExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        // Using JavaScript's engine for expression evaluation
        try {
            javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
            return ((Number) engine.eval(expression)).doubleValue();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error evaluating expression: " + e.getMessage());
        }
    }
}
