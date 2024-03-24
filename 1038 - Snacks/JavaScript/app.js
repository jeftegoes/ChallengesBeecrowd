const Product = require("./product");

var prompt = require("prompt-sync")();

const product1 = new Product(1, "Hotdog", 4);
const product2 = new Product(2, "Hotdog", 4.5);
const product3 = new Product(3, "Hotdog", 5);
const product4 = new Product(4, "Hotdog", 2);
const product5 = new Product(5, "Hotdog", 1.5);

const products = [product1, product2, product3, product4, product5];

console.log("-------- Select product --------");
products.forEach((product) => {
  console.log(product.toString());
});

const productAndPrice = prompt(
  "Enter the code and quantity of the product to be purchased: "
).split(" ");

products.forEach((product) => {
  if (product.code === parseInt(productAndPrice[0])) {
    console.log(product.price * parseFloat(productAndPrice[1]));
  }
});
