Feature: Verify the homepage functionalities of Green Kart Homepage.

#Scenario Outline: Verify user is able to add products to cart
#Given user is on Greenkart Homepage
#When user search vegetable <vegetable>
#And select the <quantity>
#And click on ADD TO CART button
#Then Items, quantity and amount should reflect in cart
#
#Examples:
#| vegetable	| quantity	|
#| Potato		| 7					|
#| Mushroom	| 5					|


Scenario: Verify user is able to add products to cart
Given user is on Greenkart Homepage page
When user search vegetable and select the quantity and click on ADD TO CART button
| Potato		| 7					|
| Mushroom	| 5					|
Then Items, quantity and amount should reflect in cart
When user click on PROCEED TO CHECKOUT button
Then user should navigate to checkout page
Given User is on Greenkart Checkout page

#Scenario: Verify products at checkout page
#Given User is on Greenkart Checkout page
#Then user user should be able to see all the products added at homepage also displayed at checkoutpage
#When user clicks on Place Order button
#Then user user should navigate to user details page