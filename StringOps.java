public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String str = "MMMM";
        char a = 'M';
        //System.out.println("test of first function: " + capVowelsLowRest(str));
        //System.out.println("test of camel case: " + camelCase(str));
        //System.out.println("test of updated input for camel case: " + checkInput(str));
        int[] array = allIndexOf(str, a);
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");

        
    }

    public static String capVowelsLowRest (String string) {
        String answer = "";
        char chr;

        for (int i = 0; i < string.length(); i++) {
            chr = string.charAt(i);
            if (chr != ' ') {
                if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u')
                    answer += (char)(chr - 32);
                else {
                    if (chr == 'A' || chr == 'E' || chr == 'I' || chr == 'O' || chr == 'U')
                        answer += chr;
                    else {
                        if (chr >= 'B' && chr <= 'Z')
                            answer += (char)(chr + 32);
                        else 
                            answer += chr; 
                    }
                }
            } else 
                answer += chr;
        }
        return answer;
    }

    // helper function of camelCase
    public static String checkInput (String string) {
        String newStr = "";
        char chr = string.charAt(0), nextChr;
        int i = 0;

        while (chr == ' ') {
            i++;
            chr = string.charAt(i);
        }

        for (int j = i; j < string.length(); j++) {
            chr = string.charAt(j);
            if (chr != ' ')
                newStr += chr;
            else {
                nextChr = string.charAt(j+1);
                if (nextChr == ' ') {
                    while (nextChr == ' ') {
                        j++;
                        nextChr = string.charAt(j+1);
                    }
                    newStr += string.charAt(j);
                }
                else 
                    newStr += chr;
            }
        }

        return newStr;
    }

    public static String camelCase (String string) {
        string = checkInput(string);
        String answer = "";
        char chr = string.charAt(0), nextChr;
        int lastIdx = 0;

        // handling the first word in the string
        for (int i = 0; i < string.length() && string.charAt(i) != ' '; i++) {
            chr = string.charAt(i);
            if (chr >= 'A' && chr <='Z') 
                answer += (char)(chr + 32);
            else 
                answer += chr;
            lastIdx = i;
        }

        // handling the rest of the string
        int i = lastIdx + 1;
        while (i < string.length()) {
            chr = string.charAt(i);
            if (chr == ' ') {
                i++;
                nextChr = string.charAt(i);
                if (nextChr >= 'a' && nextChr <= 'z') {
                    answer += (char)(nextChr - 32);
                } else {
                    answer += nextChr;
                }
            } else {
                if (chr >= 'A' && chr <= 'Z') {
                    answer += (char)(chr + 32);
                } else 
                    answer += chr;
            }
            i++;
        }

        return answer;
    }

    public static int[] allIndexOf (String string, char chr) {
        int n = 0;

        // determining the size of the array of indexes by the nuber of appearnces of the character
        for (int i = 0; i  < string.length(); i++) {
            if (string.charAt(i) == chr)
                n++;
        }

        int[] idxArr = new int[n];
        int idx = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                idxArr[idx] = i;
                idx++;
            }
        }
        return idxArr;
    }
}
















