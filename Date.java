 
/**
 * Write a description of class י here.
 *
 * @author Gavriel Barashi - id:206096679
 * @version 31-12-2022
 */
import java.math.*;
import java.time.*;
 
public class Date
{
    
  
    //consts
    final static String ZERO = "0";
    final static int TEN = 10;
    //attributes
    private int _day;
    private int _month;
    private int _year;
      
    //constructors
     public Date(){
    }
    
    //copier constructor
    public Date(Date d){
    this._day=d.getDay();
    this._month=d.getMonth();
    this._year=d.getYear();
    }
    
    //Method that return true if the date is proper or false in another case.
    public boolean checkDate(int _day,int _month,int _year){
    //boolean flag
    boolean flag=true;
        
    //Invalid months and Invalid years 
        
    if(_month<1 || _month >12  || _year<1000 || _year>9999 )
            flag=false;
            //Invalid days for months 1,3,5,7,8,10,12
       else
       if((_month==1 || _month ==3 || _month ==5 || _month ==7 || _month==8 || _month ==10 || _month==12) && (_day>31 || _day<1) )
        flag=false;
        
       else
       //Invalid days for months 4,6,9,11
       if((_month==4 || _month ==6 || _month ==9 || _month ==11) && (_day>30||_day<1))
             flag=false;
    
        else
       //Invalid days for month 2
        if(_month==2)
          {
        if(   (( _year%4!=0)||(_year%4==0&&_year%100==0&&_year%400!=0) ) && (_day>28 ||_day<1 ))
            flag=false;
                
        else if ( ((_year%4==0 && _year%100!=0) ||(_year%4==0&&_year%100==0 && _year%400==0)) &&(_day>29 || _day<1))    
                    flag=false;
            }
        return flag;
    }
    //constructor
    
    public Date(int _day,int _month,int _year){
        boolean flag=checkDate(_day,_month, _year);    
          
        if(!flag){
         this._day=1;
         this._month=1;
         this._year=2000;
                    }

        else{
         //proper date
         this._day=_day;
         this._month=_month;
         this._year=_year;
               }
    }
    
    public int getDay() {
        return this._day;
    }

    public void setDay(int _day){
    this._day = _day;
    }

    public int getMonth(){
    return this._month;
    }

    public void setMonth(int _month){
    this._month = _month;
    }

    public int getYear(){
    return this._year;
    }

    public void setYear(int _year){
    this._year = _year;
    }
 
    public boolean equals (Date other)
    {
        if(this._day== other.getDay() && this._month == other.getMonth() && this._year == other.getYear())
            return true;
        return false;
    }
    
    public boolean before (Date other){
        if (this.getYear() < other.getYear() )
            return true;
        else if(this.getYear() == other.getYear() && this.getMonth() < other.getMonth() )
            return true;
        else if (this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() < other.getDay() )
            return true;
        else
            return false;
    }
    
       public boolean after(Date other)
    {
        //boolean ans;
        //ans=this.before(other);
    //if (ans)
         //  return false;
    //return true;
    return other.before(this);
    
    } 
    
    public String toString()
    {
        if (this.getMonth() < TEN && this. getDay()<TEN){
            String ans = ZERO + this.getDay() + "/" + ZERO + "" +this.getMonth() + "/" +this.getYear();
            return ans;
        }
        else if (this.getMonth() >= TEN && this.getDay() < TEN){
             String ans = ZERO + "" + this.getDay() + "/" +this.getMonth() + "/" +this.getYear();
            return ans;
        }
        else if (this.getMonth() < TEN && this.getDay() >= TEN) {
            String ans = this.getDay() + "/" + ZERO + "" +this.getMonth() + "/" +this.getYear();
            return ans;
        }
        else{
            String ans = this.getDay() + "/" +this.getMonth() + "/" +this.getYear();
            return ans;
        }
    }
    
    public int difference(Date other){
        int dif=0;
        dif=Math.abs(calculateDate(this._day,this._month,this._year)-calculateDate(other.getDay(),other.getMonth(),other.getYear()));        
            return dif;
       
   
    }
    
    private int calculateDate(int day,int month,int year){
        if(month<3)
        {
         year--;
         month=month+12;
        }
        return 365*year+year/4-year/100+year/400+((month+1)*306)/10+(day-62);
    }
    
    public Date tomorrow(){
        Date d=new Date(this._day,this._month,this._year);
        
     if(checkDate(this._day,this._month,this._year)){    
        if((_month==1 || _month ==3 ||_month ==5 || _month ==7 || _month==8 || _month ==10) && (_day==31))
            
            d=d.addDay(d);
                
        else if((_month==4 || _month ==6 || _month ==9 || _month == 11) && (this._day==30))
                
            d=d.addDay(d);
                
        else if((( _year%4!=0)||(_year%4==0&&_year%100==0&&_year%400!=0))&& this._day==28)
                
            d=d.addDay(d);
                
        else if(((_year%4==0 && _year%100!=0) || (_year%4==0&&_year%100==0 && _year%400==0)) && this._day==29)
                   
            d=d.addDay(d);
        
        else if((_month==12)  && this._day==31)
                   
            addYear(this);
            
        else
            
            d.setDay(d.getDay()+1);
        }
        return d;
    }
    
    public Date addDay(Date d){
    d.setDay(1);
    d.setMonth(d.getMonth()+1);
    return d;
    }
    
    public Date addYear(Date Y){
    Y.setDay(1);
    Y.setMonth(1);
    Y.setYear(Y.getYear()+1);
    return Y;
    }
    }
   
