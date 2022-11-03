package com.samr.influxdb.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samr.influxdb.entities.Medicion;
import com.samr.influxdb.service.MedicionService;

@Controller
public class WebController {
    
    @Autowired
	private MedicionService service;

    @GetMapping("/helloUser")
    public String helloUser (@RequestParam(name = "name", required = false, defaultValue = "user") String name, Model model) {
        model.addAttribute("name", name);

        return "welcome";
    }

    @GetMapping("/insert")
    public String insert(Model model){
        
		int idMedidor = service.createAndSave();

        model.addAttribute("id", idMedidor);

        return "inserted";
    }

    @GetMapping("/listar")
    public String listAll(Model model){
        
		List<Medicion> mediciones = service.listAll();

        model.addAttribute("mediciones", mediciones);

        return "listAll";
    }    
    
}
