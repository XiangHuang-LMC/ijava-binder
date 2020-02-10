<!-- StoreAddressService.jsp -->
<%@ page import = "chapter41.Address" %>
<%@ page import = "chapter41.AddressWebService" %>
<%@ page import = "chapter41.AddressService" %>
<jsp:useBean id = "addressId" 
             class = "chapter41.Address" scope = "session"></jsp:useBean>
<jsp:setProperty name = "addressId" property = "*" />

<html>
  <body>
    <h3>Storing Address</h3>
    
    <%  
    AddressWebService addressWebService = new AddressWebService();
    AddressService proxy = addressWebService.getAddressServicePort();
    proxy.storeAddress(addressId);
    %>
    
    <%= addressId.getFirstName() %> <%= addressId.getLastName() %> has been 
    added to the database
  </body>
</html>
