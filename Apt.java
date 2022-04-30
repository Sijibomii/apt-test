//  MTN: 0703,0706,0803,0806,0810,0813,0814,0816,0903,0906,0913,0916,07025,07026,0704
// Airtel: 0701,0708,0802,0808,0812,0901,0902,0904,0907,0912
// Globacom: 0705,0805,0807,0811,0815,0905,0915
// 9Mobile: 0809,0817,0818,0909,0908
// MTEL: 0804
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Apt {
    public static void main(String[] args) {

        String path = "test.txt";
    
        try{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
        
        while ((st = br.readLine()) != null){
            String match = getOperator(st);
            // Print the string
            System.out.println(match);
    }
        }catch(Exception e){
          System.out.println("error");
        }
       
    }

    public static String getOperator(String number){
        if (mtn(number)){
            return "MTN";
        }else if (airtel(number)){
            return "AIRTEL";
        }else if (globacom(number)){
            return "GLOBACOM";
        }else if(nineMobile(number)){
            return "9MOBILE";
        } else if(mtel(number)){
            return "MTEL";
        } else{
            return "INVALID";
        }
    }

    public static boolean mtn(String number){
        return 
        Pattern.matches("070[364][0-9]{7}", number) ||
        Pattern.matches("080[36][0-9]{7}", number) ||
        Pattern.matches("081[0346][0-9]{7}", number) ||
        Pattern.matches("09[01][36][0-9]{7}", number) ||
        Pattern.matches("0702[56][0-9]{6}", number) ||
        Pattern.matches("0704[0-9]{7}", number);
    }

    public static boolean airtel(String number){
        return 
        Pattern.matches("070[18][0-9]{7}", number) ||
        Pattern.matches("080[28][0-9]{7}", number) ||
        Pattern.matches("081[2][0-9]{7}", number) ||
        Pattern.matches("090[1247][0-9]{7}", number) ||
        Pattern.matches("0912[0-9]{7}", number);
    }

    public static boolean globacom(String number){
        return 
        Pattern.matches("0705[0-9]{7}", number) ||
        Pattern.matches("080[57][0-9]{7}", number) ||
        Pattern.matches("081[15][0-9]{7}", number) ||
        Pattern.matches("09[01]5[0-9]{7}", number);
    }

    public static boolean nineMobile(String number){
        return Pattern.matches("0[89][01][978][0-9]{7}", number);
    }

    public static boolean mtel(String number){
        return Pattern.matches("0804[0-9]{7}", number);
    }
}