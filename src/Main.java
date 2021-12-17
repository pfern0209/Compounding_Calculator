import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("What type of compounding info are your looking for: ");
        System.out.println("1: LumpSum");
        System.out.println("2: SIP");
        System.out.println("Enter your choice: ");
        int option=sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Enter principal amount");
                long principalAmt=sc.nextInt();
                System.out.println("Enter rate of interest");
                double compoundRateOfInterest=sc.nextDouble();
                double growthFactor=(double) compoundRateOfInterest/100;
                System.out.println("Enter period(years) of you want to stay invested for");
                int duration= sc.nextInt();
                double totalAmount=principalAmt*Math.pow((1+growthFactor),duration);
                System.out.println(totalAmount);
                break;

            case 2:
                System.out.println("Enter initial monthly investment amount: ");
                long currentMonthlyInvestment=sc.nextLong();
//                double currentMonthlyInvestment=sc.nextLong();
                System.out.println("Enter the percentage by which you will increment your monthly investment every year: ");
                double yearlyIncrement= sc.nextDouble();
                System.out.println("What %age of return are you expecting every year: ");
                double expectedCAGR=sc.nextDouble();
                System.out.println("How many years you want to invest for: ");
                int yearsInvesting=sc.nextInt();
                System.out.println("How many years you want to stay invested for: ");
                int yearsInvested=sc.nextInt();
//                double totalInvestedCorpus=0;
//                double compoundedCorpus=0;
                long totalInvestedCorpus=0;
                long compoundedCorpus=0;
                double returnFactor=(double)expectedCAGR/(double)100;
                double incrementFactor=(double)yearlyIncrement/(double)100;

                int currentYear=0;

                while(currentYear<yearsInvested){
                    if(currentYear<yearsInvesting){
                        currentYear++;
                        totalInvestedCorpus=totalInvestedCorpus+(currentMonthlyInvestment*12);
                        if(compoundedCorpus==0){
                            compoundedCorpus=(long)(totalInvestedCorpus+(totalInvestedCorpus*returnFactor));
//                            compoundedCorpus=(totalInvestedCorpus+(totalInvestedCorpus*returnFactor));

                        }else{
                            compoundedCorpus=(compoundedCorpus+(currentMonthlyInvestment*12))+(long)((compoundedCorpus+(currentMonthlyInvestment*12))*returnFactor);
//                            compoundedCorpus=(compoundedCorpus+(currentMonthlyInvestment*12))+((compoundedCorpus+(currentMonthlyInvestment*12))*returnFactor);
                        }
                        currentMonthlyInvestment=currentMonthlyInvestment+(long)(currentMonthlyInvestment*incrementFactor);
//                        currentMonthlyInvestment=currentMonthlyInvestment+(currentMonthlyInvestment*incrementFactor);

                    }else{
                        currentYear++;
                        compoundedCorpus=compoundedCorpus+(long)(compoundedCorpus*returnFactor);
//                        compoundedCorpus=compoundedCorpus+(compoundedCorpus*returnFactor);
                    }
                }

                System.out.println(totalInvestedCorpus);
                System.out.println(compoundedCorpus);
        }


        }




}
