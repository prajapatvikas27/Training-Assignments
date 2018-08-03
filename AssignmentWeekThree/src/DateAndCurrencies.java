
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
public class DateAndCurrencies {

    public static void main(String[] args) throws ParseException {

        long number = 5000000L;
        NumberFormat numberFormatDefault = NumberFormat.getInstance();
        System.out.println("Number Format using Default Locale: "+numberFormatDefault.format(number));
        NumberFormat numberFormatLocale = NumberFormat.getInstance(Locale.ITALY);
        System.out.println("Number Format using ITALY Locale: "+numberFormatLocale.format(number));
        NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
        System.out.println("Currency Format using Default Locale: "+numberFormatDefaultCurrency.format(number));

        NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY);
        System.out.println("Currency Format using ITALY Locale: "+numberFormatLocaleCurrency.format(number));

        Currency currency = Currency.getInstance(Locale.CHINA);
        System.out.println(currency.getDisplayName()+" ("+currency.getCurrencyCode()+") "+currency.getDisplayName());

        Date currentDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);

        System.out.println("Date Format in German Locale: "+dateFormat.format(currentDate));
        
        DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatter = new SimpleDateFormat("yy-dd-MM");
        Date convertedDate = parser.parse(currentDate.toString());
        String output = formatter.format(convertedDate);
        
        
    }

}
