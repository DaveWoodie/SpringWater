package serverrunner.controllers;

import java.util.ArrayList;

import com.netbuilder.entities.Item;
import com.netbuilder.entityrepository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableMongoRepositories
public class ItemsController {

	private ArrayList<Item> items;
	
	@Autowired
	ItemRepository itemRepository;
	
    @RequestMapping(value="/items", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("itemList", itemRepository.findAll());
        return "items";
    }
}
