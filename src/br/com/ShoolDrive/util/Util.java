package br.com.ShoolDrive.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Util {

    private static Locale ptbr = new Locale("pt", "BR");
    public static DateTimeFormatter formatoData = DateTimeFormat.forPattern("dd/MMM/yyyy").withLocale(ptbr);

    /**
     * pega a data atual do sistema no formato dd/MM/yyyy
     * @return
     */
    public static String getDataAtual() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        calendar.setTime(date);
        return out.format(calendar.getTime());
    }

    /**
     * Metodo Resposavel por formatar a data no padrão dd/mm/yyyy
     */
    public static String formatarData(DateTime data) {
        return formatoData.print(data);
    }


}
