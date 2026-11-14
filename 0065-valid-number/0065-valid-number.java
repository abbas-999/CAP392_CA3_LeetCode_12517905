class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9'){
                a = true;

                if(c){
                    d = true;
                }
            }
            else if(ch == '.'){
                if(b || c){
                    return false;
                }
                b = true;
            }
            else if(ch == 'e' || ch == 'E'){
                if(c || !a){
                    return false;
                }
                c = true;
            }
            else if(ch == '+' || ch == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'){
                    return false;
                }
            }
            else{
                return false;
            }
        }

        return a && (!c || d);
    }
}