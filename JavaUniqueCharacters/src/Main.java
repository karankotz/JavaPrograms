public class Main {

    public static void main(String[] args) {
        
        String str = "abcd";
        int[] unique = new int[256];
        int flag = 0;
        for(int i=0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            int ascii = (int)c;
            if(unique[ascii] == 1)
            {
                System.out.println("Duplicate Found");
                flag = 1;
                break;
            }
            else
            {
                unique[ascii] = 1;
            }
        }
        if(flag != 1)
        {
            System.out.println("The string has the unique elements");
        }

    }
}
