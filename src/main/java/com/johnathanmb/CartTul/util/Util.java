package com.johnathanmb.CartTul.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String createId(int quantityCarts){
        Date dateToday = new Date();
        String strDateFormat = "yyyy-MM";
        SimpleDateFormat objDataFormat = new SimpleDateFormat(strDateFormat);
        return objDataFormat.format(dateToday) + "-" + quantityCarts;
    }
}
