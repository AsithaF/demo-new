package com.hardwareproject.demo;





    public class Inventory {
        private int inventoryId;
        private String productName;
        private double productPrice;
        private int productQuty;

        public Inventory(int inventoryId, String productName, double productPrice, int productQuty) {
            this.inventoryId = inventoryId;
            this.productName = productName;
            this.productPrice = productPrice;
            this.productQuty = productQuty;
        }

        public int getInventoryId() {
            return inventoryId;
        }

        public String getProductName() {
            return productName;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public int getProductQuty() {
            return productQuty;
        }
    }

