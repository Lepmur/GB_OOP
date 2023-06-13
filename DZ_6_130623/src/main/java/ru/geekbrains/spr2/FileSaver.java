package ru.geekbrains.spr2;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver implements DataSaver {

    public void saveJson(Order order) {
        String fileName = "order_1.json";
        String data = "{\"clientName\":\"" + order.getClientName() + "\",\"product\":\"" + order.getProduct() +
                "\",\"qnt\":" + order.getQnt() + ",\"price\":" + order.getPrice() + "}";
        saveToFile(fileName, data);
    }

    public void saveXML(Order order) {
        String fileName = "order_2.xml";
        String xml = "<Order>\n" +
                "    <clientName>" + order.getClientName() + "</clientName>\n" +
                "    <product>" + order.getProduct() + "</product>\n" +
                "    <qnt>" + order.getQnt() + "</qnt>\n" +
                "    <price>" + order.getPrice() + "</price>\n" +
                "</Order>";
        saveToFile(fileName, xml);
    }

    @Override
    public void saveToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(content);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}