// Name: Swoyam Thapa
// Course: CSCI 2003 Spring 2023 - 60358
// Instructor: Kim Taylor
// File name: MonthlyFinance.java
//
// Program Description: MonthlyFinance class that allows you to put your income, expenses and expected savings for the month
//                      and it will calculate the savings you has and if your expected savings was reached or not.

/**
   MonthlyFinance class that allows you to put your inxom, expenses and expected savings for the month
   and it will calculate the savings you has and if your expected savings was reached or not.
*/

import java.util.*;

public class MoneyMomentum
{
   /**The monthly income*/
   private double monthlyIncome;
   /**The monthly expense*/
   private double monthlyExpenses;
   /**The monthly savigns or the money left*/
   private double moneyLeft;
   /**The expected savigns*/
   private double expectedSavings;
   /**is the expected savings reached*/
   private boolean expectedSavingsReached;
   /**tracks the expenses*/
   private HashMap<String,Double > expenses;
   /**a pointer for the unkonwn expenses*/
   private int unkonwnCount = 1;
   
   
   /**
      No argument constructor.
   */
   public MoneyMomentum()
   {
   
   }
   
   /**
      Constructs a Monthly Finance class
      @param monthlyIncome your income for the month.
      @param expenses your expenses for the month.
      @param expectedSavings your expected savings for the month.
   */
   public MoneyMomentum(double monthlyIncome, double expenses, double expectedSavings)
   {
      this.monthlyIncome = monthlyIncome;
      this.monthlyExpenses = expenses;
      this.expectedSavings = expectedSavings;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
      this.expenses = new HashMap<String,Double>();
   }
   
   /**
      Allows you to add income to your monthly income
      @param income additonal income
   */
   public void addIncome(double income)
   {
      this.monthlyIncome = this.monthlyIncome + income;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
   }
   
   /**
      Allows you to add expenses to your monthly expenses.
      @param expenses additional income
   */
   public void addExpenses(double expense)
   {
      String unknown = "Unknown Expense" + this.unkonwnCount;
      this.unkonwnCount++;
      this.expenses.put(unknown, expense);
      this.monthlyExpenses = this.monthlyExpenses + expense;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
   }
   
   /**
      Allows you to add expenseName and expense
      @param expenseName the name of the expenes
      @param expense the amount of expense
   */
   public void addExpenses(String expenseName, Double expense){
      if(expenses.containsKey(expenseName))
         this.expenses.put(expenseName, this.expenses.get(expenseName) + expense);
      else
         this.expenses.put(expenseName, expense);
      
      this.monthlyExpenses = this.monthlyExpenses + expense;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
   }
   
   /**
      Returns the expense amount if the expense is present else null
      @param expenseName the name of the expense you want to remove
      @return returns the amount of expense that is removed and if not present returns null
   */
   public Double removeExpense(String expenseName){
      if(expenses.containsKey(expenseName)){
         Double expense = this.expenses.remove(expenseName);
         this.monthlyExpenses = this.monthlyExpenses - expense;
         this.moneyLeft = monthlyIncome - monthlyExpenses;
         this.expectedSavingsReached = (moneyLeft > expectedSavings);
         return expense;
      }
      else
         return null; 
   }
   
   /**
      Returns your projected yearly savings
      @return projected yerarly savings
   */
   public double projectedYearlySavings()
   {
      return moneyLeft * 12;
   }
   
   /**
      Compares your income for two months
      @param m the month you want to compare to
      @return the comparision result
   */
   public String compareIncome(MoneyMomentum m)
   {
      String incomeComparision;
      
      if (this.monthlyIncome > m.monthlyIncome)
      {
         incomeComparision = "more income";
      }
      
      else if (this.monthlyIncome == m.monthlyIncome)
      {
         incomeComparision = "same income";
      }
      
      else
      {
         incomeComparision = "less income";
      }
      
      return "This month you had " + incomeComparision + " than the compred month.";
   }
   
   /**
      Compares your expenses for two months
      @param m the month you want to compare to
      @return the comparision result
   */
   public String compareExpenses(MoneyMomentum m)
   {
      String expenseComparision;
      
      if (this.monthlyExpenses >= m.monthlyExpenses)
      {
         expenseComparision = "more expense";
      }
      
      else if (this.monthlyExpenses == m.monthlyExpenses)
      {
         expenseComparision = "same income";
      }
      
      
      else 
      {
         expenseComparision = "less expense";
      }
      
      return "This month you had " + expenseComparision + " than the compred month.";
   }
   
