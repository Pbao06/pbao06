package communityuni.com;

import java.util.ArrayList;

// Note: Renamed from 9_5_26 because Java class names cannot start with numbers.
// Rename your file to StaffSystem.java
public class StaffSystem {

    // --- class Staff ---
    public static class Staff {
        private ArrayList<StaffMember> staffList;

        public Staff() {
            staffList = new ArrayList<>();
        }

        public void addStaffMember(StaffMember member) {
            staffList.add(member);
        }

        public void payday() {
            for (StaffMember member : staffList) {
                System.out.println(member.toString());
                double amount = member.pay();
                if (amount == 0) {
                    System.out.println("Thanks for volunteering!");
                } else {
                    System.out.println("Paid: $" + amount);
                }
                System.out.println("-------------------------");
            }
        }
    }

    // --- class StaffMember ---
    public static abstract class StaffMember {
        protected String name;
        protected String address;
        protected String phone;

        public StaffMember(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone;
        }

        // Abstract: every subclass MUST implement their own pay logic
        public abstract double pay();
    }

    // --- class Volunteer ---
    public static class Volunteer extends StaffMember {
        public Volunteer(String name, String address, String phone) {
            super(name, address, phone);
        }

        @Override
        public double pay() {
            return 0; // Volunteers usually aren't paid
        }
    }

    // --- class Employee ---
    public static class Employee extends StaffMember {
        protected String socialSecurityNumber;
        protected double payRate;

        public Employee(String name, String address, String phone, String ssn, double rate) {
            super(name, address, phone);
            this.socialSecurityNumber = ssn;
            this.payRate = rate;
        }

        @Override
        public String toString() {
            return super.toString() + "\nSSN: " + socialSecurityNumber;
        }

        @Override
        public double pay() {
            return payRate;
        }
    }

    // --- class Executive ---
    public static class Executive extends Employee {
        private double bonus;

        public Executive(String name, String address, String phone, String ssn, double rate) {
            super(name, address, phone, ssn, rate);
            bonus = 0; // Bonus starts at 0
        }

        public void awardBonus(double execBonus) {
            this.bonus = execBonus;
        }

        @Override
        public double pay() {
            double totalPay = super.pay() + bonus;
            bonus = 0; // Reset bonus after payment
            return totalPay;
        }
    }

    // --- class Hourly ---
    public static class Hourly extends Employee {
        private int hoursWorked;

        public Hourly(String name, String address, String phone, String ssn, double rate) {
            super(name, address, phone, ssn, rate);
            hoursWorked = 0;
        }

        public void addHours(int moreHours) {
            hoursWorked += moreHours;
        }

        @Override
        public double pay() {
            double payment = payRate * hoursWorked;
            hoursWorked = 0; // Reset hours
            return payment;
        }
    }

    public static void main(String[] args) {
        Staff company = new Staff();

        // Adding different types of members
        company.addStaffMember(new Executive("Alice", "123 CEO Lane", "555-0101", "111-22-3333", 5000));
        company.addStaffMember(new Hourly("Bob", "456 Worker St", "555-0202", "444-55-6666", 20));
        company.addStaffMember(new Volunteer("Charlie", "789 Helper Blvd", "555-0303"));

        // Run payroll
        company.payday();
    }
}