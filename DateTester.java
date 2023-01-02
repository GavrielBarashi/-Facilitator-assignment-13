
public class DateTester
{
    public static void main(String[] args) {
        System.out.println("********** Test Date - Started **********");
        String defDate = ("01/01/2000");
        System.out.println("\n\n*****TESTING CONSTRUCTOR******");
        System.out.println("setting valid date not leap: 09-11-2022 expected");
        Date dt1 = new Date (9, 11, 2022); // valid date not leap
        System.out.println((dt1.toString().equals("09/11/2022") ? "\t****TEST PASSED****" : "\t****TEST FAILED****"));
        System.out.println("DAY:"+dt1.getDay());
        System.out.println("MONTH:"+dt1.getMonth());
        System.out.println("YEAR:"+dt1.getYear());
        System.out.println("************************");
        System.out.println("setting year divided evenly by 4 but not leap");
        Date dt17 = new Date(29,02,1700);
        System.out.print(dt17);
        System.out.print((dt17.toString().equals(defDate)) ? "\t****TEST PASSED****\n" : "\t****TEST FAILED****\n" );
        Date dt18 = new Date(29,02,2300);
        System.out.print(dt18);
        System.out.print((dt18.toString().equals(defDate)) ? "\t****TEST PASSED****\n" : "\t****TEST FAILED****\n" );
        Date dt19 = new Date(28,02,1900);
        System.out.print(dt19);
        System.out.print((dt19.toString().equals("28/02/1900")) ? "\t****TEST PASSED****\n" : "\t****TEST FAILED****\n" );
        System.out.println("************************");
        System.out.println("setting valid date leap: 15-02-2024 expected");
        Date dt2 = new Date (15, 2, 2024); // valid date leap
        System.out.print((dt2.toString()));
        System.out.print((dt2.toString().equals("15/02/2024")) ? "\t****TEST PASSED****\n" : "\t****TEST FAILED****\n" );
        System.out.println("************************");
        System.out.println("setting invalid month default expected: 01-01-2000");
        Date dt3 = new Date (9, 14, 2022); // invalid month
        System.out.print(dt3);
        System.out.print((dt3.toString().equals(defDate)) ? "\t***TEST PASSED***\n" : "\t***TEST FAILED***\n");
        System.out.println("************************");
        System.out.println("setting invalid day in leap default expected");
        Date dt4 = new Date (30, 2, 2022); // invalid day+leap
        System.out.print(dt4);
        System.out.print((dt4.toString().equals(defDate)) ? "\t***TEST PASSED***\n" : "\t***TEST FAILED***\n");
        System.out.println("************************");
        System.out.println("setting invalid year default expected");
        Date dt5 = new Date (15, 2, -100); // invalid year
        System.out.print(dt5);
        System.out.print((dt5.toString().equals(defDate)) ? "\t***TEST PASSED***\n" : "\t***TEST FAILED***\n");
        System.out.println("************************\n\n");
        System.out.println("*****TESTING FOR ALIASING******");
        Date dt10 = new Date (31, 1, 1467);
        Date dt11 = new Date(dt10);
        dt11.setYear(1990);
        System.out.println(((dt10.getYear()==1467) ? "\t***TEST PASSED**\n" : "\t***TEST FAILED YEAR 1467 EXPECTED**\n"));
        System.out.println("*****TESTING SETTERS******");
        System.out.println("**WAS:"+dt1);
        dt1.setDay(15);
        dt1.setMonth(5);
        dt1.setYear(2024);
        System.out.println("**NOW:"+dt1+" **EXPECTED: 15/05/2024\n");
        System.out.println("**WAS:"+dt2+" **SETTING LEAP FEB DAY WITH NOT LEAP YEAR**");
        dt2.setDay(29);
        dt2.setYear(2001);
        System.out.println("**NOW:"+dt2+" ** EXPECTED 29/02/2024\n");
        System.out.println("**WAS:"+dt3+" **SETTING INVALID DAY IN MONTH YEAR**");
        dt3.setMonth(11);
        dt3.setDay(31);
        System.out.print(dt3);
        System.out.println((dt3.toString().equals("01/11/2000") ? "\t****TEST PASSED EXPECTED: 01/11/2000****" : "\t****TEST FAILED EXPECTED: 01/11/2000****" ));
        System.out.println("\n\n*****TESTING BEFORE AFTER******");
        System.out.println("IS "+dt3+" BEFORE "+dt2+"? >> "+ dt3.before(dt2)+(((dt3.before(dt2)==true) ? "\tTEST PASSED" : "\tTEST FAILED")));
        System.out.println("IS "+dt3+" BEFORE "+dt3+"? >> "+ dt3.before(dt3) +(((dt3.before(dt3)==false) ? "\tTEST PASSED" : "\tTEST FAILED")) );
        System.out.println("IS "+dt2+" AFTER "+dt3+"? >> "+ dt2.after(dt3) +(((dt2.after(dt3)==true) ? "\t\tTEST PASSED" : "\tTEST FAILED")) );
        dt5.setDay(31);
        dt5.setMonth(12);
        dt5.setYear(2022);
        dt4.setDay(1);
        dt4.setMonth(1);
        dt4.setYear(2023);
        System.out.println("IS "+dt4+" BEFORE "+dt5+"? >> "+ dt4.before(dt5) +(((dt4.before(dt5)==false) ? "\tTEST PASSED" : "\tTEST FAILED")) );
        System.out.println("IS "+dt5+" AFTER "+dt4+"? >> "+ dt5.after(dt4) +(((dt5.after(dt4)==false) ? "\tTEST PASSED" : "\tTEST FAILED")) );
        System.out.println("IS "+dt4+" AFTER "+dt4+"? >> "+ dt4.after(dt4) +(((dt4.after(dt4)==false) ? "\tTEST PASSED" : "\tTEST FAILED")));

        System.out.println("\n\n*****TESTING CALCULATE DIFFERRENCE******");
        dt5.setYear(2024);
        dt5.setDay(29);
        dt5.setMonth(2);
        dt4.setDay(10);
        dt4.setMonth(11);
        dt4.setYear(2022);
        System.out.println("FROM 29/02/2024 TILL 10/11/2022 THERE IS: "+dt4.difference(dt5)+" DAYS");
        System.out.println((dt4.difference(dt5)==476) ? "\t***TEST PASSED (476)***" : "\t***TEST FAILED (EXPECTED 476)***");
        System.out.println("\n*****TESTING TOMORROW******");
        dt3.setMonth(12);
        dt3.setDay(31);
        dt3.setYear(2022);
        System.out.println("****TODAY IS:"+dt5+" TOMMORROW IS: "+dt5.tomorrow() + ((dt5.tomorrow().toString().equals("01/03/2024")) ? "\t***TEST PASSED***" : "\t***TEST FAILED***") );
        dt4.setDay(30);
        System.out.println("****TODAY IS:"+dt4+" TOMMORROW IS: "+dt4.tomorrow() + ((dt4.tomorrow().toString().equals("01/12/2022")) ? "\t***TEST PASSED***" : "\t***TEST FAILED***") );
        System.out.println("****TODAY IS:"+dt3+" TOMMORROW IS: "+dt3.tomorrow() + ((dt3.tomorrow().toString().equals("01/01/2023")) ? "\t***TEST PASSED***" : "\t***TEST FAILED***") );

        // YD
        System.out.println("\ntesting accuracy of setYear method");
        Date dt20 = new Date(29, 2, 2020);
        dt20.setYear(2021);
        System.out.println("\t" + dt20);
        System.out.println("\t^ this should stay 29/02/2020");

        System.out.println("\ntesting accuracy of setMonth method");
        Date dt21 = new Date(31,1,2019);
        dt21.setMonth(11);
        System.out.println("\t" + dt21);
        System.out.println("\t^ this should stay 31/01/2019");

        System.out.println("\ntesting accuracy of leapYear checking");
        Date dt12 = new Date(29,2,2100);
        System.out.println("\t" + dt12);
        Date dt13 = new Date(29,2,2023);
        System.out.println("\t" + dt13);
        System.out.println("\t^ these should both be 01/01/2000");

        System.out.println("Testing the tomorrow method");
        Date dt14 = new Date(28,2,2021);
        Date dt15 = dt14.tomorrow();
        System.out.println("\t" + dt15);
        System.out.println("\t^ this should be 01/03/2021");

        System.out.println("\n********** Test Date - Finished **********");
    }


}

