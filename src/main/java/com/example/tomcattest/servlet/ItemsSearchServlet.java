package com.example.tomcattest.servlet;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.repository.config.ApplicationContext;
import com.example.tomcattest.servise.ItemServiceImpl;
import com.example.tomcattest.util.URLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Predicate;

@WebServlet(name = "ItemsSearchServlet", value = "/item/search")
public class ItemsSearchServlet extends HttpServlet {

    public static final String PARAM_NAME = "name";
    public static final String PARAM_PRICE_GT = "priceGT";
    public static final String PARAM_PRICE_LT = "priceLT";

    //    private final ItemRepository itemRepository = ItemRepository.getInstance();
    private ItemServiceImpl itemServiceImpl =
            ApplicationContext.context.getBean("itemServiceImpl", ItemServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        Predicate<Item> searchPredicate = item -> true;
        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String key = params.nextElement();
            String value = req.getParameter(key);
            if (value != null && !value.isEmpty()) {
                Predicate<Item> predicate = getPredicateForParam(key, value);
                searchPredicate = searchPredicate.and(predicate);
            }
        }

//        List<Item> rv = itemRepository.findItems(searchPredicate);
        int itemId = (URLUtils.getLastPathSegment(req, resp));
        List<Item> rv = (List<Item>) itemServiceImpl.getById(itemId);

        ObjectMapper objectMapper = new ObjectMapper();
        resp.getWriter().write(objectMapper.writeValueAsString(rv));
    }

    private Predicate<Item> getPredicateForParam(String key, String value) {
        switch (key) {
            case PARAM_NAME:
                return getNamePredicate(value);
            case PARAM_PRICE_GT:
                return getGreaterThanPredicate(Double.parseDouble(value));
            case PARAM_PRICE_LT:
                return getLessThanPredicate(Double.parseDouble(value));
        }

        return item -> true;
    }

    private Predicate<Item> getNamePredicate(String value) {
        return (i) -> i.getName().contains(value);
    }

    private Predicate<Item> getGreaterThanPredicate(double value) {
        return (i) -> i.getBasePrice() >= value;
    }

    private Predicate<Item> getLessThanPredicate(double value) {
        return (i) -> i.getBasePrice() <= value;
    }
}