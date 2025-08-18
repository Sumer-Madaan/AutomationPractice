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
When user clicks on "Place Order" button
And user selects "India" country and terms and conditions checkbox
And user clicks on "Proceed" button
Then user should get confirmation message and click on Home link in that

Scenario: Verify user is able to add products to cart and make order 2
Given user is on Greenkart Homepage page
When user search vegetable and select the quantity and click on ADD TO CART button
| Cucumber		| 3					|
| Musk Melon	| 5					|
Then Items, quantity and amount should reflect in cart
When user click on PROCEED TO CHECKOUT button
Then user should navigate to checkout page
Given User is on Greenkart Checkout page
#Then user must see details of all the added products in the cart
When user clicks on "Place Order" button
And user selects "India" country and terms and conditions checkbox
And user clicks on "Proceed" button
Then user should get confirmation message and click on Home link in that