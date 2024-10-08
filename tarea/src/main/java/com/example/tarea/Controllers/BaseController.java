package com.example.tarea.Controllers;

import com.example.tarea.Entities.Artistas;
import com.example.tarea.Entities.Eventos;
import com.example.tarea.Repositories.ArtistasRepository;
import com.example.tarea.Repositories.BaseRepository;
import com.example.tarea.Repositories.EventosRepository;
import com.example.tarea.Repositories.Eventos_ArtistasRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab")
public class BaseController {

    final BaseRepository baseRepository;
    final EventosRepository eventosRepository;
    final ArtistasRepository artistasRepository;
    final Eventos_ArtistasRepository eventos_ArtistasRepository;

    public BaseController(BaseRepository baseRepository, EventosRepository eventosRepository, ArtistasRepository artistasRepository, Eventos_ArtistasRepository eventos_ArtistasRepository) {
        this.eventosRepository = eventosRepository;
        this.artistasRepository = artistasRepository;
        this.baseRepository = baseRepository;
        this.eventos_ArtistasRepository = eventos_ArtistasRepository;
    }

    @GetMapping("/eventos")
    public String sub1(Model model) {
        List<Eventos> listaEventos = eventosRepository.findAll();
        model.addAttribute("eventos", listaEventos);
        return "inicio";
    }

    @GetMapping("/artistas")
    public String sub2(Model model) {
        List<Artistas> listaArtistas = artistasRepository.findAll();
        model.addAttribute("artistas", listaArtistas);
        return "artistas";
    }

    @GetMapping("/mostrarAgregarEvento")
    public String mostrarGuardar(@ModelAttribute("evento") Eventos evento, Model model) {
        return "formularioEvento";
    }

    @GetMapping("/editarEvento")
    public String editar(@ModelAttribute("evento") Eventos evento, Model model, @RequestParam("idEvento") Integer id) {
        Optional<Eventos> employeeOptional = eventosRepository.findById(id);
        if (employeeOptional.isPresent()) {
            model.addAttribute("evento", employeeOptional.get());
            return "formularioEvento";
        } else {
            return "redirect:/lab/eventos";
        }
    }

    @PostMapping("/guardarEvento")
    public String saveEvento(@ModelAttribute("evento") @Valid Eventos evento, BindingResult bindingResult, RedirectAttributes attr) {
        if(bindingResult.hasErrors()){
            return "formularioEvento";
        } else {
            attr.addFlashAttribute("msg", "Evento " + (evento.getId() == null ? "creado exitosamente" : "actualizado exitosamente"));
            eventosRepository.save(evento);
            return "redirect:/lab/eventos";
        }
    }

    @GetMapping("/leerEvento")
    public String sub3(@ModelAttribute("evento") Eventos evento,Model model,  @RequestParam("idEvento") Integer id) {
        Optional<Eventos> employeeOptional = eventosRepository.findById(id);
        if (employeeOptional.isPresent()) {
            model.addAttribute("evento", employeeOptional.get());
            model.addAttribute("evento_artistas", eventos_ArtistasRepository.buscarPorEvento(id));
            return "detalleEvento";
        } else {
            return "redirect:/lab/eventos";
        }
    }

    @GetMapping("/mostrarAgregarArtista")
    public String mostrarGuardarArtista(@ModelAttribute("artista") Artistas artista, Model model) {
        return "formularioArtistas";
    }

    @GetMapping("/editarArtista")
    public String editarArtista(@ModelAttribute("artista") Artistas artista, Model model, @RequestParam("idArtista") Integer id) {
        Optional<Artistas> artistasOptional = artistasRepository.findById(id);
        if (artistasOptional.isPresent()) {
            model.addAttribute("artista", artistasOptional.get());
            return "formularioArtistas";
        } else {
            return "redirect:/lab/artistas";
        }
    }

    @PostMapping("/guardarArtista")
    public String saveEvento(@ModelAttribute("artista") @Valid Artistas artista, BindingResult bindingResult, RedirectAttributes attr) {
        if(bindingResult.hasErrors()){
            return "formularioArtistas";
        } else {
            attr.addFlashAttribute("msg", "Artista " + (artista.getId() == null ? "creado exitosamente" : "actualizado exitosamente"));
            artistasRepository.save(artista);
            return "redirect:/lab/artistas";
        }
    }

    @GetMapping("/leerArtista")
    public String sub4(@ModelAttribute("artista") Artistas artista,Model model,  @RequestParam("idArtista") Integer id) {
        Optional<Artistas> employeeOptional = artistasRepository.findById(id);
        if (employeeOptional.isPresent()) {
            model.addAttribute("artista", employeeOptional.get());
            return "detalleArtista";
        } else {
            return "redirect:/lab/artistas";
        }
    }

    /*GetMapping("/sub2")
    public String sub2(@RequestParam("tipo") Long  tipo,
                        @RequestParam("color") Long  color,
                        @RequestParam("ocasion") Long  ocasion, Model model){
        //SUMAR LISTAS
        List<Flores> floresLis1 = floresRepository.findAll();
        List<Flores> floresLis2 = floresRepository.findAll();
        List<Flores> listaSumada = new ArrayList<>(floresLis1);

        model.addAttribute("cosas", listaSumada);
        return "plantilla";
     */

    /*@GetMapping("/editar")
    public String editarBase(Model model,
                                  @RequestParam("idEmployee") Integer id) {
        List<Job> listaJobs = employeesJobRepository.findAll();
        model.addAttribute("listaJobs", listaJobs);
        Optional<Employee> optionalEmployee = employeesRepository.findById(id);

        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "catalogo";
        }else{
            return "redirect:/tarea/listar";
        }
    }*/

    /*@PostMapping("/guardar")
    public String guardar (Employee employee) {
        employeesRepository.save(employee);
        return "redirect:/tarea/listar";
    }*/

    /*@GetMapping("/borrar")
    public String borrarEmpleado(Model model, @RequestParam("idEmployee") int id, RedirectAttributes redirectAttributes) {
        try {
            employeesRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Se borró el empleado");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "No se pudo borrar el empleado");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        return "redirect:/employee/listar";
    }*/

}
