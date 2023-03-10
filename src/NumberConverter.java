public class NumberConverter {
    int[] digits;

    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int returner = 0;
        if (base == 2) {
            int pwr = (int) Math.pow(2, digits.length - 1);
            for (int i = 0; i <= digits.length - 1; i++) {
                if (digits[i] == 1) {
                    returner += pwr;
                    pwr = pwr / 2;
                } else if (digits[i] == 0) {
                    pwr = pwr / 2;
                }
            }
            NumberConverter use = new NumberConverter(returner, 10);
            System.out.print("Number: " + use.displayOriginalNumber());
            return use.digits;
        }
        if (base == 8) {
            int sub = 0;
            for (int i = digits.length - 1; i >= 0; i --){
                returner += digits[i] * Math.pow(8, sub);
                sub ++;
            }
            NumberConverter use = new NumberConverter(returner, 10);
            return use.digits;
        }
        return null;
    }

    public int[] convertToBinary() {
        if (base == 10){
            int a = 0;
            int b = 0;
            int c = 0;
            int sub = Integer.parseInt(this.displayOriginalNumber());
            int count = 0;
            while (a <= sub){
                a += Math.pow(2, count);
                count ++;
                if (a > sub){
                    b = count;
                }
                else if(a == sub){
                    b = count;
                    a ++;
                }
            }
            int[] binary = new int[b];
            c = sub;
            for (int i = 0; i <= binary.length - 1; i ++){
                b --;
                if (c - Math.pow(2,b) > - 1){
                    binary[i] = 1;
                    c -= Math.pow(2, b);
                } else if (c - Math.pow(2, b) == 0) {
                    binary[i] = 1;
                    i = binary.length + 1;
                }
            }
            return binary;

        }
        if (base == 8){
            int returner = 0;
            int sub = 0;
            for (int i = digits.length - 1; i >= 0; i --){
                returner += digits[i] * Math.pow(8, sub);
                sub ++;
            }
            int a = 0;
            int b = 0;
            int c = 0;
            sub = Integer.parseInt(this.displayOriginalNumber());
            int count = 0;
            while (a <= sub){
                a += Math.pow(2, count);
                count ++;
                if (a > sub){
                    b = count;
                }
                else if(a == sub){
                    b = count;
                    a ++;
                }
            }
            int[] binary = new int[b];
            c = sub;
            for (int i = 0; i <= binary.length - 1; i ++){
                b --;
                if (c - Math.pow(2,b) > - 1){
                    binary[i] = 1;
                    c -= Math.pow(2, b);
                } else if (c - Math.pow(2, b) == 0) {
                    binary[i] = 1;
                    i = binary.length + 1;
                }
            }
            return binary;
        }
        return null;
    }

    public int[] convertToOctal() {
        if (base  == 10) {
            int num =  Integer.parseInt(this.displayOriginalNumber());
            int remain = 0;
            int sub = 1;
            while (num != 0) {
                remain += (num % 8) * sub;
                num = num / 8;
                sub = sub * 10;
            }
            NumberConverter oct = new NumberConverter(remain, 8);
            return oct.getDigits();
        }
        if (base == 2){
            int returner = 0;
            int pwr = (int) Math.pow(2, digits.length - 1);
            for (int i = 0; i <= digits.length - 1; i++) {
                if (digits[i] == 1) {
                    returner += pwr;
                    pwr = pwr / 2;
                } else if (digits[i] == 0) {
                    pwr = pwr / 2;
                }

            }
            int num =  returner;
            int remain = 0;
            int sub = 1;
            while (num != 0) {
                remain += (num % 8) * sub;
                num = num / 8;
                sub = sub * 10;
            }
            NumberConverter oct = new NumberConverter(remain, 8);
            return oct.getDigits();
        }
        return null;
    }
}




/*
int a = 0;
int b = 0;
int c = 0;
String str = "";
int i = 0;
while (a <= this.displayOriginalNumber()){
a = math.pow(2, i);
i++;
str = ("" + 0 + str);
if (a >= this.displayOriginalNumber()){
str = ("" + 1 + str);
}
}
for (int i = 0; a <= this.displayOriginalNumber; i ++){
a = Math.pow(2, i);
str = ("" + 0 + str);
}
 */