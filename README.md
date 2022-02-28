# assignment-java-boot-camp

<h2>Design Shopping Flow and Action</h2>
<img src="https://user-images.githubusercontent.com/99329107/155902968-bbaf6777-82b0-4cff-a33b-e26bdea4e651.png" />
<table>
  <tr>
    <th>Method</th>
    <th>Url</th>
    <th>Description</th>
    <th>Response Body</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>/products/search/{name}</td>
    <td>Find product by name</td>
    <td>Json</td>
  </tr>
   <tr>
    <td>GET</td>
    <td>/products/id/{id}</td>
    <td>Find product by id</td>
    <td>Json</td>
  </tr>
   <tr>
    <td>POST</td>
    <td>/Cart/AddProductToCart</td>
    <td>Add product to cart</td>
    <td>Json</td>
  </tr>
   <tr>
    <td>GET</td>
    <td>/Cart/CartDetail/{userId}</td>
    <td>Get all product in cart</td>
    <td>Json</td>
  </tr>
   <tr>
    <td>DELETE</td>
    <td>/Cart/deleteItemInCart/{cartId}/{productId}</td>
    <td>Delete product in cart</td>
    <td>Json</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/CartCheckOut/addShippingAddress</td>
    <td>Add address for shipping</td>
    <td>Json</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/CartCheckOut/addPaymentMethod</td>
    <td>Add payment method</td>
    <td>Json</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/CartCheckOut/{userId}</td>
    <td>Get all detail for check out order</td>
    <td>Json</td>
  </tr>
</table>
