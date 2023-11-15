package org.example.project.objectOriented;

public class Polymorphic {
    public static void main(String[] args){
        /**
         * @多态
         * 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。
         *
         * @Override
         * 在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）。
         */
        PersonOfPolyMorphic ming = new StudentOfPolyMorphic();

        ming.run();

        /**
         * @practice： TODO: 给一个有工资收入和稿费收入的小伙伴算税:
         */

        Income[] incomes = new Income[] { new Income(3000), new SalaryIncome(7500), new RoyaltyIncome(12000) };
        double total = 0;
        // TODO:
        for(Income income : incomes){
            total += income.getTax();
        }
        System.out.println("total:"+total);
    }
}


class PersonOfPolyMorphic{
    public void run(){
        System.out.println("PersonRun");
    }
}


class StudentOfPolyMorphic extends PersonOfPolyMorphic{
    @Override
    public void run(){
        System.out.println("StudentRun");
    }
}

/**
 * practice
 */

class Income {

    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }

}

class SalaryIncome extends Income {

    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

/**
 * 稿费收入税率是20%
 */
class RoyaltyIncome extends Income {
    // TODO
    public RoyaltyIncome(double income){
        super(income);
    };
    @Override
    public double getTax(){
      return income * 0.2;
    };
}