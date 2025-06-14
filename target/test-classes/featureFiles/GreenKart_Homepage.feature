Feature: Verify Green Kart Ordering App.

Scenario: Verify user is able to add products to cart and make order
Given user is on Greenkart Homepage page
When user search vegetable and select the quantity and click on ADD TO CART button
| Potato		| 7					|
| Mushroom	| 5					|
Then Items, quantity and amount should reflect in cart
When user click on PROCEED TO CHECKOUT button
Then user should navigate to checkout page
Given User is on Greenkart Checkout page
#Then user must see details of all the added products in the cart
#When user clicks on "Place Order" button
#Then user should navigate to Address Validation page
#When user selects country and terms and conditions checkbox
#And click on "Proceed" button
#Then user should get confirmation message "Thank you, your order has been placed successfully
#You'll be redirected to Home page shortly!!"