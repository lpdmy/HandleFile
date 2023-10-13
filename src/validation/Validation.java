package validation;


public class Validation {

    public Validation() {
    }

    public double checkDoule(String input) throws Exception {
        while (true) {
            String temp = input.trim();
            if (temp == null) {
                return 0;
            }
            double rs;
            try {
                rs = Double.parseDouble(temp);
                if (rs < 0) throw new Exception();
            } catch (Exception e) {
                rs = 0;
            }

            return rs;
        }
    }

    public String checkName(String input) throws Exception {
        while (true) {
            String temp = input.trim();
            if (temp == null) {
                return null;
            }

        }

    }
}
