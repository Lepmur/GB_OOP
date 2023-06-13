package ru.geekbrains.dip;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<ReportItem> items;
    private final ReportOutput reportOutput;

    public Report(ReportOutput reportOutput) {
        this.reportOutput = reportOutput;
    }

    public void calculate() {
        items = new ArrayList<>();
        items.add(new ReportItem("First", (float) 5));
        items.add(new ReportItem("Second", (float) 6));
    }

    public void output() {
        reportOutput.output(items);
    }

}
