package projet.spring.boot.springpredicate.rest.ressource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projet.spring.boot.springpredicate.service.DepartementService;
import projet.spring.boot.springpredicate.service.dto.DepartementDTO;

@RestController
@RequestMapping("/api/*")
public class DepartementController {
    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }
    @GetMapping("departements")
    public Page<DepartementDTO>getAllDepartements(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "5")int size
    ){
        return departementService.getAllDepartement(page,size);
    }
}
