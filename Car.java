/**
 * Write a description of class י here.
 *
 * @author Gavriel Barashi - id:206096679
 * @version 31-12-2022
 */ 

public class Car{
     final static int DEFAULTID=9999999;
     final static int DEFID=999999;
     private int _id;
     private char _type;
     private String _brand;
     private boolean _isManual;
       
     public Car(){
            // TODO Auto-generated constructor stub
     }
        
     public Car(Car c){
    this._id = c.getId();
    this._type=c.getType();
    this._brand = c.getBrand();
    this._isManual=c.getisManual(); 
        }

     public Car (int id, char type, String brand, boolean isManual){
         if( id>DEFID && id<=DEFAULTID)
        this._id = id;
     else
        this._id=DEFAULTID;
     if(type=='A' || type =='B' || type =='C' || type =='D')
        this._type=type;
     else
        this._type='A';
        this._brand = brand;
        this._isManual = isManual;
     }
       
     public int getId(){
     return this._id;
     }
       
     public char getType(){
     return this._type;
     }
       
     public String getBrand(){
     return this._brand;
     }
       
     public boolean getisManual(){
     return this._isManual;
     }
       
     public void setId(int id){
    if( id>999999 && id<=9999999)
        this._id = id;
     }
       
     public void setType(char type){
       if(type=='A' || type =='B' || type =='C' || type =='D')
           this._type=type;
     }
       
     public void setBrand(String brand){
       this._brand = brand;
     }
       
     public void setIsManual(boolean manual){
       this._isManual = manual;
     }
       
     public boolean better (Car other){
          if (this._type > other._type){
               return true;
           }
           else if (this._type == other._type && this._isManual == false && other._isManual == true){
               return true;
           }
           else{
               return false;
           }
     }
     
     public String toString(){
       return ("id:"+this._id + " " +"type:"+ this._type + " " +"brand:"+ this._brand + " " + "gear:"+ this._isManual);
     }
        
     public boolean worse(Car other){
            boolean ans=this.better(other);
            if(ans)
                return false;
            return true;
            //way 2:return other.better(this);
    }
        
     public boolean equals(Car c){
            if( this._type==c.getType() && c._brand.equals(c.getBrand()) && this._isManual==c.getisManual())
                return true;
            return false;
        }
        }
        



