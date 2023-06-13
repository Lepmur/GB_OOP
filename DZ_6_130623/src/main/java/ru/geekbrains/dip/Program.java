package ru.geekbrains.dip;

public class Program {

    public static void main(String[] args) {
        ReportOutput reportOutput = new PrintReport();
        Report report = new Report(reportOutput);
        report.calculate();
        report.output();
    }

}
