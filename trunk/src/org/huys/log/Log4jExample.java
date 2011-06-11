package org.huys.log;

import org.apache.log4j.Logger;

class CustomerOrder {

    private String productName;
    private int productCode;
    private int productPrice;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public CustomerOrder(String productName, int productCode, int productPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.productPrice = productPrice;
    }
}

public class Log4jExample {

    private static Logger logger = Logger.getLogger("name");

    public void processOrder(CustomerOrder order) {
        logger.info(order.getProductName());
    }

    public static void main(String args[]) {
        CustomerOrder order1 = new CustomerOrder("Beer", 101, 20);
        CustomerOrder order2 = new CustomerOrder("Lemonade", 95, 10);
        CustomerOrder order3 = new CustomerOrder("Chocolate", 223, 5);

        Log4jExample demo = new Log4jExample();
        demo.processOrder(order1);
        demo.processOrder(order2);
        demo.processOrder(order3);
    }
}

