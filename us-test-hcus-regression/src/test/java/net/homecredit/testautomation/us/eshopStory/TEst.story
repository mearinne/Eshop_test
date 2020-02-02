
!-- ================================================
!-- Save values into context for following steps
!-- ================================================

Given save a value [https://www.czc.cz/] into a context [ESHOP_URL]

Given save a value [Nejdražší] into a context [EXPENSIVE_GOODS_TAB_NAME]

Given save a value [Zboží jsme vložili do košíku:] into a context [ADDED_TO_CARD_SUCCESS]

!-- =================
!-- Open the web page
!-- =================

Given open a web page with URL [ESHOP_URL]

!-- Wait till an element is clickable
Then wait on the page [eshop_home_page] for an element [tab_components] until is clickable

!-- Cursor hovering
Then on the page [eshop_home_page] hover element [tab_components]

!-- Wait till an element is clickable
Then wait on the page [eshop_home_page] for an element [tab_components_graph_cards] until is clickable

!-- choose one of the categories
When on the page [eshop_home_page] click on the element [tab_components_graph_cards]

!-- Wait till an element is clickable
Then wait on the page [components] for an element [biggest_price_category] until is clickable

!-- check the name of tab, if it is correct one
Then check on the page [components] the element [biggest_price_category] has value [EXPENSIVE_GOODS_TAB_NAME]

!-- select filtering by the biggest price of a product
When on the page [components] click on the element [biggest_price_category]

!-- processing wait
Then execution waits for 4 seconds

!-- Wait till an element is clickable
Then wait on the page [components] for an element [name_of_product_1] until is clickable

!-- scroll(focus) on an element
Then on the page [components] focus on element [name_of_product_1]

!-- save name of first product
Then on the page [components] save value of element [name_of_product_1] in to context [PRODUCT_NAME_1]

!-- Wait till an element is clickable
Then wait on the page [components] for an element [name_of_product_2] until is clickable

!-- save name of second product
Then on the page [components] save value of element [name_of_product_2] in to context [PRODUCT_NAME_2]

!-- add to the cart
When on the page [components] click on the element [add_to_cart_button_1]

!-- wait for element
Then wait on the page [cart_info] for an element [added_to_cart] until is clickable

!-- the product was successfully added to the cart
Then check on the page [cart_info] the element [added_to_cart] has value [ADDED_TO_CARD_SUCCESS]

!-- continue with shopping
When on the page [cart_info] click on the element [continue_button]

!-- wait for element
Then wait on the page [components] for an element [biggest_price_category] until is clickable

!-- to be sure we are in the correct category, we click on that again
When on the page [components] click on the element [biggest_price_category]

!-- wait for element
Then wait on the page [components] for an element [add_to_cart_button_2] until is clickable

!-- click on the second product to add it to the cart
When on the page [components] click on the element [add_to_cart_button_2]

!-- wait for element
Then wait on the page [cart_info] for an element [added_to_cart] until is clickable

!-- the product was successfully added to the cart
Then check on the page [cart_info] the element [added_to_cart] has value [ADDED_TO_CARD_SUCCESS]

!-- click on the cart icon
When on the page [eshop_home_page] click on the element [cart_icon]

!-- wait for element
Then wait on the page [cart_content] for an element [item_1_name] until is clickable

!-- =======================================================================
!-- !-- Check the name of products from components page are same as in cart
!-- =======================================================================
Then check on the page [cart_content] the element [item_1_name] has value [PRODUCT_NAME_1]
Then check on the page [cart_content] the element [item_2_name] has value [PRODUCT_NAME_2]