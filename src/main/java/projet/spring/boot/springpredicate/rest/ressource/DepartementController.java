package projet.spring.boot.springpredicate.rest.ressource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
    public List<DepartementDTO> getAllDepartements(){
        return departementService.getAllDepartement();
    }
    @PostMapping("departements")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO){
        return departementService.save(departementDTO);
    }
}
