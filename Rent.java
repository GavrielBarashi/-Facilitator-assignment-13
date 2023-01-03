/**
 * Write a description of class י here.
 *
 * @author Gavriel Barashi - id:206096679
 * @version 31-12-2022
 */ 
public class Rent 
{
  
    final static int A=100,B=250,C=180,D=240;
    private String name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    
    public Rent(){
        // TODO Auto-generated constructor stub
    }

    public Rent(Rent other)
    {
    this.name=other.getName();
    this._car=new Car(other.getCar());
    this._pickDate=new Date(other.getPickDate());

    this._returnDate=new Date(other.getReturnDate());
    }

    public Rent(String name,Car _carDate ,Date _pickDate,Date _returnDate){
    this.name=name;
    this._car=new Car(_carDate);    
    this._pickDate=new Date(_pickDate);
    if(this._pickDate.before(_returnDate))
        this._returnDate=new Date(_returnDate);
    else{
        Date d=new Date(_pickDate);
        d.tomorrow();
        this._returnDate=new Date(d);
        }
    }
    
    public String getName(){
    return name;
    }

    public void setName(String name){
    this.name = name;
    }

    public Car getCar(){
    return _car;
    }

    public void setCar(Car _car){
    this._car = _car;
    }

    public Date getPickDate(){
    return _pickDate;
    }

    public void setPickDate(Date _pickDate){
    this._pickDate = _pickDate;
    }

    public Date getReturnDate(){
    return _returnDate;
    }

    public void setReturnDate(Date _returnDate){
    this._returnDate = _returnDate;
    }
    
    @Override
    public String toString(){
        return "Rent [name=" + name + ", _car=" + _car + ", _pickDate=" + _pickDate + ", _returnDate=" + _returnDate
                + "]";
    }
    
    public boolean equals(Rent other){
    if(this.name.equals(other.getName())&& this._pickDate.equals(other.getPickDate()) && this._returnDate.equals(other.getReturnDate()) && this._car.equals(other.getCar()))
        return true;
    return false;
    }
    
    public int howManyDays(){
    int days=this._pickDate.difference(this._returnDate);
    return days;
    }
    
    //A 100
    //B 150
    //C 180
    //D 240
    
    public int getPrice(){
    int price=0,dif=0,divideDays;
    
    if(this.howManyDays()%7!=0)
        dif=this.howManyDays()%7;
    
    divideDays=this.howManyDays()-dif;
    
    switch(this._car.getType()){
        case 'A':price= (A*divideDays)-(10*A*divideDays/100)+(dif*A); break;
        case 'B':price=(B*divideDays)-(10*B*divideDays/100)+(dif*B); break;
        case 'C':price=(C*divideDays)-(10*C*divideDays/100)+(dif*C); break;
        case 'D':price= (D*divideDays)-(10*D*divideDays/100)+(dif*D); break;
        }
        
    return price;
    }
    
    public int upgrade(Car newCar){
    int dif=0;
    if(newCar.better(this._car)){    
        this.setCar(newCar);
            return 1000;
           //which difference???
          }
        
    return dif;
        
    }
    }
