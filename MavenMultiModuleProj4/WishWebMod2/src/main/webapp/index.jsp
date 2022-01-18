<%@page import="com.nit.service.WishMessageService" %>

Wish Message is :: <%= new WishMessageService().getWishMessage("raja") %>