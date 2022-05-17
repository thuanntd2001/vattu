package quanlyvattu.controller;

import java.sql.SQLException;
import java.util.List;

import quanlyvattu.dao.impl.DataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @Autowired
    private DataDAO dataDAO;

    @RequestMapping(value = { "/congty/list" }, method = RequestMethod.GET)
    public String advertiser(Model model) throws SQLException {

        List<String> list = dataDAO.queryAdvertisers();
        model.addAttribute("advertisers", list);

        return "congty";
    }

    @RequestMapping(value = { "/chinhanh/list" }, method = RequestMethod.GET)
    public String publisher(Model model) throws SQLException {

        List<String> list = dataDAO.queryPublishers();
        model.addAttribute("publishers", list);

        return "chinhanh";
    }

}