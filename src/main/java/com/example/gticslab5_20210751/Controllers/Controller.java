package com.example.gticslab5_20210751.Controllers;


import com.example.gticslab5_20210751.Entity.Technician;
import com.example.gticslab5_20210751.Repository.DeviceRepository;
import com.example.gticslab5_20210751.Repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    final TechnicianRepository technicianRepository;
    final DeviceRepository deviceRepository;
    public Controller(TechnicianRepository technicianRepository, DeviceRepository deviceRepository) {
        this.technicianRepository = technicianRepository;
        this.deviceRepository = deviceRepository;

    }


    @GetMapping(value = { "/GTICS_F"})
    public String principal() {
        return "GTICS-F";
    }

    @GetMapping(value = { "/listarTecnicos",""})
    public String listarTecnicos(Model model) {

        model.addAttribute("listaTecnicos",technicianRepository.findAll());

        return "Technicians/ListaTecnicos";
    }


    @GetMapping(value = { "/editarTecnico"})
    public String editarTecnicos(@ModelAttribute("technician") Technician technician, Model model, @RequestParam("idTecnico") int idTecnico) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(idTecnico);

        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("technician", technician);
            return "Technicians/newForm";
        } else {
            return "redirect:/listarTecnicos";
        }

    }

    @GetMapping(value = { "/crearTecnico"})
    public String crearTecnicos(@ModelAttribute("technician")Technician technician) {
        return "Technicians/newForm";

    }

    @PostMapping("/guardar")
    public String guardarNuevoTransportista(@ModelAttribute ("technician") @Valid Technician technician, BindingResult bindingResult, Model model, RedirectAttributes attr) {

        if(bindingResult.hasErrors()){

            return "Technicians/newForm";

        }else{
            if (technician.getId()==0) {
                attr.addFlashAttribute("msg", "Técnico "+technician.getFirstName() + " "+technician.getLastName()  +" creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Técnico "+ technician.getFirstName() + " "+technician.getLastName()+" actualizado exitosamente");
            }
            technicianRepository.save(technician);

            return "redirect:/listarTecnicos";
        }

    }

}
