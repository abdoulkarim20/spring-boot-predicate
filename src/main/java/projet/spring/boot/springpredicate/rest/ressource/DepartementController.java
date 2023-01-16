package projet.spring.boot.springpredicate.rest.ressource;

import org.springframework.web.bind.annotation.*;
import projet.spring.boot.springpredicate.exceptionHandlers.RessourceNotFoundException;
import projet.spring.boot.springpredicate.service.DepartementService;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;

import java.util.List;

@RestController
@RequestMapping("/api/*")
@CrossOrigin("*")
public class DepartementController {
    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }
    @GetMapping("departements")
    public List<DepartementDTO> getAllDepartements() throws RessourceNotFoundException {
        return departementService.getAllDepartement();
    }
    @PostMapping("departements")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO) throws RessourceNotFoundException {
        return departementService.save(departementDTO);
    }
    @GetMapping("departements/{id}")
    public DepartementDTO getDepartement(@PathVariable Long id) throws RessourceNotFoundException {
        return departementService.getOneDepartement(id);
    }
    @PutMapping("departements/{id}")
    public DepartementDTO update(@PathVariable Long id, @RequestBody DepartementDTO departementDTO) throws RessourceNotFoundException {
        departementDTO.setId(id);
        return departementService.update(departementDTO);
    }
}
