
 class Industry {
    public double baseval;
    Company[] companies;
    public Industry()
    {
        companies=new Company[5];
    }
    public Industry(float baseval)
    {
        this.baseval=baseval;
        companies = new Company[5];
    }
    public void calcBase()
    {
        for(int i=0;i<5;i++)
        {
            baseval+=companies[i].networth;
        }
    }
    public void calcFall(float percent)
    {
        double newval= baseval -(percent*0.01*baseval);
        System.out.println("------------------------------");
        System.out.println("Actual market value is: "+ newval+ " cr\n");
    }

    public void taxLoss(float percent)
    {
        double loss=0;
        for(int i=0;i<5;i++)
        {
            loss += companies[i].calcTax(percent);
        }
        double lossper=loss*0.01*baseval;
        System.out.println("------------------------------");
        System.out.println("total loss on taxes: "+ loss+ " cr\n");
        System.out.println("Loss percentage is: "+lossper+" %");
    }
    public void display()
    {
        System.out.println("------------------------------");
        System.out.println("Base value is: "+ baseval+" cr\n");
        for(int i=0;i<5;i++)
        {
            companies[i].display();
        }

    }
    
}

 class Test
{
    public static void main(String[] args) {
        Company c1=new Company("Tata",40.0,40);
        Company c2=new Company("Maruti",20.0,38);
        Company c3=new Company("Hyundai",18.0,29);
        Company c4=new Company("Toyota",22.0,40);
        Company c5=new Company("Nissan",7.0,15);
        Industry market = new Industry();
        Company[] carr = {c1,c2,c3,c4,c5};
        market.companies=carr;
        market.display();
        market.calcBase();
        market.display();
        market.calcFall(9);
        market.taxLoss(15);

    }

}