   /**
      Compares your savigns for two months
      @param m the month you want to compare to
      @return the comparision result
   */
   public String compareSavings(MoneyMomentum m)
   {
      String savingComparision;
      
      if (this.moneyLeft >= m.moneyLeft)
      {
         savingComparision = "more saving";
      }
      
      else if (this.moneyLeft == m.moneyLeft)
      {
         savingComparision = "same income";
      }
      
      
      else
      {
         savingComparision = "less saving";
      }
      
      return "This month you had " + savingComparision + " than the compred month.";
   }
   
   /**
      Compares two months
      @param m the month you want to compare to
      @return the comparision result
   */
   public String compareMonths(MoneyMomentum m)
   {
      return this.compareIncome(m) + " " + this.compareExpenses(m) + " " + this.compareSavings(m);
   }
   
   /**
      Sets your monthly income
      @param income your income for the month
   */
   public void setMonthlyIncome(double income)
   {
      this.monthlyIncome = income;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
   }
   
   /**
      Sets your expected savings for the month
      @param expectedSavings your expected savings for the month
   */
   public void setExpectedSavings(double expectedSavings)
   {
      this.expectedSavings = expectedSavings;
   }
   
   /**
      Sets your monthly expenses
      @param expenses your expenses for the month
   */
   public void setExpenses(double expenses)
   {
      this.monthlyExpenses = expenses;
      this.moneyLeft = (monthlyIncome - monthlyExpenses);
      this.expectedSavingsReached = (moneyLeft > expectedSavings);
   }
   
   
   /**
      Returns your monthly savings
      @return your savings
   */
   public double getSavings()
   {
      return moneyLeft;
   }
   
   /**
      Retruns a statement saying if the expected savings is reached or not.
      @return a statement saying if the expected savings is reached or not.
   */
   public String isExpectedSavingsReached()
   {
      if (expectedSavingsReached)
      {
         return "Expected savings was reached.";
      }
      else
      {
         return "Expected savings was not reached.";
      }
   }
   
   /**
      Returns your monthly income
      @return your income
   */
   public double getIncome()
   {
      return monthlyIncome;
   }
   
   /**
      Returns your monthly expenses
      @return your expenses
   */
   public double getExpenses()
   {
      return monthlyExpenses;
   }
   
   /**
      Returns your expectedSavings for the month
      @return your expected savings
   */
   public double getExpectedSavings()
   {
      return expectedSavings;
   }
   
   /**
      Checks if two months have the same income, expenses and savings
      @param m the other month
      @return true if they are the same else false
   */
   public boolean equals(MoneyMomentum m)
   {
      return this.toString().equals(m.toString());
   }
   
   /**
      Returns the infomation of income, expenses, savings for the month
      @return a string with the information of the income, expense and savings of the month
   */
   public String toString()
   {
      return "This month you had a income of " + this.monthlyIncome + ". Your expenses for this month is " + this.monthlyExpenses + " and you had a savings of " + this.moneyLeft + ". Your expeced savings for this month was " + this.expectedSavings + " and " + this.isExpectedSavingsReached();
   }
   
   public void displayExpenses() {
      System.out.println("+----------------------------+----------------------------+");
      System.out.println("|          Expense           |            Value           |");
      System.out.println("+----------------------------+----------------------------+");
      int count = 1;
   
      for (Map.Entry<String,Double> entry : expenses.entrySet()) {
         String key = entry.getKey().toString();
         String value = entry.getValue().toString();
         System.out.printf("|%1d %-6s | %-7s |\n", count, key, value);
      }
   
      System.out.println("+--------+---------+");
   }
    
   public void display(){
      StringBuilder stringMapTable = new StringBuilder();
      stringMapTable.append("<table>");
   
      Iterator it = expenses.entrySet().iterator();
      while (it.hasNext()) {
         Map.Entry pair = (Map.Entry)it.next();
         stringMapTable.append("<tr><td>" + expenses.getKey() + "</td><td>" +expenses.getValue() + "</td></tr>");
         System.out.println(pair.getKey() + " = " + pair.getValue());
         it.remove(); // avoids a ConcurrentModificationException
      }
   
      String mapTable = stringMapTable.toString();
   }
   
}