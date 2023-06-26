package com.mistake.page;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 *
 * @author leoliu
 */
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    private final static int TWO = 2;

    private final static int THREE = 3;

    /**
     * 第一版本
     *
     * @return String
     */
    /*public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "/n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
                    break;
            }
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "Amount owed is " + totalAmount + "/n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
        return result;
    }*/

    /**
     * 第二版本
     *
     * @return String
     */
   /* public String statement2() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "/n";
        while (rentals.hasMoreElements()) {

            double thisAmount = 0;
            Rental each = rentals.nextElement();
            thisAmount = amountFor(each);
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "Amount owed is " + totalAmount + "/n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
        return result;
    }*/

    /**
     * 第三版本
     *
     * @return String
     */
  /*  public String statement3() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "/n";
        while (rentals.hasMoreElements()) {

            double thisAmount = 0;
            Rental each = rentals.nextElement();
            thisAmount = each.getCharge();
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
        }

        result += "Amount owed is " + totalAmount + "/n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
        return result;
    }*/

    /**
     * 第四版本
     *
     * @return String
     */
   /* public String statement4() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "/n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        result += "Amount owed is " + totalAmount + "/n";
        result += "You earned " + frequentRenterPoints + "frequent renter points";
        return result;
    }*/

    /**
     * 第五版本
     *
     * @return String
     */
    public String statement5() {
        double totalAmount = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for " + getName() + "/n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result.append("\t" + each.getMovie().getTitle());
            result.append("\t");
            result.append(each.getCharge());
            result.append("\n");
            totalAmount += each.getCharge();
        }
        result.append("Amount owed is " + getTotalCharge() + "/n");
        result.append("You earned " + getTotalFrequentRenterPoints() + "frequent renter points");
        return result.toString();
    }

    /**
     * 查询获取总金额
     *
     * @return double
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 查询积分
     *
     * @return int
     */
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        if (null == rentals) {
            return 0;
        }
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

   /* private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                break;
        }
        return thisAmount;
    }*/

    /*private double amountFor2(Rental each) {
        return each.getCharge();
    }*/
}
